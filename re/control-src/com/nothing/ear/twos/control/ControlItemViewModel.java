package com.nothing.ear.twos.control;

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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/ear/twos/control/ControlItemViewModel;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;)V", "onClickSelectedOperation", "", "itemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "convertOptions", "it", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlItemViewModel extends ControlGestureViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_OPERATIONS = {8, 9, 11};
    private static final int[] SUPPORT_OPERATIONS_NO_CLOSE = {10, 18, 19, 11};
    private static final int[] SUPPORT_OPERATIONS_MORE = {10, 18, 19, 11};

    /* JADX INFO: compiled from: ControlItemViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/nothing/ear/twos/control/ControlItemViewModel$Companion;", "", "<init>", "()V", "SUPPORT_OPERATIONS", "", "getSUPPORT_OPERATIONS", "()[I", "SUPPORT_OPERATIONS_NO_CLOSE", "getSUPPORT_OPERATIONS_NO_CLOSE", "SUPPORT_OPERATIONS_MORE", "getSUPPORT_OPERATIONS_MORE", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        Context context2;
        int i;
        int i2;
        int i3;
        Context context3 = context;
        ControlConfigurationEntity.Operation it2 = it;
        Intrinsics.checkNotNullParameter(it2, "it");
        Intrinsics.checkNotNullParameter(context3, "context");
        getOperationList().clear();
        Pair<String, Integer> gestureOperation = getGestureOperation(it2.getOperation(), context3);
        setOperationNameAppend(gestureOperation.getFirst());
        int gesture = it2.getGesture();
        int i4 = 1;
        if (gesture == 1) {
            getOperationSubName().set("\n" + ((Object) getGestureOperation(3, context3).getFirst()));
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(true);
            getArrowVisible().set(8);
        } else if (gesture == 2) {
            int i5 = 4;
            getOperationSubName().set("\n" + ((Object) getGestureOperation(4, context3).getFirst()));
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(true);
            setDefaultOperation(9);
            int[] iArr = SUPPORT_OPERATIONS;
            int length = iArr.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                int i8 = i5;
                int i9 = iArr[i6];
                int i10 = i7 + 1;
                if (i7 == 0) {
                    i = 0;
                } else {
                    i = (i7 != SUPPORT_OPERATIONS.length - i4 || isSupportNews()) ? -1 : i4;
                }
                ControlGestureViewModel.addNewsControl$default(this, i9, it, context3, Integer.valueOf(i), null, 16, null);
                i6++;
                context3 = context;
                i5 = i8;
                i7 = i10;
                length = length;
                iArr = iArr;
                i4 = 1;
            }
            int i11 = i5;
            if (isSupportNews()) {
                context2 = context;
                ControlGestureViewModel.addNewsControl$default(this, 31, it, context2, 1, null, 16, null);
            } else {
                context2 = context;
            }
            ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(4, getGestureOperation(i11, context2), null, null, 12, null);
            controlOperationViewModel.getEnable().set(false);
            controlOperationViewModel.setDirection(ControlRadius.NONE);
            controlOperationViewModel.selectedOperation(false);
            getOperationList().add(controlOperationViewModel);
        } else if (gesture == 3) {
            setDefaultOperation(8);
            int[] iArr2 = SUPPORT_OPERATIONS;
            int length2 = iArr2.length;
            int i12 = 0;
            int i13 = 0;
            while (i12 < length2) {
                int i14 = length2;
                int i15 = iArr2[i12];
                int i16 = i13 + 1;
                if (i13 == 0) {
                    i2 = 0;
                } else {
                    i2 = (i13 != SUPPORT_OPERATIONS.length - 1 || isSupportNews()) ? -1 : 1;
                }
                ControlGestureViewModel.addNewsControl$default(this, i15, it, context, Integer.valueOf(i2), null, 16, null);
                i12++;
                i13 = i16;
                iArr2 = iArr2;
                length2 = i14;
            }
            if (isSupportNews()) {
                ControlGestureViewModel.addNewsControl$default(this, 31, it, context, 1, null, 16, null);
            }
        } else if (gesture == 7) {
            setDefaultOperation(22);
            int[] iArr3 = SUPPORT_OPERATIONS_NO_CLOSE;
            int length3 = iArr3.length;
            int i17 = 0;
            int i18 = 0;
            while (i17 < length3) {
                int i19 = length3;
                int i20 = iArr3[i17];
                int i21 = i18 + 1;
                if (i18 == 0) {
                    i3 = 0;
                } else {
                    i3 = (i18 != SUPPORT_OPERATIONS_NO_CLOSE.length - 1 || isSupportNews()) ? -1 : 1;
                }
                ControlGestureViewModel.addNewsControl$default(this, i20, it, context, Integer.valueOf(i3), null, 16, null);
                i17++;
                i18 = i21;
                iArr3 = iArr3;
                length3 = i19;
            }
            if (isSupportNews()) {
                ControlGestureViewModel.addNewsControl$default(this, 31, it, context, 1, null, 16, null);
            }
        } else if (gesture == 9) {
            setDefaultOperation(1);
            int[] iArr4 = SUPPORT_OPERATIONS_MORE;
            int i22 = 0;
            int i23 = 0;
            for (int length4 = iArr4.length; i22 < length4; length4 = length4) {
                int i24 = i22;
                int i25 = i23 + 1;
                ControlGestureViewModel.addNewsControl$default(this, iArr4[i24], it2, context3, Integer.valueOf(i23 == 0 ? 0 : -1), null, 16, null);
                i22 = i24 + 1;
                it2 = it;
                context3 = context;
                i23 = i25;
            }
            if (isSupportNews()) {
                ControlGestureViewModel.addNewsControl$default(this, 31, it, context, -1, null, 16, null);
            }
            ControlGestureViewModel.addNewsControl$default(this, 1, it, context, 1, null, 16, null);
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
