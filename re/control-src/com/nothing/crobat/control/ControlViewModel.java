package com.nothing.crobat.control;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.util.ext.ViewModelExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.crobat.core.protocol.CrobatSppProtocol;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.ear.R;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.os.control.TitleViewModel;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.cli.HelpFormatter;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0016\u0010\u001d\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0016\u0010!\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J \u0010'\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010*\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u001e\u0010,\u001a\u00020\u00192\u0006\u0010#\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J.\u0010/\u001a\u00020\u00192\u0006\u0010#\u001a\u00020-2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\u000eH\u0082@\u00a2\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0019H\u0016J \u00102\u001a\u00020\u00192\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020)04j\b\u0012\u0004\u0012\u00020)`5H\u0002J \u00106\u001a\u00020\u00192\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020)04j\b\u0012\u0004\u0012\u00020)`5H\u0002J\u0010\u00107\u001a\u00020\u00192\u0006\u0010(\u001a\u00020$H\u0002J\u0014\u00108\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010)H\u0002J\u0014\u00109\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010)H\u0002J\u0014\u0010:\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010)H\u0002J\u0014\u0010;\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006="}, d2 = {"Lcom/nothing/crobat/control/ControlViewModel;", "Lcom/nothing/earbase/control/BaseControlViewModel;", "context", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "protocol", "Lcom/nothing/crobat/core/protocol/CrobatSppProtocol;", "getProtocol", "()Lcom/nothing/crobat/core/protocol/CrobatSppProtocol;", "setProtocol", "(Lcom/nothing/crobat/core/protocol/CrobatSppProtocol;)V", "controlRes", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getControlRes", "()Landroidx/databinding/ObservableField;", "enterWithAnimation", "", "getEnterWithAnimation", "()Z", "setEnterWithAnimation", "(Z)V", "register", "", "extras", "Landroid/os/Bundle;", "listenerLiveData", "addInnerButton", "rightTemp", "Landroidx/databinding/ObservableArrayList;", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "addSmartDial", "setGestureData", "viewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "synData", "it", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "setVisibleOrGoneNoiseSubItems", "isLeft", "setAncGestureData", "Lcom/nothing/crobat/control/ControlItemViewModel;", "operation", "syncGestureData", "(Lcom/nothing/crobat/control/ControlItemViewModel;Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Lcom/nothing/earbase/control/ControlOperationViewModel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetGestureData", "resetGestureRightData", "operations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "resetGestureLeftData", "resetGestureOperation", "addSinglePress", "addButtonDoublePress", "addHoldPress", "addRotateAction", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlViewModel extends BaseControlViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_GESTURES = {2, 3, 7};
    private final Application context;
    private final ObservableField<Integer> controlRes;
    private boolean enterWithAnimation;
    private CrobatSppProtocol protocol;

    /* JADX INFO: renamed from: com.nothing.crobat.control.ControlViewModel$syncGestureData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.crobat.control.ControlViewModel", f = "ControlViewModel.kt", i = {0, 0, 0, 0, 0, 0}, l = {282}, m = "syncGestureData", n = {"this", "it", "dialogItemViewModel", "gesture", "option", "operation"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0"})
    static final class C04641 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C04641(Continuation<? super C04641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ControlViewModel.this.syncGestureData(null, null, null, 0, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ControlViewModel(Application context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.protocol = new CrobatSppProtocol(null, 1, null == true ? 1 : 0);
        this.controlRes = new ObservableField<>(0);
        this.enterWithAnimation = true;
    }

    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/crobat/control/ControlViewModel$Companion;", "", "<init>", "()V", "SUPPORT_GESTURES", "", "getSUPPORT_GESTURES", "()[I", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int[] getSUPPORT_GESTURES() {
            return ControlViewModel.SUPPORT_GESTURES;
        }
    }

    public final CrobatSppProtocol getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(CrobatSppProtocol crobatSppProtocol) {
        Intrinsics.checkNotNullParameter(crobatSppProtocol, "<set-?>");
        this.protocol = crobatSppProtocol;
    }

    public final ObservableField<Integer> getControlRes() {
        return this.controlRes;
    }

    public final boolean getEnterWithAnimation() {
        return this.enterWithAnimation;
    }

    public final void setEnterWithAnimation(boolean z) {
        this.enterWithAnimation = z;
    }

    @Override // com.nothing.earbase.control.BaseControlViewModel
    public void register(Bundle extras) {
        super.register(extras);
        this.protocol = new CrobatSppProtocol(getAddress());
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(getAddress());
        if (iOTDeviceByMacAddress != null) {
            this.controlRes.set(Integer.valueOf(iOTDeviceByMacAddress.getRightImage()));
        }
        listenerLiveData();
        getGestureData(false);
    }

    private final void listenerLiveData() {
        final TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
        LiveData liveDataDistinctUntilChanged;
        TWSDevice tWSDevice = this.protocol.getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(tWSDevice)) == null) {
            return;
        }
        final Class<ControlConfigurationEntity> cls = ControlConfigurationEntity.class;
        LiveData map = Transformations.map(tWSDeviceBuilderKeyConfiguration.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderKeyConfiguration.getGetCommand(), tWSDeviceBuilderKeyConfiguration.getNotifyCommand()), new Function1<Message, ControlConfigurationEntity>() { // from class: com.nothing.crobat.control.ControlViewModel$listenerLiveData$$inlined$getLiveData$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final ControlConfigurationEntity invoke(Message message) {
                byte[] payload;
                Object obj;
                ControlConfigurationEntity controlConfigurationEntity = 0;
                Object obj2 = null;
                objNewInstance = null;
                Object objNewInstance = null;
                controlConfigurationEntity = 0;
                if (message != null && (payload = message.getPayload()) != null) {
                    Class cls2 = cls;
                    try {
                        if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                            obj = (ControlConfigurationEntity) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                        } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                            obj = (ControlConfigurationEntity) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                        } else if (Intrinsics.areEqual(cls2, String.class)) {
                            Object objDecodeToString = StringsKt.decodeToString(payload);
                            if (objDecodeToString == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.control.entity.ControlConfigurationEntity");
                            }
                            obj = (ControlConfigurationEntity) objDecodeToString;
                        } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                            obj = (ControlConfigurationEntity) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                        } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                            obj = (ControlConfigurationEntity) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                        } else {
                            try {
                                objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                obj2 = objNewInstance;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            obj = obj2;
                        }
                        controlConfigurationEntity = obj;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        controlConfigurationEntity = objNewInstance;
                    }
                }
                Logger logger = Logger.INSTANCE;
                Class cls3 = cls;
                Logger logger2 = logger;
                String tag = logger2.getTAG();
                int depth = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str = "parseLiveData " + cls3 + StringUtils.SPACE + controlConfigurationEntity + StringUtils.SPACE;
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger2.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                return controlConfigurationEntity;
            }
        });
        if (map == null || (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(map)) == null) {
            return;
        }
        liveDataDistinctUntilChanged.observe(this, new ControlViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.crobat.control.ControlViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlViewModel.listenerLiveData$lambda$12(this.f$0, (ControlConfigurationEntity) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0029  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    public static final kotlin.Unit listenerLiveData$lambda$12(com.nothing.crobat.control.ControlViewModel r27, com.nothing.earbase.control.entity.ControlConfigurationEntity r28) {
        /*
            Method dump skipped, instruction units count: 775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.crobat.control.ControlViewModel.listenerLiveData$lambda$12(com.nothing.crobat.control.ControlViewModel, com.nothing.earbase.control.entity.ControlConfigurationEntity):kotlin.Unit");
    }

    private final void addInnerButton(ObservableArrayList<CommonBindingMoreType> rightTemp) {
        if (getIsSystem()) {
            TitleViewModel titleViewModel = new TitleViewModel();
            titleViewModel.getTitleName().set(ViewModelExtKt.getString(this, R.string.inner_button));
            rightTemp.add(titleViewModel);
        }
    }

    private final void addSmartDial(ObservableArrayList<CommonBindingMoreType> rightTemp) {
        if (getIsSystem()) {
            TitleViewModel titleViewModel = new TitleViewModel();
            titleViewModel.getTitleName().set(ViewModelExtKt.getString(this, R.string.knob));
            rightTemp.add(titleViewModel);
        }
    }

    @Override // com.nothing.earbase.control.BaseControlViewModel
    public void setGestureData(ControlGestureViewModel viewModel, ControlOperationViewModel dialogItemViewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        ControlConfigurationEntity.Operation options = viewModel.getOptions();
        if (options != null) {
            AppBuriedPointUtils.INSTANCE.controlData(options.getDevice(), options.getButton(), options.getGesture(), dialogItemViewModel.getOperation(), getIsSystem());
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ControlViewModel$setGestureData$1$1(this, dialogItemViewModel, options, viewModel, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0044  */
    public final void synData(ControlOperationViewModel dialogItemViewModel, ControlConfigurationEntity.Operation it, ControlGestureViewModel viewModel) {
        boolean z;
        boolean z2;
        ControlGestureViewModel controlGestureViewModel;
        ControlConfigurationEntity.Operation options;
        ControlConfigurationEntity.Operation options2;
        boolean zIsNoiseOperation = dialogItemViewModel.isNoiseOperation(it.getOperation());
        boolean zIsNoiseOperation2 = dialogItemViewModel.isNoiseOperation(dialogItemViewModel.getOperation());
        ObservableArrayList<CommonBindingMoreType> rightGestureData = Intrinsics.areEqual((Object) viewModel.isLeft().get(), (Object) true) ? getRightGestureData() : getLeftGestureData();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "setGestureData --> source=" + zIsNoiseOperation + " target=" + zIsNoiseOperation2;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z2 = zIsNoiseOperation;
                z = zIsNoiseOperation2;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                z = zIsNoiseOperation2;
                z2 = zIsNoiseOperation;
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            z2 = zIsNoiseOperation;
            z = zIsNoiseOperation2;
        }
        if (!z || z2) {
            return;
        }
        for (CommonBindingMoreType commonBindingMoreType : rightGestureData) {
            if ((commonBindingMoreType instanceof ControlGestureViewModel) && (options = (controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType).getOptions()) != null && it.getGesture() == options.getGesture() && (options2 = controlGestureViewModel.getOptions()) != null && dialogItemViewModel.isNoiseOperation(options2.getOperation())) {
                dialogItemViewModel.setOperation(options2.getOperation());
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "setGestureData --> normal to  noise " + ((Object) controlGestureViewModel.getGestureName().get()) + HelpFormatter.DEFAULT_LONG_OPT_PREFIX + ((Object) controlGestureViewModel.getOperationName().get()) + StringUtils.SPACE;
                    String str5 = str4;
                    if (str5 != null && str5.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str6 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                        FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVisibleOrGoneNoiseSubItems(ControlOperationViewModel dialogItemViewModel, boolean isLeft) {
        if (dialogItemViewModel.getOperation() == 10 || dialogItemViewModel.getOperation() == 20 || dialogItemViewModel.getOperation() == 22 || dialogItemViewModel.getOperation() == 21) {
            dialogItemViewModel.getNoiseControlVisible().set(true);
            return;
        }
        ObservableArrayList<CommonBindingMoreType> leftGestureData = getLeftGestureData();
        if (!isLeft) {
            leftGestureData = getRightGestureData();
        }
        for (CommonBindingMoreType commonBindingMoreType : leftGestureData) {
            if (commonBindingMoreType instanceof ControlItemViewModel) {
                for (ControlOperationViewModel controlOperationViewModel : ((ControlItemViewModel) commonBindingMoreType).getOperationList()) {
                    if (controlOperationViewModel.getOperation() == 10 || controlOperationViewModel.getOperation() == 20 || controlOperationViewModel.getOperation() == 22 || controlOperationViewModel.getOperation() == 21) {
                        controlOperationViewModel.getNoiseControlVisible().set(false);
                    }
                }
            }
        }
    }

    public final void setAncGestureData(ControlItemViewModel viewModel, int operation, ControlOperationViewModel dialogItemViewModel) {
        ControlConfigurationEntity.Operation options;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        if (operation == 0 || (options = viewModel.getOptions()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ControlViewModel$setAncGestureData$1$1(this, options, operation, viewModel, dialogItemViewModel, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0087  */
    /* JADX WARN: Code duplicated, block: B:23:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:56:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x019f -> B:46:0x01a9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01e8 -> B:57:0x01e9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object syncGestureData(com.nothing.crobat.control.ControlItemViewModel r24, com.nothing.earbase.control.entity.ControlConfigurationEntity.Operation r25, com.nothing.earbase.control.ControlOperationViewModel r26, int r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.crobat.control.ControlViewModel.syncGestureData(com.nothing.crobat.control.ControlItemViewModel, com.nothing.earbase.control.entity.ControlConfigurationEntity$Operation, com.nothing.earbase.control.ControlOperationViewModel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.nothing.earbase.control.BaseControlViewModel
    public void resetGestureData() {
        ArrayList<ControlConfigurationEntity.Operation> arrayList = new ArrayList<>();
        resetGestureLeftData(arrayList);
        resetGestureRightData(arrayList);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(arrayList, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.crobat.control.ControlViewModel$resetGestureData$1, reason: invalid class name */
    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.crobat.control.ControlViewModel$resetGestureData$1", f = "ControlViewModel.kt", i = {}, l = {306, 307}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<ControlConfigurationEntity.Operation> $operations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArrayList<ControlConfigurationEntity.Operation> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$operations = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ControlViewModel.this.new AnonymousClass1(this.$operations, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.crobat.control.ControlViewModel.AnonymousClass1.C01151(r7, r6.this$0, null), r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ControlViewModel.this.getProtocol().resetGestureData(this.$operations, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.crobat.control.ControlViewModel$resetGestureData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ControlViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.crobat.control.ControlViewModel$resetGestureData$1$1", f = "ControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $result;
            int label;
            final /* synthetic */ ControlViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01151(boolean z, ControlViewModel controlViewModel, Continuation<? super C01151> continuation) {
                super(2, continuation);
                this.$result = z;
                this.this$0 = controlViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01151(this.$result, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.$result) {
                    ObservableArrayList<CommonBindingMoreType> leftGestureData = this.this$0.getLeftGestureData();
                    ControlViewModel controlViewModel = this.this$0;
                    for (CommonBindingMoreType commonBindingMoreType : leftGestureData) {
                        if (commonBindingMoreType instanceof ControlGestureViewModel) {
                            controlViewModel.resetGestureOperation((ControlGestureViewModel) commonBindingMoreType);
                        }
                    }
                    ObservableArrayList<CommonBindingMoreType> rightGestureData = this.this$0.getRightGestureData();
                    ControlViewModel controlViewModel2 = this.this$0;
                    for (CommonBindingMoreType commonBindingMoreType2 : rightGestureData) {
                        if (commonBindingMoreType2 instanceof ControlGestureViewModel) {
                            controlViewModel2.resetGestureOperation((ControlGestureViewModel) commonBindingMoreType2);
                        }
                    }
                    this.this$0.getDataUpdate().postValue(new Pair<>(Boxing.boxInt(4), Boxing.boxBoolean(false)));
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void resetGestureRightData(ArrayList<ControlConfigurationEntity.Operation> operations) {
        ControlGestureViewModel controlGestureViewModel;
        ControlConfigurationEntity.Operation options;
        Integer num;
        for (CommonBindingMoreType commonBindingMoreType : getRightGestureData()) {
            if ((commonBindingMoreType instanceof ControlGestureViewModel) && (options = (controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType).getOptions()) != null && (num = controlGestureViewModel.getArrowVisible().get()) != null && num.intValue() == 0) {
                ControlConfigurationEntity.Operation operationCopy$default = ControlConfigurationEntity.Operation.copy$default(options, 0, 0, 0, 0, 15, null);
                operationCopy$default.setOperation(controlGestureViewModel.getDefaultOperation());
                operations.add(operationCopy$default);
            }
        }
    }

    private final void resetGestureLeftData(ArrayList<ControlConfigurationEntity.Operation> operations) {
        ControlGestureViewModel controlGestureViewModel;
        ControlConfigurationEntity.Operation options;
        Integer num;
        for (CommonBindingMoreType commonBindingMoreType : getLeftGestureData()) {
            if ((commonBindingMoreType instanceof ControlGestureViewModel) && (options = (controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType).getOptions()) != null && (num = controlGestureViewModel.getArrowVisible().get()) != null && num.intValue() == 0) {
                ControlConfigurationEntity.Operation operationCopy$default = ControlConfigurationEntity.Operation.copy$default(options, 0, 0, 0, 0, 15, null);
                operationCopy$default.setOperation(controlGestureViewModel.getDefaultOperation());
                operations.add(operationCopy$default);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetGestureOperation(ControlGestureViewModel it) {
        Integer num = it.getArrowVisible().get();
        if (num != null && num.intValue() == 0) {
            ControlConfigurationEntity.Operation options = it.getOptions();
            if (options != null) {
                options.setOperation(it.getDefaultOperation());
            }
            ControlConfigurationEntity.Operation options2 = it.getOptions();
            Integer numValueOf = options2 != null ? Integer.valueOf(options2.getGesture()) : null;
            if (numValueOf == null || numValueOf.intValue() != 7) {
                if ((numValueOf != null && numValueOf.intValue() == 8) || (numValueOf != null && numValueOf.intValue() == 9)) {
                    for (ControlOperationViewModel controlOperationViewModel : it.getOperationList()) {
                        controlOperationViewModel.selectedOperation(it.getDefaultOperation() == controlOperationViewModel.getOperation());
                        controlOperationViewModel.getNoiseControlVisible().set(false);
                    }
                } else {
                    for (ControlOperationViewModel controlOperationViewModel2 : it.getOperationList()) {
                        controlOperationViewModel2.selectedOperation(it.getDefaultOperation() == controlOperationViewModel2.getOperation());
                    }
                }
            } else {
                for (ControlOperationViewModel controlOperationViewModel3 : it.getOperationList()) {
                    controlOperationViewModel3.selectedOperation(it.getDefaultOperation() == controlOperationViewModel3.getOperation());
                    if (controlOperationViewModel3.getOperation() == 10 || controlOperationViewModel3.getOperation() == 20 || controlOperationViewModel3.getOperation() == 22 || controlOperationViewModel3.getOperation() == 21) {
                        controlOperationViewModel3.selectedOperation(controlOperationViewModel3.convertAnc(it.getDefaultOperation(), true));
                    } else {
                        controlOperationViewModel3.selectedOperation(it.getDefaultOperation() == controlOperationViewModel3.getOperation());
                        controlOperationViewModel3.getNoiseControlVisible().set(false);
                    }
                }
            }
            it.updateOperationText(it.getDefaultOperation(), this.context);
        }
    }

    private final ControlItemViewModel addSinglePress(ControlConfigurationEntity.Operation operation) {
        if (operation != null) {
            return new ControlItemViewModel(new ControlConfigurationEntity.Operation(operation.getDevice(), operation.getButton(), 1, 2), this.context, getAddress());
        }
        return null;
    }

    private final ControlItemViewModel addButtonDoublePress(ControlConfigurationEntity.Operation operation) {
        if (operation == null) {
            return null;
        }
        ControlItemViewModel controlItemViewModel = new ControlItemViewModel(new ControlConfigurationEntity.Operation(operation.getDevice(), operation.getButton(), 13, 39), this.context, getAddress());
        controlItemViewModel.getArrowVisible().set(8);
        return controlItemViewModel;
    }

    private final ControlItemViewModel addHoldPress(ControlConfigurationEntity.Operation operation) {
        if (operation == null) {
            return null;
        }
        ControlItemViewModel controlItemViewModel = new ControlItemViewModel(new ControlConfigurationEntity.Operation(operation.getDevice(), operation.getButton(), 14, 24), this.context, getAddress());
        controlItemViewModel.getArrowVisible().set(8);
        return controlItemViewModel;
    }

    private final ControlItemViewModel addRotateAction(ControlConfigurationEntity.Operation operation) {
        if (operation != null) {
            return new ControlItemViewModel(new ControlConfigurationEntity.Operation(operation.getDevice(), operation.getButton(), 10, 255), this.context, getAddress());
        }
        return null;
    }
}
