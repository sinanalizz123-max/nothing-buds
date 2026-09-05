package com.nothing.device;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.model.BaseDevice;
import com.nothing.base.router.device.DeviceColor;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.ear.R;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.helper.SppConnectHelper;
import com.nothing.protocol.model.ProtocolModel;
import com.nothing.xservice.XViewType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: IOTDevice.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0005J>\u0010\u0082\u0001\u001a\u0004\u0018\u00010|2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00052&\u0010\u0084\u0001\u001a!\u0012\u0016\u0012\u00140\u0005\u00a2\u0006\u000f\b\u0086\u0001\u0012\n\b\u0087\u0001\u0012\u0005\b\b(\u0083\u0001\u0012\u0004\u0012\u00020|0\u0085\u0001H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0017H\u0016J\u0007\u0010\u0089\u0001\u001a\u00020\u0017J\u0011\u0010\u008a\u0001\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\u0005H\u0016J\u0013\u0010\u008b\u0001\u001a\u00020\u00172\b\b\u0002\u0010[\u001a\u00020\u0005H\u0016J\u0013\u0010\u008c\u0001\u001a\u00020\u00172\b\u0010[\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010\u008d\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u008e\u0001\u001a\u00020\u001dH\u0016J\t\u0010\u008f\u0001\u001a\u00020\u001dH\u0016J\u0019\u0010\u0090\u0001\u001a\u00020Z2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020E0\u0092\u0001H\u0016J\t\u0010\u0093\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0094\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0096\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0097\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u009b\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u009f\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u00a0\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u00a1\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u00a2\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u00a3\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u00a4\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u00a5\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u00a6\u0001\u001a\u00020\u0017H\u0016J\t\u0010\u00a7\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u00a8\u0001\u001a\u00020\u0005H\u0016J\f\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00aa\u0001H\u0002J\t\u0010\u00ab\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u00ac\u0001\u001a\u00020\u001dH\u0016J\u0016\u0010\u00ad\u0001\u001a\u00020\u00172\n\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00af\u0001H\u0096\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001a\u0010(\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010.\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001a\u00101\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001a\u00104\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001a\u00107\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R\u001a\u0010:\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001a\u0010=\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R\u001a\u0010@\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R!\u0010C\u001a\u0012\u0012\u0004\u0012\u00020E0Dj\b\u0012\u0004\u0012\u00020E`F\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001f\"\u0004\bK\u0010!R\u001a\u0010L\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010!R\u001a\u0010O\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!R*\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Dj\b\u0012\u0004\u0012\u00020\u001d`FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010H\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001f\"\u0004\bX\u0010!R\u001e\u0010\\\u001a\u0004\u0018\u00010]8FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001a\u0010n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u000e\"\u0004\bp\u0010\u0010R\u001a\u0010q\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u001f\"\u0004\bs\u0010!R\u001a\u0010t\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u001f\"\u0004\bv\u0010!R\u001a\u0010w\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0019\"\u0004\by\u0010\u001bR\u001d\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020|0{\u00a2\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u001c\u0010\u007f\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u001f\"\u0005\b\u0081\u0001\u0010!\u00a8\u0006\u00b0\u0001"}, d2 = {"Lcom/nothing/device/IOTDevice;", "Lcom/nothing/base/model/BaseDevice;", "color", "Lcom/nothing/base/router/device/DeviceColor;", "modelId", "", "productId", "<init>", "(Lcom/nothing/base/router/device/DeviceColor;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Lcom/nothing/base/router/device/DeviceColor;", "setColor", "(Lcom/nothing/base/router/device/DeviceColor;)V", "getModelId", "()Ljava/lang/String;", "setModelId", "(Ljava/lang/String;)V", "getProductId", "setProductId", "deviceName", "getDeviceName", "setDeviceName", "deviceNameAllUpCase", "", "getDeviceNameAllUpCase", "()Z", "setDeviceNameAllUpCase", "(Z)V", "widgetImage", "", "getWidgetImage", "()I", "setWidgetImage", "(I)V", "widgetDisconnectImage", "getWidgetDisconnectImage", "setWidgetDisconnectImage", "leftImage", "getLeftImage", "setLeftImage", "rightImage", "getRightImage", "setRightImage", "caseImage", "getCaseImage", "setCaseImage", "osLeftImage", "getOsLeftImage", "setOsLeftImage", "osRightImage", "getOsRightImage", "setOsRightImage", "osCaseImage", "getOsCaseImage", "setOsCaseImage", "osDisconnectedImage", "getOsDisconnectedImage", "setOsDisconnectedImage", "osSystemUIImage", "getOsSystemUIImage", "setOsSystemUIImage", "guideLottieJson", "getGuideLottieJson", "setGuideLottieJson", "macAddress", "getMacAddress", "setMacAddress", "gestureList", "Ljava/util/ArrayList;", "Lcom/nothing/device/GesturesItem;", "Lkotlin/collections/ArrayList;", "getGestureList", "()Ljava/util/ArrayList;", "homeImage", "getHomeImage", "setHomeImage", "controlImage", "getControlImage", "setControlImage", "pairImage", "getPairImage", "setPairImage", "guideImages", "getGuideImages", "setGuideImages", "(Ljava/util/ArrayList;)V", "menuImage", "getMenuImage", "setMenuImage", "setMyMacAddress", "", "address", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "getTwsDevice", "()Lcom/nothing/protocol/device/TWSDevice;", "setTwsDevice", "(Lcom/nothing/protocol/device/TWSDevice;)V", "battery", "Lcom/nothing/device/IOTDeviceBattery;", "getBattery", "()Lcom/nothing/device/IOTDeviceBattery;", "setBattery", "(Lcom/nothing/device/IOTDeviceBattery;)V", "pageData", "Lcom/nothing/device/IOTDevicePageDataAction;", "getPageData", "()Lcom/nothing/device/IOTDevicePageDataAction;", "setPageData", "(Lcom/nothing/device/IOTDevicePageDataAction;)V", "pushTopic", "getPushTopic", "setPushTopic", "widgetLeftImage", "getWidgetLeftImage", "setWidgetLeftImage", "widgetRightImage", "getWidgetRightImage", "setWidgetRightImage", "overrideDeviceName", "getOverrideDeviceName", "setOverrideDeviceName", "mapViewController", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/nothing/device/OSXViewController;", "getMapViewController", "()Ljava/util/concurrent/ConcurrentHashMap;", "caseText", "getCaseText", "setCaseText", "getViewController", "viewType", "createAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isCmfText", "isRoboText", "getANCLevel", "isSupportAnc", "isSupportAncByVersion", "isSupportPassThrough", "getLeftEarImage", "getRightEarImage", "addAllGesturesItem", "gestures", "", "isSupportAdvanceEQ", "isSupportUtc", "isSupportSerialNumber", "isSupportInEarDetect", "isSupportPersonalANC", "isSupportPersonalSound", "isSupportHighQualityAudio", "isSupportEarTipFitTest", "isSupportEqualizer", "isSupportDirac", "isSupportNoiseReduction", "isSupportFindMyDevice", "isSupportDual", "isBassBoost", "isSupportLagLatency", "isSupportEarConnectState", "hasSupportGpt", "hasHeadTrack", "isSupportNews", "isSupportExplore", "getFirmwareVersion", "getSerialNumber", "queryItem", "Lcom/nothing/database/entity/DeviceItem;", "toString", "hashCode", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IOTDevice extends BaseDevice {
    private IOTDeviceBattery battery;
    private int caseImage;
    private int caseText;
    private DeviceColor color;
    private int controlImage;
    private String deviceName;
    private boolean deviceNameAllUpCase;
    private final ArrayList<GesturesItem> gestureList;
    private ArrayList<Integer> guideImages;
    private String guideLottieJson;
    private int homeImage;
    private int leftImage;
    private String macAddress;
    private final ConcurrentHashMap<String, OSXViewController> mapViewController;
    private int menuImage;
    private String modelId;
    private int osCaseImage;
    private int osDisconnectedImage;
    private int osLeftImage;
    private int osRightImage;
    private int osSystemUIImage;
    private boolean overrideDeviceName;
    private IOTDevicePageDataAction pageData;
    private int pairImage;
    private String productId;
    private String pushTopic;
    private int rightImage;
    private TWSDevice twsDevice;
    private int widgetDisconnectImage;
    private int widgetImage;
    private int widgetLeftImage;
    private int widgetRightImage;

    public int getANCLevel(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return 0;
    }

    public boolean hasHeadTrack() {
        return false;
    }

    public boolean hasSupportGpt() {
        return true;
    }

    public boolean isBassBoost() {
        return false;
    }

    public boolean isCmfText() {
        return false;
    }

    public final boolean isRoboText() {
        return false;
    }

    public boolean isSupportAdvanceEQ() {
        return false;
    }

    public boolean isSupportAnc(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return true;
    }

    public boolean isSupportAncByVersion(String address) {
        return false;
    }

    public boolean isSupportDirac() {
        return false;
    }

    public boolean isSupportDual() {
        return false;
    }

    public boolean isSupportEarConnectState() {
        return true;
    }

    public boolean isSupportEarTipFitTest() {
        return false;
    }

    public boolean isSupportEqualizer() {
        return true;
    }

    public boolean isSupportExplore() {
        return false;
    }

    public boolean isSupportFindMyDevice() {
        return true;
    }

    public boolean isSupportHighQualityAudio() {
        return false;
    }

    public boolean isSupportInEarDetect() {
        return true;
    }

    public boolean isSupportLagLatency() {
        return true;
    }

    public boolean isSupportNews() {
        return false;
    }

    public boolean isSupportNoiseReduction() {
        return false;
    }

    public boolean isSupportPassThrough() {
        return true;
    }

    public boolean isSupportPersonalANC() {
        return false;
    }

    public boolean isSupportPersonalSound() {
        return false;
    }

    public boolean isSupportSerialNumber() {
        return true;
    }

    public boolean isSupportUtc() {
        return true;
    }

    public /* synthetic */ IOTDevice(DeviceColor deviceColor, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceColor, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    public final DeviceColor getColor() {
        return this.color;
    }

    public final void setColor(DeviceColor deviceColor) {
        Intrinsics.checkNotNullParameter(deviceColor, "<set-?>");
        this.color = deviceColor;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setModelId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelId = str;
    }

    public final void setProductId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productId = str;
    }

    public IOTDevice(DeviceColor color, String modelId, String productId) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.color = color;
        this.modelId = modelId;
        this.productId = productId;
        this.deviceName = "";
        this.leftImage = R.drawable.ear_default_left;
        this.rightImage = R.drawable.ear_default_right;
        this.caseImage = R.drawable.ear_default_case_3x;
        this.osLeftImage = R.drawable.ear_os_default_left;
        this.osRightImage = R.drawable.ear_os_default_right;
        this.osCaseImage = R.drawable.ear_os_default_case;
        this.osDisconnectedImage = R.drawable.ear_os_default_disconnected;
        this.osSystemUIImage = R.drawable.ear_default_small_icon;
        this.guideLottieJson = "lottie/ear_default_boarding_black.json";
        this.macAddress = "";
        this.gestureList = new ArrayList<>();
        this.homeImage = R.drawable.ear_default_right;
        this.controlImage = R.drawable.ear_default_right;
        this.pairImage = R.drawable.ear_default_right;
        this.guideImages = new ArrayList<>();
        this.pushTopic = "";
        this.widgetLeftImage = R.drawable.ear_default_left;
        this.widgetRightImage = R.drawable.ear_default_right;
        this.overrideDeviceName = true;
        this.mapViewController = new ConcurrentHashMap<>();
        this.caseText = com.nothing.settings.R.string.bluetooth_middle_name;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceName = str;
    }

    public final boolean getDeviceNameAllUpCase() {
        return this.deviceNameAllUpCase;
    }

    public final void setDeviceNameAllUpCase(boolean z) {
        this.deviceNameAllUpCase = z;
    }

    public final int getWidgetImage() {
        return this.widgetImage;
    }

    public final void setWidgetImage(int i) {
        this.widgetImage = i;
    }

    public final int getWidgetDisconnectImage() {
        return this.widgetDisconnectImage;
    }

    public final void setWidgetDisconnectImage(int i) {
        this.widgetDisconnectImage = i;
    }

    public final int getLeftImage() {
        return this.leftImage;
    }

    public final void setLeftImage(int i) {
        this.leftImage = i;
    }

    public final int getRightImage() {
        return this.rightImage;
    }

    public final void setRightImage(int i) {
        this.rightImage = i;
    }

    public final int getCaseImage() {
        return this.caseImage;
    }

    public final void setCaseImage(int i) {
        this.caseImage = i;
    }

    public final int getOsLeftImage() {
        return this.osLeftImage;
    }

    public final void setOsLeftImage(int i) {
        this.osLeftImage = i;
    }

    public final int getOsRightImage() {
        return this.osRightImage;
    }

    public final void setOsRightImage(int i) {
        this.osRightImage = i;
    }

    public final int getOsCaseImage() {
        return this.osCaseImage;
    }

    public final void setOsCaseImage(int i) {
        this.osCaseImage = i;
    }

    public final int getOsDisconnectedImage() {
        return this.osDisconnectedImage;
    }

    public final void setOsDisconnectedImage(int i) {
        this.osDisconnectedImage = i;
    }

    public final int getOsSystemUIImage() {
        return this.osSystemUIImage;
    }

    public final void setOsSystemUIImage(int i) {
        this.osSystemUIImage = i;
    }

    public final String getGuideLottieJson() {
        return this.guideLottieJson;
    }

    public final void setGuideLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guideLottieJson = str;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final void setMacAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.macAddress = str;
    }

    public final ArrayList<GesturesItem> getGestureList() {
        return this.gestureList;
    }

    public final int getHomeImage() {
        return this.homeImage;
    }

    public final void setHomeImage(int i) {
        this.homeImage = i;
    }

    public final int getControlImage() {
        return this.controlImage;
    }

    public final void setControlImage(int i) {
        this.controlImage = i;
    }

    public final int getPairImage() {
        return this.pairImage;
    }

    public final void setPairImage(int i) {
        this.pairImage = i;
    }

    public final ArrayList<Integer> getGuideImages() {
        return this.guideImages;
    }

    public final void setGuideImages(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.guideImages = arrayList;
    }

    public final int getMenuImage() {
        return this.menuImage;
    }

    public final void setMenuImage(int i) {
        this.menuImage = i;
    }

    public final void setMyMacAddress(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.macAddress = address;
        TWSDevice twsDevice = getTwsDevice();
        if (twsDevice != null) {
            twsDevice.getAddress();
        }
    }

    public final void setTwsDevice(TWSDevice tWSDevice) {
        this.twsDevice = tWSDevice;
    }

    public final TWSDevice getTwsDevice() {
        IOTProductDevice productByModelId;
        ProtocolModel protocol;
        if (this.macAddress.length() == 0) {
            return null;
        }
        TWSDevice tWSDeviceObtainDevice = SppConnectHelper.INSTANCE.getInstance().obtainDevice(this.macAddress);
        this.twsDevice = tWSDeviceObtainDevice;
        if (tWSDeviceObtainDevice != null) {
            return tWSDeviceObtainDevice;
        }
        synchronized (this) {
            if (SppConnectHelper.INSTANCE.getInstance().isPermissions()) {
                BluetoothDevice bluetoothDevice = BluetoothBroadcast.INSTANCE.getInstance().getBluetoothDevice(this.macAddress);
                if (bluetoothDevice != null && (productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(this.modelId)) != null && (protocol = productByModelId.getProtocol()) != null) {
                    this.twsDevice = SppConnectHelper.INSTANCE.getInstance().obtainDevice(bluetoothDevice, protocol);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "initTWSDevice has no permission ".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "initTWSDevice has no permission  " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "initTWSDevice has no permission  " + strComponent2);
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return this.twsDevice;
    }

    public final IOTDeviceBattery getBattery() {
        return this.battery;
    }

    public final void setBattery(IOTDeviceBattery iOTDeviceBattery) {
        this.battery = iOTDeviceBattery;
    }

    public final IOTDevicePageDataAction getPageData() {
        return this.pageData;
    }

    public final void setPageData(IOTDevicePageDataAction iOTDevicePageDataAction) {
        this.pageData = iOTDevicePageDataAction;
    }

    public final String getPushTopic() {
        return this.pushTopic;
    }

    public final void setPushTopic(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pushTopic = str;
    }

    public final int getWidgetLeftImage() {
        return this.widgetLeftImage;
    }

    public final void setWidgetLeftImage(int i) {
        this.widgetLeftImage = i;
    }

    public final int getWidgetRightImage() {
        return this.widgetRightImage;
    }

    public final void setWidgetRightImage(int i) {
        this.widgetRightImage = i;
    }

    public final boolean getOverrideDeviceName() {
        return this.overrideDeviceName;
    }

    public final void setOverrideDeviceName(boolean z) {
        this.overrideDeviceName = z;
    }

    public final ConcurrentHashMap<String, OSXViewController> getMapViewController() {
        return this.mapViewController;
    }

    public final int getCaseText() {
        return this.caseText;
    }

    public final void setCaseText(int i) {
        this.caseText = i;
    }

    public OSXViewController getViewController(String viewType, Function1<? super String, ? extends OSXViewController> createAction) {
        Intrinsics.checkNotNullParameter(createAction, "createAction");
        if (Intrinsics.areEqual(viewType, XViewType.ANC_VIEW_TYPE) || Intrinsics.areEqual(viewType, "BATTERY")) {
            OSXViewController oSXViewController = this.mapViewController.get(viewType);
            if (oSXViewController == null) {
                OSXViewController oSXViewControllerInvoke = createAction.invoke(viewType);
                this.mapViewController.put(viewType, oSXViewControllerInvoke);
                return oSXViewControllerInvoke;
            }
            if (oSXViewController.getType() == getANCLevel(this.macAddress)) {
                return oSXViewController;
            }
            OSXViewController oSXViewControllerInvoke2 = createAction.invoke(viewType);
            oSXViewController.removeObserver(this.macAddress);
            this.mapViewController.put(viewType, oSXViewControllerInvoke2);
            return oSXViewControllerInvoke2;
        }
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (!logger.isCanLogger(true)) {
            return null;
        }
        String str = "getViewController " + viewType + " is not correct ";
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        Pair<String, String> trace = logger.getTrace(depth);
        String strComponent1 = trace.component1();
        String strComponent2 = trace.component2();
        FileLog fileLog = FileLog.INSTANCE;
        String str3 = logger.getSdf().format(new Date());
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        FileLog.print$default(fileLog, 5, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
        if (!logger.isDebug()) {
            return null;
        }
        Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
        return null;
    }

    public static /* synthetic */ boolean isSupportAnc$default(IOTDevice iOTDevice, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isSupportAnc");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        return iOTDevice.isSupportAnc(str);
    }

    /* JADX INFO: renamed from: getLeftEarImage, reason: from getter */
    public int getLeftImage() {
        return this.leftImage;
    }

    /* JADX INFO: renamed from: getRightEarImage, reason: from getter */
    public int getRightImage() {
        return this.rightImage;
    }

    public void addAllGesturesItem(List<GesturesItem> gestures) {
        Intrinsics.checkNotNullParameter(gestures, "gestures");
        this.gestureList.addAll(gestures);
    }

    public String getFirmwareVersion() {
        String version;
        String deviceVersion;
        TWSDevice twsDevice = getTwsDevice();
        String str = "";
        if (twsDevice == null || (version = twsDevice.getVersion()) == null) {
            version = "";
        }
        if (version.length() > 0) {
            return version;
        }
        DeviceItem deviceItemQueryItem = queryItem();
        if (deviceItemQueryItem != null && (deviceVersion = deviceItemQueryItem.getDeviceVersion()) != null) {
            str = deviceVersion;
        }
        TWSDevice twsDevice2 = getTwsDevice();
        if (twsDevice2 != null) {
            twsDevice2.setVersion(str);
        }
        return str;
    }

    public String getSerialNumber() {
        String sn;
        String sn2;
        TWSDevice twsDevice = getTwsDevice();
        if (twsDevice == null || (sn = twsDevice.getSn()) == null) {
            sn = "";
        }
        if (sn.length() > 0) {
            return sn;
        }
        DeviceItem deviceItemQueryItem = queryItem();
        return (deviceItemQueryItem == null || (sn2 = deviceItemQueryItem.getSn()) == null) ? "" : sn2;
    }

    private final DeviceItem queryItem() {
        List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(this.macAddress);
        if (deviceItem != null) {
            return (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem);
        }
        return null;
    }

    public String toString() {
        return "[color:" + this.color + ",macAddress:" + this.macAddress + ",modelId:" + this.modelId + ",deviceName:" + this.deviceName + "]";
    }

    public int hashCode() {
        return Objects.hash(this.macAddress, this.modelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IOTDevice)) {
            return false;
        }
        IOTDevice iOTDevice = (IOTDevice) other;
        return Intrinsics.areEqual(this.macAddress, iOTDevice.macAddress) && Intrinsics.areEqual(this.modelId, iOTDevice.modelId);
    }
}
