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
import com.nothing.espeon.control.ControlCaseOperationActivity;
import com.nothing.espeon.control.ControlItemViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class EspeonControlCaseDialogItemBindingImpl extends EspeonControlCaseDialogItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback116;
    private final View.OnClickListener mCallback117;
    private final View.OnClickListener mCallback118;
    private final View.OnClickListener mCallback119;
    private final View.OnClickListener mCallback120;
    private final View.OnClickListener mCallback121;
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

    public EspeonControlCaseDialogItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private EspeonControlCaseDialogItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
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
        this.mCallback116 = new OnClickListener(this, 1);
        this.mCallback120 = new OnClickListener(this, 5);
        this.mCallback117 = new OnClickListener(this, 2);
        this.mCallback121 = new OnClickListener(this, 6);
        this.mCallback118 = new OnClickListener(this, 3);
        this.mCallback119 = new OnClickListener(this, 4);
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

    @Override // com.nothing.ear.databinding.EspeonControlCaseDialogItemBinding
    public void setItemViewModel(ControlItemViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.EspeonControlCaseDialogItemBinding
    public void setEventHandler(ControlCaseOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.EspeonControlCaseDialogItemBinding
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

    /* JADX WARN: Code duplicated, block: B:109:0x019a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x019c  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:114:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:119:0x01c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:129:0x01e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:135:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:139:0x0209 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x020b  */
    /* JADX WARN: Code duplicated, block: B:141:0x0210  */
    /* JADX WARN: Code duplicated, block: B:144:0x021b  */
    /* JADX WARN: Code duplicated, block: B:145:0x0222  */
    /* JADX WARN: Code duplicated, block: B:149:0x022f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x0231  */
    /* JADX WARN: Code duplicated, block: B:151:0x0236  */
    /* JADX WARN: Code duplicated, block: B:154:0x0241  */
    /* JADX WARN: Code duplicated, block: B:155:0x0248  */
    /* JADX WARN: Code duplicated, block: B:159:0x0252 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x0254  */
    /* JADX WARN: Code duplicated, block: B:161:0x0259  */
    /* JADX WARN: Code duplicated, block: B:164:0x0264  */
    /* JADX WARN: Code duplicated, block: B:165:0x026b  */
    /* JADX WARN: Code duplicated, block: B:169:0x0275 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    /* JADX WARN: Code duplicated, block: B:171:0x027c  */
    /* JADX WARN: Code duplicated, block: B:174:0x0287 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:175:0x0289  */
    /* JADX WARN: Code duplicated, block: B:176:0x0294  */
    /* JADX WARN: Code duplicated, block: B:179:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:180:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:184:0x02b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:185:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:186:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:189:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:192:0x02d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:194:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:195:0x02df  */
    /* JADX WARN: Code duplicated, block: B:197:0x0304  */
    /* JADX WARN: Code duplicated, block: B:25:0x007b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0132  */
    /* JADX WARN: Code duplicated, block: B:87:0x0152  */
    /* JADX WARN: Code duplicated, block: B:96:0x0170  */
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
        String str3;
        String str4;
        Boolean bool6;
        ControlRadius direction;
        Boolean bool7;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        boolean zSafeUnbox;
        float f;
        float f2;
        boolean z;
        boolean z2;
        Boolean bool11;
        boolean zSafeUnbox2;
        boolean z3;
        String str5;
        Boolean bool12;
        float f3;
        boolean z4;
        ObservableField<Boolean> newsPromptVisibility;
        Boolean bool13;
        boolean zSafeUnbox3;
        String str6;
        String str7;
        Boolean bool14;
        Boolean bool15;
        Boolean bool16;
        Boolean bool17;
        Boolean bool18;
        Boolean bool19;
        Boolean bool20;
        Boolean bool21;
        Boolean bool22;
        Boolean bool23;
        Boolean bool24;
        Boolean bool25;
        Boolean bool26;
        long j6;
        String str8;
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
        ObservableField<Boolean> newsPromptVisibility2 = null;
        if ((851967 & j) != 0) {
            if ((j & 786433) == 0) {
                str5 = null;
            } else {
                ObservableField<String> chatGptUnableText = controlOperationViewModel2 != null ? controlOperationViewModel2.getChatGptUnableText() : null;
                updateRegistration(0, chatGptUnableText);
                if (chatGptUnableText != null) {
                    str5 = chatGptUnableText.get();
                } else {
                    str5 = null;
                }
            }
            if ((j & 786434) == 0) {
                bool12 = null;
            } else {
                ObservableField<Boolean> transSelected = controlOperationViewModel2 != null ? controlOperationViewModel2.getTransSelected() : null;
                updateRegistration(1, transSelected);
                if (transSelected != null) {
                    bool12 = transSelected.get();
                } else {
                    bool12 = null;
                }
            }
            long j9 = j & 786436;
            if (j9 != 0) {
                ObservableField<Boolean> voiceAssistantEnable = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantEnable() : null;
                j2 = 794624;
                updateRegistration(2, voiceAssistantEnable);
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(voiceAssistantEnable != null ? voiceAssistantEnable.get() : null);
                z4 = !zSafeUnbox4;
                boolean z5 = zSafeUnbox4;
                if (j9 != 0) {
                    j |= z5 ? 33554432L : 16777216L;
                }
                f3 = z5 ? 1.0f : 0.38f;
            } else {
                j2 = 794624;
                f3 = 0.0f;
                z4 = false;
            }
            long j10 = j & 786440;
            if (j10 != 0) {
                newsPromptVisibility = controlOperationViewModel2 != null ? controlOperationViewModel2.getNewsPromptVisibility() : null;
                j3 = 786560;
                updateRegistration(3, newsPromptVisibility);
                bool13 = newsPromptVisibility != null ? newsPromptVisibility.get() : null;
                j4 = 786496;
                zSafeUnbox3 = ViewDataBinding.safeUnbox(bool13);
                boolean z6 = zSafeUnbox3;
                if (j10 != 0) {
                    j |= z6 ? 2097152L : 1048576L;
                }
                f2 = z6 ? 0.4f : 1.0f;
            } else {
                j3 = 786560;
                j4 = 786496;
                newsPromptVisibility = null;
                bool13 = null;
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
                str6 = null;
            } else {
                ObservableField<String> operationName = controlOperationViewModel2 != null ? controlOperationViewModel2.getOperationName() : null;
                updateRegistration(5, operationName);
                if (operationName != null) {
                    str6 = operationName.get();
                } else {
                    str6 = null;
                }
            }
            if ((j & j4) == 0) {
                str7 = null;
            } else {
                ObservableField<String> newsPromptName = controlOperationViewModel2 != null ? controlOperationViewModel2.getNewsPromptName() : null;
                updateRegistration(6, newsPromptName);
                if (newsPromptName != null) {
                    str7 = newsPromptName.get();
                } else {
                    str7 = null;
                }
            }
            if ((j & j3) != 0) {
                ObservableField<Boolean> selected = controlOperationViewModel2 != null ? controlOperationViewModel2.getSelected() : null;
                controlOperationViewModel = controlOperationViewModel2;
                updateRegistration(7, selected);
                if (selected != null) {
                    bool14 = selected.get();
                }
                if ((j & 786688) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantChatGptSelected = controlOperationViewModel.getVoiceAssistantChatGptSelected();
                    } else {
                        voiceAssistantChatGptSelected = null;
                    }
                    bool15 = bool14;
                    updateRegistration(8, voiceAssistantChatGptSelected);
                    if (voiceAssistantChatGptSelected != null) {
                        bool16 = voiceAssistantChatGptSelected.get();
                    }
                    if ((j & 786944) != 0) {
                        if (controlOperationViewModel != null) {
                            observableFieldIsCallGesture = controlOperationViewModel.isCallGesture();
                        } else {
                            observableFieldIsCallGesture = null;
                        }
                        bool17 = bool16;
                        updateRegistration(9, observableFieldIsCallGesture);
                        if (observableFieldIsCallGesture != null) {
                            bool18 = observableFieldIsCallGesture.get();
                        }
                        if ((j & 787456) != 0) {
                            if (controlOperationViewModel != null) {
                                offSelected = controlOperationViewModel.getOffSelected();
                            } else {
                                offSelected = null;
                            }
                            bool19 = bool18;
                            updateRegistration(10, offSelected);
                            if (offSelected != null) {
                                bool20 = offSelected.get();
                            }
                            if ((j & 788480) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                                } else {
                                    noiseControlVisible = null;
                                }
                                bool21 = bool20;
                                updateRegistration(11, noiseControlVisible);
                                if (noiseControlVisible != null) {
                                    bool22 = noiseControlVisible.get();
                                }
                                if ((j & 790528) != 0) {
                                    if (controlOperationViewModel != null) {
                                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                    } else {
                                        noiseCancellationSelected = null;
                                    }
                                    bool23 = bool22;
                                    updateRegistration(12, noiseCancellationSelected);
                                    if (noiseCancellationSelected != null) {
                                        bool24 = noiseCancellationSelected.get();
                                    }
                                    if ((j & j2) != 0) {
                                        if (controlOperationViewModel != null) {
                                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                        } else {
                                            voiceAssistantDefaultSelected = null;
                                        }
                                        bool25 = bool24;
                                        updateRegistration(13, voiceAssistantDefaultSelected);
                                        if (voiceAssistantDefaultSelected != null) {
                                            bool26 = voiceAssistantDefaultSelected.get();
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
                                                str8 = itemDesc.get();
                                            }
                                            j7 = j6 & 819208;
                                            if (j7 != 0) {
                                                if (controlOperationViewModel != null) {
                                                    enable = controlOperationViewModel.getEnable();
                                                } else {
                                                    enable = null;
                                                }
                                                String str9 = str8;
                                                updateRegistration(15, enable);
                                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                                if (j7 != 0) {
                                                    j8 = j6;
                                                } else if (zSafeUnbox) {
                                                    j8 = j6 | 8388608;
                                                } else {
                                                    j8 = j6 | 4194304;
                                                }
                                                newsPromptVisibility2 = newsPromptVisibility;
                                                bool10 = bool19;
                                                bool9 = bool25;
                                                str4 = str9;
                                                long j11 = j8;
                                                str = str6;
                                                bool = bool15;
                                                bool2 = bool21;
                                                z = z4;
                                                bool8 = bool13;
                                                bool6 = bool23;
                                                str3 = str7;
                                                f = f3;
                                                z2 = zSafeUnbox3;
                                                bool5 = bool26;
                                                bool7 = bool12;
                                                str2 = str5;
                                                bool3 = bool17;
                                                j5 = j11;
                                            } else {
                                                str = str6;
                                                newsPromptVisibility2 = newsPromptVisibility;
                                                bool = bool15;
                                                bool10 = bool19;
                                                bool2 = bool21;
                                                bool9 = bool25;
                                                str4 = str8;
                                                zSafeUnbox = false;
                                                z = z4;
                                                bool8 = bool13;
                                                bool6 = bool23;
                                                str3 = str7;
                                                f = f3;
                                                z2 = zSafeUnbox3;
                                                bool5 = bool26;
                                                bool7 = bool12;
                                                str2 = str5;
                                                bool3 = bool17;
                                                j5 = j6;
                                            }
                                        } else {
                                            bool26 = bool26;
                                            j6 = j;
                                        }
                                        str8 = null;
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str10 = str8;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool10 = bool19;
                                            bool9 = bool25;
                                            str4 = str10;
                                            long j12 = j8;
                                            str = str6;
                                            bool = bool15;
                                            bool2 = bool21;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j12;
                                        } else {
                                            str = str6;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool15;
                                            bool10 = bool19;
                                            bool2 = bool21;
                                            bool9 = bool25;
                                            str4 = str8;
                                            zSafeUnbox = false;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j6;
                                        }
                                    } else {
                                        bool25 = bool24;
                                    }
                                    bool26 = null;
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
                                            str8 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str11 = str8;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool10 = bool19;
                                            bool9 = bool25;
                                            str4 = str11;
                                            long j13 = j8;
                                            str = str6;
                                            bool = bool15;
                                            bool2 = bool21;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j13;
                                        } else {
                                            str = str6;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool15;
                                            bool10 = bool19;
                                            bool2 = bool21;
                                            bool9 = bool25;
                                            str4 = str8;
                                            zSafeUnbox = false;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j6;
                                        }
                                    } else {
                                        bool26 = bool26;
                                        j6 = j;
                                    }
                                    str8 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str12 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str12;
                                        long j14 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j14;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool23 = bool22;
                                }
                                bool24 = null;
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool25 = bool24;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool26 = voiceAssistantDefaultSelected.get();
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
                                            str8 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str13 = str8;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool10 = bool19;
                                            bool9 = bool25;
                                            str4 = str13;
                                            long j15 = j8;
                                            str = str6;
                                            bool = bool15;
                                            bool2 = bool21;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j15;
                                        } else {
                                            str = str6;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool15;
                                            bool10 = bool19;
                                            bool2 = bool21;
                                            bool9 = bool25;
                                            str4 = str8;
                                            zSafeUnbox = false;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j6;
                                        }
                                    } else {
                                        bool26 = bool26;
                                        j6 = j;
                                    }
                                    str8 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str14 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str14;
                                        long j16 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j16;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool25 = bool24;
                                }
                                bool26 = null;
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str15 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str15;
                                        long j17 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j17;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str16 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str16;
                                    long j18 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j18;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool21 = bool20;
                            }
                            bool22 = null;
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool23 = bool22;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool24 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool25 = bool24;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool26 = voiceAssistantDefaultSelected.get();
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
                                            str8 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str17 = str8;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool10 = bool19;
                                            bool9 = bool25;
                                            str4 = str17;
                                            long j19 = j8;
                                            str = str6;
                                            bool = bool15;
                                            bool2 = bool21;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j19;
                                        } else {
                                            str = str6;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool15;
                                            bool10 = bool19;
                                            bool2 = bool21;
                                            bool9 = bool25;
                                            str4 = str8;
                                            zSafeUnbox = false;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j6;
                                        }
                                    } else {
                                        bool26 = bool26;
                                        j6 = j;
                                    }
                                    str8 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str18 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str18;
                                        long j110 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j110;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool25 = bool24;
                                }
                                bool26 = null;
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str19 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str19;
                                        long j111 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str110 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str110;
                                    long j112 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j112;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool23 = bool22;
                            }
                            bool24 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str111;
                                        long j113 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j113;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str112 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str112;
                                    long j114 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j114;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str113;
                                    long j115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str114;
                                long j116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool19 = bool18;
                        }
                        bool20 = null;
                        if ((j & 788480) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool21 = bool20;
                            updateRegistration(11, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool22 = noiseControlVisible.get();
                            }
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool23 = bool22;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool24 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool25 = bool24;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool26 = voiceAssistantDefaultSelected.get();
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
                                            str8 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str115 = str8;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool10 = bool19;
                                            bool9 = bool25;
                                            str4 = str115;
                                            long j117 = j8;
                                            str = str6;
                                            bool = bool15;
                                            bool2 = bool21;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j117;
                                        } else {
                                            str = str6;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool15;
                                            bool10 = bool19;
                                            bool2 = bool21;
                                            bool9 = bool25;
                                            str4 = str8;
                                            zSafeUnbox = false;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j6;
                                        }
                                    } else {
                                        bool26 = bool26;
                                        j6 = j;
                                    }
                                    str8 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str116 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str116;
                                        long j118 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j118;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool25 = bool24;
                                }
                                bool26 = null;
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str117 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str117;
                                        long j119 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j119;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str118 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str118;
                                    long j1110 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1110;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool23 = bool22;
                            }
                            bool24 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str119 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str119;
                                        long j1111 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j1111;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1110 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1110;
                                    long j1112 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1112;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111;
                                    long j1113 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1113;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1112 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1112;
                                long j1114 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1114;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool21 = bool20;
                        }
                        bool22 = null;
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str1113 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str1113;
                                        long j1115 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j1115;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1114 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1114;
                                    long j1116 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1116;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1115 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1115;
                                    long j1117 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1117;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1116 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1116;
                                long j1118 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1118;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1117 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1117;
                                    long j1119 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1119;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1118 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1118;
                                long j11110 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11110;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1119;
                                long j11111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11110;
                            long j11112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool17 = bool16;
                    }
                    bool18 = null;
                    if ((j & 787456) != 0) {
                        if (controlOperationViewModel != null) {
                            offSelected = controlOperationViewModel.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        bool19 = bool18;
                        updateRegistration(10, offSelected);
                        if (offSelected != null) {
                            bool20 = offSelected.get();
                        }
                        if ((j & 788480) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool21 = bool20;
                            updateRegistration(11, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool22 = noiseControlVisible.get();
                            }
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool23 = bool22;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool24 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool25 = bool24;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool26 = voiceAssistantDefaultSelected.get();
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
                                            str8 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str11111 = str8;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool10 = bool19;
                                            bool9 = bool25;
                                            str4 = str11111;
                                            long j11113 = j8;
                                            str = str6;
                                            bool = bool15;
                                            bool2 = bool21;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j11113;
                                        } else {
                                            str = str6;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool15;
                                            bool10 = bool19;
                                            bool2 = bool21;
                                            bool9 = bool25;
                                            str4 = str8;
                                            zSafeUnbox = false;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j6;
                                        }
                                    } else {
                                        bool26 = bool26;
                                        j6 = j;
                                    }
                                    str8 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11112 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11112;
                                        long j11114 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j11114;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool25 = bool24;
                                }
                                bool26 = null;
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11113 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11113;
                                        long j11115 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j11115;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11114 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11114;
                                    long j11116 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j11116;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool23 = bool22;
                            }
                            bool24 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11115 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11115;
                                        long j11117 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j11117;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11116 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11116;
                                    long j11118 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j11118;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11117 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11117;
                                    long j11119 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j11119;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11118 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11118;
                                long j111110 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111110;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool21 = bool20;
                        }
                        bool22 = null;
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11119 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11119;
                                        long j111111 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111111;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111110 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111110;
                                    long j111112 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111112;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111;
                                    long j111113 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111113;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111112 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111112;
                                long j111114 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111114;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111113;
                                    long j111115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111114;
                                long j111116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111115 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111115;
                                long j111117 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111117;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111116 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111116;
                            long j111118 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j111118;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool19 = bool18;
                    }
                    bool20 = null;
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool21 = bool20;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool22 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111117 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str111117;
                                        long j111119 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111119;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111118 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111118;
                                    long j1111110 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111110;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111119 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111119;
                                    long j1111111 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111110 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111110;
                                long j1111112 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111112;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111;
                                    long j1111113 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111113;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111112 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111112;
                                long j1111114 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111114;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111113 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111113;
                                long j1111115 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111115;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111114 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111114;
                            long j1111116 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111116;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool21 = bool20;
                    }
                    bool22 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111115 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111115;
                                    long j1111117 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111117;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111116 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111116;
                                long j1111118 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111118;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111117 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111117;
                                long j1111119 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111119;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111118 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111118;
                            long j11111110 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111110;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111119;
                                long j11111111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111110;
                            long j11111112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111;
                            long j11111113 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111113;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111112 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111112;
                        long j11111114 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111114;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool15 = bool14;
                }
                bool16 = null;
                if ((j & 786944) != 0) {
                    if (controlOperationViewModel != null) {
                        observableFieldIsCallGesture = controlOperationViewModel.isCallGesture();
                    } else {
                        observableFieldIsCallGesture = null;
                    }
                    bool17 = bool16;
                    updateRegistration(9, observableFieldIsCallGesture);
                    if (observableFieldIsCallGesture != null) {
                        bool18 = observableFieldIsCallGesture.get();
                    }
                    if ((j & 787456) != 0) {
                        if (controlOperationViewModel != null) {
                            offSelected = controlOperationViewModel.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        bool19 = bool18;
                        updateRegistration(10, offSelected);
                        if (offSelected != null) {
                            bool20 = offSelected.get();
                        }
                        if ((j & 788480) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool21 = bool20;
                            updateRegistration(11, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool22 = noiseControlVisible.get();
                            }
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool23 = bool22;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool24 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool25 = bool24;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool26 = voiceAssistantDefaultSelected.get();
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
                                            str8 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str11111113 = str8;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool10 = bool19;
                                            bool9 = bool25;
                                            str4 = str11111113;
                                            long j11111115 = j8;
                                            str = str6;
                                            bool = bool15;
                                            bool2 = bool21;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j11111115;
                                        } else {
                                            str = str6;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool15;
                                            bool10 = bool19;
                                            bool2 = bool21;
                                            bool9 = bool25;
                                            str4 = str8;
                                            zSafeUnbox = false;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j6;
                                        }
                                    } else {
                                        bool26 = bool26;
                                        j6 = j;
                                    }
                                    str8 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111114 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11111114;
                                        long j11111116 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j11111116;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool25 = bool24;
                                }
                                bool26 = null;
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111115 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11111115;
                                        long j11111117 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j11111117;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111116 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11111116;
                                    long j11111118 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j11111118;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool23 = bool22;
                            }
                            bool24 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111117 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11111117;
                                        long j11111119 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j11111119;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111118 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11111118;
                                    long j111111110 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111110;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111119 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11111119;
                                    long j111111111 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111110 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111110;
                                long j111111112 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111112;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool21 = bool20;
                        }
                        bool22 = null;
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111111111 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str111111111;
                                        long j111111113 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111111113;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111112 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111112;
                                    long j111111114 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111114;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111113;
                                    long j111111115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111114;
                                long j111111116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111115 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111115;
                                    long j111111117 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111117;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111116 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111116;
                                long j111111118 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111118;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111117 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111117;
                                long j111111119 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111119;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111118 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111118;
                            long j1111111110 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111110;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool19 = bool18;
                    }
                    bool20 = null;
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool21 = bool20;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool22 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111111119 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str111111119;
                                        long j1111111111 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j1111111111;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111110 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111110;
                                    long j1111111112 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111112;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111111;
                                    long j1111111113 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111113;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111112 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111112;
                                long j1111111114 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111114;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111113;
                                    long j1111111115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111114;
                                long j1111111116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111115 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111115;
                                long j1111111117 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111117;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111116 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111116;
                            long j1111111118 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111118;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool21 = bool20;
                    }
                    bool22 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111117 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111117;
                                    long j1111111119 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111119;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111118 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111118;
                                long j11111111110 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111110;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111119;
                                long j11111111111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111110;
                            long j11111111112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11111111111;
                                long j11111111113 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111113;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111112 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111112;
                            long j11111111114 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111114;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111113 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111113;
                            long j11111111115 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111115;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111114 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111114;
                        long j11111111116 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111116;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool17 = bool16;
                }
                bool18 = null;
                if ((j & 787456) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool19 = bool18;
                    updateRegistration(10, offSelected);
                    if (offSelected != null) {
                        bool20 = offSelected.get();
                    }
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool21 = bool20;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool22 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111115 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11111111115;
                                        long j11111111117 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j11111111117;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111116 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11111111116;
                                    long j11111111118 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j11111111118;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111117 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11111111117;
                                    long j11111111119 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j11111111119;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111118 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11111111118;
                                long j111111111110 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111110;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111119 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11111111119;
                                    long j111111111111 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111110 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111110;
                                long j111111111112 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111112;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111;
                                long j111111111113 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111113;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111112 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111112;
                            long j111111111114 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j111111111114;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool21 = bool20;
                    }
                    bool22 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111113;
                                    long j111111111115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111114;
                                long j111111111116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111115 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111115;
                                long j111111111117 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111117;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111116 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111116;
                            long j111111111118 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j111111111118;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111117 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111117;
                                long j111111111119 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111119;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111118 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111118;
                            long j1111111111110 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111110;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111119 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111119;
                            long j1111111111111 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111110 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str1111111111110;
                        long j1111111111112 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j1111111111112;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool19 = bool18;
                }
                bool20 = null;
                if ((j & 788480) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool21 = bool20;
                    updateRegistration(11, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool22 = noiseControlVisible.get();
                    }
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111111111;
                                    long j1111111111113 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111111113;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111112 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111112;
                                long j1111111111114 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111114;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111113 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111113;
                                long j1111111111115 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111115;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111114 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111114;
                            long j1111111111116 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111116;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111115 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111115;
                                long j1111111111117 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111117;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111116 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111116;
                            long j1111111111118 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111118;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111117 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111117;
                            long j1111111111119 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111119;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111118 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str1111111111118;
                        long j11111111111110 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111110;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool21 = bool20;
                }
                bool22 = null;
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool23 = bool22;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool24 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111119;
                                long j11111111111111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111110;
                            long j11111111111112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111;
                            long j11111111111113 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111113;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111112 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111112;
                        long j11111111111114 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111114;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool23 = bool22;
                }
                bool24 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool25 = bool24;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool26 = voiceAssistantDefaultSelected.get();
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111113 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111113;
                            long j11111111111115 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111115;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111114 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111114;
                        long j11111111111116 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111116;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool25 = bool24;
                }
                bool26 = null;
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
                        str8 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111115 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111115;
                        long j11111111111117 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111117;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool26 = bool26;
                    j6 = j;
                }
                str8 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str11111111111116 = str8;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool10 = bool19;
                    bool9 = bool25;
                    str4 = str11111111111116;
                    long j11111111111118 = j8;
                    str = str6;
                    bool = bool15;
                    bool2 = bool21;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j11111111111118;
                } else {
                    str = str6;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool15;
                    bool10 = bool19;
                    bool2 = bool21;
                    bool9 = bool25;
                    str4 = str8;
                    zSafeUnbox = false;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j6;
                }
            } else {
                controlOperationViewModel = controlOperationViewModel2;
            }
            bool14 = null;
            if ((j & 786688) != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantChatGptSelected = controlOperationViewModel.getVoiceAssistantChatGptSelected();
                } else {
                    voiceAssistantChatGptSelected = null;
                }
                bool15 = bool14;
                updateRegistration(8, voiceAssistantChatGptSelected);
                if (voiceAssistantChatGptSelected != null) {
                    bool16 = voiceAssistantChatGptSelected.get();
                }
                if ((j & 786944) != 0) {
                    if (controlOperationViewModel != null) {
                        observableFieldIsCallGesture = controlOperationViewModel.isCallGesture();
                    } else {
                        observableFieldIsCallGesture = null;
                    }
                    bool17 = bool16;
                    updateRegistration(9, observableFieldIsCallGesture);
                    if (observableFieldIsCallGesture != null) {
                        bool18 = observableFieldIsCallGesture.get();
                    }
                    if ((j & 787456) != 0) {
                        if (controlOperationViewModel != null) {
                            offSelected = controlOperationViewModel.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        bool19 = bool18;
                        updateRegistration(10, offSelected);
                        if (offSelected != null) {
                            bool20 = offSelected.get();
                        }
                        if ((j & 788480) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool21 = bool20;
                            updateRegistration(11, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool22 = noiseControlVisible.get();
                            }
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool23 = bool22;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool24 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool25 = bool24;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool26 = voiceAssistantDefaultSelected.get();
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
                                            str8 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str11111111111117 = str8;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool10 = bool19;
                                            bool9 = bool25;
                                            str4 = str11111111111117;
                                            long j11111111111119 = j8;
                                            str = str6;
                                            bool = bool15;
                                            bool2 = bool21;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j11111111111119;
                                        } else {
                                            str = str6;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool15;
                                            bool10 = bool19;
                                            bool2 = bool21;
                                            bool9 = bool25;
                                            str4 = str8;
                                            zSafeUnbox = false;
                                            z = z4;
                                            bool8 = bool13;
                                            bool6 = bool23;
                                            str3 = str7;
                                            f = f3;
                                            z2 = zSafeUnbox3;
                                            bool5 = bool26;
                                            bool7 = bool12;
                                            str2 = str5;
                                            bool3 = bool17;
                                            j5 = j6;
                                        }
                                    } else {
                                        bool26 = bool26;
                                        j6 = j;
                                    }
                                    str8 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111118 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11111111111118;
                                        long j111111111111110 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111111111111110;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool25 = bool24;
                                }
                                bool26 = null;
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111119 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11111111111119;
                                        long j111111111111111 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111111111111111;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111110 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111110;
                                    long j111111111111112 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111112;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool23 = bool22;
                            }
                            bool24 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111111111111111 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str111111111111111;
                                        long j111111111111113 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111111111111113;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111112 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111112;
                                    long j111111111111114 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111114;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111113;
                                    long j111111111111115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111114;
                                long j111111111111116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool21 = bool20;
                        }
                        bool22 = null;
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111111111111115 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str111111111111115;
                                        long j111111111111117 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111111111111117;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111116 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111116;
                                    long j111111111111118 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111118;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111117 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111117;
                                    long j111111111111119 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111119;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111118 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111118;
                                long j1111111111111110 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111110;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111119 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111119;
                                    long j1111111111111111 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111111111111;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111110 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111110;
                                long j1111111111111112 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111112;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111;
                                long j1111111111111113 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111113;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111112 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111112;
                            long j1111111111111114 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111114;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool19 = bool18;
                    }
                    bool20 = null;
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool21 = bool20;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool22 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str1111111111111113 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str1111111111111113;
                                        long j1111111111111115 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j1111111111111115;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111114 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111111111114;
                                    long j1111111111111116 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111111111116;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111115 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111111111115;
                                    long j1111111111111117 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111111111117;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111116 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111116;
                                long j1111111111111118 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111118;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111117 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111111111117;
                                    long j1111111111111119 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111111111119;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111118 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111118;
                                long j11111111111111110 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111110;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111119;
                                long j11111111111111111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111110;
                            long j11111111111111112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool21 = bool20;
                    }
                    bool22 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111111111111 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str11111111111111111;
                                    long j11111111111111113 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j11111111111111113;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111112 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11111111111111112;
                                long j11111111111111114 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111114;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111113 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11111111111111113;
                                long j11111111111111115 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111115;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111114 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111114;
                            long j11111111111111116 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111116;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111115 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11111111111111115;
                                long j11111111111111117 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111117;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111116 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111116;
                            long j11111111111111118 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111118;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111117 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111117;
                            long j11111111111111119 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111119;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111118 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111118;
                        long j111111111111111110 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111110;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool17 = bool16;
                }
                bool18 = null;
                if ((j & 787456) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool19 = bool18;
                    updateRegistration(10, offSelected);
                    if (offSelected != null) {
                        bool20 = offSelected.get();
                    }
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool21 = bool20;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool22 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111111119 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str11111111111111119;
                                        long j111111111111111111 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111111111111111111;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111110 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111110;
                                    long j111111111111111112 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111111112;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111111;
                                    long j111111111111111113 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111111113;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111112 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111112;
                                long j111111111111111114 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111114;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111113;
                                    long j111111111111111115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111111115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111114;
                                long j111111111111111116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111115 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111115;
                                long j111111111111111117 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111117;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111116 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111111111116;
                            long j111111111111111118 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j111111111111111118;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool21 = bool20;
                    }
                    bool22 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111117 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111117;
                                    long j111111111111111119 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111111119;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111118 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111118;
                                long j1111111111111111110 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111110;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111119;
                                long j1111111111111111111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111110;
                            long j1111111111111111112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111111;
                                long j1111111111111111113 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111113;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111112 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111112;
                            long j1111111111111111114 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111114;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111113 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111113;
                            long j1111111111111111115 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111115;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111114 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str1111111111111111114;
                        long j1111111111111111116 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j1111111111111111116;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool19 = bool18;
                }
                bool20 = null;
                if ((j & 788480) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool21 = bool20;
                    updateRegistration(11, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool22 = noiseControlVisible.get();
                    }
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111111115 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111111111111115;
                                    long j1111111111111111117 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111111111111117;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111116 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111116;
                                long j1111111111111111118 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111118;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111117 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111117;
                                long j1111111111111111119 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111119;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111118 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111118;
                            long j11111111111111111110 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111110;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111119;
                                long j11111111111111111111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111111111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111110;
                            long j11111111111111111112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111;
                            long j11111111111111111113 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111113;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111112 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111112;
                        long j11111111111111111114 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111111111114;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool21 = bool20;
                }
                bool22 = null;
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool23 = bool22;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool24 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111111113 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11111111111111111113;
                                long j11111111111111111115 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111111115;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111114 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111114;
                            long j11111111111111111116 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111116;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111115 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111115;
                            long j11111111111111111117 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111117;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111116 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111116;
                        long j11111111111111111118 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111111111118;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool23 = bool22;
                }
                bool24 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool25 = bool24;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool26 = voiceAssistantDefaultSelected.get();
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111117 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111117;
                            long j11111111111111111119 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111119;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111118 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111118;
                        long j111111111111111111110 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111111110;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool25 = bool24;
                }
                bool26 = null;
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
                        str8 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111119 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111119;
                        long j111111111111111111111 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111111111;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool26 = bool26;
                    j6 = j;
                }
                str8 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111110 = str8;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool10 = bool19;
                    bool9 = bool25;
                    str4 = str111111111111111111110;
                    long j111111111111111111112 = j8;
                    str = str6;
                    bool = bool15;
                    bool2 = bool21;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j111111111111111111112;
                } else {
                    str = str6;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool15;
                    bool10 = bool19;
                    bool2 = bool21;
                    bool9 = bool25;
                    str4 = str8;
                    zSafeUnbox = false;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j6;
                }
            } else {
                bool15 = bool14;
            }
            bool16 = null;
            if ((j & 786944) != 0) {
                if (controlOperationViewModel != null) {
                    observableFieldIsCallGesture = controlOperationViewModel.isCallGesture();
                } else {
                    observableFieldIsCallGesture = null;
                }
                bool17 = bool16;
                updateRegistration(9, observableFieldIsCallGesture);
                if (observableFieldIsCallGesture != null) {
                    bool18 = observableFieldIsCallGesture.get();
                }
                if ((j & 787456) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool19 = bool18;
                    updateRegistration(10, offSelected);
                    if (offSelected != null) {
                        bool20 = offSelected.get();
                    }
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool21 = bool20;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool22 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool23 = bool22;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool24 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool25 = bool24;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool26 = voiceAssistantDefaultSelected.get();
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
                                        str8 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111111111111111111111 = str8;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool10 = bool19;
                                        bool9 = bool25;
                                        str4 = str111111111111111111111;
                                        long j111111111111111111113 = j8;
                                        str = str6;
                                        bool = bool15;
                                        bool2 = bool21;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j111111111111111111113;
                                    } else {
                                        str = str6;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool15;
                                        bool10 = bool19;
                                        bool2 = bool21;
                                        bool9 = bool25;
                                        str4 = str8;
                                        zSafeUnbox = false;
                                        z = z4;
                                        bool8 = bool13;
                                        bool6 = bool23;
                                        str3 = str7;
                                        f = f3;
                                        z2 = zSafeUnbox3;
                                        bool5 = bool26;
                                        bool7 = bool12;
                                        str2 = str5;
                                        bool3 = bool17;
                                        j5 = j6;
                                    }
                                } else {
                                    bool26 = bool26;
                                    j6 = j;
                                }
                                str8 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111112 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111111112;
                                    long j111111111111111111114 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111111111114;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool25 = bool24;
                            }
                            bool26 = null;
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111111113;
                                    long j111111111111111111115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111111111115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111111114;
                                long j111111111111111111116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111111116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool23 = bool22;
                        }
                        bool24 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111115 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111111115;
                                    long j111111111111111111117 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111111111117;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111116 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111111116;
                                long j111111111111111111118 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111111118;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111117 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111111117;
                                long j111111111111111111119 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111111119;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111118 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111111111111118;
                            long j1111111111111111111110 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111110;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool21 = bool20;
                    }
                    bool22 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111119 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111111119;
                                    long j1111111111111111111111 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111111111111111111;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111110 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111111110;
                                long j1111111111111111111112 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111111112;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111111 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111111111;
                                long j1111111111111111111113 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111111113;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111112 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111111112;
                            long j1111111111111111111114 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111114;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111113 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111111113;
                                long j1111111111111111111115 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111111115;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111114 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111111114;
                            long j1111111111111111111116 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111116;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111115 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111111115;
                            long j1111111111111111111117 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111117;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111116 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str1111111111111111111116;
                        long j1111111111111111111118 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j1111111111111111111118;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool19 = bool18;
                }
                bool20 = null;
                if ((j & 788480) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool21 = bool20;
                    updateRegistration(11, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool22 = noiseControlVisible.get();
                    }
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111111111117 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str1111111111111111111117;
                                    long j1111111111111111111119 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j1111111111111111111119;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111118 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111111118;
                                long j11111111111111111111110 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111111111110;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111111119;
                                long j11111111111111111111111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111111111111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111110;
                            long j11111111111111111111112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111111111111 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11111111111111111111111;
                                long j11111111111111111111113 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111111111113;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111112 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111112;
                            long j11111111111111111111114 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111114;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111113 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111113;
                            long j11111111111111111111115 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111115;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111114 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111111114;
                        long j11111111111111111111116 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111111111111116;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool21 = bool20;
                }
                bool22 = null;
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool23 = bool22;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool24 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111111111115 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str11111111111111111111115;
                                long j11111111111111111111117 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111111111117;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111116 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111116;
                            long j11111111111111111111118 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111118;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111117 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111117;
                            long j11111111111111111111119 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111119;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111118 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111111118;
                        long j111111111111111111111110 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111111111110;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool23 = bool22;
                }
                bool24 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool25 = bool24;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool26 = voiceAssistantDefaultSelected.get();
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111119 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111119;
                            long j111111111111111111111111 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j111111111111111111111111;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str111111111111111111111110 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str111111111111111111111110;
                        long j111111111111111111111112 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111111111112;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool25 = bool24;
                }
                bool26 = null;
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
                        str8 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str111111111111111111111111 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str111111111111111111111111;
                        long j111111111111111111111113 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111111111113;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool26 = bool26;
                    j6 = j;
                }
                str8 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111112 = str8;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool10 = bool19;
                    bool9 = bool25;
                    str4 = str111111111111111111111112;
                    long j111111111111111111111114 = j8;
                    str = str6;
                    bool = bool15;
                    bool2 = bool21;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j111111111111111111111114;
                } else {
                    str = str6;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool15;
                    bool10 = bool19;
                    bool2 = bool21;
                    bool9 = bool25;
                    str4 = str8;
                    zSafeUnbox = false;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j6;
                }
            } else {
                bool17 = bool16;
            }
            bool18 = null;
            if ((j & 787456) != 0) {
                if (controlOperationViewModel != null) {
                    offSelected = controlOperationViewModel.getOffSelected();
                } else {
                    offSelected = null;
                }
                bool19 = bool18;
                updateRegistration(10, offSelected);
                if (offSelected != null) {
                    bool20 = offSelected.get();
                }
                if ((j & 788480) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool21 = bool20;
                    updateRegistration(11, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool22 = noiseControlVisible.get();
                    }
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool23 = bool22;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool24 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool25 = bool24;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool26 = voiceAssistantDefaultSelected.get();
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
                                    str8 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111111113 = str8;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool10 = bool19;
                                    bool9 = bool25;
                                    str4 = str111111111111111111111113;
                                    long j111111111111111111111115 = j8;
                                    str = str6;
                                    bool = bool15;
                                    bool2 = bool21;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j111111111111111111111115;
                                } else {
                                    str = str6;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool15;
                                    bool10 = bool19;
                                    bool2 = bool21;
                                    bool9 = bool25;
                                    str4 = str8;
                                    zSafeUnbox = false;
                                    z = z4;
                                    bool8 = bool13;
                                    bool6 = bool23;
                                    str3 = str7;
                                    f = f3;
                                    z2 = zSafeUnbox3;
                                    bool5 = bool26;
                                    bool7 = bool12;
                                    str2 = str5;
                                    bool3 = bool17;
                                    j5 = j6;
                                }
                            } else {
                                bool26 = bool26;
                                j6 = j;
                            }
                            str8 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111111114 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111111111114;
                                long j111111111111111111111116 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111111111116;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool25 = bool24;
                        }
                        bool26 = null;
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111111115 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111111111115;
                                long j111111111111111111111117 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111111111117;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111111116 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111111111111111116;
                            long j111111111111111111111118 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j111111111111111111111118;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool23 = bool22;
                    }
                    bool24 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111111117 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str111111111111111111111117;
                                long j111111111111111111111119 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j111111111111111111111119;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111111118 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111111111111111118;
                            long j1111111111111111111111110 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111111110;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111111119 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str111111111111111111111119;
                            long j1111111111111111111111111 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111111111;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111110 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str1111111111111111111111110;
                        long j1111111111111111111111112 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j1111111111111111111111112;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool21 = bool20;
                }
                bool22 = null;
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool23 = bool22;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool24 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111111111 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111111111111;
                                long j1111111111111111111111113 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j1111111111111111111111113;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111112 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111111111112;
                            long j1111111111111111111111114 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111111114;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111113 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111111111113;
                            long j1111111111111111111111115 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111111115;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111114 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str1111111111111111111111114;
                        long j1111111111111111111111116 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j1111111111111111111111116;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool23 = bool22;
                }
                bool24 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool25 = bool24;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool26 = voiceAssistantDefaultSelected.get();
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111115 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str1111111111111111111111115;
                            long j1111111111111111111111117 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j1111111111111111111111117;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111116 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str1111111111111111111111116;
                        long j1111111111111111111111118 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j1111111111111111111111118;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool25 = bool24;
                }
                bool26 = null;
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
                        str8 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111117 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str1111111111111111111111117;
                        long j1111111111111111111111119 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j1111111111111111111111119;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool26 = bool26;
                    j6 = j;
                }
                str8 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str1111111111111111111111118 = str8;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool10 = bool19;
                    bool9 = bool25;
                    str4 = str1111111111111111111111118;
                    long j11111111111111111111111110 = j8;
                    str = str6;
                    bool = bool15;
                    bool2 = bool21;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j11111111111111111111111110;
                } else {
                    str = str6;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool15;
                    bool10 = bool19;
                    bool2 = bool21;
                    bool9 = bool25;
                    str4 = str8;
                    zSafeUnbox = false;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j6;
                }
            } else {
                bool19 = bool18;
            }
            bool20 = null;
            if ((j & 788480) != 0) {
                if (controlOperationViewModel != null) {
                    noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                } else {
                    noiseControlVisible = null;
                }
                bool21 = bool20;
                updateRegistration(11, noiseControlVisible);
                if (noiseControlVisible != null) {
                    bool22 = noiseControlVisible.get();
                }
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool23 = bool22;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool24 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool25 = bool24;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool26 = voiceAssistantDefaultSelected.get();
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
                                str8 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111111119 = str8;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool10 = bool19;
                                bool9 = bool25;
                                str4 = str1111111111111111111111119;
                                long j11111111111111111111111111 = j8;
                                str = str6;
                                bool = bool15;
                                bool2 = bool21;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j11111111111111111111111111;
                            } else {
                                str = str6;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool15;
                                bool10 = bool19;
                                bool2 = bool21;
                                bool9 = bool25;
                                str4 = str8;
                                zSafeUnbox = false;
                                z = z4;
                                bool8 = bool13;
                                bool6 = bool23;
                                str3 = str7;
                                f = f3;
                                z2 = zSafeUnbox3;
                                bool5 = bool26;
                                bool7 = bool12;
                                str2 = str5;
                                bool3 = bool17;
                                j5 = j6;
                            }
                        } else {
                            bool26 = bool26;
                            j6 = j;
                        }
                        str8 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111111110 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111111110;
                            long j11111111111111111111111112 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111111112;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool25 = bool24;
                    }
                    bool26 = null;
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111111111 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111111111;
                            long j11111111111111111111111113 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111111113;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111112 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111111111112;
                        long j11111111111111111111111114 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111111111111111114;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool23 = bool22;
                }
                bool24 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool25 = bool24;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool26 = voiceAssistantDefaultSelected.get();
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111111113 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111111113;
                            long j11111111111111111111111115 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111111115;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111114 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111111111114;
                        long j11111111111111111111111116 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111111111111111116;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool25 = bool24;
                }
                bool26 = null;
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
                        str8 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111115 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111111111115;
                        long j11111111111111111111111117 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j11111111111111111111111117;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool26 = bool26;
                    j6 = j;
                }
                str8 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str11111111111111111111111116 = str8;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool10 = bool19;
                    bool9 = bool25;
                    str4 = str11111111111111111111111116;
                    long j11111111111111111111111118 = j8;
                    str = str6;
                    bool = bool15;
                    bool2 = bool21;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j11111111111111111111111118;
                } else {
                    str = str6;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool15;
                    bool10 = bool19;
                    bool2 = bool21;
                    bool9 = bool25;
                    str4 = str8;
                    zSafeUnbox = false;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j6;
                }
            } else {
                bool21 = bool20;
            }
            bool22 = null;
            if ((j & 790528) != 0) {
                if (controlOperationViewModel != null) {
                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                } else {
                    noiseCancellationSelected = null;
                }
                bool23 = bool22;
                updateRegistration(12, noiseCancellationSelected);
                if (noiseCancellationSelected != null) {
                    bool24 = noiseCancellationSelected.get();
                }
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool25 = bool24;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool26 = voiceAssistantDefaultSelected.get();
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
                            str8 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111111117 = str8;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool10 = bool19;
                            bool9 = bool25;
                            str4 = str11111111111111111111111117;
                            long j11111111111111111111111119 = j8;
                            str = str6;
                            bool = bool15;
                            bool2 = bool21;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j11111111111111111111111119;
                        } else {
                            str = str6;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool15;
                            bool10 = bool19;
                            bool2 = bool21;
                            bool9 = bool25;
                            str4 = str8;
                            zSafeUnbox = false;
                            z = z4;
                            bool8 = bool13;
                            bool6 = bool23;
                            str3 = str7;
                            f = f3;
                            z2 = zSafeUnbox3;
                            bool5 = bool26;
                            bool7 = bool12;
                            str2 = str5;
                            bool3 = bool17;
                            j5 = j6;
                        }
                    } else {
                        bool26 = bool26;
                        j6 = j;
                    }
                    str8 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111118 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111111111118;
                        long j111111111111111111111111110 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111111111111110;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool25 = bool24;
                }
                bool26 = null;
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
                        str8 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111119 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str11111111111111111111111119;
                        long j111111111111111111111111111 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111111111111111;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool26 = bool26;
                    j6 = j;
                }
                str8 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111111110 = str8;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool10 = bool19;
                    bool9 = bool25;
                    str4 = str111111111111111111111111110;
                    long j111111111111111111111111112 = j8;
                    str = str6;
                    bool = bool15;
                    bool2 = bool21;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j111111111111111111111111112;
                } else {
                    str = str6;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool15;
                    bool10 = bool19;
                    bool2 = bool21;
                    bool9 = bool25;
                    str4 = str8;
                    zSafeUnbox = false;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j6;
                }
            } else {
                bool23 = bool22;
            }
            bool24 = null;
            if ((j & j2) != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                } else {
                    voiceAssistantDefaultSelected = null;
                }
                bool25 = bool24;
                updateRegistration(13, voiceAssistantDefaultSelected);
                if (voiceAssistantDefaultSelected != null) {
                    bool26 = voiceAssistantDefaultSelected.get();
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
                        str8 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str111111111111111111111111111 = str8;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool10 = bool19;
                        bool9 = bool25;
                        str4 = str111111111111111111111111111;
                        long j111111111111111111111111113 = j8;
                        str = str6;
                        bool = bool15;
                        bool2 = bool21;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j111111111111111111111111113;
                    } else {
                        str = str6;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool15;
                        bool10 = bool19;
                        bool2 = bool21;
                        bool9 = bool25;
                        str4 = str8;
                        zSafeUnbox = false;
                        z = z4;
                        bool8 = bool13;
                        bool6 = bool23;
                        str3 = str7;
                        f = f3;
                        z2 = zSafeUnbox3;
                        bool5 = bool26;
                        bool7 = bool12;
                        str2 = str5;
                        bool3 = bool17;
                        j5 = j6;
                    }
                } else {
                    bool26 = bool26;
                    j6 = j;
                }
                str8 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111111112 = str8;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool10 = bool19;
                    bool9 = bool25;
                    str4 = str111111111111111111111111112;
                    long j111111111111111111111111114 = j8;
                    str = str6;
                    bool = bool15;
                    bool2 = bool21;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j111111111111111111111111114;
                } else {
                    str = str6;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool15;
                    bool10 = bool19;
                    bool2 = bool21;
                    bool9 = bool25;
                    str4 = str8;
                    zSafeUnbox = false;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j6;
                }
            } else {
                bool25 = bool24;
            }
            bool26 = null;
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
                    str8 = itemDesc.get();
                }
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111111113 = str8;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool10 = bool19;
                    bool9 = bool25;
                    str4 = str111111111111111111111111113;
                    long j111111111111111111111111115 = j8;
                    str = str6;
                    bool = bool15;
                    bool2 = bool21;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j111111111111111111111111115;
                } else {
                    str = str6;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool15;
                    bool10 = bool19;
                    bool2 = bool21;
                    bool9 = bool25;
                    str4 = str8;
                    zSafeUnbox = false;
                    z = z4;
                    bool8 = bool13;
                    bool6 = bool23;
                    str3 = str7;
                    f = f3;
                    z2 = zSafeUnbox3;
                    bool5 = bool26;
                    bool7 = bool12;
                    str2 = str5;
                    bool3 = bool17;
                    j5 = j6;
                }
            } else {
                bool26 = bool26;
                j6 = j;
            }
            str8 = null;
            j7 = j6 & 819208;
            if (j7 != 0) {
                if (controlOperationViewModel != null) {
                    enable = controlOperationViewModel.getEnable();
                } else {
                    enable = null;
                }
                String str111111111111111111111111114 = str8;
                updateRegistration(15, enable);
                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                if (j7 != 0) {
                    j8 = j6;
                } else if (zSafeUnbox) {
                    j8 = j6 | 8388608;
                } else {
                    j8 = j6 | 4194304;
                }
                newsPromptVisibility2 = newsPromptVisibility;
                bool10 = bool19;
                bool9 = bool25;
                str4 = str111111111111111111111111114;
                long j111111111111111111111111116 = j8;
                str = str6;
                bool = bool15;
                bool2 = bool21;
                z = z4;
                bool8 = bool13;
                bool6 = bool23;
                str3 = str7;
                f = f3;
                z2 = zSafeUnbox3;
                bool5 = bool26;
                bool7 = bool12;
                str2 = str5;
                bool3 = bool17;
                j5 = j111111111111111111111111116;
            } else {
                str = str6;
                newsPromptVisibility2 = newsPromptVisibility;
                bool = bool15;
                bool10 = bool19;
                bool2 = bool21;
                bool9 = bool25;
                str4 = str8;
                zSafeUnbox = false;
                z = z4;
                bool8 = bool13;
                bool6 = bool23;
                str3 = str7;
                f = f3;
                z2 = zSafeUnbox3;
                bool5 = bool26;
                bool7 = bool12;
                str2 = str5;
                bool3 = bool17;
                j5 = j6;
            }
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
            str3 = null;
            str4 = null;
            bool6 = null;
            direction = null;
            bool7 = null;
            bool8 = null;
            bool9 = null;
            bool10 = null;
            zSafeUnbox = false;
            f = 0.0f;
            f2 = 0.0f;
            z = false;
            z2 = false;
        }
        if ((j5 & 4194304) != 0) {
            if (controlOperationViewModel != null) {
                newsPromptVisibility2 = controlOperationViewModel.getNewsPromptVisibility();
            }
            ObservableField<Boolean> observableField = newsPromptVisibility2;
            updateRegistration(3, observableField);
            bool11 = observableField != null ? observableField.get() : bool8;
            zSafeUnbox2 = ViewDataBinding.safeUnbox(bool11);
        } else {
            bool11 = bool8;
            zSafeUnbox2 = z2;
        }
        long j20 = j5 & 819208;
        if (j20 != 0) {
            z3 = zSafeUnbox ? true : zSafeUnbox2;
        } else {
            z3 = false;
        }
        if ((j5 & 524288) != 0) {
            BindingAdapter.onClick(this.mboundView10, this.mCallback119);
            BindingAdapter.onClick((ViewGroup) this.mboundView12, this.mCallback120);
            BindingAdapter.onClick(this.mboundView15, this.mCallback121);
            BindingAdapter.onClick(this.mboundView8, this.mCallback117);
            BindingAdapter.onClick(this.mboundView9, this.mCallback118);
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
            BindingAdapter.goneUnless(this.mboundView14, Boolean.valueOf(z));
        }
        if ((j5 & 786688) != 0) {
            BindingAdapter.viewSelected(this.mboundView13, bool3);
        }
        if ((j5 & 786433) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str2);
        }
        if ((j5 & j2) != 0) {
            BindingAdapter.viewSelected(this.mboundView15, bool5);
        }
        if ((j5 & 786432) != 0) {
            BindingAdapter.viewRadius(this.mboundView2, direction);
        }
        if ((j5 & 786440) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView3.setAlpha(f2);
            }
            BindingAdapter.goneUnless(this.mboundView6, bool11);
        }
        if ((j5 & 802816) != 0 && getBuildSdkInt() >= 4) {
            this.mboundView3.setContentDescription(str4);
        }
        if ((j5 & 819200) != 0) {
            ViewBindingAdapter.setOnClick(this.mboundView3, this.mCallback116, zSafeUnbox);
        }
        if ((j5 & 786464) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str);
        }
        if (j20 != 0) {
            BindingAdapter.invisibleUnless(this.mboundView5, Boolean.valueOf(z3));
        }
        if ((j5 & j3) != 0) {
            BindingAdapter.viewSelected(this.mboundView5, bool);
        }
        if ((j5 & j4) != 0) {
            TextViewBindingAdapter.setText(this.mboundView6, str3);
        }
        if ((j5 & 788480) != 0) {
            BindingAdapter.goneUnless(this.mboundView7, bool6);
        }
        if ((j5 & 786434) != 0) {
            BindingAdapter.viewSelected(this.mboundView8, bool7);
        }
        if ((j5 & 790528) != 0) {
            BindingAdapter.viewSelected(this.mboundView9, bool9);
        }
        if ((j5 & 786944) != 0) {
            BindingAdapter.goneUnless(this.notTitle, bool10);
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
