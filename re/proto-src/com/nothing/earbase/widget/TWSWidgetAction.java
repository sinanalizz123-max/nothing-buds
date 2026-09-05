package com.nothing.earbase.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import com.google.android.exoplayer2.Renderer;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.cardservice.CardWidgetManager;
import com.nothing.cardtransform.CardInfo;
import com.nothing.cardtransform.info.ActionInfo;
import com.nothing.cardtransform.info.CustomInfo;
import com.nothing.cardtransform.info.ListViewInfo;
import com.nothing.cardtransform.info.ParamInfo;
import com.nothing.cardtransform.info.ResultInfo;
import com.nothing.cardtransform.info.ScheduleInfo;
import com.nothing.cardtransform.info.ViewPagerInfo;
import com.nothing.cardtransform.type.ParamType;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.widget.IOTDeviceWidgetAction;
import com.nothing.device.widget.entity.BaseWidgetUIModel;
import com.nothing.ear.R;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;
import org.json.JSONException;

/* JADX INFO: compiled from: TWSWidgetAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J,\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J.\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003JR\u0010\u0016\u001a\u00020\u0005*\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u001aj\b\u0012\u0004\u0012\u00020\u0018`\u001b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003J.\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006!"}, d2 = {"Lcom/nothing/earbase/widget/TWSWidgetAction;", "Lcom/nothing/device/widget/IOTDeviceWidgetAction;", "<init>", "()V", "freshGoogleWidgetView", "", "uiModel", "Lcom/nothing/device/widget/entity/BaseWidgetUIModel;", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "createGoogleWidgetView", "Landroid/widget/RemoteViews;", "freshNothingWidgetView", "authority", "", "freshNothingWidgetSize", "options", "Landroid/os/Bundle;", "createNothingWidgetView", "Lcom/nothing/cardtransform/CardInfo;", "setNothingPageView", "earPage", "Lcom/nothing/cardtransform/info/ListViewInfo$ItemViewInfo;", "viewPageData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "getNothingEarViewPage", "getNothingViewPageSize", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TWSWidgetAction extends IOTDeviceWidgetAction {

    /* JADX INFO: renamed from: com.nothing.earbase.widget.TWSWidgetAction$freshGoogleWidgetView$1, reason: invalid class name */
    /* JADX INFO: compiled from: TWSWidgetAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.widget.TWSWidgetAction$freshGoogleWidgetView$1", f = "TWSWidgetAction.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        final /* synthetic */ BaseWidgetUIModel $uiModel;
        int label;
        final /* synthetic */ TWSWidgetAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseWidgetUIModel baseWidgetUIModel, TWSWidgetAction tWSWidgetAction, Context context, Intent intent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$uiModel = baseWidgetUIModel;
            this.this$0 = tWSWidgetAction;
            this.$context = context;
            this.$intent = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$uiModel, this.this$0, this.$context, this.$intent, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$uiModel.setBluetoothClose(!BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable());
                RemoteViews remoteViewsCreateGoogleWidgetView = this.this$0.createGoogleWidgetView(this.$context, this.$uiModel, this.$intent);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C01551(this.$context, this.$uiModel, remoteViewsCreateGoogleWidgetView, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.widget.TWSWidgetAction$freshGoogleWidgetView$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TWSWidgetAction.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.widget.TWSWidgetAction$freshGoogleWidgetView$1$1", f = "TWSWidgetAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ RemoteViews $remoteViews;
            final /* synthetic */ BaseWidgetUIModel $uiModel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01551(Context context, BaseWidgetUIModel baseWidgetUIModel, RemoteViews remoteViews, Continuation<? super C01551> continuation) {
                super(2, continuation);
                this.$context = context;
                this.$uiModel = baseWidgetUIModel;
                this.$remoteViews = remoteViews;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01551(this.$context, this.$uiModel, this.$remoteViews, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.$context);
                if (appWidgetManager != null) {
                    appWidgetManager.updateAppWidget(this.$uiModel.getWidgetId(), this.$remoteViews);
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.device.widget.IOTDeviceWidgetAction
    public void freshGoogleWidgetView(BaseWidgetUIModel uiModel, Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(uiModel, this, context, intent, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RemoteViews createGoogleWidgetView(Context context, BaseWidgetUIModel uiModel, Intent intent) {
        if (uiModel.getBluetoothClose() || uiModel.getDeviceAddress().length() == 0) {
            return new GoogleWidgetEmptyView(context, uiModel, intent).getEmptyView();
        }
        if (uiModel.isConnected()) {
            IOTDevice iotDevice = uiModel.getIotDevice();
            if (iotDevice != null && iotDevice.isSupportAnc(uiModel.getDeviceAddress())) {
                return new GoogleWidgetNoiseView(context, uiModel, intent).getNoiseView();
            }
            return new GoogleWidgetConnectView(context, uiModel, intent).getConnectView();
        }
        return new GoogleWidgetDisconnectView(context, uiModel, intent).getDisconnectView();
    }

    /* JADX INFO: renamed from: com.nothing.earbase.widget.TWSWidgetAction$freshNothingWidgetView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSWidgetAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.widget.TWSWidgetAction$freshNothingWidgetView$1", f = "TWSWidgetAction.kt", i = {}, l = {Renderer.MSG_SET_WAKEUP_LISTENER}, m = "invokeSuspend", n = {}, s = {})
    static final class C07841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $authority;
        final /* synthetic */ Context $context;
        final /* synthetic */ BaseWidgetUIModel $uiModel;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TWSWidgetAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07841(BaseWidgetUIModel baseWidgetUIModel, TWSWidgetAction tWSWidgetAction, Context context, String str, Continuation<? super C07841> continuation) {
            super(2, continuation);
            this.$uiModel = baseWidgetUIModel;
            this.this$0 = tWSWidgetAction;
            this.$context = context;
            this.$authority = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07841 c07841 = new C07841(this.$uiModel, this.this$0, this.$context, this.$authority, continuation);
            c07841.L$0 = obj;
            return c07841;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0062  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JSONException {
            String str;
            Object obj2;
            String str2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$uiModel.setBluetoothClose(!BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable());
                CardInfo cardInfoCreateNothingWidgetView = this.this$0.createNothingWidgetView(this.$uiModel, this.$context, this.$authority, null);
                Context context = this.$context;
                CardWidgetManager companion = context != null ? CardWidgetManager.INSTANCE.getInstance(context) : null;
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str3 = "cardWidgetManager is null:" + (companion == null) + ",cardInfo:" + cardInfoCreateNothingWidgetView;
                    String str4 = str3;
                    if (str4 == null || str4.length() == 0) {
                        obj2 = coroutine_suspended;
                        str = "format(...)";
                        str2 = StringUtils.SPACE;
                    } else {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str5 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        String str6 = str3 + StringUtils.SPACE + strComponent2;
                        str = "format(...)";
                        obj2 = coroutine_suspended;
                        str2 = StringUtils.SPACE;
                        FileLog.print$default(fileLog, 3, str5, tag, str6, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str3 + str2 + strComponent2);
                        }
                    }
                } else {
                    obj2 = coroutine_suspended;
                    str = "format(...)";
                    str2 = StringUtils.SPACE;
                }
                Logger logger2 = Logger.INSTANCE;
                BaseWidgetUIModel baseWidgetUIModel = this.$uiModel;
                Logger logger3 = logger2;
                String tag2 = logger3.getTAG();
                int depth2 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str7 = "cardInfo is null:" + (cardInfoCreateNothingWidgetView == null) + ",widgetId:" + WidgetUtils.INSTANCE.nothingLaunchWidgetId(baseWidgetUIModel.getWidgetId());
                    String str8 = str7;
                    if (str8 != null && str8.length() != 0) {
                        Pair<String, String> trace2 = logger3.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str9 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, str);
                        FileLog.print$default(fileLog2, 3, str9, tag2, str7 + str2 + strComponent4, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag2 + strComponent3, str7 + str2 + strComponent4);
                        }
                    }
                }
                this.label = 1;
                Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(cardInfoCreateNothingWidgetView, companion, this.$uiModel, null), this);
                Object obj3 = obj2;
                if (objWithContext == obj3) {
                    return obj3;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.widget.TWSWidgetAction$freshNothingWidgetView$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: TWSWidgetAction.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.widget.TWSWidgetAction$freshNothingWidgetView$1$3", f = "TWSWidgetAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CardInfo $cardInfo;
            final /* synthetic */ CardWidgetManager $cardWidgetManager;
            final /* synthetic */ BaseWidgetUIModel $uiModel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(CardInfo cardInfo, CardWidgetManager cardWidgetManager, BaseWidgetUIModel baseWidgetUIModel, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$cardInfo = cardInfo;
                this.$cardWidgetManager = cardWidgetManager;
                this.$uiModel = baseWidgetUIModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$cardInfo, this.$cardWidgetManager, this.$uiModel, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                String strBuild;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                CardInfo cardInfo = this.$cardInfo;
                if (cardInfo != null && (strBuild = cardInfo.build()) != null) {
                    CardWidgetManager cardWidgetManager = this.$cardWidgetManager;
                    BaseWidgetUIModel baseWidgetUIModel = this.$uiModel;
                    if (cardWidgetManager != null) {
                        cardWidgetManager.updateAppWidget(WidgetUtils.INSTANCE.nothingLaunchWidgetId(baseWidgetUIModel.getWidgetId()), strBuild);
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.device.widget.IOTDeviceWidgetAction
    public synchronized void freshNothingWidgetView(BaseWidgetUIModel uiModel, Context context, String authority) throws Throwable {
        try {
            try {
                Intrinsics.checkNotNullParameter(uiModel, "uiModel");
                Intrinsics.checkNotNullParameter(authority, "authority");
                if (!NothingOSUtil.INSTANCE.isNothingOS()) {
                    return;
                }
                try {
                    BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C07841(uiModel, this, context, authority, null), 3, null);
                    return;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003f  */
    @Override // com.nothing.device.widget.IOTDeviceWidgetAction
    public void freshNothingWidgetSize(BaseWidgetUIModel uiModel, Context context, String authority, Bundle options) throws JSONException {
        CardInfo cardInfo;
        String strBuild;
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        Intrinsics.checkNotNullParameter(authority, "authority");
        if (NothingOSUtil.INSTANCE.isNothingOS()) {
            CardInfo cardInfoCreateNothingWidgetView = createNothingWidgetView(uiModel, context, authority, options);
            CardWidgetManager companion = context != null ? CardWidgetManager.INSTANCE.getInstance(context) : null;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "cardWidgetManager is null:" + (companion == null) + ",cardInfo:" + cardInfoCreateNothingWidgetView;
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    cardInfo = cardInfoCreateNothingWidgetView;
                } else {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    cardInfo = cardInfoCreateNothingWidgetView;
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            } else {
                cardInfo = cardInfoCreateNothingWidgetView;
            }
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "cardInfo is null:" + (cardInfo == null) + ",widgetId:" + WidgetUtils.INSTANCE.nothingLaunchWidgetId(uiModel.getWidgetId());
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
            if (cardInfo == null || (strBuild = cardInfo.build()) == null || companion == null) {
                return;
            }
            companion.updateAppWidget(WidgetUtils.INSTANCE.nothingLaunchWidgetId(uiModel.getWidgetId()), strBuild);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final CardInfo createNothingWidgetView(BaseWidgetUIModel uiModel, Context context, String authority, Bundle options) throws JSONException {
        String packageName;
        String str = null;
        Object[] objArr = 0;
        if (!NothingOSUtil.INSTANCE.isNothingLaunch(context, true)) {
            return null;
        }
        if (uiModel.getBluetoothClose() || uiModel.getDeviceAddress().length() == 0) {
            return new NothingWidgetEmptyView(uiModel, context, authority, options).getEmptyViewCardInfo();
        }
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(uiModel.getDeviceAddress());
        if (iOTDeviceByMacAddress == null) {
            return null;
        }
        int i = R.layout.nothing_widget_view;
        if (context == null || (packageName = context.getPackageName()) == null) {
            packageName = "";
        }
        CardInfo cardInfo = new CardInfo(i, packageName, authority);
        ViewPagerInfo viewPagerInfo = new ViewPagerInfo(R.id.ear_page, str, 2, objArr == true ? 1 : 0);
        int nothingViewPageSize = getNothingViewPageSize(iOTDeviceByMacAddress, uiModel);
        ListViewInfo.ItemViewInfo nothingEarViewPage = getNothingEarViewPage(uiModel, context, iOTDeviceByMacAddress, options);
        ArrayList<ListViewInfo.ItemViewInfo> arrayList = new ArrayList<>(nothingViewPageSize);
        setNothingPageView(cardInfo, nothingEarViewPage, arrayList, uiModel, iOTDeviceByMacAddress, context, options);
        viewPagerInfo.setViewPagerAdapter(arrayList);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "viewpage size :" + nothingViewPageSize;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (uiModel.getEarPage()) {
            viewPagerInfo.setCurrentItem(0);
        } else {
            viewPagerInfo.setCurrentItem(1);
        }
        ActionInfo actionInfo = new ActionInfo(R.id.ear_page);
        actionInfo.registerOnPageChangeCallback(new ResultInfo());
        cardInfo.setActionInfo(actionInfo);
        ScheduleInfo scheduleInfo = new ScheduleInfo();
        scheduleInfo.configViewResumeCallback();
        scheduleInfo.configViewStopCallback();
        cardInfo.setScheduleInfo(scheduleInfo);
        cardInfo.setViewInfo(viewPagerInfo);
        return cardInfo;
    }

    private final void setNothingPageView(CardInfo cardInfo, ListViewInfo.ItemViewInfo itemViewInfo, ArrayList<ListViewInfo.ItemViewInfo> arrayList, BaseWidgetUIModel baseWidgetUIModel, IOTDevice iOTDevice, Context context, Bundle bundle) {
        ListViewInfo.ItemViewInfo noiseViewPage;
        if (itemViewInfo != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "ear page not empty".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "ear page not empty " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "ear page not empty " + strComponent2);
                }
            }
            arrayList.add(itemViewInfo);
        }
        if (baseWidgetUIModel.isConnected() && iOTDevice.isSupportAnc(iOTDevice.getMacAddress()) && (noiseViewPage = new NothingWidgetNoiseView(baseWidgetUIModel, context, bundle).getNoiseViewPage()) != null) {
            arrayList.add(noiseViewPage);
            CustomInfo customInfo = new CustomInfo(R.id.page_indicator, "setPageListener");
            customInfo.setParam(new ParamInfo(ParamType.INSTANCE.getINTEGER(), Integer.valueOf(R.id.ear_page)));
            cardInfo.setCustomInfo(customInfo);
        }
    }

    private final ListViewInfo.ItemViewInfo getNothingEarViewPage(BaseWidgetUIModel uiModel, Context context, IOTDevice iotDevice, Bundle options) {
        if (uiModel.isConnected()) {
            return new NothingWidgetEarConnectView(uiModel, context, iotDevice, options).getEarPageConnectView();
        }
        return new NothingWidgetEarDisconnectView(uiModel, context, iotDevice, options).getEarPageDisconnectView();
    }

    private final int getNothingViewPageSize(IOTDevice iotDevice, BaseWidgetUIModel uiModel) {
        return (iotDevice.isSupportAnc(iotDevice.getMacAddress()) && uiModel.isConnected()) ? 2 : 1;
    }
}
