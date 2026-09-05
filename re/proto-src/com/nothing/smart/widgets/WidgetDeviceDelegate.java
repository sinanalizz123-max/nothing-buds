package com.nothing.smart.widgets;

import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.Utils;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.broadcase.ext.BluetoothDeviceExtKt;
import com.nothing.cardservice.CardWidgetManager;
import com.nothing.database.dao.DeviceItemDao;
import com.nothing.database.dao.WidgetContentProvider;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.entity.WidgetItem;
import com.nothing.database.old.OldWidgetContentProvider;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.widget.entity.BaseWidgetUIModel;
import com.nothing.device.widget.entity.DeviceBattery;
import com.nothing.device.widget.entity.DeviceNoiseItem;
import com.nothing.device.widget.entity.DeviceNoiseReduction;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.global.core.router.GlobalImplKt;
import com.nothing.log.FileLog;
import com.nothing.log.feedback.LogFeedback;
import com.nothing.nt_route.FlutterRouterManager;
import com.nothing.protocol.SPPConnect;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import defpackage.FlutterRoute;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010&\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0003J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0003J\"\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ\u0018\u0010 \u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0082@\u00a2\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u0012\u0012\f\u0012\n #*\u0004\u0018\u00010\n0\n\u0018\u00010\u0014H\u0002J\b\u0010$\u001a\u00020\u0003H\u0002J\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000eJ\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0018\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010,\u001a\u00020-J\u001a\u0010.\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J.\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u00032\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a03J\u001a\u00104\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001c\u00105\u001a\u0004\u0018\u00010\u000f2\u0006\u00106\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u00107\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0015J\"\u00108\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ\u0018\u00109\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u000eJ\u001a\u0010:\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0018\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0018\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J$\u0010@\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u000e2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0BH\u0002J\u0018\u0010C\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0010\u0010D\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000fH\u0002J\u0018\u0010E\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u000eJ \u0010F\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u000eH\u0082@\u00a2\u0006\u0002\u0010GJ(\u0010H\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0J0I2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010K\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010L\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J>\u0010M\u001a\u00020\u001a2\u001e\u0010N\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0J0I2\u0006\u0010O\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0082@\u00a2\u0006\u0002\u0010PJ4\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020\u00032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0B2\u0006\u0010O\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u000eH\u0002J\u0010\u0010T\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J \u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020X2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010K\u001a\u00020\u001aH\u0016J\b\u0010L\u001a\u00020\u001aH\u0016J\u001a\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020\u000e2\b\u0010[\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020XH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006]"}, d2 = {"Lcom/nothing/smart/widgets/WidgetDeviceDelegate;", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "isNothing", "", "delegateInterface", "Lcom/nothing/smart/widgets/DeviceDelegateInterface;", "<init>", "(ZLcom/nothing/smart/widgets/DeviceDelegateInterface;)V", GlobalImplKt.DEVICE_LIST, "Ljava/util/concurrent/ConcurrentHashMap;", "", "getDeviceList", "()Ljava/util/concurrent/ConcurrentHashMap;", "widgetDataList", "", "Lcom/nothing/device/widget/entity/BaseWidgetUIModel;", "getWidgetDataList", "connectFlowJob", "Lkotlinx/coroutines/Job;", "getSqliteWidgetItem", "", "Lcom/nothing/database/entity/WidgetItem;", "context", "Landroid/content/Context;", "getOldContentDevice", "insertContentDevice", "", "widgetItem", "getContentDevice", "deleteDevice", "widgetId", "address", "getAllDevice", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBoundDevice", "kotlin.jvm.PlatformType", "isDeviceAvailable", "addWidget", "widgetTypeDevice", "createTWSDevice", "createTwsByWidgetItem", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "updateWidget", "widgetIds", "", "dataClear", "getTwsDevice", "widgetUIData", "isAutoConnect", "createDeviceAction", "Lkotlin/Function0;", "checkWidgetId", "getWidgetUiModel", "it", "initWidgetUIModel", "connectDevice", "sendNoiseLevel", "deviceEmptyCheckIsClearData", "deviceNoiseBuriedPoint", "noiseModel", "checkIsNeedConnectAnimal", "widgetUIModel", "connectFlow", "setWidgetAnimator", "item", "", "sendBasicCommand", "getNoiseModel", "gotoApp", "selectDeviceToHome", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNotHasWidgetData", "Lkotlin/Pair;", "", "onConnected", "onDisconnected", "updateWidgetWithNoAnimation", "widgetDataPair", "deviceAddress", "(Lkotlin/Pair;Ljava/lang/String;Lcom/nothing/protocol/device/TWSDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetDataPairStatus", "isBonded", "connectCurrentState", "openBluetooth", "onUpdate", "cmdType", "data", "Lcom/nothing/protocol/model/Message;", "onError", "code", "message", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetDeviceDelegate implements TWSDevice.Callback {
    private static final long CONNECT_TIME_OUT = 15000;
    private static final long DISCONNECT_CHECK_STATUS = 800;
    private static final long FAIL_ANIMAL_TIME = 2000;
    private static final long REMOVE_DEVICE_TIME = 2000;
    private final ConcurrentHashMap<String, Job> connectFlowJob;
    private final DeviceDelegateInterface delegateInterface;
    private final ConcurrentHashMap<String, String> deviceList;
    private final boolean isNothing;
    private final ConcurrentHashMap<Integer, BaseWidgetUIModel> widgetDataList;

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$getAllDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate", f = "WidgetDeviceDelegate.kt", i = {1}, l = {244, 276}, m = "getAllDevice", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WidgetDeviceDelegate.this.getAllDevice(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$updateWidgetWithNoAnimation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate", f = "WidgetDeviceDelegate.kt", i = {0, 0, 0, 0}, l = {1142}, m = "updateWidgetWithNoAnimation", n = {"this", "widgetDataPair", "deviceAddress", "twsDevice"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C10741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10741(Continuation<? super C10741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WidgetDeviceDelegate.this.updateWidgetWithNoAnimation(null, null, null, this);
        }
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(int code, String message) {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public WidgetDeviceDelegate(boolean z, DeviceDelegateInterface delegateInterface) {
        Intrinsics.checkNotNullParameter(delegateInterface, "delegateInterface");
        this.isNothing = z;
        this.delegateInterface = delegateInterface;
        this.deviceList = new ConcurrentHashMap<>();
        this.widgetDataList = new ConcurrentHashMap<>();
        this.connectFlowJob = new ConcurrentHashMap<>();
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void getBesVersionSuccess() {
        TWSDevice.Callback.DefaultImpls.getBesVersionSuccess(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public boolean isIOThread() {
        return TWSDevice.Callback.DefaultImpls.isIOThread(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnecting(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnecting(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice, int i, String str) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i, str);
    }

    public final ConcurrentHashMap<String, String> getDeviceList() {
        return this.deviceList;
    }

    public final ConcurrentHashMap<Integer, BaseWidgetUIModel> getWidgetDataList() {
        return this.widgetDataList;
    }

    public final List<WidgetItem> getSqliteWidgetItem(Context context) {
        if (Utils.INSTANCE.getProcessIsKill() == 0) {
            SpUtils.INSTANCE.setMigrationProvider(true);
            return DatabaseUtils.INSTANCE.getWidgetDao().getAllWidgetItem();
        }
        if (!SpUtils.INSTANCE.isMigrationProvider()) {
            SpUtils.INSTANCE.setMigrationProvider(true);
            List<WidgetItem> oldContentDevice = getOldContentDevice(context);
            Iterator<T> it = oldContentDevice.iterator();
            while (it.hasNext()) {
                insertContentDevice(context, (WidgetItem) it.next());
            }
            return oldContentDevice;
        }
        return getContentDevice(context);
    }

    private final List<WidgetItem> getOldContentDevice(Context context) {
        Cursor cursorQuery;
        ContentResolver contentResolver;
        ArrayList arrayList = new ArrayList();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            cursorQuery = null;
        } else {
            Function1<String, Uri> uri_widget = OldWidgetContentProvider.INSTANCE.getURI_WIDGET();
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            cursorQuery = contentResolver.query(uri_widget.invoke(packageName), null, null, null, null, null);
        }
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("appWidgetId"));
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("address"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("deviceColor"));
                int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("widgetTheme"));
                String oldDeviceModelId = RouterFactory.INSTANCE.getAppRouter().getOldDeviceModelId(i2);
                Intrinsics.checkNotNull(string);
                arrayList.add(new WidgetItem(i, string, oldDeviceModelId, i3, 0));
            }
            cursorQuery.close();
        }
        return arrayList;
    }

    private final void insertContentDevice(Context context, WidgetItem widgetItem) {
        ContentResolver contentResolver;
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return;
        }
        Function1<String, Uri> uri_widget = WidgetContentProvider.INSTANCE.getURI_WIDGET();
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        contentResolver.insert(uri_widget.invoke(packageName), WidgetItem.INSTANCE.toContentValues(widgetItem));
    }

    private final List<WidgetItem> getContentDevice(Context context) {
        Cursor cursorQuery;
        ContentResolver contentResolver;
        ArrayList arrayList = new ArrayList();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            cursorQuery = null;
        } else {
            Function1<String, Uri> uri_widget = WidgetContentProvider.INSTANCE.getURI_WIDGET();
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            cursorQuery = contentResolver.query(uri_widget.invoke(packageName), null, null, null, null, null);
        }
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("widget_app_id"));
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("address"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("model_id"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("widget_theme"));
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNull(string2);
                arrayList.add(new WidgetItem(i, string, string2, i2, 0));
            }
            cursorQuery.close();
        }
        return arrayList;
    }

    public final void deleteDevice(Context context, int widgetId, String address) {
        ContentResolver contentResolver;
        String str = address;
        if (str == null || str.length() == 0) {
            this.widgetDataList.remove(Integer.valueOf(widgetId));
            if (Utils.INSTANCE.getProcessIsKill() == 0) {
                DatabaseUtils.INSTANCE.getWidgetDao().deleteWidgetItem(widgetId);
                return;
            }
            if (context == null || (contentResolver = context.getContentResolver()) == null) {
                return;
            }
            WidgetContentProvider.Companion companion = WidgetContentProvider.INSTANCE;
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            contentResolver.delete(companion.getContentUriWithId(packageName, widgetId), null, null);
            return;
        }
        this.deviceList.remove(address);
        ConcurrentHashMap<Integer, BaseWidgetUIModel> concurrentHashMap = this.widgetDataList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Integer, BaseWidgetUIModel> entry : concurrentHashMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue().getDeviceAddress(), address) && widgetTypeDevice(entry.getValue().getWidgetId())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            this.widgetDataList.remove(entry2.getKey());
            DatabaseUtils.INSTANCE.getWidgetDao().deleteWidgetItem(((Number) entry2.getKey()).intValue());
            this.delegateInterface.deleteDevice(((Number) entry2.getKey()).intValue(), ((BaseWidgetUIModel) entry2.getValue()).getDeviceAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:125:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:127:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:130:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:135:0x0449  */
    /* JADX WARN: Code duplicated, block: B:139:0x0489 A[PHI: r0 r1 r3
      0x0489: PHI (r0v29 com.nothing.smart.widgets.WidgetDeviceDelegate) = (r0v19 com.nothing.smart.widgets.WidgetDeviceDelegate), (r0v31 com.nothing.smart.widgets.WidgetDeviceDelegate) binds: [B:126:0x03d3, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]
      0x0489: PHI (r1v45 java.util.Iterator) = (r1v37 java.util.Iterator), (r1v48 java.util.Iterator) binds: [B:126:0x03d3, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]
      0x0489: PHI (r3v42 char) = (r3v32 char), (r3v0 char) binds: [B:126:0x03d3, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x03d3 -> B:139:0x0489). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x0486 -> B:140:0x048a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getAllDevice(android.content.Context r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instruction units count: 1297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.smart.widgets.WidgetDeviceDelegate.getAllDevice(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$getAllDevice$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$getAllDevice$3", f = "WidgetDeviceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10693 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<DeviceItem> $devices;
        final /* synthetic */ List<WidgetItem> $widgetList;
        int label;
        final /* synthetic */ WidgetDeviceDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10693(List<WidgetItem> list, WidgetDeviceDelegate widgetDeviceDelegate, Context context, List<DeviceItem> list2, Continuation<? super C10693> continuation) {
            super(2, continuation);
            this.$widgetList = list;
            this.this$0 = widgetDeviceDelegate;
            this.$context = context;
            this.$devices = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10693(this.$widgetList, this.this$0, this.$context, this.$devices, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10693) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<WidgetItem> list = this.$widgetList;
            WidgetDeviceDelegate widgetDeviceDelegate = this.this$0;
            Context context = this.$context;
            List<DeviceItem> list2 = this.$devices;
            for (WidgetItem widgetItem : list) {
                widgetDeviceDelegate.deleteDevice(context, widgetItem.getAppWidgetId(), null);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    DatabaseUtils.INSTANCE.getDeviceDao().deleteDeviceItem((DeviceItem) it.next());
                }
                if (widgetDeviceDelegate.widgetTypeDevice(widgetItem.getAppWidgetId())) {
                    widgetDeviceDelegate.delegateInterface.getAllDeviceSystemNoPairDevice(widgetItem.getAppWidgetId());
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final List<String> getBoundDevice() {
        if (isDeviceAvailable()) {
            Set<BluetoothDevice> setBluetoothBondDevice = BluetoothBroadcast.INSTANCE.getInstance().bluetoothBondDevice();
            if (setBluetoothBondDevice == null) {
                return null;
            }
            Set<BluetoothDevice> set = setBluetoothBondDevice;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((BluetoothDevice) it.next()).getAddress());
            }
            return CollectionsKt.distinct(arrayList);
        }
        return new ArrayList();
    }

    private final boolean isDeviceAvailable() {
        return BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable() && BluetoothBroadcast.INSTANCE.getInstance().hasPermission();
    }

    public final void addWidget(WidgetItem widgetItem) {
        Intrinsics.checkNotNullParameter(widgetItem, "widgetItem");
        DatabaseUtils.INSTANCE.getWidgetDao().insertWidgetItem(widgetItem);
        AppBuriedPointUtils.reportUserData$default(AppBuriedPointUtils.INSTANCE, new EventParams(AppBuriedPointUtils.WIDGET_NEW_EVENT, "1", AppBuriedPointUtils.VALUE_TYPE_INT), false, 2, null);
        createTWSDevice(widgetItem);
    }

    public final boolean widgetTypeDevice(int widgetId) {
        boolean z = this.isNothing;
        if (!z || widgetId <= 10000) {
            return !z && widgetId < 10000;
        }
        return true;
    }

    private final void createTWSDevice(WidgetItem widgetItem) {
        IOTDevice andCreateIOTDevice = IOTDeviceManager.INSTANCE.getAndCreateIOTDevice(widgetItem.getAddress(), widgetItem.getModelID());
        TWSDevice twsDevice = andCreateIOTDevice != null ? andCreateIOTDevice.getTwsDevice() : null;
        if (twsDevice == null) {
            if (widgetTypeDevice(widgetItem.getAppWidgetId())) {
                this.widgetDataList.put(Integer.valueOf(widgetItem.getAppWidgetId()), initWidgetUIModel(widgetItem));
                if (this.deviceList.isEmpty()) {
                    return;
                }
                this.delegateInterface.createTWSDeviceIsNull(widgetItem);
                return;
            }
            return;
        }
        createTwsByWidgetItem(twsDevice, widgetItem);
    }

    private final void createTwsByWidgetItem(TWSDevice twsDevice, WidgetItem widgetItem) {
        String str;
        try {
            twsDevice.register(this);
            if (this.deviceList.get(widgetItem.getAddress()) == null) {
                this.deviceList.put(widgetItem.getAddress(), widgetItem.getAddress());
            }
            BaseWidgetUIModel baseWidgetUIModelInitWidgetUIModel = this.widgetDataList.get(Integer.valueOf(widgetItem.getAppWidgetId()));
            if (baseWidgetUIModelInitWidgetUIModel == null) {
                baseWidgetUIModelInitWidgetUIModel = initWidgetUIModel(widgetItem);
                this.widgetDataList.put(Integer.valueOf(widgetItem.getAppWidgetId()), baseWidgetUIModelInitWidgetUIModel);
            }
            Logger logger = Logger.INSTANCE;
            Logger logger2 = logger;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger2.isCanLogger(true) && "click connect event createTwsDevice".length() != 0) {
                Pair<String, String> trace = logger2.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                str = "format(...)";
                FileLog.print$default(fileLog, 3, str2, tag, "click connect event createTwsDevice " + strComponent2, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag + strComponent1, "click connect event createTwsDevice " + strComponent2);
                }
            } else {
                str = "format(...)";
            }
            baseWidgetUIModelInitWidgetUIModel.setConnectStatus(twsDevice.isConnected() ? 0 : 3);
            if (twsDevice.isConnected()) {
                sendBasicCommand(twsDevice, widgetItem.getAppWidgetId());
                return;
            }
            if (BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable() && BluetoothBroadcast.INSTANCE.getInstance().hasPermission()) {
                LogFeedback logFeedback = LogFeedback.INSTANCE;
                String address = twsDevice.getAddress();
                if (address == null) {
                    address = "";
                }
                logFeedback.addPoint(address, "Widget", "WIDGET_CONNECTED when created");
                Logger logger3 = Logger.INSTANCE;
                Logger logger4 = logger3;
                String tag2 = logger3.getTAG();
                int depth2 = logger3.getDepth();
                if (logger4.isCanLogger(true) && "createTwsByWidgetItem connect isWidgetAutoConnect is true".length() != 0) {
                    Pair<String, String> trace2 = logger4.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str3 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, str);
                    FileLog.print$default(fileLog2, 3, str3, tag2, "createTwsByWidgetItem connect isWidgetAutoConnect is true " + strComponent4, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag2 + strComponent3, "createTwsByWidgetItem connect isWidgetAutoConnect is true " + strComponent4);
                    }
                }
                TWSDevice.connect$default(twsDevice, true, null, null, 6, null);
                return;
            }
            ConcurrentHashMap<Integer, BaseWidgetUIModel> concurrentHashMap = this.widgetDataList;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, BaseWidgetUIModel> entry : concurrentHashMap.entrySet()) {
                if (Intrinsics.areEqual(entry.getValue().getDeviceAddress(), twsDevice.getAddress()) && widgetTypeDevice(entry.getKey().intValue())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                ((BaseWidgetUIModel) entry2.getValue()).setConnectStatus(3);
                this.delegateInterface.createTwsDeviceDisconnect(((Number) entry2.getKey()).intValue(), ((BaseWidgetUIModel) entry2.getValue()).getDeviceAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$updateWidget$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$updateWidget$1", f = "WidgetDeviceDelegate.kt", i = {}, l = {460}, m = "invokeSuspend", n = {}, s = {})
    static final class C10731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ int[] $widgetIds;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WidgetDeviceDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10731(int[] iArr, WidgetDeviceDelegate widgetDeviceDelegate, Context context, Continuation<? super C10731> continuation) {
            super(2, continuation);
            this.$widgetIds = iArr;
            this.this$0 = widgetDeviceDelegate;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10731 c10731 = new C10731(this.$widgetIds, this.this$0, this.$context, continuation);
            c10731.L$0 = obj;
            return c10731;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00b5  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Context context;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int[] iArr = this.$widgetIds;
                WidgetDeviceDelegate widgetDeviceDelegate = this.this$0;
                Context context2 = this.$context;
                for (int i2 : iArr) {
                    widgetDeviceDelegate.checkWidgetId(i2, context2);
                }
                if (this.this$0.getDeviceList().isEmpty()) {
                    this.this$0.getWidgetDataList().clear();
                    this.label = 1;
                    if (this.this$0.getAllDevice(this.$context, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    int[] iArr2 = this.$widgetIds;
                    WidgetDeviceDelegate widgetDeviceDelegate2 = this.this$0;
                    ArrayList arrayList = new ArrayList();
                    for (int i3 : iArr2) {
                        if (widgetDeviceDelegate2.widgetTypeDevice(i3)) {
                            arrayList.add(Boxing.boxInt(i3));
                        }
                    }
                    final WidgetDeviceDelegate widgetDeviceDelegate3 = this.this$0;
                    Context context3 = this.$context;
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        final int iIntValue = ((Number) it2.next()).intValue();
                        final BaseWidgetUIModel widgetUiModel = widgetDeviceDelegate3.getWidgetUiModel(iIntValue, context3);
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(z)) {
                            String str = "address:" + (widgetUiModel != null ? widgetUiModel.getDeviceAddress() : null) + ",modelId:" + (widgetUiModel != null ? widgetUiModel.getModelId() : null) + ",connectStatus:" + (widgetUiModel != null ? Boxing.boxInt(widgetUiModel.getConnectStatus()) : null);
                            String str2 = str;
                            if (str2 == null || str2.length() == 0) {
                                context = context3;
                                it = it2;
                            } else {
                                Pair<String, String> trace = logger.getTrace(depth);
                                String strComponent1 = trace.component1();
                                String strComponent2 = trace.component2();
                                FileLog fileLog = FileLog.INSTANCE;
                                String str3 = logger.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                context = context3;
                                it = it2;
                                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                if (logger.isDebug()) {
                                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                }
                            }
                        } else {
                            context = context3;
                            it = it2;
                        }
                        if (widgetUiModel == null) {
                            widgetDeviceDelegate3.delegateInterface.updateWidgetRemove(iIntValue);
                        } else {
                            WidgetDeviceDelegate.getTwsDevice$default(widgetDeviceDelegate3, widgetUiModel, iIntValue, false, new Function0() { // from class: com.nothing.smart.widgets.WidgetDeviceDelegate$updateWidget$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return WidgetDeviceDelegate.C10731.invokeSuspend$lambda$6$lambda$5(widgetDeviceDelegate3, widgetUiModel, iIntValue);
                                }
                            }, 4, null);
                        }
                        it2 = it;
                        context3 = context;
                        z = true;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.dataClear(this.$widgetIds, this.$context);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$6$lambda$5(WidgetDeviceDelegate widgetDeviceDelegate, BaseWidgetUIModel baseWidgetUIModel, int i) {
            IOTDevice iOTDeviceByMacAddress;
            TWSDevice twsDevice;
            String str = widgetDeviceDelegate.getDeviceList().get(baseWidgetUIModel.getDeviceAddress());
            if (str != null && (iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(str)) != null && (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) != null) {
                widgetDeviceDelegate.sendBasicCommand(twsDevice, i);
            }
            return Unit.INSTANCE;
        }
    }

    public final synchronized void updateWidget(Context context, int[] widgetIds) {
        Intrinsics.checkNotNullParameter(widgetIds, "widgetIds");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C10731(widgetIds, this, context, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:13:0x0037  */
    public final void dataClear(int[] widgetIds, Context context) {
        int[] appWidgetIds;
        String str;
        CardWidgetManager companion;
        if (widgetIds.length == 0) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            if (appWidgetManager != null) {
                appWidgetIds = appWidgetManager.getAppWidgetIds(context != null ? new ComponentName(context, (Class<?>) EarWidgets.class) : null);
            } else {
                appWidgetIds = null;
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "googleWidgetIds:" + (appWidgetIds != null ? Integer.valueOf(appWidgetIds.length) : null);
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    str = StringUtils.SPACE;
                } else {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    String str5 = str2 + StringUtils.SPACE + strComponent2;
                    str = StringUtils.SPACE;
                    FileLog.print$default(fileLog, 3, str4, tag, str5, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + str + strComponent2);
                    }
                }
            } else {
                str = StringUtils.SPACE;
            }
            if (appWidgetIds != null) {
                for (int i : appWidgetIds) {
                    deviceEmptyCheckIsClearData(context, i);
                }
            }
            if (NothingOSUtil.INSTANCE.isNothingOS()) {
                int[] appWidgetIds2 = (context == null || (companion = CardWidgetManager.INSTANCE.getInstance(context)) == null) ? null : companion.getAppWidgetIds(new ComponentName(context.getPackageName(), "com.nothing.smart.widgets.nothing.NothingEarWidgetProvider"));
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str6 = "nothingWidgetIds:" + (appWidgetIds2 != null ? Integer.valueOf(appWidgetIds2.length) : null);
                    String str7 = str6;
                    if (str7 != null && str7.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str8 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                        FileLog.print$default(fileLog2, 3, str8, tag2, str6 + str + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str6 + str + strComponent4);
                        }
                    }
                }
                if (appWidgetIds2 != null) {
                    for (int i2 : appWidgetIds2) {
                        deviceEmptyCheckIsClearData(context, i2 + 10000);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 : widgetIds) {
            if (widgetTypeDevice(i3)) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            deviceEmptyCheckIsClearData(context, ((Number) it.next()).intValue());
        }
    }

    public static /* synthetic */ void getTwsDevice$default(WidgetDeviceDelegate widgetDeviceDelegate, BaseWidgetUIModel baseWidgetUIModel, int i, boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        widgetDeviceDelegate.getTwsDevice(baseWidgetUIModel, i, z, function0);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00d1  */
    public final void getTwsDevice(BaseWidgetUIModel widgetUIData, int widgetId, boolean isAutoConnect, Function0<Unit> createDeviceAction) {
        String str;
        Intrinsics.checkNotNullParameter(widgetUIData, "widgetUIData");
        Intrinsics.checkNotNullParameter(createDeviceAction, "createDeviceAction");
        if (widgetUIData.getDeviceAddress().length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "getTwsDevice return address:null".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str2 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog, 3, str2, tag, "getTwsDevice return address:null " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "getTwsDevice return address:null " + strComponent2);
                    return;
                }
                return;
            }
            return;
        }
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.deviceList.get(widgetUIData.getDeviceAddress()));
        TWSDevice twsDevice = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null;
        if (twsDevice != null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str3 = "sure twsDevice is same Widget TwsDevice:" + twsDevice;
                String str4 = str3;
                if (str4 == null || str4.length() == 0) {
                    str = StringUtils.SPACE;
                } else {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str5 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    String str6 = str3 + StringUtils.SPACE + strComponent4;
                    str = StringUtils.SPACE;
                    FileLog.print$default(fileLog2, 3, str5, tag2, str6, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str3 + str + strComponent4);
                    }
                }
            } else {
                str = StringUtils.SPACE;
            }
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "click connect event twsDevice not null ".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str7 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                FileLog.print$default(fileLog3, 3, str7, tag3, "click connect event twsDevice not null  " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, "click connect event twsDevice not null  " + strComponent6);
                }
            }
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true)) {
                String str8 = "widget register callback:" + this;
                String str9 = str8;
                if (str9 != null && str9.length() != 0) {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str10 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    FileLog.print$default(fileLog4, 3, str10, tag4, str8 + str + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag4 + strComponent7, str8 + str + strComponent8);
                    }
                }
            }
            twsDevice.register(this);
            if (!twsDevice.isConnected()) {
                Logger logger5 = Logger.INSTANCE;
                String tag5 = logger5.getTAG();
                int depth5 = logger5.getDepth();
                if (logger5.isCanLogger(true)) {
                    String str11 = "getTwsDevice connect isWidgetAutoConnect:" + isAutoConnect;
                    String str12 = str11;
                    if (str12 != null && str12.length() != 0) {
                        Pair<String, String> trace5 = logger5.getTrace(depth5);
                        String strComponent9 = trace5.component1();
                        String strComponent10 = trace5.component2();
                        FileLog fileLog5 = FileLog.INSTANCE;
                        String str13 = logger5.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                        FileLog.print$default(fileLog5, 3, str13, tag5, str11 + str + strComponent10, null, 16, null);
                        if (logger5.isDebug()) {
                            Log.i(tag5 + strComponent9, str11 + str + strComponent10);
                        }
                    }
                }
                TWSDevice.connect$default(twsDevice, isAutoConnect, null, null, 6, null);
            }
            createDeviceAction.invoke();
            return;
        }
        Logger logger6 = Logger.INSTANCE;
        String tag6 = logger6.getTAG();
        int depth6 = logger6.getDepth();
        if (logger6.isCanLogger(true) && "click connect event twsDevice is null".length() != 0) {
            Pair<String, String> trace6 = logger6.getTrace(depth6);
            String strComponent11 = trace6.component1();
            String strComponent12 = trace6.component2();
            FileLog fileLog6 = FileLog.INSTANCE;
            String str14 = logger6.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
            FileLog.print$default(fileLog6, 3, str14, tag6, "click connect event twsDevice is null " + strComponent12, null, 16, null);
            if (logger6.isDebug()) {
                Log.i(tag6 + strComponent11, "click connect event twsDevice is null " + strComponent12);
            }
        }
        if (BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable() && BluetoothBroadcast.INSTANCE.getInstance().hasPermission()) {
            BluetoothDevice bluetoothDevice = SPPConnect.INSTANCE.getInstance().getBluetoothDevice(widgetUIData.getDeviceAddress());
            if (bluetoothDevice != null && BluetoothDeviceExtKt.isBondedState(bluetoothDevice)) {
                createTWSDevice(widgetUIData.createWidgetItem());
                createDeviceAction.invoke();
                return;
            } else {
                DatabaseUtils.INSTANCE.getWidgetDao().deleteWidgetItem(widgetId);
                this.widgetDataList.remove(Integer.valueOf(widgetId));
                this.delegateInterface.getTwsDeviceDeviceRemove(widgetId);
                return;
            }
        }
        this.delegateInterface.getTwsDeviceSystemSwitchOrPermissionOff(widgetId, widgetUIData.getDeviceAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkWidgetId(int widgetId, Context context) {
        Object next;
        if (this.widgetDataList.get(Integer.valueOf(widgetId)) == null) {
            Iterator<T> it = getSqliteWidgetItem(context).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((WidgetItem) next).getAppWidgetId() != widgetId);
            WidgetItem widgetItem = (WidgetItem) next;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "address:" + (widgetItem != null ? widgetItem.getAddress() : null) + ",modelId:" + (widgetItem != null ? widgetItem.getModelID() : null) + ",widgetId:" + widgetId;
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
            if (widgetItem == null) {
                this.delegateInterface.updateWidgetRemove(widgetId);
            } else {
                this.widgetDataList.put(Integer.valueOf(widgetId), initWidgetUIModel(widgetItem));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseWidgetUIModel getWidgetUiModel(int it, Context context) {
        Object next;
        if (this.widgetDataList.get(Integer.valueOf(it)) != null) {
            return this.widgetDataList.get(Integer.valueOf(it));
        }
        Iterator<T> it2 = getSqliteWidgetItem(context).iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (((WidgetItem) next).getAppWidgetId() != it);
        WidgetItem widgetItem = (WidgetItem) next;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "sqlite address:" + (widgetItem != null ? widgetItem.getAddress() : null) + ",modelId:" + (widgetItem != null ? widgetItem.getModelID() : null) + ",widgetId:" + it;
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
        if (widgetItem != null) {
            this.widgetDataList.put(Integer.valueOf(it), initWidgetUIModel(widgetItem));
        }
        return this.widgetDataList.get(Integer.valueOf(it));
    }

    public final BaseWidgetUIModel initWidgetUIModel(WidgetItem widgetItem) {
        Intrinsics.checkNotNullParameter(widgetItem, "widgetItem");
        return new BaseWidgetUIModel(widgetItem.getAppWidgetId(), widgetItem.getWidgetTheme(), widgetItem.getAddress(), widgetItem.getModelID());
    }

    public final void connectDevice(Context context, int widgetId, String address) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "click connect event widgetId=" + widgetId + ",address:" + address;
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
        if (!BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable()) {
            this.delegateInterface.getAllDeviceSystemSwitchOrPermissionOff(widgetId, address == null ? "" : address);
            Unit unit = Unit.INSTANCE;
            return;
        }
        if (this.deviceList.isEmpty()) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "click connect event deviceList is empty".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 3, str4, tag2, "click connect event deviceList is empty " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "click connect event deviceList is empty " + strComponent4);
                }
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass3(context, address, widgetId, null), 3, null);
            return;
        }
        String str5 = address;
        if (str5 == null || str5.length() == 0) {
            BaseWidgetUIModel widgetUiModel = getWidgetUiModel(widgetId, context);
            if (widgetUiModel != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass4(widgetUiModel, widgetId, null), 3, null);
                return;
            } else {
                this.delegateInterface.connectActionWidgetRemove(widgetId);
                Unit unit2 = Unit.INSTANCE;
                return;
            }
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true) && "click connect event widget connect".length() != 0) {
            Pair<String, String> trace3 = logger3.getTrace(depth3);
            String strComponent5 = trace3.component1();
            String strComponent6 = trace3.component2();
            FileLog fileLog3 = FileLog.INSTANCE;
            String str6 = logger3.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            FileLog.print$default(fileLog3, 3, str6, tag3, "click connect event widget connect " + strComponent6, null, 16, null);
            if (logger3.isDebug()) {
                Log.i(tag3 + strComponent5, "click connect event widget connect " + strComponent6);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass6(address, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$connectDevice$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$connectDevice$3", f = "WidgetDeviceDelegate.kt", i = {0}, l = {654}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $widgetId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Context context, String str, int i, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$address = str;
            this.$widgetId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = WidgetDeviceDelegate.this.new AnonymousClass3(this.$context, this.$address, this.$widgetId, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                WidgetDeviceDelegate.this.getWidgetDataList().clear();
                this.L$0 = coroutineScope;
                this.label = 1;
                if (WidgetDeviceDelegate.this.getAllDevice(this.$context, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            String str = this.$address;
            if (str != null && str.length() != 0) {
                List<WidgetItem> sqliteWidgetItem = WidgetDeviceDelegate.this.getSqliteWidgetItem(this.$context);
                int i2 = this.$widgetId;
                Iterator<T> it = sqliteWidgetItem.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (((WidgetItem) next).getAppWidgetId() != i2);
                WidgetItem widgetItem = (WidgetItem) next;
                if (widgetItem != null && Intrinsics.areEqual(widgetItem.getAddress(), this.$address)) {
                    BaseWidgetUIModel baseWidgetUIModelInitWidgetUIModel = WidgetDeviceDelegate.this.initWidgetUIModel(widgetItem);
                    WidgetDeviceDelegate.this.getWidgetDataList().put(Boxing.boxInt(this.$widgetId), baseWidgetUIModelInitWidgetUIModel);
                    ConcurrentHashMap<String, String> deviceList = WidgetDeviceDelegate.this.getDeviceList();
                    String str2 = this.$address;
                    deviceList.put(str2, str2);
                    Logger logger = Logger.INSTANCE;
                    String str3 = this.$address;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str4 = "click connect event after getAllDevice, show connecting for address:" + str3;
                        String str5 = str4;
                        if (str5 != null && str5.length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str6 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                            FileLog.print$default(fileLog, 3, str6, tag, str4 + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag + strComponent1, str4 + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    WidgetDeviceDelegate.this.checkIsNeedConnectAnimal(baseWidgetUIModelInitWidgetUIModel, this.$widgetId);
                    return Unit.INSTANCE;
                }
            }
            WidgetDeviceDelegate.this.deviceEmptyCheckIsClearData(this.$context, this.$widgetId);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$connectDevice$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$connectDevice$4", f = "WidgetDeviceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $widgetId;
        final /* synthetic */ BaseWidgetUIModel $widgetUIData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(BaseWidgetUIModel baseWidgetUIModel, int i, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$widgetUIData = baseWidgetUIModel;
            this.$widgetId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = WidgetDeviceDelegate.this.new AnonymousClass4(this.$widgetUIData, this.$widgetId, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "connect device getTwsDevice".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "connect device getTwsDevice " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "connect device getTwsDevice " + strComponent2);
                }
            }
            WidgetDeviceDelegate.this.getTwsDevice(this.$widgetUIData, this.$widgetId, true, new Function0() { // from class: com.nothing.smart.widgets.WidgetDeviceDelegate$connectDevice$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$connectDevice$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$connectDevice$6", f = "WidgetDeviceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(String str, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$address = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass6 anonymousClass6 = WidgetDeviceDelegate.this.new AnonymousClass6(this.$address, continuation);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ConcurrentHashMap<Integer, BaseWidgetUIModel> widgetDataList = WidgetDeviceDelegate.this.getWidgetDataList();
            String str = this.$address;
            WidgetDeviceDelegate widgetDeviceDelegate = WidgetDeviceDelegate.this;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, BaseWidgetUIModel> entry : widgetDataList.entrySet()) {
                if (Intrinsics.areEqual(entry.getValue().getDeviceAddress(), str) && widgetDeviceDelegate.widgetTypeDevice(entry.getKey().intValue())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            WidgetDeviceDelegate widgetDeviceDelegate2 = WidgetDeviceDelegate.this;
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "connect device checkIsNeedConnectAnimal".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str2 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    FileLog.print$default(fileLog, 3, str2, tag, "connect device checkIsNeedConnectAnimal " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "connect device checkIsNeedConnectAnimal " + strComponent2);
                    }
                }
                widgetDeviceDelegate2.checkIsNeedConnectAnimal((BaseWidgetUIModel) entry2.getValue(), ((Number) entry2.getKey()).intValue());
            }
            return Unit.INSTANCE;
        }
    }

    public final void sendNoiseLevel(Context context, int widgetId) {
        if (!BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable()) {
            this.delegateInterface.getAllDeviceSystemSwitchOrPermissionOff(widgetId, "");
            return;
        }
        if (this.deviceList.isEmpty()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "click noise event deviceList is empty".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "click noise event deviceList is empty " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "click noise event deviceList is empty " + strComponent2);
                }
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(context, widgetId, null), 3, null);
            return;
        }
        BaseWidgetUIModel widgetUiModel = getWidgetUiModel(widgetId, context);
        if (widgetUiModel != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C10723(widgetUiModel, widgetId, null), 3, null);
        } else {
            this.delegateInterface.noiseActionWidgetRemove(widgetId);
        }
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$sendNoiseLevel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$sendNoiseLevel$2", f = "WidgetDeviceDelegate.kt", i = {}, l = {712}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ int $widgetId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$widgetId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WidgetDeviceDelegate.this.new AnonymousClass2(this.$context, this.$widgetId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WidgetDeviceDelegate.this.getWidgetDataList().clear();
                this.label = 1;
                if (WidgetDeviceDelegate.this.getAllDevice(this.$context, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            WidgetDeviceDelegate.this.deviceEmptyCheckIsClearData(this.$context, this.$widgetId);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$sendNoiseLevel$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$sendNoiseLevel$3", f = "WidgetDeviceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10723 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $widgetId;
        final /* synthetic */ BaseWidgetUIModel $widgetUIData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10723(BaseWidgetUIModel baseWidgetUIModel, int i, Continuation<? super C10723> continuation) {
            super(2, continuation);
            this.$widgetUIData = baseWidgetUIModel;
            this.$widgetId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WidgetDeviceDelegate.this.new C10723(this.$widgetUIData, this.$widgetId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10723) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            final WidgetDeviceDelegate widgetDeviceDelegate = WidgetDeviceDelegate.this;
            final BaseWidgetUIModel baseWidgetUIModel = this.$widgetUIData;
            widgetDeviceDelegate.getTwsDevice(baseWidgetUIModel, this.$widgetId, false, new Function0() { // from class: com.nothing.smart.widgets.WidgetDeviceDelegate$sendNoiseLevel$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WidgetDeviceDelegate.C10723.invokeSuspend$lambda$0(widgetDeviceDelegate, baseWidgetUIModel);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(WidgetDeviceDelegate widgetDeviceDelegate, BaseWidgetUIModel baseWidgetUIModel) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WidgetDeviceDelegate$sendNoiseLevel$3$1$1(widgetDeviceDelegate, baseWidgetUIModel, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deviceEmptyCheckIsClearData(Context context, int widgetId) {
        if (this.deviceList.isEmpty()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "deviceList is empty deviceEmptyCheckIsClearData".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "deviceList is empty deviceEmptyCheckIsClearData " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "deviceList is empty deviceEmptyCheckIsClearData " + strComponent2);
                }
            }
            this.delegateInterface.updateWidgetClearData(context, widgetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deviceNoiseBuriedPoint(int noiseModel, String address) {
        String str;
        if (noiseModel == 0 || noiseModel == 5) {
            str = "2";
        } else if (noiseModel == 7 || noiseModel == 254) {
            str = "1";
        } else {
            str = "0";
        }
        AppBuriedPointUtils.reportUserData$default(AppBuriedPointUtils.INSTANCE, new EventParams(AppBuriedPointUtils.WIDGET_MODE_EVENT, str, AppBuriedPointUtils.VALUE_TYPE_INT), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIsNeedConnectAnimal(final BaseWidgetUIModel widgetUIModel, int widgetId) {
        getTwsDevice(widgetUIModel, widgetId, false, new Function0() { // from class: com.nothing.smart.widgets.WidgetDeviceDelegate$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WidgetDeviceDelegate.checkIsNeedConnectAnimal$lambda$48(this.f$0, widgetUIModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkIsNeedConnectAnimal$lambda$48(WidgetDeviceDelegate widgetDeviceDelegate, BaseWidgetUIModel baseWidgetUIModel) {
        String str = widgetDeviceDelegate.deviceList.get(baseWidgetUIModel.getDeviceAddress());
        if (str != null) {
            IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(str);
            TWSDevice twsDevice = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null;
            if (twsDevice != null) {
                widgetDeviceDelegate.connectFlow(twsDevice);
            }
        }
        return Unit.INSTANCE;
    }

    private final void connectFlow(TWSDevice twsDevice) {
        String address = twsDevice.getAddress();
        if (address == null) {
            address = "";
        }
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new WidgetDeviceDelegate$connectFlow$currentJob$1(twsDevice, this, address, null), 3, null);
        Job jobRemove = this.connectFlowJob.remove(address);
        if (jobRemove != null) {
            Job.DefaultImpls.cancel$default(jobRemove, (CancellationException) null, 1, (Object) null);
        }
        this.connectFlowJob.put(address, jobLaunch$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setWidgetAnimator(int it, Map.Entry<Integer, BaseWidgetUIModel> item) {
        if (it == 1) {
            item.getValue().setNeedFailAnimator(true);
        }
        if (it == 3) {
            item.getValue().setNeedFailAnimator(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendBasicCommand(TWSDevice twsDevice, int widgetId) {
        IOTDevice iotDevice;
        TWSDevice.sendCommands$default(twsDevice, new int[]{49159}, false, false, 6, null);
        BaseWidgetUIModel baseWidgetUIModel = this.widgetDataList.get(Integer.valueOf(widgetId));
        if (baseWidgetUIModel == null || (iotDevice = baseWidgetUIModel.getIotDevice()) == null || !iotDevice.isSupportAnc(iotDevice.getMacAddress())) {
            return;
        }
        twsDevice.getCurrentAnc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getNoiseModel(BaseWidgetUIModel widgetUIModel) {
        IOTDevice infoByModelId = IOTDeviceManager.INSTANCE.getInfoByModelId(widgetUIModel.getModelId());
        if (infoByModelId != null && !infoByModelId.isSupportPassThrough()) {
            int noiseModel = widgetUIModel.getNoiseModel();
            return (noiseModel == 0 || noiseModel == 5) ? 1 : 5;
        }
        int noiseModel2 = widgetUIModel.getNoiseModel();
        if (noiseModel2 == 0 || noiseModel2 == 5) {
            return 1;
        }
        return (noiseModel2 == 7 || noiseModel2 == 254) ? 5 : 7;
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$gotoApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$gotoApp$1", f = "WidgetDeviceDelegate.kt", i = {}, l = {955}, m = "invokeSuspend", n = {}, s = {})
    static final class C10701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ int $widgetId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10701(Context context, int i, Continuation<? super C10701> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$widgetId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10701 c10701 = WidgetDeviceDelegate.this.new C10701(this.$context, this.$widgetId, continuation);
            c10701.L$0 = obj;
            return c10701;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!WidgetDeviceDelegate.this.getDeviceList().isEmpty()) {
                    this.label = 1;
                    if (WidgetDeviceDelegate.this.selectDeviceToHome(this.$context, this.$widgetId, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true) && "click noise event deviceList is empty".length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        FileLog.print$default(fileLog, 3, str, tag, "click noise event deviceList is empty " + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, "click noise event deviceList is empty " + strComponent2);
                        }
                    }
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(WidgetDeviceDelegate.this, this.$context, this.$widgetId, null), 3, null);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$gotoApp$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$gotoApp$1$2", f = "WidgetDeviceDelegate.kt", i = {}, l = {948, 951}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ int $widgetId;
            int label;
            final /* synthetic */ WidgetDeviceDelegate this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(WidgetDeviceDelegate widgetDeviceDelegate, Context context, int i, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = widgetDeviceDelegate;
                this.$context = context;
                this.$widgetId = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$context, this.$widgetId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
            
                if (r5.this$0.selectDeviceToHome(r5.$context, r5.$widgetId, r5) == r0) goto L17;
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
                    this.this$0.getWidgetDataList().clear();
                    this.label = 1;
                    if (this.this$0.getAllDevice(this.$context, this) != coroutine_suspended) {
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
                this.this$0.deviceEmptyCheckIsClearData(this.$context, this.$widgetId);
                if (!this.this$0.getDeviceList().isEmpty()) {
                    this.label = 2;
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void gotoApp(Context context, int widgetId) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C10701(context, widgetId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object selectDeviceToHome(Context context, int i, Continuation<? super Unit> continuation) {
        BaseWidgetUIModel widgetUiModel = getWidgetUiModel(i, context);
        if (widgetUiModel == null) {
            return Unit.INSTANCE;
        }
        SpUtils.INSTANCE.setSelectDeviceMac(widgetUiModel.getDeviceAddress());
        SpUtils.INSTANCE.setCurrentModel(widgetUiModel.getModelId());
        IOTDeviceManager.INSTANCE.getAndCreateIOTDevice(SpUtils.INSTANCE.getSelectDeviceMac(), SpUtils.INSTANCE.getCurrentModel());
        if (NothingOSUtil.INSTANCE.isCantOpenApp()) {
            if (context != null) {
                Boxing.boxBoolean(RouterFactory.INSTANCE.getOsRouter().startToDeviceDetail(context));
            }
            return Unit.INSTANCE;
        }
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C10713(widgetUiModel, context, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$selectDeviceToHome$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$selectDeviceToHome$3", f = "WidgetDeviceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10713 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ BaseWidgetUIModel $widgetUIData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10713(BaseWidgetUIModel baseWidgetUIModel, Context context, Continuation<? super C10713> continuation) {
            super(2, continuation);
            this.$widgetUIData = baseWidgetUIModel;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10713(this.$widgetUIData, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10713) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Bundle bundle = new Bundle();
            bundle.putString("GOTO_HOME_DEVICE_ADDRESS", this.$widgetUIData.getDeviceAddress());
            bundle.putString(FlutterRouterManager.GOTO_HOME_DEVICE_MODEL, this.$widgetUIData.getModelId());
            bundle.putInt("source", 1);
            bundle.putInt("routeIndex", FlutterRoute.DEVICE_TRANSITION.getRaw());
            bundle.putBoolean(FlutterRouterManager.ROUTE_REPLACE, true);
            bundle.putBoolean(FlutterRouterManager.SELECT_DEVICE, true);
            FlutterRouterManager.toFlutterHomePage$default(FlutterRouterManager.INSTANCE.get(), this.$context, bundle, false, false, null, false, 60, null);
            return Unit.INSTANCE;
        }
    }

    private final Pair<Boolean, Map<Integer, BaseWidgetUIModel>> isNotHasWidgetData(TWSDevice twsDevice) {
        ConcurrentHashMap<Integer, BaseWidgetUIModel> concurrentHashMap = this.widgetDataList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Integer, BaseWidgetUIModel> entry : concurrentHashMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue().getDeviceAddress(), twsDevice.getAddress()) && widgetTypeDevice(entry.getKey().intValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return TuplesKt.to(Boolean.valueOf(linkedHashMap.isEmpty()), linkedHashMap);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected(TWSDevice twsDevice) {
        Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
        Pair<Boolean, Map<Integer, BaseWidgetUIModel>> pairIsNotHasWidgetData = isNotHasWidgetData(twsDevice);
        if (pairIsNotHasWidgetData.getFirst().booleanValue()) {
            return;
        }
        Job job = (Job) TypeIntrinsics.asMutableMap(this.connectFlowJob).remove(twsDevice.getAddress());
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        int iIntValue = 0;
        for (Map.Entry<Integer, BaseWidgetUIModel> entry : pairIsNotHasWidgetData.getSecond().entrySet()) {
            entry.getValue().setNeedFailAnimator(false);
            if (iIntValue == 0) {
                iIntValue = entry.getKey().intValue();
                sendBasicCommand(twsDevice, iIntValue);
            }
        }
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected(TWSDevice twsDevice) {
        Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
        Pair<Boolean, Map<Integer, BaseWidgetUIModel>> pairIsNotHasWidgetData = isNotHasWidgetData(twsDevice);
        BaseWidgetUIModel baseWidgetUIModel = (BaseWidgetUIModel) CollectionsKt.firstOrNull(pairIsNotHasWidgetData.getSecond().values());
        Integer numValueOf = baseWidgetUIModel != null ? Integer.valueOf(baseWidgetUIModel.getConnectStatus()) : null;
        Boolean boolValueOf = baseWidgetUIModel != null ? Boolean.valueOf(baseWidgetUIModel.getIsNeedFailAnimator()) : null;
        if (pairIsNotHasWidgetData.getFirst().booleanValue()) {
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            return;
        }
        Job job = this.connectFlowJob.get(twsDevice.getAddress());
        if (job != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "lastJob is not null need lastJob cancel".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "lastJob is not null need lastJob cancel " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "lastJob is not null need lastJob cancel " + strComponent2);
                }
            }
            String address = twsDevice.getAddress();
            String str2 = address != null ? address : "";
            List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(str2);
            DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
            if (!BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable()) {
                this.connectFlowJob.remove(str2);
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                for (Map.Entry<Integer, BaseWidgetUIModel> entry : pairIsNotHasWidgetData.getSecond().entrySet()) {
                    entry.getValue().setConnectStatus(3);
                    this.delegateInterface.deviceCallbackDisconnect(entry.getKey().intValue(), str2, 3);
                }
                return;
            }
            if (deviceItem2 == null) {
                this.connectFlowJob.remove(str2);
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                for (Map.Entry<Integer, BaseWidgetUIModel> entry2 : pairIsNotHasWidgetData.getSecond().entrySet()) {
                    DatabaseUtils.INSTANCE.getWidgetDao().deleteWidgetItem(entry2.getKey().intValue());
                    this.widgetDataList.remove(entry2.getKey());
                    this.delegateInterface.deviceCallbackDisconnectDeviceRemove(entry2.getKey().intValue(), str2);
                }
                return;
            }
            Object obj = null;
            Map<Integer, BaseWidgetUIModel> second = pairIsNotHasWidgetData.getSecond();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, BaseWidgetUIModel> entry3 : second.entrySet()) {
                if (entry3.getValue().isDisconnected()) {
                    linkedHashMap.put(entry3.getKey(), entry3.getValue());
                }
            }
            for (Object obj2 : pairIsNotHasWidgetData.getSecond().values()) {
                if (!((BaseWidgetUIModel) obj2).isDisconnected()) {
                    obj = obj2;
                    break;
                }
            }
            BaseWidgetUIModel baseWidgetUIModel2 = (BaseWidgetUIModel) obj;
            int connectStatus = baseWidgetUIModel2 != null ? baseWidgetUIModel2.getConnectStatus() : 3;
            for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                ((BaseWidgetUIModel) entry4.getValue()).setConnectStatus(connectStatus);
                this.delegateInterface.connectFlowDeviceState(((Number) entry4.getKey()).intValue(), str2);
            }
            return;
        }
        String address2 = twsDevice.getAddress();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass5(twsDevice, pairIsNotHasWidgetData, boolValueOf, this, address2 == null ? "" : address2, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.smart.widgets.WidgetDeviceDelegate$onDisconnected$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$onDisconnected$5", f = "WidgetDeviceDelegate.kt", i = {0}, l = {1073, 1101, 1121}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        final /* synthetic */ Boolean $isNeedAnimal;
        final /* synthetic */ TWSDevice $twsDevice;
        final /* synthetic */ Pair<Boolean, Map<Integer, BaseWidgetUIModel>> $widgetDataPair;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WidgetDeviceDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(TWSDevice tWSDevice, Pair<Boolean, ? extends Map<Integer, BaseWidgetUIModel>> pair, Boolean bool, WidgetDeviceDelegate widgetDeviceDelegate, String str, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$twsDevice = tWSDevice;
            this.$widgetDataPair = pair;
            this.$isNeedAnimal = bool;
            this.this$0 = widgetDeviceDelegate;
            this.$deviceAddress = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$twsDevice, this.$widgetDataPair, this.$isNeedAnimal, this.this$0, this.$deviceAddress, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:58:0x0279, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(2000, r20) == r1) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x035f, code lost:
        
            if (r20.this$0.updateWidgetWithNoAnimation(r20.$widgetDataPair, r20.$deviceAddress, r20.$twsDevice, r20) == r1) goto L80;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean zIsBondedState = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Logger logger = Logger.INSTANCE;
                Pair<Boolean, Map<Integer, BaseWidgetUIModel>> pair = this.$widgetDataPair;
                Logger logger2 = logger;
                String tag = logger2.getTAG();
                int depth = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str = "DeviceDelegateInterface callback onDisconnected device list size=" + pair.getSecond().size();
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger2.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(800L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                if (BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable() && BluetoothBroadcast.INSTANCE.getInstance().hasPermission()) {
                    zIsBondedState = BluetoothDeviceExtKt.isBondedState(this.$twsDevice.getDevice());
                }
                Map<Integer, BaseWidgetUIModel> second = this.$widgetDataPair.getSecond();
                WidgetDeviceDelegate widgetDeviceDelegate = this.this$0;
                String str4 = this.$deviceAddress;
                for (Map.Entry<Integer, BaseWidgetUIModel> entry : second.entrySet()) {
                    widgetDeviceDelegate.updateWidgetDataPairStatus(zIsBondedState, entry, str4, entry.getValue().getConnectStatus());
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            DeviceItemDao deviceDao = DatabaseUtils.INSTANCE.getDeviceDao();
            String address = this.$twsDevice.getAddress();
            if (address == null) {
                address = "";
            }
            List<DeviceItem> deviceItem = deviceDao.getDeviceItem(address);
            if ((deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null) == null) {
                Logger logger3 = Logger.INSTANCE;
                Pair<Boolean, Map<Integer, BaseWidgetUIModel>> pair2 = this.$widgetDataPair;
                Logger logger4 = logger3;
                String tag2 = logger4.getTAG();
                int depth2 = logger4.getDepth();
                if (logger4.isCanLogger(true)) {
                    String str5 = "DeviceDelegateInterface callback onDisconnected device is null widgetId:" + CollectionsKt.first(pair2.getSecond().keySet());
                    String str6 = str5;
                    if (str6 != null && str6.length() != 0) {
                        Pair<String, String> trace2 = logger4.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str7 = logger4.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        FileLog.print$default(fileLog2, 3, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger4.isDebug()) {
                            Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                Map<Integer, BaseWidgetUIModel> second2 = this.$widgetDataPair.getSecond();
                WidgetDeviceDelegate widgetDeviceDelegate2 = this.this$0;
                String str8 = this.$deviceAddress;
                for (Map.Entry<Integer, BaseWidgetUIModel> entry2 : second2.entrySet()) {
                    DatabaseUtils.INSTANCE.getWidgetDao().deleteWidgetItem(entry2.getKey().intValue());
                    widgetDeviceDelegate2.getWidgetDataList().remove(entry2.getKey());
                    widgetDeviceDelegate2.delegateInterface.deviceCallbackDisconnectDeviceRemove(entry2.getKey().intValue(), str8);
                }
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(this.$isNeedAnimal, Boxing.boxBoolean(true))) {
                Map<Integer, BaseWidgetUIModel> second3 = this.$widgetDataPair.getSecond();
                WidgetDeviceDelegate widgetDeviceDelegate3 = this.this$0;
                String str9 = this.$deviceAddress;
                for (Map.Entry<Integer, BaseWidgetUIModel> entry3 : second3.entrySet()) {
                    entry3.getValue().setConnectStatus(2);
                    widgetDeviceDelegate3.delegateInterface.deviceCallbackDisconnect(entry3.getKey().intValue(), str9, 2);
                }
                this.L$0 = null;
                this.label = 2;
            } else {
                Logger logger5 = Logger.INSTANCE;
                String tag3 = logger5.getTAG();
                int depth3 = logger5.getDepth();
                if (logger5.isCanLogger(true) && "DeviceDelegateInterface callback onDisconnected device not null".length() != 0) {
                    Pair<String, String> trace3 = logger5.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str10 = logger5.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    FileLog.print$default(fileLog3, 3, str10, tag3, "DeviceDelegateInterface callback onDisconnected device not null " + strComponent6, null, 16, null);
                    if (logger5.isDebug()) {
                        Log.i(tag3 + strComponent5, "DeviceDelegateInterface callback onDisconnected device not null " + strComponent6);
                    }
                }
                this.L$0 = null;
                this.label = 3;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateWidgetWithNoAnimation(Pair<Boolean, ? extends Map<Integer, BaseWidgetUIModel>> pair, String str, TWSDevice tWSDevice, Continuation<? super Unit> continuation) {
        C10741 c10741;
        WidgetDeviceDelegate widgetDeviceDelegate;
        if (continuation instanceof C10741) {
            c10741 = (C10741) continuation;
            if ((c10741.label & Integer.MIN_VALUE) != 0) {
                c10741.label -= Integer.MIN_VALUE;
            } else {
                c10741 = new C10741(continuation);
            }
        } else {
            c10741 = new C10741(continuation);
        }
        Object obj = c10741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10741.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            for (Map.Entry<Integer, BaseWidgetUIModel> entry : pair.getSecond().entrySet()) {
                entry.getValue().setConnectStatus(3);
                this.delegateInterface.deviceCallbackDisconnect(entry.getKey().intValue(), str, 3);
            }
            c10741.L$0 = this;
            c10741.L$1 = pair;
            c10741.L$2 = str;
            c10741.L$3 = tWSDevice;
            c10741.label = 1;
            if (DelayKt.delay(2000L, c10741) == coroutine_suspended) {
                return coroutine_suspended;
            }
            widgetDeviceDelegate = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            tWSDevice = (TWSDevice) c10741.L$3;
            str = (String) c10741.L$2;
            pair = (Pair) c10741.L$1;
            widgetDeviceDelegate = (WidgetDeviceDelegate) c10741.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable() && BluetoothBroadcast.INSTANCE.getInstance().hasPermission() && !BluetoothDeviceExtKt.isBondedState(tWSDevice.getDevice())) {
            for (Map.Entry<Integer, BaseWidgetUIModel> entry2 : pair.getSecond().entrySet()) {
                DatabaseUtils.INSTANCE.getWidgetDao().deleteWidgetItem(entry2.getKey().intValue());
                widgetDeviceDelegate.widgetDataList.remove(entry2.getKey());
                widgetDeviceDelegate.delegateInterface.deviceCallbackDisconnectDeviceRemove(entry2.getKey().intValue(), str);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWidgetDataPairStatus(boolean isBonded, Map.Entry<Integer, BaseWidgetUIModel> it, String deviceAddress, int connectCurrentState) {
        if (!isBonded) {
            this.delegateInterface.deviceCallbackDisconnectDeviceRemove(it.getKey().intValue(), deviceAddress);
            this.widgetDataList.remove(it.getKey());
            DatabaseUtils.INSTANCE.getWidgetDao().deleteWidgetItem(it.getKey().intValue());
        } else if (connectCurrentState == 2) {
            it.getValue().setConnectStatus(3);
            it.getValue().setNeedFailAnimator(false);
            this.delegateInterface.deviceCallbackDisconnect(it.getKey().intValue(), deviceAddress, 3);
        }
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void openBluetooth(TWSDevice twsDevice) {
        Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
        if (isNotHasWidgetData(twsDevice).getFirst().booleanValue()) {
            return;
        }
        DeviceDelegateInterface deviceDelegateInterface = this.delegateInterface;
        String address = twsDevice.getAddress();
        if (address == null) {
            address = "";
        }
        deviceDelegateInterface.openBluetoothSwitch(address, twsDevice.isConnected());
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data, TWSDevice twsDevice) {
        DeviceNoiseItem noiseReductionMode;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
        if (isNotHasWidgetData(twsDevice).getFirst().booleanValue()) {
            return;
        }
        switch (cmdType) {
            case 49159:
            case 57345:
                DeviceBattery deviceBattery = (DeviceBattery) data.obtainPayload(DeviceBattery.class);
                if (deviceBattery != null) {
                    DeviceDelegateInterface deviceDelegateInterface = this.delegateInterface;
                    String address = twsDevice.getAddress();
                    deviceDelegateInterface.deviceCallbackUpdateBatteryData(address != null ? address : "", deviceBattery);
                    break;
                }
                break;
            case 49182:
            case 57347:
                DeviceNoiseReduction deviceNoiseReduction = (DeviceNoiseReduction) data.obtainPayload(DeviceNoiseReduction.class);
                if (deviceNoiseReduction != null && (noiseReductionMode = deviceNoiseReduction.getNoiseReductionMode()) != null) {
                    DeviceDelegateInterface deviceDelegateInterface2 = this.delegateInterface;
                    String address2 = twsDevice.getAddress();
                    deviceDelegateInterface2.deviceCallbackUpdateNoiseData(address2 != null ? address2 : "", noiseReductionMode);
                    break;
                }
                break;
        }
    }
}
