package com.nothing.elekid.control;

import android.app.Application;
import android.content.Context;
import androidx.databinding.ObservableField;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.ear.R;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u00a8\u0006\u0019"}, d2 = {"Lcom/nothing/elekid/control/ControlItemViewModel;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "isSystem", "", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;Z)V", "onClickSelectedOperation", "", "itemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "convertOptions", "it", "addMagicNews", "", "addMagicClose", "addNothingRadioSetting", "addEssentialSpace", "addNothingRadio", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlItemViewModel extends ControlGestureViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_DOUBLE_OPERATIONS = {8, 9, 11};
    private static final int[] SUPPORT_OPERATIONS = {8, 9, 11};
    private static final int[] SUPPORT_OPERATIONS_MORE = {10};

    public /* synthetic */ ControlItemViewModel(ControlConfigurationEntity.Operation operation, Context context, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(operation, context, str, (i & 8) != 0 ? false : z);
    }

    /* JADX INFO: compiled from: ControlItemViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/nothing/elekid/control/ControlItemViewModel$Companion;", "", "<init>", "()V", "SUPPORT_DOUBLE_OPERATIONS", "", "getSUPPORT_DOUBLE_OPERATIONS", "()[I", "SUPPORT_OPERATIONS", "getSUPPORT_OPERATIONS", "SUPPORT_OPERATIONS_MORE", "getSUPPORT_OPERATIONS_MORE", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final int[] getSUPPORT_OPERATIONS_MORE() {
            return ControlItemViewModel.SUPPORT_OPERATIONS_MORE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ControlItemViewModel(ControlConfigurationEntity.Operation operation, Context context, String address, boolean z) {
        super(operation, context, address, null, z, 8, null);
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
        Boolean bool;
        Boolean bool2;
        int i;
        boolean z;
        Boolean bool3;
        Boolean bool4;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(context, "context");
        getOperationList().clear();
        Pair<String, Integer> gestureOperation = getGestureOperation(it.getOperation(), context);
        setOperationNameAppend(gestureOperation.getFirst());
        int gesture = it.getGesture();
        int i2 = 31;
        boolean z2 = false;
        Boolean bool5 = false;
        boolean z3 = true;
        Boolean bool6 = true;
        if (gesture == 1) {
            bool = bool5;
            bool2 = bool6;
            if (it.getButton() == 10) {
                setOperationNameAppend(gestureOperation.getFirst());
                getSecondOperationVisible().set(bool2);
                setDefaultOperation(NothingOSUtil.INSTANCE.isNothingOS() ? 32 : 11);
                addNothingRadio(it, context);
                int[] support_magic_gestures = ControlViewModel.INSTANCE.getSUPPORT_MAGIC_GESTURES();
                int length = support_magic_gestures.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = support_magic_gestures[i3];
                    int i6 = i4 + 1;
                    if (i5 == 31) {
                        addMagicNews(context, i5, it);
                        i = i3;
                    } else {
                        i = i3;
                        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(i5, getGestureOperation(i5, context), 10, null, 8, null);
                        controlOperationViewModel.selectedOperation(it.getOperation() == i5);
                        if (i5 == 10) {
                            controlOperationViewModel.selectedOperation(controlOperationViewModel.convertAnc(it.getOperation(), true));
                        }
                        if (i4 == 0 && getOperationList().size() == 0) {
                            controlOperationViewModel.setDirection(ControlRadius.HEAD);
                        }
                        getOperationList().add(controlOperationViewModel);
                    }
                    i3 = i + 1;
                    i4 = i6;
                }
                addMagicClose(context, it);
                addNothingRadioSetting(context);
            }
        } else if (gesture == 2) {
            bool = bool5;
            bool2 = bool6;
            getOperationSubName().set("\n" + ((Object) getGestureOperation(4, context).getFirst()));
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(bool2);
            setDefaultOperation(9);
            int[] iArr = SUPPORT_DOUBLE_OPERATIONS;
            int length2 = iArr.length;
            for (int i7 = 0; i7 < length2; i7++) {
                int i8 = iArr[i7];
                ControlOperationViewModel controlOperationViewModel2 = new ControlOperationViewModel(i8, getGestureOperation(i8, context), null, null, 12, null);
                controlOperationViewModel2.selectedOperation(it.getOperation() == i8);
                getOperationList().add(controlOperationViewModel2);
            }
            ControlOperationViewModel controlOperationViewModel3 = new ControlOperationViewModel(4, getGestureOperation(4, context), null, null, 12, null);
            controlOperationViewModel3.getEnable().set(bool);
            controlOperationViewModel3.selectedOperation(false);
            getOperationList().add(controlOperationViewModel3);
        } else if (gesture == 3) {
            bool = bool5;
            bool2 = bool6;
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(bool2);
            setDefaultOperation(8);
            int[] iArr2 = SUPPORT_OPERATIONS;
            int length3 = iArr2.length;
            for (int i9 = 0; i9 < length3; i9++) {
                int i10 = iArr2[i9];
                ControlOperationViewModel controlOperationViewModel4 = new ControlOperationViewModel(i10, getGestureOperation(i10, context), null, null, 12, null);
                controlOperationViewModel4.selectedOperation(it.getOperation() == i10);
                getOperationList().add(controlOperationViewModel4);
            }
        } else if (gesture != 7) {
            if (gesture == 12) {
                setOperationNameAppend(getGestureOperation(it.getOperation(), context).getFirst());
                getSecondOperationVisible().set(bool5);
            } else {
                switch (gesture) {
                    case 17:
                        setOperationNameAppend(getGestureOperation(it.getOperation(), context).getFirst());
                        getSecondOperationVisible().set(bool5);
                        break;
                    case 18:
                        setOperationNameAppend(getGestureOperation(it.getOperation(), context).getFirst());
                        getSecondOperationVisible().set(bool5);
                        break;
                    case 19:
                        setOperationNameAppend(getGestureOperation(it.getOperation(), context).getFirst());
                        getSecondOperationVisible().set(bool5);
                        break;
                }
            }
            bool = bool5;
            bool2 = bool6;
        } else if (it.getButton() == 10) {
            setOperationNameAppend(gestureOperation.getFirst());
            getSecondOperationVisible().set(bool6);
            setDefaultOperation(NothingOSUtil.INSTANCE.isNothingOS() ? 11 : 1);
            addNothingRadio(it, context);
            int[] support_magic_gestures2 = ControlViewModel.INSTANCE.getSUPPORT_MAGIC_GESTURES();
            int length4 = support_magic_gestures2.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length4) {
                Boolean bool7 = bool5;
                int i13 = support_magic_gestures2[i11];
                int i14 = i12 + 1;
                if (i13 == i2) {
                    addMagicNews(context, i13, it);
                    z = z3;
                    bool4 = bool6;
                    bool3 = bool7;
                } else {
                    z = z3;
                    bool3 = bool7;
                    bool4 = bool6;
                    ControlOperationViewModel controlOperationViewModel5 = new ControlOperationViewModel(i13, getGestureOperation(i13, context), 10, null, 8, null);
                    controlOperationViewModel5.selectedOperation(it.getOperation() == i13 ? z : false);
                    if (i13 == 10) {
                        controlOperationViewModel5.selectedOperation(controlOperationViewModel5.convertAnc(it.getOperation(), z));
                    }
                    if (i12 == 0 && getOperationList().size() == 0) {
                        controlOperationViewModel5.setDirection(ControlRadius.HEAD);
                    }
                    getOperationList().add(controlOperationViewModel5);
                }
                i11++;
                bool5 = bool3;
                bool6 = bool4;
                z3 = z;
                i12 = i14;
                i2 = 31;
                z2 = false;
            }
            bool = bool5;
            bool2 = bool6;
            addEssentialSpace(it, context);
            addMagicClose(context, it);
            addNothingRadioSetting(context);
        } else {
            bool = bool5;
            bool2 = bool6;
            setDefaultOperation(22);
            int[] iArr3 = SUPPORT_OPERATIONS_MORE;
            int length5 = iArr3.length;
            for (int i15 = 0; i15 < length5; i15++) {
                int i16 = iArr3[i15];
                ControlOperationViewModel controlOperationViewModel6 = new ControlOperationViewModel(i16, getGestureOperation(i16, context), null, null, 12, null);
                controlOperationViewModel6.getItemSelectRadioVisible().set(bool);
                if (i16 == 10) {
                    controlOperationViewModel6.selectedOperation(controlOperationViewModel6.convertAnc(it.getOperation(), true));
                    controlOperationViewModel6.setDirection(ControlRadius.NONE);
                    getOperationList().add(controlOperationViewModel6);
                } else {
                    controlOperationViewModel6.selectedOperation(it.getOperation() == i16);
                    controlOperationViewModel6.setDirection(ControlRadius.NONE);
                    getOperationList().add(controlOperationViewModel6);
                }
            }
        }
        int device = it.getDevice();
        if (device == 2) {
            isLeft().set(bool2);
        } else if (device == 3) {
            isLeft().set(bool);
        } else {
            if (device != 6) {
                return;
            }
            isLeft().set(bool);
        }
    }

    private final void addMagicNews(Context context, int operation, ControlConfigurationEntity.Operation it) {
        boolean zHasNothingAiNews = NothingOSUtil.INSTANCE.isNothingOS() ? RouterFactory.INSTANCE.getWidgetRouter().hasNothingAiNews(context) : false;
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(operation, getGestureOperation(operation, context), 10, null, 8, null);
        if (it.getOperation() == 31 && !NothingOSUtil.INSTANCE.isNothingOS()) {
            controlOperationViewModel.getEnable().set(false);
            controlOperationViewModel.getNewsPromptVisibility().set(true);
            ObservableField<String> newsPromptName = controlOperationViewModel.getNewsPromptName();
            Application application = AppGlobals.INSTANCE.get();
            Intrinsics.checkNotNull(application);
            newsPromptName.set(application.getString(R.string.not_support));
            controlOperationViewModel.selectedOperation(it.getOperation() == 31);
            getOperationList().add(controlOperationViewModel);
            return;
        }
        if (NothingOSUtil.INSTANCE.isNothingOS() && zHasNothingAiNews) {
            controlOperationViewModel.selectedOperation(it.getOperation() == 31);
            getOperationList().add(controlOperationViewModel);
            return;
        }
        if (NothingOSUtil.INSTANCE.isNothingOS() && !NothingOSUtil.INSTANCE.isSupportNews(AppGlobals.INSTANCE.get())) {
            controlOperationViewModel.getEnable().set(false);
            controlOperationViewModel.getNewsPromptVisibility().set(true);
            ObservableField<String> newsPromptName2 = controlOperationViewModel.getNewsPromptName();
            Application application2 = AppGlobals.INSTANCE.get();
            Intrinsics.checkNotNull(application2);
            int i = R.string.news_update_widget_app;
            Application application3 = AppGlobals.INSTANCE.get();
            Intrinsics.checkNotNull(application3);
            newsPromptName2.set(application2.getString(i, new Object[]{application3.getString(R.string.ai_news)}));
            controlOperationViewModel.selectedOperation(it.getOperation() == 31);
            getOperationList().add(controlOperationViewModel);
            return;
        }
        if (!NothingOSUtil.INSTANCE.isNothingOS() || zHasNothingAiNews) {
            return;
        }
        controlOperationViewModel.getEnable().set(false);
        controlOperationViewModel.getNewsPromptVisibility().set(true);
        ObservableField<String> newsPromptName3 = controlOperationViewModel.getNewsPromptName();
        Application application4 = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application4);
        newsPromptName3.set(application4.getString(R.string.news_nothing_control_add_widget));
        controlOperationViewModel.selectedOperation(it.getOperation() == 31);
        getOperationList().add(controlOperationViewModel);
    }

    private final void addMagicClose(Context context, ControlConfigurationEntity.Operation it) {
        ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(1, getGestureOperation(1, context), 10, null, 8, null);
        controlOperationViewModel.setDirection(ControlRadius.END);
        controlOperationViewModel.selectedOperation(it.getOperation() == 1);
        getOperationList().add(controlOperationViewModel);
    }

    private final void addNothingRadioSetting(Context context) {
        if (NothingOSUtil.INSTANCE.isNothingOS()) {
            ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(51, getGestureOperation(51, context), 10, null, 8, null);
            controlOperationViewModel.setDirection(ControlRadius.NONE);
            controlOperationViewModel.getItemSelectRadioVisible().set(false);
            controlOperationViewModel.isMagicGesture().set(true);
            getOperationList().add(controlOperationViewModel);
        }
    }

    private final void addEssentialSpace(ControlConfigurationEntity.Operation it, Context context) {
        if (NothingOSUtil.INSTANCE.isSupportEssential() || it.getOperation() == 33) {
            ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(33, getGestureOperation(33, context), 10, null, 8, null);
            controlOperationViewModel.selectedOperation(it.getOperation() == 33);
            if (!NothingOSUtil.INSTANCE.isSupportEssential()) {
                controlOperationViewModel.getEnable().set(false);
                controlOperationViewModel.getEssentialSpacePromptVisibility().set(true);
                controlOperationViewModel.getNewsPromptName().set(context.getString(R.string.not_support_essential));
            }
            getOperationList().add(controlOperationViewModel);
        }
    }

    private final void addNothingRadio(ControlConfigurationEntity.Operation it, Context context) {
        if (NothingOSUtil.INSTANCE.isNothingOS() || it.getOperation() == 32) {
            ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(32, getGestureOperation(32, context), 10, null, 8, null);
            controlOperationViewModel.selectedOperation(it.getOperation() == 32);
            controlOperationViewModel.setDirection(ControlRadius.HEAD);
            if (!NothingOSUtil.INSTANCE.isNothingOS()) {
                controlOperationViewModel.getEnable().set(false);
                controlOperationViewModel.getNothingRadioPromptVisibility().set(true);
                controlOperationViewModel.getNewsPromptName().set(context.getString(R.string.not_support_radio));
            }
            getOperationList().add(controlOperationViewModel);
        }
    }
}
