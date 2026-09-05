package com.nothing.ear.one.control;

import android.content.Context;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.ear.R;
import com.nothing.ear.one.core.protocol.device.EarOneManager;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/nothing/ear/one/control/ControlItemViewModel;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;)V", "getGestureOperationExt", "Lkotlin/Pair;", "", "convertOptions", "", "it", "isHasAssistant", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ControlItemViewModel extends ControlGestureViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_TRIPLE_OPERATIONS = {8, 9, 1};
    private static final int[] SUPPORT_TAB_HOLD = {10, 1};

    /* JADX INFO: compiled from: ControlItemViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/nothing/ear/one/control/ControlItemViewModel$Companion;", "", "<init>", "()V", "SUPPORT_TRIPLE_OPERATIONS", "", "getSUPPORT_TRIPLE_OPERATIONS", "()[I", "SUPPORT_TAB_HOLD", "getSUPPORT_TAB_HOLD", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int[] getSUPPORT_TRIPLE_OPERATIONS() {
            return ControlItemViewModel.SUPPORT_TRIPLE_OPERATIONS;
        }

        public final int[] getSUPPORT_TAB_HOLD() {
            return ControlItemViewModel.SUPPORT_TAB_HOLD;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlItemViewModel(ControlConfigurationEntity.Operation operation, Context context, String address) {
        super(operation, context, address, null, false, 24, null);
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
    }

    public final Pair<String, Integer> getGestureOperationExt(int operation, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (operation == 1) {
            String string = ContextExtKt.getLocalizedResources(context).getString(R.string.control_no_extra_action);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return TuplesKt.to(string, 0);
        }
        return super.getGestureOperation(operation, context);
    }

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public void convertOptions(ControlConfigurationEntity.Operation it, Context context) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(context, "context");
        int gesture = it.getGesture();
        if (gesture == 0) {
            setOperationNameAppend(getGestureOperation(it.getOperation(), context).getFirst());
            getSecondOperationVisible().set(false);
            getArrowVisible().set(8);
            return;
        }
        if (gesture == 7) {
            getOperationSubName().set("\n" + ((Object) getGestureOperationExt(4, context).getFirst()));
            setOperationNameAppend(getGestureOperationExt(it.getOperation(), context).getFirst());
            setDefaultOperation(10);
            int[] iArr = SUPPORT_TAB_HOLD;
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = iArr[i];
                int i4 = i2 + 1;
                ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(i3, getGestureOperationExt(i3, context), null, null, 12, null);
                if (i2 == 0) {
                    controlOperationViewModel.setDirection(ControlRadius.HEAD);
                } else if (i2 == SUPPORT_TAB_HOLD.length - 1) {
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
            controlOperationViewModel2.selectedOperation(false);
            getOperationList().add(controlOperationViewModel2);
            return;
        }
        if (gesture == 2) {
            Pair<String, Integer> gestureOperation = getGestureOperation(3, context);
            Pair<String, Integer> gestureOperation2 = getGestureOperation(it.getOperation(), context);
            getOperationSubName().set("\n" + ((Object) gestureOperation.getFirst()));
            setOperationNameAppend(gestureOperation2.getFirst());
            getSecondOperationVisible().set(false);
            getArrowVisible().set(8);
            return;
        }
        if (gesture != 3) {
            return;
        }
        setOperationNameAppend(getGestureOperation(it.getOperation(), context).getFirst());
        setDefaultOperation(9);
        int[] iArr2 = SUPPORT_TRIPLE_OPERATIONS;
        int length2 = iArr2.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length2) {
            int i7 = iArr2[i5];
            int i8 = i6 + 1;
            ControlOperationViewModel controlOperationViewModel3 = new ControlOperationViewModel(i7, getGestureOperation(i7, context), null, null, 12, null);
            if (i6 == 0) {
                controlOperationViewModel3.setDirection(ControlRadius.HEAD);
            } else if (i6 == SUPPORT_TRIPLE_OPERATIONS.length - 1) {
                controlOperationViewModel3.setDirection(ControlRadius.END);
            }
            controlOperationViewModel3.selectedOperation(it.getOperation() == i7);
            getOperationList().add(controlOperationViewModel3);
            i5++;
            i6 = i8;
        }
        if (isHasAssistant()) {
            ControlOperationViewModel controlOperationViewModel4 = new ControlOperationViewModel(11, getGestureOperation(11, context), null, null, 12, null);
            controlOperationViewModel4.selectedOperation(it.getOperation() == 11);
            getOperationList().add(2, controlOperationViewModel4);
        }
    }

    public boolean isHasAssistant() {
        return EarOneManager.INSTANCE.isHasAssistant();
    }
}
