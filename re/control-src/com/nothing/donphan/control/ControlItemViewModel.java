package com.nothing.donphan.control;

import android.content.Context;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.control.entity.ControlRadius;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ControlItemViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J)\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/nothing/donphan/control/ControlItemViewModel;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;)V", "onClickSelectedOperation", "", "itemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "getNoExtraFunc", "Lkotlin/Pair;", "", "convertOptions", "it", "addSupportNewsKey", "isNoExtra", "", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/Boolean;)V", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlItemViewModel extends ControlGestureViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_OPERATIONS = {8, 9, 11};
    private static final int[] SUPPORT_OPERATIONS_NO_CLOSE = {10, 11};
    private static final int[] SUPPORT_OPERATIONS_LONG_PRESS = {18, 19, 11};
    private static final int[] SUPPORT_DOUBLE_OPERATIONS = {2, 8, 9, 11};

    /* JADX INFO: compiled from: ControlItemViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/donphan/control/ControlItemViewModel$Companion;", "", "<init>", "()V", "SUPPORT_OPERATIONS", "", "getSUPPORT_OPERATIONS", "()[I", "SUPPORT_OPERATIONS_NO_CLOSE", "getSUPPORT_OPERATIONS_NO_CLOSE", "SUPPORT_OPERATIONS_LONG_PRESS", "getSUPPORT_OPERATIONS_LONG_PRESS", "SUPPORT_DOUBLE_OPERATIONS", "getSUPPORT_DOUBLE_OPERATIONS", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final int[] getSUPPORT_OPERATIONS_LONG_PRESS() {
            return ControlItemViewModel.SUPPORT_OPERATIONS_LONG_PRESS;
        }

        public final int[] getSUPPORT_DOUBLE_OPERATIONS() {
            return ControlItemViewModel.SUPPORT_DOUBLE_OPERATIONS;
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

    private final Pair<String, Integer> getNoExtraFunc(int operation, Context context) {
        if (operation == 1) {
            String string = ContextExtKt.getLocalizedResources(context).getString(R.string.control_no_extra_action);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return TuplesKt.to(string, 0);
        }
        return getGestureOperation(operation, context);
    }

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public void convertOptions(ControlConfigurationEntity.Operation it, Context context) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(context, "context");
        getOperationList().clear();
        int gesture = it.getGesture();
        if (gesture == 2) {
            Pair<String, Integer> noExtraFunc = getNoExtraFunc(it.getOperation(), context);
            getOperationSubName().set("\n" + ((Object) getGestureOperation(3, context).getFirst()));
            setOperationNameAppend(noExtraFunc.getFirst());
            getSecondOperationVisible().set(true);
            setDefaultOperation(9);
            int[] iArr = SUPPORT_DOUBLE_OPERATIONS;
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = iArr[i];
                int i4 = i2 + 1;
                ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(i3, getNoExtraFunc(i3, context), null, null, 12, null);
                if (i2 == 0) {
                    controlOperationViewModel.setDirection(ControlRadius.HEAD);
                }
                controlOperationViewModel.selectedOperation(it.getOperation() == i3);
                getOperationList().add(controlOperationViewModel);
                i++;
                i2 = i4;
            }
            addSupportNewsKey$default(this, it, context, null, 4, null);
            ControlOperationViewModel controlOperationViewModel2 = new ControlOperationViewModel(3, getGestureOperation(3, context), null, null, 12, null);
            controlOperationViewModel2.setDirection(ControlRadius.NONE);
            controlOperationViewModel2.getEnable().set(false);
            controlOperationViewModel2.selectedOperation(false);
            getOperationList().add(controlOperationViewModel2);
        } else if (gesture == 3) {
            Pair<String, Integer> noExtraFunc2 = getNoExtraFunc(it.getOperation(), context);
            getOperationSubName().set("\n" + ((Object) getGestureOperation(4, context).getFirst()));
            setOperationNameAppend(noExtraFunc2.getFirst());
            getSecondOperationVisible().set(true);
            setDefaultOperation(8);
            int[] iArr2 = SUPPORT_OPERATIONS;
            int length2 = iArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length2) {
                int i7 = iArr2[i5];
                int i8 = i6 + 1;
                ControlOperationViewModel controlOperationViewModel3 = new ControlOperationViewModel(i7, getNoExtraFunc(i7, context), null, null, 12, null);
                if (i6 == 0) {
                    controlOperationViewModel3.setDirection(ControlRadius.HEAD);
                }
                controlOperationViewModel3.selectedOperation(it.getOperation() == i7);
                getOperationList().add(controlOperationViewModel3);
                i5++;
                i6 = i8;
            }
            addSupportNewsKey$default(this, it, context, null, 4, null);
            ControlOperationViewModel controlOperationViewModel4 = new ControlOperationViewModel(4, getGestureOperation(4, context), null, null, 12, null);
            controlOperationViewModel4.setDirection(ControlRadius.NONE);
            controlOperationViewModel4.getEnable().set(false);
            controlOperationViewModel4.selectedOperation(false);
            getOperationList().add(controlOperationViewModel4);
        } else if (gesture == 7) {
            setOperationNameAppend(getGestureOperation(it.getOperation(), context).getFirst());
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
            addSupportNewsKey(it, context, false);
        } else if (gesture == 8 || gesture == 9) {
            setOperationNameAppend(getGestureOperation(it.getOperation(), context).getFirst());
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
                }
                controlOperationViewModel6.selectedOperation(it.getOperation() == i15);
                getOperationList().add(controlOperationViewModel6);
                i13++;
                i14 = i16;
            }
            addSupportNewsKey(it, context, false);
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

    static /* synthetic */ void addSupportNewsKey$default(ControlItemViewModel controlItemViewModel, ControlConfigurationEntity.Operation operation, Context context, Boolean bool, int i, Object obj) {
        if ((i & 4) != 0) {
            bool = true;
        }
        controlItemViewModel.addSupportNewsKey(operation, context, bool);
    }

    private final void addSupportNewsKey(ControlConfigurationEntity.Operation it, Context context, Boolean isNoExtra) {
        ControlConfigurationEntity.Operation operation;
        Context context2;
        Pair<String, Integer> gestureOperation;
        if (isSupportNews()) {
            operation = it;
            ControlGestureViewModel.addNewsControl$default(this, 31, operation, context, -1, null, 16, null);
            context2 = context;
        } else {
            operation = it;
            context2 = context;
        }
        if (Intrinsics.areEqual((Object) isNoExtra, (Object) true)) {
            gestureOperation = getNoExtraFunc(1, context2);
        } else {
            gestureOperation = getGestureOperation(1, context2);
        }
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(1, gestureOperation, null, null, 12, null);
        controlOperationViewModel.setDirection(ControlRadius.END);
        controlOperationViewModel.selectedOperation(operation.getOperation() == 1);
        getOperationList().add(controlOperationViewModel);
    }
}
