package com.nothing.ear.one.control;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.ear.R;
import com.nothing.ear.one.core.protocol.EarOneSppProtocol;
import com.nothing.ear.one.core.protocol.device.EarOneManager;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlNotCustomisableViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlBottomEntity;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.control.entity.ControlRadius;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0015J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J \u0010$\u001a\u00020\u00172\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(H\u0002J \u0010)\u001a\u00020\u00172\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(H\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010'H\u0002J\u0014\u0010-\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/nothing/ear/one/control/ControlViewModel;", "Lcom/nothing/earbase/control/BaseControlViewModel;", "context", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "protocol", "Lcom/nothing/ear/one/core/protocol/EarOneSppProtocol;", "getProtocol", "()Lcom/nothing/ear/one/core/protocol/EarOneSppProtocol;", "setProtocol", "(Lcom/nothing/ear/one/core/protocol/EarOneSppProtocol;)V", "eggLightValue", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getEggLightValue", "()Landroidx/lifecycle/MutableLiveData;", "eggChangeLiveData", "getEggChangeLiveData", "saveEggValue", "", "register", "", "extras", "Landroid/os/Bundle;", "listenerLiveData", "getSelectedEarDrawable", "clickEarImage", "clickValue", "setGestureData", "viewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "resetGestureData", "resetRightGestureData", "operations", "Ljava/util/ArrayList;", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "Lkotlin/collections/ArrayList;", "resetLeftGestureData", "addDoubleTap", "Lcom/nothing/ear/one/control/ControlItemViewModel;", "operation", "addSlideOnSystem", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ControlViewModel extends BaseControlViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_GESTURES = {3, 7};
    private final Application context;
    private final MutableLiveData<Boolean> eggChangeLiveData;
    private final MutableLiveData<Boolean> eggLightValue;
    private EarOneSppProtocol protocol;
    private String saveEggValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ControlViewModel(Application context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.protocol = new EarOneSppProtocol(null, 1, null == true ? 1 : 0);
        this.eggLightValue = new MutableLiveData<>(false);
        this.eggChangeLiveData = new MutableLiveData<>(false);
        this.saveEggValue = "";
    }

    public final EarOneSppProtocol getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(EarOneSppProtocol earOneSppProtocol) {
        Intrinsics.checkNotNullParameter(earOneSppProtocol, "<set-?>");
        this.protocol = earOneSppProtocol;
    }

    public final MutableLiveData<Boolean> getEggLightValue() {
        return this.eggLightValue;
    }

    public final MutableLiveData<Boolean> getEggChangeLiveData() {
        return this.eggChangeLiveData;
    }

    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/ear/one/control/ControlViewModel$Companion;", "", "<init>", "()V", "SUPPORT_GESTURES", "", "getSUPPORT_GESTURES", "()[I", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Override // com.nothing.earbase.control.BaseControlViewModel
    public void register(Bundle extras) {
        super.register(extras);
        this.protocol = new EarOneSppProtocol(extras != null ? extras.getString("device_address") : null);
        listenerLiveData();
        getGestureData(false);
        getSelectedEarDrawable();
    }

    private final void listenerLiveData() {
        final TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
        LiveData liveDataDistinctUntilChanged;
        TWSDevice tWSDevice = this.protocol.getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(tWSDevice)) == null) {
            return;
        }
        final Class<ControlConfigurationEntity> cls = ControlConfigurationEntity.class;
        LiveData map = Transformations.map(tWSDeviceBuilderKeyConfiguration.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderKeyConfiguration.getGetCommand(), tWSDeviceBuilderKeyConfiguration.getNotifyCommand()), new Function1<Message, ControlConfigurationEntity>() { // from class: com.nothing.ear.one.control.ControlViewModel$listenerLiveData$$inlined$getLiveData$1
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
        liveDataDistinctUntilChanged.observe(this, new ControlViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.ear.one.control.ControlViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlViewModel.listenerLiveData$lambda$9(this.f$0, (ControlConfigurationEntity) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit listenerLiveData$lambda$9(ControlViewModel controlViewModel, ControlConfigurationEntity controlConfigurationEntity) {
        if (controlConfigurationEntity == null) {
            return Unit.INSTANCE;
        }
        ObservableArrayList<CommonBindingMoreType> observableArrayList = new ObservableArrayList<>();
        ObservableArrayList<CommonBindingMoreType> observableArrayList2 = new ObservableArrayList<>();
        ControlConfigurationEntity.Operation operation = null;
        ControlConfigurationEntity.Operation operation2 = null;
        for (ControlConfigurationEntity.Operation operation3 : controlConfigurationEntity.getOperations()) {
            if (ArraysKt.contains(SUPPORT_GESTURES, operation3.getGesture())) {
                ControlItemViewModel controlItemViewModel = new ControlItemViewModel(operation3, controlViewModel.context, controlViewModel.getAddress());
                if (Intrinsics.areEqual((Object) controlItemViewModel.isLeft().get(), (Object) true)) {
                    observableArrayList.add(controlItemViewModel);
                    operation = operation3;
                } else {
                    observableArrayList2.add(controlItemViewModel);
                    operation2 = operation3;
                }
            }
        }
        if (!observableArrayList.isEmpty()) {
            controlViewModel.setControlRadius(observableArrayList);
            if (controlViewModel.getIsSystem()) {
                ArrayList arrayList = new ArrayList();
                ControlItemViewModel controlItemViewModelAddDoubleTap = controlViewModel.addDoubleTap(operation);
                if (controlItemViewModelAddDoubleTap != null) {
                    arrayList.add(controlItemViewModelAddDoubleTap);
                }
                ControlItemViewModel controlItemViewModelAddSlideOnSystem = controlViewModel.addSlideOnSystem(operation);
                if (controlItemViewModelAddSlideOnSystem != null) {
                    arrayList.add(controlItemViewModelAddSlideOnSystem);
                }
                observableArrayList.add(new ControlNotCustomisableViewModel(arrayList, controlViewModel.context, null, null, null, 28, null));
                controlViewModel.setLeftGestureData(observableArrayList);
            } else {
                controlViewModel.setLeftGestureData(observableArrayList);
                ControlNotCustomisableViewModel controlNotCustomisableViewModel = new ControlNotCustomisableViewModel(null, controlViewModel.context, null, null, null, 28, null);
                controlNotCustomisableViewModel.getTitle().set(controlViewModel.context.getString(R.string.gesture_not_customisation));
                controlViewModel.getLeftGestureData().add(controlNotCustomisableViewModel);
                ControlItemViewModel controlItemViewModelAddDoubleTap2 = controlViewModel.addDoubleTap(operation);
                if (controlItemViewModelAddDoubleTap2 != null) {
                    controlItemViewModelAddDoubleTap2.setDirection(ControlRadius.HEAD);
                    controlViewModel.getLeftGestureData().add(controlItemViewModelAddDoubleTap2);
                }
                ControlItemViewModel controlItemViewModelAddSlideOnSystem2 = controlViewModel.addSlideOnSystem(operation);
                if (controlItemViewModelAddSlideOnSystem2 != null) {
                    controlItemViewModelAddSlideOnSystem2.setDirection(ControlRadius.END);
                    controlViewModel.getLeftGestureData().add(controlItemViewModelAddSlideOnSystem2);
                }
                controlViewModel.getLeftGestureData().add(new ControlBottomEntity());
            }
        }
        if (!observableArrayList2.isEmpty()) {
            controlViewModel.setControlRadius(observableArrayList2);
            if (controlViewModel.getIsSystem()) {
                ArrayList arrayList2 = new ArrayList();
                ControlItemViewModel controlItemViewModelAddDoubleTap3 = controlViewModel.addDoubleTap(operation2);
                if (controlItemViewModelAddDoubleTap3 != null) {
                    arrayList2.add(controlItemViewModelAddDoubleTap3);
                }
                ControlItemViewModel controlItemViewModelAddSlideOnSystem3 = controlViewModel.addSlideOnSystem(operation2);
                if (controlItemViewModelAddSlideOnSystem3 != null) {
                    arrayList2.add(controlItemViewModelAddSlideOnSystem3);
                }
                observableArrayList2.add(new ControlNotCustomisableViewModel(arrayList2, controlViewModel.context, null, null, null, 28, null));
                controlViewModel.setRightGestureData(observableArrayList2);
            } else {
                controlViewModel.setRightGestureData(observableArrayList2);
                ControlNotCustomisableViewModel controlNotCustomisableViewModel2 = new ControlNotCustomisableViewModel(null, controlViewModel.context, null, null, null, 28, null);
                controlNotCustomisableViewModel2.getTitle().set(controlViewModel.context.getString(R.string.gesture_not_customisation));
                controlViewModel.getRightGestureData().add(controlNotCustomisableViewModel2);
                ControlItemViewModel controlItemViewModelAddDoubleTap4 = controlViewModel.addDoubleTap(operation2);
                if (controlItemViewModelAddDoubleTap4 != null) {
                    controlItemViewModelAddDoubleTap4.setDirection(ControlRadius.HEAD);
                    controlViewModel.getRightGestureData().add(controlItemViewModelAddDoubleTap4);
                }
                ControlItemViewModel controlItemViewModelAddSlideOnSystem4 = controlViewModel.addSlideOnSystem(operation2);
                if (controlItemViewModelAddSlideOnSystem4 != null) {
                    controlItemViewModelAddSlideOnSystem4.setDirection(ControlRadius.END);
                    controlViewModel.getRightGestureData().add(controlItemViewModelAddSlideOnSystem4);
                }
                controlViewModel.getRightGestureData().add(new ControlBottomEntity());
            }
        }
        controlViewModel.getDataUpdate().postValue(new Pair<>(1, Boolean.valueOf(controlViewModel.checkHasSetValue())));
        return Unit.INSTANCE;
    }

    private final void getSelectedEarDrawable() {
        Pair pair;
        if (EarOneManager.INSTANCE.isEggModel()) {
            getLeftSelectedRes().set(Integer.valueOf(R.drawable.ear_zero_left_image));
            getRightSelectedRes().set(Integer.valueOf(R.drawable.ear_zero_right_image));
            return;
        }
        IOTDevice infoByModelId = IOTDeviceManager.INSTANCE.getInfoByModelId(SpUtils.INSTANCE.getCurrentModel());
        if (infoByModelId == null || (pair = TuplesKt.to(Integer.valueOf(infoByModelId.getLeftImage()), Integer.valueOf(infoByModelId.getRightImage()))) == null) {
            pair = new Pair(Integer.valueOf(R.drawable.ear_default_left), Integer.valueOf(R.drawable.ear_default_right));
        }
        setLeftSelectedRes(new ObservableField<>(pair.getFirst()));
        setRightSelectedRes(new ObservableField<>(pair.getSecond()));
    }

    public final void clickEarImage(String clickValue) {
        Intrinsics.checkNotNullParameter(clickValue, "clickValue");
        String str = this.saveEggValue + clickValue;
        this.saveEggValue = (StringsKt.startsWith$default(EarOneManager.EGG_LIGHT_VALUE, str, false, 2, (Object) null) || StringsKt.startsWith$default(EarOneManager.EGG_MODEL_VALUE, str, false, 2, (Object) null)) ? str : "";
        if (Intrinsics.areEqual(str, EarOneManager.EGG_LIGHT_VALUE)) {
            SpUtils.INSTANCE.setEggLight(true);
            this.eggLightValue.postValue(true);
        } else if (Intrinsics.areEqual(str, EarOneManager.EGG_MODEL_VALUE)) {
            SpUtils.INSTANCE.setEggImage(!SpUtils.INSTANCE.getEggImage());
            this.eggChangeLiveData.postValue(true);
            getSelectedEarDrawable();
        }
    }

    @Override // com.nothing.earbase.control.BaseControlViewModel
    public void setGestureData(ControlGestureViewModel viewModel, ControlOperationViewModel dialogItemViewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        super.setGestureData(viewModel, dialogItemViewModel);
        ControlConfigurationEntity.Operation options = viewModel.getOptions();
        if (options != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ControlViewModel$setGestureData$1$1(this, options, dialogItemViewModel, viewModel, null), 2, null);
        }
    }

    @Override // com.nothing.earbase.control.BaseControlViewModel
    public void resetGestureData() {
        ArrayList<ControlConfigurationEntity.Operation> arrayList = new ArrayList<>();
        resetLeftGestureData(arrayList);
        resetRightGestureData(arrayList);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(arrayList, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.ear.one.control.ControlViewModel$resetGestureData$1, reason: invalid class name */
    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.one.control.ControlViewModel$resetGestureData$1", f = "ControlViewModel.kt", i = {}, l = {187, 188}, m = "invokeSuspend", n = {}, s = {})
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
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.ear.one.control.ControlViewModel.AnonymousClass1.C01201(r6.this$0, r7, null), r6) == r0) goto L15;
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

        /* JADX INFO: renamed from: com.nothing.ear.one.control.ControlViewModel$resetGestureData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ControlViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.ear.one.control.ControlViewModel$resetGestureData$1$1", f = "ControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $result;
            int label;
            final /* synthetic */ ControlViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01201(ControlViewModel controlViewModel, boolean z, Continuation<? super C01201> continuation) {
                super(2, continuation);
                this.this$0 = controlViewModel;
                this.$result = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01201(this.this$0, this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.addScore(this.$result);
                if (this.$result) {
                    ObservableArrayList<CommonBindingMoreType> leftGestureData = this.this$0.getLeftGestureData();
                    ControlViewModel controlViewModel = this.this$0;
                    for (CommonBindingMoreType commonBindingMoreType : leftGestureData) {
                        if (commonBindingMoreType instanceof ControlGestureViewModel) {
                            ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType;
                            Integer num = controlGestureViewModel.getArrowVisible().get();
                            if (num != null && num.intValue() == 0) {
                                ControlConfigurationEntity.Operation options = controlGestureViewModel.getOptions();
                                if (options != null) {
                                    options.setOperation(controlGestureViewModel.getDefaultOperation());
                                }
                                for (ControlOperationViewModel controlOperationViewModel : controlGestureViewModel.getOperationList()) {
                                    controlOperationViewModel.selectedOperation(controlGestureViewModel.getDefaultOperation() == controlOperationViewModel.getOperation());
                                }
                                controlGestureViewModel.updateOperationText(controlGestureViewModel.getDefaultOperation(), controlViewModel.context);
                            }
                        }
                    }
                    ObservableArrayList<CommonBindingMoreType> rightGestureData = this.this$0.getRightGestureData();
                    ControlViewModel controlViewModel2 = this.this$0;
                    for (CommonBindingMoreType commonBindingMoreType2 : rightGestureData) {
                        if (commonBindingMoreType2 instanceof ControlGestureViewModel) {
                            ControlGestureViewModel controlGestureViewModel2 = (ControlGestureViewModel) commonBindingMoreType2;
                            Integer num2 = controlGestureViewModel2.getArrowVisible().get();
                            if (num2 != null && num2.intValue() == 0) {
                                ControlConfigurationEntity.Operation options2 = controlGestureViewModel2.getOptions();
                                if (options2 != null) {
                                    options2.setOperation(controlGestureViewModel2.getDefaultOperation());
                                }
                                for (ControlOperationViewModel controlOperationViewModel2 : controlGestureViewModel2.getOperationList()) {
                                    controlOperationViewModel2.selectedOperation(controlGestureViewModel2.getDefaultOperation() == controlOperationViewModel2.getOperation());
                                }
                                controlGestureViewModel2.updateOperationText(controlGestureViewModel2.getDefaultOperation(), controlViewModel2.context);
                            }
                        }
                    }
                    this.this$0.getDataUpdate().postValue(new Pair<>(Boxing.boxInt(4), Boxing.boxBoolean(false)));
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void resetRightGestureData(ArrayList<ControlConfigurationEntity.Operation> operations) {
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

    private final void resetLeftGestureData(ArrayList<ControlConfigurationEntity.Operation> operations) {
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

    private final ControlItemViewModel addDoubleTap(ControlConfigurationEntity.Operation operation) {
        if (operation != null) {
            return new ControlItemViewModel(new ControlConfigurationEntity.Operation(operation.getDevice(), operation.getButton(), 2, 2), this.context, getAddress());
        }
        return null;
    }

    private final ControlItemViewModel addSlideOnSystem(ControlConfigurationEntity.Operation operation) {
        if (operation != null) {
            return new ControlItemViewModel(new ControlConfigurationEntity.Operation(operation.getDevice(), operation.getButton(), 0, 255), this.context, getAddress());
        }
        return null;
    }
}
