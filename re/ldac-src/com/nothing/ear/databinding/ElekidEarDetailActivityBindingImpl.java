package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.base.wiget.DeviceDetailItemView;
import com.nothing.base.wiget.RoundTextView;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.generated.callback.OnCheckedChangeListener;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.elekid.detail.EarDetailActivity;
import com.nothing.elekid.detail.EarDetailViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class ElekidEarDetailActivityBindingImpl extends ElekidEarDetailActivityBinding implements OnClickListener.Listener, OnCheckedChangeListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final CompoundButton.OnCheckedChangeListener mCallback254;
    private final CompoundButton.OnCheckedChangeListener mCallback255;
    private final View.OnClickListener mCallback256;
    private final View.OnClickListener mCallback257;
    private final View.OnClickListener mCallback258;
    private final View.OnClickListener mCallback259;
    private final View.OnClickListener mCallback260;
    private final View.OnClickListener mCallback261;
    private final View.OnClickListener mCallback262;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;
    private final DeviceDetailItemView mboundView1;
    private final DeviceDetailItemView mboundView10;
    private final DeviceDetailItemView mboundView11;
    private final RoundTextView mboundView14;
    private final RoundTextView mboundView15;
    private final DeviceDetailItemView mboundView2;
    private final DeviceDetailItemView mboundView3;
    private final DeviceDetailItemView mboundView4;
    private final DeviceDetailItemView mboundView5;
    private final DeviceDetailItemView mboundView6;
    private final DeviceDetailItemView mboundView7;
    private final DeviceDetailItemView mboundView8;
    private final DeviceDetailItemView mboundView9;

    public ElekidEarDetailActivityBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private ElekidEarDetailActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 12, (LinearLayout) bindings[13], (DeviceDetailItemView) bindings[12]);
        this.mDirtyFlags = -1L;
        this.bottomView.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        DeviceDetailItemView deviceDetailItemView = (DeviceDetailItemView) bindings[1];
        this.mboundView1 = deviceDetailItemView;
        deviceDetailItemView.setTag(null);
        DeviceDetailItemView deviceDetailItemView2 = (DeviceDetailItemView) bindings[10];
        this.mboundView10 = deviceDetailItemView2;
        deviceDetailItemView2.setTag(null);
        DeviceDetailItemView deviceDetailItemView3 = (DeviceDetailItemView) bindings[11];
        this.mboundView11 = deviceDetailItemView3;
        deviceDetailItemView3.setTag(null);
        RoundTextView roundTextView = (RoundTextView) bindings[14];
        this.mboundView14 = roundTextView;
        roundTextView.setTag(null);
        RoundTextView roundTextView2 = (RoundTextView) bindings[15];
        this.mboundView15 = roundTextView2;
        roundTextView2.setTag(null);
        DeviceDetailItemView deviceDetailItemView4 = (DeviceDetailItemView) bindings[2];
        this.mboundView2 = deviceDetailItemView4;
        deviceDetailItemView4.setTag(null);
        DeviceDetailItemView deviceDetailItemView5 = (DeviceDetailItemView) bindings[3];
        this.mboundView3 = deviceDetailItemView5;
        deviceDetailItemView5.setTag(null);
        DeviceDetailItemView deviceDetailItemView6 = (DeviceDetailItemView) bindings[4];
        this.mboundView4 = deviceDetailItemView6;
        deviceDetailItemView6.setTag(null);
        DeviceDetailItemView deviceDetailItemView7 = (DeviceDetailItemView) bindings[5];
        this.mboundView5 = deviceDetailItemView7;
        deviceDetailItemView7.setTag(null);
        DeviceDetailItemView deviceDetailItemView8 = (DeviceDetailItemView) bindings[6];
        this.mboundView6 = deviceDetailItemView8;
        deviceDetailItemView8.setTag(null);
        DeviceDetailItemView deviceDetailItemView9 = (DeviceDetailItemView) bindings[7];
        this.mboundView7 = deviceDetailItemView9;
        deviceDetailItemView9.setTag(null);
        DeviceDetailItemView deviceDetailItemView10 = (DeviceDetailItemView) bindings[8];
        this.mboundView8 = deviceDetailItemView10;
        deviceDetailItemView10.setTag(null);
        DeviceDetailItemView deviceDetailItemView11 = (DeviceDetailItemView) bindings[9];
        this.mboundView9 = deviceDetailItemView11;
        deviceDetailItemView11.setTag(null);
        this.tipsCl.setTag(null);
        setRootTag(root);
        this.mCallback259 = new OnClickListener(this, 6);
        this.mCallback257 = new OnClickListener(this, 4);
        this.mCallback255 = new OnCheckedChangeListener(this, 2);
        this.mCallback261 = new OnClickListener(this, 8);
        this.mCallback258 = new OnClickListener(this, 5);
        this.mCallback256 = new OnClickListener(this, 3);
        this.mCallback254 = new OnCheckedChangeListener(this, 1);
        this.mCallback262 = new OnClickListener(this, 9);
        this.mCallback260 = new OnClickListener(this, 7);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16384L;
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
            setEventHandler((EarDetailActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((EarDetailViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.ElekidEarDetailActivityBinding
    public void setEventHandler(EarDetailActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.ElekidEarDetailActivityBinding
    public void setViewModel(EarDetailViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelFirmwareVersionStr((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelHasSupport((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelInEarChecked((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelHasUpdate((ObservableField) object, fieldId);
            case 4:
                return onChangeEventHandlerConfigurationChanged((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelLowModelChecked((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelLdacModelChecked((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelDeviceName((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelDeviceSerial((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelDeviceMac((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelIsHasSerial((ObservableField) object, fieldId);
            case 11:
                return onChangeViewModelConnected((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelFirmwareVersionStr(ObservableField<String> ViewModelFirmwareVersionStr, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelHasSupport(ObservableField<Boolean> ViewModelHasSupport, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelInEarChecked(ObservableField<Boolean> ViewModelInEarChecked, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelHasUpdate(ObservableField<Boolean> ViewModelHasUpdate, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeEventHandlerConfigurationChanged(ObservableField<Boolean> EventHandlerConfigurationChanged, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelLowModelChecked(ObservableField<Boolean> ViewModelLowModelChecked, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelLdacModelChecked(ObservableField<Boolean> ViewModelLdacModelChecked, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelDeviceName(ObservableField<String> ViewModelDeviceName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelDeviceSerial(ObservableField<String> ViewModelDeviceSerial, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelDeviceMac(ObservableField<String> ViewModelDeviceMac, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelIsHasSerial(ObservableField<Boolean> ViewModelIsHasSerial, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelConnected(ObservableField<Boolean> ViewModelConnected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0155  */
    /* JADX WARN: Code duplicated, block: B:103:0x015c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x015e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0163  */
    /* JADX WARN: Code duplicated, block: B:108:0x016d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0174  */
    /* JADX WARN: Code duplicated, block: B:113:0x017d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x017f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0184  */
    /* JADX WARN: Code duplicated, block: B:118:0x018c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0198  */
    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x008c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0091  */
    /* JADX WARN: Code duplicated, block: B:43:0x0098  */
    /* JADX WARN: Code duplicated, block: B:44:0x009f  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00db  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:75:0x0102 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0104  */
    /* JADX WARN: Code duplicated, block: B:77:0x0109  */
    /* JADX WARN: Code duplicated, block: B:80:0x0110  */
    /* JADX WARN: Code duplicated, block: B:81:0x0117  */
    /* JADX WARN: Code duplicated, block: B:84:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0120  */
    /* JADX WARN: Code duplicated, block: B:86:0x0125  */
    /* JADX WARN: Code duplicated, block: B:89:0x012f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0136  */
    /* JADX WARN: Code duplicated, block: B:94:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0141  */
    /* JADX WARN: Code duplicated, block: B:96:0x0146  */
    /* JADX WARN: Code duplicated, block: B:99:0x014e  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Boolean bool;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        String str;
        String str2;
        Boolean bool5;
        ObservableField<Boolean> hasUpdate;
        Boolean bool6;
        Boolean bool7;
        String str3;
        String str4;
        Boolean bool8;
        ObservableField<Boolean> connected;
        ObservableField<Boolean> observableFieldIsHasSerial;
        ObservableField<String> deviceMac;
        ObservableField<String> deviceSerial;
        ObservableField<String> deviceName;
        ObservableField<Boolean> ldacModelChecked;
        ObservableField<Boolean> lowModelChecked;
        ObservableField<Boolean> inEarChecked;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        EarDetailActivity earDetailActivity = this.mEventHandler;
        EarDetailViewModel earDetailViewModel = this.mViewModel;
        long j6 = 20496 & j;
        if (j6 == 0) {
            bool = null;
        } else {
            ObservableField<Boolean> configurationChanged = earDetailActivity != null ? earDetailActivity.getConfigurationChanged() : null;
            updateRegistration(4, configurationChanged);
            if (configurationChanged != null) {
                bool = configurationChanged.get();
            } else {
                bool = null;
            }
        }
        if ((28655 & j) != 0) {
            if ((j & 24577) == 0) {
                str = null;
            } else {
                ObservableField<String> firmwareVersionStr = earDetailViewModel != null ? earDetailViewModel.getFirmwareVersionStr() : null;
                updateRegistration(0, firmwareVersionStr);
                if (firmwareVersionStr != null) {
                    str = firmwareVersionStr.get();
                } else {
                    str = null;
                }
            }
            if ((j & 24578) != 0) {
                ObservableField<Boolean> hasSupport = earDetailViewModel != null ? earDetailViewModel.getHasSupport() : null;
                z = false;
                updateRegistration(1, hasSupport);
                bool4 = hasSupport != null ? hasSupport.get() : null;
                if ((j & 24580) == 0) {
                    bool8 = null;
                } else {
                    if (earDetailViewModel != null) {
                        inEarChecked = earDetailViewModel.getInEarChecked();
                    } else {
                        inEarChecked = null;
                    }
                    updateRegistration(2, inEarChecked);
                    if (inEarChecked != null) {
                        bool8 = inEarChecked.get();
                    } else {
                        bool8 = null;
                    }
                }
                if ((j & 24584) != 0) {
                    if (earDetailViewModel != null) {
                        hasUpdate = earDetailViewModel.getHasUpdate();
                    } else {
                        hasUpdate = null;
                    }
                    j5 = 24704;
                    updateRegistration(3, hasUpdate);
                    if (hasUpdate != null) {
                        hasUpdate.get();
                    }
                } else {
                    j5 = 24704;
                    hasUpdate = null;
                }
                if ((j & 24608) == 0) {
                    bool6 = null;
                } else {
                    if (earDetailViewModel != null) {
                        lowModelChecked = earDetailViewModel.getLowModelChecked();
                    } else {
                        lowModelChecked = null;
                    }
                    updateRegistration(5, lowModelChecked);
                    if (lowModelChecked != null) {
                        bool6 = lowModelChecked.get();
                    } else {
                        bool6 = null;
                    }
                }
                if ((j & 24640) != 0) {
                    if (earDetailViewModel != null) {
                        ldacModelChecked = earDetailViewModel.getLdacModelChecked();
                    } else {
                        ldacModelChecked = null;
                    }
                    j3 = 24640;
                    updateRegistration(6, ldacModelChecked);
                    bool7 = ldacModelChecked != null ? ldacModelChecked.get() : null;
                    if ((j & j5) == 0) {
                        str3 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            deviceName = earDetailViewModel.getDeviceName();
                        } else {
                            deviceName = null;
                        }
                        updateRegistration(7, deviceName);
                        if (deviceName != null) {
                            str3 = deviceName.get();
                        } else {
                            str3 = null;
                        }
                    }
                    if ((j & 24832) != 0) {
                        if (earDetailViewModel != null) {
                            deviceSerial = earDetailViewModel.getDeviceSerial();
                        } else {
                            deviceSerial = null;
                        }
                        j4 = 24832;
                        updateRegistration(8, deviceSerial);
                        str4 = deviceSerial != null ? deviceSerial.get() : null;
                        if ((j & 25088) == 0) {
                            str2 = null;
                        } else {
                            if (earDetailViewModel != null) {
                                deviceMac = earDetailViewModel.getDeviceMac();
                            } else {
                                deviceMac = null;
                            }
                            updateRegistration(9, deviceMac);
                            if (deviceMac != null) {
                                str2 = deviceMac.get();
                            } else {
                                str2 = null;
                            }
                        }
                        if ((j & 25600) != 0) {
                            if (earDetailViewModel != null) {
                                observableFieldIsHasSerial = earDetailViewModel.isHasSerial();
                            } else {
                                observableFieldIsHasSerial = null;
                            }
                            j2 = j;
                            updateRegistration(10, observableFieldIsHasSerial);
                            bool2 = observableFieldIsHasSerial != null ? observableFieldIsHasSerial.get() : null;
                            if ((j2 & 26624) == 0) {
                                bool3 = bool8;
                                bool5 = null;
                            } else {
                                if (earDetailViewModel != null) {
                                    connected = earDetailViewModel.getConnected();
                                } else {
                                    connected = null;
                                }
                                updateRegistration(11, connected);
                                if (connected != null) {
                                    Boolean bool9 = bool8;
                                    bool5 = connected.get();
                                    bool3 = bool9;
                                } else {
                                    bool3 = bool8;
                                    bool5 = null;
                                }
                            }
                        } else {
                            j2 = j;
                        }
                        if ((j2 & 26624) == 0) {
                            bool3 = bool8;
                            bool5 = null;
                        } else {
                            if (earDetailViewModel != null) {
                                connected = earDetailViewModel.getConnected();
                            } else {
                                connected = null;
                            }
                            updateRegistration(11, connected);
                            if (connected != null) {
                                Boolean bool10 = bool8;
                                bool5 = connected.get();
                                bool3 = bool10;
                            } else {
                                bool3 = bool8;
                                bool5 = null;
                            }
                        }
                    } else {
                        j4 = 24832;
                    }
                    if ((j & 25088) == 0) {
                        str2 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            deviceMac = earDetailViewModel.getDeviceMac();
                        } else {
                            deviceMac = null;
                        }
                        updateRegistration(9, deviceMac);
                        if (deviceMac != null) {
                            str2 = deviceMac.get();
                        } else {
                            str2 = null;
                        }
                    }
                    if ((j & 25600) != 0) {
                        if (earDetailViewModel != null) {
                            observableFieldIsHasSerial = earDetailViewModel.isHasSerial();
                        } else {
                            observableFieldIsHasSerial = null;
                        }
                        j2 = j;
                        updateRegistration(10, observableFieldIsHasSerial);
                        if (observableFieldIsHasSerial != null) {
                        }
                        if ((j2 & 26624) == 0) {
                            bool3 = bool8;
                            bool5 = null;
                        } else {
                            if (earDetailViewModel != null) {
                                connected = earDetailViewModel.getConnected();
                            } else {
                                connected = null;
                            }
                            updateRegistration(11, connected);
                            if (connected != null) {
                                Boolean bool11 = bool8;
                                bool5 = connected.get();
                                bool3 = bool11;
                            } else {
                                bool3 = bool8;
                                bool5 = null;
                            }
                        }
                    } else {
                        j2 = j;
                    }
                    if ((j2 & 26624) == 0) {
                        bool3 = bool8;
                        bool5 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            connected = earDetailViewModel.getConnected();
                        } else {
                            connected = null;
                        }
                        updateRegistration(11, connected);
                        if (connected != null) {
                            Boolean bool12 = bool8;
                            bool5 = connected.get();
                            bool3 = bool12;
                        } else {
                            bool3 = bool8;
                            bool5 = null;
                        }
                    }
                } else {
                    j3 = 24640;
                }
                if ((j & j5) == 0) {
                    str3 = null;
                } else {
                    if (earDetailViewModel != null) {
                        deviceName = earDetailViewModel.getDeviceName();
                    } else {
                        deviceName = null;
                    }
                    updateRegistration(7, deviceName);
                    if (deviceName != null) {
                        str3 = deviceName.get();
                    } else {
                        str3 = null;
                    }
                }
                if ((j & 24832) != 0) {
                    if (earDetailViewModel != null) {
                        deviceSerial = earDetailViewModel.getDeviceSerial();
                    } else {
                        deviceSerial = null;
                    }
                    j4 = 24832;
                    updateRegistration(8, deviceSerial);
                    if (deviceSerial != null) {
                    }
                    if ((j & 25088) == 0) {
                        str2 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            deviceMac = earDetailViewModel.getDeviceMac();
                        } else {
                            deviceMac = null;
                        }
                        updateRegistration(9, deviceMac);
                        if (deviceMac != null) {
                            str2 = deviceMac.get();
                        } else {
                            str2 = null;
                        }
                    }
                    if ((j & 25600) != 0) {
                        if (earDetailViewModel != null) {
                            observableFieldIsHasSerial = earDetailViewModel.isHasSerial();
                        } else {
                            observableFieldIsHasSerial = null;
                        }
                        j2 = j;
                        updateRegistration(10, observableFieldIsHasSerial);
                        if (observableFieldIsHasSerial != null) {
                        }
                        if ((j2 & 26624) == 0) {
                            bool3 = bool8;
                            bool5 = null;
                        } else {
                            if (earDetailViewModel != null) {
                                connected = earDetailViewModel.getConnected();
                            } else {
                                connected = null;
                            }
                            updateRegistration(11, connected);
                            if (connected != null) {
                                Boolean bool13 = bool8;
                                bool5 = connected.get();
                                bool3 = bool13;
                            } else {
                                bool3 = bool8;
                                bool5 = null;
                            }
                        }
                    } else {
                        j2 = j;
                    }
                    if ((j2 & 26624) == 0) {
                        bool3 = bool8;
                        bool5 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            connected = earDetailViewModel.getConnected();
                        } else {
                            connected = null;
                        }
                        updateRegistration(11, connected);
                        if (connected != null) {
                            Boolean bool14 = bool8;
                            bool5 = connected.get();
                            bool3 = bool14;
                        } else {
                            bool3 = bool8;
                            bool5 = null;
                        }
                    }
                } else {
                    j4 = 24832;
                }
                if ((j & 25088) == 0) {
                    str2 = null;
                } else {
                    if (earDetailViewModel != null) {
                        deviceMac = earDetailViewModel.getDeviceMac();
                    } else {
                        deviceMac = null;
                    }
                    updateRegistration(9, deviceMac);
                    if (deviceMac != null) {
                        str2 = deviceMac.get();
                    } else {
                        str2 = null;
                    }
                }
                if ((j & 25600) != 0) {
                    if (earDetailViewModel != null) {
                        observableFieldIsHasSerial = earDetailViewModel.isHasSerial();
                    } else {
                        observableFieldIsHasSerial = null;
                    }
                    j2 = j;
                    updateRegistration(10, observableFieldIsHasSerial);
                    if (observableFieldIsHasSerial != null) {
                    }
                    if ((j2 & 26624) == 0) {
                        bool3 = bool8;
                        bool5 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            connected = earDetailViewModel.getConnected();
                        } else {
                            connected = null;
                        }
                        updateRegistration(11, connected);
                        if (connected != null) {
                            Boolean bool15 = bool8;
                            bool5 = connected.get();
                            bool3 = bool15;
                        } else {
                            bool3 = bool8;
                            bool5 = null;
                        }
                    }
                } else {
                    j2 = j;
                }
                if ((j2 & 26624) == 0) {
                    bool3 = bool8;
                    bool5 = null;
                } else {
                    if (earDetailViewModel != null) {
                        connected = earDetailViewModel.getConnected();
                    } else {
                        connected = null;
                    }
                    updateRegistration(11, connected);
                    if (connected != null) {
                        Boolean bool16 = bool8;
                        bool5 = connected.get();
                        bool3 = bool16;
                    } else {
                        bool3 = bool8;
                        bool5 = null;
                    }
                }
            } else {
                z = false;
            }
            if ((j & 24580) == 0) {
                bool8 = null;
            } else {
                if (earDetailViewModel != null) {
                    inEarChecked = earDetailViewModel.getInEarChecked();
                } else {
                    inEarChecked = null;
                }
                updateRegistration(2, inEarChecked);
                if (inEarChecked != null) {
                    bool8 = inEarChecked.get();
                } else {
                    bool8 = null;
                }
            }
            if ((j & 24584) != 0) {
                if (earDetailViewModel != null) {
                    hasUpdate = earDetailViewModel.getHasUpdate();
                } else {
                    hasUpdate = null;
                }
                j5 = 24704;
                updateRegistration(3, hasUpdate);
                if (hasUpdate != null) {
                    hasUpdate.get();
                }
            } else {
                j5 = 24704;
                hasUpdate = null;
            }
            if ((j & 24608) == 0) {
                bool6 = null;
            } else {
                if (earDetailViewModel != null) {
                    lowModelChecked = earDetailViewModel.getLowModelChecked();
                } else {
                    lowModelChecked = null;
                }
                updateRegistration(5, lowModelChecked);
                if (lowModelChecked != null) {
                    bool6 = lowModelChecked.get();
                } else {
                    bool6 = null;
                }
            }
            if ((j & 24640) != 0) {
                if (earDetailViewModel != null) {
                    ldacModelChecked = earDetailViewModel.getLdacModelChecked();
                } else {
                    ldacModelChecked = null;
                }
                j3 = 24640;
                updateRegistration(6, ldacModelChecked);
                if (ldacModelChecked != null) {
                }
                if ((j & j5) == 0) {
                    str3 = null;
                } else {
                    if (earDetailViewModel != null) {
                        deviceName = earDetailViewModel.getDeviceName();
                    } else {
                        deviceName = null;
                    }
                    updateRegistration(7, deviceName);
                    if (deviceName != null) {
                        str3 = deviceName.get();
                    } else {
                        str3 = null;
                    }
                }
                if ((j & 24832) != 0) {
                    if (earDetailViewModel != null) {
                        deviceSerial = earDetailViewModel.getDeviceSerial();
                    } else {
                        deviceSerial = null;
                    }
                    j4 = 24832;
                    updateRegistration(8, deviceSerial);
                    if (deviceSerial != null) {
                    }
                    if ((j & 25088) == 0) {
                        str2 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            deviceMac = earDetailViewModel.getDeviceMac();
                        } else {
                            deviceMac = null;
                        }
                        updateRegistration(9, deviceMac);
                        if (deviceMac != null) {
                            str2 = deviceMac.get();
                        } else {
                            str2 = null;
                        }
                    }
                    if ((j & 25600) != 0) {
                        if (earDetailViewModel != null) {
                            observableFieldIsHasSerial = earDetailViewModel.isHasSerial();
                        } else {
                            observableFieldIsHasSerial = null;
                        }
                        j2 = j;
                        updateRegistration(10, observableFieldIsHasSerial);
                        if (observableFieldIsHasSerial != null) {
                        }
                        if ((j2 & 26624) == 0) {
                            bool3 = bool8;
                            bool5 = null;
                        } else {
                            if (earDetailViewModel != null) {
                                connected = earDetailViewModel.getConnected();
                            } else {
                                connected = null;
                            }
                            updateRegistration(11, connected);
                            if (connected != null) {
                                Boolean bool17 = bool8;
                                bool5 = connected.get();
                                bool3 = bool17;
                            } else {
                                bool3 = bool8;
                                bool5 = null;
                            }
                        }
                    } else {
                        j2 = j;
                    }
                    if ((j2 & 26624) == 0) {
                        bool3 = bool8;
                        bool5 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            connected = earDetailViewModel.getConnected();
                        } else {
                            connected = null;
                        }
                        updateRegistration(11, connected);
                        if (connected != null) {
                            Boolean bool18 = bool8;
                            bool5 = connected.get();
                            bool3 = bool18;
                        } else {
                            bool3 = bool8;
                            bool5 = null;
                        }
                    }
                } else {
                    j4 = 24832;
                }
                if ((j & 25088) == 0) {
                    str2 = null;
                } else {
                    if (earDetailViewModel != null) {
                        deviceMac = earDetailViewModel.getDeviceMac();
                    } else {
                        deviceMac = null;
                    }
                    updateRegistration(9, deviceMac);
                    if (deviceMac != null) {
                        str2 = deviceMac.get();
                    } else {
                        str2 = null;
                    }
                }
                if ((j & 25600) != 0) {
                    if (earDetailViewModel != null) {
                        observableFieldIsHasSerial = earDetailViewModel.isHasSerial();
                    } else {
                        observableFieldIsHasSerial = null;
                    }
                    j2 = j;
                    updateRegistration(10, observableFieldIsHasSerial);
                    if (observableFieldIsHasSerial != null) {
                    }
                    if ((j2 & 26624) == 0) {
                        bool3 = bool8;
                        bool5 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            connected = earDetailViewModel.getConnected();
                        } else {
                            connected = null;
                        }
                        updateRegistration(11, connected);
                        if (connected != null) {
                            Boolean bool19 = bool8;
                            bool5 = connected.get();
                            bool3 = bool19;
                        } else {
                            bool3 = bool8;
                            bool5 = null;
                        }
                    }
                } else {
                    j2 = j;
                }
                if ((j2 & 26624) == 0) {
                    bool3 = bool8;
                    bool5 = null;
                } else {
                    if (earDetailViewModel != null) {
                        connected = earDetailViewModel.getConnected();
                    } else {
                        connected = null;
                    }
                    updateRegistration(11, connected);
                    if (connected != null) {
                        Boolean bool110 = bool8;
                        bool5 = connected.get();
                        bool3 = bool110;
                    } else {
                        bool3 = bool8;
                        bool5 = null;
                    }
                }
            } else {
                j3 = 24640;
            }
            if ((j & j5) == 0) {
                str3 = null;
            } else {
                if (earDetailViewModel != null) {
                    deviceName = earDetailViewModel.getDeviceName();
                } else {
                    deviceName = null;
                }
                updateRegistration(7, deviceName);
                if (deviceName != null) {
                    str3 = deviceName.get();
                } else {
                    str3 = null;
                }
            }
            if ((j & 24832) != 0) {
                if (earDetailViewModel != null) {
                    deviceSerial = earDetailViewModel.getDeviceSerial();
                } else {
                    deviceSerial = null;
                }
                j4 = 24832;
                updateRegistration(8, deviceSerial);
                if (deviceSerial != null) {
                }
                if ((j & 25088) == 0) {
                    str2 = null;
                } else {
                    if (earDetailViewModel != null) {
                        deviceMac = earDetailViewModel.getDeviceMac();
                    } else {
                        deviceMac = null;
                    }
                    updateRegistration(9, deviceMac);
                    if (deviceMac != null) {
                        str2 = deviceMac.get();
                    } else {
                        str2 = null;
                    }
                }
                if ((j & 25600) != 0) {
                    if (earDetailViewModel != null) {
                        observableFieldIsHasSerial = earDetailViewModel.isHasSerial();
                    } else {
                        observableFieldIsHasSerial = null;
                    }
                    j2 = j;
                    updateRegistration(10, observableFieldIsHasSerial);
                    if (observableFieldIsHasSerial != null) {
                    }
                    if ((j2 & 26624) == 0) {
                        bool3 = bool8;
                        bool5 = null;
                    } else {
                        if (earDetailViewModel != null) {
                            connected = earDetailViewModel.getConnected();
                        } else {
                            connected = null;
                        }
                        updateRegistration(11, connected);
                        if (connected != null) {
                            Boolean bool111 = bool8;
                            bool5 = connected.get();
                            bool3 = bool111;
                        } else {
                            bool3 = bool8;
                            bool5 = null;
                        }
                    }
                } else {
                    j2 = j;
                }
                if ((j2 & 26624) == 0) {
                    bool3 = bool8;
                    bool5 = null;
                } else {
                    if (earDetailViewModel != null) {
                        connected = earDetailViewModel.getConnected();
                    } else {
                        connected = null;
                    }
                    updateRegistration(11, connected);
                    if (connected != null) {
                        Boolean bool112 = bool8;
                        bool5 = connected.get();
                        bool3 = bool112;
                    } else {
                        bool3 = bool8;
                        bool5 = null;
                    }
                }
            } else {
                j4 = 24832;
            }
            if ((j & 25088) == 0) {
                str2 = null;
            } else {
                if (earDetailViewModel != null) {
                    deviceMac = earDetailViewModel.getDeviceMac();
                } else {
                    deviceMac = null;
                }
                updateRegistration(9, deviceMac);
                if (deviceMac != null) {
                    str2 = deviceMac.get();
                } else {
                    str2 = null;
                }
            }
            if ((j & 25600) != 0) {
                if (earDetailViewModel != null) {
                    observableFieldIsHasSerial = earDetailViewModel.isHasSerial();
                } else {
                    observableFieldIsHasSerial = null;
                }
                j2 = j;
                updateRegistration(10, observableFieldIsHasSerial);
                if (observableFieldIsHasSerial != null) {
                }
                if ((j2 & 26624) == 0) {
                    bool3 = bool8;
                    bool5 = null;
                } else {
                    if (earDetailViewModel != null) {
                        connected = earDetailViewModel.getConnected();
                    } else {
                        connected = null;
                    }
                    updateRegistration(11, connected);
                    if (connected != null) {
                        Boolean bool113 = bool8;
                        bool5 = connected.get();
                        bool3 = bool113;
                    } else {
                        bool3 = bool8;
                        bool5 = null;
                    }
                }
            } else {
                j2 = j;
            }
            if ((j2 & 26624) == 0) {
                bool3 = bool8;
                bool5 = null;
            } else {
                if (earDetailViewModel != null) {
                    connected = earDetailViewModel.getConnected();
                } else {
                    connected = null;
                }
                updateRegistration(11, connected);
                if (connected != null) {
                    Boolean bool114 = bool8;
                    bool5 = connected.get();
                    bool3 = bool114;
                } else {
                    bool3 = bool8;
                    bool5 = null;
                }
            }
        } else {
            j2 = j;
            z = false;
            j3 = 24640;
            j4 = 24832;
            j5 = 24704;
            bool2 = null;
            bool3 = null;
            bool4 = null;
            str = null;
            str2 = null;
            bool5 = null;
            hasUpdate = null;
            bool6 = null;
            bool7 = null;
            str3 = null;
            str4 = null;
        }
        if (j6 != 0) {
            BindingAdapter.adjustNavigationBar(this.bottomView, Boolean.valueOf(z), bool);
        }
        if ((j2 & 16384) != 0) {
            if (getBuildSdkInt() >= 4) {
                DeviceDetailItemView deviceDetailItemView = this.mboundView1;
                deviceDetailItemView.setContentDescription(deviceDetailItemView.getResources().getString(R.string.title_desc, this.mboundView1.getResources().getString(R.string.advanced_features)));
                this.mboundView3.setContentDescription(this.mboundView3.getResources().getString(R.string.sound_low_latency_mode) + this.mboundView3.getResources().getString(R.string.sound_low_latency_mode_tips));
                DeviceDetailItemView deviceDetailItemView2 = this.mboundView7;
                deviceDetailItemView2.setContentDescription(deviceDetailItemView2.getResources().getString(R.string.title_desc, this.mboundView7.getResources().getString(R.string.device_detail)));
            }
            BindingAdapter.onClick(this.mboundView14, this.mCallback261);
            BindingAdapter.onClick(this.mboundView15, this.mCallback262);
            DeviceDetailItemView.setSwitchCheckChangeListener(this.mboundView2, this.mCallback254);
            DeviceDetailItemView.setSwitchCheckChangeListener(this.mboundView3, this.mCallback255);
            DeviceDetailItemView.setSwitchClickListener(this.mboundView4, this.mCallback256);
            BindingAdapter.onClick((ViewGroup) this.mboundView5, this.mCallback257);
            BindingAdapter.onClick((ViewGroup) this.mboundView6, this.mCallback258);
            BindingAdapter.onClick((ViewGroup) this.mboundView8, this.mCallback259);
            BindingAdapter.onClick((ViewGroup) this.tipsCl, this.mCallback260);
        } else {
            bool4 = bool4;
        }
        if ((j2 & 26624) != 0) {
            BindingAdapter.goneUnless(this.mboundView1, bool5);
            BindingAdapter.goneUnless(this.mboundView2, bool5);
            BindingAdapter.goneUnless(this.mboundView3, bool5);
            BindingAdapter.goneUnless(this.mboundView4, bool5);
            BindingAdapter.goneUnless(this.mboundView5, bool5);
            BindingAdapter.goneUnless(this.mboundView6, bool5);
            DeviceDetailItemView.setTitleLineGone(this.mboundView7, bool5);
            BindingAdapter.goneUnless(this.mboundView8, bool5);
        }
        if ((j2 & 25088) != 0) {
            DeviceDetailItemView.setArrowMsg(this.mboundView10, str2);
            BindingAdapter.copyText(this.mboundView10, str2);
        }
        if ((j2 & 25600) != 0) {
            BindingAdapter.goneUnless(this.mboundView11, bool2);
        }
        if ((j2 & j4) != 0) {
            DeviceDetailItemView.setArrowMsg(this.mboundView11, str4);
            BindingAdapter.copyText(this.mboundView11, str4);
        }
        if ((j2 & 24580) != 0) {
            DeviceDetailItemView.setSwitchCheck(this.mboundView2, bool3);
        }
        if ((j2 & 24608) != 0) {
            DeviceDetailItemView.setSwitchCheck(this.mboundView3, bool6);
        }
        if ((j2 & j3) != 0) {
            DeviceDetailItemView.setSwitchCheck(this.mboundView4, bool7);
        }
        if ((j2 & 24577) != 0) {
            DeviceDetailItemView.setArrowMsg(this.mboundView8, str);
            BindingAdapter.copyText(this.mboundView8, str);
        }
        if ((j2 & 24584) != 0) {
            DeviceDetailItemView.setFirmwareUpdate(this.mboundView8, hasUpdate);
        }
        if ((j2 & j5) != 0) {
            DeviceDetailItemView.setArrowMsg(this.mboundView9, str3);
            BindingAdapter.copyText(this.mboundView9, str3);
        }
        if ((j2 & 24578) != 0) {
            BindingAdapter.goneUnless(this.tipsCl, bool4);
        }
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 3:
                EarDetailActivity earDetailActivity = this.mEventHandler;
                EarDetailViewModel earDetailViewModel = this.mViewModel;
                if (earDetailActivity != null) {
                    earDetailActivity.onClickTestLDAC(earDetailViewModel);
                }
                break;
            case 4:
                EarDetailActivity earDetailActivity2 = this.mEventHandler;
                if (earDetailActivity2 != null) {
                    earDetailActivity2.onClickDualConnect();
                }
                break;
            case 5:
                EarDetailActivity earDetailActivity3 = this.mEventHandler;
                if (earDetailActivity3 != null) {
                    earDetailActivity3.onClickFindEar();
                }
                break;
            case 6:
                EarDetailActivity earDetailActivity4 = this.mEventHandler;
                if (earDetailActivity4 != null) {
                    earDetailActivity4.onClickFirmware();
                }
                break;
            case 7:
                EarDetailActivity earDetailActivity5 = this.mEventHandler;
                if (earDetailActivity5 != null) {
                    earDetailActivity5.onClickTipsSupport();
                }
                break;
            case 8:
                EarDetailActivity earDetailActivity6 = this.mEventHandler;
                if (earDetailActivity6 != null) {
                    earDetailActivity6.clickForgetDevice();
                }
                break;
            case 9:
                EarDetailActivity earDetailActivity7 = this.mEventHandler;
                if (earDetailActivity7 != null) {
                    earDetailActivity7.clickDisConnect();
                }
                break;
        }
    }

    @Override // com.nothing.ear.generated.callback.OnCheckedChangeListener.Listener
    public final void _internalCallbackOnCheckedChanged(int sourceId, CompoundButton callbackArg_0, boolean callbackArg_1) {
        if (sourceId == 1) {
            EarDetailActivity earDetailActivity = this.mEventHandler;
            EarDetailViewModel earDetailViewModel = this.mViewModel;
            if (earDetailActivity != null) {
                earDetailActivity.onClickInEarDetect(earDetailViewModel, callbackArg_1);
                return;
            }
            return;
        }
        if (sourceId != 2) {
            return;
        }
        EarDetailActivity earDetailActivity2 = this.mEventHandler;
        EarDetailViewModel earDetailViewModel2 = this.mViewModel;
        if (earDetailActivity2 != null) {
            earDetailActivity2.onClickLowChangeStatus(earDetailViewModel2, callbackArg_1);
        }
    }
}
