package com.nothing.elekid.control;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.nothing.base.adapter.CommonBindingAdapter;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.view.BaseConfig;
import com.nothing.base.wiget.ActionView;
import com.nothing.database.util.SpUtils;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.ElekidControlOperationActivityBinding;
import com.nothing.earbase.base.ActivityManager;
import com.nothing.earbase.control.BaseControlOperationActivity;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.VoiceAssistantUtil;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.log.FileLog;
import com.nothing.magicbutton.router.ControlActivityManager;
import com.nothing.magicbutton.util.MediaUtils;
import com.nothing.nt_permission.impl.ForegroundNoticePermission;
import com.nothing.nt_route.FlutterRouterManager;
import defpackage.FlutterRoute;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlOperationActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020#J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0014J\b\u0010'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u0014H\u0002J\u0016\u0010)\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020#J\u0016\u0010*\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020#J\u0016\u0010+\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020#J\b\u0010,\u001a\u00020\u0014H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/nothing/elekid/control/ControlOperationActivity;", "Lcom/nothing/earbase/control/BaseControlOperationActivity;", "Lcom/nothing/ear/databinding/ElekidControlOperationActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/elekid/control/ControlViewModel;", "isSelectLeft", "", "selectedOperation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "changeOperation", "changeControlBounds", "Lcom/nothing/elekid/control/ChangeControlBounds;", "magicDialog", "Lcom/nothing/elekid/control/MagicDialog;", "requestNotification", "getVoiceAssistantCount", "", "onBackPressedInner", "", "createContentConfig", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "refreshGestureData", "isLeft", "onClickChangeData", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "onSelectedOperation", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "Lcom/nothing/elekid/control/ControlItemViewModel;", "gotoMagicButton", "showNotificationDialog", "onResume", "startNotificationSetting", "setDefaultScaleSelected", "onClickTransparency", "onClickNoiseCancellation", "onClickOff", "onDestroy", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlOperationActivity extends BaseControlOperationActivity<ElekidControlOperationActivityBinding> {
    public static final String CHANGE_OPERATION = "CHANGE_OPERATION";
    public static final String IS_BACK_STACK = "IS_BACK_STACK";
    public static final String IS_LEFT_SELECTED = "IS_LEFT_SELECTED";
    public static final String SELECTED_OPERATION = "SELECTED_OPERATION";
    private boolean changeOperation;
    private MagicDialog magicDialog;
    private boolean requestNotification;
    private ControlConfigurationEntity.Operation selectedOperation;
    private ControlViewModel viewModel;
    private boolean isSelectLeft = true;
    private final ChangeControlBounds changeControlBounds = new ChangeControlBounds();

    @Override // com.nothing.earbase.control.BaseControlOperationActivity
    public int getVoiceAssistantCount() {
        ControlViewModel controlViewModel = this.viewModel;
        ControlViewModel controlViewModel2 = null;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        int iCheckHasSelectAssistant = checkHasSelectAssistant(controlViewModel.getLeftGestureData());
        ControlViewModel controlViewModel3 = this.viewModel;
        if (controlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel3;
        }
        return iCheckHasSelectAssistant + checkHasSelectAssistant(controlViewModel2.getRightGestureData());
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onBackPressedInner() {
        Bundle extras = getIntent().getExtras();
        if (Intrinsics.areEqual((Object) (extras != null ? Boolean.valueOf(extras.getBoolean(IS_BACK_STACK, false)) : null), (Object) true)) {
            Intent intent = new Intent(this, (Class<?>) ControlActivity.class);
            intent.addFlags(65536);
            startActivity(intent);
            finish();
        } else {
            setResult(-1, new Intent().putExtra("CHANGE_OPERATION", this.changeOperation));
        }
        super.onBackPressedInner();
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        ControlViewModel controlViewModel = (ControlViewModel) new ViewModelProvider(this).get(ControlViewModel.class);
        this.viewModel = controlViewModel;
        ControlViewModel controlViewModel2 = null;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        Intent intent = getIntent();
        controlViewModel.register(intent != null ? intent.getExtras() : null);
        ControlActivityManager controlActivityManager = ControlActivityManager.INSTANCE;
        Intent intent2 = getIntent();
        controlActivityManager.setOperationBundle(intent2 != null ? intent2.getExtras() : null);
        Bundle extras = getIntent().getExtras();
        this.selectedOperation = extras != null ? (ControlConfigurationEntity.Operation) extras.getParcelable("SELECTED_OPERATION") : null;
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.elekid_control_operation_activity);
        int i = BR.viewModel;
        ControlViewModel controlViewModel3 = this.viewModel;
        if (controlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel3;
        }
        layoutId.addVariable(i, controlViewModel2).addVariable(BR.eventHandler, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nothing.earbase.control.BaseControlOperationActivity, com.nothing.base.view.BaseActivity
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        setDefaultScaleSelected();
        ((ElekidControlOperationActivityBinding) getMBinding()).rvOperation.setLayoutManager(new LinearLayoutManager(this));
        ((ElekidControlOperationActivityBinding) getMBinding()).setEventHandler(this);
        this.magicDialog = new MagicDialog();
        ControlActivityManager.INSTANCE.addActivity(this);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0198  */
    private final void refreshGestureData(ControlViewModel viewModel, boolean isLeft) {
        Iterator<CommonBindingMoreType> it;
        CommonBindingMoreType commonBindingMoreType;
        ControlConfigurationEntity.Operation options;
        ControlConfigurationEntity.Operation options2;
        ControlConfigurationEntity.Operation options3;
        Iterator<CommonBindingMoreType> it2 = (isLeft ? viewModel.getLeftGestureData() : viewModel.getRightGestureData()).iterator();
        while (it2.hasNext()) {
            CommonBindingMoreType next = it2.next();
            boolean z = next instanceof ControlGestureViewModel;
            if (z) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) next;
                    String str = controlGestureViewModel.getGestureName().get();
                    ControlConfigurationEntity.Operation options4 = controlGestureViewModel.getOptions();
                    Integer numValueOf = options4 != null ? Integer.valueOf(options4.getGesture()) : null;
                    ControlConfigurationEntity.Operation options5 = controlGestureViewModel.getOptions();
                    Integer numValueOf2 = options5 != null ? Integer.valueOf(options5.getButton()) : null;
                    ControlConfigurationEntity.Operation options6 = controlGestureViewModel.getOptions();
                    Integer numValueOf3 = options6 != null ? Integer.valueOf(options6.getOperation()) : null;
                    ControlGestureViewModel controlGestureViewModel2 = viewModel.getSelectedItemViewModel().get();
                    Integer numValueOf4 = (controlGestureViewModel2 == null || (options3 = controlGestureViewModel2.getOptions()) == null) ? null : Integer.valueOf(options3.getOperation());
                    ControlGestureViewModel controlGestureViewModel3 = viewModel.getSelectedItemViewModel().get();
                    Integer numValueOf5 = (controlGestureViewModel3 == null || (options2 = controlGestureViewModel3.getOptions()) == null) ? null : Integer.valueOf(options2.getButton());
                    ControlGestureViewModel controlGestureViewModel4 = viewModel.getSelectedItemViewModel().get();
                    it = it2;
                    String str2 = "control_gestureViewModel Operation gestureName:" + ((Object) str) + ",button:" + numValueOf + "," + numValueOf2 + "," + numValueOf3 + ", select button:" + numValueOf4 + "," + numValueOf5 + "," + ((controlGestureViewModel4 == null || (options = controlGestureViewModel4.getOptions()) == null) ? null : Integer.valueOf(options.getGesture()));
                    String str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str4 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                        commonBindingMoreType = next;
                        FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                        }
                    }
                } else {
                    it = it2;
                }
                commonBindingMoreType = next;
            } else {
                it = it2;
                commonBindingMoreType = next;
            }
            if (z) {
                ControlConfigurationEntity.Operation operation = this.selectedOperation;
                Integer numValueOf6 = operation != null ? Integer.valueOf(operation.getGesture()) : null;
                ControlGestureViewModel controlGestureViewModel5 = (ControlGestureViewModel) commonBindingMoreType;
                ControlConfigurationEntity.Operation options7 = controlGestureViewModel5.getOptions();
                if (Intrinsics.areEqual(numValueOf6, options7 != null ? Integer.valueOf(options7.getGesture()) : null)) {
                    ControlConfigurationEntity.Operation operation2 = this.selectedOperation;
                    Integer numValueOf7 = operation2 != null ? Integer.valueOf(operation2.getButton()) : null;
                    ControlConfigurationEntity.Operation options8 = controlGestureViewModel5.getOptions();
                    if (Intrinsics.areEqual(numValueOf7, options8 != null ? Integer.valueOf(options8.getButton()) : null)) {
                        ActionView actionView = getActionBarBinding().headerBar;
                        String str5 = controlGestureViewModel5.getGestureName().get();
                        if (str5 == null) {
                            str5 = "";
                        }
                        actionView.setTitle2(str5);
                        Logger logger2 = Logger.INSTANCE;
                        String tag2 = logger2.getTAG();
                        int depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true) && "control_gestureViewModel Operation onClickChangeData".length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str6 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                            FileLog.print$default(fileLog2, 3, str6, tag2, "control_gestureViewModel Operation onClickChangeData " + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, "control_gestureViewModel Operation onClickChangeData " + strComponent4);
                            }
                        }
                        onClickChangeData(controlGestureViewModel5);
                    }
                }
            }
            it2 = it;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onClickChangeData(ControlGestureViewModel itemViewModel) {
        Iterator<ControlOperationViewModel> it = itemViewModel.getOperationList().iterator();
        while (it.hasNext()) {
            it.next().setSelectChatGpt(VoiceAssistantUtil.INSTANCE.isSelectChatGpt());
        }
        ((ElekidControlOperationActivityBinding) getMBinding()).rvOperation.setAdapter(new CommonBindingAdapter.Builder().setLayoutId(R.layout.elekid_control_dialog_item).setEventHandler((Object) this).addVariable(BR.itemViewModel, (Object) itemViewModel).setDataList((ObservableArrayList) itemViewModel.getOperationList()).build());
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setSelectedItem(itemViewModel);
    }

    public final void onSelectedOperation(ControlOperationViewModel dialogItemViewModel, ControlItemViewModel itemViewModel) {
        ControlViewModel controlViewModel;
        ControlConfigurationEntity.Operation options;
        ControlConfigurationEntity.Operation options2;
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        if (Intrinsics.areEqual((Object) dialogItemViewModel.isMagicGesture().get(), (Object) true)) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "magic inito".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "magic inito " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "magic inito " + strComponent2);
                }
            }
            if (MediaUtils.INSTANCE.isNotifyEnable(this)) {
                gotoMagicButton();
                return;
            } else {
                showNotificationDialog();
                return;
            }
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            ControlViewModel controlViewModel2 = this.viewModel;
            if (controlViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel2 = null;
            }
            ControlGestureViewModel controlGestureViewModel = controlViewModel2.getSelectedItemViewModel().get();
            String str2 = "magic last:" + ((controlGestureViewModel == null || (options2 = controlGestureViewModel.getOptions()) == null) ? null : Integer.valueOf(options2.getOperation())) + ",current:" + dialogItemViewModel.getOperation();
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        if (dialogItemViewModel.getOperation() == 32) {
            ControlViewModel controlViewModel3 = this.viewModel;
            if (controlViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel3 = null;
            }
            ControlGestureViewModel controlGestureViewModel2 = controlViewModel3.getSelectedItemViewModel().get();
            if ((controlGestureViewModel2 == null || (options = controlGestureViewModel2.getOptions()) == null || options.getOperation() != 32) && NothingOSUtil.INSTANCE.isNothingOS() && !SpUtils.INSTANCE.getTapNothingRadioDialog()) {
                SpUtils.INSTANCE.setTapNothingRadioDialog(true);
                MagicDialog magicDialog = this.magicDialog;
                if (magicDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("magicDialog");
                    magicDialog = null;
                }
                magicDialog.show(this, new Function0() { // from class: com.nothing.elekid.control.ControlOperationActivity$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ControlOperationActivity.onSelectedOperation$lambda$7(this.f$0);
                    }
                });
            }
        }
        ControlViewModel controlViewModel4 = this.viewModel;
        if (controlViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        } else {
            controlViewModel = controlViewModel4;
        }
        controlViewModel.setGestureData(itemViewModel, dialogItemViewModel);
        this.changeOperation = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelectedOperation$lambda$7(ControlOperationActivity controlOperationActivity) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "magic inito".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "magic inito " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "magic inito " + strComponent2);
            }
        }
        if (MediaUtils.INSTANCE.isNotifyEnable(controlOperationActivity)) {
            controlOperationActivity.gotoMagicButton();
        } else {
            controlOperationActivity.showNotificationDialog();
        }
        return Unit.INSTANCE;
    }

    private final void gotoMagicButton() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(FlutterRouterManager.ROUTE_REPLACE, true);
        bundle.putBoolean(FlutterRouterManager.SELECT_DEVICE, false);
        bundle.putInt("routeIndex", FlutterRoute.DEVICE_EAR_MAGICBUTTONMAIN.getRaw());
        bundle.putString("GOTO_HOME_DEVICE_ADDRESS", SpUtils.INSTANCE.getSelectDeviceMac());
        ControlActivityManager.INSTANCE.finish();
        if (!ActivityManager.INSTANCE.hasOsMainActivity()) {
            FlutterRouterManager.toFlutterHomePage$default(new FlutterRouterManager(), this, bundle, false, true, null, false, 48, null);
        } else {
            FlutterRouterManager.toFlutterHomePage$default(new FlutterRouterManager(), this, bundle, false, true, FlutterRouterManager.GOTO_OS_HOME_ACTION, false, 32, null);
        }
    }

    private final void showNotificationDialog() {
        RadioServiceTermDialog.Builder builder = new RadioServiceTermDialog.Builder();
        String string = getString(R.string.ear_magic_button_permission_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        RadioServiceTermDialog.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.ear_magic_button_permission_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        RadioServiceTermDialog.Builder message = title.setMessage(string2);
        String string3 = getString(R.string.user_continue);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        RadioServiceTermDialog.Builder positiveButtonText = message.setPositiveButtonText(string3);
        String string4 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        positiveButtonText.setNegativeButtonText(string4).setPositiveAction(new Function0() { // from class: com.nothing.elekid.control.ControlOperationActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ControlOperationActivity.showNotificationDialog$lambda$8(this.f$0);
            }
        }).setNegativeAction(new Function0() { // from class: com.nothing.elekid.control.ControlOperationActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ControlOperationActivity.showNotificationDialog$lambda$9(this.f$0);
            }
        }).build().show(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNotificationDialog$lambda$8(ControlOperationActivity controlOperationActivity) {
        controlOperationActivity.requestNotification = true;
        controlOperationActivity.startNotificationSetting();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNotificationDialog$lambda$9(ControlOperationActivity controlOperationActivity) {
        controlOperationActivity.requestNotification = false;
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.requestNotification && MediaUtils.INSTANCE.isNotifyEnable(this)) {
            this.requestNotification = false;
            gotoMagicButton();
        }
    }

    private final void startNotificationSetting() {
        Intent intent = new Intent(ForegroundNoticePermission.ACTION_NOTIFICATION_LISTENER_SETTINGS);
        intent.setFlags(268435456);
        startActivity(intent);
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true) && "AppCommonApi startNotificationSetting".length() != 0) {
            Pair<String, String> trace = logger3.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger3.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "AppCommonApi startNotificationSetting " + strComponent2, null, 16, null);
            if (logger3.isDebug()) {
                Log.i(tag + strComponent1, "AppCommonApi startNotificationSetting " + strComponent2);
            }
        }
    }

    private final void setDefaultScaleSelected() {
        Bundle extras = getIntent().getExtras();
        this.isSelectLeft = extras != null ? extras.getBoolean("IS_LEFT_SELECTED") : true;
        ControlViewModel controlViewModel = this.viewModel;
        ControlViewModel controlViewModel2 = null;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.getDataUpdate().observe(this, new ControlOperationActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.control.ControlOperationActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlOperationActivity.setDefaultScaleSelected$lambda$11(this.f$0, (Pair) obj);
            }
        }));
        ControlViewModel controlViewModel3 = this.viewModel;
        if (controlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel3 = null;
        }
        controlViewModel3.getLeftTextVisible().set(false);
        ControlViewModel controlViewModel4 = this.viewModel;
        if (controlViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel4;
        }
        controlViewModel2.getRightTextVisible().set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDefaultScaleSelected$lambda$11(ControlOperationActivity controlOperationActivity, Pair pair) {
        if (pair != null && ((Number) pair.getFirst()).intValue() == 1) {
            ControlViewModel controlViewModel = null;
            if (controlOperationActivity.isSelectLeft) {
                ControlViewModel controlViewModel2 = controlOperationActivity.viewModel;
                if (controlViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    controlViewModel = controlViewModel2;
                }
                controlOperationActivity.refreshGestureData(controlViewModel, true);
            } else {
                ControlViewModel controlViewModel3 = controlOperationActivity.viewModel;
                if (controlViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    controlViewModel = controlViewModel3;
                }
                controlOperationActivity.refreshGestureData(controlViewModel, false);
            }
        }
        return Unit.INSTANCE;
    }

    public final void onClickTransparency(ControlOperationViewModel dialogItemViewModel, ControlItemViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int transparency = dialogItemViewModel.toTransparency();
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setAncGestureData(itemViewModel, transparency, dialogItemViewModel);
        this.changeOperation = true;
    }

    public final void onClickNoiseCancellation(ControlOperationViewModel dialogItemViewModel, ControlItemViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int noiseCancellation = dialogItemViewModel.toNoiseCancellation();
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setAncGestureData(itemViewModel, noiseCancellation, dialogItemViewModel);
        this.changeOperation = true;
    }

    public final void onClickOff(ControlOperationViewModel dialogItemViewModel, ControlItemViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int off = dialogItemViewModel.toOff();
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setAncGestureData(itemViewModel, off, dialogItemViewModel);
        this.changeOperation = true;
    }

    @Override // com.nothing.earbase.control.BaseControlOperationActivity, com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ControlActivityManager.INSTANCE.removeActivity(this);
    }
}
