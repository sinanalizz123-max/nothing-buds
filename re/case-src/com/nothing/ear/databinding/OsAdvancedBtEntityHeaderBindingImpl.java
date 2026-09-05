package com.nothing.ear.databinding;

import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.os.device.bluetooth.BluetoothDetailsFragment;
import com.nothing.os.device.bluetooth.adapter.HeaderViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class OsAdvancedBtEntityHeaderBindingImpl extends OsAdvancedBtEntityHeaderBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final OsAdvancedButtonsBinding mboundView0;
    private final TextView mboundView10;
    private final LinearLayout mboundView11;
    private final ImageView mboundView12;
    private final TextView mboundView13;
    private final ImageView mboundView15;
    private final LinearLayout mboundView16;
    private final ImageView mboundView17;
    private final TextView mboundView18;
    private final LinearLayout mboundView5;
    private final ImageView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(22);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"os_advanced_buttons"}, new int[]{19}, new int[]{R.layout.os_advanced_buttons});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.header_title, 20);
        sparseIntArray.put(R.id.bt_battery_prediction, 21);
    }

    public OsAdvancedBtEntityHeaderBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }

    private OsAdvancedBtEntityHeaderBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 25, (ImageView) bindings[6], (TextView) bindings[21], (TextView) bindings[7], (LinearLayout) bindings[0], (TextView) bindings[2], (TextView) bindings[1], (ImageView) bindings[4], (TextView) bindings[20], (LinearLayout) bindings[3], (LinearLayout) bindings[8], (LinearLayout) bindings[14]);
        this.mDirtyFlags = -1L;
        this.btBatteryIcon.setTag(null);
        this.btBatterySummary.setTag(null);
        this.entityHeader.setTag(null);
        this.entityHeaderSummary.setTag(null);
        this.entityHeaderTitle.setTag(null);
        this.headerIcon.setTag(null);
        this.layoutLeft.setTag(null);
        this.layoutMiddle.setTag(null);
        this.layoutRight.setTag(null);
        OsAdvancedButtonsBinding osAdvancedButtonsBinding = (OsAdvancedButtonsBinding) bindings[19];
        this.mboundView0 = osAdvancedButtonsBinding;
        setContainedBinding(osAdvancedButtonsBinding);
        TextView textView = (TextView) bindings[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[11];
        this.mboundView11 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[12];
        this.mboundView12 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) bindings[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        ImageView imageView2 = (ImageView) bindings[15];
        this.mboundView15 = imageView2;
        imageView2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[16];
        this.mboundView16 = linearLayout2;
        linearLayout2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[17];
        this.mboundView17 = imageView3;
        imageView3.setTag(null);
        TextView textView3 = (TextView) bindings[18];
        this.mboundView18 = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[5];
        this.mboundView5 = linearLayout3;
        linearLayout3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[9];
        this.mboundView9 = imageView4;
        imageView4.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 134217728L;
        }
        this.mboundView0.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.mboundView0.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (BR.eventHandler == variableId) {
            setEventHandler((BluetoothDetailsFragment) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((HeaderViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.OsAdvancedBtEntityHeaderBinding
    public void setEventHandler(BluetoothDetailsFragment EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 33554432;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.OsAdvancedBtEntityHeaderBinding
    public void setViewModel(HeaderViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 67108864;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView0.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelCaseTextVisible((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelCaseUri((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelCaseText((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelLeftImageUri((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelRightCharging((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelCaseVisible((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelRightBatteryVisible((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelLeftVisible((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelLeftLevel((ObservableInt) object, fieldId);
            case 9:
                return onChangeViewModelCaseLevel((ObservableInt) object, fieldId);
            case 10:
                return onChangeViewModelCaseBattery((ObservableField) object, fieldId);
            case 11:
                return onChangeViewModelRightImage((ObservableField) object, fieldId);
            case 12:
                return onChangeViewModelTitle((ObservableField) object, fieldId);
            case 13:
                return onChangeViewModelCaseImage((ObservableField) object, fieldId);
            case 14:
                return onChangeViewModelLeftCharging((ObservableField) object, fieldId);
            case 15:
                return onChangeViewModelRightImageUri((ObservableField) object, fieldId);
            case 16:
                return onChangeViewModelLeftBattery((ObservableField) object, fieldId);
            case 17:
                return onChangeViewModelRightVisible((ObservableField) object, fieldId);
            case 18:
                return onChangeViewModelRightLevel((ObservableInt) object, fieldId);
            case 19:
                return onChangeViewModelCaseBatteryVisible((ObservableField) object, fieldId);
            case 20:
                return onChangeViewModelRightBattery((ObservableField) object, fieldId);
            case 21:
                return onChangeViewModelLeftBatteryVisible((ObservableField) object, fieldId);
            case 22:
                return onChangeViewModelCaseCharging((ObservableField) object, fieldId);
            case 23:
                return onChangeViewModelLeftImage((ObservableField) object, fieldId);
            case 24:
                return onChangeViewModelSummary((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelCaseTextVisible(ObservableField<Boolean> ViewModelCaseTextVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelCaseUri(ObservableField<Uri> ViewModelCaseUri, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelCaseText(ObservableField<String> ViewModelCaseText, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelLeftImageUri(ObservableField<Uri> ViewModelLeftImageUri, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelRightCharging(ObservableField<Boolean> ViewModelRightCharging, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelCaseVisible(ObservableField<Boolean> ViewModelCaseVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelRightBatteryVisible(ObservableField<Boolean> ViewModelRightBatteryVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelLeftVisible(ObservableField<Boolean> ViewModelLeftVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelLeftLevel(ObservableInt ViewModelLeftLevel, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelCaseLevel(ObservableInt ViewModelCaseLevel, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelCaseBattery(ObservableField<String> ViewModelCaseBattery, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelRightImage(ObservableField<Integer> ViewModelRightImage, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelTitle(ObservableField<String> ViewModelTitle, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeViewModelCaseImage(ObservableField<Integer> ViewModelCaseImage, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeViewModelLeftCharging(ObservableField<Boolean> ViewModelLeftCharging, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeViewModelRightImageUri(ObservableField<Uri> ViewModelRightImageUri, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    private boolean onChangeViewModelLeftBattery(ObservableField<String> ViewModelLeftBattery, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        return true;
    }

    private boolean onChangeViewModelRightVisible(ObservableField<Boolean> ViewModelRightVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        return true;
    }

    private boolean onChangeViewModelRightLevel(ObservableInt ViewModelRightLevel, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    private boolean onChangeViewModelCaseBatteryVisible(ObservableField<Boolean> ViewModelCaseBatteryVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 524288;
        }
        return true;
    }

    private boolean onChangeViewModelRightBattery(ObservableField<String> ViewModelRightBattery, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1048576;
        }
        return true;
    }

    private boolean onChangeViewModelLeftBatteryVisible(ObservableField<Boolean> ViewModelLeftBatteryVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2097152;
        }
        return true;
    }

    private boolean onChangeViewModelCaseCharging(ObservableField<Boolean> ViewModelCaseCharging, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        return true;
    }

    private boolean onChangeViewModelLeftImage(ObservableField<Integer> ViewModelLeftImage, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        return true;
    }

    private boolean onChangeViewModelSummary(ObservableField<String> ViewModelSummary, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16777216;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:101:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:108:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:110:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:113:0x0207 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0209  */
    /* JADX WARN: Code duplicated, block: B:115:0x0218  */
    /* JADX WARN: Code duplicated, block: B:118:0x022b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0232  */
    /* JADX WARN: Code duplicated, block: B:121:0x0236  */
    /* JADX WARN: Code duplicated, block: B:122:0x023d  */
    /* JADX WARN: Code duplicated, block: B:124:0x024a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0257 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x0259  */
    /* JADX WARN: Code duplicated, block: B:129:0x025e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0267  */
    /* JADX WARN: Code duplicated, block: B:133:0x026e  */
    /* JADX WARN: Code duplicated, block: B:136:0x0276 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x0278  */
    /* JADX WARN: Code duplicated, block: B:138:0x0287  */
    /* JADX WARN: Code duplicated, block: B:141:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:145:0x02b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:147:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:150:0x02c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:152:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:155:0x02da  */
    /* JADX WARN: Code duplicated, block: B:156:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:160:0x02eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:162:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:165:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:166:0x0304  */
    /* JADX WARN: Code duplicated, block: B:16:0x0066  */
    /* JADX WARN: Code duplicated, block: B:170:0x030e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:171:0x0310  */
    /* JADX WARN: Code duplicated, block: B:172:0x0315  */
    /* JADX WARN: Code duplicated, block: B:175:0x0320  */
    /* JADX WARN: Code duplicated, block: B:176:0x0327  */
    /* JADX WARN: Code duplicated, block: B:180:0x0331 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:181:0x0333  */
    /* JADX WARN: Code duplicated, block: B:182:0x0338  */
    /* JADX WARN: Code duplicated, block: B:185:0x0343  */
    /* JADX WARN: Code duplicated, block: B:186:0x034a  */
    /* JADX WARN: Code duplicated, block: B:190:0x0354 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:191:0x0356  */
    /* JADX WARN: Code duplicated, block: B:192:0x035b  */
    /* JADX WARN: Code duplicated, block: B:195:0x0366  */
    /* JADX WARN: Code duplicated, block: B:196:0x036d  */
    /* JADX WARN: Code duplicated, block: B:200:0x037a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:201:0x037c  */
    /* JADX WARN: Code duplicated, block: B:202:0x0381  */
    /* JADX WARN: Code duplicated, block: B:205:0x038c  */
    /* JADX WARN: Code duplicated, block: B:206:0x0393  */
    /* JADX WARN: Code duplicated, block: B:210:0x039d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:211:0x039f  */
    /* JADX WARN: Code duplicated, block: B:212:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:215:0x03af  */
    /* JADX WARN: Code duplicated, block: B:216:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:54:0x011a  */
    /* JADX WARN: Code duplicated, block: B:57:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x0128  */
    /* JADX WARN: Code duplicated, block: B:59:0x0131  */
    /* JADX WARN: Code duplicated, block: B:62:0x0142  */
    /* JADX WARN: Code duplicated, block: B:63:0x0149  */
    /* JADX WARN: Code duplicated, block: B:65:0x014d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0152  */
    /* JADX WARN: Code duplicated, block: B:68:0x0158  */
    /* JADX WARN: Code duplicated, block: B:71:0x0163 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0165  */
    /* JADX WARN: Code duplicated, block: B:73:0x016a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0172  */
    /* JADX WARN: Code duplicated, block: B:77:0x0179  */
    /* JADX WARN: Code duplicated, block: B:80:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0183  */
    /* JADX WARN: Code duplicated, block: B:82:0x0188  */
    /* JADX WARN: Code duplicated, block: B:85:0x0192  */
    /* JADX WARN: Code duplicated, block: B:86:0x0199  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:95:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c1 A[DONT_INVERT] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        Boolean bool;
        Boolean bool2;
        String str;
        String str2;
        String str3;
        ObservableField<Uri> leftImageUri;
        ObservableField<Integer> leftImage;
        Boolean bool3;
        String str4;
        Boolean bool4;
        String str5;
        ObservableField<Uri> observableField;
        ObservableField<Integer> observableField2;
        Boolean bool5;
        String str6;
        Boolean bool6;
        ObservableField<Uri> observableField3;
        ObservableField<Integer> observableField4;
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        Boolean bool7;
        Boolean bool8;
        ObservableField<Uri> caseUri;
        ObservableField<Integer> caseImage;
        String str7;
        boolean zSafeUnbox;
        int i4;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        boolean zSafeUnbox2;
        int i5;
        int i6;
        boolean zSafeUnbox3;
        String str8;
        String str9;
        ObservableField<Uri> rightImageUri;
        ObservableField<Integer> rightImage;
        ObservableField<Uri> observableField5;
        String str10;
        String str11;
        String str12;
        String str13;
        Boolean bool12;
        Boolean bool13;
        Boolean bool14;
        Boolean bool15;
        String str14;
        String str15;
        Boolean bool16;
        Boolean bool17;
        ObservableField<String> summary;
        ObservableField<Boolean> leftBatteryVisible;
        ObservableField<String> rightBattery;
        ObservableField<Boolean> caseBatteryVisible;
        ObservableField<Boolean> rightVisible;
        ObservableField<String> leftBattery;
        ObservableField<String> title;
        ObservableField<String> caseBattery;
        ObservableField<Boolean> caseCharging;
        ObservableInt caseLevel;
        int i7;
        Boolean bool18;
        ObservableField<Boolean> leftCharging;
        ObservableInt leftLevel;
        Boolean bool19;
        ObservableField<Boolean> leftVisible;
        ObservableField<Boolean> rightBatteryVisible;
        ObservableField<Boolean> caseVisible;
        ObservableField<Boolean> rightCharging;
        ObservableInt rightLevel;
        Boolean bool20;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BluetoothDetailsFragment bluetoothDetailsFragment = this.mEventHandler;
        HeaderViewModel headerViewModel = this.mViewModel;
        long j7 = 167772160 & j;
        String str16 = null;
        if ((234881023 & j) != 0) {
            if ((j & 201326593) == 0) {
                bool8 = null;
            } else {
                ObservableField<Boolean> caseTextVisible = headerViewModel != null ? headerViewModel.getCaseTextVisible() : null;
                updateRegistration(0, caseTextVisible);
                if (caseTextVisible != null) {
                    bool8 = caseTextVisible.get();
                } else {
                    bool8 = null;
                }
            }
            if ((j & 201334786) != 0) {
                if (headerViewModel != null) {
                    caseUri = headerViewModel.getCaseUri();
                    caseImage = headerViewModel.getCaseImage();
                } else {
                    caseUri = null;
                    caseImage = null;
                }
                j3 = 202375168;
                updateRegistration(1, caseUri);
                updateRegistration(13, caseImage);
                if ((j & 201326594) != 0 && caseUri != null) {
                    caseUri.get();
                }
                if ((j & 201334784) != 0 && caseImage != null) {
                    caseImage.get();
                }
            } else {
                j3 = 202375168;
                caseUri = null;
                caseImage = null;
            }
            if ((j & 201326596) != 0) {
                ObservableField<String> caseText = headerViewModel != null ? headerViewModel.getCaseText() : null;
                j4 = 201850880;
                updateRegistration(2, caseText);
                if (caseText != null) {
                    str7 = caseText.get();
                }
                if ((j & 209715208) != 0) {
                    if (headerViewModel != null) {
                        leftImageUri = headerViewModel.getLeftImageUri();
                        leftImage = headerViewModel.getLeftImage();
                    } else {
                        leftImageUri = null;
                        leftImage = null;
                    }
                    j5 = 201361408;
                    updateRegistration(3, leftImageUri);
                    updateRegistration(23, leftImage);
                    if ((201326600 & j) != 0 && leftImageUri != null) {
                        leftImageUri.get();
                    }
                    if ((209715200 & j) != 0 && leftImage != null) {
                        leftImage.get();
                    }
                } else {
                    j5 = 201361408;
                    leftImageUri = null;
                    leftImage = null;
                }
                if ((j & 201588752) != 0) {
                    if (headerViewModel != null) {
                        rightCharging = headerViewModel.getRightCharging();
                        rightLevel = headerViewModel.getRightLevel();
                    } else {
                        rightCharging = null;
                        rightLevel = null;
                    }
                    j6 = 201327616;
                    updateRegistration(4, rightCharging);
                    updateRegistration(18, rightLevel);
                    if (rightCharging != null) {
                        bool20 = rightCharging.get();
                    } else {
                        bool20 = null;
                    }
                    if (rightLevel != null) {
                        i4 = rightLevel.get();
                    } else {
                        i4 = 0;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool20);
                } else {
                    j6 = 201327616;
                    zSafeUnbox = false;
                    i4 = 0;
                }
                if ((j & 201326624) == 0) {
                    bool9 = null;
                } else {
                    if (headerViewModel != null) {
                        caseVisible = headerViewModel.getCaseVisible();
                    } else {
                        caseVisible = null;
                    }
                    updateRegistration(5, caseVisible);
                    if (caseVisible != null) {
                        bool9 = caseVisible.get();
                    } else {
                        bool9 = null;
                    }
                }
                if ((j & 201326656) != 0) {
                    if (headerViewModel != null) {
                        rightBatteryVisible = headerViewModel.getRightBatteryVisible();
                    } else {
                        rightBatteryVisible = null;
                    }
                    j2 = j;
                    updateRegistration(6, rightBatteryVisible);
                    if (rightBatteryVisible != null) {
                        bool10 = rightBatteryVisible.get();
                    }
                    if ((j2 & 201326720) == 0) {
                        bool11 = null;
                    } else {
                        if (headerViewModel != null) {
                            leftVisible = headerViewModel.getLeftVisible();
                        } else {
                            leftVisible = null;
                        }
                        updateRegistration(7, leftVisible);
                        if (leftVisible != null) {
                            bool11 = leftVisible.get();
                        } else {
                            bool11 = null;
                        }
                    }
                    if ((j2 & 201343232) != 0) {
                        if (headerViewModel != null) {
                            leftLevel = headerViewModel.getLeftLevel();
                            leftCharging = headerViewModel.getLeftCharging();
                        } else {
                            leftCharging = null;
                            leftLevel = null;
                        }
                        updateRegistration(8, leftLevel);
                        updateRegistration(14, leftCharging);
                        if (leftLevel != null) {
                            i5 = leftLevel.get();
                        } else {
                            i5 = 0;
                        }
                        if (leftCharging != null) {
                            bool19 = leftCharging.get();
                        } else {
                            bool19 = null;
                        }
                        zSafeUnbox2 = ViewDataBinding.safeUnbox(bool19);
                    } else {
                        bool10 = bool10;
                        zSafeUnbox2 = false;
                        i5 = 0;
                    }
                    if ((j2 & 205521408) != 0) {
                        if (headerViewModel != null) {
                            caseLevel = headerViewModel.getCaseLevel();
                            caseCharging = headerViewModel.getCaseCharging();
                        } else {
                            caseCharging = null;
                            caseLevel = null;
                        }
                        updateRegistration(9, caseLevel);
                        updateRegistration(22, caseCharging);
                        if (caseLevel != null) {
                            i7 = caseLevel.get();
                        } else {
                            i7 = 0;
                        }
                        if (caseCharging != null) {
                            bool18 = caseCharging.get();
                        } else {
                            bool18 = null;
                        }
                        int i8 = i7;
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(bool18);
                        i6 = i8;
                    } else {
                        zSafeUnbox2 = zSafeUnbox2;
                        i6 = 0;
                        zSafeUnbox3 = false;
                    }
                    if ((j2 & j6) == 0) {
                        str8 = null;
                    } else {
                        if (headerViewModel != null) {
                            caseBattery = headerViewModel.getCaseBattery();
                        } else {
                            caseBattery = null;
                        }
                        updateRegistration(10, caseBattery);
                        if (caseBattery != null) {
                            str8 = caseBattery.get();
                        } else {
                            str8 = null;
                        }
                    }
                    if ((j2 & j5) != 0) {
                        if (headerViewModel != null) {
                            rightImage = headerViewModel.getRightImage();
                            rightImageUri = headerViewModel.getRightImageUri();
                        } else {
                            rightImageUri = null;
                            rightImage = null;
                        }
                        str9 = str8;
                        updateRegistration(11, rightImage);
                        updateRegistration(15, rightImageUri);
                        if ((j2 & 201328640) != 0 && rightImage != null) {
                            rightImage.get();
                        }
                        if ((j2 & 201359360) != 0 && rightImageUri != null) {
                            rightImageUri.get();
                        }
                    } else {
                        i6 = i6;
                        str9 = str8;
                        rightImageUri = null;
                        rightImage = null;
                    }
                    if ((j2 & 201330688) != 0) {
                        if (headerViewModel != null) {
                            title = headerViewModel.getTitle();
                        } else {
                            title = null;
                        }
                        observableField5 = rightImageUri;
                        updateRegistration(12, title);
                        if (title != null) {
                            str10 = title.get();
                        }
                        if ((j2 & 201392128) != 0) {
                            if (headerViewModel != null) {
                                leftBattery = headerViewModel.getLeftBattery();
                            } else {
                                leftBattery = null;
                            }
                            str11 = str10;
                            updateRegistration(16, leftBattery);
                            if (leftBattery != null) {
                                str12 = leftBattery.get();
                            }
                            if ((j2 & 201457664) != 0) {
                                if (headerViewModel != null) {
                                    rightVisible = headerViewModel.getRightVisible();
                                } else {
                                    rightVisible = null;
                                }
                                str13 = str12;
                                updateRegistration(17, rightVisible);
                                if (rightVisible != null) {
                                    bool12 = rightVisible.get();
                                }
                                if ((j2 & j4) != 0) {
                                    if (headerViewModel != null) {
                                        caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                                    } else {
                                        caseBatteryVisible = null;
                                    }
                                    bool13 = bool12;
                                    updateRegistration(19, caseBatteryVisible);
                                    if (caseBatteryVisible != null) {
                                        bool14 = caseBatteryVisible.get();
                                    }
                                    if ((j2 & j3) != 0) {
                                        if (headerViewModel != null) {
                                            rightBattery = headerViewModel.getRightBattery();
                                        } else {
                                            rightBattery = null;
                                        }
                                        bool15 = bool14;
                                        updateRegistration(20, rightBattery);
                                        if (rightBattery != null) {
                                            str14 = rightBattery.get();
                                        }
                                        if ((j2 & 203423744) != 0) {
                                            if (headerViewModel != null) {
                                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                            } else {
                                                leftBatteryVisible = null;
                                            }
                                            str15 = str14;
                                            updateRegistration(21, leftBatteryVisible);
                                            if (leftBatteryVisible != null) {
                                                bool16 = leftBatteryVisible.get();
                                            }
                                            if ((j2 & 218103808) != 0) {
                                                if (headerViewModel != null) {
                                                    summary = headerViewModel.getSummary();
                                                } else {
                                                    summary = null;
                                                }
                                                bool17 = bool16;
                                                updateRegistration(24, summary);
                                                if (summary != null) {
                                                    str16 = summary.get();
                                                }
                                            } else {
                                                bool17 = bool16;
                                            }
                                            observableField3 = caseUri;
                                            bool = bool8;
                                            observableField4 = caseImage;
                                            observableField2 = rightImage;
                                            str2 = str16;
                                            bool5 = bool10;
                                            bool4 = bool11;
                                            z = zSafeUnbox2;
                                            i = i5;
                                            i3 = i6;
                                            str5 = str9;
                                            observableField = observableField5;
                                            str = str13;
                                            str6 = str15;
                                            bool6 = bool17;
                                            i2 = i4;
                                            z3 = zSafeUnbox3;
                                            bool7 = bool9;
                                            str4 = str7;
                                            z2 = zSafeUnbox;
                                            str3 = str11;
                                            bool3 = bool13;
                                            bool2 = bool15;
                                        } else {
                                            str15 = str14;
                                        }
                                        bool16 = null;
                                        if ((j2 & 218103808) != 0) {
                                            if (headerViewModel != null) {
                                                summary = headerViewModel.getSummary();
                                            } else {
                                                summary = null;
                                            }
                                            bool17 = bool16;
                                            updateRegistration(24, summary);
                                            if (summary != null) {
                                                str16 = summary.get();
                                            }
                                        } else {
                                            bool17 = bool16;
                                        }
                                        observableField3 = caseUri;
                                        bool = bool8;
                                        observableField4 = caseImage;
                                        observableField2 = rightImage;
                                        str2 = str16;
                                        bool5 = bool10;
                                        bool4 = bool11;
                                        z = zSafeUnbox2;
                                        i = i5;
                                        i3 = i6;
                                        str5 = str9;
                                        observableField = observableField5;
                                        str = str13;
                                        str6 = str15;
                                        bool6 = bool17;
                                        i2 = i4;
                                        z3 = zSafeUnbox3;
                                        bool7 = bool9;
                                        str4 = str7;
                                        z2 = zSafeUnbox;
                                        str3 = str11;
                                        bool3 = bool13;
                                        bool2 = bool15;
                                    } else {
                                        bool15 = bool14;
                                    }
                                    str14 = null;
                                    if ((j2 & 203423744) != 0) {
                                        if (headerViewModel != null) {
                                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                        } else {
                                            leftBatteryVisible = null;
                                        }
                                        str15 = str14;
                                        updateRegistration(21, leftBatteryVisible);
                                        if (leftBatteryVisible != null) {
                                            bool16 = leftBatteryVisible.get();
                                        }
                                        if ((j2 & 218103808) != 0) {
                                            if (headerViewModel != null) {
                                                summary = headerViewModel.getSummary();
                                            } else {
                                                summary = null;
                                            }
                                            bool17 = bool16;
                                            updateRegistration(24, summary);
                                            if (summary != null) {
                                                str16 = summary.get();
                                            }
                                        } else {
                                            bool17 = bool16;
                                        }
                                        observableField3 = caseUri;
                                        bool = bool8;
                                        observableField4 = caseImage;
                                        observableField2 = rightImage;
                                        str2 = str16;
                                        bool5 = bool10;
                                        bool4 = bool11;
                                        z = zSafeUnbox2;
                                        i = i5;
                                        i3 = i6;
                                        str5 = str9;
                                        observableField = observableField5;
                                        str = str13;
                                        str6 = str15;
                                        bool6 = bool17;
                                        i2 = i4;
                                        z3 = zSafeUnbox3;
                                        bool7 = bool9;
                                        str4 = str7;
                                        z2 = zSafeUnbox;
                                        str3 = str11;
                                        bool3 = bool13;
                                        bool2 = bool15;
                                    } else {
                                        str15 = str14;
                                    }
                                    bool16 = null;
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    bool13 = bool12;
                                }
                                bool14 = null;
                                if ((j2 & j3) != 0) {
                                    if (headerViewModel != null) {
                                        rightBattery = headerViewModel.getRightBattery();
                                    } else {
                                        rightBattery = null;
                                    }
                                    bool15 = bool14;
                                    updateRegistration(20, rightBattery);
                                    if (rightBattery != null) {
                                        str14 = rightBattery.get();
                                    }
                                    if ((j2 & 203423744) != 0) {
                                        if (headerViewModel != null) {
                                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                        } else {
                                            leftBatteryVisible = null;
                                        }
                                        str15 = str14;
                                        updateRegistration(21, leftBatteryVisible);
                                        if (leftBatteryVisible != null) {
                                            bool16 = leftBatteryVisible.get();
                                        }
                                        if ((j2 & 218103808) != 0) {
                                            if (headerViewModel != null) {
                                                summary = headerViewModel.getSummary();
                                            } else {
                                                summary = null;
                                            }
                                            bool17 = bool16;
                                            updateRegistration(24, summary);
                                            if (summary != null) {
                                                str16 = summary.get();
                                            }
                                        } else {
                                            bool17 = bool16;
                                        }
                                        observableField3 = caseUri;
                                        bool = bool8;
                                        observableField4 = caseImage;
                                        observableField2 = rightImage;
                                        str2 = str16;
                                        bool5 = bool10;
                                        bool4 = bool11;
                                        z = zSafeUnbox2;
                                        i = i5;
                                        i3 = i6;
                                        str5 = str9;
                                        observableField = observableField5;
                                        str = str13;
                                        str6 = str15;
                                        bool6 = bool17;
                                        i2 = i4;
                                        z3 = zSafeUnbox3;
                                        bool7 = bool9;
                                        str4 = str7;
                                        z2 = zSafeUnbox;
                                        str3 = str11;
                                        bool3 = bool13;
                                        bool2 = bool15;
                                    } else {
                                        str15 = str14;
                                    }
                                    bool16 = null;
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    bool15 = bool14;
                                }
                                str14 = null;
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str13 = str12;
                            }
                            bool12 = null;
                            if ((j2 & j4) != 0) {
                                if (headerViewModel != null) {
                                    caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                                } else {
                                    caseBatteryVisible = null;
                                }
                                bool13 = bool12;
                                updateRegistration(19, caseBatteryVisible);
                                if (caseBatteryVisible != null) {
                                    bool14 = caseBatteryVisible.get();
                                }
                                if ((j2 & j3) != 0) {
                                    if (headerViewModel != null) {
                                        rightBattery = headerViewModel.getRightBattery();
                                    } else {
                                        rightBattery = null;
                                    }
                                    bool15 = bool14;
                                    updateRegistration(20, rightBattery);
                                    if (rightBattery != null) {
                                        str14 = rightBattery.get();
                                    }
                                    if ((j2 & 203423744) != 0) {
                                        if (headerViewModel != null) {
                                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                        } else {
                                            leftBatteryVisible = null;
                                        }
                                        str15 = str14;
                                        updateRegistration(21, leftBatteryVisible);
                                        if (leftBatteryVisible != null) {
                                            bool16 = leftBatteryVisible.get();
                                        }
                                        if ((j2 & 218103808) != 0) {
                                            if (headerViewModel != null) {
                                                summary = headerViewModel.getSummary();
                                            } else {
                                                summary = null;
                                            }
                                            bool17 = bool16;
                                            updateRegistration(24, summary);
                                            if (summary != null) {
                                                str16 = summary.get();
                                            }
                                        } else {
                                            bool17 = bool16;
                                        }
                                        observableField3 = caseUri;
                                        bool = bool8;
                                        observableField4 = caseImage;
                                        observableField2 = rightImage;
                                        str2 = str16;
                                        bool5 = bool10;
                                        bool4 = bool11;
                                        z = zSafeUnbox2;
                                        i = i5;
                                        i3 = i6;
                                        str5 = str9;
                                        observableField = observableField5;
                                        str = str13;
                                        str6 = str15;
                                        bool6 = bool17;
                                        i2 = i4;
                                        z3 = zSafeUnbox3;
                                        bool7 = bool9;
                                        str4 = str7;
                                        z2 = zSafeUnbox;
                                        str3 = str11;
                                        bool3 = bool13;
                                        bool2 = bool15;
                                    } else {
                                        str15 = str14;
                                    }
                                    bool16 = null;
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    bool15 = bool14;
                                }
                                str14 = null;
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool13 = bool12;
                            }
                            bool14 = null;
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str11 = str10;
                        }
                        str12 = null;
                        if ((j2 & 201457664) != 0) {
                            if (headerViewModel != null) {
                                rightVisible = headerViewModel.getRightVisible();
                            } else {
                                rightVisible = null;
                            }
                            str13 = str12;
                            updateRegistration(17, rightVisible);
                            if (rightVisible != null) {
                                bool12 = rightVisible.get();
                            }
                            if ((j2 & j4) != 0) {
                                if (headerViewModel != null) {
                                    caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                                } else {
                                    caseBatteryVisible = null;
                                }
                                bool13 = bool12;
                                updateRegistration(19, caseBatteryVisible);
                                if (caseBatteryVisible != null) {
                                    bool14 = caseBatteryVisible.get();
                                }
                                if ((j2 & j3) != 0) {
                                    if (headerViewModel != null) {
                                        rightBattery = headerViewModel.getRightBattery();
                                    } else {
                                        rightBattery = null;
                                    }
                                    bool15 = bool14;
                                    updateRegistration(20, rightBattery);
                                    if (rightBattery != null) {
                                        str14 = rightBattery.get();
                                    }
                                    if ((j2 & 203423744) != 0) {
                                        if (headerViewModel != null) {
                                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                        } else {
                                            leftBatteryVisible = null;
                                        }
                                        str15 = str14;
                                        updateRegistration(21, leftBatteryVisible);
                                        if (leftBatteryVisible != null) {
                                            bool16 = leftBatteryVisible.get();
                                        }
                                        if ((j2 & 218103808) != 0) {
                                            if (headerViewModel != null) {
                                                summary = headerViewModel.getSummary();
                                            } else {
                                                summary = null;
                                            }
                                            bool17 = bool16;
                                            updateRegistration(24, summary);
                                            if (summary != null) {
                                                str16 = summary.get();
                                            }
                                        } else {
                                            bool17 = bool16;
                                        }
                                        observableField3 = caseUri;
                                        bool = bool8;
                                        observableField4 = caseImage;
                                        observableField2 = rightImage;
                                        str2 = str16;
                                        bool5 = bool10;
                                        bool4 = bool11;
                                        z = zSafeUnbox2;
                                        i = i5;
                                        i3 = i6;
                                        str5 = str9;
                                        observableField = observableField5;
                                        str = str13;
                                        str6 = str15;
                                        bool6 = bool17;
                                        i2 = i4;
                                        z3 = zSafeUnbox3;
                                        bool7 = bool9;
                                        str4 = str7;
                                        z2 = zSafeUnbox;
                                        str3 = str11;
                                        bool3 = bool13;
                                        bool2 = bool15;
                                    } else {
                                        str15 = str14;
                                    }
                                    bool16 = null;
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    bool15 = bool14;
                                }
                                str14 = null;
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool13 = bool12;
                            }
                            bool14 = null;
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str13 = str12;
                        }
                        bool12 = null;
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        observableField5 = rightImageUri;
                    }
                    str10 = null;
                    if ((j2 & 201392128) != 0) {
                        if (headerViewModel != null) {
                            leftBattery = headerViewModel.getLeftBattery();
                        } else {
                            leftBattery = null;
                        }
                        str11 = str10;
                        updateRegistration(16, leftBattery);
                        if (leftBattery != null) {
                            str12 = leftBattery.get();
                        }
                        if ((j2 & 201457664) != 0) {
                            if (headerViewModel != null) {
                                rightVisible = headerViewModel.getRightVisible();
                            } else {
                                rightVisible = null;
                            }
                            str13 = str12;
                            updateRegistration(17, rightVisible);
                            if (rightVisible != null) {
                                bool12 = rightVisible.get();
                            }
                            if ((j2 & j4) != 0) {
                                if (headerViewModel != null) {
                                    caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                                } else {
                                    caseBatteryVisible = null;
                                }
                                bool13 = bool12;
                                updateRegistration(19, caseBatteryVisible);
                                if (caseBatteryVisible != null) {
                                    bool14 = caseBatteryVisible.get();
                                }
                                if ((j2 & j3) != 0) {
                                    if (headerViewModel != null) {
                                        rightBattery = headerViewModel.getRightBattery();
                                    } else {
                                        rightBattery = null;
                                    }
                                    bool15 = bool14;
                                    updateRegistration(20, rightBattery);
                                    if (rightBattery != null) {
                                        str14 = rightBattery.get();
                                    }
                                    if ((j2 & 203423744) != 0) {
                                        if (headerViewModel != null) {
                                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                        } else {
                                            leftBatteryVisible = null;
                                        }
                                        str15 = str14;
                                        updateRegistration(21, leftBatteryVisible);
                                        if (leftBatteryVisible != null) {
                                            bool16 = leftBatteryVisible.get();
                                        }
                                        if ((j2 & 218103808) != 0) {
                                            if (headerViewModel != null) {
                                                summary = headerViewModel.getSummary();
                                            } else {
                                                summary = null;
                                            }
                                            bool17 = bool16;
                                            updateRegistration(24, summary);
                                            if (summary != null) {
                                                str16 = summary.get();
                                            }
                                        } else {
                                            bool17 = bool16;
                                        }
                                        observableField3 = caseUri;
                                        bool = bool8;
                                        observableField4 = caseImage;
                                        observableField2 = rightImage;
                                        str2 = str16;
                                        bool5 = bool10;
                                        bool4 = bool11;
                                        z = zSafeUnbox2;
                                        i = i5;
                                        i3 = i6;
                                        str5 = str9;
                                        observableField = observableField5;
                                        str = str13;
                                        str6 = str15;
                                        bool6 = bool17;
                                        i2 = i4;
                                        z3 = zSafeUnbox3;
                                        bool7 = bool9;
                                        str4 = str7;
                                        z2 = zSafeUnbox;
                                        str3 = str11;
                                        bool3 = bool13;
                                        bool2 = bool15;
                                    } else {
                                        str15 = str14;
                                    }
                                    bool16 = null;
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    bool15 = bool14;
                                }
                                str14 = null;
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool13 = bool12;
                            }
                            bool14 = null;
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str13 = str12;
                        }
                        bool12 = null;
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str11 = str10;
                    }
                    str12 = null;
                    if ((j2 & 201457664) != 0) {
                        if (headerViewModel != null) {
                            rightVisible = headerViewModel.getRightVisible();
                        } else {
                            rightVisible = null;
                        }
                        str13 = str12;
                        updateRegistration(17, rightVisible);
                        if (rightVisible != null) {
                            bool12 = rightVisible.get();
                        }
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str13 = str12;
                    }
                    bool12 = null;
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    j2 = j;
                }
                bool10 = null;
                if ((j2 & 201326720) == 0) {
                    bool11 = null;
                } else {
                    if (headerViewModel != null) {
                        leftVisible = headerViewModel.getLeftVisible();
                    } else {
                        leftVisible = null;
                    }
                    updateRegistration(7, leftVisible);
                    if (leftVisible != null) {
                        bool11 = leftVisible.get();
                    } else {
                        bool11 = null;
                    }
                }
                if ((j2 & 201343232) != 0) {
                    if (headerViewModel != null) {
                        leftLevel = headerViewModel.getLeftLevel();
                        leftCharging = headerViewModel.getLeftCharging();
                    } else {
                        leftCharging = null;
                        leftLevel = null;
                    }
                    updateRegistration(8, leftLevel);
                    updateRegistration(14, leftCharging);
                    if (leftLevel != null) {
                        i5 = leftLevel.get();
                    } else {
                        i5 = 0;
                    }
                    if (leftCharging != null) {
                        bool19 = leftCharging.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(bool19);
                } else {
                    bool10 = bool10;
                    zSafeUnbox2 = false;
                    i5 = 0;
                }
                if ((j2 & 205521408) != 0) {
                    if (headerViewModel != null) {
                        caseLevel = headerViewModel.getCaseLevel();
                        caseCharging = headerViewModel.getCaseCharging();
                    } else {
                        caseCharging = null;
                        caseLevel = null;
                    }
                    updateRegistration(9, caseLevel);
                    updateRegistration(22, caseCharging);
                    if (caseLevel != null) {
                        i7 = caseLevel.get();
                    } else {
                        i7 = 0;
                    }
                    if (caseCharging != null) {
                        bool18 = caseCharging.get();
                    } else {
                        bool18 = null;
                    }
                    int i9 = i7;
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(bool18);
                    i6 = i9;
                } else {
                    zSafeUnbox2 = zSafeUnbox2;
                    i6 = 0;
                    zSafeUnbox3 = false;
                }
                if ((j2 & j6) == 0) {
                    str8 = null;
                } else {
                    if (headerViewModel != null) {
                        caseBattery = headerViewModel.getCaseBattery();
                    } else {
                        caseBattery = null;
                    }
                    updateRegistration(10, caseBattery);
                    if (caseBattery != null) {
                        str8 = caseBattery.get();
                    } else {
                        str8 = null;
                    }
                }
                if ((j2 & j5) != 0) {
                    if (headerViewModel != null) {
                        rightImage = headerViewModel.getRightImage();
                        rightImageUri = headerViewModel.getRightImageUri();
                    } else {
                        rightImageUri = null;
                        rightImage = null;
                    }
                    str9 = str8;
                    updateRegistration(11, rightImage);
                    updateRegistration(15, rightImageUri);
                    if ((j2 & 201328640) != 0) {
                        rightImage.get();
                    }
                    if ((j2 & 201359360) != 0) {
                        rightImageUri.get();
                    }
                } else {
                    i6 = i6;
                    str9 = str8;
                    rightImageUri = null;
                    rightImage = null;
                }
                if ((j2 & 201330688) != 0) {
                    if (headerViewModel != null) {
                        title = headerViewModel.getTitle();
                    } else {
                        title = null;
                    }
                    observableField5 = rightImageUri;
                    updateRegistration(12, title);
                    if (title != null) {
                        str10 = title.get();
                    }
                    if ((j2 & 201392128) != 0) {
                        if (headerViewModel != null) {
                            leftBattery = headerViewModel.getLeftBattery();
                        } else {
                            leftBattery = null;
                        }
                        str11 = str10;
                        updateRegistration(16, leftBattery);
                        if (leftBattery != null) {
                            str12 = leftBattery.get();
                        }
                        if ((j2 & 201457664) != 0) {
                            if (headerViewModel != null) {
                                rightVisible = headerViewModel.getRightVisible();
                            } else {
                                rightVisible = null;
                            }
                            str13 = str12;
                            updateRegistration(17, rightVisible);
                            if (rightVisible != null) {
                                bool12 = rightVisible.get();
                            }
                            if ((j2 & j4) != 0) {
                                if (headerViewModel != null) {
                                    caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                                } else {
                                    caseBatteryVisible = null;
                                }
                                bool13 = bool12;
                                updateRegistration(19, caseBatteryVisible);
                                if (caseBatteryVisible != null) {
                                    bool14 = caseBatteryVisible.get();
                                }
                                if ((j2 & j3) != 0) {
                                    if (headerViewModel != null) {
                                        rightBattery = headerViewModel.getRightBattery();
                                    } else {
                                        rightBattery = null;
                                    }
                                    bool15 = bool14;
                                    updateRegistration(20, rightBattery);
                                    if (rightBattery != null) {
                                        str14 = rightBattery.get();
                                    }
                                    if ((j2 & 203423744) != 0) {
                                        if (headerViewModel != null) {
                                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                        } else {
                                            leftBatteryVisible = null;
                                        }
                                        str15 = str14;
                                        updateRegistration(21, leftBatteryVisible);
                                        if (leftBatteryVisible != null) {
                                            bool16 = leftBatteryVisible.get();
                                        }
                                        if ((j2 & 218103808) != 0) {
                                            if (headerViewModel != null) {
                                                summary = headerViewModel.getSummary();
                                            } else {
                                                summary = null;
                                            }
                                            bool17 = bool16;
                                            updateRegistration(24, summary);
                                            if (summary != null) {
                                                str16 = summary.get();
                                            }
                                        } else {
                                            bool17 = bool16;
                                        }
                                        observableField3 = caseUri;
                                        bool = bool8;
                                        observableField4 = caseImage;
                                        observableField2 = rightImage;
                                        str2 = str16;
                                        bool5 = bool10;
                                        bool4 = bool11;
                                        z = zSafeUnbox2;
                                        i = i5;
                                        i3 = i6;
                                        str5 = str9;
                                        observableField = observableField5;
                                        str = str13;
                                        str6 = str15;
                                        bool6 = bool17;
                                        i2 = i4;
                                        z3 = zSafeUnbox3;
                                        bool7 = bool9;
                                        str4 = str7;
                                        z2 = zSafeUnbox;
                                        str3 = str11;
                                        bool3 = bool13;
                                        bool2 = bool15;
                                    } else {
                                        str15 = str14;
                                    }
                                    bool16 = null;
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    bool15 = bool14;
                                }
                                str14 = null;
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool13 = bool12;
                            }
                            bool14 = null;
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str13 = str12;
                        }
                        bool12 = null;
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str11 = str10;
                    }
                    str12 = null;
                    if ((j2 & 201457664) != 0) {
                        if (headerViewModel != null) {
                            rightVisible = headerViewModel.getRightVisible();
                        } else {
                            rightVisible = null;
                        }
                        str13 = str12;
                        updateRegistration(17, rightVisible);
                        if (rightVisible != null) {
                            bool12 = rightVisible.get();
                        }
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str13 = str12;
                    }
                    bool12 = null;
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    observableField5 = rightImageUri;
                }
                str10 = null;
                if ((j2 & 201392128) != 0) {
                    if (headerViewModel != null) {
                        leftBattery = headerViewModel.getLeftBattery();
                    } else {
                        leftBattery = null;
                    }
                    str11 = str10;
                    updateRegistration(16, leftBattery);
                    if (leftBattery != null) {
                        str12 = leftBattery.get();
                    }
                    if ((j2 & 201457664) != 0) {
                        if (headerViewModel != null) {
                            rightVisible = headerViewModel.getRightVisible();
                        } else {
                            rightVisible = null;
                        }
                        str13 = str12;
                        updateRegistration(17, rightVisible);
                        if (rightVisible != null) {
                            bool12 = rightVisible.get();
                        }
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str13 = str12;
                    }
                    bool12 = null;
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str11 = str10;
                }
                str12 = null;
                if ((j2 & 201457664) != 0) {
                    if (headerViewModel != null) {
                        rightVisible = headerViewModel.getRightVisible();
                    } else {
                        rightVisible = null;
                    }
                    str13 = str12;
                    updateRegistration(17, rightVisible);
                    if (rightVisible != null) {
                        bool12 = rightVisible.get();
                    }
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str13 = str12;
                }
                bool12 = null;
                if ((j2 & j4) != 0) {
                    if (headerViewModel != null) {
                        caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                    } else {
                        caseBatteryVisible = null;
                    }
                    bool13 = bool12;
                    updateRegistration(19, caseBatteryVisible);
                    if (caseBatteryVisible != null) {
                        bool14 = caseBatteryVisible.get();
                    }
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool13 = bool12;
                }
                bool14 = null;
                if ((j2 & j3) != 0) {
                    if (headerViewModel != null) {
                        rightBattery = headerViewModel.getRightBattery();
                    } else {
                        rightBattery = null;
                    }
                    bool15 = bool14;
                    updateRegistration(20, rightBattery);
                    if (rightBattery != null) {
                        str14 = rightBattery.get();
                    }
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool15 = bool14;
                }
                str14 = null;
                if ((j2 & 203423744) != 0) {
                    if (headerViewModel != null) {
                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                    } else {
                        leftBatteryVisible = null;
                    }
                    str15 = str14;
                    updateRegistration(21, leftBatteryVisible);
                    if (leftBatteryVisible != null) {
                        bool16 = leftBatteryVisible.get();
                    }
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str15 = str14;
                }
                bool16 = null;
                if ((j2 & 218103808) != 0) {
                    if (headerViewModel != null) {
                        summary = headerViewModel.getSummary();
                    } else {
                        summary = null;
                    }
                    bool17 = bool16;
                    updateRegistration(24, summary);
                    if (summary != null) {
                        str16 = summary.get();
                    }
                } else {
                    bool17 = bool16;
                }
                observableField3 = caseUri;
                bool = bool8;
                observableField4 = caseImage;
                observableField2 = rightImage;
                str2 = str16;
                bool5 = bool10;
                bool4 = bool11;
                z = zSafeUnbox2;
                i = i5;
                i3 = i6;
                str5 = str9;
                observableField = observableField5;
                str = str13;
                str6 = str15;
                bool6 = bool17;
                i2 = i4;
                z3 = zSafeUnbox3;
                bool7 = bool9;
                str4 = str7;
                z2 = zSafeUnbox;
                str3 = str11;
                bool3 = bool13;
                bool2 = bool15;
            } else {
                j4 = 201850880;
            }
            str7 = null;
            if ((j & 209715208) != 0) {
                if (headerViewModel != null) {
                    leftImageUri = headerViewModel.getLeftImageUri();
                    leftImage = headerViewModel.getLeftImage();
                } else {
                    leftImageUri = null;
                    leftImage = null;
                }
                j5 = 201361408;
                updateRegistration(3, leftImageUri);
                updateRegistration(23, leftImage);
                if ((201326600 & j) != 0) {
                    leftImageUri.get();
                }
                if ((209715200 & j) != 0) {
                    leftImage.get();
                }
            } else {
                j5 = 201361408;
                leftImageUri = null;
                leftImage = null;
            }
            if ((j & 201588752) != 0) {
                if (headerViewModel != null) {
                    rightCharging = headerViewModel.getRightCharging();
                    rightLevel = headerViewModel.getRightLevel();
                } else {
                    rightCharging = null;
                    rightLevel = null;
                }
                j6 = 201327616;
                updateRegistration(4, rightCharging);
                updateRegistration(18, rightLevel);
                if (rightCharging != null) {
                    bool20 = rightCharging.get();
                } else {
                    bool20 = null;
                }
                if (rightLevel != null) {
                    i4 = rightLevel.get();
                } else {
                    i4 = 0;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(bool20);
            } else {
                j6 = 201327616;
                zSafeUnbox = false;
                i4 = 0;
            }
            if ((j & 201326624) == 0) {
                bool9 = null;
            } else {
                if (headerViewModel != null) {
                    caseVisible = headerViewModel.getCaseVisible();
                } else {
                    caseVisible = null;
                }
                updateRegistration(5, caseVisible);
                if (caseVisible != null) {
                    bool9 = caseVisible.get();
                } else {
                    bool9 = null;
                }
            }
            if ((j & 201326656) != 0) {
                if (headerViewModel != null) {
                    rightBatteryVisible = headerViewModel.getRightBatteryVisible();
                } else {
                    rightBatteryVisible = null;
                }
                j2 = j;
                updateRegistration(6, rightBatteryVisible);
                if (rightBatteryVisible != null) {
                    bool10 = rightBatteryVisible.get();
                }
                if ((j2 & 201326720) == 0) {
                    bool11 = null;
                } else {
                    if (headerViewModel != null) {
                        leftVisible = headerViewModel.getLeftVisible();
                    } else {
                        leftVisible = null;
                    }
                    updateRegistration(7, leftVisible);
                    if (leftVisible != null) {
                        bool11 = leftVisible.get();
                    } else {
                        bool11 = null;
                    }
                }
                if ((j2 & 201343232) != 0) {
                    if (headerViewModel != null) {
                        leftLevel = headerViewModel.getLeftLevel();
                        leftCharging = headerViewModel.getLeftCharging();
                    } else {
                        leftCharging = null;
                        leftLevel = null;
                    }
                    updateRegistration(8, leftLevel);
                    updateRegistration(14, leftCharging);
                    if (leftLevel != null) {
                        i5 = leftLevel.get();
                    } else {
                        i5 = 0;
                    }
                    if (leftCharging != null) {
                        bool19 = leftCharging.get();
                    } else {
                        bool19 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(bool19);
                } else {
                    bool10 = bool10;
                    zSafeUnbox2 = false;
                    i5 = 0;
                }
                if ((j2 & 205521408) != 0) {
                    if (headerViewModel != null) {
                        caseLevel = headerViewModel.getCaseLevel();
                        caseCharging = headerViewModel.getCaseCharging();
                    } else {
                        caseCharging = null;
                        caseLevel = null;
                    }
                    updateRegistration(9, caseLevel);
                    updateRegistration(22, caseCharging);
                    if (caseLevel != null) {
                        i7 = caseLevel.get();
                    } else {
                        i7 = 0;
                    }
                    if (caseCharging != null) {
                        bool18 = caseCharging.get();
                    } else {
                        bool18 = null;
                    }
                    int i10 = i7;
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(bool18);
                    i6 = i10;
                } else {
                    zSafeUnbox2 = zSafeUnbox2;
                    i6 = 0;
                    zSafeUnbox3 = false;
                }
                if ((j2 & j6) == 0) {
                    str8 = null;
                } else {
                    if (headerViewModel != null) {
                        caseBattery = headerViewModel.getCaseBattery();
                    } else {
                        caseBattery = null;
                    }
                    updateRegistration(10, caseBattery);
                    if (caseBattery != null) {
                        str8 = caseBattery.get();
                    } else {
                        str8 = null;
                    }
                }
                if ((j2 & j5) != 0) {
                    if (headerViewModel != null) {
                        rightImage = headerViewModel.getRightImage();
                        rightImageUri = headerViewModel.getRightImageUri();
                    } else {
                        rightImageUri = null;
                        rightImage = null;
                    }
                    str9 = str8;
                    updateRegistration(11, rightImage);
                    updateRegistration(15, rightImageUri);
                    if ((j2 & 201328640) != 0) {
                        rightImage.get();
                    }
                    if ((j2 & 201359360) != 0) {
                        rightImageUri.get();
                    }
                } else {
                    i6 = i6;
                    str9 = str8;
                    rightImageUri = null;
                    rightImage = null;
                }
                if ((j2 & 201330688) != 0) {
                    if (headerViewModel != null) {
                        title = headerViewModel.getTitle();
                    } else {
                        title = null;
                    }
                    observableField5 = rightImageUri;
                    updateRegistration(12, title);
                    if (title != null) {
                        str10 = title.get();
                    }
                    if ((j2 & 201392128) != 0) {
                        if (headerViewModel != null) {
                            leftBattery = headerViewModel.getLeftBattery();
                        } else {
                            leftBattery = null;
                        }
                        str11 = str10;
                        updateRegistration(16, leftBattery);
                        if (leftBattery != null) {
                            str12 = leftBattery.get();
                        }
                        if ((j2 & 201457664) != 0) {
                            if (headerViewModel != null) {
                                rightVisible = headerViewModel.getRightVisible();
                            } else {
                                rightVisible = null;
                            }
                            str13 = str12;
                            updateRegistration(17, rightVisible);
                            if (rightVisible != null) {
                                bool12 = rightVisible.get();
                            }
                            if ((j2 & j4) != 0) {
                                if (headerViewModel != null) {
                                    caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                                } else {
                                    caseBatteryVisible = null;
                                }
                                bool13 = bool12;
                                updateRegistration(19, caseBatteryVisible);
                                if (caseBatteryVisible != null) {
                                    bool14 = caseBatteryVisible.get();
                                }
                                if ((j2 & j3) != 0) {
                                    if (headerViewModel != null) {
                                        rightBattery = headerViewModel.getRightBattery();
                                    } else {
                                        rightBattery = null;
                                    }
                                    bool15 = bool14;
                                    updateRegistration(20, rightBattery);
                                    if (rightBattery != null) {
                                        str14 = rightBattery.get();
                                    }
                                    if ((j2 & 203423744) != 0) {
                                        if (headerViewModel != null) {
                                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                        } else {
                                            leftBatteryVisible = null;
                                        }
                                        str15 = str14;
                                        updateRegistration(21, leftBatteryVisible);
                                        if (leftBatteryVisible != null) {
                                            bool16 = leftBatteryVisible.get();
                                        }
                                        if ((j2 & 218103808) != 0) {
                                            if (headerViewModel != null) {
                                                summary = headerViewModel.getSummary();
                                            } else {
                                                summary = null;
                                            }
                                            bool17 = bool16;
                                            updateRegistration(24, summary);
                                            if (summary != null) {
                                                str16 = summary.get();
                                            }
                                        } else {
                                            bool17 = bool16;
                                        }
                                        observableField3 = caseUri;
                                        bool = bool8;
                                        observableField4 = caseImage;
                                        observableField2 = rightImage;
                                        str2 = str16;
                                        bool5 = bool10;
                                        bool4 = bool11;
                                        z = zSafeUnbox2;
                                        i = i5;
                                        i3 = i6;
                                        str5 = str9;
                                        observableField = observableField5;
                                        str = str13;
                                        str6 = str15;
                                        bool6 = bool17;
                                        i2 = i4;
                                        z3 = zSafeUnbox3;
                                        bool7 = bool9;
                                        str4 = str7;
                                        z2 = zSafeUnbox;
                                        str3 = str11;
                                        bool3 = bool13;
                                        bool2 = bool15;
                                    } else {
                                        str15 = str14;
                                    }
                                    bool16 = null;
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    bool15 = bool14;
                                }
                                str14 = null;
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool13 = bool12;
                            }
                            bool14 = null;
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str13 = str12;
                        }
                        bool12 = null;
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str11 = str10;
                    }
                    str12 = null;
                    if ((j2 & 201457664) != 0) {
                        if (headerViewModel != null) {
                            rightVisible = headerViewModel.getRightVisible();
                        } else {
                            rightVisible = null;
                        }
                        str13 = str12;
                        updateRegistration(17, rightVisible);
                        if (rightVisible != null) {
                            bool12 = rightVisible.get();
                        }
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str13 = str12;
                    }
                    bool12 = null;
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    observableField5 = rightImageUri;
                }
                str10 = null;
                if ((j2 & 201392128) != 0) {
                    if (headerViewModel != null) {
                        leftBattery = headerViewModel.getLeftBattery();
                    } else {
                        leftBattery = null;
                    }
                    str11 = str10;
                    updateRegistration(16, leftBattery);
                    if (leftBattery != null) {
                        str12 = leftBattery.get();
                    }
                    if ((j2 & 201457664) != 0) {
                        if (headerViewModel != null) {
                            rightVisible = headerViewModel.getRightVisible();
                        } else {
                            rightVisible = null;
                        }
                        str13 = str12;
                        updateRegistration(17, rightVisible);
                        if (rightVisible != null) {
                            bool12 = rightVisible.get();
                        }
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str13 = str12;
                    }
                    bool12 = null;
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str11 = str10;
                }
                str12 = null;
                if ((j2 & 201457664) != 0) {
                    if (headerViewModel != null) {
                        rightVisible = headerViewModel.getRightVisible();
                    } else {
                        rightVisible = null;
                    }
                    str13 = str12;
                    updateRegistration(17, rightVisible);
                    if (rightVisible != null) {
                        bool12 = rightVisible.get();
                    }
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str13 = str12;
                }
                bool12 = null;
                if ((j2 & j4) != 0) {
                    if (headerViewModel != null) {
                        caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                    } else {
                        caseBatteryVisible = null;
                    }
                    bool13 = bool12;
                    updateRegistration(19, caseBatteryVisible);
                    if (caseBatteryVisible != null) {
                        bool14 = caseBatteryVisible.get();
                    }
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool13 = bool12;
                }
                bool14 = null;
                if ((j2 & j3) != 0) {
                    if (headerViewModel != null) {
                        rightBattery = headerViewModel.getRightBattery();
                    } else {
                        rightBattery = null;
                    }
                    bool15 = bool14;
                    updateRegistration(20, rightBattery);
                    if (rightBattery != null) {
                        str14 = rightBattery.get();
                    }
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool15 = bool14;
                }
                str14 = null;
                if ((j2 & 203423744) != 0) {
                    if (headerViewModel != null) {
                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                    } else {
                        leftBatteryVisible = null;
                    }
                    str15 = str14;
                    updateRegistration(21, leftBatteryVisible);
                    if (leftBatteryVisible != null) {
                        bool16 = leftBatteryVisible.get();
                    }
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str15 = str14;
                }
                bool16 = null;
                if ((j2 & 218103808) != 0) {
                    if (headerViewModel != null) {
                        summary = headerViewModel.getSummary();
                    } else {
                        summary = null;
                    }
                    bool17 = bool16;
                    updateRegistration(24, summary);
                    if (summary != null) {
                        str16 = summary.get();
                    }
                } else {
                    bool17 = bool16;
                }
                observableField3 = caseUri;
                bool = bool8;
                observableField4 = caseImage;
                observableField2 = rightImage;
                str2 = str16;
                bool5 = bool10;
                bool4 = bool11;
                z = zSafeUnbox2;
                i = i5;
                i3 = i6;
                str5 = str9;
                observableField = observableField5;
                str = str13;
                str6 = str15;
                bool6 = bool17;
                i2 = i4;
                z3 = zSafeUnbox3;
                bool7 = bool9;
                str4 = str7;
                z2 = zSafeUnbox;
                str3 = str11;
                bool3 = bool13;
                bool2 = bool15;
            } else {
                j2 = j;
            }
            bool10 = null;
            if ((j2 & 201326720) == 0) {
                bool11 = null;
            } else {
                if (headerViewModel != null) {
                    leftVisible = headerViewModel.getLeftVisible();
                } else {
                    leftVisible = null;
                }
                updateRegistration(7, leftVisible);
                if (leftVisible != null) {
                    bool11 = leftVisible.get();
                } else {
                    bool11 = null;
                }
            }
            if ((j2 & 201343232) != 0) {
                if (headerViewModel != null) {
                    leftLevel = headerViewModel.getLeftLevel();
                    leftCharging = headerViewModel.getLeftCharging();
                } else {
                    leftCharging = null;
                    leftLevel = null;
                }
                updateRegistration(8, leftLevel);
                updateRegistration(14, leftCharging);
                if (leftLevel != null) {
                    i5 = leftLevel.get();
                } else {
                    i5 = 0;
                }
                if (leftCharging != null) {
                    bool19 = leftCharging.get();
                } else {
                    bool19 = null;
                }
                zSafeUnbox2 = ViewDataBinding.safeUnbox(bool19);
            } else {
                bool10 = bool10;
                zSafeUnbox2 = false;
                i5 = 0;
            }
            if ((j2 & 205521408) != 0) {
                if (headerViewModel != null) {
                    caseLevel = headerViewModel.getCaseLevel();
                    caseCharging = headerViewModel.getCaseCharging();
                } else {
                    caseCharging = null;
                    caseLevel = null;
                }
                updateRegistration(9, caseLevel);
                updateRegistration(22, caseCharging);
                if (caseLevel != null) {
                    i7 = caseLevel.get();
                } else {
                    i7 = 0;
                }
                if (caseCharging != null) {
                    bool18 = caseCharging.get();
                } else {
                    bool18 = null;
                }
                int i11 = i7;
                zSafeUnbox3 = ViewDataBinding.safeUnbox(bool18);
                i6 = i11;
            } else {
                zSafeUnbox2 = zSafeUnbox2;
                i6 = 0;
                zSafeUnbox3 = false;
            }
            if ((j2 & j6) == 0) {
                str8 = null;
            } else {
                if (headerViewModel != null) {
                    caseBattery = headerViewModel.getCaseBattery();
                } else {
                    caseBattery = null;
                }
                updateRegistration(10, caseBattery);
                if (caseBattery != null) {
                    str8 = caseBattery.get();
                } else {
                    str8 = null;
                }
            }
            if ((j2 & j5) != 0) {
                if (headerViewModel != null) {
                    rightImage = headerViewModel.getRightImage();
                    rightImageUri = headerViewModel.getRightImageUri();
                } else {
                    rightImageUri = null;
                    rightImage = null;
                }
                str9 = str8;
                updateRegistration(11, rightImage);
                updateRegistration(15, rightImageUri);
                if ((j2 & 201328640) != 0) {
                    rightImage.get();
                }
                if ((j2 & 201359360) != 0) {
                    rightImageUri.get();
                }
            } else {
                i6 = i6;
                str9 = str8;
                rightImageUri = null;
                rightImage = null;
            }
            if ((j2 & 201330688) != 0) {
                if (headerViewModel != null) {
                    title = headerViewModel.getTitle();
                } else {
                    title = null;
                }
                observableField5 = rightImageUri;
                updateRegistration(12, title);
                if (title != null) {
                    str10 = title.get();
                }
                if ((j2 & 201392128) != 0) {
                    if (headerViewModel != null) {
                        leftBattery = headerViewModel.getLeftBattery();
                    } else {
                        leftBattery = null;
                    }
                    str11 = str10;
                    updateRegistration(16, leftBattery);
                    if (leftBattery != null) {
                        str12 = leftBattery.get();
                    }
                    if ((j2 & 201457664) != 0) {
                        if (headerViewModel != null) {
                            rightVisible = headerViewModel.getRightVisible();
                        } else {
                            rightVisible = null;
                        }
                        str13 = str12;
                        updateRegistration(17, rightVisible);
                        if (rightVisible != null) {
                            bool12 = rightVisible.get();
                        }
                        if ((j2 & j4) != 0) {
                            if (headerViewModel != null) {
                                caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                            } else {
                                caseBatteryVisible = null;
                            }
                            bool13 = bool12;
                            updateRegistration(19, caseBatteryVisible);
                            if (caseBatteryVisible != null) {
                                bool14 = caseBatteryVisible.get();
                            }
                            if ((j2 & j3) != 0) {
                                if (headerViewModel != null) {
                                    rightBattery = headerViewModel.getRightBattery();
                                } else {
                                    rightBattery = null;
                                }
                                bool15 = bool14;
                                updateRegistration(20, rightBattery);
                                if (rightBattery != null) {
                                    str14 = rightBattery.get();
                                }
                                if ((j2 & 203423744) != 0) {
                                    if (headerViewModel != null) {
                                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                    } else {
                                        leftBatteryVisible = null;
                                    }
                                    str15 = str14;
                                    updateRegistration(21, leftBatteryVisible);
                                    if (leftBatteryVisible != null) {
                                        bool16 = leftBatteryVisible.get();
                                    }
                                    if ((j2 & 218103808) != 0) {
                                        if (headerViewModel != null) {
                                            summary = headerViewModel.getSummary();
                                        } else {
                                            summary = null;
                                        }
                                        bool17 = bool16;
                                        updateRegistration(24, summary);
                                        if (summary != null) {
                                            str16 = summary.get();
                                        }
                                    } else {
                                        bool17 = bool16;
                                    }
                                    observableField3 = caseUri;
                                    bool = bool8;
                                    observableField4 = caseImage;
                                    observableField2 = rightImage;
                                    str2 = str16;
                                    bool5 = bool10;
                                    bool4 = bool11;
                                    z = zSafeUnbox2;
                                    i = i5;
                                    i3 = i6;
                                    str5 = str9;
                                    observableField = observableField5;
                                    str = str13;
                                    str6 = str15;
                                    bool6 = bool17;
                                    i2 = i4;
                                    z3 = zSafeUnbox3;
                                    bool7 = bool9;
                                    str4 = str7;
                                    z2 = zSafeUnbox;
                                    str3 = str11;
                                    bool3 = bool13;
                                    bool2 = bool15;
                                } else {
                                    str15 = str14;
                                }
                                bool16 = null;
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                bool15 = bool14;
                            }
                            str14 = null;
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool13 = bool12;
                        }
                        bool14 = null;
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str13 = str12;
                    }
                    bool12 = null;
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str11 = str10;
                }
                str12 = null;
                if ((j2 & 201457664) != 0) {
                    if (headerViewModel != null) {
                        rightVisible = headerViewModel.getRightVisible();
                    } else {
                        rightVisible = null;
                    }
                    str13 = str12;
                    updateRegistration(17, rightVisible);
                    if (rightVisible != null) {
                        bool12 = rightVisible.get();
                    }
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str13 = str12;
                }
                bool12 = null;
                if ((j2 & j4) != 0) {
                    if (headerViewModel != null) {
                        caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                    } else {
                        caseBatteryVisible = null;
                    }
                    bool13 = bool12;
                    updateRegistration(19, caseBatteryVisible);
                    if (caseBatteryVisible != null) {
                        bool14 = caseBatteryVisible.get();
                    }
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool13 = bool12;
                }
                bool14 = null;
                if ((j2 & j3) != 0) {
                    if (headerViewModel != null) {
                        rightBattery = headerViewModel.getRightBattery();
                    } else {
                        rightBattery = null;
                    }
                    bool15 = bool14;
                    updateRegistration(20, rightBattery);
                    if (rightBattery != null) {
                        str14 = rightBattery.get();
                    }
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool15 = bool14;
                }
                str14 = null;
                if ((j2 & 203423744) != 0) {
                    if (headerViewModel != null) {
                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                    } else {
                        leftBatteryVisible = null;
                    }
                    str15 = str14;
                    updateRegistration(21, leftBatteryVisible);
                    if (leftBatteryVisible != null) {
                        bool16 = leftBatteryVisible.get();
                    }
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str15 = str14;
                }
                bool16 = null;
                if ((j2 & 218103808) != 0) {
                    if (headerViewModel != null) {
                        summary = headerViewModel.getSummary();
                    } else {
                        summary = null;
                    }
                    bool17 = bool16;
                    updateRegistration(24, summary);
                    if (summary != null) {
                        str16 = summary.get();
                    }
                } else {
                    bool17 = bool16;
                }
                observableField3 = caseUri;
                bool = bool8;
                observableField4 = caseImage;
                observableField2 = rightImage;
                str2 = str16;
                bool5 = bool10;
                bool4 = bool11;
                z = zSafeUnbox2;
                i = i5;
                i3 = i6;
                str5 = str9;
                observableField = observableField5;
                str = str13;
                str6 = str15;
                bool6 = bool17;
                i2 = i4;
                z3 = zSafeUnbox3;
                bool7 = bool9;
                str4 = str7;
                z2 = zSafeUnbox;
                str3 = str11;
                bool3 = bool13;
                bool2 = bool15;
            } else {
                observableField5 = rightImageUri;
            }
            str10 = null;
            if ((j2 & 201392128) != 0) {
                if (headerViewModel != null) {
                    leftBattery = headerViewModel.getLeftBattery();
                } else {
                    leftBattery = null;
                }
                str11 = str10;
                updateRegistration(16, leftBattery);
                if (leftBattery != null) {
                    str12 = leftBattery.get();
                }
                if ((j2 & 201457664) != 0) {
                    if (headerViewModel != null) {
                        rightVisible = headerViewModel.getRightVisible();
                    } else {
                        rightVisible = null;
                    }
                    str13 = str12;
                    updateRegistration(17, rightVisible);
                    if (rightVisible != null) {
                        bool12 = rightVisible.get();
                    }
                    if ((j2 & j4) != 0) {
                        if (headerViewModel != null) {
                            caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                        } else {
                            caseBatteryVisible = null;
                        }
                        bool13 = bool12;
                        updateRegistration(19, caseBatteryVisible);
                        if (caseBatteryVisible != null) {
                            bool14 = caseBatteryVisible.get();
                        }
                        if ((j2 & j3) != 0) {
                            if (headerViewModel != null) {
                                rightBattery = headerViewModel.getRightBattery();
                            } else {
                                rightBattery = null;
                            }
                            bool15 = bool14;
                            updateRegistration(20, rightBattery);
                            if (rightBattery != null) {
                                str14 = rightBattery.get();
                            }
                            if ((j2 & 203423744) != 0) {
                                if (headerViewModel != null) {
                                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                                } else {
                                    leftBatteryVisible = null;
                                }
                                str15 = str14;
                                updateRegistration(21, leftBatteryVisible);
                                if (leftBatteryVisible != null) {
                                    bool16 = leftBatteryVisible.get();
                                }
                                if ((j2 & 218103808) != 0) {
                                    if (headerViewModel != null) {
                                        summary = headerViewModel.getSummary();
                                    } else {
                                        summary = null;
                                    }
                                    bool17 = bool16;
                                    updateRegistration(24, summary);
                                    if (summary != null) {
                                        str16 = summary.get();
                                    }
                                } else {
                                    bool17 = bool16;
                                }
                                observableField3 = caseUri;
                                bool = bool8;
                                observableField4 = caseImage;
                                observableField2 = rightImage;
                                str2 = str16;
                                bool5 = bool10;
                                bool4 = bool11;
                                z = zSafeUnbox2;
                                i = i5;
                                i3 = i6;
                                str5 = str9;
                                observableField = observableField5;
                                str = str13;
                                str6 = str15;
                                bool6 = bool17;
                                i2 = i4;
                                z3 = zSafeUnbox3;
                                bool7 = bool9;
                                str4 = str7;
                                z2 = zSafeUnbox;
                                str3 = str11;
                                bool3 = bool13;
                                bool2 = bool15;
                            } else {
                                str15 = str14;
                            }
                            bool16 = null;
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            bool15 = bool14;
                        }
                        str14 = null;
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool13 = bool12;
                    }
                    bool14 = null;
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str13 = str12;
                }
                bool12 = null;
                if ((j2 & j4) != 0) {
                    if (headerViewModel != null) {
                        caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                    } else {
                        caseBatteryVisible = null;
                    }
                    bool13 = bool12;
                    updateRegistration(19, caseBatteryVisible);
                    if (caseBatteryVisible != null) {
                        bool14 = caseBatteryVisible.get();
                    }
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool13 = bool12;
                }
                bool14 = null;
                if ((j2 & j3) != 0) {
                    if (headerViewModel != null) {
                        rightBattery = headerViewModel.getRightBattery();
                    } else {
                        rightBattery = null;
                    }
                    bool15 = bool14;
                    updateRegistration(20, rightBattery);
                    if (rightBattery != null) {
                        str14 = rightBattery.get();
                    }
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool15 = bool14;
                }
                str14 = null;
                if ((j2 & 203423744) != 0) {
                    if (headerViewModel != null) {
                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                    } else {
                        leftBatteryVisible = null;
                    }
                    str15 = str14;
                    updateRegistration(21, leftBatteryVisible);
                    if (leftBatteryVisible != null) {
                        bool16 = leftBatteryVisible.get();
                    }
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str15 = str14;
                }
                bool16 = null;
                if ((j2 & 218103808) != 0) {
                    if (headerViewModel != null) {
                        summary = headerViewModel.getSummary();
                    } else {
                        summary = null;
                    }
                    bool17 = bool16;
                    updateRegistration(24, summary);
                    if (summary != null) {
                        str16 = summary.get();
                    }
                } else {
                    bool17 = bool16;
                }
                observableField3 = caseUri;
                bool = bool8;
                observableField4 = caseImage;
                observableField2 = rightImage;
                str2 = str16;
                bool5 = bool10;
                bool4 = bool11;
                z = zSafeUnbox2;
                i = i5;
                i3 = i6;
                str5 = str9;
                observableField = observableField5;
                str = str13;
                str6 = str15;
                bool6 = bool17;
                i2 = i4;
                z3 = zSafeUnbox3;
                bool7 = bool9;
                str4 = str7;
                z2 = zSafeUnbox;
                str3 = str11;
                bool3 = bool13;
                bool2 = bool15;
            } else {
                str11 = str10;
            }
            str12 = null;
            if ((j2 & 201457664) != 0) {
                if (headerViewModel != null) {
                    rightVisible = headerViewModel.getRightVisible();
                } else {
                    rightVisible = null;
                }
                str13 = str12;
                updateRegistration(17, rightVisible);
                if (rightVisible != null) {
                    bool12 = rightVisible.get();
                }
                if ((j2 & j4) != 0) {
                    if (headerViewModel != null) {
                        caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                    } else {
                        caseBatteryVisible = null;
                    }
                    bool13 = bool12;
                    updateRegistration(19, caseBatteryVisible);
                    if (caseBatteryVisible != null) {
                        bool14 = caseBatteryVisible.get();
                    }
                    if ((j2 & j3) != 0) {
                        if (headerViewModel != null) {
                            rightBattery = headerViewModel.getRightBattery();
                        } else {
                            rightBattery = null;
                        }
                        bool15 = bool14;
                        updateRegistration(20, rightBattery);
                        if (rightBattery != null) {
                            str14 = rightBattery.get();
                        }
                        if ((j2 & 203423744) != 0) {
                            if (headerViewModel != null) {
                                leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                            } else {
                                leftBatteryVisible = null;
                            }
                            str15 = str14;
                            updateRegistration(21, leftBatteryVisible);
                            if (leftBatteryVisible != null) {
                                bool16 = leftBatteryVisible.get();
                            }
                            if ((j2 & 218103808) != 0) {
                                if (headerViewModel != null) {
                                    summary = headerViewModel.getSummary();
                                } else {
                                    summary = null;
                                }
                                bool17 = bool16;
                                updateRegistration(24, summary);
                                if (summary != null) {
                                    str16 = summary.get();
                                }
                            } else {
                                bool17 = bool16;
                            }
                            observableField3 = caseUri;
                            bool = bool8;
                            observableField4 = caseImage;
                            observableField2 = rightImage;
                            str2 = str16;
                            bool5 = bool10;
                            bool4 = bool11;
                            z = zSafeUnbox2;
                            i = i5;
                            i3 = i6;
                            str5 = str9;
                            observableField = observableField5;
                            str = str13;
                            str6 = str15;
                            bool6 = bool17;
                            i2 = i4;
                            z3 = zSafeUnbox3;
                            bool7 = bool9;
                            str4 = str7;
                            z2 = zSafeUnbox;
                            str3 = str11;
                            bool3 = bool13;
                            bool2 = bool15;
                        } else {
                            str15 = str14;
                        }
                        bool16 = null;
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        bool15 = bool14;
                    }
                    str14 = null;
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool13 = bool12;
                }
                bool14 = null;
                if ((j2 & j3) != 0) {
                    if (headerViewModel != null) {
                        rightBattery = headerViewModel.getRightBattery();
                    } else {
                        rightBattery = null;
                    }
                    bool15 = bool14;
                    updateRegistration(20, rightBattery);
                    if (rightBattery != null) {
                        str14 = rightBattery.get();
                    }
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool15 = bool14;
                }
                str14 = null;
                if ((j2 & 203423744) != 0) {
                    if (headerViewModel != null) {
                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                    } else {
                        leftBatteryVisible = null;
                    }
                    str15 = str14;
                    updateRegistration(21, leftBatteryVisible);
                    if (leftBatteryVisible != null) {
                        bool16 = leftBatteryVisible.get();
                    }
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str15 = str14;
                }
                bool16 = null;
                if ((j2 & 218103808) != 0) {
                    if (headerViewModel != null) {
                        summary = headerViewModel.getSummary();
                    } else {
                        summary = null;
                    }
                    bool17 = bool16;
                    updateRegistration(24, summary);
                    if (summary != null) {
                        str16 = summary.get();
                    }
                } else {
                    bool17 = bool16;
                }
                observableField3 = caseUri;
                bool = bool8;
                observableField4 = caseImage;
                observableField2 = rightImage;
                str2 = str16;
                bool5 = bool10;
                bool4 = bool11;
                z = zSafeUnbox2;
                i = i5;
                i3 = i6;
                str5 = str9;
                observableField = observableField5;
                str = str13;
                str6 = str15;
                bool6 = bool17;
                i2 = i4;
                z3 = zSafeUnbox3;
                bool7 = bool9;
                str4 = str7;
                z2 = zSafeUnbox;
                str3 = str11;
                bool3 = bool13;
                bool2 = bool15;
            } else {
                str13 = str12;
            }
            bool12 = null;
            if ((j2 & j4) != 0) {
                if (headerViewModel != null) {
                    caseBatteryVisible = headerViewModel.getCaseBatteryVisible();
                } else {
                    caseBatteryVisible = null;
                }
                bool13 = bool12;
                updateRegistration(19, caseBatteryVisible);
                if (caseBatteryVisible != null) {
                    bool14 = caseBatteryVisible.get();
                }
                if ((j2 & j3) != 0) {
                    if (headerViewModel != null) {
                        rightBattery = headerViewModel.getRightBattery();
                    } else {
                        rightBattery = null;
                    }
                    bool15 = bool14;
                    updateRegistration(20, rightBattery);
                    if (rightBattery != null) {
                        str14 = rightBattery.get();
                    }
                    if ((j2 & 203423744) != 0) {
                        if (headerViewModel != null) {
                            leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                        } else {
                            leftBatteryVisible = null;
                        }
                        str15 = str14;
                        updateRegistration(21, leftBatteryVisible);
                        if (leftBatteryVisible != null) {
                            bool16 = leftBatteryVisible.get();
                        }
                        if ((j2 & 218103808) != 0) {
                            if (headerViewModel != null) {
                                summary = headerViewModel.getSummary();
                            } else {
                                summary = null;
                            }
                            bool17 = bool16;
                            updateRegistration(24, summary);
                            if (summary != null) {
                                str16 = summary.get();
                            }
                        } else {
                            bool17 = bool16;
                        }
                        observableField3 = caseUri;
                        bool = bool8;
                        observableField4 = caseImage;
                        observableField2 = rightImage;
                        str2 = str16;
                        bool5 = bool10;
                        bool4 = bool11;
                        z = zSafeUnbox2;
                        i = i5;
                        i3 = i6;
                        str5 = str9;
                        observableField = observableField5;
                        str = str13;
                        str6 = str15;
                        bool6 = bool17;
                        i2 = i4;
                        z3 = zSafeUnbox3;
                        bool7 = bool9;
                        str4 = str7;
                        z2 = zSafeUnbox;
                        str3 = str11;
                        bool3 = bool13;
                        bool2 = bool15;
                    } else {
                        str15 = str14;
                    }
                    bool16 = null;
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    bool15 = bool14;
                }
                str14 = null;
                if ((j2 & 203423744) != 0) {
                    if (headerViewModel != null) {
                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                    } else {
                        leftBatteryVisible = null;
                    }
                    str15 = str14;
                    updateRegistration(21, leftBatteryVisible);
                    if (leftBatteryVisible != null) {
                        bool16 = leftBatteryVisible.get();
                    }
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str15 = str14;
                }
                bool16 = null;
                if ((j2 & 218103808) != 0) {
                    if (headerViewModel != null) {
                        summary = headerViewModel.getSummary();
                    } else {
                        summary = null;
                    }
                    bool17 = bool16;
                    updateRegistration(24, summary);
                    if (summary != null) {
                        str16 = summary.get();
                    }
                } else {
                    bool17 = bool16;
                }
                observableField3 = caseUri;
                bool = bool8;
                observableField4 = caseImage;
                observableField2 = rightImage;
                str2 = str16;
                bool5 = bool10;
                bool4 = bool11;
                z = zSafeUnbox2;
                i = i5;
                i3 = i6;
                str5 = str9;
                observableField = observableField5;
                str = str13;
                str6 = str15;
                bool6 = bool17;
                i2 = i4;
                z3 = zSafeUnbox3;
                bool7 = bool9;
                str4 = str7;
                z2 = zSafeUnbox;
                str3 = str11;
                bool3 = bool13;
                bool2 = bool15;
            } else {
                bool13 = bool12;
            }
            bool14 = null;
            if ((j2 & j3) != 0) {
                if (headerViewModel != null) {
                    rightBattery = headerViewModel.getRightBattery();
                } else {
                    rightBattery = null;
                }
                bool15 = bool14;
                updateRegistration(20, rightBattery);
                if (rightBattery != null) {
                    str14 = rightBattery.get();
                }
                if ((j2 & 203423744) != 0) {
                    if (headerViewModel != null) {
                        leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                    } else {
                        leftBatteryVisible = null;
                    }
                    str15 = str14;
                    updateRegistration(21, leftBatteryVisible);
                    if (leftBatteryVisible != null) {
                        bool16 = leftBatteryVisible.get();
                    }
                    if ((j2 & 218103808) != 0) {
                        if (headerViewModel != null) {
                            summary = headerViewModel.getSummary();
                        } else {
                            summary = null;
                        }
                        bool17 = bool16;
                        updateRegistration(24, summary);
                        if (summary != null) {
                            str16 = summary.get();
                        }
                    } else {
                        bool17 = bool16;
                    }
                    observableField3 = caseUri;
                    bool = bool8;
                    observableField4 = caseImage;
                    observableField2 = rightImage;
                    str2 = str16;
                    bool5 = bool10;
                    bool4 = bool11;
                    z = zSafeUnbox2;
                    i = i5;
                    i3 = i6;
                    str5 = str9;
                    observableField = observableField5;
                    str = str13;
                    str6 = str15;
                    bool6 = bool17;
                    i2 = i4;
                    z3 = zSafeUnbox3;
                    bool7 = bool9;
                    str4 = str7;
                    z2 = zSafeUnbox;
                    str3 = str11;
                    bool3 = bool13;
                    bool2 = bool15;
                } else {
                    str15 = str14;
                }
                bool16 = null;
                if ((j2 & 218103808) != 0) {
                    if (headerViewModel != null) {
                        summary = headerViewModel.getSummary();
                    } else {
                        summary = null;
                    }
                    bool17 = bool16;
                    updateRegistration(24, summary);
                    if (summary != null) {
                        str16 = summary.get();
                    }
                } else {
                    bool17 = bool16;
                }
                observableField3 = caseUri;
                bool = bool8;
                observableField4 = caseImage;
                observableField2 = rightImage;
                str2 = str16;
                bool5 = bool10;
                bool4 = bool11;
                z = zSafeUnbox2;
                i = i5;
                i3 = i6;
                str5 = str9;
                observableField = observableField5;
                str = str13;
                str6 = str15;
                bool6 = bool17;
                i2 = i4;
                z3 = zSafeUnbox3;
                bool7 = bool9;
                str4 = str7;
                z2 = zSafeUnbox;
                str3 = str11;
                bool3 = bool13;
                bool2 = bool15;
            } else {
                bool15 = bool14;
            }
            str14 = null;
            if ((j2 & 203423744) != 0) {
                if (headerViewModel != null) {
                    leftBatteryVisible = headerViewModel.getLeftBatteryVisible();
                } else {
                    leftBatteryVisible = null;
                }
                str15 = str14;
                updateRegistration(21, leftBatteryVisible);
                if (leftBatteryVisible != null) {
                    bool16 = leftBatteryVisible.get();
                }
                if ((j2 & 218103808) != 0) {
                    if (headerViewModel != null) {
                        summary = headerViewModel.getSummary();
                    } else {
                        summary = null;
                    }
                    bool17 = bool16;
                    updateRegistration(24, summary);
                    if (summary != null) {
                        str16 = summary.get();
                    }
                } else {
                    bool17 = bool16;
                }
                observableField3 = caseUri;
                bool = bool8;
                observableField4 = caseImage;
                observableField2 = rightImage;
                str2 = str16;
                bool5 = bool10;
                bool4 = bool11;
                z = zSafeUnbox2;
                i = i5;
                i3 = i6;
                str5 = str9;
                observableField = observableField5;
                str = str13;
                str6 = str15;
                bool6 = bool17;
                i2 = i4;
                z3 = zSafeUnbox3;
                bool7 = bool9;
                str4 = str7;
                z2 = zSafeUnbox;
                str3 = str11;
                bool3 = bool13;
                bool2 = bool15;
            } else {
                str15 = str14;
            }
            bool16 = null;
            if ((j2 & 218103808) != 0) {
                if (headerViewModel != null) {
                    summary = headerViewModel.getSummary();
                } else {
                    summary = null;
                }
                bool17 = bool16;
                updateRegistration(24, summary);
                if (summary != null) {
                    str16 = summary.get();
                }
            } else {
                bool17 = bool16;
            }
            observableField3 = caseUri;
            bool = bool8;
            observableField4 = caseImage;
            observableField2 = rightImage;
            str2 = str16;
            bool5 = bool10;
            bool4 = bool11;
            z = zSafeUnbox2;
            i = i5;
            i3 = i6;
            str5 = str9;
            observableField = observableField5;
            str = str13;
            str6 = str15;
            bool6 = bool17;
            i2 = i4;
            z3 = zSafeUnbox3;
            bool7 = bool9;
            str4 = str7;
            z2 = zSafeUnbox;
            str3 = str11;
            bool3 = bool13;
            bool2 = bool15;
        } else {
            j2 = j;
            j3 = 202375168;
            j4 = 201850880;
            j5 = 201361408;
            j6 = 201327616;
            bool = null;
            bool2 = null;
            str = null;
            str2 = null;
            str3 = null;
            leftImageUri = null;
            leftImage = null;
            bool3 = null;
            str4 = null;
            bool4 = null;
            str5 = null;
            observableField = null;
            observableField2 = null;
            bool5 = null;
            str6 = null;
            bool6 = null;
            observableField3 = null;
            observableField4 = null;
            z = false;
            i = 0;
            z2 = false;
            i2 = 0;
            i3 = 0;
            z3 = false;
            bool7 = null;
        }
        if ((j2 & 201343232) != 0) {
            HeaderViewModel.showBattery(this.btBatteryIcon, i, 10, z);
        }
        if ((j2 & 201392128) != 0) {
            TextViewBindingAdapter.setText(this.btBatterySummary, str);
        }
        if ((j2 & 218103808) != 0) {
            TextViewBindingAdapter.setText(this.entityHeaderSummary, str2);
        }
        if ((j2 & 201330688) != 0) {
            TextViewBindingAdapter.setText(this.entityHeaderTitle, str3);
        }
        if ((j2 & 209715208) != 0) {
            BindingAdapter.glideResOrUri(this.headerIcon, leftImageUri, leftImage);
        }
        if ((j2 & 201326720) != 0) {
            BindingAdapter.goneUnlessAnimation(this.layoutLeft, bool4);
        }
        if ((j2 & 201326624) != 0) {
            BindingAdapter.goneUnlessAnimation(this.layoutMiddle, bool7);
        }
        if ((j2 & 201457664) != 0) {
            BindingAdapter.goneUnlessAnimation(this.layoutRight, bool3);
        }
        if (j7 != 0) {
            this.mboundView0.setEventHandler(bluetoothDetailsFragment);
        }
        if ((j2 & 201326592) != 0) {
            this.mboundView0.setViewModel(headerViewModel);
        }
        if ((j2 & 201326596) != 0) {
            TextViewBindingAdapter.setText(this.mboundView10, str4);
        }
        if ((j2 & 201326593) != 0) {
            BindingAdapter.goneUnless(this.mboundView10, bool);
        }
        if ((j2 & j4) != 0) {
            BindingAdapter.goneUnless(this.mboundView11, bool2);
        }
        if ((j2 & 205521408) != 0) {
            HeaderViewModel.showBattery(this.mboundView12, i3, 10, z3);
        }
        if ((j2 & j6) != 0) {
            TextViewBindingAdapter.setText(this.mboundView13, str5);
        }
        if ((j2 & j5) != 0) {
            BindingAdapter.glideResOrUri(this.mboundView15, observableField, observableField2);
        }
        if ((j2 & 201326656) != 0) {
            BindingAdapter.goneUnless(this.mboundView16, bool5);
        }
        if ((j2 & 201588752) != 0) {
            HeaderViewModel.showBattery(this.mboundView17, i2, 10, z2);
        }
        if ((j2 & j3) != 0) {
            TextViewBindingAdapter.setText(this.mboundView18, str6);
        }
        if ((j2 & 203423744) != 0) {
            BindingAdapter.goneUnless(this.mboundView5, bool6);
        }
        if ((j2 & 201334786) != 0) {
            BindingAdapter.glideResOrUri(this.mboundView9, observableField3, observableField4);
        }
        executeBindingsOn(this.mboundView0);
    }
}
