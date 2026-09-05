package com.nothing.espeon.control;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.ear.R;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlNotCustomisableViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlBottomEntity;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.control.entity.ControlRadius;
import com.nothing.espeon.core.protocol.EspeonSppProtocol;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002J:\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001e\u0010\"\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001dJ.\u0010%\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0082@\u00a2\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0002J \u0010)\u001a\u00020\r2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020 0+j\b\u0012\u0004\u0012\u00020 `,H\u0002J \u0010-\u001a\u00020\r2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020 0+j\b\u0012\u0004\u0012\u00020 `,H\u0002J \u0010.\u001a\u00020\r2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020 0+j\b\u0012\u0004\u0012\u00020 `,H\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u00062"}, d2 = {"Lcom/nothing/espeon/control/ControlViewModel;", "Lcom/nothing/earbase/control/BaseControlViewModel;", "context", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "protocol", "Lcom/nothing/espeon/core/protocol/EspeonSppProtocol;", "getProtocol", "()Lcom/nothing/espeon/core/protocol/EspeonSppProtocol;", "setProtocol", "(Lcom/nothing/espeon/core/protocol/EspeonSppProtocol;)V", "register", "", "extras", "Landroid/os/Bundle;", "listenerLiveData", "addGestureList", "element", "Lcom/nothing/espeon/control/ControlItemViewModel;", "leftTemp", "Landroidx/databinding/ObservableArrayList;", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "rightTemp", "caseTemp", "setGestureData", "viewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "syncGestureData", "it", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "setVisibleOrGoneNoiseSubItems", "setAncGestureData", "operation", "", "syncAncGestureData", "(Lcom/nothing/espeon/control/ControlItemViewModel;Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Lcom/nothing/earbase/control/ControlOperationViewModel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetGestureData", "resetOperationToDevice", "resetRightGestureData", "operations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "resetCallGestureData", "resetLeftGestureData", "resetGestureOperation", "addLockCustomisable", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlViewModel extends BaseControlViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SUPPORT_GESTURES = {1, 2, 3, 7, 9, 10, 15};
    private final Application context;
    private EspeonSppProtocol protocol;

    /* JADX INFO: renamed from: com.nothing.espeon.control.ControlViewModel$syncAncGestureData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.espeon.control.ControlViewModel", f = "ControlViewModel.kt", i = {0, 0, 0, 0, 0, 0}, l = {280}, m = "syncAncGestureData", n = {"this", "it", "dialogItemViewModel", "gesture", "option", "operation"}, s = {"L$0", "L$1", "L$2", "L$5", "L$6", "I$0"})
    static final class C08121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C08121(Continuation<? super C08121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ControlViewModel.this.syncAncGestureData(null, null, null, 0, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ControlViewModel(Application context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.protocol = new EspeonSppProtocol(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/espeon/control/ControlViewModel$Companion;", "", "<init>", "()V", "SUPPORT_GESTURES", "", "getSUPPORT_GESTURES", "()[I", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public final EspeonSppProtocol getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(EspeonSppProtocol espeonSppProtocol) {
        Intrinsics.checkNotNullParameter(espeonSppProtocol, "<set-?>");
        this.protocol = espeonSppProtocol;
    }

    @Override // com.nothing.earbase.control.BaseControlViewModel
    public void register(Bundle extras) {
        super.register(extras);
        this.protocol = new EspeonSppProtocol(extras != null ? extras.getString("device_address") : null);
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
        LiveData map = Transformations.map(tWSDeviceBuilderKeyConfiguration.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderKeyConfiguration.getGetCommand(), tWSDeviceBuilderKeyConfiguration.getNotifyCommand()), new Function1<Message, ControlConfigurationEntity>() { // from class: com.nothing.espeon.control.ControlViewModel$listenerLiveData$$inlined$getLiveData$1
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
        liveDataDistinctUntilChanged.observe(this, new ControlViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.espeon.control.ControlViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlViewModel.listenerLiveData$lambda$11(this.f$0, (ControlConfigurationEntity) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:47:0x0289  */
    /* JADX WARN: Code duplicated, block: B:8:0x002d  */
    public static final Unit listenerLiveData$lambda$11(ControlViewModel controlViewModel, ControlConfigurationEntity controlConfigurationEntity) {
        ObservableArrayList<CommonBindingMoreType> observableArrayList;
        ArrayList arrayList;
        ArrayList arrayList2;
        ObservableArrayList<CommonBindingMoreType> observableArrayList2;
        Object next;
        ControlItemViewModel controlItemViewModel;
        if (controlConfigurationEntity == null) {
            return Unit.INSTANCE;
        }
        ObservableArrayList<CommonBindingMoreType> observableArrayList3 = new ObservableArrayList<>();
        ObservableArrayList<CommonBindingMoreType> observableArrayList4 = new ObservableArrayList<>();
        ObservableArrayList<CommonBindingMoreType> observableArrayList5 = new ObservableArrayList<>();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "corsola gesture old list size=" + controlConfigurationEntity.getOperations().size();
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                observableArrayList = observableArrayList3;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                observableArrayList = observableArrayList3;
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            observableArrayList = observableArrayList3;
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "operations111\uff1a" + controlConfigurationEntity.getOperations().size();
            String str5 = str4;
            if (str5 != null && str5.length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        ArrayList<ControlConfigurationEntity.Operation> operations = controlConfigurationEntity.getOperations();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : operations) {
            if (((ControlConfigurationEntity.Operation) obj).getButton() == 9) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = arrayList3;
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str7 = "call \u624b\u52bf\u5927\u5c0f\uff1a" + arrayList4.size();
            String str8 = str7;
            if (str8 == null || str8.length() == 0) {
                arrayList = arrayList4;
            } else {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str9 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                arrayList = arrayList4;
                FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                }
            }
        } else {
            arrayList = arrayList4;
        }
        ArrayList arrayList5 = arrayList;
        controlConfigurationEntity.getOperations().removeAll(CollectionsKt.toSet(arrayList5));
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true)) {
            String str10 = "operations222\uff1a" + controlConfigurationEntity.getOperations().size();
            String str11 = str10;
            if (str11 == null || str11.length() == 0) {
                arrayList2 = arrayList5;
            } else {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str12 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                arrayList2 = arrayList5;
                FileLog.print$default(fileLog4, 3, str12, tag4, str10 + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, str10 + StringUtils.SPACE + strComponent8);
                }
            }
        } else {
            arrayList2 = arrayList5;
        }
        for (ControlConfigurationEntity.Operation operation : controlConfigurationEntity.getOperations()) {
            if (ArraysKt.contains(SUPPORT_GESTURES, operation.getGesture())) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((ControlConfigurationEntity.Operation) next).getGesture() == operation.getGesture() && operation.getDevice() == 4) {
                        break;
                    }
                }
                ControlConfigurationEntity.Operation operation2 = (ControlConfigurationEntity.Operation) next;
                if (operation2 != null) {
                    Logger logger5 = Logger.INSTANCE;
                    String tag5 = logger5.getTAG();
                    int depth5 = logger5.getDepth();
                    if (logger5.isCanLogger(true)) {
                        String str13 = "\u6dfb\u52a0call \u624b\u52bf:" + operation;
                        String str14 = str13;
                        if (str14 != null && str14.length() != 0) {
                            Pair<String, String> trace5 = logger5.getTrace(depth5);
                            String strComponent9 = trace5.component1();
                            String strComponent10 = trace5.component2();
                            FileLog fileLog5 = FileLog.INSTANCE;
                            String str15 = logger5.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                            FileLog.print$default(fileLog5, 3, str15, tag5, str13 + StringUtils.SPACE + strComponent10, null, 16, null);
                            if (logger5.isDebug()) {
                                Log.i(tag5 + strComponent9, str13 + StringUtils.SPACE + strComponent10);
                            }
                        }
                    }
                    controlItemViewModel = new ControlItemViewModel(operation, controlViewModel.context, controlViewModel.getAddress(), operation2);
                } else {
                    Logger logger6 = Logger.INSTANCE;
                    String tag6 = logger6.getTAG();
                    int depth6 = logger6.getDepth();
                    if (logger6.isCanLogger(true)) {
                        String str16 = "\u4e0d\u662f call \u624b\u52bf" + operation;
                        String str17 = str16;
                        if (str17 != null && str17.length() != 0) {
                            Pair<String, String> trace6 = logger6.getTrace(depth6);
                            String strComponent11 = trace6.component1();
                            String strComponent12 = trace6.component2();
                            FileLog fileLog6 = FileLog.INSTANCE;
                            String str18 = logger6.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str18, "format(...)");
                            FileLog.print$default(fileLog6, 3, str18, tag6, str16 + StringUtils.SPACE + strComponent12, null, 16, null);
                            if (logger6.isDebug()) {
                                Log.i(tag6 + strComponent11, str16 + StringUtils.SPACE + strComponent12);
                            }
                        }
                    }
                    controlItemViewModel = new ControlItemViewModel(operation, controlViewModel.context, controlViewModel.getAddress(), null, 8, null);
                }
                observableArrayList2 = observableArrayList;
                controlViewModel.addGestureList(controlItemViewModel, observableArrayList2, observableArrayList4, observableArrayList5);
            } else {
                observableArrayList2 = observableArrayList;
            }
            observableArrayList = observableArrayList2;
        }
        ObservableArrayList<CommonBindingMoreType> observableArrayList6 = observableArrayList;
        if (!observableArrayList6.isEmpty()) {
            controlViewModel.setControlRadius(observableArrayList6);
            controlViewModel.setLeftGestureData(observableArrayList6);
            controlViewModel.getLeftGestureData().add(new ControlBottomEntity());
        }
        if (!observableArrayList4.isEmpty()) {
            controlViewModel.setControlRadius(observableArrayList4);
            controlViewModel.setRightGestureData(observableArrayList4);
            controlViewModel.getRightGestureData().add(new ControlBottomEntity());
        }
        if (!observableArrayList5.isEmpty()) {
            controlViewModel.setControlRadius(observableArrayList5);
            controlViewModel.setCaseGestureData(observableArrayList5);
            if (controlViewModel.checkCaseValue()) {
                if (controlViewModel.getIsSystem()) {
                    ArrayList arrayList6 = new ArrayList();
                    arrayList6.add(controlViewModel.addLockCustomisable());
                    controlViewModel.getCaseGestureData().add(new ControlNotCustomisableViewModel(arrayList6, controlViewModel.context, null, null, null, 28, null));
                } else {
                    ControlNotCustomisableViewModel controlNotCustomisableViewModel = new ControlNotCustomisableViewModel(null, controlViewModel.context, null, null, null, 28, null);
                    controlNotCustomisableViewModel.getTitle().set(controlViewModel.context.getString(R.string.gesture_not_customisation));
                    controlViewModel.getCaseGestureData().add(controlNotCustomisableViewModel);
                    ControlItemViewModel controlItemViewModelAddLockCustomisable = controlViewModel.addLockCustomisable();
                    controlItemViewModelAddLockCustomisable.setDirection(ControlRadius.NONE);
                    controlViewModel.getCaseGestureData().add(controlItemViewModelAddLockCustomisable);
                    controlViewModel.getCaseGestureData().add(new ControlBottomEntity());
                }
            } else {
                controlViewModel.getCaseGestureData().add(new ControlBottomEntity());
            }
            Logger logger7 = Logger.INSTANCE;
            String tag7 = logger7.getTAG();
            int depth7 = logger7.getDepth();
            if (logger7.isCanLogger(true)) {
                String str19 = "case size:" + controlViewModel.getCaseGestureData().size();
                String str20 = str19;
                if (str20 != null && str20.length() != 0) {
                    Pair<String, String> trace7 = logger7.getTrace(depth7);
                    String strComponent13 = trace7.component1();
                    String strComponent14 = trace7.component2();
                    FileLog fileLog7 = FileLog.INSTANCE;
                    String str21 = logger7.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str21, "format(...)");
                    FileLog.print$default(fileLog7, 3, str21, tag7, str19 + StringUtils.SPACE + strComponent14, null, 16, null);
                    if (logger7.isDebug()) {
                        Log.i(tag7 + strComponent13, str19 + StringUtils.SPACE + strComponent14);
                    }
                }
            }
        }
        controlViewModel.getDataUpdate().postValue(new Pair<>(1, Boolean.valueOf(controlViewModel.checkHasSetValue())));
        Logger logger8 = Logger.INSTANCE;
        String tag8 = logger8.getTAG();
        int depth8 = logger8.getDepth();
        if (logger8.isCanLogger(true) && "dataUpdate is loadData success".length() != 0) {
            Pair<String, String> trace8 = logger8.getTrace(depth8);
            String strComponent15 = trace8.component1();
            String strComponent16 = trace8.component2();
            FileLog fileLog8 = FileLog.INSTANCE;
            String str22 = logger8.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str22, "format(...)");
            FileLog.print$default(fileLog8, 4, str22, tag8, "dataUpdate is loadData success " + strComponent16, null, 16, null);
            if (logger8.isDebug()) {
                Log.i(tag8 + strComponent15, "dataUpdate is loadData success " + strComponent16);
            }
        }
        return Unit.INSTANCE;
    }

    private final void addGestureList(ControlItemViewModel element, ObservableArrayList<CommonBindingMoreType> leftTemp, ObservableArrayList<CommonBindingMoreType> rightTemp, ObservableArrayList<CommonBindingMoreType> caseTemp) {
        if (Intrinsics.areEqual((Object) element.isLeft().get(), (Object) true)) {
            leftTemp.add(element);
        } else if (Intrinsics.areEqual((Object) element.isRight().get(), (Object) true)) {
            rightTemp.add(element);
        } else if (Intrinsics.areEqual((Object) element.isCase().get(), (Object) true)) {
            caseTemp.add(element);
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
    /* JADX WARN: Code duplicated, block: B:11:0x006f  */
    public final void syncGestureData(ControlOperationViewModel dialogItemViewModel, ControlConfigurationEntity.Operation it, ControlGestureViewModel viewModel) {
        Pair pair;
        boolean z;
        boolean z2;
        ControlGestureViewModel controlGestureViewModel;
        ControlConfigurationEntity.Operation options;
        ControlConfigurationEntity.Operation options2;
        ControlOperationViewModel controlOperationViewModel = dialogItemViewModel;
        boolean zIsNoiseOperation = controlOperationViewModel.isNoiseOperation(it.getOperation());
        boolean zIsNoiseOperation2 = controlOperationViewModel.isNoiseOperation(controlOperationViewModel.getOperation());
        if (Intrinsics.areEqual((Object) viewModel.isLeft().get(), (Object) true)) {
            pair = TuplesKt.to(getRightGestureData(), getCaseGestureData());
        } else {
            pair = Intrinsics.areEqual((Object) viewModel.isRight().get(), (Object) true) ? TuplesKt.to(getLeftGestureData(), getCaseGestureData()) : TuplesKt.to(getRightGestureData(), getLeftGestureData());
        }
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
        Iterator it2 = TuplesKt.toList(pair).iterator();
        while (it2.hasNext()) {
            for (CommonBindingMoreType commonBindingMoreType : (ObservableArrayList) it2.next()) {
                if ((commonBindingMoreType instanceof ControlGestureViewModel) && (options = (controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType).getOptions()) != null && it.getGesture() == options.getGesture() && (options2 = controlGestureViewModel.getOptions()) != null && controlOperationViewModel.isNoiseOperation(options2.getOperation())) {
                    controlOperationViewModel.setOperation(options2.getOperation());
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
                controlOperationViewModel = dialogItemViewModel;
            }
            controlOperationViewModel = dialogItemViewModel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVisibleOrGoneNoiseSubItems(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel viewModel) {
        ObservableArrayList<CommonBindingMoreType> rightGestureData;
        if (dialogItemViewModel.getOperation() == 10 || dialogItemViewModel.getOperation() == 20 || dialogItemViewModel.getOperation() == 22 || dialogItemViewModel.getOperation() == 21) {
            dialogItemViewModel.getNoiseControlVisible().set(true);
            return;
        }
        if (Intrinsics.areEqual((Object) viewModel.isLeft().get(), (Object) true)) {
            rightGestureData = getLeftGestureData();
        } else {
            rightGestureData = Intrinsics.areEqual((Object) viewModel.isRight().get(), (Object) true) ? getRightGestureData() : getCaseGestureData();
        }
        for (CommonBindingMoreType commonBindingMoreType : rightGestureData) {
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
    /* JADX WARN: Code duplicated, block: B:24:0x00be  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:29:0x00de  */
    /* JADX WARN: Code duplicated, block: B:61:0x0236  */
    /* JADX WARN: Code duplicated, block: B:62:0x0238  */
    /* JADX WARN: Code duplicated, block: B:64:0x023e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00be -> B:25:0x00ce). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01f0 -> B:52:0x01f9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0238 -> B:63:0x0239). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object syncAncGestureData(com.nothing.espeon.control.ControlItemViewModel r24, com.nothing.earbase.control.entity.ControlConfigurationEntity.Operation r25, com.nothing.earbase.control.ControlOperationViewModel r26, int r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.espeon.control.ControlViewModel.syncAncGestureData(com.nothing.espeon.control.ControlItemViewModel, com.nothing.earbase.control.entity.ControlConfigurationEntity$Operation, com.nothing.earbase.control.ControlOperationViewModel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.nothing.earbase.control.BaseControlViewModel
    public void resetGestureData() {
        ArrayList<ControlConfigurationEntity.Operation> arrayList = new ArrayList<>();
        resetLeftGestureData(arrayList);
        resetRightGestureData(arrayList);
        resetCallGestureData(arrayList);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(arrayList, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.espeon.control.ControlViewModel$resetGestureData$1, reason: invalid class name */
    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.espeon.control.ControlViewModel$resetGestureData$1", f = "ControlViewModel.kt", i = {}, l = {305, 306}, m = "invokeSuspend", n = {}, s = {})
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
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.espeon.control.ControlViewModel.AnonymousClass1.C01601(r7, r6.this$0, null), r6) == r0) goto L15;
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

        /* JADX INFO: renamed from: com.nothing.espeon.control.ControlViewModel$resetGestureData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ControlViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.espeon.control.ControlViewModel$resetGestureData$1$1", f = "ControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $result;
            int label;
            final /* synthetic */ ControlViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01601(boolean z, ControlViewModel controlViewModel, Continuation<? super C01601> continuation) {
                super(2, continuation);
                this.$result = z;
                this.this$0 = controlViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01601(this.$result, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.$result) {
                    this.this$0.resetOperationToDevice();
                    this.this$0.getDataUpdate().postValue(new Pair<>(Boxing.boxInt(4), Boxing.boxBoolean(false)));
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetOperationToDevice() {
        for (CommonBindingMoreType commonBindingMoreType : getLeftGestureData()) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                resetGestureOperation((ControlGestureViewModel) commonBindingMoreType);
            }
        }
        for (CommonBindingMoreType commonBindingMoreType2 : getRightGestureData()) {
            if (commonBindingMoreType2 instanceof ControlGestureViewModel) {
                resetGestureOperation((ControlGestureViewModel) commonBindingMoreType2);
            }
        }
        for (CommonBindingMoreType commonBindingMoreType3 : getCaseGestureData()) {
            if (commonBindingMoreType3 instanceof ControlGestureViewModel) {
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType3;
                controlGestureViewModel.getOperationSubName().set("\n" + ContextExtKt.getLocalizedResources(this.context).getString(R.string.control_no_action));
                resetGestureOperation(controlGestureViewModel);
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

    private final void resetCallGestureData(ArrayList<ControlConfigurationEntity.Operation> operations) {
        Integer num;
        CommonBindingMoreType commonBindingMoreType = null;
        CommonBindingMoreType commonBindingMoreType2 = null;
        for (CommonBindingMoreType commonBindingMoreType3 : getCaseGestureData()) {
            if (commonBindingMoreType3 instanceof ControlGestureViewModel) {
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType3;
                ControlConfigurationEntity.Operation options = controlGestureViewModel.getOptions();
                if (options != null && options.getOperation() == 40) {
                    commonBindingMoreType2 = commonBindingMoreType3;
                }
                ControlConfigurationEntity.Operation options2 = controlGestureViewModel.getOptions();
                if (options2 != null && (num = controlGestureViewModel.getArrowVisible().get()) != null && num.intValue() == 0) {
                    ControlConfigurationEntity.Operation operationCopy$default = ControlConfigurationEntity.Operation.copy$default(options2, 0, 0, 0, 0, 15, null);
                    operationCopy$default.setOperation(controlGestureViewModel.getDefaultOperation());
                    operations.add(operationCopy$default);
                }
                ControlConfigurationEntity.Operation callOperation = controlGestureViewModel.getCallOperation();
                if (callOperation != null) {
                    ControlConfigurationEntity.Operation operationCopy$default2 = ControlConfigurationEntity.Operation.copy$default(callOperation, 0, 0, 0, 0, 15, null);
                    operationCopy$default2.setOperation(controlGestureViewModel.getDefaultOperation());
                    operations.add(operationCopy$default2);
                }
            }
            if (commonBindingMoreType3 instanceof ControlNotCustomisableViewModel) {
                commonBindingMoreType = commonBindingMoreType3;
            }
        }
        if (commonBindingMoreType != null) {
            getCaseGestureData().remove(commonBindingMoreType);
        }
        if (commonBindingMoreType2 != null) {
            getCaseGestureData().remove(commonBindingMoreType2);
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

    private final void resetGestureOperation(ControlGestureViewModel it) {
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

    private final ControlItemViewModel addLockCustomisable() {
        return new ControlItemViewModel(new ControlConfigurationEntity.Operation(4, 1, 15, 40), this.context, getAddress(), null, 8, null);
    }
}
