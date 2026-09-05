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
import com.nothing.ear.two.control.ControlItemViewModel;
import com.nothing.ear.two.control.ControlOperationActivity;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlRadius;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class EarTwoControlDialogItemBindingImpl extends EarTwoControlDialogItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback64;
    private final View.OnClickListener mCallback65;
    private final View.OnClickListener mCallback66;
    private final View.OnClickListener mCallback67;
    private final View.OnClickListener mCallback68;
    private final View.OnClickListener mCallback69;
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

    public EarTwoControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private EarTwoControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 15, (TextView) bindings[1]);
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
        this.mCallback67 = new OnClickListener(this, 4);
        this.mCallback68 = new OnClickListener(this, 5);
        this.mCallback69 = new OnClickListener(this, 6);
        this.mCallback65 = new OnClickListener(this, 2);
        this.mCallback64 = new OnClickListener(this, 1);
        this.mCallback66 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 262144L;
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

    @Override // com.nothing.ear.databinding.EarTwoControlDialogItemBinding
    public void setItemViewModel(ControlItemViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.EarTwoControlDialogItemBinding
    public void setEventHandler(ControlOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.EarTwoControlDialogItemBinding
    public void setViewModel(ControlOperationViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 131072;
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
                return onChangeViewModelOffSelected((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelNoiseControlVisible((ObservableField) object, fieldId);
            case 11:
                return onChangeViewModelNoiseCancellationSelected((ObservableField) object, fieldId);
            case 12:
                return onChangeViewModelVoiceAssistantDefaultSelected((ObservableField) object, fieldId);
            case 13:
                return onChangeViewModelItemDesc((ObservableField) object, fieldId);
            case 14:
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

    private boolean onChangeViewModelOffSelected(ObservableField<Boolean> ViewModelOffSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseControlVisible(ObservableField<Boolean> ViewModelNoiseControlVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseCancellationSelected(ObservableField<Boolean> ViewModelNoiseCancellationSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantDefaultSelected(ObservableField<Boolean> ViewModelVoiceAssistantDefaultSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeViewModelItemDesc(ObservableField<String> ViewModelItemDesc, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeViewModelEnable(ObservableField<Boolean> ViewModelEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x019d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x019f  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:114:0x01af  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:119:0x01c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d9  */
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
    /* JADX WARN: Code duplicated, block: B:149:0x022f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x0231  */
    /* JADX WARN: Code duplicated, block: B:151:0x0236  */
    /* JADX WARN: Code duplicated, block: B:154:0x0241  */
    /* JADX WARN: Code duplicated, block: B:155:0x0248  */
    /* JADX WARN: Code duplicated, block: B:159:0x0252 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:161:0x0259  */
    /* JADX WARN: Code duplicated, block: B:164:0x0264 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x0266  */
    /* JADX WARN: Code duplicated, block: B:166:0x0271  */
    /* JADX WARN: Code duplicated, block: B:169:0x027e  */
    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    /* JADX WARN: Code duplicated, block: B:170:0x0285  */
    /* JADX WARN: Code duplicated, block: B:174:0x0291 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:175:0x0293  */
    /* JADX WARN: Code duplicated, block: B:176:0x0298  */
    /* JADX WARN: Code duplicated, block: B:179:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:182:0x02b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:183:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:184:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:186:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:189:0x02c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:190:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:191:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:193:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:210:0x0384 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:212:0x0387  */
    /* JADX WARN: Code duplicated, block: B:214:0x038b  */
    /* JADX WARN: Code duplicated, block: B:215:0x038e  */
    /* JADX WARN: Code duplicated, block: B:217:0x0393  */
    /* JADX WARN: Code duplicated, block: B:220:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:221:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:224:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:227:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:230:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:232:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:236:0x0405  */
    /* JADX WARN: Code duplicated, block: B:239:0x0410  */
    /* JADX WARN: Code duplicated, block: B:242:0x041b  */
    /* JADX WARN: Code duplicated, block: B:245:0x0426  */
    /* JADX WARN: Code duplicated, block: B:248:0x0431  */
    /* JADX WARN: Code duplicated, block: B:250:0x0439  */
    /* JADX WARN: Code duplicated, block: B:259:0x0461  */
    /* JADX WARN: Code duplicated, block: B:25:0x007b  */
    /* JADX WARN: Code duplicated, block: B:262:0x046e  */
    /* JADX WARN: Code duplicated, block: B:264:0x0475  */
    /* JADX WARN: Code duplicated, block: B:267:0x048d  */
    /* JADX WARN: Code duplicated, block: B:270:0x049a  */
    /* JADX WARN: Code duplicated, block: B:273:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:276:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:279:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:286:? A[RETURN, SYNTHETIC] */
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
        String str2;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        String str3;
        Boolean bool6;
        String str4;
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
        boolean z3;
        String str5;
        Boolean bool11;
        Boolean bool12;
        boolean zSafeUnbox2;
        boolean z4;
        long j6;
        boolean z5;
        boolean z6;
        String str6;
        Boolean bool13;
        float f3;
        boolean z7;
        ObservableField<Boolean> newsPromptVisibility;
        Boolean bool14;
        boolean zSafeUnbox3;
        String str7;
        String str8;
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
        long j7;
        String str9;
        long j8;
        ObservableField<Boolean> enable;
        long j9;
        long j10;
        ObservableField<String> itemDesc;
        ObservableField<Boolean> voiceAssistantDefaultSelected;
        ObservableField<Boolean> noiseCancellationSelected;
        ObservableField<Boolean> noiseControlVisible;
        ObservableField<Boolean> offSelected;
        ObservableField<Boolean> voiceAssistantChatGptSelected;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlItemViewModel controlItemViewModel = this.mItemViewModel;
        ControlOperationActivity controlOperationActivity = this.mEventHandler;
        ControlOperationViewModel controlOperationViewModel2 = this.mViewModel;
        ObservableField<Boolean> newsPromptVisibility2 = null;
        if ((425983 & j) != 0) {
            if ((j & 393217) == 0) {
                str6 = null;
            } else {
                ObservableField<String> chatGptUnableText = controlOperationViewModel2 != null ? controlOperationViewModel2.getChatGptUnableText() : null;
                updateRegistration(0, chatGptUnableText);
                if (chatGptUnableText != null) {
                    str6 = chatGptUnableText.get();
                } else {
                    str6 = null;
                }
            }
            if ((j & 393218) == 0) {
                bool13 = null;
            } else {
                ObservableField<Boolean> transSelected = controlOperationViewModel2 != null ? controlOperationViewModel2.getTransSelected() : null;
                updateRegistration(1, transSelected);
                if (transSelected != null) {
                    bool13 = transSelected.get();
                } else {
                    bool13 = null;
                }
            }
            long j11 = j & 393220;
            if (j11 != 0) {
                ObservableField<Boolean> voiceAssistantEnable = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantEnable() : null;
                j2 = 397312;
                updateRegistration(2, voiceAssistantEnable);
                bool5 = voiceAssistantEnable != null ? voiceAssistantEnable.get() : null;
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(bool5);
                z7 = !zSafeUnbox4;
                boolean z8 = zSafeUnbox4;
                if (j11 != 0) {
                    j |= z8 ? 67108864L : 33554432L;
                }
                f3 = z8 ? 1.0f : 0.38f;
            } else {
                j2 = 397312;
                bool5 = null;
                f3 = 0.0f;
                z7 = false;
            }
            long j12 = j & 393224;
            if (j12 != 0) {
                newsPromptVisibility = controlOperationViewModel2 != null ? controlOperationViewModel2.getNewsPromptVisibility() : null;
                j3 = 393344;
                updateRegistration(3, newsPromptVisibility);
                bool14 = newsPromptVisibility != null ? newsPromptVisibility.get() : null;
                j4 = 393280;
                zSafeUnbox3 = ViewDataBinding.safeUnbox(bool14);
                boolean z9 = zSafeUnbox3;
                if (j12 != 0) {
                    j |= z9 ? 1048576L : 524288L;
                }
                f2 = z9 ? 0.4f : 1.0f;
            } else {
                j3 = 393344;
                j4 = 393280;
                newsPromptVisibility = null;
                bool14 = null;
                zSafeUnbox3 = false;
                f2 = 0.0f;
            }
            if ((j & 393232) == 0) {
                bool3 = null;
            } else {
                ObservableField<Boolean> voiceAssistantVisible = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantVisible() : null;
                updateRegistration(4, voiceAssistantVisible);
                if (voiceAssistantVisible != null) {
                    bool3 = voiceAssistantVisible.get();
                } else {
                    bool3 = null;
                }
            }
            if ((j & 393248) == 0) {
                str7 = null;
            } else {
                ObservableField<String> operationName = controlOperationViewModel2 != null ? controlOperationViewModel2.getOperationName() : null;
                updateRegistration(5, operationName);
                if (operationName != null) {
                    str7 = operationName.get();
                } else {
                    str7 = null;
                }
            }
            if ((j & j4) == 0) {
                str8 = null;
            } else {
                ObservableField<String> newsPromptName = controlOperationViewModel2 != null ? controlOperationViewModel2.getNewsPromptName() : null;
                updateRegistration(6, newsPromptName);
                if (newsPromptName != null) {
                    str8 = newsPromptName.get();
                } else {
                    str8 = null;
                }
            }
            if ((j & j3) != 0) {
                ObservableField<Boolean> selected = controlOperationViewModel2 != null ? controlOperationViewModel2.getSelected() : null;
                controlOperationViewModel = controlOperationViewModel2;
                updateRegistration(7, selected);
                if (selected != null) {
                    bool15 = selected.get();
                }
                if ((j & 393472) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantChatGptSelected = controlOperationViewModel.getVoiceAssistantChatGptSelected();
                    } else {
                        voiceAssistantChatGptSelected = null;
                    }
                    bool16 = bool15;
                    updateRegistration(8, voiceAssistantChatGptSelected);
                    if (voiceAssistantChatGptSelected != null) {
                        bool17 = voiceAssistantChatGptSelected.get();
                    }
                    if ((j & 393728) != 0) {
                        if (controlOperationViewModel != null) {
                            offSelected = controlOperationViewModel.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(9, offSelected);
                        if (offSelected != null) {
                            bool19 = offSelected.get();
                        }
                        if ((j & 394240) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool20 = bool19;
                            updateRegistration(10, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool21 = noiseControlVisible.get();
                            }
                            if ((j & 395264) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool22 = bool21;
                                updateRegistration(11, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool23 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool24 = bool23;
                                    updateRegistration(12, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool25 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 393216) != 0 || controlOperationViewModel == null) {
                                        direction = null;
                                    } else {
                                        direction = controlOperationViewModel.getDirection();
                                    }
                                    if ((j & 401408) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j7 = j;
                                        updateRegistration(13, itemDesc);
                                        if (itemDesc != null) {
                                            str9 = itemDesc.get();
                                        }
                                        j8 = j7 & 409608;
                                        if (j8 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str10 = str9;
                                            updateRegistration(14, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j8 != 0) {
                                                if (zSafeUnbox) {
                                                    j10 = 16777216;
                                                } else {
                                                    j10 = 8388608;
                                                }
                                                j9 = j7 | j10;
                                            } else {
                                                j9 = j7;
                                            }
                                            boolean z10 = !zSafeUnbox;
                                            if ((j9 & 409608) != 0) {
                                                if (zSafeUnbox) {
                                                    j9 |= 2097152;
                                                } else {
                                                    j9 |= 4194304;
                                                }
                                            }
                                            Boolean bool26 = bool22;
                                            z2 = zSafeUnbox3;
                                            bool7 = bool26;
                                            bool9 = bool13;
                                            bool4 = bool18;
                                            bool10 = bool24;
                                            z3 = z7;
                                            bool8 = bool14;
                                            str4 = str8;
                                            f = f3;
                                            str3 = str6;
                                            bool2 = bool20;
                                            j5 = j9;
                                            str2 = str7;
                                            bool = bool16;
                                            z = z10;
                                            str = str10;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool6 = bool25;
                                        } else {
                                            String str11 = str9;
                                            Boolean bool27 = bool22;
                                            z2 = zSafeUnbox3;
                                            bool7 = bool27;
                                            str2 = str7;
                                            bool9 = bool13;
                                            newsPromptVisibility2 = newsPromptVisibility;
                                            bool = bool16;
                                            bool4 = bool18;
                                            bool10 = bool24;
                                            bool6 = bool25;
                                            str = str11;
                                            zSafeUnbox = false;
                                            z = false;
                                            z3 = z7;
                                            bool8 = bool14;
                                            str4 = str8;
                                            f = f3;
                                            str3 = str6;
                                            bool2 = bool20;
                                            j5 = j7;
                                        }
                                    } else {
                                        bool25 = bool25;
                                        j7 = j;
                                    }
                                    str9 = null;
                                    j8 = j7 & 409608;
                                    if (j8 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str12 = str9;
                                        updateRegistration(14, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j8 != 0) {
                                            if (zSafeUnbox) {
                                                j10 = 16777216;
                                            } else {
                                                j10 = 8388608;
                                            }
                                            j9 = j7 | j10;
                                        } else {
                                            j9 = j7;
                                        }
                                        boolean z11 = !zSafeUnbox;
                                        if ((j9 & 409608) != 0) {
                                            if (zSafeUnbox) {
                                                j9 |= 4194304;
                                            } else {
                                                j9 |= 2097152;
                                            }
                                        }
                                        Boolean bool28 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool28;
                                        bool9 = bool13;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j9;
                                        str2 = str7;
                                        bool = bool16;
                                        z = z11;
                                        str = str12;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool6 = bool25;
                                    } else {
                                        String str13 = str9;
                                        Boolean bool29 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool29;
                                        str2 = str7;
                                        bool9 = bool13;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool16;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        bool6 = bool25;
                                        str = str13;
                                        zSafeUnbox = false;
                                        z = false;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j7;
                                    }
                                } else {
                                    bool24 = bool23;
                                }
                                bool25 = null;
                                if ((j & 393216) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 401408) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j7 = j;
                                    updateRegistration(13, itemDesc);
                                    if (itemDesc != null) {
                                        str9 = itemDesc.get();
                                    }
                                    j8 = j7 & 409608;
                                    if (j8 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str14 = str9;
                                        updateRegistration(14, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j8 != 0) {
                                            if (zSafeUnbox) {
                                                j10 = 16777216;
                                            } else {
                                                j10 = 8388608;
                                            }
                                            j9 = j7 | j10;
                                        } else {
                                            j9 = j7;
                                        }
                                        boolean z12 = !zSafeUnbox;
                                        if ((j9 & 409608) != 0) {
                                            if (zSafeUnbox) {
                                                j9 |= 4194304;
                                            } else {
                                                j9 |= 2097152;
                                            }
                                        }
                                        Boolean bool210 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool210;
                                        bool9 = bool13;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j9;
                                        str2 = str7;
                                        bool = bool16;
                                        z = z12;
                                        str = str14;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool6 = bool25;
                                    } else {
                                        String str15 = str9;
                                        Boolean bool211 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool211;
                                        str2 = str7;
                                        bool9 = bool13;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool16;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        bool6 = bool25;
                                        str = str15;
                                        zSafeUnbox = false;
                                        z = false;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j7;
                                    }
                                } else {
                                    bool25 = bool25;
                                    j7 = j;
                                }
                                str9 = null;
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str16 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z13 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool212 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool212;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z13;
                                    str = str16;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str17 = str9;
                                    Boolean bool213 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool213;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str17;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool22 = bool21;
                            }
                            bool23 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool24 = bool23;
                                updateRegistration(12, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool25 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 393216) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 401408) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j7 = j;
                                    updateRegistration(13, itemDesc);
                                    if (itemDesc != null) {
                                        str9 = itemDesc.get();
                                    }
                                    j8 = j7 & 409608;
                                    if (j8 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str18 = str9;
                                        updateRegistration(14, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j8 != 0) {
                                            if (zSafeUnbox) {
                                                j10 = 16777216;
                                            } else {
                                                j10 = 8388608;
                                            }
                                            j9 = j7 | j10;
                                        } else {
                                            j9 = j7;
                                        }
                                        boolean z14 = !zSafeUnbox;
                                        if ((j9 & 409608) != 0) {
                                            if (zSafeUnbox) {
                                                j9 |= 4194304;
                                            } else {
                                                j9 |= 2097152;
                                            }
                                        }
                                        Boolean bool214 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool214;
                                        bool9 = bool13;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j9;
                                        str2 = str7;
                                        bool = bool16;
                                        z = z14;
                                        str = str18;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool6 = bool25;
                                    } else {
                                        String str19 = str9;
                                        Boolean bool215 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool215;
                                        str2 = str7;
                                        bool9 = bool13;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool16;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        bool6 = bool25;
                                        str = str19;
                                        zSafeUnbox = false;
                                        z = false;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j7;
                                    }
                                } else {
                                    bool25 = bool25;
                                    j7 = j;
                                }
                                str9 = null;
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str110 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z15 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool216 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool216;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z15;
                                    str = str110;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111 = str9;
                                    Boolean bool217 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool217;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool24 = bool23;
                            }
                            bool25 = null;
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str112 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z16 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool218 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool218;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z16;
                                    str = str112;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str113 = str9;
                                    Boolean bool219 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool219;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str113;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z17 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z17;
                                str = str114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str115 = str9;
                                Boolean bool2111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool20 = bool19;
                        }
                        bool21 = null;
                        if ((j & 395264) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool22 = bool21;
                            updateRegistration(11, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool23 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool24 = bool23;
                                updateRegistration(12, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool25 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 393216) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 401408) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j7 = j;
                                    updateRegistration(13, itemDesc);
                                    if (itemDesc != null) {
                                        str9 = itemDesc.get();
                                    }
                                    j8 = j7 & 409608;
                                    if (j8 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str116 = str9;
                                        updateRegistration(14, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j8 != 0) {
                                            if (zSafeUnbox) {
                                                j10 = 16777216;
                                            } else {
                                                j10 = 8388608;
                                            }
                                            j9 = j7 | j10;
                                        } else {
                                            j9 = j7;
                                        }
                                        boolean z18 = !zSafeUnbox;
                                        if ((j9 & 409608) != 0) {
                                            if (zSafeUnbox) {
                                                j9 |= 4194304;
                                            } else {
                                                j9 |= 2097152;
                                            }
                                        }
                                        Boolean bool2112 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool2112;
                                        bool9 = bool13;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j9;
                                        str2 = str7;
                                        bool = bool16;
                                        z = z18;
                                        str = str116;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool6 = bool25;
                                    } else {
                                        String str117 = str9;
                                        Boolean bool2113 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool2113;
                                        str2 = str7;
                                        bool9 = bool13;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool16;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        bool6 = bool25;
                                        str = str117;
                                        zSafeUnbox = false;
                                        z = false;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j7;
                                    }
                                } else {
                                    bool25 = bool25;
                                    j7 = j;
                                }
                                str9 = null;
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str118 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z19 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool2114 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2114;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z19;
                                    str = str118;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str119 = str9;
                                    Boolean bool2115 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2115;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str119;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool24 = bool23;
                            }
                            bool25 = null;
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1110 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z110 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool2116 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2116;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z110;
                                    str = str1110;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str1111 = str9;
                                    Boolean bool2117 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2117;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str1111;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1112 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2118 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2118;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111;
                                str = str1112;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1113 = str9;
                                Boolean bool2119 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2119;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1113;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool22 = bool21;
                        }
                        bool23 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1114 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z112 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool21110 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool21110;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z112;
                                    str = str1114;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str1115 = str9;
                                    Boolean bool21111 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool21111;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str1115;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1116 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z113 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21112 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21112;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z113;
                                str = str1116;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1117 = str9;
                                Boolean bool21113 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21113;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1117;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1118 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z114 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21114 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21114;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z114;
                                str = str1118;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1119 = str9;
                                Boolean bool21115 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21115;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1119;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z115 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z115;
                            str = str11110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111 = str9;
                            Boolean bool21117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & 394240) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool20 = bool19;
                        updateRegistration(10, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool21 = noiseControlVisible.get();
                        }
                        if ((j & 395264) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool22 = bool21;
                            updateRegistration(11, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool23 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool24 = bool23;
                                updateRegistration(12, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool25 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 393216) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 401408) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j7 = j;
                                    updateRegistration(13, itemDesc);
                                    if (itemDesc != null) {
                                        str9 = itemDesc.get();
                                    }
                                    j8 = j7 & 409608;
                                    if (j8 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11112 = str9;
                                        updateRegistration(14, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j8 != 0) {
                                            if (zSafeUnbox) {
                                                j10 = 16777216;
                                            } else {
                                                j10 = 8388608;
                                            }
                                            j9 = j7 | j10;
                                        } else {
                                            j9 = j7;
                                        }
                                        boolean z116 = !zSafeUnbox;
                                        if ((j9 & 409608) != 0) {
                                            if (zSafeUnbox) {
                                                j9 |= 4194304;
                                            } else {
                                                j9 |= 2097152;
                                            }
                                        }
                                        Boolean bool21118 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool21118;
                                        bool9 = bool13;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j9;
                                        str2 = str7;
                                        bool = bool16;
                                        z = z116;
                                        str = str11112;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool6 = bool25;
                                    } else {
                                        String str11113 = str9;
                                        Boolean bool21119 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool21119;
                                        str2 = str7;
                                        bool9 = bool13;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool16;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        bool6 = bool25;
                                        str = str11113;
                                        zSafeUnbox = false;
                                        z = false;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j7;
                                    }
                                } else {
                                    bool25 = bool25;
                                    j7 = j;
                                }
                                str9 = null;
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11114 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z117 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211110 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211110;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z117;
                                    str = str11114;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str11115 = str9;
                                    Boolean bool211111 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str11115;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool24 = bool23;
                            }
                            bool25 = null;
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11116 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z118 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211112 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211112;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z118;
                                    str = str11116;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str11117 = str9;
                                    Boolean bool211113 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211113;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str11117;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11118 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z119 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool211114 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211114;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z119;
                                str = str11118;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str11119 = str9;
                                Boolean bool211115 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211115;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str11119;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool22 = bool21;
                        }
                        bool23 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111110 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z1110 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211116 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211116;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z1110;
                                    str = str111110;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111111 = str9;
                                    Boolean bool211117 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211117;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111111;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111112 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool211118 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211118;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111;
                                str = str111112;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111113 = str9;
                                Boolean bool211119 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211119;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111113;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1112 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1112;
                                str = str111114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111115 = str9;
                                Boolean bool2111111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111116 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1113 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111112 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111112;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1113;
                            str = str111116;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111117 = str9;
                            Boolean bool2111113 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111113;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111117;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool20 = bool19;
                    }
                    bool21 = null;
                    if ((j & 395264) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool22 = bool21;
                        updateRegistration(11, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool23 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111118 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z1114 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool2111114 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2111114;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z1114;
                                    str = str111118;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111119 = str9;
                                    Boolean bool2111115 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2111115;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111119;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111110 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1115 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111116 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111116;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1115;
                                str = str1111110;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111 = str9;
                                Boolean bool2111117 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111117;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111112 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1116 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111118 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111118;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1116;
                                str = str1111112;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111113 = str9;
                                Boolean bool2111119 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111119;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111113;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111114 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1117 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111110 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111110;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1117;
                            str = str1111114;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111115 = str9;
                            Boolean bool21111111 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111115;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool22 = bool21;
                    }
                    bool23 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111116 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1118 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21111112 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111112;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1118;
                                str = str1111116;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111117 = str9;
                                Boolean bool21111113 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111113;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111117;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111118 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1119 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111114 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111114;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1119;
                            str = str1111118;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111119 = str9;
                            Boolean bool21111115 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111115;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111119;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z11110 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z11110;
                            str = str11111110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111 = str9;
                            Boolean bool21111117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111112 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111118 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111118;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111;
                        str = str11111112;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111113 = str9;
                        Boolean bool21111119 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111119;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111113;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool16 = bool15;
                }
                bool17 = null;
                if ((j & 393728) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool18 = bool17;
                    updateRegistration(9, offSelected);
                    if (offSelected != null) {
                        bool19 = offSelected.get();
                    }
                    if ((j & 394240) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool20 = bool19;
                        updateRegistration(10, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool21 = noiseControlVisible.get();
                        }
                        if ((j & 395264) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool22 = bool21;
                            updateRegistration(11, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool23 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool24 = bool23;
                                updateRegistration(12, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool25 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 393216) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 401408) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j7 = j;
                                    updateRegistration(13, itemDesc);
                                    if (itemDesc != null) {
                                        str9 = itemDesc.get();
                                    }
                                    j8 = j7 & 409608;
                                    if (j8 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111114 = str9;
                                        updateRegistration(14, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j8 != 0) {
                                            if (zSafeUnbox) {
                                                j10 = 16777216;
                                            } else {
                                                j10 = 8388608;
                                            }
                                            j9 = j7 | j10;
                                        } else {
                                            j9 = j7;
                                        }
                                        boolean z11112 = !zSafeUnbox;
                                        if ((j9 & 409608) != 0) {
                                            if (zSafeUnbox) {
                                                j9 |= 4194304;
                                            } else {
                                                j9 |= 2097152;
                                            }
                                        }
                                        Boolean bool211111110 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool211111110;
                                        bool9 = bool13;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j9;
                                        str2 = str7;
                                        bool = bool16;
                                        z = z11112;
                                        str = str11111114;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool6 = bool25;
                                    } else {
                                        String str11111115 = str9;
                                        Boolean bool211111111 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool211111111;
                                        str2 = str7;
                                        bool9 = bool13;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool16;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        bool6 = bool25;
                                        str = str11111115;
                                        zSafeUnbox = false;
                                        z = false;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j7;
                                    }
                                } else {
                                    bool25 = bool25;
                                    j7 = j;
                                }
                                str9 = null;
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111116 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z11113 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211111112 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111112;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z11113;
                                    str = str11111116;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str11111117 = str9;
                                    Boolean bool211111113 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111113;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str11111117;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool24 = bool23;
                            }
                            bool25 = null;
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111118 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z11114 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211111114 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111114;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z11114;
                                    str = str11111118;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str11111119 = str9;
                                    Boolean bool211111115 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111115;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str11111119;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111110 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z11115 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool211111116 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211111116;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z11115;
                                str = str111111110;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111 = str9;
                                Boolean bool211111117 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211111117;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool22 = bool21;
                        }
                        bool23 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111112 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z11116 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211111118 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111118;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z11116;
                                    str = str111111112;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111111113 = str9;
                                    Boolean bool211111119 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111119;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111111113;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z11117 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z11117;
                                str = str111111114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111115 = str9;
                                Boolean bool2111111111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111116 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z11118 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111112 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111112;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z11118;
                                str = str111111116;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111117 = str9;
                                Boolean bool2111111113 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111113;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111117;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111118 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z11119 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111114 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111114;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z11119;
                            str = str111111118;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111111119 = str9;
                            Boolean bool2111111115 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111115;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111111119;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool20 = bool19;
                    }
                    bool21 = null;
                    if ((j & 395264) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool22 = bool21;
                        updateRegistration(11, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool23 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111110 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z111110 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool2111111116 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2111111116;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z111110;
                                    str = str1111111110;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str1111111111 = str9;
                                    Boolean bool2111111117 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2111111117;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str1111111111;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111112 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111111 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111118 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111118;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111111;
                                str = str1111111112;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111113 = str9;
                                Boolean bool2111111119 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111119;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111113;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111112 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21111111110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111112;
                                str = str1111111114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111115 = str9;
                                Boolean bool21111111111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111116 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111113 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111112 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111112;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111113;
                            str = str1111111116;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111117 = str9;
                            Boolean bool21111111113 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111113;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111117;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool22 = bool21;
                    }
                    bool23 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111118 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111114 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21111111114 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111114;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111114;
                                str = str1111111118;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111119 = str9;
                                Boolean bool21111111115 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111115;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111119;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111115 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111115;
                            str = str11111111110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111 = str9;
                            Boolean bool21111111117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111112 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111116 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111118 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111118;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111116;
                            str = str11111111112;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111113 = str9;
                            Boolean bool21111111119 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111119;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111113;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111114 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z111117 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111110 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111110;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z111117;
                        str = str11111111114;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111115 = str9;
                        Boolean bool211111111111 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111115;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool18 = bool17;
                }
                bool19 = null;
                if ((j & 394240) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool20 = bool19;
                    updateRegistration(10, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool21 = noiseControlVisible.get();
                    }
                    if ((j & 395264) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool22 = bool21;
                        updateRegistration(11, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool23 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111116 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z111118 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211111111112 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111112;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z111118;
                                    str = str11111111116;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str11111111117 = str9;
                                    Boolean bool211111111113 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111113;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str11111111117;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111118 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111119 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool211111111114 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211111111114;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111119;
                                str = str11111111118;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str11111111119 = str9;
                                Boolean bool211111111115 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211111111115;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str11111111119;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111110 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111110 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool211111111116 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211111111116;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111110;
                                str = str111111111110;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111 = str9;
                                Boolean bool211111111117 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211111111117;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111112 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111111 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool211111111118 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111118;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111111;
                            str = str111111111112;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111111111113 = str9;
                            Boolean bool211111111119 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111119;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111111111113;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool22 = bool21;
                    }
                    bool23 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111112 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111112;
                                str = str111111111114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111115 = str9;
                                Boolean bool2111111111111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111116 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111113 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111112 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111112;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111113;
                            str = str111111111116;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111111111117 = str9;
                            Boolean bool2111111111113 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111113;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111111111117;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111118 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111114 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111114 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111114;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111114;
                            str = str111111111118;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111111111119 = str9;
                            Boolean bool2111111111115 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111115;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111111111119;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111110 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z1111115 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool2111111111116 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool2111111111116;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z1111115;
                        str = str1111111111110;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str1111111111111 = str9;
                        Boolean bool2111111111117 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool2111111111117;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str1111111111111;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool20 = bool19;
                }
                bool21 = null;
                if ((j & 395264) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool22 = bool21;
                    updateRegistration(11, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool23 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111112 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111116 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111118 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111118;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111116;
                                str = str1111111111112;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111111113 = str9;
                                Boolean bool2111111111119 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111119;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111111113;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111114 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111117 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111110 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111110;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111117;
                            str = str1111111111114;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111115 = str9;
                            Boolean bool21111111111111 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111115;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111116 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111118 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111112 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111112;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111118;
                            str = str1111111111116;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111117 = str9;
                            Boolean bool21111111111113 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111113;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111117;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111118 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z1111119 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111111111114 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111114;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z1111119;
                        str = str1111111111118;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str1111111111119 = str9;
                        Boolean bool21111111111115 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111115;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str1111111111119;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool22 = bool21;
                }
                bool23 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool24 = bool23;
                    updateRegistration(12, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool25 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z11111110 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z11111110;
                            str = str11111111111110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111 = str9;
                            Boolean bool21111111111117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111112 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111111 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111111111118 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111118;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111111;
                        str = str11111111111112;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111113 = str9;
                        Boolean bool21111111111119 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111119;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111113;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool24 = bool23;
                }
                bool25 = null;
                if ((j & 393216) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 401408) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(13, itemDesc);
                    if (itemDesc != null) {
                        str9 = itemDesc.get();
                    }
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111114 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111112 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111110 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111110;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111112;
                        str = str11111111111114;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111115 = str9;
                        Boolean bool211111111111111 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111115;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool25 = bool25;
                    j7 = j;
                }
                str9 = null;
                j8 = j7 & 409608;
                if (j8 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str11111111111116 = str9;
                    updateRegistration(14, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j8 != 0) {
                        if (zSafeUnbox) {
                            j10 = 16777216;
                        } else {
                            j10 = 8388608;
                        }
                        j9 = j7 | j10;
                    } else {
                        j9 = j7;
                    }
                    boolean z11111113 = !zSafeUnbox;
                    if ((j9 & 409608) != 0) {
                        if (zSafeUnbox) {
                            j9 |= 4194304;
                        } else {
                            j9 |= 2097152;
                        }
                    }
                    Boolean bool211111111111112 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111112;
                    bool9 = bool13;
                    bool4 = bool18;
                    bool10 = bool24;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j9;
                    str2 = str7;
                    bool = bool16;
                    z = z11111113;
                    str = str11111111111116;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool6 = bool25;
                } else {
                    String str11111111111117 = str9;
                    Boolean bool211111111111113 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111113;
                    str2 = str7;
                    bool9 = bool13;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool16;
                    bool4 = bool18;
                    bool10 = bool24;
                    bool6 = bool25;
                    str = str11111111111117;
                    zSafeUnbox = false;
                    z = false;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j7;
                }
            } else {
                controlOperationViewModel = controlOperationViewModel2;
            }
            bool15 = null;
            if ((j & 393472) != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantChatGptSelected = controlOperationViewModel.getVoiceAssistantChatGptSelected();
                } else {
                    voiceAssistantChatGptSelected = null;
                }
                bool16 = bool15;
                updateRegistration(8, voiceAssistantChatGptSelected);
                if (voiceAssistantChatGptSelected != null) {
                    bool17 = voiceAssistantChatGptSelected.get();
                }
                if ((j & 393728) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool18 = bool17;
                    updateRegistration(9, offSelected);
                    if (offSelected != null) {
                        bool19 = offSelected.get();
                    }
                    if ((j & 394240) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool20 = bool19;
                        updateRegistration(10, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool21 = noiseControlVisible.get();
                        }
                        if ((j & 395264) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool22 = bool21;
                            updateRegistration(11, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool23 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool24 = bool23;
                                updateRegistration(12, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool25 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 393216) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 401408) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j7 = j;
                                    updateRegistration(13, itemDesc);
                                    if (itemDesc != null) {
                                        str9 = itemDesc.get();
                                    }
                                    j8 = j7 & 409608;
                                    if (j8 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111118 = str9;
                                        updateRegistration(14, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j8 != 0) {
                                            if (zSafeUnbox) {
                                                j10 = 16777216;
                                            } else {
                                                j10 = 8388608;
                                            }
                                            j9 = j7 | j10;
                                        } else {
                                            j9 = j7;
                                        }
                                        boolean z11111114 = !zSafeUnbox;
                                        if ((j9 & 409608) != 0) {
                                            if (zSafeUnbox) {
                                                j9 |= 4194304;
                                            } else {
                                                j9 |= 2097152;
                                            }
                                        }
                                        Boolean bool211111111111114 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool211111111111114;
                                        bool9 = bool13;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j9;
                                        str2 = str7;
                                        bool = bool16;
                                        z = z11111114;
                                        str = str11111111111118;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool6 = bool25;
                                    } else {
                                        String str11111111111119 = str9;
                                        Boolean bool211111111111115 = bool22;
                                        z2 = zSafeUnbox3;
                                        bool7 = bool211111111111115;
                                        str2 = str7;
                                        bool9 = bool13;
                                        newsPromptVisibility2 = newsPromptVisibility;
                                        bool = bool16;
                                        bool4 = bool18;
                                        bool10 = bool24;
                                        bool6 = bool25;
                                        str = str11111111111119;
                                        zSafeUnbox = false;
                                        z = false;
                                        z3 = z7;
                                        bool8 = bool14;
                                        str4 = str8;
                                        f = f3;
                                        str3 = str6;
                                        bool2 = bool20;
                                        j5 = j7;
                                    }
                                } else {
                                    bool25 = bool25;
                                    j7 = j;
                                }
                                str9 = null;
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111110 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z11111115 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211111111111116 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111111116;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z11111115;
                                    str = str111111111111110;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111111111111111 = str9;
                                    Boolean bool211111111111117 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111111117;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111111111111111;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool24 = bool23;
                            }
                            bool25 = null;
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111112 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z11111116 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211111111111118 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111111118;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z11111116;
                                    str = str111111111111112;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111111111111113 = str9;
                                    Boolean bool211111111111119 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111111119;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111111111111113;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z11111117 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z11111117;
                                str = str111111111111114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111115 = str9;
                                Boolean bool2111111111111111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool22 = bool21;
                        }
                        bool23 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111116 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z11111118 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool2111111111111112 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2111111111111112;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z11111118;
                                    str = str111111111111116;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111111111111117 = str9;
                                    Boolean bool2111111111111113 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool2111111111111113;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111111111111117;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111118 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z11111119 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111114 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111114;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z11111119;
                                str = str111111111111118;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111119 = str9;
                                Boolean bool2111111111111115 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111115;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111119;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111110 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111111110 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111116 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111116;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111111110;
                                str = str1111111111111110;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111111111111 = str9;
                                Boolean bool2111111111111117 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111117;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111111111111;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111112 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111111 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111118 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111118;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111111;
                            str = str1111111111111112;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111111113 = str9;
                            Boolean bool2111111111111119 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111119;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111111113;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool20 = bool19;
                    }
                    bool21 = null;
                    if ((j & 395264) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool22 = bool21;
                        updateRegistration(11, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool23 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111114 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z111111112 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool21111111111111110 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool21111111111111110;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z111111112;
                                    str = str1111111111111114;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str1111111111111115 = str9;
                                    Boolean bool21111111111111111 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool21111111111111111;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str1111111111111115;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111116 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111111113 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21111111111111112 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111112;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111111113;
                                str = str1111111111111116;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111111111117 = str9;
                                Boolean bool21111111111111113 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111113;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111111111117;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111118 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111111114 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21111111111111114 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111114;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111111114;
                                str = str1111111111111118;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111111111119 = str9;
                                Boolean bool21111111111111115 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111115;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111111111119;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111115 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111111116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111115;
                            str = str11111111111111110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111111 = str9;
                            Boolean bool21111111111111117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool22 = bool21;
                    }
                    bool23 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111112 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111111116 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21111111111111118 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111118;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111111116;
                                str = str11111111111111112;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str11111111111111113 = str9;
                                Boolean bool21111111111111119 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111119;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str11111111111111113;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111114 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111117 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool211111111111111110 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111111111110;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111117;
                            str = str11111111111111114;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111115 = str9;
                            Boolean bool211111111111111111 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111111111111;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111115;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111116 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111118 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool211111111111111112 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111111111112;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111118;
                            str = str11111111111111116;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111117 = str9;
                            Boolean bool211111111111111113 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111111111113;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111117;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111118 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z111111119 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111111114 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111114;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z111111119;
                        str = str11111111111111118;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111119 = str9;
                        Boolean bool211111111111111115 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111115;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111119;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool18 = bool17;
                }
                bool19 = null;
                if ((j & 394240) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool20 = bool19;
                    updateRegistration(10, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool21 = noiseControlVisible.get();
                    }
                    if ((j & 395264) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool22 = bool21;
                        updateRegistration(11, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool23 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111110 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z1111111110 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211111111111111116 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111111111116;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z1111111110;
                                    str = str111111111111111110;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111111111111111111 = str9;
                                    Boolean bool211111111111111117 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111111111117;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111111111111111111;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111112 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111111111 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool211111111111111118 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211111111111111118;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111111111;
                                str = str111111111111111112;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111111113 = str9;
                                Boolean bool211111111111111119 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool211111111111111119;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111111113;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111111112 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111111110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111111112;
                                str = str111111111111111114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111111115 = str9;
                                Boolean bool2111111111111111111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111111115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111116 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111111113 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111111112 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111112;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111111113;
                            str = str111111111111111116;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111111111111111117 = str9;
                            Boolean bool2111111111111111113 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111113;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111111111111111117;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool22 = bool21;
                    }
                    bool23 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111118 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111111114 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111111114 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111114;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111111114;
                                str = str111111111111111118;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111111119 = str9;
                                Boolean bool2111111111111111115 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111115;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111111119;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111111115 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111111116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111111115;
                            str = str1111111111111111110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111111111111 = str9;
                            Boolean bool2111111111111111117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111111111111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111112 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111111116 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111111118 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111118;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111111116;
                            str = str1111111111111111112;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111111111113 = str9;
                            Boolean bool2111111111111111119 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111119;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111111111113;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111114 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z1111111117 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111111111111111110 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111110;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z1111111117;
                        str = str1111111111111111114;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str1111111111111111115 = str9;
                        Boolean bool21111111111111111111 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str1111111111111111115;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool20 = bool19;
                }
                bool21 = null;
                if ((j & 395264) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool22 = bool21;
                    updateRegistration(11, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool23 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111116 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111111118 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21111111111111111112 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111111112;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111111118;
                                str = str1111111111111111116;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111111111111117 = str9;
                                Boolean bool21111111111111111113 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111111113;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111111111111117;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111118 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111111119 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111111111114 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111114;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111111119;
                            str = str1111111111111111118;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111111111119 = str9;
                            Boolean bool21111111111111111115 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111115;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111111111119;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z11111111110 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111111111116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z11111111110;
                            str = str11111111111111111110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111111111 = str9;
                            Boolean bool21111111111111111117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111111111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111112 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111111111 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111111111111111118 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111118;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111111111;
                        str = str11111111111111111112;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111111113 = str9;
                        Boolean bool21111111111111111119 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111119;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111111113;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool22 = bool21;
                }
                bool23 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool24 = bool23;
                    updateRegistration(12, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool25 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111114 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z11111111112 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool211111111111111111110 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111111111111110;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z11111111112;
                            str = str11111111111111111114;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111111115 = str9;
                            Boolean bool211111111111111111111 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111111111111111;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111111115;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111116 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111111113 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111111111112 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111112;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111111113;
                        str = str11111111111111111116;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111111117 = str9;
                        Boolean bool211111111111111111113 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111113;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111111117;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool24 = bool23;
                }
                bool25 = null;
                if ((j & 393216) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 401408) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(13, itemDesc);
                    if (itemDesc != null) {
                        str9 = itemDesc.get();
                    }
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111118 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111111114 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111111111114 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111114;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111111114;
                        str = str11111111111111111118;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111111119 = str9;
                        Boolean bool211111111111111111115 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111115;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111111119;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool25 = bool25;
                    j7 = j;
                }
                str9 = null;
                j8 = j7 & 409608;
                if (j8 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111110 = str9;
                    updateRegistration(14, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j8 != 0) {
                        if (zSafeUnbox) {
                            j10 = 16777216;
                        } else {
                            j10 = 8388608;
                        }
                        j9 = j7 | j10;
                    } else {
                        j9 = j7;
                    }
                    boolean z11111111115 = !zSafeUnbox;
                    if ((j9 & 409608) != 0) {
                        if (zSafeUnbox) {
                            j9 |= 4194304;
                        } else {
                            j9 |= 2097152;
                        }
                    }
                    Boolean bool211111111111111111116 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111116;
                    bool9 = bool13;
                    bool4 = bool18;
                    bool10 = bool24;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j9;
                    str2 = str7;
                    bool = bool16;
                    z = z11111111115;
                    str = str111111111111111111110;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool6 = bool25;
                } else {
                    String str111111111111111111111 = str9;
                    Boolean bool211111111111111111117 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111117;
                    str2 = str7;
                    bool9 = bool13;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool16;
                    bool4 = bool18;
                    bool10 = bool24;
                    bool6 = bool25;
                    str = str111111111111111111111;
                    zSafeUnbox = false;
                    z = false;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j7;
                }
            } else {
                bool16 = bool15;
            }
            bool17 = null;
            if ((j & 393728) != 0) {
                if (controlOperationViewModel != null) {
                    offSelected = controlOperationViewModel.getOffSelected();
                } else {
                    offSelected = null;
                }
                bool18 = bool17;
                updateRegistration(9, offSelected);
                if (offSelected != null) {
                    bool19 = offSelected.get();
                }
                if ((j & 394240) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool20 = bool19;
                    updateRegistration(10, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool21 = noiseControlVisible.get();
                    }
                    if ((j & 395264) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool22 = bool21;
                        updateRegistration(11, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool23 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool24 = bool23;
                            updateRegistration(12, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool25 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 393216) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 401408) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(13, itemDesc);
                                if (itemDesc != null) {
                                    str9 = itemDesc.get();
                                }
                                j8 = j7 & 409608;
                                if (j8 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111112 = str9;
                                    updateRegistration(14, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j8 != 0) {
                                        if (zSafeUnbox) {
                                            j10 = 16777216;
                                        } else {
                                            j10 = 8388608;
                                        }
                                        j9 = j7 | j10;
                                    } else {
                                        j9 = j7;
                                    }
                                    boolean z11111111116 = !zSafeUnbox;
                                    if ((j9 & 409608) != 0) {
                                        if (zSafeUnbox) {
                                            j9 |= 4194304;
                                        } else {
                                            j9 |= 2097152;
                                        }
                                    }
                                    Boolean bool211111111111111111118 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111111111111118;
                                    bool9 = bool13;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j9;
                                    str2 = str7;
                                    bool = bool16;
                                    z = z11111111116;
                                    str = str111111111111111111112;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool6 = bool25;
                                } else {
                                    String str111111111111111111113 = str9;
                                    Boolean bool211111111111111111119 = bool22;
                                    z2 = zSafeUnbox3;
                                    bool7 = bool211111111111111111119;
                                    str2 = str7;
                                    bool9 = bool13;
                                    newsPromptVisibility2 = newsPromptVisibility;
                                    bool = bool16;
                                    bool4 = bool18;
                                    bool10 = bool24;
                                    bool6 = bool25;
                                    str = str111111111111111111113;
                                    zSafeUnbox = false;
                                    z = false;
                                    z3 = z7;
                                    bool8 = bool14;
                                    str4 = str8;
                                    f = f3;
                                    str3 = str6;
                                    bool2 = bool20;
                                    j5 = j7;
                                }
                            } else {
                                bool25 = bool25;
                                j7 = j;
                            }
                            str9 = null;
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z11111111117 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111111111110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z11111111117;
                                str = str111111111111111111114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111111111115 = str9;
                                Boolean bool2111111111111111111111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111111111115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool24 = bool23;
                        }
                        bool25 = null;
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111116 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z11111111118 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111111111112 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111112;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z11111111118;
                                str = str111111111111111111116;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111111111117 = str9;
                                Boolean bool2111111111111111111113 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111113;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111111111117;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111118 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z11111111119 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111111111114 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111114;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z11111111119;
                            str = str111111111111111111118;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111111111111111111119 = str9;
                            Boolean bool2111111111111111111115 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111115;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111111111111111111119;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool22 = bool21;
                    }
                    bool23 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111110 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111111111110 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111111111116 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111116;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111111111110;
                                str = str1111111111111111111110;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111111111111111111 = str9;
                                Boolean bool2111111111111111111117 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111117;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111111111111111111;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111112 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111111111 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111111111118 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111118;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111111111;
                            str = str1111111111111111111112;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111111111111113 = str9;
                            Boolean bool2111111111111111111119 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111119;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111111111111113;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111114 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111111112 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111111111111110 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111111110;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111111112;
                            str = str1111111111111111111114;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111111111111115 = str9;
                            Boolean bool21111111111111111111111 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111111111;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111111111111115;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111116 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z111111111113 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111111111111111111112 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111112;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z111111111113;
                        str = str1111111111111111111116;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str1111111111111111111117 = str9;
                        Boolean bool21111111111111111111113 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111113;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str1111111111111111111117;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool20 = bool19;
                }
                bool21 = null;
                if ((j & 395264) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool22 = bool21;
                    updateRegistration(11, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool23 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111118 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z111111111114 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool21111111111111111111114 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111111111114;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z111111111114;
                                str = str1111111111111111111118;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str1111111111111111111119 = str9;
                                Boolean bool21111111111111111111115 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool21111111111111111111115;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str1111111111111111111119;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111111115 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111111111111116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111111116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111111115;
                            str = str11111111111111111111110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111111111111 = str9;
                            Boolean bool21111111111111111111117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111111117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111111111111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111112 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111111116 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111111111111118 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111111118;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111111116;
                            str = str11111111111111111111112;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111111111113 = str9;
                            Boolean bool21111111111111111111119 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111111119;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111111111113;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111114 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z111111111117 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111111111111110 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111110;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z111111111117;
                        str = str11111111111111111111114;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111111111115 = str9;
                        Boolean bool211111111111111111111111 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111111;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111111111115;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool22 = bool21;
                }
                bool23 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool24 = bool23;
                    updateRegistration(12, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool25 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111116 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z111111111118 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool211111111111111111111112 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111111111111111112;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z111111111118;
                            str = str11111111111111111111116;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111111111117 = str9;
                            Boolean bool211111111111111111111113 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool211111111111111111111113;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111111111117;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111118 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z111111111119 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111111111111114 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111114;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z111111111119;
                        str = str11111111111111111111118;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111111111119 = str9;
                        Boolean bool211111111111111111111115 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111115;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111111111119;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool24 = bool23;
                }
                bool25 = null;
                if ((j & 393216) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 401408) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(13, itemDesc);
                    if (itemDesc != null) {
                        str9 = itemDesc.get();
                    }
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str111111111111111111111110 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z1111111111110 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111111111111116 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111116;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z1111111111110;
                        str = str111111111111111111111110;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str111111111111111111111111 = str9;
                        Boolean bool211111111111111111111117 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111117;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str111111111111111111111111;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool25 = bool25;
                    j7 = j;
                }
                str9 = null;
                j8 = j7 & 409608;
                if (j8 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111112 = str9;
                    updateRegistration(14, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j8 != 0) {
                        if (zSafeUnbox) {
                            j10 = 16777216;
                        } else {
                            j10 = 8388608;
                        }
                        j9 = j7 | j10;
                    } else {
                        j9 = j7;
                    }
                    boolean z1111111111111 = !zSafeUnbox;
                    if ((j9 & 409608) != 0) {
                        if (zSafeUnbox) {
                            j9 |= 4194304;
                        } else {
                            j9 |= 2097152;
                        }
                    }
                    Boolean bool211111111111111111111118 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111111118;
                    bool9 = bool13;
                    bool4 = bool18;
                    bool10 = bool24;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j9;
                    str2 = str7;
                    bool = bool16;
                    z = z1111111111111;
                    str = str111111111111111111111112;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool6 = bool25;
                } else {
                    String str111111111111111111111113 = str9;
                    Boolean bool211111111111111111111119 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111111119;
                    str2 = str7;
                    bool9 = bool13;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool16;
                    bool4 = bool18;
                    bool10 = bool24;
                    bool6 = bool25;
                    str = str111111111111111111111113;
                    zSafeUnbox = false;
                    z = false;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j7;
                }
            } else {
                bool18 = bool17;
            }
            bool19 = null;
            if ((j & 394240) != 0) {
                if (controlOperationViewModel != null) {
                    noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                } else {
                    noiseControlVisible = null;
                }
                bool20 = bool19;
                updateRegistration(10, noiseControlVisible);
                if (noiseControlVisible != null) {
                    bool21 = noiseControlVisible.get();
                }
                if ((j & 395264) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool22 = bool21;
                    updateRegistration(11, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool23 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool24 = bool23;
                        updateRegistration(12, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool25 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 393216) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 401408) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(13, itemDesc);
                            if (itemDesc != null) {
                                str9 = itemDesc.get();
                            }
                            j8 = j7 & 409608;
                            if (j8 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111111114 = str9;
                                updateRegistration(14, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j8 != 0) {
                                    if (zSafeUnbox) {
                                        j10 = 16777216;
                                    } else {
                                        j10 = 8388608;
                                    }
                                    j9 = j7 | j10;
                                } else {
                                    j9 = j7;
                                }
                                boolean z1111111111112 = !zSafeUnbox;
                                if ((j9 & 409608) != 0) {
                                    if (zSafeUnbox) {
                                        j9 |= 4194304;
                                    } else {
                                        j9 |= 2097152;
                                    }
                                }
                                Boolean bool2111111111111111111111110 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111111110;
                                bool9 = bool13;
                                bool4 = bool18;
                                bool10 = bool24;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j9;
                                str2 = str7;
                                bool = bool16;
                                z = z1111111111112;
                                str = str111111111111111111111114;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool6 = bool25;
                            } else {
                                String str111111111111111111111115 = str9;
                                Boolean bool2111111111111111111111111 = bool22;
                                z2 = zSafeUnbox3;
                                bool7 = bool2111111111111111111111111;
                                str2 = str7;
                                bool9 = bool13;
                                newsPromptVisibility2 = newsPromptVisibility;
                                bool = bool16;
                                bool4 = bool18;
                                bool10 = bool24;
                                bool6 = bool25;
                                str = str111111111111111111111115;
                                zSafeUnbox = false;
                                z = false;
                                z3 = z7;
                                bool8 = bool14;
                                str4 = str8;
                                f = f3;
                                str3 = str6;
                                bool2 = bool20;
                                j5 = j7;
                            }
                        } else {
                            bool25 = bool25;
                            j7 = j;
                        }
                        str9 = null;
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111111116 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111111111113 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111111111111112 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111111112;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111111111113;
                            str = str111111111111111111111116;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111111111111111111111117 = str9;
                            Boolean bool2111111111111111111111113 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111111113;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111111111111111111111117;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool24 = bool23;
                    }
                    bool25 = null;
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111111118 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111111111114 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111111111111114 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111111114;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111111111114;
                            str = str111111111111111111111118;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str111111111111111111111119 = str9;
                            Boolean bool2111111111111111111111115 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111111115;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str111111111111111111111119;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111110 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z1111111111115 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool2111111111111111111111116 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool2111111111111111111111116;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z1111111111115;
                        str = str1111111111111111111111110;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str1111111111111111111111111 = str9;
                        Boolean bool2111111111111111111111117 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool2111111111111111111111117;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str1111111111111111111111111;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool22 = bool21;
                }
                bool23 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool24 = bool23;
                    updateRegistration(12, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool25 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111112 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z1111111111116 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool2111111111111111111111118 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111111118;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z1111111111116;
                            str = str1111111111111111111111112;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str1111111111111111111111113 = str9;
                            Boolean bool2111111111111111111111119 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool2111111111111111111111119;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str1111111111111111111111113;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111114 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z1111111111117 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111111111111111111111110 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111111110;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z1111111111117;
                        str = str1111111111111111111111114;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str1111111111111111111111115 = str9;
                        Boolean bool21111111111111111111111111 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111111111;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str1111111111111111111111115;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool24 = bool23;
                }
                bool25 = null;
                if ((j & 393216) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 401408) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(13, itemDesc);
                    if (itemDesc != null) {
                        str9 = itemDesc.get();
                    }
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111116 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z1111111111118 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111111111111111111111112 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111111112;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z1111111111118;
                        str = str1111111111111111111111116;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str1111111111111111111111117 = str9;
                        Boolean bool21111111111111111111111113 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111111113;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str1111111111111111111111117;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool25 = bool25;
                    j7 = j;
                }
                str9 = null;
                j8 = j7 & 409608;
                if (j8 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str1111111111111111111111118 = str9;
                    updateRegistration(14, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j8 != 0) {
                        if (zSafeUnbox) {
                            j10 = 16777216;
                        } else {
                            j10 = 8388608;
                        }
                        j9 = j7 | j10;
                    } else {
                        j9 = j7;
                    }
                    boolean z1111111111119 = !zSafeUnbox;
                    if ((j9 & 409608) != 0) {
                        if (zSafeUnbox) {
                            j9 |= 4194304;
                        } else {
                            j9 |= 2097152;
                        }
                    }
                    Boolean bool21111111111111111111111114 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool21111111111111111111111114;
                    bool9 = bool13;
                    bool4 = bool18;
                    bool10 = bool24;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j9;
                    str2 = str7;
                    bool = bool16;
                    z = z1111111111119;
                    str = str1111111111111111111111118;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool6 = bool25;
                } else {
                    String str1111111111111111111111119 = str9;
                    Boolean bool21111111111111111111111115 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool21111111111111111111111115;
                    str2 = str7;
                    bool9 = bool13;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool16;
                    bool4 = bool18;
                    bool10 = bool24;
                    bool6 = bool25;
                    str = str1111111111111111111111119;
                    zSafeUnbox = false;
                    z = false;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j7;
                }
            } else {
                bool20 = bool19;
            }
            bool21 = null;
            if ((j & 395264) != 0) {
                if (controlOperationViewModel != null) {
                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                } else {
                    noiseCancellationSelected = null;
                }
                bool22 = bool21;
                updateRegistration(11, noiseCancellationSelected);
                if (noiseCancellationSelected != null) {
                    bool23 = noiseCancellationSelected.get();
                }
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool24 = bool23;
                    updateRegistration(12, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool25 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 393216) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 401408) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(13, itemDesc);
                        if (itemDesc != null) {
                            str9 = itemDesc.get();
                        }
                        j8 = j7 & 409608;
                        if (j8 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111111110 = str9;
                            updateRegistration(14, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j8 != 0) {
                                if (zSafeUnbox) {
                                    j10 = 16777216;
                                } else {
                                    j10 = 8388608;
                                }
                                j9 = j7 | j10;
                            } else {
                                j9 = j7;
                            }
                            boolean z11111111111110 = !zSafeUnbox;
                            if ((j9 & 409608) != 0) {
                                if (zSafeUnbox) {
                                    j9 |= 4194304;
                                } else {
                                    j9 |= 2097152;
                                }
                            }
                            Boolean bool21111111111111111111111116 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111111111116;
                            bool9 = bool13;
                            bool4 = bool18;
                            bool10 = bool24;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j9;
                            str2 = str7;
                            bool = bool16;
                            z = z11111111111110;
                            str = str11111111111111111111111110;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool6 = bool25;
                        } else {
                            String str11111111111111111111111111 = str9;
                            Boolean bool21111111111111111111111117 = bool22;
                            z2 = zSafeUnbox3;
                            bool7 = bool21111111111111111111111117;
                            str2 = str7;
                            bool9 = bool13;
                            newsPromptVisibility2 = newsPromptVisibility;
                            bool = bool16;
                            bool4 = bool18;
                            bool10 = bool24;
                            bool6 = bool25;
                            str = str11111111111111111111111111;
                            zSafeUnbox = false;
                            z = false;
                            z3 = z7;
                            bool8 = bool14;
                            str4 = str8;
                            f = f3;
                            str3 = str6;
                            bool2 = bool20;
                            j5 = j7;
                        }
                    } else {
                        bool25 = bool25;
                        j7 = j;
                    }
                    str9 = null;
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111112 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111111111111 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool21111111111111111111111118 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111111118;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111111111111;
                        str = str11111111111111111111111112;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111111111111113 = str9;
                        Boolean bool21111111111111111111111119 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool21111111111111111111111119;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111111111111113;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool24 = bool23;
                }
                bool25 = null;
                if ((j & 393216) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 401408) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(13, itemDesc);
                    if (itemDesc != null) {
                        str9 = itemDesc.get();
                    }
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111114 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111111111112 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111111111111111110 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111111110;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111111111112;
                        str = str11111111111111111111111114;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111111111111115 = str9;
                        Boolean bool211111111111111111111111111 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111111111;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111111111111115;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool25 = bool25;
                    j7 = j;
                }
                str9 = null;
                j8 = j7 & 409608;
                if (j8 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str11111111111111111111111116 = str9;
                    updateRegistration(14, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j8 != 0) {
                        if (zSafeUnbox) {
                            j10 = 16777216;
                        } else {
                            j10 = 8388608;
                        }
                        j9 = j7 | j10;
                    } else {
                        j9 = j7;
                    }
                    boolean z11111111111113 = !zSafeUnbox;
                    if ((j9 & 409608) != 0) {
                        if (zSafeUnbox) {
                            j9 |= 4194304;
                        } else {
                            j9 |= 2097152;
                        }
                    }
                    Boolean bool211111111111111111111111112 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111111111112;
                    bool9 = bool13;
                    bool4 = bool18;
                    bool10 = bool24;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j9;
                    str2 = str7;
                    bool = bool16;
                    z = z11111111111113;
                    str = str11111111111111111111111116;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool6 = bool25;
                } else {
                    String str11111111111111111111111117 = str9;
                    Boolean bool211111111111111111111111113 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111111111113;
                    str2 = str7;
                    bool9 = bool13;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool16;
                    bool4 = bool18;
                    bool10 = bool24;
                    bool6 = bool25;
                    str = str11111111111111111111111117;
                    zSafeUnbox = false;
                    z = false;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j7;
                }
            } else {
                bool22 = bool21;
            }
            bool23 = null;
            if ((j & j2) != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                } else {
                    voiceAssistantDefaultSelected = null;
                }
                bool24 = bool23;
                updateRegistration(12, voiceAssistantDefaultSelected);
                if (voiceAssistantDefaultSelected != null) {
                    bool25 = voiceAssistantDefaultSelected.get();
                }
                if ((j & 393216) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 401408) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(13, itemDesc);
                    if (itemDesc != null) {
                        str9 = itemDesc.get();
                    }
                    j8 = j7 & 409608;
                    if (j8 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111118 = str9;
                        updateRegistration(14, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j8 != 0) {
                            if (zSafeUnbox) {
                                j10 = 16777216;
                            } else {
                                j10 = 8388608;
                            }
                            j9 = j7 | j10;
                        } else {
                            j9 = j7;
                        }
                        boolean z11111111111114 = !zSafeUnbox;
                        if ((j9 & 409608) != 0) {
                            if (zSafeUnbox) {
                                j9 |= 4194304;
                            } else {
                                j9 |= 2097152;
                            }
                        }
                        Boolean bool211111111111111111111111114 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111111114;
                        bool9 = bool13;
                        bool4 = bool18;
                        bool10 = bool24;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j9;
                        str2 = str7;
                        bool = bool16;
                        z = z11111111111114;
                        str = str11111111111111111111111118;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool6 = bool25;
                    } else {
                        String str11111111111111111111111119 = str9;
                        Boolean bool211111111111111111111111115 = bool22;
                        z2 = zSafeUnbox3;
                        bool7 = bool211111111111111111111111115;
                        str2 = str7;
                        bool9 = bool13;
                        newsPromptVisibility2 = newsPromptVisibility;
                        bool = bool16;
                        bool4 = bool18;
                        bool10 = bool24;
                        bool6 = bool25;
                        str = str11111111111111111111111119;
                        zSafeUnbox = false;
                        z = false;
                        z3 = z7;
                        bool8 = bool14;
                        str4 = str8;
                        f = f3;
                        str3 = str6;
                        bool2 = bool20;
                        j5 = j7;
                    }
                } else {
                    bool25 = bool25;
                    j7 = j;
                }
                str9 = null;
                j8 = j7 & 409608;
                if (j8 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111111110 = str9;
                    updateRegistration(14, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j8 != 0) {
                        if (zSafeUnbox) {
                            j10 = 16777216;
                        } else {
                            j10 = 8388608;
                        }
                        j9 = j7 | j10;
                    } else {
                        j9 = j7;
                    }
                    boolean z11111111111115 = !zSafeUnbox;
                    if ((j9 & 409608) != 0) {
                        if (zSafeUnbox) {
                            j9 |= 4194304;
                        } else {
                            j9 |= 2097152;
                        }
                    }
                    Boolean bool211111111111111111111111116 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111111111116;
                    bool9 = bool13;
                    bool4 = bool18;
                    bool10 = bool24;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j9;
                    str2 = str7;
                    bool = bool16;
                    z = z11111111111115;
                    str = str111111111111111111111111110;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool6 = bool25;
                } else {
                    String str111111111111111111111111111 = str9;
                    Boolean bool211111111111111111111111117 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111111111117;
                    str2 = str7;
                    bool9 = bool13;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool16;
                    bool4 = bool18;
                    bool10 = bool24;
                    bool6 = bool25;
                    str = str111111111111111111111111111;
                    zSafeUnbox = false;
                    z = false;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j7;
                }
            } else {
                bool24 = bool23;
            }
            bool25 = null;
            if ((j & 393216) != 0) {
                direction = null;
            } else {
                direction = null;
            }
            if ((j & 401408) != 0) {
                if (controlOperationViewModel != null) {
                    itemDesc = controlOperationViewModel.getItemDesc();
                } else {
                    itemDesc = null;
                }
                j7 = j;
                updateRegistration(13, itemDesc);
                if (itemDesc != null) {
                    str9 = itemDesc.get();
                }
                j8 = j7 & 409608;
                if (j8 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111111112 = str9;
                    updateRegistration(14, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j8 != 0) {
                        if (zSafeUnbox) {
                            j10 = 16777216;
                        } else {
                            j10 = 8388608;
                        }
                        j9 = j7 | j10;
                    } else {
                        j9 = j7;
                    }
                    boolean z11111111111116 = !zSafeUnbox;
                    if ((j9 & 409608) != 0) {
                        if (zSafeUnbox) {
                            j9 |= 4194304;
                        } else {
                            j9 |= 2097152;
                        }
                    }
                    Boolean bool211111111111111111111111118 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111111111118;
                    bool9 = bool13;
                    bool4 = bool18;
                    bool10 = bool24;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j9;
                    str2 = str7;
                    bool = bool16;
                    z = z11111111111116;
                    str = str111111111111111111111111112;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool6 = bool25;
                } else {
                    String str111111111111111111111111113 = str9;
                    Boolean bool211111111111111111111111119 = bool22;
                    z2 = zSafeUnbox3;
                    bool7 = bool211111111111111111111111119;
                    str2 = str7;
                    bool9 = bool13;
                    newsPromptVisibility2 = newsPromptVisibility;
                    bool = bool16;
                    bool4 = bool18;
                    bool10 = bool24;
                    bool6 = bool25;
                    str = str111111111111111111111111113;
                    zSafeUnbox = false;
                    z = false;
                    z3 = z7;
                    bool8 = bool14;
                    str4 = str8;
                    f = f3;
                    str3 = str6;
                    bool2 = bool20;
                    j5 = j7;
                }
            } else {
                bool25 = bool25;
                j7 = j;
            }
            str9 = null;
            j8 = j7 & 409608;
            if (j8 != 0) {
                if (controlOperationViewModel != null) {
                    enable = controlOperationViewModel.getEnable();
                } else {
                    enable = null;
                }
                String str111111111111111111111111114 = str9;
                updateRegistration(14, enable);
                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                if (j8 != 0) {
                    if (zSafeUnbox) {
                        j10 = 16777216;
                    } else {
                        j10 = 8388608;
                    }
                    j9 = j7 | j10;
                } else {
                    j9 = j7;
                }
                boolean z11111111111117 = !zSafeUnbox;
                if ((j9 & 409608) != 0) {
                    if (zSafeUnbox) {
                        j9 |= 4194304;
                    } else {
                        j9 |= 2097152;
                    }
                }
                Boolean bool2111111111111111111111111110 = bool22;
                z2 = zSafeUnbox3;
                bool7 = bool2111111111111111111111111110;
                bool9 = bool13;
                bool4 = bool18;
                bool10 = bool24;
                z3 = z7;
                bool8 = bool14;
                str4 = str8;
                f = f3;
                str3 = str6;
                bool2 = bool20;
                j5 = j9;
                str2 = str7;
                bool = bool16;
                z = z11111111111117;
                str = str111111111111111111111111114;
                newsPromptVisibility2 = newsPromptVisibility;
                bool6 = bool25;
            } else {
                String str111111111111111111111111115 = str9;
                Boolean bool2111111111111111111111111111 = bool22;
                z2 = zSafeUnbox3;
                bool7 = bool2111111111111111111111111111;
                str2 = str7;
                bool9 = bool13;
                newsPromptVisibility2 = newsPromptVisibility;
                bool = bool16;
                bool4 = bool18;
                bool10 = bool24;
                bool6 = bool25;
                str = str111111111111111111111111115;
                zSafeUnbox = false;
                z = false;
                z3 = z7;
                bool8 = bool14;
                str4 = str8;
                f = f3;
                str3 = str6;
                bool2 = bool20;
                j5 = j7;
            }
        } else {
            controlOperationViewModel = controlOperationViewModel2;
            j2 = 397312;
            j3 = 393344;
            j4 = 393280;
            j5 = j;
            str = null;
            str2 = null;
            bool = null;
            bool2 = null;
            bool3 = null;
            bool4 = null;
            bool5 = null;
            str3 = null;
            bool6 = null;
            str4 = null;
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
            z3 = false;
        }
        if ((j5 & 12582912) != 0) {
            if (controlOperationViewModel != null) {
                newsPromptVisibility2 = controlOperationViewModel.getNewsPromptVisibility();
            }
            bool11 = bool7;
            ObservableField<Boolean> observableField = newsPromptVisibility2;
            str5 = str4;
            updateRegistration(3, observableField);
            bool12 = observableField != null ? observableField.get() : bool8;
            zSafeUnbox2 = ViewDataBinding.safeUnbox(bool12);
            z4 = (j5 & 4194304) != 0 ? !zSafeUnbox2 : false;
            j6 = j5 & 409608;
            if (j6 != 0) {
                if (!z) {
                    z4 = false;
                }
                if (zSafeUnbox) {
                    z6 = true;
                } else {
                    z6 = zSafeUnbox2;
                }
                z5 = z6;
            } else {
                z4 = false;
                z5 = false;
            }
            if ((j5 & 262144) != 0) {
                BindingAdapter.onClick(this.mboundView10, this.mCallback67);
                BindingAdapter.onClick((ViewGroup) this.mboundView12, this.mCallback68);
                BindingAdapter.onClick(this.mboundView15, this.mCallback69);
                BindingAdapter.onClick(this.mboundView8, this.mCallback65);
                BindingAdapter.onClick(this.mboundView9, this.mCallback66);
            }
            if ((j5 & 393728) != 0) {
                BindingAdapter.viewSelected(this.mboundView10, bool2);
            }
            if ((j5 & 393232) != 0) {
                BindingAdapter.goneUnless(this.mboundView11, bool3);
            }
            if ((j5 & 393220) != 0) {
                if (getBuildSdkInt() >= 11) {
                    this.mboundView12.setAlpha(f);
                }
                BindingAdapter.chatGptOption(this.mboundView13, bool5);
                BindingAdapter.goneUnless(this.mboundView14, Boolean.valueOf(z3));
            }
            if ((j5 & 393472) != 0) {
                BindingAdapter.viewSelected(this.mboundView13, bool4);
            }
            if ((j5 & 393217) != 0) {
                TextViewBindingAdapter.setText(this.mboundView14, str3);
            }
            if ((j5 & j2) != 0) {
                BindingAdapter.viewSelected(this.mboundView15, bool6);
            }
            if ((j5 & 393216) != 0) {
                BindingAdapter.viewRadius(this.mboundView2, direction);
            }
            if ((j5 & 393224) != 0) {
                if (getBuildSdkInt() >= 11) {
                    this.mboundView3.setAlpha(f2);
                }
                BindingAdapter.goneUnless(this.mboundView6, bool12);
            }
            if ((j5 & 401408) != 0 && getBuildSdkInt() >= 4) {
                this.mboundView3.setContentDescription(str);
            }
            if ((j5 & 409600) != 0) {
                ViewBindingAdapter.setOnClick(this.mboundView3, this.mCallback64, zSafeUnbox);
            }
            if ((j5 & 393248) != 0) {
                TextViewBindingAdapter.setText(this.mboundView4, str2);
            }
            if (j6 != 0) {
                BindingAdapter.invisibleUnless(this.mboundView5, Boolean.valueOf(z5));
                BindingAdapter.goneUnless(this.notTitle, Boolean.valueOf(z4));
            }
            if ((j5 & j3) != 0) {
                BindingAdapter.viewSelected(this.mboundView5, bool);
            }
            if ((j5 & j4) != 0) {
                TextViewBindingAdapter.setText(this.mboundView6, str5);
            }
            if ((j5 & 394240) != 0) {
                BindingAdapter.goneUnless(this.mboundView7, bool11);
            }
            if ((j5 & 393218) != 0) {
                BindingAdapter.viewSelected(this.mboundView8, bool9);
            }
            if ((j5 & 395264) != 0) {
                BindingAdapter.viewSelected(this.mboundView9, bool10);
            }
        }
        str5 = str4;
        bool11 = bool7;
        bool12 = bool8;
        zSafeUnbox2 = z2;
        j6 = j5 & 409608;
        if (j6 != 0) {
            if (!z) {
                z4 = false;
            }
            if (zSafeUnbox) {
                z6 = true;
            } else {
                z6 = zSafeUnbox2;
            }
            z5 = z6;
        } else {
            z4 = false;
            z5 = false;
        }
        if ((j5 & 262144) != 0) {
            BindingAdapter.onClick(this.mboundView10, this.mCallback67);
            BindingAdapter.onClick((ViewGroup) this.mboundView12, this.mCallback68);
            BindingAdapter.onClick(this.mboundView15, this.mCallback69);
            BindingAdapter.onClick(this.mboundView8, this.mCallback65);
            BindingAdapter.onClick(this.mboundView9, this.mCallback66);
        }
        if ((j5 & 393728) != 0) {
            BindingAdapter.viewSelected(this.mboundView10, bool2);
        }
        if ((j5 & 393232) != 0) {
            BindingAdapter.goneUnless(this.mboundView11, bool3);
        }
        if ((j5 & 393220) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView12.setAlpha(f);
            }
            BindingAdapter.chatGptOption(this.mboundView13, bool5);
            BindingAdapter.goneUnless(this.mboundView14, Boolean.valueOf(z3));
        }
        if ((j5 & 393472) != 0) {
            BindingAdapter.viewSelected(this.mboundView13, bool4);
        }
        if ((j5 & 393217) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str3);
        }
        if ((j5 & j2) != 0) {
            BindingAdapter.viewSelected(this.mboundView15, bool6);
        }
        if ((j5 & 393216) != 0) {
            BindingAdapter.viewRadius(this.mboundView2, direction);
        }
        if ((j5 & 393224) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView3.setAlpha(f2);
            }
            BindingAdapter.goneUnless(this.mboundView6, bool12);
        }
        if ((j5 & 401408) != 0) {
            this.mboundView3.setContentDescription(str);
        }
        if ((j5 & 409600) != 0) {
            ViewBindingAdapter.setOnClick(this.mboundView3, this.mCallback64, zSafeUnbox);
        }
        if ((j5 & 393248) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str2);
        }
        if (j6 != 0) {
            BindingAdapter.invisibleUnless(this.mboundView5, Boolean.valueOf(z5));
            BindingAdapter.goneUnless(this.notTitle, Boolean.valueOf(z4));
        }
        if ((j5 & j3) != 0) {
            BindingAdapter.viewSelected(this.mboundView5, bool);
        }
        if ((j5 & j4) != 0) {
            TextViewBindingAdapter.setText(this.mboundView6, str5);
        }
        if ((j5 & 394240) != 0) {
            BindingAdapter.goneUnless(this.mboundView7, bool11);
        }
        if ((j5 & 393218) != 0) {
            BindingAdapter.viewSelected(this.mboundView8, bool9);
        }
        if ((j5 & 395264) != 0) {
            BindingAdapter.viewSelected(this.mboundView9, bool10);
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
