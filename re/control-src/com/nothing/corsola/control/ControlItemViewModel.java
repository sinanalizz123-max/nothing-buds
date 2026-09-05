package com.nothing.corsola.control;

import android.content.Context;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/corsola/control/ControlItemViewModel;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;)V", "onClickSelectedOperation", "", "itemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "convertOptions", "it", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlItemViewModel extends ControlGestureViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_DOUBLE_OPERATIONS = {2, 8, 9, 11};
    private static final int[] SUPPORT_OPERATIONS = {8, 9, 11};
    private static final int[] SUPPORT_OPERATIONS_NO_CLOSE = {10, 11};
    private static final int[] SUPPORT_OPERATIONS_LONG_PRESS = {18, 19, 11, 1};

    /* JADX INFO: compiled from: ControlItemViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/corsola/control/ControlItemViewModel$Companion;", "", "<init>", "()V", "SUPPORT_DOUBLE_OPERATIONS", "", "getSUPPORT_DOUBLE_OPERATIONS", "()[I", "SUPPORT_OPERATIONS", "getSUPPORT_OPERATIONS", "SUPPORT_OPERATIONS_NO_CLOSE", "getSUPPORT_OPERATIONS_NO_CLOSE", "SUPPORT_OPERATIONS_LONG_PRESS", "getSUPPORT_OPERATIONS_LONG_PRESS", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int[] getSUPPORT_DOUBLE_OPERATIONS() {
            return ControlItemViewModel.SUPPORT_DOUBLE_OPERATIONS;
        }

        public final int[] getSUPPORT_OPERATIONS() {
            return ControlItemViewModel.SUPPORT_OPERATIONS;
        }

        public final int[] getSUPPORT_OPERATIONS_NO_CLOSE() {
            return ControlItemViewModel.SUPPORT_OPERATIONS_NO_CLOSE;
        }

        public final int[] getSUPPORT_OPERATIONS_LONG_PRESS() {
            return ControlItemViewModel.SUPPORT_OPERATIONS_LONG_PRESS;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlItemViewModel(ControlConfigurationEntity.Operation operation, Context context, String address) {
        super(operation, context, address, null, false, 24, null);
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
    }

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public void onClickSelectedOperation(Context context, ControlOperationViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        for (ControlOperationViewModel controlOperationViewModel : getOperationList()) {
            controlOperationViewModel.selectedOperation(Intrinsics.areEqual(itemViewModel, controlOperationViewModel));
        }
        int operation = itemViewModel.getOperation();
        itemViewModel.convertAnc(operation, false);
        updateOperationText(operation, context);
    }

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public void convertOptions(ControlConfigurationEntity.Operation it, Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(context, "context");
        getOperationList().clear();
        Pair<String, Integer> gestureOperation = getGestureOperation(it.getOperation(), context);
        setOperationNameAppend(gestureOperation.getFirst());
        int gesture = it.getGesture();
        boolean z2 = true;
        if (gesture == 1) {
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(false);
            getArrowVisible().set(8);
            getAlphaItem().set(0.65f);
        } else if (gesture == 2) {
            getOperationSubName().set("\n" + ((Object) getGestureOperation(3, context).getFirst()));
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(true);
            setDefaultOperation(9);
            int[] iArr = SUPPORT_DOUBLE_OPERATIONS;
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = iArr[i];
                int i4 = i2 + 1;
                ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(i3, getGestureOperation(i3, context), null, null, 12, null);
                if (i2 == 0) {
                    controlOperationViewModel.setDirection(ControlRadius.HEAD);
                } else if (i2 == SUPPORT_DOUBLE_OPERATIONS.length - 1) {
                    controlOperationViewModel.setDirection(ControlRadius.END);
                }
                controlOperationViewModel.selectedOperation(it.getOperation() == i3);
                getOperationList().add(controlOperationViewModel);
                i++;
                i2 = i4;
            }
            ControlOperationViewModel controlOperationViewModel2 = new ControlOperationViewModel(3, getGestureOperation(3, context), null, null, 12, null);
            controlOperationViewModel2.getEnable().set(false);
            controlOperationViewModel2.selectedOperation(false);
            controlOperationViewModel2.setDirection(ControlRadius.NONE);
            getOperationList().add(controlOperationViewModel2);
        } else if (gesture == 3) {
            getOperationSubName().set("\n" + ((Object) getGestureOperation(4, context).getFirst()));
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(true);
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
                    z = z2;
                } else {
                    z = z2;
                    if (i6 == SUPPORT_OPERATIONS.length - 1) {
                        controlOperationViewModel3.setDirection(ControlRadius.END);
                    }
                }
                controlOperationViewModel3.selectedOperation(it.getOperation() == i7 ? z : false);
                getOperationList().add(controlOperationViewModel3);
                i5++;
                z2 = z;
                i6 = i8;
            }
            ControlOperationViewModel controlOperationViewModel4 = new ControlOperationViewModel(4, getGestureOperation(4, context), null, null, 12, null);
            controlOperationViewModel4.getEnable().set(false);
            controlOperationViewModel4.setDirection(ControlRadius.NONE);
            controlOperationViewModel4.selectedOperation(false);
            getOperationList().add(controlOperationViewModel4);
        } else if (gesture == 7) {
            setOperationNameAppend(gestureOperation.getFirst());
            setDefaultOperation(22);
            int[] iArr3 = SUPPORT_OPERATIONS_NO_CLOSE;
            int length3 = iArr3.length;
            int i9 = 0;
            int i10 = 0;
            while (i9 < length3) {
                int i11 = iArr3[i9];
                int i12 = i10 + 1;
                ControlOperationViewModel controlOperationViewModel5 = new ControlOperationViewModel(i11, getGestureOperation(i11, context), null, null, 12, null);
                if (i10 == 0) {
                    controlOperationViewModel5.setDirection(ControlRadius.HEAD);
                } else if (i10 == SUPPORT_OPERATIONS_NO_CLOSE.length - 1) {
                    controlOperationViewModel5.setDirection(ControlRadius.END);
                }
                if (i11 == 10) {
                    controlOperationViewModel5.selectedOperation(controlOperationViewModel5.convertAnc(it.getOperation(), true));
                    getOperationList().add(controlOperationViewModel5);
                } else {
                    controlOperationViewModel5.selectedOperation(it.getOperation() == i11);
                    getOperationList().add(controlOperationViewModel5);
                }
                i9++;
                i10 = i12;
            }
        } else if (gesture == 8 || gesture == 9) {
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(true);
            setDefaultOperation(1);
            int[] iArr4 = SUPPORT_OPERATIONS_LONG_PRESS;
            int length4 = iArr4.length;
            int i13 = 0;
            int i14 = 0;
            while (i13 < length4) {
                int i15 = iArr4[i13];
                int i16 = i14 + 1;
                ControlOperationViewModel controlOperationViewModel6 = new ControlOperationViewModel(i15, getGestureOperation(i15, context), null, null, 12, null);
                if (i14 == 0) {
                    controlOperationViewModel6.setDirection(ControlRadius.HEAD);
                } else if (i14 == SUPPORT_DOUBLE_OPERATIONS.length - 1) {
                    controlOperationViewModel6.setDirection(ControlRadius.END);
                }
                controlOperationViewModel6.selectedOperation(it.getOperation() == i15);
                getOperationList().add(controlOperationViewModel6);
                i13++;
                i14 = i16;
            }
        }
        int device = it.getDevice();
        if (device == 2) {
            isLeft().set(true);
        } else {
            if (device != 3) {
                return;
            }
            isLeft().set(false);
        }
    }
}
