package com.nothing.link.bluetooth.sdk.scan.parser;

import android.os.Bundle;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.TikaCoreProperties;

/* JADX INFO: compiled from: NothingParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rJ\u001e\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rJ\f\u0010\u001c\u001a\u00020\u0004*\u0004\u0018\u00010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/parser/NothingParser;", "Lcom/nothing/link/bluetooth/sdk/scan/parser/IParser;", "()V", "enableFilterMacPrefix", "", "getEnableFilterMacPrefix", "()Z", "setEnableFilterMacPrefix", "(Z)V", "isInit", "setInit", "macPrefixCache", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMacPrefixCache", "()Ljava/util/ArrayList;", "addMacPrefix", "", "prefix", "buildBundle", "Landroid/os/Bundle;", "clearPrefix", "getDeviceType", "", "getRealMacAddress", "badMacAddress", "removePrefix", "isNothingAudioAddress", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class NothingParser implements IParser {
    public static final String COLOR_ID = "COLOR_ID";
    public static final String DEVICE_MODEL = "DEVICE_MODEL";
    public static final String DEVICE_TYPE = "DEVICE_TYPE";
    public static final int DEVICE_TYPE_EARBUDS = 0;
    public static final int DEVICE_TYPE_WATCH = 1;
    public static final String FAST_PAIRED_ID = "FAST_PAIRED_ID";
    public static final String IS_PAIRED = "IS_PAIRED";
    public static final String MAC_ADDRESS = "ADDRESS";
    public static final int MAC_ADDRESS_LENGTH = 12;
    public static final String MANUFACTURER_DATA = "MANUFACTURER_DATA";
    public static final int NOTHING_MANUFACTURER_ID_NEW = 3275;
    public static final String PRODUCT_COLOR_ID = "PRODUCT_COLOR_ID";
    public static final String PRODUCT_ID = "PRODUCT_ID";
    private boolean enableFilterMacPrefix;
    private boolean isInit;
    private final ArrayList<String> macPrefixCache;

    public int getDeviceType() {
        return 0;
    }

    public NothingParser() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.macPrefixCache = arrayList;
        arrayList.add("2CBEEB");
        arrayList.add("3CB0ED");
    }

    public final ArrayList<String> getMacPrefixCache() {
        return this.macPrefixCache;
    }

    /* JADX INFO: renamed from: isInit, reason: from getter */
    public final boolean getIsInit() {
        return this.isInit;
    }

    public final void setInit(boolean z) {
        this.isInit = z;
    }

    public final boolean getEnableFilterMacPrefix() {
        return this.enableFilterMacPrefix;
    }

    public final void setEnableFilterMacPrefix(boolean z) {
        this.enableFilterMacPrefix = z;
    }

    public final void addMacPrefix(ArrayList<String> prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.macPrefixCache.addAll(prefix);
    }

    public final void addMacPrefix(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.macPrefixCache.add(prefix);
    }

    public final void removePrefix(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.macPrefixCache.remove(prefix);
    }

    public final void clearPrefix() {
        this.macPrefixCache.clear();
    }

    public final boolean isNothingAudioAddress(String str) {
        if (str == null) {
            return false;
        }
        if (!this.isInit) {
            this.isInit = true;
            for (String str2 : XBluetoothManager.INSTANCE.get().getBluetoothConfig().getScanDeviceAddressesPrefix()) {
                ArrayList<String> arrayList = this.macPrefixCache;
                String upperCase = str2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                arrayList.add(StringsKt.replace$default(upperCase, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null));
            }
            this.enableFilterMacPrefix = XBluetoothManager.INSTANCE.get().getBluetoothConfig().getEnableFilterMacPrefix();
        }
        if (!this.enableFilterMacPrefix) {
            return true;
        }
        for (String str3 : this.macPrefixCache) {
            String upperCase2 = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            if (StringsKt.startsWith(StringsKt.replace$default(upperCase2, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null), str3, true)) {
                return true;
            }
        }
        return false;
    }

    public final Bundle buildBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(DEVICE_TYPE, getDeviceType());
        return bundle;
    }

    public String getRealMacAddress(String badMacAddress) {
        Intrinsics.checkNotNullParameter(badMacAddress, "badMacAddress");
        int length = badMacAddress.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            if (i % 2 != 0) {
                strArr[i - 1] = String.valueOf(badMacAddress.charAt(i));
            } else {
                strArr[i + 1] = String.valueOf(badMacAddress.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(strArr[i2]);
            if (i2 % 2 != 0 && i2 != length - 1) {
                sb.append(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
