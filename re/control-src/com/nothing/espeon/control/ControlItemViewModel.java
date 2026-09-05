package com.nothing.espeon.control;

import android.content.Context;
import android.util.Log;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.device.GesturesItem;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.VoiceAssistantUtil;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.control.entity.ControlRadius;
import com.nothing.espeon.core.device.IOTEarEspeonGestureAction;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlItemViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u0000 +2\u00020\u0001:\u0001+B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J>\u0010\u000f\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J,\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J,\u0010\u001a\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J,\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J;\u0010\u001e\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\u0015H\u0002\u00a2\u0006\u0002\u0010!J,\u0010\"\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J(\u0010#\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0012H\u0002J \u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J,\u0010'\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J,\u0010(\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J$\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J$\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006,"}, d2 = {"Lcom/nothing/espeon/control/ControlItemViewModel;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "callOperation", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;)V", "onClickSelectedOperation", "", "itemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "getGestureName", "Lkotlin/Triple;", "Lkotlin/Pair;", "", "gesture", "isLeft", "", "convertOptions", "it", "caseTriplePress", "gestureOperation", "earTapAndLongPressGesture", "caseDoublePressGesture", "caseSinglePressGesture", "casePressHoldGesture", "addCaseCallOperation", "isFirst", "isEnd", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;ILandroid/content/Context;Ljava/lang/Boolean;Z)V", "earLongTap", "caseOperationList", "isHead", "parseAncOperation", "element", "earTripleTap", "earDoubleTap", "getNoExtraFunc", "getGestureOperation", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlItemViewModel extends ControlGestureViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_OPERATIONS = {8, 9, 11};
    private static final int[] SUPPORT_OPERATIONS_NO_CLOSE = {22, 11};
    private static final int[] SUPPORT_OPERATIONS_LONG_PRESS = {18, 19, 11};
    private static final int[] SUPPORT_DOUBLE_OPERATIONS = {2, 8, 9, 11};
    private static final int[] CASE_SUPPORT_SINGLE_PRESS = {2, 9, 8, 11, 17};
    private static final int[] CASE_SUPPORT_PRESS_HOLD = {22, 11, 17};
    private static final int[] CASE_SUPPORT_DOUBLE_PRESS_CALL = {3, 25, 1};
    private static final int[] CASE_SUPPORT_TRIPLE_PRESS_CALL = {26, 1};
    private static final int[] CASE_SUPPORT_ROTATE = {23, 1};

    public /* synthetic */ ControlItemViewModel(ControlConfigurationEntity.Operation operation, Context context, String str, ControlConfigurationEntity.Operation operation2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(operation, context, str, (i & 8) != 0 ? null : operation2);
    }

    /* JADX INFO: compiled from: ControlItemViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/nothing/espeon/control/ControlItemViewModel$Companion;", "", "<init>", "()V", "SUPPORT_OPERATIONS", "", "getSUPPORT_OPERATIONS", "()[I", "SUPPORT_OPERATIONS_NO_CLOSE", "getSUPPORT_OPERATIONS_NO_CLOSE", "SUPPORT_OPERATIONS_LONG_PRESS", "getSUPPORT_OPERATIONS_LONG_PRESS", "SUPPORT_DOUBLE_OPERATIONS", "getSUPPORT_DOUBLE_OPERATIONS", "CASE_SUPPORT_SINGLE_PRESS", "getCASE_SUPPORT_SINGLE_PRESS", "CASE_SUPPORT_PRESS_HOLD", "getCASE_SUPPORT_PRESS_HOLD", "CASE_SUPPORT_DOUBLE_PRESS_CALL", "getCASE_SUPPORT_DOUBLE_PRESS_CALL", "CASE_SUPPORT_TRIPLE_PRESS_CALL", "getCASE_SUPPORT_TRIPLE_PRESS_CALL", "CASE_SUPPORT_ROTATE", "getCASE_SUPPORT_ROTATE", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final int[] getCASE_SUPPORT_SINGLE_PRESS() {
            return ControlItemViewModel.CASE_SUPPORT_SINGLE_PRESS;
        }

        public final int[] getCASE_SUPPORT_PRESS_HOLD() {
            return ControlItemViewModel.CASE_SUPPORT_PRESS_HOLD;
        }

        public final int[] getCASE_SUPPORT_DOUBLE_PRESS_CALL() {
            return ControlItemViewModel.CASE_SUPPORT_DOUBLE_PRESS_CALL;
        }

        public final int[] getCASE_SUPPORT_TRIPLE_PRESS_CALL() {
            return ControlItemViewModel.CASE_SUPPORT_TRIPLE_PRESS_CALL;
        }

        public final int[] getCASE_SUPPORT_ROTATE() {
            return ControlItemViewModel.CASE_SUPPORT_ROTATE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlItemViewModel(ControlConfigurationEntity.Operation operation, Context context, String address, ControlConfigurationEntity.Operation operation2) {
        super(operation, context, address, operation2, false, 16, null);
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
    }

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public void onClickSelectedOperation(Context context, ControlOperationViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        for (ControlOperationViewModel controlOperationViewModel : getOperationList()) {
            if (Intrinsics.areEqual(controlOperationViewModel.getButton(), itemViewModel.getButton())) {
                controlOperationViewModel.selectedOperation(Intrinsics.areEqual(itemViewModel, controlOperationViewModel));
            }
        }
        int operation = itemViewModel.getOperation();
        itemViewModel.convertAnc(operation, false);
        updateOperationText(operation, context);
    }

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public Triple<Pair<String, String>, Integer, Integer> getGestureName(int gesture, Context context, boolean isLeft) {
        Triple<Pair<String, String>, Integer, Integer> tripleControlViewData;
        Triple<Pair<String, String>, Integer, Integer> tripleControlViewData2;
        Intrinsics.checkNotNullParameter(context, "context");
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(getAddress());
        if (iOTDeviceByMacAddress == null) {
            return new Triple<>(new Pair("", ""), 0, 0);
        }
        Object obj = null;
        if (Intrinsics.areEqual((Object) isCase().get(), (Object) false)) {
            for (Object obj2 : iOTDeviceByMacAddress.getGestureList()) {
                if (((GesturesItem) obj2).getGestures() == gesture) {
                    obj = obj2;
                    break;
                }
            }
            GesturesItem gesturesItem = (GesturesItem) obj;
            return (gesturesItem == null || (tripleControlViewData2 = gesturesItem.controlViewData(isLeft, context)) == null) ? new Triple<>(new Pair("", ""), 0, 0) : tripleControlViewData2;
        }
        for (Object obj3 : IOTEarEspeonGestureAction.INSTANCE.getCaseGestures()) {
            if (((GesturesItem) obj3).getGestures() == gesture) {
                obj = obj3;
                break;
            }
        }
        GesturesItem gesturesItem2 = (GesturesItem) obj;
        return (gesturesItem2 == null || (tripleControlViewData = gesturesItem2.controlViewData(isLeft, context)) == null) ? new Triple<>(new Pair("", ""), 0, 0) : tripleControlViewData;
    }

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public void convertOptions(ControlConfigurationEntity.Operation it, Context context) {
        Pair<String, Integer> gestureOperation;
        int i;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(context, "context");
        getOperationList().clear();
        if (Intrinsics.areEqual((Object) isCase().get(), (Object) true) && (it.getGesture() == 2 || it.getGesture() == 3)) {
            gestureOperation = getNoExtraFunc(it.getOperation(), context);
        } else {
            gestureOperation = getGestureOperation(it.getOperation(), context);
        }
        setOperationNameAppend(gestureOperation.getFirst());
        int gesture = it.getGesture();
        if (gesture == 1) {
            caseSinglePressGesture(context, it);
        } else if (gesture != 2) {
            if (gesture != 3) {
                if (gesture != 15) {
                    switch (gesture) {
                        case 7:
                            if (Intrinsics.areEqual((Object) isCase().get(), (Object) true)) {
                                casePressHoldGesture(context, it);
                            } else {
                                earLongTap(gestureOperation, context, it);
                            }
                            break;
                        case 8:
                        case 9:
                            earTapAndLongPressGesture(gestureOperation, context, it);
                            break;
                        case 10:
                            int[] iArr = CASE_SUPPORT_ROTATE;
                            int length = iArr.length;
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < length) {
                                int i4 = iArr[i2];
                                int i5 = i3 + 1;
                                if (i3 == 0) {
                                    i = 0;
                                } else {
                                    i = i3 == CASE_SUPPORT_ROTATE.length - 1 ? 1 : -1;
                                }
                                caseOperationList(i4, context, it, i);
                                i2++;
                                i3 = i5;
                            }
                            setDefaultOperation(1);
                            break;
                    }
                } else {
                    getSecondOperationVisible().set(true);
                    getArrowVisible().set(8);
                }
            } else if (Intrinsics.areEqual((Object) isCase().get(), (Object) true)) {
                caseTriplePress(context, it, gestureOperation);
            } else {
                Pair<String, Integer> noExtraFunc = getNoExtraFunc(it.getOperation(), context);
                setOperationNameAppend(noExtraFunc.getFirst());
                earTripleTap(context, noExtraFunc, it);
            }
        } else if (Intrinsics.areEqual((Object) isCase().get(), (Object) true)) {
            caseDoublePressGesture(context, gestureOperation, it);
        } else {
            Pair<String, Integer> noExtraFunc2 = getNoExtraFunc(it.getOperation(), context);
            setOperationNameAppend(noExtraFunc2.getFirst());
            earDoubleTap(context, noExtraFunc2, it);
        }
        int device = it.getDevice();
        if (device == 2) {
            isLeft().set(true);
            isRight().set(false);
            isCase().set(false);
        } else if (device == 3) {
            isLeft().set(false);
            isRight().set(true);
            isCase().set(false);
        } else if (device == 4) {
            isLeft().set(false);
            isRight().set(false);
            isCase().set(true);
        } else {
            isLeft().set(false);
            isRight().set(false);
            isCase().set(false);
        }
    }

    private final void caseTriplePress(Context context, ControlConfigurationEntity.Operation it, Pair<String, Integer> gestureOperation) {
        int i;
        Context context2 = context;
        int[] iArr = CASE_SUPPORT_SINGLE_PRESS;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = -1;
            if (i2 >= length) {
                break;
            }
            int i5 = iArr[i2];
            int i6 = i3 + 1;
            if (i3 == 0) {
                i4 = 0;
            }
            caseOperationList(i5, context2, it, i4);
            i2++;
            i3 = i6;
        }
        if (isSupportNews()) {
            ControlGestureViewModel.addNewsControl$default(this, 31, it, context2, -1, null, 16, null);
            context2 = context2;
        }
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(1, getNoExtraFunc(1, context2), null, null, 12, null);
        controlOperationViewModel.selectedOperation(it.getOperation() == 1);
        getOperationList().add(controlOperationViewModel);
        int[] iArr2 = CASE_SUPPORT_TRIPLE_PRESS_CALL;
        int length2 = iArr2.length;
        int i7 = 0;
        int i8 = 0;
        while (i8 < length2) {
            int i9 = i7 + 1;
            addCaseCallOperation(getCallOperation(), iArr2[i8], context2, Boolean.valueOf(i7 == 0), i7 == CASE_SUPPORT_TRIPLE_PRESS_CALL.length - 1);
            i8++;
            i7 = i9;
        }
        ControlConfigurationEntity.Operation callOperation = getCallOperation();
        if (callOperation != null) {
            int operation = callOperation.getOperation();
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "\u6dfb\u52a0\u6253\u7535\u8bdd \u64cd\u4f5c operation:" + operation;
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            getOperationSubName().set("\n" + ((Object) getGestureOperation(operation, context2).getFirst()));
            setOperationNameAppend(gestureOperation.getFirst());
            i = 1;
        } else {
            i = 1;
        }
        setDefaultOperation(i);
    }

    private final void earTapAndLongPressGesture(Pair<String, Integer> gestureOperation, Context context, ControlConfigurationEntity.Operation it) {
        setOperationNameAppend(gestureOperation.getFirst());
        getSecondOperationVisible().set(true);
        setDefaultOperation(1);
        int[] iArr = SUPPORT_OPERATIONS_LONG_PRESS;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(i3, getGestureOperation(i3, context), null, null, 12, null);
            if (i2 == 0) {
                controlOperationViewModel.setDirection(ControlRadius.HEAD);
            }
            controlOperationViewModel.selectedOperation(it.getOperation() == i3);
            getOperationList().add(controlOperationViewModel);
            i++;
            i2 = i4;
        }
        if (isSupportNews()) {
            ControlGestureViewModel.addNewsControl$default(this, 31, it, context, -1, null, 16, null);
        }
        ControlOperationViewModel controlOperationViewModel2 = new ControlOperationViewModel(1, getGestureOperation(1, context), null, null, 12, null);
        controlOperationViewModel2.setDirection(ControlRadius.END);
        controlOperationViewModel2.selectedOperation(it.getOperation() == 1);
        getOperationList().add(controlOperationViewModel2);
    }

    private final void caseDoublePressGesture(Context context, Pair<String, Integer> gestureOperation, ControlConfigurationEntity.Operation it) {
        ControlItemViewModel controlItemViewModel = this;
        Context context2 = context;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "GESTURE_DOUBLE_TAP isCase:callOperation:" + (controlItemViewModel.getCallOperation() == null);
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        ControlConfigurationEntity.Operation callOperation = controlItemViewModel.getCallOperation();
        if (callOperation != null) {
            controlItemViewModel.getOperationSubName().set("\n" + ((Object) controlItemViewModel.getGestureOperation(callOperation.getOperation(), context2).getFirst()));
            controlItemViewModel.setOperationNameAppend(gestureOperation.getFirst());
        }
        controlItemViewModel.setDefaultOperation(1);
        int[] iArr = CASE_SUPPORT_SINGLE_PRESS;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = -1;
            if (i >= length) {
                break;
            }
            int i4 = iArr[i];
            int i5 = i2 + 1;
            if (i2 == 0) {
                i3 = 0;
            }
            controlItemViewModel.caseOperationList(i4, context2, it, i3);
            i++;
            i2 = i5;
        }
        if (controlItemViewModel.isSupportNews()) {
            ControlGestureViewModel.addNewsControl$default(controlItemViewModel, 31, it, context2, -1, null, 16, null);
            context2 = context2;
        }
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(1, controlItemViewModel.getNoExtraFunc(1, context2), null, null, 12, null);
        controlOperationViewModel.selectedOperation(it.getOperation() == 1);
        controlItemViewModel.getOperationList().add(controlOperationViewModel);
        int[] iArr2 = CASE_SUPPORT_DOUBLE_PRESS_CALL;
        int length2 = iArr2.length;
        int i6 = 0;
        int i7 = 0;
        while (i7 < length2) {
            int i8 = i6 + 1;
            controlItemViewModel.addCaseCallOperation(controlItemViewModel.getCallOperation(), iArr2[i7], context2, Boolean.valueOf(i6 == 0), i6 == CASE_SUPPORT_DOUBLE_PRESS_CALL.length - 1);
            i7++;
            controlItemViewModel = this;
            context2 = context;
            i6 = i8;
        }
    }

    private final void caseSinglePressGesture(Context context, ControlConfigurationEntity.Operation it) {
        setDefaultOperation(1);
        int[] iArr = CASE_SUPPORT_SINGLE_PRESS;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = -1;
            if (i >= length) {
                break;
            }
            int i4 = iArr[i];
            int i5 = i2 + 1;
            if (i2 == 0) {
                i3 = 0;
            }
            caseOperationList(i4, context, it, i3);
            i++;
            i2 = i5;
        }
        if (isSupportNews()) {
            ControlGestureViewModel.addNewsControl$default(this, 31, it, context, -1, null, 16, null);
        }
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(1, getGestureOperation(1, context), null, null, 12, null);
        controlOperationViewModel.setDirection(ControlRadius.END);
        controlOperationViewModel.selectedOperation(it.getOperation() == 1);
        getOperationList().add(controlOperationViewModel);
    }

    private final void casePressHoldGesture(Context context, ControlConfigurationEntity.Operation it) {
        setDefaultOperation(1);
        int[] iArr = CASE_SUPPORT_PRESS_HOLD;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = -1;
            if (i >= length) {
                break;
            }
            int i4 = iArr[i];
            int i5 = i2 + 1;
            if (i2 == 0) {
                i3 = 0;
            }
            caseOperationList(i4, context, it, i3);
            i++;
            i2 = i5;
        }
        if (isSupportNews()) {
            ControlGestureViewModel.addNewsControl$default(this, 31, it, context, -1, null, 16, null);
        }
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(1, getGestureOperation(1, context), null, null, 12, null);
        controlOperationViewModel.setDirection(ControlRadius.END);
        controlOperationViewModel.selectedOperation(it.getOperation() == 1);
        getOperationList().add(controlOperationViewModel);
    }

    static /* synthetic */ void addCaseCallOperation$default(ControlItemViewModel controlItemViewModel, ControlConfigurationEntity.Operation operation, int i, Context context, Boolean bool, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            bool = false;
        }
        controlItemViewModel.addCaseCallOperation(operation, i, context, bool, z);
    }

    private final void addCaseCallOperation(ControlConfigurationEntity.Operation it, int operation, Context context, Boolean isFirst, boolean isEnd) {
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(operation, getGestureOperation(operation, context), 9, isFirst);
        if (Intrinsics.areEqual((Object) isFirst, (Object) true)) {
            controlOperationViewModel.isCallGesture().set(true);
        }
        if (isEnd) {
            controlOperationViewModel.setDirection(ControlRadius.END);
        }
        controlOperationViewModel.selectedOperation(it != null && it.getOperation() == operation);
        getOperationList().add(controlOperationViewModel);
    }

    private final void earLongTap(Pair<String, Integer> gestureOperation, Context context, ControlConfigurationEntity.Operation it) {
        ControlConfigurationEntity.Operation operation;
        Context context2;
        setOperationNameAppend(gestureOperation.getFirst());
        setDefaultOperation(22);
        for (int i : SUPPORT_OPERATIONS_NO_CLOSE) {
            parseAncOperation(i, new ControlOperationViewModel(i, getGestureOperation(i, context), null, null, 12, null), it);
        }
        if (isSupportNews()) {
            operation = it;
            ControlGestureViewModel.addNewsControl$default(this, 31, operation, context, -1, null, 16, null);
            context2 = context;
        } else {
            operation = it;
            context2 = context;
        }
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(1, getGestureOperation(1, context2), null, null, 12, null);
        controlOperationViewModel.setDirection(ControlRadius.END);
        controlOperationViewModel.selectedOperation(operation.getOperation() == 1);
        getOperationList().add(controlOperationViewModel);
    }

    private final void caseOperationList(int operation, Context context, ControlConfigurationEntity.Operation it, int isHead) {
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(operation, getGestureOperation(operation, context), null, null, 12, null);
        if (isHead == 0) {
            controlOperationViewModel.setDirection(ControlRadius.HEAD);
        } else if (isHead == 1) {
            controlOperationViewModel.setDirection(ControlRadius.END);
        }
        parseAncOperation(operation, controlOperationViewModel, it);
    }

    private final void parseAncOperation(int operation, ControlOperationViewModel element, ControlConfigurationEntity.Operation it) {
        if (operation == 22) {
            element.selectedOperation(element.convertAnc(it.getOperation(), true));
            element.setDirection(ControlRadius.HEAD);
            getOperationList().add(element);
        } else {
            element.selectedOperation(it.getOperation() == operation);
            getOperationList().add(element);
        }
    }

    private final void earTripleTap(Context context, Pair<String, Integer> gestureOperation, ControlConfigurationEntity.Operation it) {
        getOperationSubName().set("\n" + ((Object) getNoExtraFunc(26, context).getFirst()));
        setOperationNameAppend(gestureOperation.getFirst());
        getSecondOperationVisible().set(true);
        setDefaultOperation(8);
        int[] iArr = SUPPORT_OPERATIONS;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(i3, getNoExtraFunc(i3, context), null, null, 12, null);
            controlOperationViewModel.selectedOperation(it.getOperation() == i3);
            if (i2 == 0) {
                controlOperationViewModel.setDirection(ControlRadius.HEAD);
            }
            getOperationList().add(controlOperationViewModel);
            i++;
            i2 = i4;
        }
        if (isSupportNews()) {
            ControlGestureViewModel.addNewsControl$default(this, 31, it, context, -1, null, 16, null);
        }
        ControlOperationViewModel controlOperationViewModel2 = new ControlOperationViewModel(1, getNoExtraFunc(1, context), null, null, 12, null);
        controlOperationViewModel2.selectedOperation(it.getOperation() == 1);
        controlOperationViewModel2.setDirection(ControlRadius.END);
        getOperationList().add(controlOperationViewModel2);
        ControlOperationViewModel controlOperationViewModel3 = new ControlOperationViewModel(26, getGestureOperation(26, context), null, null, 12, null);
        controlOperationViewModel3.setDirection(ControlRadius.NONE);
        controlOperationViewModel3.getEnable().set(false);
        controlOperationViewModel3.selectedOperation(false);
        getOperationList().add(controlOperationViewModel3);
    }

    private final void earDoubleTap(Context context, Pair<String, Integer> gestureOperation, ControlConfigurationEntity.Operation it) {
        getOperationSubName().set("\n" + ((Object) getNoExtraFunc(3, context).getFirst()));
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
            ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(i3, getNoExtraFunc(i3, context), null, null, 12, null);
            if (i2 == 0) {
                controlOperationViewModel.setDirection(ControlRadius.HEAD);
            }
            controlOperationViewModel.selectedOperation(it.getOperation() == i3);
            getOperationList().add(controlOperationViewModel);
            i++;
            i2 = i4;
        }
        if (isSupportNews()) {
            ControlGestureViewModel.addNewsControl$default(this, 31, it, context, null, null, 24, null);
        }
        ControlOperationViewModel controlOperationViewModel2 = new ControlOperationViewModel(1, getNoExtraFunc(1, context), null, null, 12, null);
        controlOperationViewModel2.setDirection(ControlRadius.END);
        controlOperationViewModel2.selectedOperation(it.getOperation() == 1);
        getOperationList().add(controlOperationViewModel2);
        ControlOperationViewModel controlOperationViewModel3 = new ControlOperationViewModel(3, getGestureOperation(3, context), null, null, 12, null);
        controlOperationViewModel3.setDirection(ControlRadius.NONE);
        controlOperationViewModel3.getEnable().set(false);
        controlOperationViewModel3.selectedOperation(false);
        getOperationList().add(controlOperationViewModel3);
    }

    private final Pair<String, Integer> getNoExtraFunc(int operation, Context context) {
        if (operation == 1) {
            String string = ContextExtKt.getLocalizedResources(context).getString(R.string.control_no_extra_action);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return TuplesKt.to(string, 0);
        }
        return getGestureOperation(operation, context);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f5  */
    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public Pair<String, Integer> getGestureOperation(int operation, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (operation == 1) {
            String string = ContextExtKt.getLocalizedResources(context).getString(R.string.control_no_action);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return TuplesKt.to(string, 0);
        }
        if (operation == 2) {
            String string2 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_play_pause);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return TuplesKt.to(string2, 0);
        }
        if (operation == 3) {
            String string3 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_answer_call);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return TuplesKt.to(string3, 0);
        }
        if (operation == 4) {
            String string4 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_decline_incoming_call);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return TuplesKt.to(string4, 0);
        }
        if (operation == 31) {
            String string5 = ContextExtKt.getLocalizedResources(context).getString(R.string.ai_news);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return TuplesKt.to(string5, 0);
        }
        if (operation == 32) {
            return TuplesKt.to("Nothing radio", 0);
        }
        if (operation == 39) {
            String string6 = ContextExtKt.getLocalizedResources(context).getString(R.string.switch_bluetooth_connection);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return TuplesKt.to(string6, 0);
        }
        if (operation == 40) {
            String string7 = ContextExtKt.getLocalizedResources(context).getString(R.string.lock_unlock_tips, ContextExtKt.getLocalizedResources(context).getString(R.string.knob));
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return TuplesKt.to(string7, 0);
        }
        if (operation != 255) {
            switch (operation) {
                case 6:
                    return volumeUp(context);
                case 7:
                    return volumeDown(context);
                case 8:
                    String string8 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_skip_back);
                    Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                    return TuplesKt.to(string8, 0);
                case 9:
                    String string9 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_skip_forward);
                    Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                    return TuplesKt.to(string9, 0);
                case 10:
                    return ancNoiseControl(context);
                case 11:
                    if (VoiceAssistantUtil.INSTANCE.isSupportGpt()) {
                        String string10 = ContextExtKt.getLocalizedResources(context).getString(R.string.voice_ai_title);
                        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                        return TuplesKt.to(string10, 0);
                    }
                    String string11 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_voice_assistant);
                    Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                    return TuplesKt.to(string11, 0);
                default:
                    switch (operation) {
                        case 17:
                            String string12 = ContextExtKt.getLocalizedResources(context).getString(R.string.case_game_model);
                            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                            return TuplesKt.to(string12, 0);
                        case 18:
                            return volumeUp(context);
                        case 19:
                            return volumeDown(context);
                        case 20:
                        case 21:
                        case 22:
                            return ancNoiseControl(context);
                        case 23:
                            return volumeControl(context);
                        case 24:
                            String string13 = ContextExtKt.getLocalizedResources(context).getString(R.string.pairing_mode);
                            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                            return TuplesKt.to(string13, 0);
                        case 25:
                            String string14 = ContextExtKt.getLocalizedResources(context).getString(R.string.case_answer_call_mute);
                            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                            return TuplesKt.to(string14, 0);
                        case 26:
                            String string15 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_hand_up_decline_incoming_calls);
                            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                            return TuplesKt.to(string15, 0);
                        case 27:
                            return TuplesKt.to("Spatial audio", 0);
                        case 28:
                            return TuplesKt.to("Bass enhancement", 0);
                        case 29:
                            return TuplesKt.to("Mic mute", 0);
                        default:
                            return TuplesKt.to("", 0);
                    }
            }
        }
        return volumeControl(context);
    }
}
