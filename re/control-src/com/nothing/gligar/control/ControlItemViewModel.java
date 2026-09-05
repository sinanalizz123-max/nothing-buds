package com.nothing.gligar.control;

import android.content.Context;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.VoiceAssistantUtil;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.control.entity.ControlRadius;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ControlItemViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J,\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J,\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J,\u0010\u0015\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J,\u0010\u0018\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J$\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/nothing/gligar/control/ControlItemViewModel;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;)V", "onClickSelectedOperation", "", "itemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "convertOptions", "it", "earDoubleTap", "gestureOperation", "Lkotlin/Pair;", "", "earTripleTap", "earLongTap", "parseAncOperation", "element", "earTapAndLongPressGesture", "getNoExtraFunc", "getGestureOperation", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlItemViewModel extends ControlGestureViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_OPERATIONS = {8, 9, 11, 31, 1};
    private static final int[] SUPPORT_OPERATIONS_NO_CLOSE = {22, 11, 31, 1};
    private static final int[] SUPPORT_OPERATIONS_LONG_PRESS = {18, 19, 11, 31, 1};
    private static final int[] SUPPORT_DOUBLE_OPERATIONS = {2, 8, 9, 11, 31, 1};

    /* JADX INFO: compiled from: ControlItemViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/gligar/control/ControlItemViewModel$Companion;", "", "<init>", "()V", "SUPPORT_OPERATIONS", "", "getSUPPORT_OPERATIONS", "()[I", "SUPPORT_OPERATIONS_NO_CLOSE", "getSUPPORT_OPERATIONS_NO_CLOSE", "SUPPORT_OPERATIONS_LONG_PRESS", "getSUPPORT_OPERATIONS_LONG_PRESS", "SUPPORT_DOUBLE_OPERATIONS", "getSUPPORT_DOUBLE_OPERATIONS", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Override // com.nothing.earbase.control.ControlGestureViewModel
    public void convertOptions(ControlConfigurationEntity.Operation it, Context context) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(context, "context");
        getOperationList().clear();
        int gesture = it.getGesture();
        if (gesture == 2) {
            Pair<String, Integer> noExtraFunc = getNoExtraFunc(it.getOperation(), context);
            setOperationNameAppend(noExtraFunc.getFirst());
            earDoubleTap(context, noExtraFunc, it);
        } else if (gesture == 3) {
            Pair<String, Integer> noExtraFunc2 = getNoExtraFunc(it.getOperation(), context);
            setOperationNameAppend(noExtraFunc2.getFirst());
            earTripleTap(context, noExtraFunc2, it);
        } else if (gesture == 7) {
            Pair<String, Integer> gestureOperation = getGestureOperation(it.getOperation(), context);
            setOperationNameAppend(gestureOperation.getFirst());
            earLongTap(gestureOperation, context, it);
        } else if (gesture == 8 || gesture == 9) {
            Pair<String, Integer> gestureOperation2 = getGestureOperation(it.getOperation(), context);
            setOperationNameAppend(gestureOperation2.getFirst());
            earTapAndLongPressGesture(gestureOperation2, context, it);
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

    private final void earDoubleTap(Context context, Pair<String, Integer> gestureOperation, ControlConfigurationEntity.Operation it) {
        int i;
        getOperationSubName().set("\n" + ((Object) getNoExtraFunc(3, context).getFirst()));
        setOperationNameAppend(gestureOperation.getFirst());
        getSecondOperationVisible().set(true);
        setDefaultOperation(9);
        int[] iArr = SUPPORT_DOUBLE_OPERATIONS;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int i4 = iArr[i3];
            int i5 = i2 + 1;
            if (i2 == 0) {
                i = 0;
            } else {
                i = i2 == SUPPORT_DOUBLE_OPERATIONS.length - 1 ? 1 : -1;
            }
            addNewsControl(i4, it, context, Integer.valueOf(i), Boolean.valueOf(i4 == 1));
            i3++;
            i2 = i5;
        }
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(3, getGestureOperation(3, context), null, null, 12, null);
        controlOperationViewModel.setDirection(ControlRadius.NONE);
        controlOperationViewModel.getEnable().set(false);
        controlOperationViewModel.selectedOperation(false);
        getOperationList().add(controlOperationViewModel);
    }

    private final void earTripleTap(Context context, Pair<String, Integer> gestureOperation, ControlConfigurationEntity.Operation it) {
        int i;
        getOperationSubName().set("\n" + ((Object) getNoExtraFunc(26, context).getFirst()));
        setOperationNameAppend(gestureOperation.getFirst());
        getSecondOperationVisible().set(true);
        setDefaultOperation(8);
        int[] iArr = SUPPORT_OPERATIONS;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int i4 = iArr[i3];
            int i5 = i2 + 1;
            if (i2 == 0) {
                i = 0;
            } else {
                i = i2 == SUPPORT_OPERATIONS.length - 1 ? 1 : -1;
            }
            addNewsControl(i4, it, context, Integer.valueOf(i), Boolean.valueOf(i4 == 1));
            i3++;
            i2 = i5;
        }
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(26, getGestureOperation(26, context), null, null, 12, null);
        controlOperationViewModel.setDirection(ControlRadius.NONE);
        controlOperationViewModel.getEnable().set(false);
        controlOperationViewModel.selectedOperation(false);
        getOperationList().add(controlOperationViewModel);
    }

    private final void earLongTap(Pair<String, Integer> gestureOperation, Context context, ControlConfigurationEntity.Operation it) {
        int i;
        setOperationNameAppend(gestureOperation.getFirst());
        setDefaultOperation(22);
        int[] iArr = SUPPORT_OPERATIONS_NO_CLOSE;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            if (i3 == 0) {
                i = 0;
            } else {
                i = 1;
                if (i3 != SUPPORT_OPERATIONS_NO_CLOSE.length - 1) {
                    i = -1;
                }
            }
            ControlGestureViewModel.addNewsControl$default(this, i4, it, context, Integer.valueOf(i), null, 16, null);
            i2++;
            i3 = i5;
        }
    }

    private final void parseAncOperation(int operation, ControlOperationViewModel element, ControlConfigurationEntity.Operation it) {
        if (operation == 22) {
            element.selectedOperation(element.convertAnc(it.getOperation(), true));
            getOperationList().add(element);
        } else {
            element.selectedOperation(it.getOperation() == operation);
            getOperationList().add(element);
        }
    }

    private final void earTapAndLongPressGesture(Pair<String, Integer> gestureOperation, Context context, ControlConfigurationEntity.Operation it) {
        int i;
        setOperationNameAppend(gestureOperation.getFirst());
        getSecondOperationVisible().set(true);
        setDefaultOperation(1);
        int[] iArr = SUPPORT_OPERATIONS_LONG_PRESS;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            if (i3 == 0) {
                i = 0;
            } else {
                i = i3 == SUPPORT_OPERATIONS_NO_CLOSE.length - 1 ? 1 : -1;
            }
            ControlGestureViewModel.addNewsControl$default(this, i4, it, context, Integer.valueOf(i), null, 16, null);
            i2++;
            i3 = i5;
        }
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
