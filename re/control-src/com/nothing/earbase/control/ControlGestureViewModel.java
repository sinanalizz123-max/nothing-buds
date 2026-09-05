package com.nothing.earbase.control;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.GesturesItem;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.ear.R;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.control.entity.ControlRadius;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlGestureViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 t2\u00020\u0001:\u0001tB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010[\u001a\u00020\nJ\u000e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0007J\u0018\u0010_\u001a\u00020]2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010`\u001a\u00020CH\u0016J\u0018\u0010a\u001a\u00020]2\u0006\u0010\u0002\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010b\u001a\u00020]2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J>\u0010\u001e\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070d\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140c2\u0006\u0010e\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\nH\u0016J;\u0010f\u001a\u00020]2\u0006\u0010\u0002\u001a\u00020\u00142\u0006\u0010g\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010jJ$\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140d2\u0006\u0010\u0002\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J$\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140d2\u0006\u0010\u0002\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001f\u0010m\u001a\u0013\u0012\t\u0012\u00070\u0007\u00a2\u0006\u0002\bn\u0012\u0004\u0012\u00020\u00140d2\u0006\u0010\u0004\u001a\u00020\u0005J\u001f\u0010o\u001a\u0013\u0012\t\u0012\u00070\u0007\u00a2\u0006\u0002\bn\u0012\u0004\u0012\u00020\u00140d2\u0006\u0010\u0004\u001a\u00020\u0005J\u001f\u0010p\u001a\u0013\u0012\t\u0012\u00070\u0007\u00a2\u0006\u0002\bn\u0012\u0004\u0012\u00020\u00140d2\u0006\u0010\u0004\u001a\u00020\u0005J\u001f\u0010q\u001a\u0013\u0012\t\u0012\u00070\u0007\u00a2\u0006\u0002\bn\u0012\u0004\u0012\u00020\u00140d2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010r\u001a\u00020]2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010s\u001a\u00020\u0014H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R(\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u00070\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R(\u0010 \u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u00070\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R(\u0010#\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u00070\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R(\u0010&\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u00070\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R(\u0010)\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010:R(\u0010;\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0017\"\u0004\b<\u0010\u0019R(\u0010=\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R(\u0010?\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\n0\n0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R \u0010A\u001a\b\u0012\u0004\u0012\u00020C0BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010H\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0017\"\u0004\bJ\u0010\u0019R(\u0010K\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u00070\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u0019R(\u0010N\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u00070\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0017\"\u0004\bP\u0010\u0019R(\u0010Q\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u00070\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0017\"\u0004\bS\u0010\u0019R\u001a\u0010T\u001a\u00020UX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0011\u0010Z\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bZ\u0010\u0011\u00a8\u0006u"}, d2 = {"Lcom/nothing/earbase/control/ControlGestureViewModel;", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "context", "Landroid/content/Context;", "address", "", "callOperation", "isSystem", "", "<init>", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/String;Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Z)V", "getAddress", "()Ljava/lang/String;", "getCallOperation", "()Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "()Z", "gestureIndexRes", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getGestureIndexRes", "()Landroidx/databinding/ObservableField;", "setGestureIndexRes", "(Landroidx/databinding/ObservableField;)V", "gestureIndexTitleRes", "getGestureIndexTitleRes", "setGestureIndexTitleRes", "gestureName", "getGestureName", "setGestureName", "operationName", "getOperationName", "setOperationName", "itemDesc", "getItemDesc", "setItemDesc", "operationSubName", "getOperationSubName", "setOperationSubName", "secondOperationVisible", "getSecondOperationVisible", "setSecondOperationVisible", "alphaItem", "Landroidx/databinding/ObservableFloat;", "getAlphaItem", "()Landroidx/databinding/ObservableFloat;", "setAlphaItem", "(Landroidx/databinding/ObservableFloat;)V", "defaultOperation", "getDefaultOperation", "()I", "setDefaultOperation", "(I)V", "options", "getOptions", "setOptions", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;)V", "isLeft", "setLeft", "isRight", "setRight", "isCase", "setCase", "operationList", "Landroidx/databinding/ObservableArrayList;", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "getOperationList", "()Landroidx/databinding/ObservableArrayList;", "setOperationList", "(Landroidx/databinding/ObservableArrayList;)V", "arrowVisible", "getArrowVisible", "setArrowVisible", "lottieString", "getLottieString", "setLottieString", "noiseSummary", "getNoiseSummary", "setNoiseSummary", "chatGptSummary", "getChatGptSummary", "setChatGptSummary", "direction", "Lcom/nothing/earbase/control/entity/ControlRadius;", "getDirection", "()Lcom/nothing/earbase/control/entity/ControlRadius;", "setDirection", "(Lcom/nothing/earbase/control/entity/ControlRadius;)V", "isCanClick", "isSupportNews", "setOperationNameAppend", "", "name", "onClickSelectedOperation", "itemViewModel", "updateOperationText", "convertToViewModel", "Lkotlin/Triple;", "Lkotlin/Pair;", "gesture", "addNewsControl", "it", "isHead", "isNoExtra", "(ILcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getNoExtraFunc", "getGestureOperation", "volumeControl", "Lkotlin/jvm/internal/EnhancedNullability;", "ancNoiseControl", "volumeDown", "volumeUp", "convertOptions", "getItemViewType", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ControlGestureViewModel implements CommonBindingMoreType {
    public static final int CONTROL_BOTTOM = 3;
    public static final int CONTROL_EMPTY_VIEW = 5;
    public static final int CONTROL_OPERATION_TYPE = 1;
    public static final int CONTROL_TITLE = 4;
    public static final float UNABLE = 0.65f;
    private final String address;
    private ObservableFloat alphaItem;
    private ObservableField<Integer> arrowVisible;
    private final ControlConfigurationEntity.Operation callOperation;
    private ObservableField<String> chatGptSummary;
    private int defaultOperation;
    private ControlRadius direction;
    private ObservableField<Integer> gestureIndexRes;
    private ObservableField<Integer> gestureIndexTitleRes;
    private ObservableField<String> gestureName;
    private ObservableField<Boolean> isCase;
    private ObservableField<Boolean> isLeft;
    private ObservableField<Boolean> isRight;
    private final boolean isSystem;
    private ObservableField<String> itemDesc;
    private ObservableField<String> lottieString;
    private ObservableField<String> noiseSummary;
    private ObservableArrayList<ControlOperationViewModel> operationList;
    private ObservableField<String> operationName;
    private ObservableField<String> operationSubName;
    private ControlConfigurationEntity.Operation options;
    private ObservableField<Boolean> secondOperationVisible;

    public void convertOptions(ControlConfigurationEntity.Operation operation, Context context) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.nothing.base.adapter.CommonBindingMoreType
    public int getItemViewType() {
        return 1;
    }

    public ControlGestureViewModel(ControlConfigurationEntity.Operation operation, Context context, String address, ControlConfigurationEntity.Operation operation2, boolean z) {
        String deviceName;
        String strFirstUpper;
        String deviceName2;
        String strFirstUpper2;
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        this.address = address;
        this.callOperation = operation2;
        this.isSystem = z;
        this.gestureIndexRes = new ObservableField<>(0);
        this.gestureIndexTitleRes = new ObservableField<>(0);
        String str = "";
        this.gestureName = new ObservableField<>("");
        this.operationName = new ObservableField<>("");
        this.itemDesc = new ObservableField<>("");
        this.operationSubName = new ObservableField<>("");
        this.secondOperationVisible = new ObservableField<>(false);
        this.alphaItem = new ObservableFloat(1.0f);
        this.isLeft = new ObservableField<>(false);
        this.isRight = new ObservableField<>(false);
        this.isCase = new ObservableField<>(false);
        this.operationList = new ObservableArrayList<>();
        this.arrowVisible = new ObservableField<>(0);
        this.lottieString = new ObservableField<>("");
        this.noiseSummary = new ObservableField<>("");
        this.chatGptSummary = new ObservableField<>("");
        this.direction = ControlRadius.CENTER;
        convertToViewModel(operation, context);
        Application application = AppGlobals.INSTANCE.get();
        if (application != null) {
            ObservableField<String> observableField = this.noiseSummary;
            int i = R.string.os_noise_mode_summary;
            IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
            observableField.set(application.getString(i, new Object[]{(iOTDeviceByMacAddress == null || (deviceName2 = iOTDeviceByMacAddress.getDeviceName()) == null || (strFirstUpper2 = DataExtKt.firstUpper(deviceName2)) == null) ? "" : strFirstUpper2, this.gestureName.get()}));
            ObservableField<String> observableField2 = this.chatGptSummary;
            int i2 = R.string.voice_assistant_system_summary;
            IOTDevice iOTDeviceByMacAddress2 = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
            if (iOTDeviceByMacAddress2 != null && (deviceName = iOTDeviceByMacAddress2.getDeviceName()) != null && (strFirstUpper = DataExtKt.firstUpper(deviceName)) != null) {
                str = strFirstUpper;
            }
            observableField2.set(application.getString(i2, new Object[]{str, this.gestureName.get()}));
        }
    }

    public /* synthetic */ ControlGestureViewModel(ControlConfigurationEntity.Operation operation, Context context, String str, ControlConfigurationEntity.Operation operation2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(operation, context, str, (i & 8) != 0 ? null : operation2, (i & 16) != 0 ? false : z);
    }

    public final String getAddress() {
        return this.address;
    }

    public final ControlConfigurationEntity.Operation getCallOperation() {
        return this.callOperation;
    }

    /* JADX INFO: renamed from: isSystem, reason: from getter */
    public final boolean getIsSystem() {
        return this.isSystem;
    }

    public final ObservableField<Integer> getGestureIndexRes() {
        return this.gestureIndexRes;
    }

    public final void setGestureIndexRes(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.gestureIndexRes = observableField;
    }

    public final ObservableField<Integer> getGestureIndexTitleRes() {
        return this.gestureIndexTitleRes;
    }

    public final void setGestureIndexTitleRes(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.gestureIndexTitleRes = observableField;
    }

    public final ObservableField<String> getGestureName() {
        return this.gestureName;
    }

    public final void setGestureName(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.gestureName = observableField;
    }

    public final ObservableField<String> getOperationName() {
        return this.operationName;
    }

    public final void setOperationName(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.operationName = observableField;
    }

    public final ObservableField<String> getItemDesc() {
        return this.itemDesc;
    }

    public final void setItemDesc(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.itemDesc = observableField;
    }

    public final ObservableField<String> getOperationSubName() {
        return this.operationSubName;
    }

    public final void setOperationSubName(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.operationSubName = observableField;
    }

    public final ObservableField<Boolean> getSecondOperationVisible() {
        return this.secondOperationVisible;
    }

    public final void setSecondOperationVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.secondOperationVisible = observableField;
    }

    public final ObservableFloat getAlphaItem() {
        return this.alphaItem;
    }

    public final void setAlphaItem(ObservableFloat observableFloat) {
        Intrinsics.checkNotNullParameter(observableFloat, "<set-?>");
        this.alphaItem = observableFloat;
    }

    public final int getDefaultOperation() {
        return this.defaultOperation;
    }

    public final void setDefaultOperation(int i) {
        this.defaultOperation = i;
    }

    public final ControlConfigurationEntity.Operation getOptions() {
        return this.options;
    }

    public final void setOptions(ControlConfigurationEntity.Operation operation) {
        this.options = operation;
    }

    public final ObservableField<Boolean> isLeft() {
        return this.isLeft;
    }

    public final void setLeft(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.isLeft = observableField;
    }

    public final ObservableField<Boolean> isRight() {
        return this.isRight;
    }

    public final void setRight(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.isRight = observableField;
    }

    public final ObservableField<Boolean> isCase() {
        return this.isCase;
    }

    public final void setCase(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.isCase = observableField;
    }

    public final ObservableArrayList<ControlOperationViewModel> getOperationList() {
        return this.operationList;
    }

    public final void setOperationList(ObservableArrayList<ControlOperationViewModel> observableArrayList) {
        Intrinsics.checkNotNullParameter(observableArrayList, "<set-?>");
        this.operationList = observableArrayList;
    }

    public final ObservableField<Integer> getArrowVisible() {
        return this.arrowVisible;
    }

    public final void setArrowVisible(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.arrowVisible = observableField;
    }

    public final ObservableField<String> getLottieString() {
        return this.lottieString;
    }

    public final void setLottieString(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.lottieString = observableField;
    }

    public final ObservableField<String> getNoiseSummary() {
        return this.noiseSummary;
    }

    public final void setNoiseSummary(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.noiseSummary = observableField;
    }

    public final ObservableField<String> getChatGptSummary() {
        return this.chatGptSummary;
    }

    public final void setChatGptSummary(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.chatGptSummary = observableField;
    }

    public final ControlRadius getDirection() {
        return this.direction;
    }

    public final void setDirection(ControlRadius controlRadius) {
        Intrinsics.checkNotNullParameter(controlRadius, "<set-?>");
        this.direction = controlRadius;
    }

    public final boolean isCanClick() {
        Integer num = this.arrowVisible.get();
        return num != null && num.intValue() == 0;
    }

    public final boolean isSupportNews() {
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.address);
        if (iOTDeviceByMacAddress != null) {
            return iOTDeviceByMacAddress.isSupportNews();
        }
        return false;
    }

    public final void setOperationNameAppend(String name) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(name, "name");
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        String string = ContextExtKt.getLocalizedResources(application).getString(R.string.control_no_action);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Application application2 = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application2);
        String string2 = ContextExtKt.getLocalizedResources(application2).getString(R.string.control_no_extra_action);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str3 = name;
        String str4 = string;
        if ((StringsKt.contains$default((CharSequence) str3, (CharSequence) str4, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str3, (CharSequence) string2, false, 2, (Object) null)) && (((str = this.operationSubName.get()) != null && StringsKt.contains$default((CharSequence) str, (CharSequence) str4, false, 2, (Object) null)) || ((str2 = this.operationSubName.get()) != null && StringsKt.contains$default((CharSequence) str2, (CharSequence) string2, false, 2, (Object) null)))) {
            this.operationName.set(string);
        } else {
            this.operationName.set(name + ((Object) this.operationSubName.get()));
        }
        ObservableField<String> observableField = this.itemDesc;
        String str5 = this.gestureName.get();
        String str6 = this.operationName.get();
        observableField.set(((Object) str5) + (str6 != null ? StringsKt.replace$default(str6, "\n", "", false, 4, (Object) null) : null));
    }

    public void onClickSelectedOperation(Context context, ControlOperationViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        for (ControlOperationViewModel controlOperationViewModel : this.operationList) {
            controlOperationViewModel.selectedOperation(Intrinsics.areEqual(itemViewModel, controlOperationViewModel));
        }
        updateOperationText(itemViewModel.getOperation(), context);
    }

    public void updateOperationText(int operation, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ControlConfigurationEntity.Operation operation2 = this.options;
        if (operation2 != null) {
            operation2.setOperation(operation);
        }
        setOperationNameAppend(getGestureOperation(operation, context).getFirst());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003c  */
    private final void convertToViewModel(ControlConfigurationEntity.Operation operation, Context context) {
        this.options = operation;
        int device = operation.getDevice();
        if (device == 2) {
            this.isLeft.set(true);
            this.isRight.set(false);
            this.isCase.set(false);
        } else if (device == 3) {
            this.isLeft.set(false);
            this.isRight.set(true);
            this.isCase.set(false);
        } else if (device == 4) {
            this.isLeft.set(false);
            this.isRight.set(false);
            this.isCase.set(true);
        } else if (device != 6) {
            this.isLeft.set(false);
            this.isRight.set(false);
            this.isCase.set(false);
        } else {
            this.isLeft.set(false);
            this.isRight.set(true);
            this.isCase.set(false);
        }
        int gesture = operation.getGesture();
        Boolean bool = this.isLeft.get();
        Triple<Pair<String, String>, Integer, Integer> gestureName = getGestureName(gesture, context, bool != null ? bool.booleanValue() : false);
        this.gestureName.set(gestureName.getFirst().getFirst());
        this.gestureIndexRes.set(gestureName.getSecond());
        this.gestureIndexTitleRes.set(gestureName.getThird());
        this.lottieString.set(gestureName.getFirst().getSecond());
        convertOptions(operation, context);
    }

    public Triple<Pair<String, String>, Integer, Integer> getGestureName(int gesture, Context context, boolean isLeft) {
        Object next;
        Triple<Pair<String, String>, Integer, Integer> tripleControlViewData;
        Intrinsics.checkNotNullParameter(context, "context");
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.address);
        if (iOTDeviceByMacAddress == null) {
            return new Triple<>(new Pair("", ""), 0, 0);
        }
        Iterator<T> it = iOTDeviceByMacAddress.getGestureList().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((GesturesItem) next).getGestures() != gesture);
        GesturesItem gesturesItem = (GesturesItem) next;
        return (gesturesItem == null || (tripleControlViewData = gesturesItem.controlViewData(isLeft, context)) == null) ? new Triple<>(new Pair("", ""), 0, 0) : tripleControlViewData;
    }

    public static /* synthetic */ void addNewsControl$default(ControlGestureViewModel controlGestureViewModel, int i, ControlConfigurationEntity.Operation operation, Context context, Integer num, Boolean bool, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addNewsControl");
        }
        if ((i2 & 8) != 0) {
            num = -1;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            bool = false;
        }
        controlGestureViewModel.addNewsControl(i, operation, context, num2, bool);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x009d  */
    public final void addNewsControl(int operation, ControlConfigurationEntity.Operation it, Context context, Integer isHead, Boolean isNoExtra) {
        Pair<String, Integer> gestureOperation;
        boolean zHasNothingAiNews;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(context, "context");
        if (NothingOSUtil.INSTANCE.isNothingOS() || operation != 31 || it.getOperation() == 31) {
            if (Intrinsics.areEqual((Object) isNoExtra, (Object) true)) {
                gestureOperation = getNoExtraFunc(operation, context);
            } else {
                gestureOperation = getGestureOperation(operation, context);
            }
            ControlOperationViewModel controlOperationViewModel = new ControlOperationViewModel(operation, gestureOperation, null, null, 12, null);
            if (isHead != null && isHead.intValue() == 0) {
                controlOperationViewModel.setDirection(ControlRadius.HEAD);
            } else if (isHead != null && isHead.intValue() == 1) {
                controlOperationViewModel.setDirection(ControlRadius.END);
            }
            controlOperationViewModel.selectedOperation(it.getOperation() == operation);
            if (!NothingOSUtil.INSTANCE.isNothingOS() || operation != 31) {
                zHasNothingAiNews = false;
            } else if (NothingOSUtil.INSTANCE.isSupportNewsConfigs(context)) {
                if (SpUtils.INSTANCE.getFlutterNewsConfigs().length() > 0) {
                    zHasNothingAiNews = true;
                } else {
                    zHasNothingAiNews = false;
                }
            } else {
                zHasNothingAiNews = RouterFactory.INSTANCE.getWidgetRouter().hasNothingAiNews(context);
            }
            if (operation == 10 || operation == 22 || operation == 21 || operation == 20) {
                controlOperationViewModel.selectedOperation(controlOperationViewModel.convertAnc(it.getOperation(), true));
            } else if (it.getOperation() == 31 && !NothingOSUtil.INSTANCE.isNothingOS() && operation == 31) {
                controlOperationViewModel.getEnable().set(false);
                controlOperationViewModel.getNewsPromptVisibility().set(true);
                ObservableField<String> newsPromptName = controlOperationViewModel.getNewsPromptName();
                Application application = AppGlobals.INSTANCE.get();
                Intrinsics.checkNotNull(application);
                newsPromptName.set(application.getString(R.string.not_support));
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "control_set third phone operation:" + operation;
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
            } else if (NothingOSUtil.INSTANCE.isNothingOS() && !NothingOSUtil.INSTANCE.isSupportNews(AppGlobals.INSTANCE.get()) && operation == 31) {
                controlOperationViewModel.getEnable().set(false);
                controlOperationViewModel.getNewsPromptVisibility().set(true);
                ObservableField<String> newsPromptName2 = controlOperationViewModel.getNewsPromptName();
                Application application2 = AppGlobals.INSTANCE.get();
                Intrinsics.checkNotNull(application2);
                int i = R.string.news_update_widget_app;
                Application application3 = AppGlobals.INSTANCE.get();
                Intrinsics.checkNotNull(application3);
                newsPromptName2.set(application2.getString(i, new Object[]{application3.getString(R.string.ai_news)}));
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "control_set nothing phone not widget operation:" + operation;
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
            } else if (NothingOSUtil.INSTANCE.isNothingOS() && !zHasNothingAiNews && operation == 31) {
                controlOperationViewModel.getEnable().set(false);
                controlOperationViewModel.getNewsPromptVisibility().set(true);
                ObservableField<String> newsPromptName3 = controlOperationViewModel.getNewsPromptName();
                Application application4 = AppGlobals.INSTANCE.get();
                Intrinsics.checkNotNull(application4);
                newsPromptName3.set(application4.getString(R.string.news_nothing_control_add_widget));
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str7 = "control_set nothing phone not widget operation:" + operation + ",version";
                    String str8 = str7;
                    if (str8 != null && str8.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str9 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                        FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
            }
            this.operationList.add(controlOperationViewModel);
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

    /* JADX WARN: Code duplicated, block: B:55:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:61:0x0119  */
    /* JADX WARN: Code duplicated, block: B:63:0x011e  */
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
            String string3 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_answer_hang_up);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return TuplesKt.to(string3, 0);
        }
        if (operation == 4) {
            String string4 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_decline_incoming_call);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return TuplesKt.to(string4, 0);
        }
        if (operation == 39) {
            String string5 = ContextExtKt.getLocalizedResources(context).getString(R.string.switch_bluetooth_connection);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return TuplesKt.to(string5, 0);
        }
        if (operation == 40) {
            String string6 = ContextExtKt.getLocalizedResources(context).getString(R.string.lock_unlock_tips, ContextExtKt.getLocalizedResources(context).getString(R.string.knob));
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return TuplesKt.to(string6, 0);
        }
        if (operation == 48) {
            return TuplesKt.to(ContextExtKt.getLocalizedResources(context).getString(R.string.control_play_pause) + "\n" + ContextExtKt.getLocalizedResources(context).getString(R.string.control_answer_hang_up), 0);
        }
        if (operation != 49) {
            if (operation != 51) {
                if (operation != 255) {
                    switch (operation) {
                        case 6:
                            return volumeUp(context);
                        case 7:
                            return volumeDown(context);
                        case 8:
                            String string7 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_skip_back);
                            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                            return TuplesKt.to(string7, 0);
                        case 9:
                            String string8 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_skip_forward);
                            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                            return TuplesKt.to(string8, 0);
                        case 10:
                            return ancNoiseControl(context);
                        case 11:
                            if (VoiceAssistantUtil.INSTANCE.isSupportGpt()) {
                                String string9 = ContextExtKt.getLocalizedResources(context).getString(R.string.voice_ai_title);
                                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                                return TuplesKt.to(string9, 0);
                            }
                            String string10 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_voice_assistant);
                            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                            return TuplesKt.to(string10, 0);
                        default:
                            switch (operation) {
                                case 17:
                                    String string11 = ContextExtKt.getLocalizedResources(context).getString(R.string.case_game_model);
                                    Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                                    return TuplesKt.to(string11, 0);
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
                                    String string12 = ContextExtKt.getLocalizedResources(context).getString(R.string.pairing_mode);
                                    Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                                    return TuplesKt.to(string12, 0);
                                case 25:
                                    String string13 = ContextExtKt.getLocalizedResources(context).getString(R.string.case_answer_call_mute);
                                    Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                                    return TuplesKt.to(string13, 0);
                                case 26:
                                    String string14 = ContextExtKt.getLocalizedResources(context).getString(R.string.control_hand_up_decline_incoming_calls);
                                    Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                                    return TuplesKt.to(string14, 0);
                                case 27:
                                    return TuplesKt.to("Spatial audio", 0);
                                case 28:
                                    return TuplesKt.to("Bass enhancement", 0);
                                case 29:
                                    return TuplesKt.to("Mic mute", 0);
                                default:
                                    switch (operation) {
                                        case 31:
                                            String string15 = ContextExtKt.getLocalizedResources(context).getString(R.string.ai_news);
                                            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                                            return TuplesKt.to(string15, 0);
                                        case 32:
                                            break;
                                        case 33:
                                            return TuplesKt.to("Essential space", 0);
                                        case 34:
                                            return TuplesKt.to("EQ Preset", 0);
                                        default:
                                            return TuplesKt.to("", 0);
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    return volumeControl(context);
                }
            }
            return TuplesKt.to("Nothing radio", 0);
        }
        return TuplesKt.to(ContextExtKt.getLocalizedResources(context).getString(R.string.control_skip_forward) + " / " + ContextExtKt.getLocalizedResources(context).getString(R.string.control_skip_back) + "\n" + ContextExtKt.getLocalizedResources(context).getString(R.string.control_answer_hang_up), 0);
    }

    public final Pair<String, Integer> volumeControl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return TuplesKt.to(ContextExtKt.getLocalizedResources(context).getString(R.string.control_volume_control), 0);
    }

    public final Pair<String, Integer> ancNoiseControl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return TuplesKt.to(ContextExtKt.getLocalizedResources(context).getString(R.string.anc_noise_control), 0);
    }

    public final Pair<String, Integer> volumeDown(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return TuplesKt.to(ContextExtKt.getLocalizedResources(context).getString(R.string.control_volume_down), 0);
    }

    public final Pair<String, Integer> volumeUp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return TuplesKt.to(ContextExtKt.getLocalizedResources(context).getString(R.string.control_volume_up), 0);
    }
}
