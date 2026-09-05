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
import com.nothing.elekid.control.ControlItemViewModel;
import com.nothing.elekid.control.ControlOperationActivity;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class ElekidControlDialogItemBindingImpl extends ElekidControlDialogItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback20;
    private final View.OnClickListener mCallback21;
    private final View.OnClickListener mCallback22;
    private final View.OnClickListener mCallback23;
    private final View.OnClickListener mCallback24;
    private final View.OnClickListener mCallback25;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final LinearLayoutCompat mboundView12;
    private final LinearLayout mboundView13;
    private final TextView mboundView14;
    private final TextView mboundView15;
    private final TextView mboundView16;
    private final View mboundView17;
    private final RoundLinearLayout mboundView2;
    private final LinearLayoutCompat mboundView3;
    private final AppCompatTextView mboundView4;
    private final AppCompatImageView mboundView5;
    private final TextView mboundView7;
    private final LinearLayoutCompat mboundView8;
    private final TextView mboundView9;

    public ElekidControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private ElekidControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 19, (AppCompatImageView) bindings[6], (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        this.ivArrowRight.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[11];
        this.mboundView11 = textView2;
        textView2.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[12];
        this.mboundView12 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[13];
        this.mboundView13 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView3 = (TextView) bindings[14];
        this.mboundView14 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[15];
        this.mboundView15 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[16];
        this.mboundView16 = textView5;
        textView5.setTag(null);
        View view = (View) bindings[17];
        this.mboundView17 = view;
        view.setTag(null);
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
        TextView textView6 = (TextView) bindings[7];
        this.mboundView7 = textView6;
        textView6.setTag(null);
        LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) bindings[8];
        this.mboundView8 = linearLayoutCompat3;
        linearLayoutCompat3.setTag(null);
        TextView textView7 = (TextView) bindings[9];
        this.mboundView9 = textView7;
        textView7.setTag(null);
        this.notTitle.setTag(null);
        setRootTag(root);
        this.mCallback23 = new OnClickListener(this, 4);
        this.mCallback24 = new OnClickListener(this, 5);
        this.mCallback25 = new OnClickListener(this, 6);
        this.mCallback21 = new OnClickListener(this, 2);
        this.mCallback20 = new OnClickListener(this, 1);
        this.mCallback22 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4194304L;
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

    @Override // com.nothing.ear.databinding.ElekidControlDialogItemBinding
    public void setItemViewModel(ControlItemViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.ElekidControlDialogItemBinding
    public void setEventHandler(ControlOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.ElekidControlDialogItemBinding
    public void setViewModel(ControlOperationViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
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
                return onChangeViewModelIsMagicGesture((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelVoiceAssistantEnable((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelNewsPromptVisibility((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelVoiceAssistantVisible((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelOperationName((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelNewsPromptName((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelSelected((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelVoiceAssistantChatGptSelected((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelOffSelected((ObservableField) object, fieldId);
            case 11:
                return onChangeViewModelIsMagicGesture1((ObservableField) object, fieldId);
            case 12:
                return onChangeViewModelNoiseControlVisible((ObservableField) object, fieldId);
            case 13:
                return onChangeViewModelNoiseCancellationSelected((ObservableField) object, fieldId);
            case 14:
                return onChangeViewModelVoiceAssistantDefaultSelected((ObservableField) object, fieldId);
            case 15:
                return onChangeViewModelItemDesc((ObservableField) object, fieldId);
            case 16:
                return onChangeViewModelEssentialSpacePromptVisibility((ObservableField) object, fieldId);
            case 17:
                return onChangeViewModelEnable((ObservableField) object, fieldId);
            case 18:
                return onChangeViewModelNothingRadioPromptVisibility((ObservableField) object, fieldId);
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

    private boolean onChangeViewModelIsMagicGesture(ObservableField<Boolean> ViewModelIsMagicGesture, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantEnable(ObservableField<Boolean> ViewModelVoiceAssistantEnable, int fieldId) {
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

    private boolean onChangeViewModelVoiceAssistantVisible(ObservableField<Boolean> ViewModelVoiceAssistantVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelOperationName(ObservableField<String> ViewModelOperationName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelNewsPromptName(ObservableField<String> ViewModelNewsPromptName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelSelected(ObservableField<Boolean> ViewModelSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantChatGptSelected(ObservableField<Boolean> ViewModelVoiceAssistantChatGptSelected, int fieldId) {
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

    private boolean onChangeViewModelIsMagicGesture1(ObservableField<Boolean> ViewModelIsMagicGesture, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseControlVisible(ObservableField<Boolean> ViewModelNoiseControlVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseCancellationSelected(ObservableField<Boolean> ViewModelNoiseCancellationSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantDefaultSelected(ObservableField<Boolean> ViewModelVoiceAssistantDefaultSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeViewModelItemDesc(ObservableField<String> ViewModelItemDesc, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeViewModelEssentialSpacePromptVisibility(ObservableField<Boolean> ViewModelEssentialSpacePromptVisibility, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeViewModelEnable(ObservableField<Boolean> ViewModelEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeViewModelNothingRadioPromptVisibility(ObservableField<Boolean> ViewModelNothingRadioPromptVisibility, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0186  */
    /* JADX WARN: Code duplicated, block: B:103:0x0191 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x0193  */
    /* JADX WARN: Code duplicated, block: B:105:0x0198  */
    /* JADX WARN: Code duplicated, block: B:108:0x019f  */
    /* JADX WARN: Code duplicated, block: B:109:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:110:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:113:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:115:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:119:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:123:0x01de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:125:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:128:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:133:0x0204 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x0206  */
    /* JADX WARN: Code duplicated, block: B:135:0x020b  */
    /* JADX WARN: Code duplicated, block: B:138:0x0216  */
    /* JADX WARN: Code duplicated, block: B:139:0x021d  */
    /* JADX WARN: Code duplicated, block: B:143:0x022a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x022c  */
    /* JADX WARN: Code duplicated, block: B:145:0x0231  */
    /* JADX WARN: Code duplicated, block: B:148:0x023c  */
    /* JADX WARN: Code duplicated, block: B:149:0x0243  */
    /* JADX WARN: Code duplicated, block: B:153:0x0250 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x0252  */
    /* JADX WARN: Code duplicated, block: B:155:0x0257  */
    /* JADX WARN: Code duplicated, block: B:158:0x0262  */
    /* JADX WARN: Code duplicated, block: B:159:0x0269  */
    /* JADX WARN: Code duplicated, block: B:163:0x0276 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x0278  */
    /* JADX WARN: Code duplicated, block: B:165:0x027d  */
    /* JADX WARN: Code duplicated, block: B:168:0x0288  */
    /* JADX WARN: Code duplicated, block: B:169:0x028f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0058  */
    /* JADX WARN: Code duplicated, block: B:173:0x029c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:175:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:178:0x02ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:179:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:180:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:183:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:184:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:188:0x02db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:189:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:190:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:193:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:194:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:197:0x02fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:198:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:199:0x0304  */
    /* JADX WARN: Code duplicated, block: B:200:0x0307  */
    /* JADX WARN: Code duplicated, block: B:202:0x0327  */
    /* JADX WARN: Code duplicated, block: B:25:0x0077  */
    /* JADX WARN: Code duplicated, block: B:85:0x0152 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0154  */
    /* JADX WARN: Code duplicated, block: B:87:0x0159  */
    /* JADX WARN: Code duplicated, block: B:90:0x0161  */
    /* JADX WARN: Code duplicated, block: B:91:0x0168  */
    /* JADX WARN: Code duplicated, block: B:94:0x0170 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0172  */
    /* JADX WARN: Code duplicated, block: B:96:0x0177  */
    /* JADX WARN: Code duplicated, block: B:99:0x017f  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ControlOperationViewModel controlOperationViewModel;
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        String str;
        Boolean bool5;
        Boolean bool6;
        ControlRadius direction;
        String str2;
        String str3;
        Boolean bool7;
        Boolean bool8;
        String str4;
        Boolean bool9;
        ObservableField<Boolean> observableField;
        ObservableField<Boolean> selected;
        Boolean bool10;
        boolean zSafeUnbox;
        float f;
        boolean z2;
        boolean zSafeUnbox2;
        boolean zSafeUnbox3;
        boolean zSafeUnbox4;
        boolean z3;
        boolean zSafeUnbox5;
        float f2;
        boolean z4;
        boolean z5;
        String str5;
        ObservableField<Boolean> observableFieldIsMagicGesture;
        Boolean bool11;
        float f3;
        String str6;
        String str7;
        Boolean bool12;
        Boolean bool13;
        Boolean bool14;
        Boolean bool15;
        Boolean bool16;
        Boolean bool17;
        Boolean bool18;
        String str8;
        long j6;
        ObservableField<Boolean> enable;
        Boolean bool19;
        long j7;
        ObservableField<String> itemDesc;
        ObservableField<Boolean> voiceAssistantDefaultSelected;
        ObservableField<Boolean> noiseCancellationSelected;
        ObservableField<Boolean> noiseControlVisible;
        ObservableField<Boolean> observableFieldIsMagicGesture2;
        ObservableField<Boolean> offSelected;
        ObservableField<Boolean> voiceAssistantChatGptSelected;
        ObservableField<String> newsPromptName;
        ObservableField<String> operationName;
        ObservableField<Boolean> newsPromptVisibility;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlItemViewModel controlItemViewModel = this.mItemViewModel;
        ControlOperationActivity controlOperationActivity = this.mEventHandler;
        ControlOperationViewModel controlOperationViewModel2 = this.mViewModel;
        if ((6815743 & j) != 0) {
            if ((j & 6291457) == 0) {
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
            if ((j & 6291458) == 0) {
                bool8 = null;
            } else {
                ObservableField<Boolean> transSelected = controlOperationViewModel2 != null ? controlOperationViewModel2.getTransSelected() : null;
                updateRegistration(1, transSelected);
                if (transSelected != null) {
                    bool8 = transSelected.get();
                } else {
                    bool8 = null;
                }
            }
            if ((j & 6291460) != 0) {
                observableFieldIsMagicGesture = controlOperationViewModel2 != null ? controlOperationViewModel2.isMagicGesture() : null;
                j3 = 6291520;
                updateRegistration(2, observableFieldIsMagicGesture);
                bool11 = observableFieldIsMagicGesture != null ? observableFieldIsMagicGesture.get() : null;
            } else {
                j3 = 6291520;
                observableFieldIsMagicGesture = null;
                bool11 = null;
            }
            long j8 = j & 6291464;
            if (j8 != 0) {
                ObservableField<Boolean> voiceAssistantEnable = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantEnable() : null;
                j4 = 6291488;
                updateRegistration(3, voiceAssistantEnable);
                boolean zSafeUnbox6 = ViewDataBinding.safeUnbox(voiceAssistantEnable != null ? voiceAssistantEnable.get() : null);
                z2 = !zSafeUnbox6;
                boolean z6 = zSafeUnbox6;
                if (j8 != 0) {
                    j |= z6 ? 17179869184L : 8589934592L;
                }
                f3 = z6 ? 1.0f : 0.38f;
            } else {
                j4 = 6291488;
                f3 = 0.0f;
                z2 = false;
            }
            long j9 = j & 6619152;
            if (j9 != 0) {
                if (controlOperationViewModel2 != null) {
                    newsPromptVisibility = controlOperationViewModel2.getNewsPromptVisibility();
                    j2 = 6291464;
                } else {
                    j2 = 6291464;
                    newsPromptVisibility = null;
                }
                updateRegistration(4, newsPromptVisibility);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(newsPromptVisibility != null ? newsPromptVisibility.get() : null);
                if (j9 != 0) {
                    j = zSafeUnbox2 ? j | FileUtils.ONE_GB : j | 536870912;
                }
            } else {
                j2 = 6291464;
                zSafeUnbox2 = false;
            }
            if ((j & j4) != 0) {
                ObservableField<Boolean> voiceAssistantVisible = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantVisible() : null;
                z = true;
                updateRegistration(5, voiceAssistantVisible);
                if (voiceAssistantVisible != null) {
                    bool7 = voiceAssistantVisible.get();
                }
                if ((j & j3) == 0) {
                    str6 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        operationName = controlOperationViewModel2.getOperationName();
                    } else {
                        operationName = null;
                    }
                    updateRegistration(6, operationName);
                    if (operationName != null) {
                        str6 = operationName.get();
                    } else {
                        str6 = null;
                    }
                }
                if ((j & 6291584) == 0) {
                    str7 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        newsPromptName = controlOperationViewModel2.getNewsPromptName();
                    } else {
                        newsPromptName = null;
                    }
                    updateRegistration(7, newsPromptName);
                    if (newsPromptName != null) {
                        str7 = newsPromptName.get();
                    } else {
                        str7 = null;
                    }
                }
                if ((j & 6291712) != 0) {
                    if (controlOperationViewModel2 != null) {
                        selected = controlOperationViewModel2.getSelected();
                    } else {
                        selected = null;
                    }
                    updateRegistration(8, selected);
                    if (selected != null) {
                        bool12 = selected.get();
                    } else {
                        bool12 = null;
                    }
                } else {
                    selected = null;
                    bool12 = null;
                }
                if ((j & 6291968) != 0) {
                    if (controlOperationViewModel2 != null) {
                        voiceAssistantChatGptSelected = controlOperationViewModel2.getVoiceAssistantChatGptSelected();
                    } else {
                        voiceAssistantChatGptSelected = null;
                    }
                    controlOperationViewModel = controlOperationViewModel2;
                    updateRegistration(9, voiceAssistantChatGptSelected);
                    if (voiceAssistantChatGptSelected != null) {
                        bool13 = voiceAssistantChatGptSelected.get();
                    }
                    if ((j & 6292480) != 0) {
                        if (controlOperationViewModel != null) {
                            offSelected = controlOperationViewModel.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        bool = bool13;
                        updateRegistration(10, offSelected);
                        if (offSelected != null) {
                            bool14 = offSelected.get();
                        }
                        if ((j & 6293504) != 0) {
                            if (controlOperationViewModel != null) {
                                observableFieldIsMagicGesture2 = controlOperationViewModel.isMagicGesture();
                            } else {
                                observableFieldIsMagicGesture2 = null;
                            }
                            bool3 = bool14;
                            updateRegistration(11, observableFieldIsMagicGesture2);
                            if (observableFieldIsMagicGesture2 != null) {
                                bool15 = observableFieldIsMagicGesture2.get();
                            }
                            if ((j & 6295552) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                                } else {
                                    noiseControlVisible = null;
                                }
                                bool6 = bool15;
                                updateRegistration(12, noiseControlVisible);
                                if (noiseControlVisible != null) {
                                    bool16 = noiseControlVisible.get();
                                }
                                if ((j & 6299648) != 0) {
                                    if (controlOperationViewModel != null) {
                                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                    } else {
                                        noiseCancellationSelected = null;
                                    }
                                    bool5 = bool16;
                                    updateRegistration(13, noiseCancellationSelected);
                                    if (noiseCancellationSelected != null) {
                                        bool17 = noiseCancellationSelected.get();
                                    }
                                    if ((j & 6307840) != 0) {
                                        if (controlOperationViewModel != null) {
                                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                        } else {
                                            voiceAssistantDefaultSelected = null;
                                        }
                                        bool2 = bool17;
                                        updateRegistration(14, voiceAssistantDefaultSelected);
                                        if (voiceAssistantDefaultSelected != null) {
                                            bool18 = voiceAssistantDefaultSelected.get();
                                        }
                                        if ((j & 6291456) != 0 || controlOperationViewModel == null) {
                                            direction = null;
                                        } else {
                                            direction = controlOperationViewModel.getDirection();
                                        }
                                        if ((j & 6324224) != 0) {
                                            if (controlOperationViewModel != null) {
                                                itemDesc = controlOperationViewModel.getItemDesc();
                                            } else {
                                                itemDesc = null;
                                            }
                                            j5 = j;
                                            updateRegistration(15, itemDesc);
                                            if (itemDesc != null) {
                                                str8 = itemDesc.get();
                                            }
                                            j6 = j5 & 6422788;
                                            if (j6 != 0) {
                                                if (controlOperationViewModel != null) {
                                                    enable = controlOperationViewModel.getEnable();
                                                } else {
                                                    enable = null;
                                                }
                                                updateRegistration(17, enable);
                                                if (enable != null) {
                                                    bool19 = enable.get();
                                                } else {
                                                    bool19 = null;
                                                }
                                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                                if (j6 != 0) {
                                                    j7 = j5;
                                                } else if (zSafeUnbox) {
                                                    j7 = j5 | 16777216;
                                                } else {
                                                    j7 = j5 | 8388608;
                                                }
                                                str4 = str6;
                                                f = f3;
                                                j5 = j7;
                                            } else {
                                                str4 = str6;
                                                f = f3;
                                                zSafeUnbox = false;
                                            }
                                            observableField = observableFieldIsMagicGesture;
                                            bool10 = bool12;
                                            str2 = str7;
                                            bool9 = bool11;
                                            bool4 = bool18;
                                            str3 = str5;
                                            str = str8;
                                        } else {
                                            bool18 = bool18;
                                            j5 = j;
                                        }
                                        str8 = null;
                                        j6 = j5 & 6422788;
                                        if (j6 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            updateRegistration(17, enable);
                                            if (enable != null) {
                                                bool19 = enable.get();
                                            } else {
                                                bool19 = null;
                                            }
                                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                            if (j6 != 0) {
                                                j7 = j5;
                                            } else if (zSafeUnbox) {
                                                j7 = j5 | 16777216;
                                            } else {
                                                j7 = j5 | 8388608;
                                            }
                                            str4 = str6;
                                            f = f3;
                                            j5 = j7;
                                        } else {
                                            str4 = str6;
                                            f = f3;
                                            zSafeUnbox = false;
                                        }
                                        observableField = observableFieldIsMagicGesture;
                                        bool10 = bool12;
                                        str2 = str7;
                                        bool9 = bool11;
                                        bool4 = bool18;
                                        str3 = str5;
                                        str = str8;
                                    } else {
                                        bool2 = bool17;
                                    }
                                    bool18 = null;
                                    if ((j & 6291456) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 6324224) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j5 = j;
                                        updateRegistration(15, itemDesc);
                                        if (itemDesc != null) {
                                            str8 = itemDesc.get();
                                        }
                                        j6 = j5 & 6422788;
                                        if (j6 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            updateRegistration(17, enable);
                                            if (enable != null) {
                                                bool19 = enable.get();
                                            } else {
                                                bool19 = null;
                                            }
                                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                            if (j6 != 0) {
                                                j7 = j5;
                                            } else if (zSafeUnbox) {
                                                j7 = j5 | 16777216;
                                            } else {
                                                j7 = j5 | 8388608;
                                            }
                                            str4 = str6;
                                            f = f3;
                                            j5 = j7;
                                        } else {
                                            str4 = str6;
                                            f = f3;
                                            zSafeUnbox = false;
                                        }
                                        observableField = observableFieldIsMagicGesture;
                                        bool10 = bool12;
                                        str2 = str7;
                                        bool9 = bool11;
                                        bool4 = bool18;
                                        str3 = str5;
                                        str = str8;
                                    } else {
                                        bool18 = bool18;
                                        j5 = j;
                                    }
                                    str8 = null;
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool5 = bool16;
                                }
                                bool17 = null;
                                if ((j & 6307840) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool2 = bool17;
                                    updateRegistration(14, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool18 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 6291456) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 6324224) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j5 = j;
                                        updateRegistration(15, itemDesc);
                                        if (itemDesc != null) {
                                            str8 = itemDesc.get();
                                        }
                                        j6 = j5 & 6422788;
                                        if (j6 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            updateRegistration(17, enable);
                                            if (enable != null) {
                                                bool19 = enable.get();
                                            } else {
                                                bool19 = null;
                                            }
                                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                            if (j6 != 0) {
                                                j7 = j5;
                                            } else if (zSafeUnbox) {
                                                j7 = j5 | 16777216;
                                            } else {
                                                j7 = j5 | 8388608;
                                            }
                                            str4 = str6;
                                            f = f3;
                                            j5 = j7;
                                        } else {
                                            str4 = str6;
                                            f = f3;
                                            zSafeUnbox = false;
                                        }
                                        observableField = observableFieldIsMagicGesture;
                                        bool10 = bool12;
                                        str2 = str7;
                                        bool9 = bool11;
                                        bool4 = bool18;
                                        str3 = str5;
                                        str = str8;
                                    } else {
                                        bool18 = bool18;
                                        j5 = j;
                                    }
                                    str8 = null;
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool2 = bool17;
                                }
                                bool18 = null;
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool6 = bool15;
                            }
                            bool16 = null;
                            if ((j & 6299648) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool5 = bool16;
                                updateRegistration(13, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool17 = noiseCancellationSelected.get();
                                }
                                if ((j & 6307840) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool2 = bool17;
                                    updateRegistration(14, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool18 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 6291456) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 6324224) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j5 = j;
                                        updateRegistration(15, itemDesc);
                                        if (itemDesc != null) {
                                            str8 = itemDesc.get();
                                        }
                                        j6 = j5 & 6422788;
                                        if (j6 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            updateRegistration(17, enable);
                                            if (enable != null) {
                                                bool19 = enable.get();
                                            } else {
                                                bool19 = null;
                                            }
                                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                            if (j6 != 0) {
                                                j7 = j5;
                                            } else if (zSafeUnbox) {
                                                j7 = j5 | 16777216;
                                            } else {
                                                j7 = j5 | 8388608;
                                            }
                                            str4 = str6;
                                            f = f3;
                                            j5 = j7;
                                        } else {
                                            str4 = str6;
                                            f = f3;
                                            zSafeUnbox = false;
                                        }
                                        observableField = observableFieldIsMagicGesture;
                                        bool10 = bool12;
                                        str2 = str7;
                                        bool9 = bool11;
                                        bool4 = bool18;
                                        str3 = str5;
                                        str = str8;
                                    } else {
                                        bool18 = bool18;
                                        j5 = j;
                                    }
                                    str8 = null;
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool2 = bool17;
                                }
                                bool18 = null;
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool5 = bool16;
                            }
                            bool17 = null;
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool3 = bool14;
                        }
                        bool15 = null;
                        if ((j & 6295552) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool6 = bool15;
                            updateRegistration(12, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool16 = noiseControlVisible.get();
                            }
                            if ((j & 6299648) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool5 = bool16;
                                updateRegistration(13, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool17 = noiseCancellationSelected.get();
                                }
                                if ((j & 6307840) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool2 = bool17;
                                    updateRegistration(14, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool18 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 6291456) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 6324224) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j5 = j;
                                        updateRegistration(15, itemDesc);
                                        if (itemDesc != null) {
                                            str8 = itemDesc.get();
                                        }
                                        j6 = j5 & 6422788;
                                        if (j6 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            updateRegistration(17, enable);
                                            if (enable != null) {
                                                bool19 = enable.get();
                                            } else {
                                                bool19 = null;
                                            }
                                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                            if (j6 != 0) {
                                                j7 = j5;
                                            } else if (zSafeUnbox) {
                                                j7 = j5 | 16777216;
                                            } else {
                                                j7 = j5 | 8388608;
                                            }
                                            str4 = str6;
                                            f = f3;
                                            j5 = j7;
                                        } else {
                                            str4 = str6;
                                            f = f3;
                                            zSafeUnbox = false;
                                        }
                                        observableField = observableFieldIsMagicGesture;
                                        bool10 = bool12;
                                        str2 = str7;
                                        bool9 = bool11;
                                        bool4 = bool18;
                                        str3 = str5;
                                        str = str8;
                                    } else {
                                        bool18 = bool18;
                                        j5 = j;
                                    }
                                    str8 = null;
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool2 = bool17;
                                }
                                bool18 = null;
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool5 = bool16;
                            }
                            bool17 = null;
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool6 = bool15;
                        }
                        bool16 = null;
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool = bool13;
                    }
                    bool14 = null;
                    if ((j & 6293504) != 0) {
                        if (controlOperationViewModel != null) {
                            observableFieldIsMagicGesture2 = controlOperationViewModel.isMagicGesture();
                        } else {
                            observableFieldIsMagicGesture2 = null;
                        }
                        bool3 = bool14;
                        updateRegistration(11, observableFieldIsMagicGesture2);
                        if (observableFieldIsMagicGesture2 != null) {
                            bool15 = observableFieldIsMagicGesture2.get();
                        }
                        if ((j & 6295552) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool6 = bool15;
                            updateRegistration(12, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool16 = noiseControlVisible.get();
                            }
                            if ((j & 6299648) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool5 = bool16;
                                updateRegistration(13, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool17 = noiseCancellationSelected.get();
                                }
                                if ((j & 6307840) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool2 = bool17;
                                    updateRegistration(14, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool18 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 6291456) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 6324224) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j5 = j;
                                        updateRegistration(15, itemDesc);
                                        if (itemDesc != null) {
                                            str8 = itemDesc.get();
                                        }
                                        j6 = j5 & 6422788;
                                        if (j6 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            updateRegistration(17, enable);
                                            if (enable != null) {
                                                bool19 = enable.get();
                                            } else {
                                                bool19 = null;
                                            }
                                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                            if (j6 != 0) {
                                                j7 = j5;
                                            } else if (zSafeUnbox) {
                                                j7 = j5 | 16777216;
                                            } else {
                                                j7 = j5 | 8388608;
                                            }
                                            str4 = str6;
                                            f = f3;
                                            j5 = j7;
                                        } else {
                                            str4 = str6;
                                            f = f3;
                                            zSafeUnbox = false;
                                        }
                                        observableField = observableFieldIsMagicGesture;
                                        bool10 = bool12;
                                        str2 = str7;
                                        bool9 = bool11;
                                        bool4 = bool18;
                                        str3 = str5;
                                        str = str8;
                                    } else {
                                        bool18 = bool18;
                                        j5 = j;
                                    }
                                    str8 = null;
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool2 = bool17;
                                }
                                bool18 = null;
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool5 = bool16;
                            }
                            bool17 = null;
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool6 = bool15;
                        }
                        bool16 = null;
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool3 = bool14;
                    }
                    bool15 = null;
                    if ((j & 6295552) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool6 = bool15;
                        updateRegistration(12, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool16 = noiseControlVisible.get();
                        }
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool6 = bool15;
                    }
                    bool16 = null;
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    controlOperationViewModel = controlOperationViewModel2;
                }
                bool13 = null;
                if ((j & 6292480) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool = bool13;
                    updateRegistration(10, offSelected);
                    if (offSelected != null) {
                        bool14 = offSelected.get();
                    }
                    if ((j & 6293504) != 0) {
                        if (controlOperationViewModel != null) {
                            observableFieldIsMagicGesture2 = controlOperationViewModel.isMagicGesture();
                        } else {
                            observableFieldIsMagicGesture2 = null;
                        }
                        bool3 = bool14;
                        updateRegistration(11, observableFieldIsMagicGesture2);
                        if (observableFieldIsMagicGesture2 != null) {
                            bool15 = observableFieldIsMagicGesture2.get();
                        }
                        if ((j & 6295552) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool6 = bool15;
                            updateRegistration(12, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool16 = noiseControlVisible.get();
                            }
                            if ((j & 6299648) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool5 = bool16;
                                updateRegistration(13, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool17 = noiseCancellationSelected.get();
                                }
                                if ((j & 6307840) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool2 = bool17;
                                    updateRegistration(14, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool18 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 6291456) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 6324224) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j5 = j;
                                        updateRegistration(15, itemDesc);
                                        if (itemDesc != null) {
                                            str8 = itemDesc.get();
                                        }
                                        j6 = j5 & 6422788;
                                        if (j6 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            updateRegistration(17, enable);
                                            if (enable != null) {
                                                bool19 = enable.get();
                                            } else {
                                                bool19 = null;
                                            }
                                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                            if (j6 != 0) {
                                                j7 = j5;
                                            } else if (zSafeUnbox) {
                                                j7 = j5 | 16777216;
                                            } else {
                                                j7 = j5 | 8388608;
                                            }
                                            str4 = str6;
                                            f = f3;
                                            j5 = j7;
                                        } else {
                                            str4 = str6;
                                            f = f3;
                                            zSafeUnbox = false;
                                        }
                                        observableField = observableFieldIsMagicGesture;
                                        bool10 = bool12;
                                        str2 = str7;
                                        bool9 = bool11;
                                        bool4 = bool18;
                                        str3 = str5;
                                        str = str8;
                                    } else {
                                        bool18 = bool18;
                                        j5 = j;
                                    }
                                    str8 = null;
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool2 = bool17;
                                }
                                bool18 = null;
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool5 = bool16;
                            }
                            bool17 = null;
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool6 = bool15;
                        }
                        bool16 = null;
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool3 = bool14;
                    }
                    bool15 = null;
                    if ((j & 6295552) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool6 = bool15;
                        updateRegistration(12, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool16 = noiseControlVisible.get();
                        }
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool6 = bool15;
                    }
                    bool16 = null;
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool = bool13;
                }
                bool14 = null;
                if ((j & 6293504) != 0) {
                    if (controlOperationViewModel != null) {
                        observableFieldIsMagicGesture2 = controlOperationViewModel.isMagicGesture();
                    } else {
                        observableFieldIsMagicGesture2 = null;
                    }
                    bool3 = bool14;
                    updateRegistration(11, observableFieldIsMagicGesture2);
                    if (observableFieldIsMagicGesture2 != null) {
                        bool15 = observableFieldIsMagicGesture2.get();
                    }
                    if ((j & 6295552) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool6 = bool15;
                        updateRegistration(12, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool16 = noiseControlVisible.get();
                        }
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool6 = bool15;
                    }
                    bool16 = null;
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool3 = bool14;
                }
                bool15 = null;
                if ((j & 6295552) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool6 = bool15;
                    updateRegistration(12, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool16 = noiseControlVisible.get();
                    }
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool6 = bool15;
                }
                bool16 = null;
                if ((j & 6299648) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool5 = bool16;
                    updateRegistration(13, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool17 = noiseCancellationSelected.get();
                    }
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool5 = bool16;
                }
                bool17 = null;
                if ((j & 6307840) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool2 = bool17;
                    updateRegistration(14, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool18 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool2 = bool17;
                }
                bool18 = null;
                if ((j & 6291456) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6324224) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j5 = j;
                    updateRegistration(15, itemDesc);
                    if (itemDesc != null) {
                        str8 = itemDesc.get();
                    }
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool18 = bool18;
                    j5 = j;
                }
                str8 = null;
                j6 = j5 & 6422788;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(17, enable);
                    if (enable != null) {
                        bool19 = enable.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                    if (j6 != 0) {
                        j7 = j5;
                    } else if (zSafeUnbox) {
                        j7 = j5 | 16777216;
                    } else {
                        j7 = j5 | 8388608;
                    }
                    str4 = str6;
                    f = f3;
                    j5 = j7;
                } else {
                    str4 = str6;
                    f = f3;
                    zSafeUnbox = false;
                }
                observableField = observableFieldIsMagicGesture;
                bool10 = bool12;
                str2 = str7;
                bool9 = bool11;
                bool4 = bool18;
                str3 = str5;
                str = str8;
            } else {
                z = true;
            }
            bool7 = null;
            if ((j & j3) == 0) {
                str6 = null;
            } else {
                if (controlOperationViewModel2 != null) {
                    operationName = controlOperationViewModel2.getOperationName();
                } else {
                    operationName = null;
                }
                updateRegistration(6, operationName);
                if (operationName != null) {
                    str6 = operationName.get();
                } else {
                    str6 = null;
                }
            }
            if ((j & 6291584) == 0) {
                str7 = null;
            } else {
                if (controlOperationViewModel2 != null) {
                    newsPromptName = controlOperationViewModel2.getNewsPromptName();
                } else {
                    newsPromptName = null;
                }
                updateRegistration(7, newsPromptName);
                if (newsPromptName != null) {
                    str7 = newsPromptName.get();
                } else {
                    str7 = null;
                }
            }
            if ((j & 6291712) != 0) {
                if (controlOperationViewModel2 != null) {
                    selected = controlOperationViewModel2.getSelected();
                } else {
                    selected = null;
                }
                updateRegistration(8, selected);
                if (selected != null) {
                    bool12 = selected.get();
                } else {
                    bool12 = null;
                }
            } else {
                selected = null;
                bool12 = null;
            }
            if ((j & 6291968) != 0) {
                if (controlOperationViewModel2 != null) {
                    voiceAssistantChatGptSelected = controlOperationViewModel2.getVoiceAssistantChatGptSelected();
                } else {
                    voiceAssistantChatGptSelected = null;
                }
                controlOperationViewModel = controlOperationViewModel2;
                updateRegistration(9, voiceAssistantChatGptSelected);
                if (voiceAssistantChatGptSelected != null) {
                    bool13 = voiceAssistantChatGptSelected.get();
                }
                if ((j & 6292480) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool = bool13;
                    updateRegistration(10, offSelected);
                    if (offSelected != null) {
                        bool14 = offSelected.get();
                    }
                    if ((j & 6293504) != 0) {
                        if (controlOperationViewModel != null) {
                            observableFieldIsMagicGesture2 = controlOperationViewModel.isMagicGesture();
                        } else {
                            observableFieldIsMagicGesture2 = null;
                        }
                        bool3 = bool14;
                        updateRegistration(11, observableFieldIsMagicGesture2);
                        if (observableFieldIsMagicGesture2 != null) {
                            bool15 = observableFieldIsMagicGesture2.get();
                        }
                        if ((j & 6295552) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool6 = bool15;
                            updateRegistration(12, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool16 = noiseControlVisible.get();
                            }
                            if ((j & 6299648) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool5 = bool16;
                                updateRegistration(13, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool17 = noiseCancellationSelected.get();
                                }
                                if ((j & 6307840) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool2 = bool17;
                                    updateRegistration(14, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool18 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 6291456) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 6324224) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j5 = j;
                                        updateRegistration(15, itemDesc);
                                        if (itemDesc != null) {
                                            str8 = itemDesc.get();
                                        }
                                        j6 = j5 & 6422788;
                                        if (j6 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            updateRegistration(17, enable);
                                            if (enable != null) {
                                                bool19 = enable.get();
                                            } else {
                                                bool19 = null;
                                            }
                                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                            if (j6 != 0) {
                                                j7 = j5;
                                            } else if (zSafeUnbox) {
                                                j7 = j5 | 16777216;
                                            } else {
                                                j7 = j5 | 8388608;
                                            }
                                            str4 = str6;
                                            f = f3;
                                            j5 = j7;
                                        } else {
                                            str4 = str6;
                                            f = f3;
                                            zSafeUnbox = false;
                                        }
                                        observableField = observableFieldIsMagicGesture;
                                        bool10 = bool12;
                                        str2 = str7;
                                        bool9 = bool11;
                                        bool4 = bool18;
                                        str3 = str5;
                                        str = str8;
                                    } else {
                                        bool18 = bool18;
                                        j5 = j;
                                    }
                                    str8 = null;
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool2 = bool17;
                                }
                                bool18 = null;
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool5 = bool16;
                            }
                            bool17 = null;
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool6 = bool15;
                        }
                        bool16 = null;
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool3 = bool14;
                    }
                    bool15 = null;
                    if ((j & 6295552) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool6 = bool15;
                        updateRegistration(12, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool16 = noiseControlVisible.get();
                        }
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool6 = bool15;
                    }
                    bool16 = null;
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool = bool13;
                }
                bool14 = null;
                if ((j & 6293504) != 0) {
                    if (controlOperationViewModel != null) {
                        observableFieldIsMagicGesture2 = controlOperationViewModel.isMagicGesture();
                    } else {
                        observableFieldIsMagicGesture2 = null;
                    }
                    bool3 = bool14;
                    updateRegistration(11, observableFieldIsMagicGesture2);
                    if (observableFieldIsMagicGesture2 != null) {
                        bool15 = observableFieldIsMagicGesture2.get();
                    }
                    if ((j & 6295552) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool6 = bool15;
                        updateRegistration(12, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool16 = noiseControlVisible.get();
                        }
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool6 = bool15;
                    }
                    bool16 = null;
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool3 = bool14;
                }
                bool15 = null;
                if ((j & 6295552) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool6 = bool15;
                    updateRegistration(12, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool16 = noiseControlVisible.get();
                    }
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool6 = bool15;
                }
                bool16 = null;
                if ((j & 6299648) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool5 = bool16;
                    updateRegistration(13, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool17 = noiseCancellationSelected.get();
                    }
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool5 = bool16;
                }
                bool17 = null;
                if ((j & 6307840) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool2 = bool17;
                    updateRegistration(14, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool18 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool2 = bool17;
                }
                bool18 = null;
                if ((j & 6291456) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6324224) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j5 = j;
                    updateRegistration(15, itemDesc);
                    if (itemDesc != null) {
                        str8 = itemDesc.get();
                    }
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool18 = bool18;
                    j5 = j;
                }
                str8 = null;
                j6 = j5 & 6422788;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(17, enable);
                    if (enable != null) {
                        bool19 = enable.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                    if (j6 != 0) {
                        j7 = j5;
                    } else if (zSafeUnbox) {
                        j7 = j5 | 16777216;
                    } else {
                        j7 = j5 | 8388608;
                    }
                    str4 = str6;
                    f = f3;
                    j5 = j7;
                } else {
                    str4 = str6;
                    f = f3;
                    zSafeUnbox = false;
                }
                observableField = observableFieldIsMagicGesture;
                bool10 = bool12;
                str2 = str7;
                bool9 = bool11;
                bool4 = bool18;
                str3 = str5;
                str = str8;
            } else {
                controlOperationViewModel = controlOperationViewModel2;
            }
            bool13 = null;
            if ((j & 6292480) != 0) {
                if (controlOperationViewModel != null) {
                    offSelected = controlOperationViewModel.getOffSelected();
                } else {
                    offSelected = null;
                }
                bool = bool13;
                updateRegistration(10, offSelected);
                if (offSelected != null) {
                    bool14 = offSelected.get();
                }
                if ((j & 6293504) != 0) {
                    if (controlOperationViewModel != null) {
                        observableFieldIsMagicGesture2 = controlOperationViewModel.isMagicGesture();
                    } else {
                        observableFieldIsMagicGesture2 = null;
                    }
                    bool3 = bool14;
                    updateRegistration(11, observableFieldIsMagicGesture2);
                    if (observableFieldIsMagicGesture2 != null) {
                        bool15 = observableFieldIsMagicGesture2.get();
                    }
                    if ((j & 6295552) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool6 = bool15;
                        updateRegistration(12, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool16 = noiseControlVisible.get();
                        }
                        if ((j & 6299648) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool5 = bool16;
                            updateRegistration(13, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool17 = noiseCancellationSelected.get();
                            }
                            if ((j & 6307840) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool2 = bool17;
                                updateRegistration(14, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool18 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 6291456) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 6324224) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j5 = j;
                                    updateRegistration(15, itemDesc);
                                    if (itemDesc != null) {
                                        str8 = itemDesc.get();
                                    }
                                    j6 = j5 & 6422788;
                                    if (j6 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        updateRegistration(17, enable);
                                        if (enable != null) {
                                            bool19 = enable.get();
                                        } else {
                                            bool19 = null;
                                        }
                                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                        if (j6 != 0) {
                                            j7 = j5;
                                        } else if (zSafeUnbox) {
                                            j7 = j5 | 16777216;
                                        } else {
                                            j7 = j5 | 8388608;
                                        }
                                        str4 = str6;
                                        f = f3;
                                        j5 = j7;
                                    } else {
                                        str4 = str6;
                                        f = f3;
                                        zSafeUnbox = false;
                                    }
                                    observableField = observableFieldIsMagicGesture;
                                    bool10 = bool12;
                                    str2 = str7;
                                    bool9 = bool11;
                                    bool4 = bool18;
                                    str3 = str5;
                                    str = str8;
                                } else {
                                    bool18 = bool18;
                                    j5 = j;
                                }
                                str8 = null;
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool2 = bool17;
                            }
                            bool18 = null;
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool5 = bool16;
                        }
                        bool17 = null;
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool6 = bool15;
                    }
                    bool16 = null;
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool3 = bool14;
                }
                bool15 = null;
                if ((j & 6295552) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool6 = bool15;
                    updateRegistration(12, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool16 = noiseControlVisible.get();
                    }
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool6 = bool15;
                }
                bool16 = null;
                if ((j & 6299648) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool5 = bool16;
                    updateRegistration(13, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool17 = noiseCancellationSelected.get();
                    }
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool5 = bool16;
                }
                bool17 = null;
                if ((j & 6307840) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool2 = bool17;
                    updateRegistration(14, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool18 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool2 = bool17;
                }
                bool18 = null;
                if ((j & 6291456) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6324224) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j5 = j;
                    updateRegistration(15, itemDesc);
                    if (itemDesc != null) {
                        str8 = itemDesc.get();
                    }
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool18 = bool18;
                    j5 = j;
                }
                str8 = null;
                j6 = j5 & 6422788;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(17, enable);
                    if (enable != null) {
                        bool19 = enable.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                    if (j6 != 0) {
                        j7 = j5;
                    } else if (zSafeUnbox) {
                        j7 = j5 | 16777216;
                    } else {
                        j7 = j5 | 8388608;
                    }
                    str4 = str6;
                    f = f3;
                    j5 = j7;
                } else {
                    str4 = str6;
                    f = f3;
                    zSafeUnbox = false;
                }
                observableField = observableFieldIsMagicGesture;
                bool10 = bool12;
                str2 = str7;
                bool9 = bool11;
                bool4 = bool18;
                str3 = str5;
                str = str8;
            } else {
                bool = bool13;
            }
            bool14 = null;
            if ((j & 6293504) != 0) {
                if (controlOperationViewModel != null) {
                    observableFieldIsMagicGesture2 = controlOperationViewModel.isMagicGesture();
                } else {
                    observableFieldIsMagicGesture2 = null;
                }
                bool3 = bool14;
                updateRegistration(11, observableFieldIsMagicGesture2);
                if (observableFieldIsMagicGesture2 != null) {
                    bool15 = observableFieldIsMagicGesture2.get();
                }
                if ((j & 6295552) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool6 = bool15;
                    updateRegistration(12, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool16 = noiseControlVisible.get();
                    }
                    if ((j & 6299648) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool5 = bool16;
                        updateRegistration(13, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool17 = noiseCancellationSelected.get();
                        }
                        if ((j & 6307840) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool2 = bool17;
                            updateRegistration(14, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool18 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 6291456) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 6324224) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j5 = j;
                                updateRegistration(15, itemDesc);
                                if (itemDesc != null) {
                                    str8 = itemDesc.get();
                                }
                                j6 = j5 & 6422788;
                                if (j6 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(17, enable);
                                    if (enable != null) {
                                        bool19 = enable.get();
                                    } else {
                                        bool19 = null;
                                    }
                                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                    if (j6 != 0) {
                                        j7 = j5;
                                    } else if (zSafeUnbox) {
                                        j7 = j5 | 16777216;
                                    } else {
                                        j7 = j5 | 8388608;
                                    }
                                    str4 = str6;
                                    f = f3;
                                    j5 = j7;
                                } else {
                                    str4 = str6;
                                    f = f3;
                                    zSafeUnbox = false;
                                }
                                observableField = observableFieldIsMagicGesture;
                                bool10 = bool12;
                                str2 = str7;
                                bool9 = bool11;
                                bool4 = bool18;
                                str3 = str5;
                                str = str8;
                            } else {
                                bool18 = bool18;
                                j5 = j;
                            }
                            str8 = null;
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool2 = bool17;
                        }
                        bool18 = null;
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool5 = bool16;
                    }
                    bool17 = null;
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool6 = bool15;
                }
                bool16 = null;
                if ((j & 6299648) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool5 = bool16;
                    updateRegistration(13, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool17 = noiseCancellationSelected.get();
                    }
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool5 = bool16;
                }
                bool17 = null;
                if ((j & 6307840) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool2 = bool17;
                    updateRegistration(14, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool18 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool2 = bool17;
                }
                bool18 = null;
                if ((j & 6291456) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6324224) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j5 = j;
                    updateRegistration(15, itemDesc);
                    if (itemDesc != null) {
                        str8 = itemDesc.get();
                    }
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool18 = bool18;
                    j5 = j;
                }
                str8 = null;
                j6 = j5 & 6422788;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(17, enable);
                    if (enable != null) {
                        bool19 = enable.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                    if (j6 != 0) {
                        j7 = j5;
                    } else if (zSafeUnbox) {
                        j7 = j5 | 16777216;
                    } else {
                        j7 = j5 | 8388608;
                    }
                    str4 = str6;
                    f = f3;
                    j5 = j7;
                } else {
                    str4 = str6;
                    f = f3;
                    zSafeUnbox = false;
                }
                observableField = observableFieldIsMagicGesture;
                bool10 = bool12;
                str2 = str7;
                bool9 = bool11;
                bool4 = bool18;
                str3 = str5;
                str = str8;
            } else {
                bool3 = bool14;
            }
            bool15 = null;
            if ((j & 6295552) != 0) {
                if (controlOperationViewModel != null) {
                    noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                } else {
                    noiseControlVisible = null;
                }
                bool6 = bool15;
                updateRegistration(12, noiseControlVisible);
                if (noiseControlVisible != null) {
                    bool16 = noiseControlVisible.get();
                }
                if ((j & 6299648) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool5 = bool16;
                    updateRegistration(13, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool17 = noiseCancellationSelected.get();
                    }
                    if ((j & 6307840) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool2 = bool17;
                        updateRegistration(14, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool18 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 6291456) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 6324224) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j5 = j;
                            updateRegistration(15, itemDesc);
                            if (itemDesc != null) {
                                str8 = itemDesc.get();
                            }
                            j6 = j5 & 6422788;
                            if (j6 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(17, enable);
                                if (enable != null) {
                                    bool19 = enable.get();
                                } else {
                                    bool19 = null;
                                }
                                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                                if (j6 != 0) {
                                    j7 = j5;
                                } else if (zSafeUnbox) {
                                    j7 = j5 | 16777216;
                                } else {
                                    j7 = j5 | 8388608;
                                }
                                str4 = str6;
                                f = f3;
                                j5 = j7;
                            } else {
                                str4 = str6;
                                f = f3;
                                zSafeUnbox = false;
                            }
                            observableField = observableFieldIsMagicGesture;
                            bool10 = bool12;
                            str2 = str7;
                            bool9 = bool11;
                            bool4 = bool18;
                            str3 = str5;
                            str = str8;
                        } else {
                            bool18 = bool18;
                            j5 = j;
                        }
                        str8 = null;
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool2 = bool17;
                    }
                    bool18 = null;
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool5 = bool16;
                }
                bool17 = null;
                if ((j & 6307840) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool2 = bool17;
                    updateRegistration(14, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool18 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool2 = bool17;
                }
                bool18 = null;
                if ((j & 6291456) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6324224) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j5 = j;
                    updateRegistration(15, itemDesc);
                    if (itemDesc != null) {
                        str8 = itemDesc.get();
                    }
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool18 = bool18;
                    j5 = j;
                }
                str8 = null;
                j6 = j5 & 6422788;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(17, enable);
                    if (enable != null) {
                        bool19 = enable.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                    if (j6 != 0) {
                        j7 = j5;
                    } else if (zSafeUnbox) {
                        j7 = j5 | 16777216;
                    } else {
                        j7 = j5 | 8388608;
                    }
                    str4 = str6;
                    f = f3;
                    j5 = j7;
                } else {
                    str4 = str6;
                    f = f3;
                    zSafeUnbox = false;
                }
                observableField = observableFieldIsMagicGesture;
                bool10 = bool12;
                str2 = str7;
                bool9 = bool11;
                bool4 = bool18;
                str3 = str5;
                str = str8;
            } else {
                bool6 = bool15;
            }
            bool16 = null;
            if ((j & 6299648) != 0) {
                if (controlOperationViewModel != null) {
                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                } else {
                    noiseCancellationSelected = null;
                }
                bool5 = bool16;
                updateRegistration(13, noiseCancellationSelected);
                if (noiseCancellationSelected != null) {
                    bool17 = noiseCancellationSelected.get();
                }
                if ((j & 6307840) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool2 = bool17;
                    updateRegistration(14, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool18 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 6291456) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 6324224) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j5 = j;
                        updateRegistration(15, itemDesc);
                        if (itemDesc != null) {
                            str8 = itemDesc.get();
                        }
                        j6 = j5 & 6422788;
                        if (j6 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(17, enable);
                            if (enable != null) {
                                bool19 = enable.get();
                            } else {
                                bool19 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                            if (j6 != 0) {
                                j7 = j5;
                            } else if (zSafeUnbox) {
                                j7 = j5 | 16777216;
                            } else {
                                j7 = j5 | 8388608;
                            }
                            str4 = str6;
                            f = f3;
                            j5 = j7;
                        } else {
                            str4 = str6;
                            f = f3;
                            zSafeUnbox = false;
                        }
                        observableField = observableFieldIsMagicGesture;
                        bool10 = bool12;
                        str2 = str7;
                        bool9 = bool11;
                        bool4 = bool18;
                        str3 = str5;
                        str = str8;
                    } else {
                        bool18 = bool18;
                        j5 = j;
                    }
                    str8 = null;
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool2 = bool17;
                }
                bool18 = null;
                if ((j & 6291456) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6324224) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j5 = j;
                    updateRegistration(15, itemDesc);
                    if (itemDesc != null) {
                        str8 = itemDesc.get();
                    }
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool18 = bool18;
                    j5 = j;
                }
                str8 = null;
                j6 = j5 & 6422788;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(17, enable);
                    if (enable != null) {
                        bool19 = enable.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                    if (j6 != 0) {
                        j7 = j5;
                    } else if (zSafeUnbox) {
                        j7 = j5 | 16777216;
                    } else {
                        j7 = j5 | 8388608;
                    }
                    str4 = str6;
                    f = f3;
                    j5 = j7;
                } else {
                    str4 = str6;
                    f = f3;
                    zSafeUnbox = false;
                }
                observableField = observableFieldIsMagicGesture;
                bool10 = bool12;
                str2 = str7;
                bool9 = bool11;
                bool4 = bool18;
                str3 = str5;
                str = str8;
            } else {
                bool5 = bool16;
            }
            bool17 = null;
            if ((j & 6307840) != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                } else {
                    voiceAssistantDefaultSelected = null;
                }
                bool2 = bool17;
                updateRegistration(14, voiceAssistantDefaultSelected);
                if (voiceAssistantDefaultSelected != null) {
                    bool18 = voiceAssistantDefaultSelected.get();
                }
                if ((j & 6291456) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6324224) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j5 = j;
                    updateRegistration(15, itemDesc);
                    if (itemDesc != null) {
                        str8 = itemDesc.get();
                    }
                    j6 = j5 & 6422788;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(17, enable);
                        if (enable != null) {
                            bool19 = enable.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                        if (j6 != 0) {
                            j7 = j5;
                        } else if (zSafeUnbox) {
                            j7 = j5 | 16777216;
                        } else {
                            j7 = j5 | 8388608;
                        }
                        str4 = str6;
                        f = f3;
                        j5 = j7;
                    } else {
                        str4 = str6;
                        f = f3;
                        zSafeUnbox = false;
                    }
                    observableField = observableFieldIsMagicGesture;
                    bool10 = bool12;
                    str2 = str7;
                    bool9 = bool11;
                    bool4 = bool18;
                    str3 = str5;
                    str = str8;
                } else {
                    bool18 = bool18;
                    j5 = j;
                }
                str8 = null;
                j6 = j5 & 6422788;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(17, enable);
                    if (enable != null) {
                        bool19 = enable.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                    if (j6 != 0) {
                        j7 = j5;
                    } else if (zSafeUnbox) {
                        j7 = j5 | 16777216;
                    } else {
                        j7 = j5 | 8388608;
                    }
                    str4 = str6;
                    f = f3;
                    j5 = j7;
                } else {
                    str4 = str6;
                    f = f3;
                    zSafeUnbox = false;
                }
                observableField = observableFieldIsMagicGesture;
                bool10 = bool12;
                str2 = str7;
                bool9 = bool11;
                bool4 = bool18;
                str3 = str5;
                str = str8;
            } else {
                bool2 = bool17;
            }
            bool18 = null;
            if ((j & 6291456) != 0) {
                direction = null;
            } else {
                direction = null;
            }
            if ((j & 6324224) != 0) {
                if (controlOperationViewModel != null) {
                    itemDesc = controlOperationViewModel.getItemDesc();
                } else {
                    itemDesc = null;
                }
                j5 = j;
                updateRegistration(15, itemDesc);
                if (itemDesc != null) {
                    str8 = itemDesc.get();
                }
                j6 = j5 & 6422788;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(17, enable);
                    if (enable != null) {
                        bool19 = enable.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                    if (j6 != 0) {
                        j7 = j5;
                    } else if (zSafeUnbox) {
                        j7 = j5 | 16777216;
                    } else {
                        j7 = j5 | 8388608;
                    }
                    str4 = str6;
                    f = f3;
                    j5 = j7;
                } else {
                    str4 = str6;
                    f = f3;
                    zSafeUnbox = false;
                }
                observableField = observableFieldIsMagicGesture;
                bool10 = bool12;
                str2 = str7;
                bool9 = bool11;
                bool4 = bool18;
                str3 = str5;
                str = str8;
            } else {
                bool18 = bool18;
                j5 = j;
            }
            str8 = null;
            j6 = j5 & 6422788;
            if (j6 != 0) {
                if (controlOperationViewModel != null) {
                    enable = controlOperationViewModel.getEnable();
                } else {
                    enable = null;
                }
                updateRegistration(17, enable);
                if (enable != null) {
                    bool19 = enable.get();
                } else {
                    bool19 = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(bool19);
                if (j6 != 0) {
                    j7 = j5;
                } else if (zSafeUnbox) {
                    j7 = j5 | 16777216;
                } else {
                    j7 = j5 | 8388608;
                }
                str4 = str6;
                f = f3;
                j5 = j7;
            } else {
                str4 = str6;
                f = f3;
                zSafeUnbox = false;
            }
            observableField = observableFieldIsMagicGesture;
            bool10 = bool12;
            str2 = str7;
            bool9 = bool11;
            bool4 = bool18;
            str3 = str5;
            str = str8;
        } else {
            controlOperationViewModel = controlOperationViewModel2;
            z = true;
            j2 = 6291464;
            j3 = 6291520;
            j4 = 6291488;
            j5 = j;
            bool = null;
            bool2 = null;
            bool3 = null;
            bool4 = null;
            str = null;
            bool5 = null;
            bool6 = null;
            direction = null;
            str2 = null;
            str3 = null;
            bool7 = null;
            bool8 = null;
            str4 = null;
            bool9 = null;
            observableField = null;
            selected = null;
            bool10 = null;
            zSafeUnbox = false;
            f = 0.0f;
            z2 = false;
            zSafeUnbox2 = false;
        }
        if ((j5 & 8388608) != 0) {
            if (controlOperationViewModel != null) {
                selected = controlOperationViewModel.getSelected();
            }
            ObservableField<Boolean> observableField2 = selected;
            updateRegistration(8, observableField2);
            if (observableField2 != null) {
                bool10 = observableField2.get();
            }
            zSafeUnbox3 = ViewDataBinding.safeUnbox(bool10);
        } else {
            zSafeUnbox3 = false;
        }
        Boolean bool20 = bool10;
        if ((j5 & 536870912) != 0) {
            ObservableField<Boolean> nothingRadioPromptVisibility = controlOperationViewModel != null ? controlOperationViewModel.getNothingRadioPromptVisibility() : null;
            updateRegistration(18, nothingRadioPromptVisibility);
            zSafeUnbox4 = ViewDataBinding.safeUnbox(nothingRadioPromptVisibility != null ? nothingRadioPromptVisibility.get() : null);
        } else {
            zSafeUnbox3 = zSafeUnbox3;
            zSafeUnbox4 = false;
        }
        long j10 = j5 & 6422788;
        if (j10 != 0) {
            if (zSafeUnbox) {
                zSafeUnbox3 = z;
            }
            if (j10 != 0) {
                j5 = zSafeUnbox3 ? j5 | 268435456 : j5 | 134217728;
            }
        } else {
            zSafeUnbox3 = false;
        }
        long j11 = j5 & 6619152;
        if (j11 != 0) {
            if (zSafeUnbox2) {
                zSafeUnbox4 = z;
            }
            if (j11 != 0) {
                j5 = zSafeUnbox4 ? j5 | 4294967296L : j5 | 2147483648L;
            }
        } else {
            zSafeUnbox4 = false;
        }
        if ((j5 & 268435456) != 0) {
            ObservableField<Boolean> observableFieldIsMagicGesture3 = controlOperationViewModel != null ? controlOperationViewModel.isMagicGesture() : observableField;
            updateRegistration(2, observableFieldIsMagicGesture3);
            if (observableFieldIsMagicGesture3 != null) {
                bool9 = observableFieldIsMagicGesture3.get();
            }
            z3 = !ViewDataBinding.safeUnbox(bool9);
        } else {
            z3 = false;
        }
        Boolean bool21 = bool9;
        if ((j5 & 2147483648L) != 0) {
            ObservableField<Boolean> essentialSpacePromptVisibility = controlOperationViewModel != null ? controlOperationViewModel.getEssentialSpacePromptVisibility() : null;
            updateRegistration(16, essentialSpacePromptVisibility);
            zSafeUnbox5 = ViewDataBinding.safeUnbox(essentialSpacePromptVisibility != null ? essentialSpacePromptVisibility.get() : null);
        } else {
            z3 = z3;
            zSafeUnbox5 = false;
        }
        if ((j5 & 6422788) == 0 || !zSafeUnbox3) {
            z3 = false;
        }
        long j12 = j5 & 6619152;
        if (j12 != 0) {
            if (zSafeUnbox4) {
                zSafeUnbox5 = z;
                z5 = zSafeUnbox5;
            } else {
                z5 = z;
            }
            boolean z7 = zSafeUnbox5 == z5 ? z5 : false;
            if (j12 != 0) {
                j5 |= z7 ? 67108864L : 33554432L;
            }
            f2 = z7 ? 0.4f : 1.0f;
            z4 = zSafeUnbox5;
        } else {
            f2 = 0.0f;
            z4 = false;
        }
        if ((j5 & 6291460) != 0) {
            BindingAdapter.goneUnless(this.ivArrowRight, bool21);
            BindingAdapter.goneUnless(this.mboundView17, bool21);
        }
        if ((j5 & 4194304) != 0) {
            BindingAdapter.onClick(this.mboundView10, this.mCallback22);
            BindingAdapter.onClick(this.mboundView11, this.mCallback23);
            BindingAdapter.onClick((ViewGroup) this.mboundView13, this.mCallback24);
            BindingAdapter.onClick(this.mboundView16, this.mCallback25);
            BindingAdapter.textLineHeight(this.mboundView4, 22);
            BindingAdapter.onClick(this.mboundView9, this.mCallback21);
        }
        if ((j5 & 6299648) != 0) {
            BindingAdapter.viewSelected(this.mboundView10, bool2);
        }
        if ((j5 & 6292480) != 0) {
            BindingAdapter.viewSelected(this.mboundView11, bool3);
        }
        if ((j5 & j4) != 0) {
            BindingAdapter.goneUnless(this.mboundView12, bool7);
        }
        if ((j5 & j2) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView13.setAlpha(f);
            }
            BindingAdapter.goneUnless(this.mboundView15, Boolean.valueOf(z2));
        }
        if ((j5 & 6291968) != 0) {
            BindingAdapter.viewSelected(this.mboundView14, bool);
        }
        if ((j5 & 6291457) != 0) {
            TextViewBindingAdapter.setText(this.mboundView15, str3);
        }
        if ((j5 & 6307840) != 0) {
            BindingAdapter.viewSelected(this.mboundView16, bool4);
        }
        if ((j5 & 6291456) != 0) {
            BindingAdapter.viewRadius(this.mboundView2, direction);
        }
        if ((j5 & 6324224) != 0 && getBuildSdkInt() >= 4) {
            this.mboundView3.setContentDescription(str);
        }
        if ((j5 & 6619152) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView3.setAlpha(f2);
            }
            BindingAdapter.goneUnless(this.mboundView7, Boolean.valueOf(z4));
        }
        if ((j5 & 6422528) != 0) {
            ViewBindingAdapter.setOnClick(this.mboundView3, this.mCallback20, zSafeUnbox);
        }
        if ((j5 & j3) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str4);
        }
        if ((j5 & 6422788) != 0) {
            BindingAdapter.invisibleUnless(this.mboundView5, Boolean.valueOf(z3));
        }
        if ((j5 & 6291712) != 0) {
            BindingAdapter.viewSelected(this.mboundView5, bool20);
        }
        if ((j5 & 6291584) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, str2);
        }
        if ((j5 & 6295552) != 0) {
            BindingAdapter.goneUnless(this.mboundView8, bool5);
        }
        if ((j5 & 6291458) != 0) {
            BindingAdapter.viewSelected(this.mboundView9, bool8);
        }
        if ((j5 & 6293504) != 0) {
            BindingAdapter.goneUnless(this.notTitle, bool6);
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
