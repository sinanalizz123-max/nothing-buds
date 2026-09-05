package com.nothing.device;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LifecycleOwner;
import com.nothing.base.router.BaseNothingDevice;
import com.nothing.base.router.device.DeviceType;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.device.widget.IOTDeviceWidgetAction;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import com.nothing.global.core.router.GlobalImplKt;
import com.nothing.os.device.DeviceConstant;
import com.nothing.ota.entity.OTAProcess;
import com.nothing.protocol.model.ProtocolModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDevice.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00d3\u00012\u00020\u0001:\u0002\u00d3\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0092\u0001\u001a\u00020pH\u0016J\t\u0010\u0093\u0001\u001a\u00020pH\u0016J\t\u0010\u0094\u0001\u001a\u00020CH\u0016J\t\u0010\u0095\u0001\u001a\u00020pH\u0016J\t\u0010\u0096\u0001\u001a\u00020CH\u0016J\t\u0010\u0097\u0001\u001a\u00020pH\u0016J\t\u0010\u0098\u0001\u001a\u00020pH\u0016J\t\u0010\u0099\u0001\u001a\u00020pH\u0016J\t\u0010\u009a\u0001\u001a\u00020pH\u0016J\t\u0010\u009b\u0001\u001a\u00020pH\u0016J\t\u0010\u009c\u0001\u001a\u00020pH\u0016J\t\u0010\u009d\u0001\u001a\u00020pH\u0016J\t\u0010\u009e\u0001\u001a\u00020pH\u0016J\t\u0010\u009f\u0001\u001a\u00020pH\u0016J\t\u0010\u00a0\u0001\u001a\u00020pH\u0016J\t\u0010\u00a1\u0001\u001a\u00020pH\u0016J\t\u0010\u00a2\u0001\u001a\u00020pH\u0016J\n\u0010\u00a3\u0001\u001a\u00030\u00a4\u0001H\u0016J!\u0010\u00a5\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u00a7\u0001\u0012\u0005\u0012\u00030\u00a7\u00010\u00a6\u00012\u0007\u0010\u00a8\u0001\u001a\u00020CH\u0016J\n\u0010\u00a9\u0001\u001a\u00030\u00a7\u0001H\u0016J'\u0010\u00aa\u0001\u001a \u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u00ab\u0001j\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%`\u00ac\u0001H\u0016J\t\u0010\u00ad\u0001\u001a\u00020%H\u0016J\u0015\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00af\u00012\u0007\u0010\u00b0\u0001\u001a\u00020pH\u0016J\u001e\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00b2\u00012\u0007\u0010\u00b3\u0001\u001a\u00020%2\u0007\u0010\u00b4\u0001\u001a\u00020%H\u0016J\f\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00b6\u0001H\u0016J\t\u0010\u00b7\u0001\u001a\u00020%H\u0016JC\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b2\u00012\u000f\u0010\u00b9\u0001\u001a\n\u0012\u0005\u0012\u00030\u00bb\u00010\u00ba\u00012\b\u0010\u00bc\u0001\u001a\u00030\u00bd\u00012\b\u0010\u00be\u0001\u001a\u00030\u00bf\u00012\u0007\u0010\u00b4\u0001\u001a\u00020%2\u0007\u0010\u00c0\u0001\u001a\u00020%H\u0016JO\u0010\u00c1\u0001\u001a\"\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030\u00c2\u00010\u00ab\u0001j\u0010\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030\u00c2\u0001`\u00ac\u00012\b\u0010\u00c3\u0001\u001a\u00030\u00c4\u00012\u0007\u0010\u00c5\u0001\u001a\u00020\u00062\b\u0010\u00c6\u0001\u001a\u00030\u00c7\u00012\u0007\u0010\u00c8\u0001\u001a\u00020pH\u0016J\t\u0010\u00c9\u0001\u001a\u00020pH\u0016J\t\u0010\u00ca\u0001\u001a\u00020pH\u0016J\t\u0010\u00cb\u0001\u001a\u00020pH\u0016J\t\u0010\u00cc\u0001\u001a\u00020pH\u0016J\t\u0010\u00cd\u0001\u001a\u00020pH\u0016J\t\u0010\u00ce\u0001\u001a\u00020pH\u0016J\"\u0010\u00cf\u0001\u001a\n\u0012\u0005\u0012\u00030\u00d1\u00010\u00d0\u00012\u0007\u0010\u00d2\u0001\u001a\u00020p2\u0006\u0010v\u001a\u00020pH\u0016R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\u001a\u0010<\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001a\u0010?\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)R\u001a\u0010B\u001a\u00020CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\u001a\u0010K\u001a\u00020CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010E\"\u0004\bM\u0010GR\u001a\u0010N\u001a\u00020CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010E\"\u0004\bP\u0010GR\u001a\u0010Q\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010'\"\u0004\bS\u0010)R\u001a\u0010T\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010'\"\u0004\bV\u0010)R\u001a\u0010W\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010'\"\u0004\bY\u0010)R\u001a\u0010Z\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010'\"\u0004\b\\\u0010)R\u001a\u0010]\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010'\"\u0004\b_\u0010)R\u001a\u0010`\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010'\"\u0004\bb\u0010)R\u001a\u0010c\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010'\"\u0004\be\u0010)R\u001a\u0010f\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010'\"\u0004\bh\u0010)R\u001a\u0010i\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010'\"\u0004\bk\u0010)R\u001a\u0010l\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010'\"\u0004\bn\u0010)R\u001a\u0010o\u001a\u00020pX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020pX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010q\"\u0004\bu\u0010sR\u001a\u0010v\u001a\u00020pX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010q\"\u0004\bw\u0010sR\u001a\u0010x\u001a\u00020pX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010q\"\u0004\by\u0010sR\u001a\u0010z\u001a\u00020pX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010q\"\u0004\b{\u0010sR\u001e\u0010|\u001a\u0004\u0018\u00010}X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010\u0082\u0001\u001a\u00020%X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010'\"\u0005\b\u0084\u0001\u0010)R\u001d\u0010\u0085\u0001\u001a\u00020%X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010'\"\u0005\b\u0087\u0001\u0010)R\u001d\u0010\u0088\u0001\u001a\u00020pX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010q\"\u0005\b\u008a\u0001\u0010sR\u001d\u0010\u008b\u0001\u001a\u00020pX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010q\"\u0005\b\u008c\u0001\u0010sR\u001d\u0010\u008d\u0001\u001a\u00020pX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010q\"\u0005\b\u008e\u0001\u0010sR\u001d\u0010\u008f\u0001\u001a\u00020CX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010E\"\u0005\b\u0091\u0001\u0010G\u00a8\u0006\u00d4\u0001"}, d2 = {"Lcom/nothing/device/IOTProductDevice;", "", "<init>", "()V", GlobalImplKt.DEVICE_LIST, "Ljava/util/HashSet;", "Lcom/nothing/device/IOTDevice;", "Lkotlin/collections/HashSet;", "getDeviceList", "()Ljava/util/HashSet;", "setDeviceList", "(Ljava/util/HashSet;)V", "action", "Lcom/nothing/device/IOTDeviceAction;", "getAction", "()Lcom/nothing/device/IOTDeviceAction;", "setAction", "(Lcom/nothing/device/IOTDeviceAction;)V", "osAction", "Lcom/nothing/device/IOTDeviceOsAction;", "getOsAction", "()Lcom/nothing/device/IOTDeviceOsAction;", "setOsAction", "(Lcom/nothing/device/IOTDeviceOsAction;)V", "gestureAction", "Lcom/nothing/device/IOTDeviceGestureAction;", "getGestureAction", "()Lcom/nothing/device/IOTDeviceGestureAction;", "setGestureAction", "(Lcom/nothing/device/IOTDeviceGestureAction;)V", "deviceType", "Lcom/nothing/base/router/device/DeviceType;", "getDeviceType", "()Lcom/nothing/base/router/device/DeviceType;", "setDeviceType", "(Lcom/nothing/base/router/device/DeviceType;)V", "deviceName", "", "getDeviceName", "()Ljava/lang/String;", "setDeviceName", "(Ljava/lang/String;)V", "helpDeviceName", "getHelpDeviceName", "setHelpDeviceName", "widgetAction", "Lcom/nothing/device/widget/IOTDeviceWidgetAction;", "getWidgetAction", "()Lcom/nothing/device/widget/IOTDeviceWidgetAction;", "setWidgetAction", "(Lcom/nothing/device/widget/IOTDeviceWidgetAction;)V", "uuid", "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "setUuid", "(Ljava/util/UUID;)V", "productId", "getProductId", "setProductId", "projectId", "getProjectId", "setProjectId", "productReleaseOrder", "getProductReleaseOrder", "setProductReleaseOrder", "supportImage", "", "getSupportImage", "()I", "setSupportImage", "(I)V", "caseImage", "getCaseImage", "setCaseImage", "introduceMsg", "getIntroduceMsg", "setIntroduceMsg", "introduceSummary", "getIntroduceSummary", "setIntroduceSummary", "leftDoubleGestureLottieJson", "getLeftDoubleGestureLottieJson", "setLeftDoubleGestureLottieJson", "rightDoubleGestureLottieJson", "getRightDoubleGestureLottieJson", "setRightDoubleGestureLottieJson", "leftTripleGestureLottieJson", "getLeftTripleGestureLottieJson", "setLeftTripleGestureLottieJson", "rightTripleGestureLottieJson", "getRightTripleGestureLottieJson", "setRightTripleGestureLottieJson", "leftLongPressGestureLottieJson", "getLeftLongPressGestureLottieJson", "setLeftLongPressGestureLottieJson", "rightLongPressGestureLottieJson", "getRightLongPressGestureLottieJson", "setRightLongPressGestureLottieJson", "leftDoublePinchGestureLottieJson", "getLeftDoublePinchGestureLottieJson", "setLeftDoublePinchGestureLottieJson", "rightDoublePinchGestureLottieJson", "getRightDoublePinchGestureLottieJson", "setRightDoublePinchGestureLottieJson", "personalizedLottieJson", "getPersonalizedLottieJson", "setPersonalizedLottieJson", "caseLottieJson", "getCaseLottieJson", "setCaseLottieJson", "isSupportFetchLog", "", "()Z", "setSupportFetchLog", "(Z)V", "isSupportReportIssue", "setSupportReportIssue", "isSupportCustomEQ", "setSupportCustomEQ", "isHasFeedback", "setHasFeedback", "isCmfText", "setCmfText", "protocol", "Lcom/nothing/protocol/model/ProtocolModel;", "getProtocol", "()Lcom/nothing/protocol/model/ProtocolModel;", "setProtocol", "(Lcom/nothing/protocol/model/ProtocolModel;)V", "pushTopic", "getPushTopic", "setPushTopic", "bluetoothName", "getBluetoothName", "setBluetoothName", "hasCurveDebugFunc", "getHasCurveDebugFunc", "setHasCurveDebugFunc", "isStereo", "setStereo", "isPublishDevice", "setPublishDevice", "scanHelpTitle", "getScanHelpTitle", "setScanHelpTitle", "needScanHelpItem", "supportSmartDial", "getSupportANCLevel", "supportAdvanceEq", "getTwsDeviceType", "getModelIdNeedVersion", "getColorNeedCrcCheck", "hasBassBoostFunction", "hasSpatialAudioFunction", "hasAudioDoFunction", "hasFirFunction", "hasNewFirFunction", "hasLeFunction", "hasBassEnhancerFunction", "hasMagicButton", "hasHeadTrack", "hasCaseUpdate", "initDevice", "", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "getTotalGain", "getProductDeviceMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getDeviceModel", "getHomeFragment", "Landroidx/fragment/app/Fragment;", "recreate", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "toString", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "createFunctionComponents", "Lcom/nothing/device/BaseFunctionComponents;", "context", "Landroid/content/Context;", "iotDevice", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "twsConnected", "supportSystemAudio", "hldcOrDiracOne", "needUpdateNoiseToWidget", "eqMutuallyExclusive", "essentialSpaceSync", "spaceEqExclusive", "initSimpleEQItem", "", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "isSystemPage", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IOTProductDevice {
    public static final int ANC_LEVEL_FOUR = 4;
    public static final int ANC_LEVEL_NONE = 255;
    public static final int ANC_LEVEL_THREE = 3;
    public static final int ANC_LEVEL_TWO = 2;
    public static final float FREQ_HIGH = 6900.0f;
    public static final float FREQ_LOW = 140.0f;
    public static final float FREQ_PEAK = 980.0f;
    public static final float Q_HIGH = 1.0f;
    public static final float Q_LOW = 0.8f;
    public static final float Q_PEAK = 0.7f;
    private String bluetoothName;
    private int caseImage;
    private String caseLottieJson;
    private boolean hasCurveDebugFunc;
    private int introduceMsg;
    private int introduceSummary;
    private boolean isCmfText;
    private boolean isHasFeedback;
    private boolean isPublishDevice;
    private boolean isStereo;
    private boolean isSupportCustomEQ;
    private boolean isSupportFetchLog;
    private boolean isSupportReportIssue;
    private String leftDoubleGestureLottieJson;
    private String leftDoublePinchGestureLottieJson;
    private String leftLongPressGestureLottieJson;
    private String leftTripleGestureLottieJson;
    private String personalizedLottieJson;
    private String productId;
    private String productReleaseOrder;
    private String projectId;
    private ProtocolModel protocol;
    private String pushTopic;
    private String rightDoubleGestureLottieJson;
    private String rightDoublePinchGestureLottieJson;
    private String rightLongPressGestureLottieJson;
    private String rightTripleGestureLottieJson;
    private int scanHelpTitle;
    private int supportImage;
    private UUID uuid;
    private IOTDeviceWidgetAction widgetAction;
    private HashSet<IOTDevice> deviceList = new HashSet<>();
    private IOTDeviceAction action = new IOTDeviceAction();
    private IOTDeviceOsAction osAction = new IOTDeviceOsAction();
    private IOTDeviceGestureAction gestureAction = new IOTDeviceGestureAction();
    private DeviceType deviceType = DeviceType.NONE;
    private String deviceName = "";
    private String helpDeviceName = "";

    public BaseNothingDevice createOSOTADevice(String address, String modelId) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return null;
    }

    public OTAProcess createOTAProcess() {
        return null;
    }

    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return null;
    }

    public boolean eqMutuallyExclusive() {
        return false;
    }

    public boolean essentialSpaceSync() {
        return true;
    }

    public boolean getColorNeedCrcCheck() {
        return true;
    }

    public Fragment getHomeFragment(boolean recreate) {
        return null;
    }

    public boolean getModelIdNeedVersion() {
        return false;
    }

    public int getSupportANCLevel() {
        return 2;
    }

    public float getTotalGain() {
        return 0.0f;
    }

    public int getTwsDeviceType() {
        return 1;
    }

    public boolean hasAudioDoFunction() {
        return false;
    }

    public boolean hasBassBoostFunction() {
        return false;
    }

    public boolean hasBassEnhancerFunction() {
        return false;
    }

    public boolean hasCaseUpdate() {
        return false;
    }

    public boolean hasFirFunction() {
        return false;
    }

    public boolean hasHeadTrack() {
        return false;
    }

    public boolean hasLeFunction() {
        return false;
    }

    public boolean hasMagicButton() {
        return false;
    }

    public boolean hasNewFirFunction() {
        return false;
    }

    public boolean hasSpatialAudioFunction() {
        return false;
    }

    public boolean hldcOrDiracOne() {
        return false;
    }

    public boolean needScanHelpItem() {
        return true;
    }

    public boolean needUpdateNoiseToWidget() {
        return false;
    }

    public boolean spaceEqExclusive() {
        return false;
    }

    public boolean supportAdvanceEq() {
        return false;
    }

    public boolean supportSmartDial() {
        return false;
    }

    public boolean supportSystemAudio() {
        return false;
    }

    public IOTProductDevice() {
        UUID uuidFromString = UUID.fromString("AEAC4A03-DFF5-498F-843A-34487CF133EB");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        this.uuid = uuidFromString;
        this.productId = "";
        this.projectId = "";
        this.productReleaseOrder = "0";
        this.supportImage = R.drawable.ear_support_default_3x;
        this.caseImage = R.drawable.ear_default_case_3x;
        this.introduceMsg = R.string.introduce_msg;
        this.introduceSummary = R.string.pair_guide_question_ear1;
        this.leftDoubleGestureLottieJson = "";
        this.rightDoubleGestureLottieJson = "";
        this.leftTripleGestureLottieJson = "";
        this.rightTripleGestureLottieJson = "";
        this.leftLongPressGestureLottieJson = "";
        this.rightLongPressGestureLottieJson = "";
        this.leftDoublePinchGestureLottieJson = "";
        this.rightDoublePinchGestureLottieJson = "";
        this.personalizedLottieJson = "";
        this.caseLottieJson = "";
        this.isSupportFetchLog = true;
        this.isSupportReportIssue = true;
        this.isSupportCustomEQ = true;
        this.isHasFeedback = true;
        this.pushTopic = "";
        this.bluetoothName = "";
        this.isPublishDevice = true;
        this.scanHelpTitle = R.string.introduce_title;
    }

    public final HashSet<IOTDevice> getDeviceList() {
        return this.deviceList;
    }

    public final void setDeviceList(HashSet<IOTDevice> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.deviceList = hashSet;
    }

    public final IOTDeviceAction getAction() {
        return this.action;
    }

    public final void setAction(IOTDeviceAction iOTDeviceAction) {
        Intrinsics.checkNotNullParameter(iOTDeviceAction, "<set-?>");
        this.action = iOTDeviceAction;
    }

    public final IOTDeviceOsAction getOsAction() {
        return this.osAction;
    }

    public final void setOsAction(IOTDeviceOsAction iOTDeviceOsAction) {
        Intrinsics.checkNotNullParameter(iOTDeviceOsAction, "<set-?>");
        this.osAction = iOTDeviceOsAction;
    }

    public final IOTDeviceGestureAction getGestureAction() {
        return this.gestureAction;
    }

    public final void setGestureAction(IOTDeviceGestureAction iOTDeviceGestureAction) {
        Intrinsics.checkNotNullParameter(iOTDeviceGestureAction, "<set-?>");
        this.gestureAction = iOTDeviceGestureAction;
    }

    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final void setDeviceType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<set-?>");
        this.deviceType = deviceType;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceName = str;
    }

    public final String getHelpDeviceName() {
        return this.helpDeviceName;
    }

    public final void setHelpDeviceName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.helpDeviceName = str;
    }

    public final IOTDeviceWidgetAction getWidgetAction() {
        return this.widgetAction;
    }

    public final void setWidgetAction(IOTDeviceWidgetAction iOTDeviceWidgetAction) {
        this.widgetAction = iOTDeviceWidgetAction;
    }

    public final UUID getUuid() {
        return this.uuid;
    }

    public final void setUuid(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<set-?>");
        this.uuid = uuid;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productId = str;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final void setProjectId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.projectId = str;
    }

    public final String getProductReleaseOrder() {
        return this.productReleaseOrder;
    }

    public final void setProductReleaseOrder(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.productReleaseOrder = str;
    }

    public final int getSupportImage() {
        return this.supportImage;
    }

    public final void setSupportImage(int i) {
        this.supportImage = i;
    }

    public final int getCaseImage() {
        return this.caseImage;
    }

    public final void setCaseImage(int i) {
        this.caseImage = i;
    }

    public final int getIntroduceMsg() {
        return this.introduceMsg;
    }

    public final void setIntroduceMsg(int i) {
        this.introduceMsg = i;
    }

    public final int getIntroduceSummary() {
        return this.introduceSummary;
    }

    public final void setIntroduceSummary(int i) {
        this.introduceSummary = i;
    }

    public final String getLeftDoubleGestureLottieJson() {
        return this.leftDoubleGestureLottieJson;
    }

    public final void setLeftDoubleGestureLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftDoubleGestureLottieJson = str;
    }

    public final String getRightDoubleGestureLottieJson() {
        return this.rightDoubleGestureLottieJson;
    }

    public final void setRightDoubleGestureLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightDoubleGestureLottieJson = str;
    }

    public final String getLeftTripleGestureLottieJson() {
        return this.leftTripleGestureLottieJson;
    }

    public final void setLeftTripleGestureLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftTripleGestureLottieJson = str;
    }

    public final String getRightTripleGestureLottieJson() {
        return this.rightTripleGestureLottieJson;
    }

    public final void setRightTripleGestureLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightTripleGestureLottieJson = str;
    }

    public final String getLeftLongPressGestureLottieJson() {
        return this.leftLongPressGestureLottieJson;
    }

    public final void setLeftLongPressGestureLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftLongPressGestureLottieJson = str;
    }

    public final String getRightLongPressGestureLottieJson() {
        return this.rightLongPressGestureLottieJson;
    }

    public final void setRightLongPressGestureLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightLongPressGestureLottieJson = str;
    }

    public final String getLeftDoublePinchGestureLottieJson() {
        return this.leftDoublePinchGestureLottieJson;
    }

    public final void setLeftDoublePinchGestureLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leftDoublePinchGestureLottieJson = str;
    }

    public final String getRightDoublePinchGestureLottieJson() {
        return this.rightDoublePinchGestureLottieJson;
    }

    public final void setRightDoublePinchGestureLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightDoublePinchGestureLottieJson = str;
    }

    public final String getPersonalizedLottieJson() {
        return this.personalizedLottieJson;
    }

    public final void setPersonalizedLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.personalizedLottieJson = str;
    }

    public final String getCaseLottieJson() {
        return this.caseLottieJson;
    }

    public final void setCaseLottieJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.caseLottieJson = str;
    }

    /* JADX INFO: renamed from: isSupportFetchLog, reason: from getter */
    public final boolean getIsSupportFetchLog() {
        return this.isSupportFetchLog;
    }

    public final void setSupportFetchLog(boolean z) {
        this.isSupportFetchLog = z;
    }

    /* JADX INFO: renamed from: isSupportReportIssue, reason: from getter */
    public final boolean getIsSupportReportIssue() {
        return this.isSupportReportIssue;
    }

    public final void setSupportReportIssue(boolean z) {
        this.isSupportReportIssue = z;
    }

    /* JADX INFO: renamed from: isSupportCustomEQ, reason: from getter */
    public final boolean getIsSupportCustomEQ() {
        return this.isSupportCustomEQ;
    }

    public final void setSupportCustomEQ(boolean z) {
        this.isSupportCustomEQ = z;
    }

    /* JADX INFO: renamed from: isHasFeedback, reason: from getter */
    public final boolean getIsHasFeedback() {
        return this.isHasFeedback;
    }

    public final void setHasFeedback(boolean z) {
        this.isHasFeedback = z;
    }

    /* JADX INFO: renamed from: isCmfText, reason: from getter */
    public final boolean getIsCmfText() {
        return this.isCmfText;
    }

    public final void setCmfText(boolean z) {
        this.isCmfText = z;
    }

    public final ProtocolModel getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(ProtocolModel protocolModel) {
        this.protocol = protocolModel;
    }

    public final String getPushTopic() {
        return this.pushTopic;
    }

    public final void setPushTopic(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pushTopic = str;
    }

    public final String getBluetoothName() {
        return this.bluetoothName;
    }

    public final void setBluetoothName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bluetoothName = str;
    }

    public final boolean getHasCurveDebugFunc() {
        return this.hasCurveDebugFunc;
    }

    public final void setHasCurveDebugFunc(boolean z) {
        this.hasCurveDebugFunc = z;
    }

    /* JADX INFO: renamed from: isStereo, reason: from getter */
    public final boolean getIsStereo() {
        return this.isStereo;
    }

    public final void setStereo(boolean z) {
        this.isStereo = z;
    }

    /* JADX INFO: renamed from: isPublishDevice, reason: from getter */
    public final boolean getIsPublishDevice() {
        return this.isPublishDevice;
    }

    public final void setPublishDevice(boolean z) {
        this.isPublishDevice = z;
    }

    public final int getScanHelpTitle() {
        return this.scanHelpTitle;
    }

    public final void setScanHelpTitle(int i) {
        this.scanHelpTitle = i;
    }

    public void initDevice() {
        for (IOTDevice iOTDevice : this.deviceList) {
            if (iOTDevice.getOverrideDeviceName()) {
                iOTDevice.setDeviceName(this.deviceName);
            }
            iOTDevice.setPushTopic(this.pushTopic);
        }
    }

    public Pair<Float, Float> getSimpleCustomEQParameter(int type) {
        Float fValueOf = Float.valueOf(0.0f);
        return new Pair<>(fValueOf, fValueOf);
    }

    public HashMap<String, String> getProductDeviceMap() {
        HashMap<String, String> map = new HashMap<>();
        Iterator<IOTDevice> it = this.deviceList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            IOTDevice next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            IOTDevice iOTDevice = next;
            HashMap<String, String> map2 = map;
            map2.put(iOTDevice.getModelId(), iOTDevice.getModelId());
            map2.put(iOTDevice.getProductId() + iOTDevice.getColor().getValue(), iOTDevice.getModelId());
        }
        return map;
    }

    /* JADX INFO: renamed from: getDeviceModel, reason: from getter */
    public String getProductId() {
        return this.productId;
    }

    public String toString() {
        return "productId:" + this.productId + ",deviceName:" + this.deviceName + ",deviceType:" + this.deviceType + ",deviceList:" + this.deviceList;
    }

    public HashMap<Integer, BaseFunctionComponents> createFunctionComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner, boolean twsConnected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        return new HashMap<>();
    }

    public List<EqualizerTypeViewModel> initSimpleEQItem(boolean isSystemPage, boolean isSupportCustomEQ) {
        int i;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList = new ArrayList();
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        Resources localizedResources = ContextExtKt.getLocalizedResources(application);
        ObservableField observableField = new ObservableField(localizedResources.getString(R.string.sound_balanced));
        if (isSystemPage) {
            i = R.drawable.os_balanced;
        } else {
            i = R.drawable.equalizer_balanced;
        }
        arrayList.add(new EqualizerTypeViewModel("0", observableField, 0, i, null, null, 0, SdkConfig.SDK_VERSION, null));
        ObservableField observableField2 = new ObservableField(localizedResources.getString(R.string.sound_more_bass));
        if (isSystemPage) {
            i2 = R.drawable.os_bass;
        } else {
            i2 = R.drawable.equalizer_bass;
        }
        arrayList.add(new EqualizerTypeViewModel("3", observableField2, 3, i2, null, null, 0, SdkConfig.SDK_VERSION, null));
        ObservableField observableField3 = new ObservableField(localizedResources.getString(R.string.sound_more_treble));
        if (isSystemPage) {
            i3 = R.drawable.os_treble;
        } else {
            i3 = R.drawable.equalizer_treble;
        }
        arrayList.add(new EqualizerTypeViewModel("2", observableField3, 2, i3, null, null, 0, SdkConfig.SDK_VERSION, null));
        ObservableField observableField4 = new ObservableField(localizedResources.getString(R.string.sound_more_voice));
        if (isSystemPage) {
            i4 = R.drawable.os_voice;
        } else {
            i4 = R.drawable.equalizer_voice;
        }
        arrayList.add(new EqualizerTypeViewModel("1", observableField4, 1, i4, null, null, 0, SdkConfig.SDK_VERSION, null));
        if (isSupportCustomEQ) {
            arrayList.add(new EqualizerTypeViewModel(DeviceConstant.NOISE_CANCELLATION_OFF, new ObservableField(localizedResources.getString(R.string.sound_eq_custom)), 5, 0, null, null, 0, SdkConfig.SDK_VERSION, null));
        }
        return arrayList;
    }
}
