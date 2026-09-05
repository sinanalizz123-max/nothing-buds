package com.nothing.cardwidget.battery;

import com.nothing.cardwidget.battery.view.BatteryContainerViewKt;
import com.nothing.commBase.battery.CustomBattery;
import com.nothing.xservice.InnerTransferKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryStateManager.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u0014\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aJ\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0007J\n\u0010\u001d\u001a\u00020\u0012*\u00020\u0012J\u0012\u0010\u001e\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0004J\u0012\u0010\u001f\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR6\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR6\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/nothing/cardwidget/battery/BatteryStateManager;", "", "()V", "TAG", "", "batteryStateInfo", "Ljava/util/HashMap;", "Lcom/nothing/cardwidget/battery/BatteryConfig$BatteryState;", "Lkotlin/collections/HashMap;", "getBatteryStateInfo", "()Ljava/util/HashMap;", "setBatteryStateInfo", "(Ljava/util/HashMap;)V", "caseBatteryInfo", "", "getCaseBatteryInfo", "setCaseBatteryInfo", "currentHandleBatteryInfo", "Lcom/nothing/commBase/battery/CustomBattery;", "getCurrentHandleBatteryInfo", "setCurrentHandleBatteryInfo", "clearBatteryState", "", InnerTransferKey.UNIQUE_ID, "clearOldCachedBatteryInfo", "newAddresses", "", "setBatteryState", "state", "earProductsOnCombine", "initState", "queryBatteryState", "CardWidgetLib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BatteryStateManager {
    private static final String TAG = "BatteryStateManager";
    public static final BatteryStateManager INSTANCE = new BatteryStateManager();
    private static HashMap<String, Integer> caseBatteryInfo = new HashMap<>();
    private static HashMap<String, BatteryConfig.BatteryState> batteryStateInfo = new HashMap<>();
    private static HashMap<String, CustomBattery> currentHandleBatteryInfo = new HashMap<>();

    private BatteryStateManager() {
    }

    public final HashMap<String, Integer> getCaseBatteryInfo() {
        return caseBatteryInfo;
    }

    public final void setCaseBatteryInfo(HashMap<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        caseBatteryInfo = map;
    }

    public final HashMap<String, BatteryConfig.BatteryState> getBatteryStateInfo() {
        return batteryStateInfo;
    }

    public final void setBatteryStateInfo(HashMap<String, BatteryConfig.BatteryState> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        batteryStateInfo = map;
    }

    public final HashMap<String, CustomBattery> getCurrentHandleBatteryInfo() {
        return currentHandleBatteryInfo;
    }

    public final void setCurrentHandleBatteryInfo(HashMap<String, CustomBattery> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        currentHandleBatteryInfo = map;
    }

    public final BatteryConfig.BatteryState queryBatteryState(CustomBattery customBattery, String uniqueId) {
        Intrinsics.checkNotNullParameter(customBattery, "<this>");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        BatteryConfig.BatteryState batteryState = batteryStateInfo.get(uniqueId);
        return batteryState == null ? INSTANCE.initState(customBattery, uniqueId) : batteryState;
    }

    public final BatteryConfig.BatteryState initState(CustomBattery customBattery, String uniqueId) {
        Intrinsics.checkNotNullParameter(customBattery, "<this>");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        if (customBattery.getCaseBattery() != -1) {
            setBatteryState(uniqueId, BatteryConfig.BatteryState.INIT_IN_CASE);
            return BatteryConfig.BatteryState.INIT_IN_CASE;
        }
        setBatteryState(uniqueId, BatteryConfig.BatteryState.NORMAL);
        return BatteryConfig.BatteryState.NORMAL;
    }

    public final void setBatteryState(String uniqueId, BatteryConfig.BatteryState state) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(state, "state");
        batteryStateInfo.put(uniqueId, state);
    }

    public final void clearBatteryState(String uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        batteryStateInfo.remove(uniqueId);
    }

    public final void clearOldCachedBatteryInfo(Set<String> newAddresses) {
        Intrinsics.checkNotNullParameter(newAddresses, "newAddresses");
        HashMap<String, CustomBattery> map = currentHandleBatteryInfo;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, CustomBattery> entry : map.entrySet()) {
            if (!newAddresses.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(currentHandleBatteryInfo.remove(((Map.Entry) it.next()).getKey()));
        }
        HashMap<String, Integer> map2 = caseBatteryInfo;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
            if (!newAddresses.contains(entry2.getKey())) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap2.size());
        Iterator it2 = linkedHashMap2.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList2.add(caseBatteryInfo.remove(((Map.Entry) it2.next()).getKey()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e9  */
    public final CustomBattery earProductsOnCombine(CustomBattery customBattery) {
        int leftBattery;
        List<Integer> leftImage;
        int leftBattery2;
        Intrinsics.checkNotNullParameter(customBattery, "<this>");
        String deviceType = customBattery.getDeviceType();
        int iHashCode = deviceType.hashCode();
        if (iHashCode != -273684744) {
            if (iHashCode != -79410817) {
                if (iHashCode == 1386738378 && deviceType.equals("NOTHINGX_DEVICE")) {
                    if (!BatteryContainerViewKt.isSingleBattery(customBattery)) {
                        if (customBattery.getLeftBattery() == -1 && customBattery.getRightBattery() != -1) {
                            leftBattery = Math.min(customBattery.getLeftBattery(), customBattery.getRightBattery());
                            leftImage = customBattery.getGlobalImage();
                        } else if (customBattery.getLeftBattery() != -1 && customBattery.getRightBattery() != -1) {
                            leftBattery = customBattery.getRightBattery();
                            leftImage = customBattery.getRightImage();
                        } else {
                            leftBattery = customBattery.getLeftBattery();
                            leftImage = customBattery.getLeftImage();
                        }
                        return new CustomBattery(customBattery.getAddress(), customBattery.getDeviceType(), customBattery.getDeviceName(), leftBattery, customBattery.getBatteryStatus(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBattery(), customBattery.getLeftBattery(), customBattery.getRightBattery(), customBattery.isActive(), customBattery.getConnectedTime(), null, null, null, leftImage, 14336, null);
                    }
                }
            } else if (deviceType.equals("FASTPAIR_DEVICE") && !BatteryContainerViewKt.isSingleBattery(customBattery)) {
                if (customBattery.getLeftBattery() == -1 || customBattery.getRightBattery() == -1) {
                    leftBattery2 = (customBattery.getLeftBattery() != -1 || customBattery.getRightBattery() == -1) ? customBattery.getLeftBattery() : customBattery.getRightBattery();
                } else {
                    leftBattery2 = Math.min(customBattery.getLeftBattery(), customBattery.getRightBattery());
                }
                return new CustomBattery(customBattery.getAddress(), customBattery.getDeviceType(), customBattery.getDeviceName(), leftBattery2, customBattery.getBatteryStatus(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBattery(), customBattery.getLeftBattery(), customBattery.getRightBattery(), customBattery.isActive(), customBattery.getConnectedTime(), null, null, null, customBattery.getGlobalImage(), 14336, null);
            }
        } else if (deviceType.equals("AIRPODS")) {
            if (!BatteryContainerViewKt.isSingleBattery(customBattery)) {
                if (customBattery.getLeftBattery() == -1) {
                    if (customBattery.getLeftBattery() != -1) {
                        leftBattery = customBattery.getLeftBattery();
                        leftImage = customBattery.getLeftImage();
                    } else {
                        leftBattery = customBattery.getLeftBattery();
                        leftImage = customBattery.getLeftImage();
                    }
                } else if (customBattery.getLeftBattery() != -1) {
                    leftBattery = customBattery.getLeftBattery();
                    leftImage = customBattery.getLeftImage();
                } else {
                    leftBattery = customBattery.getLeftBattery();
                    leftImage = customBattery.getLeftImage();
                }
                return new CustomBattery(customBattery.getAddress(), customBattery.getDeviceType(), customBattery.getDeviceName(), leftBattery, customBattery.getBatteryStatus(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBattery(), customBattery.getLeftBattery(), customBattery.getRightBattery(), customBattery.isActive(), customBattery.getConnectedTime(), null, null, null, leftImage, 14336, null);
            }
        }
        return customBattery;
    }
}
