package com.nothing.cardtransform.info;

import com.nothing.cardtransform.key.BatteryContainerKey;
import com.nothing.cardtransform.type.ParamType;
import com.nothing.cardtransform.type.ViewType;
import com.nothing.commBase.battery.CustomBattery;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatteryContainerInfo.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\u000e2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u001a\u001a\u00020\u0003*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/cardtransform/info/BatteryContainerInfo;", "Lcom/nothing/cardtransform/info/ViewInfo;", "viewId", "", "viewType", "", "(ILjava/lang/String;)V", "buildBatteryInfoJson", "Lorg/json/JSONArray;", "batteryInfoList", "Ljava/util/ArrayList;", "Lcom/nothing/commBase/battery/CustomBattery;", "Lkotlin/collections/ArrayList;", BatteryContainerKey.BATTERY_SET_AOD, "", "isAOD", "", BatteryContainerKey.BATTERY_SET_BATTERY_DISPLAY_RATIO, "ratio", "", BatteryContainerKey.BATTERY_SET_INFO_LIST, BatteryContainerKey.BATTERY_WIDGET_ID, "widgetId", BatteryContainerKey.BATTERY_PERMISSION_GRANTED, "isGranted", BatteryContainerKey.BATTERY_SET_SMALL_BATTERY_DISPLAY_RATIO, "getOrNull", "", "index", "CardClientLib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BatteryContainerInfo extends ViewInfo {
    public /* synthetic */ BatteryContainerInfo(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? ViewType.BATTERY_CONTAINER_VIEW : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatteryContainerInfo(int i, String viewType) {
        super(i, viewType);
        Intrinsics.checkNotNullParameter(viewType, "viewType");
    }

    public final void setSmallBatteryDisplayRatio(float ratio) throws JSONException {
        getJsonInfo().put(BatteryContainerKey.BATTERY_SET_SMALL_BATTERY_DISPLAY_RATIO, new ParamInfo(ParamType.INSTANCE.getFLOAT(), Float.valueOf(ratio)));
    }

    public final void setBatteryDisplayRatio(float ratio) throws JSONException {
        getJsonInfo().put(BatteryContainerKey.BATTERY_SET_BATTERY_DISPLAY_RATIO, new ParamInfo(ParamType.INSTANCE.getFLOAT(), Float.valueOf(ratio)));
    }

    public final void setBatteryInfo(ArrayList<CustomBattery> batteryInfoList) throws JSONException {
        Intrinsics.checkNotNullParameter(batteryInfoList, "batteryInfoList");
        getJsonInfo().put(BatteryContainerKey.BATTERY_SET_INFO_LIST, buildBatteryInfoJson(batteryInfoList));
    }

    public final void setPermission(boolean isGranted) throws JSONException {
        getJsonInfo().put(BatteryContainerKey.BATTERY_PERMISSION_GRANTED, new ParamInfo(ParamType.INSTANCE.getBOOLEAN(), Boolean.valueOf(isGranted)));
    }

    public final void setAODView(boolean isAOD) throws JSONException {
        getJsonInfo().put(BatteryContainerKey.BATTERY_SET_AOD, new ParamInfo(ParamType.INSTANCE.getBOOLEAN(), Boolean.valueOf(isAOD)));
    }

    public final void setBatteryWidgetId(int widgetId) throws JSONException {
        getJsonInfo().put(BatteryContainerKey.BATTERY_WIDGET_ID, widgetId);
    }

    private final JSONArray buildBatteryInfoJson(ArrayList<CustomBattery> batteryInfoList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (CustomBattery customBattery : batteryInfoList) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(BatteryContainerKey.BATTERY_ADDRESS, customBattery.getAddress());
            jSONObject.put(BatteryContainerKey.BATTERY_DEVICE_TYPE, customBattery.getDeviceType());
            jSONObject.put(BatteryContainerKey.BATTERY_DEVICE_NAME, customBattery.getDeviceName());
            jSONObject.put(BatteryContainerKey.BATTERY_MAIN_BATTERY, customBattery.getMainBattery());
            jSONObject.put(BatteryContainerKey.BATTERY_EAR_STATUS, customBattery.getBatteryStatus());
            jSONObject.put(BatteryContainerKey.BATTERY_CASE_STATUS, customBattery.getCaseBatteryStatus());
            jSONObject.put(BatteryContainerKey.BATTERY_CASE, customBattery.getCaseBattery());
            jSONObject.put(BatteryContainerKey.BATTERY_LEFT, customBattery.getLeftBattery());
            jSONObject.put(BatteryContainerKey.BATTERY_RIGHT, customBattery.getRightBattery());
            jSONObject.put(BatteryContainerKey.BATTERY_IS_ACTIVE, customBattery.isActive());
            jSONObject.put(BatteryContainerKey.BATTERY_CONNECTED_TIME, customBattery.getConnectedTime());
            jSONObject.put(BatteryContainerKey.BATTERY_LEFT_IMAGE, getOrNull(customBattery.getLeftImage(), 0));
            jSONObject.put(BatteryContainerKey.BATTERY_LEFT_IMAGE_AOD, getOrNull(customBattery.getLeftImage(), 1));
            jSONObject.put(BatteryContainerKey.BATTERY_RIGHT_IMAGE, getOrNull(customBattery.getRightImage(), 0));
            jSONObject.put(BatteryContainerKey.BATTERY_RIGHT_IMAGE_AOD, getOrNull(customBattery.getRightImage(), 1));
            jSONObject.put(BatteryContainerKey.BATTERY_CASE_IMAGE, getOrNull(customBattery.getCaseImage(), 0));
            jSONObject.put(BatteryContainerKey.BATTERY_CASE_IMAGE_AOD, getOrNull(customBattery.getCaseImage(), 1));
            jSONObject.put(BatteryContainerKey.BATTERY_GLOBAL_IMAGE, getOrNull(customBattery.getGlobalImage(), 0));
            jSONObject.put(BatteryContainerKey.BATTERY_GLOBAL_IMAGE_AOD, getOrNull(customBattery.getGlobalImage(), 1));
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private final int getOrNull(List<Integer> list, int i) {
        List<Integer> list2 = list;
        if (list2 == null || list2.isEmpty() || list.size() < i + 1) {
            return -1;
        }
        return list.get(i).intValue();
    }
}
