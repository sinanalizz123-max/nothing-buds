package com.nothing.ear.stick.control;

import android.content.Context;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.control.entity.ControlRadius;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ControlItemViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/ear/stick/control/ControlItemViewModel;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;)V", "convertOptions", "", "it", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlItemViewModel extends ControlGestureViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_OPERATIONS = {8, 9, 11};
    private static final int[] SUPPORT_OPERATIONS_NO_CLOSE = {10, 18, 19, 11};
    private static final int[] SUPPORT_OPERATIONS_MORE = {10, 18, 19, 11, 1};
    private static final int[] SUPPORT_OPERATIONS_NO_ANC = {1, 18, 19, 11};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlItemViewModel(ControlConfigurationEntity.Operation operation, Context context, String address) {
        super(operation, context, address, null, false, 24, null);
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
    }

    /* JADX INFO: compiled from: ControlItemViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/ear/stick/control/ControlItemViewModel$Companion;", "", "<init>", "()V", "SUPPORT_OPERATIONS", "", "getSUPPORT_OPERATIONS", "()[I", "SUPPORT_OPERATIONS_NO_CLOSE", "getSUPPORT_OPERATIONS_NO_CLOSE", "SUPPORT_OPERATIONS_MORE", "getSUPPORT_OPERATIONS_MORE", "SUPPORT_OPERATIONS_NO_ANC", "getSUPPORT_OPERATIONS_NO_ANC", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int[] getSUPPORT_OPERATIONS() {
            return ControlItemViewModel.SUPPORT_OPERATIONS;
        }

        public final int[] getSUPPORT_OPERATIONS_NO_CLOSE() {
            return ControlItemViewModel.SUPPORT_OPERATIONS_NO_CLOSE;
        }

        public final int[] getSUPPORT_OPERATIONS_MORE() {
            return ControlItemViewModel.SUPPORT_OPERATIONS_MORE;
        }

        public final int[] getSUPPORT_OPERATIONS_NO_ANC() {
            return ControlItemViewModel.SUPPORT_OPERATIONS_NO_ANC;
        }
    }

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public void convertOptions(ControlConfigurationEntity.Operation it, Context context) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(context, "context");
        Pair<String, Integer> gestureOperation = getGestureOperation(it.getOperation(), context);
        setOperationNameAppend(gestureOperation.getFirst());
        int gesture = it.getGesture();
        if (gesture == 1) {
            getOperationSubName().set("\n" + ((Object) getGestureOperation(3, context).getFirst()));
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(true);
            getArrowVisible().set(8);
            return;
        }
        if (gesture == 2) {
            getOperationSubName().set("\n" + ((Object) getGestureOperation(4, context).getFirst()));
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(true);
            setDefaultOperation(9);
            int[] iArr = SUPPORT_OPERATIONS;
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = iArr[i];
                int i4 = i2 + 1;
                ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(i3, getGestureOperation(i3, context), null, null, 12, null);
                if (i2 == 0) {
                    controlOperationViewModel.setDirection(ControlRadius.HEAD);
                } else if (i2 == SUPPORT_OPERATIONS.length - 1) {
                    controlOperationViewModel.setDirection(ControlRadius.END);
                }
                controlOperationViewModel.selectedOperation(it.getOperation() == i3);
                getOperationList().add(controlOperationViewModel);
                i++;
                i2 = i4;
            }
            ControlOperationViewModel controlOperationViewModel2 = new ControlOperationViewModel(4, getGestureOperation(4, context), null, null, 12, null);
            controlOperationViewModel2.setDirection(ControlRadius.NONE);
            controlOperationViewModel2.getEnable().set(false);
            controlOperationViewModel2.selectedOperation(it.getOperation() == 4);
            getOperationList().add(controlOperationViewModel2);
            return;
        }
        if (gesture == 3) {
            setDefaultOperation(8);
            int[] iArr2 = SUPPORT_OPERATIONS;
            int length2 = iArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length2) {
                int i7 = iArr2[i5];
                int i8 = i6 + 1;
                ControlOperationViewModel controlOperationViewModel3 = new ControlOperationViewModel(i7, getGestureOperation(i7, context), null, null, 12, null);
                if (i6 == 0) {
                    controlOperationViewModel3.setDirection(ControlRadius.HEAD);
                } else if (i6 == SUPPORT_OPERATIONS.length - 1) {
                    controlOperationViewModel3.setDirection(ControlRadius.END);
                }
                controlOperationViewModel3.selectedOperation(it.getOperation() == i7);
                getOperationList().add(controlOperationViewModel3);
                i5++;
                i6 = i8;
            }
            return;
        }
        if (gesture != 7) {
            if (gesture != 9) {
                return;
            }
            setDefaultOperation(1);
            IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(getAddress());
            if (iOTDeviceByMacAddress != null && iOTDeviceByMacAddress.isSupportAnc(getAddress())) {
                int[] iArr3 = SUPPORT_OPERATIONS_MORE;
                int length3 = iArr3.length;
                int i9 = 0;
                int i10 = 0;
                while (i9 < length3) {
                    int i11 = iArr3[i9];
                    int i12 = i10 + 1;
                    ControlOperationViewModel controlOperationViewModel4 = new ControlOperationViewModel(i11, getGestureOperation(i11, context), null, null, 12, null);
                    if (i10 == 0) {
                        controlOperationViewModel4.setDirection(ControlRadius.HEAD);
                    } else if (i10 == SUPPORT_OPERATIONS_MORE.length - 1) {
                        controlOperationViewModel4.setDirection(ControlRadius.END);
                    }
                    controlOperationViewModel4.selectedOperation(it.getOperation() == i11);
                    getOperationList().add(controlOperationViewModel4);
                    i9++;
                    i10 = i12;
                }
                return;
            }
            int[] iArr4 = SUPPORT_OPERATIONS_NO_ANC;
            int length4 = iArr4.length;
            int i13 = 0;
            int i14 = 0;
            while (i13 < length4) {
                int i15 = iArr4[i13];
                int i16 = i14 + 1;
                ControlOperationViewModel controlOperationViewModel5 = new ControlOperationViewModel(i15, getGestureOperation(i15, context), null, null, 12, null);
                if (i14 == 0) {
                    controlOperationViewModel5.setDirection(ControlRadius.HEAD);
                } else if (i14 == SUPPORT_OPERATIONS_NO_ANC.length - 1) {
                    controlOperationViewModel5.setDirection(ControlRadius.END);
                }
                controlOperationViewModel5.selectedOperation(it.getOperation() == i15);
                getOperationList().add(controlOperationViewModel5);
                i13++;
                i14 = i16;
            }
            return;
        }
        int device = it.getDevice();
        if (device == 2) {
            setDefaultOperation(19);
        } else if (device == 3) {
            setDefaultOperation(18);
        }
        IOTDevice iOTDeviceByMacAddress2 = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(getAddress());
        if (iOTDeviceByMacAddress2 != null && iOTDeviceByMacAddress2.isSupportAnc(getAddress())) {
            setDefaultOperation(10);
            int[] iArr5 = SUPPORT_OPERATIONS_NO_CLOSE;
            int length5 = iArr5.length;
            int i17 = 0;
            int i18 = 0;
            while (i17 < length5) {
                int i19 = iArr5[i17];
                int i20 = i18 + 1;
                ControlOperationViewModel controlOperationViewModel6 = new ControlOperationViewModel(i19, getGestureOperation(i19, context), null, null, 12, null);
                if (i18 == 0) {
                    controlOperationViewModel6.setDirection(ControlRadius.HEAD);
                } else if (i18 == SUPPORT_OPERATIONS_NO_CLOSE.length - 1) {
                    controlOperationViewModel6.setDirection(ControlRadius.END);
                }
                controlOperationViewModel6.selectedOperation(it.getOperation() == i19);
                getOperationList().add(controlOperationViewModel6);
                i17++;
                i18 = i20;
            }
            return;
        }
        int[] iArr6 = SUPPORT_OPERATIONS_NO_ANC;
        int length6 = iArr6.length;
        int i21 = 0;
        int i22 = 0;
        while (i21 < length6) {
            int i23 = iArr6[i21];
            int i24 = i22 + 1;
            if (i23 != 1) {
                ControlOperationViewModel controlOperationViewModel7 = new ControlOperationViewModel(i23, getGestureOperation(i23, context), null, null, 12, null);
                if (i22 == 0) {
                    controlOperationViewModel7.setDirection(ControlRadius.HEAD);
                } else if (i22 == SUPPORT_OPERATIONS_NO_ANC.length - 1) {
                    controlOperationViewModel7.setDirection(ControlRadius.END);
                }
                controlOperationViewModel7.selectedOperation(it.getOperation() == i23);
                getOperationList().add(controlOperationViewModel7);
            }
            i21++;
            i22 = i24;
        }
    }
}
