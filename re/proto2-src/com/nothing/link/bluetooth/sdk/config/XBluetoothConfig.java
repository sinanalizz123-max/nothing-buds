package com.nothing.link.bluetooth.sdk.config;

import com.nothing.link.bluetooth.sdk.scan.GpsWhiteList;
import com.nothing.link.bluetooth.sdk.scan.parser.IParser;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XBluetoothConfig.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 i2\u00020\u0001:\u0002hiB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010#\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010&\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\u001a\u0010,\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR\u001a\u0010/\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\nR\u001a\u00102\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u001a\u00105\u001a\u000206X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001fR\u001a\u0010>\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u001fR\u001a\u0010A\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\u001a\u0010D\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R*\u0010G\u001a\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR*\u0010O\u001a\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR*\u0010R\u001a\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010L\"\u0004\bT\u0010NR*\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u001b0Hj\b\u0012\u0004\u0012\u00020\u001b`JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010L\"\u0004\bW\u0010NR\u001a\u0010X\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0011\"\u0004\bZ\u0010\u0013R*\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\\0Hj\b\u0012\u0004\u0012\u00020\\`JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010L\"\u0004\b^\u0010NR\u001a\u0010_\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u001d\"\u0004\ba\u0010\u001fR\u001a\u0010b\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0011\"\u0004\bd\u0010\u0013R*\u0010e\u001a\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010L\"\u0004\bg\u0010N\u00a8\u0006j"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig;", "", "builder", "Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig$Builder;", "(Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig$Builder;)V", "autoConnect", "", "getAutoConnect", "()Z", "setAutoConnect", "(Z)V", "autoSetMtu", "getAutoSetMtu", "setAutoSetMtu", "bondPageTimeoutCooldownMs", "", "getBondPageTimeoutCooldownMs", "()J", "setBondPageTimeoutCooldownMs", "(J)V", "bondRetryBackoffMs", "", "getBondRetryBackoffMs", "()[J", "setBondRetryBackoffMs", "([J)V", "bondRetryMaxCount", "", "getBondRetryMaxCount", "()I", "setBondRetryMaxCount", "(I)V", "boundMillisTimeOut", "getBoundMillisTimeOut", "setBoundMillisTimeOut", "connectMillisTimeOut", "getConnectMillisTimeOut", "setConnectMillisTimeOut", "connectRetryCount", "getConnectRetryCount", "setConnectRetryCount", "connectRetryInterval", "getConnectRetryInterval", "setConnectRetryInterval", "containScanDeviceName", "getContainScanDeviceName", "setContainScanDeviceName", "enableFilterMacPrefix", "getEnableFilterMacPrefix", "setEnableFilterMacPrefix", "enableLog", "getEnableLog", "setEnableLog", "gpsWhiteList", "Lcom/nothing/link/bluetooth/sdk/scan/GpsWhiteList;", "getGpsWhiteList", "()Lcom/nothing/link/bluetooth/sdk/scan/GpsWhiteList;", "setGpsWhiteList", "(Lcom/nothing/link/bluetooth/sdk/scan/GpsWhiteList;)V", "maxConnectNum", "getMaxConnectNum", "setMaxConnectNum", "mtu", "getMtu", "setMtu", "operateInterval", "getOperateInterval", "setOperateInterval", "operateMillisTimeOut", "getOperateMillisTimeOut", "setOperateMillisTimeOut", "scanDeviceAddresses", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getScanDeviceAddresses", "()Ljava/util/ArrayList;", "setScanDeviceAddresses", "(Ljava/util/ArrayList;)V", "scanDeviceAddressesPrefix", "getScanDeviceAddressesPrefix", "setScanDeviceAddressesPrefix", "scanDeviceNames", "getScanDeviceNames", "setScanDeviceNames", "scanManufacturerIds", "getScanManufacturerIds", "setScanManufacturerIds", "scanMillisTimeOut", "getScanMillisTimeOut", "setScanMillisTimeOut", "scanRecordParsers", "Lcom/nothing/link/bluetooth/sdk/scan/parser/IParser;", "getScanRecordParsers", "setScanRecordParsers", "scanRetryCount", "getScanRetryCount", "setScanRetryCount", "scanRetryInterval", "getScanRetryInterval", "setScanRetryInterval", "scanServiceUuids", "getScanServiceUuids", "setScanServiceUuids", "Builder", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBluetoothConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean autoConnect;
    private boolean autoSetMtu;
    private long bondPageTimeoutCooldownMs;
    private long[] bondRetryBackoffMs;
    private int bondRetryMaxCount;
    private long boundMillisTimeOut;
    private long connectMillisTimeOut;
    private int connectRetryCount;
    private long connectRetryInterval;
    private boolean containScanDeviceName;
    private boolean enableFilterMacPrefix;
    private boolean enableLog;
    private GpsWhiteList gpsWhiteList;
    private int maxConnectNum;
    private int mtu;
    private long operateInterval;
    private long operateMillisTimeOut;
    private ArrayList<String> scanDeviceAddresses;
    private ArrayList<String> scanDeviceAddressesPrefix;
    private ArrayList<String> scanDeviceNames;
    private ArrayList<Integer> scanManufacturerIds;
    private long scanMillisTimeOut;
    private ArrayList<IParser> scanRecordParsers;
    private int scanRetryCount;
    private long scanRetryInterval;
    private ArrayList<String> scanServiceUuids;

    public /* synthetic */ XBluetoothConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    @JvmStatic
    public static final XBluetoothConfig getDefaultBleOptions() {
        return INSTANCE.getDefaultBleOptions();
    }

    private XBluetoothConfig(Builder builder) {
        this.scanServiceUuids = builder.getScanServiceUuids$nothinglink_bluetoothsdk_release();
        this.scanDeviceNames = builder.getScanDeviceNames$nothinglink_bluetoothsdk_release();
        this.scanRecordParsers = builder.getScanRecordParsers$nothinglink_bluetoothsdk_release();
        this.scanManufacturerIds = builder.getScanManufacturerIds$nothinglink_bluetoothsdk_release();
        this.scanDeviceAddresses = builder.getScanDeviceAddresses$nothinglink_bluetoothsdk_release();
        this.scanDeviceAddressesPrefix = builder.getScanDeviceAddressesPrefix$nothinglink_bluetoothsdk_release();
        this.containScanDeviceName = builder.getContainScanDeviceName();
        this.autoConnect = builder.getAutoConnect();
        this.enableLog = builder.getEnableLog();
        this.scanMillisTimeOut = builder.getScanMillisTimeOut();
        this.scanRetryCount = builder.getScanRetryCount();
        this.scanRetryInterval = builder.getScanRetryInterval();
        this.connectMillisTimeOut = builder.getConnectMillisTimeOut();
        this.boundMillisTimeOut = builder.getBoundMillisTimeOut();
        this.bondRetryMaxCount = builder.getBondRetryMaxCount();
        this.bondRetryBackoffMs = builder.getBondRetryBackoffMs();
        this.bondPageTimeoutCooldownMs = builder.getBondPageTimeoutCooldownMs();
        this.connectRetryCount = builder.getConnectRetryCount();
        this.connectRetryInterval = builder.getConnectRetryInterval();
        this.operateMillisTimeOut = builder.getOperateMillisTimeOut();
        this.operateInterval = builder.getOperateInterval();
        this.maxConnectNum = builder.getMaxConnectNum();
        this.mtu = builder.getMtu();
        this.autoSetMtu = builder.getAutoSetMtu();
        this.gpsWhiteList = builder.getGpsWhiteList();
        this.enableFilterMacPrefix = builder.getEnableFilterMacPrefix();
    }

    public final ArrayList<String> getScanServiceUuids() {
        return this.scanServiceUuids;
    }

    public final void setScanServiceUuids(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.scanServiceUuids = arrayList;
    }

    public final ArrayList<String> getScanDeviceNames() {
        return this.scanDeviceNames;
    }

    public final void setScanDeviceNames(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.scanDeviceNames = arrayList;
    }

    public final ArrayList<IParser> getScanRecordParsers() {
        return this.scanRecordParsers;
    }

    public final void setScanRecordParsers(ArrayList<IParser> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.scanRecordParsers = arrayList;
    }

    public final ArrayList<Integer> getScanManufacturerIds() {
        return this.scanManufacturerIds;
    }

    public final void setScanManufacturerIds(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.scanManufacturerIds = arrayList;
    }

    public final ArrayList<String> getScanDeviceAddresses() {
        return this.scanDeviceAddresses;
    }

    public final void setScanDeviceAddresses(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.scanDeviceAddresses = arrayList;
    }

    public final ArrayList<String> getScanDeviceAddressesPrefix() {
        return this.scanDeviceAddressesPrefix;
    }

    public final void setScanDeviceAddressesPrefix(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.scanDeviceAddressesPrefix = arrayList;
    }

    public final boolean getContainScanDeviceName() {
        return this.containScanDeviceName;
    }

    public final void setContainScanDeviceName(boolean z) {
        this.containScanDeviceName = z;
    }

    public final boolean getAutoConnect() {
        return this.autoConnect;
    }

    public final void setAutoConnect(boolean z) {
        this.autoConnect = z;
    }

    public final boolean getEnableLog() {
        return this.enableLog;
    }

    public final void setEnableLog(boolean z) {
        this.enableLog = z;
    }

    public final long getScanMillisTimeOut() {
        return this.scanMillisTimeOut;
    }

    public final void setScanMillisTimeOut(long j) {
        this.scanMillisTimeOut = j;
    }

    public final int getScanRetryCount() {
        return this.scanRetryCount;
    }

    public final void setScanRetryCount(int i) {
        this.scanRetryCount = i;
    }

    public final long getScanRetryInterval() {
        return this.scanRetryInterval;
    }

    public final void setScanRetryInterval(long j) {
        this.scanRetryInterval = j;
    }

    public final long getConnectMillisTimeOut() {
        return this.connectMillisTimeOut;
    }

    public final void setConnectMillisTimeOut(long j) {
        this.connectMillisTimeOut = j;
    }

    public final long getBoundMillisTimeOut() {
        return this.boundMillisTimeOut;
    }

    public final void setBoundMillisTimeOut(long j) {
        this.boundMillisTimeOut = j;
    }

    public final int getBondRetryMaxCount() {
        return this.bondRetryMaxCount;
    }

    public final void setBondRetryMaxCount(int i) {
        this.bondRetryMaxCount = i;
    }

    public final long[] getBondRetryBackoffMs() {
        return this.bondRetryBackoffMs;
    }

    public final void setBondRetryBackoffMs(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<set-?>");
        this.bondRetryBackoffMs = jArr;
    }

    public final long getBondPageTimeoutCooldownMs() {
        return this.bondPageTimeoutCooldownMs;
    }

    public final void setBondPageTimeoutCooldownMs(long j) {
        this.bondPageTimeoutCooldownMs = j;
    }

    public final int getConnectRetryCount() {
        return this.connectRetryCount;
    }

    public final void setConnectRetryCount(int i) {
        this.connectRetryCount = i;
    }

    public final long getConnectRetryInterval() {
        return this.connectRetryInterval;
    }

    public final void setConnectRetryInterval(long j) {
        this.connectRetryInterval = j;
    }

    public final long getOperateMillisTimeOut() {
        return this.operateMillisTimeOut;
    }

    public final void setOperateMillisTimeOut(long j) {
        this.operateMillisTimeOut = j;
    }

    public final long getOperateInterval() {
        return this.operateInterval;
    }

    public final void setOperateInterval(long j) {
        this.operateInterval = j;
    }

    public final int getMaxConnectNum() {
        return this.maxConnectNum;
    }

    public final void setMaxConnectNum(int i) {
        this.maxConnectNum = i;
    }

    public final int getMtu() {
        return this.mtu;
    }

    public final void setMtu(int i) {
        this.mtu = i;
    }

    public final boolean getAutoSetMtu() {
        return this.autoSetMtu;
    }

    public final void setAutoSetMtu(boolean z) {
        this.autoSetMtu = z;
    }

    public final GpsWhiteList getGpsWhiteList() {
        return this.gpsWhiteList;
    }

    public final void setGpsWhiteList(GpsWhiteList gpsWhiteList) {
        Intrinsics.checkNotNullParameter(gpsWhiteList, "<set-?>");
        this.gpsWhiteList = gpsWhiteList;
    }

    public final boolean getEnableFilterMacPrefix() {
        return this.enableFilterMacPrefix;
    }

    public final void setEnableFilterMacPrefix(boolean z) {
        this.enableFilterMacPrefix = z;
    }

    /* JADX INFO: compiled from: XBluetoothConfig.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig$Companion;", "", "()V", "builder", "Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig$Builder;", "getDefaultBleOptions", "Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final XBluetoothConfig getDefaultBleOptions() {
            return new XBluetoothConfig(new Builder(), null);
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }

    /* JADX INFO: compiled from: XBluetoothConfig.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010f\u001a\u00020gJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J$\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\rJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010k\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\rJ\u0016\u0010l\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\rJ\u000e\u0010m\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0004J\u000e\u0010o\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004J\u0010\u0010p\u001a\u00020\u00002\b\u0010q\u001a\u0004\u0018\u000104J\u000e\u0010r\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0019J\u000e\u0010s\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0019J\u0016\u0010s\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010t\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\rJ\u000e\u0010u\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\rJ\u001f\u0010v\u001a\u00020\u00002\u0012\u0010E\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0w\"\u00020G\u00a2\u0006\u0002\u0010xJ\u001f\u0010y\u001a\u00020\u00002\u0012\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0w\"\u00020G\u00a2\u0006\u0002\u0010xJ\u0012\u0010z\u001a\u00020\u00002\n\u0010S\u001a\u00020{\"\u00020\u0019J\u000e\u0010|\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\rJ\u001f\u0010}\u001a\u00020\u00002\u0012\u0010~\u001a\n\u0012\u0006\b\u0001\u0012\u00020Z0w\"\u00020Z\u00a2\u0006\u0002\u0010\u007fJ\u0017\u0010\u0080\u0001\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\rJ \u0010\u0081\u0001\u001a\u00020\u00002\u0012\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0w\"\u00020G\u00a2\u0006\u0002\u0010xR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001a\u0010'\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u000204X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u001a\u0010<\u001a\u00020\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001b\"\u0004\b>\u0010\u001dR\u001a\u0010?\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R\u001a\u0010B\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010\u0011R*\u0010E\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`HX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR*\u0010M\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`HX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR*\u0010P\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`HX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010J\"\u0004\bR\u0010LR*\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u00190Fj\b\u0012\u0004\u0012\u00020\u0019`HX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010J\"\u0004\bU\u0010LR\u001a\u0010V\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000f\"\u0004\bX\u0010\u0011R*\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020Z0Fj\b\u0012\u0004\u0012\u00020Z`HX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010J\"\u0004\b\\\u0010LR\u001a\u0010]\u001a\u00020\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u001b\"\u0004\b_\u0010\u001dR\u001a\u0010`\u001a\u00020\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u000f\"\u0004\bb\u0010\u0011R*\u0010c\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`HX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010J\"\u0004\be\u0010L\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig$Builder;", "", "()V", "autoConnect", "", "getAutoConnect$nothinglink_bluetoothsdk_release", "()Z", "setAutoConnect$nothinglink_bluetoothsdk_release", "(Z)V", "autoSetMtu", "getAutoSetMtu$nothinglink_bluetoothsdk_release", "setAutoSetMtu$nothinglink_bluetoothsdk_release", "bondPageTimeoutCooldownMs", "", "getBondPageTimeoutCooldownMs$nothinglink_bluetoothsdk_release", "()J", "setBondPageTimeoutCooldownMs$nothinglink_bluetoothsdk_release", "(J)V", "bondRetryBackoffMs", "", "getBondRetryBackoffMs$nothinglink_bluetoothsdk_release", "()[J", "setBondRetryBackoffMs$nothinglink_bluetoothsdk_release", "([J)V", "bondRetryMaxCount", "", "getBondRetryMaxCount$nothinglink_bluetoothsdk_release", "()I", "setBondRetryMaxCount$nothinglink_bluetoothsdk_release", "(I)V", "boundMillisTimeOut", "getBoundMillisTimeOut$nothinglink_bluetoothsdk_release", "setBoundMillisTimeOut$nothinglink_bluetoothsdk_release", "connectMillisTimeOut", "getConnectMillisTimeOut$nothinglink_bluetoothsdk_release", "setConnectMillisTimeOut$nothinglink_bluetoothsdk_release", "connectRetryCount", "getConnectRetryCount$nothinglink_bluetoothsdk_release", "setConnectRetryCount$nothinglink_bluetoothsdk_release", "connectRetryInterval", "getConnectRetryInterval$nothinglink_bluetoothsdk_release", "setConnectRetryInterval$nothinglink_bluetoothsdk_release", "containScanDeviceName", "getContainScanDeviceName$nothinglink_bluetoothsdk_release", "setContainScanDeviceName$nothinglink_bluetoothsdk_release", "enableFilterMacPrefix", "getEnableFilterMacPrefix$nothinglink_bluetoothsdk_release", "setEnableFilterMacPrefix$nothinglink_bluetoothsdk_release", "enableLog", "getEnableLog$nothinglink_bluetoothsdk_release", "setEnableLog$nothinglink_bluetoothsdk_release", "gpsWhiteList", "Lcom/nothing/link/bluetooth/sdk/scan/GpsWhiteList;", "getGpsWhiteList$nothinglink_bluetoothsdk_release", "()Lcom/nothing/link/bluetooth/sdk/scan/GpsWhiteList;", "setGpsWhiteList$nothinglink_bluetoothsdk_release", "(Lcom/nothing/link/bluetooth/sdk/scan/GpsWhiteList;)V", "maxConnectNum", "getMaxConnectNum$nothinglink_bluetoothsdk_release", "setMaxConnectNum$nothinglink_bluetoothsdk_release", "mtu", "getMtu$nothinglink_bluetoothsdk_release", "setMtu$nothinglink_bluetoothsdk_release", "operateInterval", "getOperateInterval$nothinglink_bluetoothsdk_release", "setOperateInterval$nothinglink_bluetoothsdk_release", "operateMillisTimeOut", "getOperateMillisTimeOut$nothinglink_bluetoothsdk_release", "setOperateMillisTimeOut$nothinglink_bluetoothsdk_release", "scanDeviceAddresses", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getScanDeviceAddresses$nothinglink_bluetoothsdk_release", "()Ljava/util/ArrayList;", "setScanDeviceAddresses$nothinglink_bluetoothsdk_release", "(Ljava/util/ArrayList;)V", "scanDeviceAddressesPrefix", "getScanDeviceAddressesPrefix$nothinglink_bluetoothsdk_release", "setScanDeviceAddressesPrefix$nothinglink_bluetoothsdk_release", "scanDeviceNames", "getScanDeviceNames$nothinglink_bluetoothsdk_release", "setScanDeviceNames$nothinglink_bluetoothsdk_release", "scanManufacturerIds", "getScanManufacturerIds$nothinglink_bluetoothsdk_release", "setScanManufacturerIds$nothinglink_bluetoothsdk_release", "scanMillisTimeOut", "getScanMillisTimeOut$nothinglink_bluetoothsdk_release", "setScanMillisTimeOut$nothinglink_bluetoothsdk_release", "scanRecordParsers", "Lcom/nothing/link/bluetooth/sdk/scan/parser/IParser;", "getScanRecordParsers$nothinglink_bluetoothsdk_release", "setScanRecordParsers$nothinglink_bluetoothsdk_release", "scanRetryCount", "getScanRetryCount$nothinglink_bluetoothsdk_release", "setScanRetryCount$nothinglink_bluetoothsdk_release", "scanRetryInterval", "getScanRetryInterval$nothinglink_bluetoothsdk_release", "setScanRetryInterval$nothinglink_bluetoothsdk_release", "scanServiceUuids", "getScanServiceUuids$nothinglink_bluetoothsdk_release", "setScanServiceUuids$nothinglink_bluetoothsdk_release", "build", "Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig;", "isContainScanDeviceName", "setBondRetryPolicy", "setBoundTimeOut", "setConnectMillisTimeOut", "setConnectRetryCountAndInterval", "setEnableFilterMacPrefix", "enable", "setEnableLog", "setGpsWhiteList", "gpsWhites", "setMaxConnectNum", "setMtu", "setOperateInterval", "setOperateMillisTimeOut", "setScanDeviceAddress", "", "([Ljava/lang/String;)Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig$Builder;", "setScanDeviceName", "setScanManufacturerId", "", "setScanMillisTimeOut", "setScanParser", "parsers", "([Lcom/nothing/link/bluetooth/sdk/scan/parser/IParser;)Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig$Builder;", "setScanRetryCountAndInterval", "setScanServiceUuid", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private boolean autoConnect;
        private boolean autoSetMtu;
        private long bondPageTimeoutCooldownMs;
        private long[] bondRetryBackoffMs;
        private int bondRetryMaxCount;
        private long boundMillisTimeOut;
        private long connectMillisTimeOut;
        private int connectRetryCount;
        private long connectRetryInterval;
        private boolean containScanDeviceName;
        private boolean enableFilterMacPrefix;
        private boolean enableLog;
        private GpsWhiteList gpsWhiteList;
        private int maxConnectNum;
        private int mtu;
        private long operateInterval;
        private long operateMillisTimeOut;
        private ArrayList<String> scanDeviceAddressesPrefix;
        private long scanMillisTimeOut;
        private int scanRetryCount;
        private long scanRetryInterval;
        private ArrayList<String> scanServiceUuids = new ArrayList<>(1);
        private ArrayList<String> scanDeviceNames = new ArrayList<>(1);
        private ArrayList<IParser> scanRecordParsers = new ArrayList<>(1);
        private ArrayList<Integer> scanManufacturerIds = new ArrayList<>(1);
        private ArrayList<String> scanDeviceAddresses = new ArrayList<>(1);

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean gpsWhiteList$lambda$1() {
            return false;
        }

        public Builder() {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add("2C:BE");
            this.scanDeviceAddressesPrefix = arrayList;
            this.enableLog = true;
            this.scanMillisTimeOut = 10000L;
            this.scanRetryInterval = 1000L;
            this.connectMillisTimeOut = 40000L;
            this.boundMillisTimeOut = 60000L;
            this.bondRetryMaxCount = 2;
            long[] default_bond_retry_backoff_ms = Constants.INSTANCE.getDEFAULT_BOND_RETRY_BACKOFF_MS();
            long[] jArrCopyOf = Arrays.copyOf(default_bond_retry_backoff_ms, default_bond_retry_backoff_ms.length);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.bondRetryBackoffMs = jArrCopyOf;
            this.bondPageTimeoutCooldownMs = 120000L;
            this.connectRetryInterval = 1000L;
            this.operateMillisTimeOut = 10000L;
            this.operateInterval = 100L;
            this.maxConnectNum = 5;
            this.mtu = Constants.DEFAULT_MTU;
            this.autoSetMtu = true;
            this.gpsWhiteList = new GpsWhiteList() { // from class: com.nothing.link.bluetooth.sdk.config.XBluetoothConfig$Builder$$ExternalSyntheticLambda0
                @Override // com.nothing.link.bluetooth.sdk.scan.GpsWhiteList
                public final boolean isNeedGspOpen() {
                    return XBluetoothConfig.Builder.gpsWhiteList$lambda$1();
                }
            };
        }

        public final ArrayList<String> getScanServiceUuids$nothinglink_bluetoothsdk_release() {
            return this.scanServiceUuids;
        }

        public final void setScanServiceUuids$nothinglink_bluetoothsdk_release(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.scanServiceUuids = arrayList;
        }

        public final ArrayList<String> getScanDeviceNames$nothinglink_bluetoothsdk_release() {
            return this.scanDeviceNames;
        }

        public final void setScanDeviceNames$nothinglink_bluetoothsdk_release(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.scanDeviceNames = arrayList;
        }

        public final ArrayList<IParser> getScanRecordParsers$nothinglink_bluetoothsdk_release() {
            return this.scanRecordParsers;
        }

        public final void setScanRecordParsers$nothinglink_bluetoothsdk_release(ArrayList<IParser> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.scanRecordParsers = arrayList;
        }

        public final ArrayList<Integer> getScanManufacturerIds$nothinglink_bluetoothsdk_release() {
            return this.scanManufacturerIds;
        }

        public final void setScanManufacturerIds$nothinglink_bluetoothsdk_release(ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.scanManufacturerIds = arrayList;
        }

        public final ArrayList<String> getScanDeviceAddresses$nothinglink_bluetoothsdk_release() {
            return this.scanDeviceAddresses;
        }

        public final void setScanDeviceAddresses$nothinglink_bluetoothsdk_release(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.scanDeviceAddresses = arrayList;
        }

        public final ArrayList<String> getScanDeviceAddressesPrefix$nothinglink_bluetoothsdk_release() {
            return this.scanDeviceAddressesPrefix;
        }

        public final void setScanDeviceAddressesPrefix$nothinglink_bluetoothsdk_release(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.scanDeviceAddressesPrefix = arrayList;
        }

        /* JADX INFO: renamed from: getContainScanDeviceName$nothinglink_bluetoothsdk_release, reason: from getter */
        public final boolean getContainScanDeviceName() {
            return this.containScanDeviceName;
        }

        public final void setContainScanDeviceName$nothinglink_bluetoothsdk_release(boolean z) {
            this.containScanDeviceName = z;
        }

        /* JADX INFO: renamed from: getAutoConnect$nothinglink_bluetoothsdk_release, reason: from getter */
        public final boolean getAutoConnect() {
            return this.autoConnect;
        }

        public final void setAutoConnect$nothinglink_bluetoothsdk_release(boolean z) {
            this.autoConnect = z;
        }

        /* JADX INFO: renamed from: getEnableLog$nothinglink_bluetoothsdk_release, reason: from getter */
        public final boolean getEnableLog() {
            return this.enableLog;
        }

        public final void setEnableLog$nothinglink_bluetoothsdk_release(boolean z) {
            this.enableLog = z;
        }

        /* JADX INFO: renamed from: getScanMillisTimeOut$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long getScanMillisTimeOut() {
            return this.scanMillisTimeOut;
        }

        public final void setScanMillisTimeOut$nothinglink_bluetoothsdk_release(long j) {
            this.scanMillisTimeOut = j;
        }

        /* JADX INFO: renamed from: getScanRetryCount$nothinglink_bluetoothsdk_release, reason: from getter */
        public final int getScanRetryCount() {
            return this.scanRetryCount;
        }

        public final void setScanRetryCount$nothinglink_bluetoothsdk_release(int i) {
            this.scanRetryCount = i;
        }

        /* JADX INFO: renamed from: getScanRetryInterval$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long getScanRetryInterval() {
            return this.scanRetryInterval;
        }

        public final void setScanRetryInterval$nothinglink_bluetoothsdk_release(long j) {
            this.scanRetryInterval = j;
        }

        /* JADX INFO: renamed from: getConnectMillisTimeOut$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long getConnectMillisTimeOut() {
            return this.connectMillisTimeOut;
        }

        public final void setConnectMillisTimeOut$nothinglink_bluetoothsdk_release(long j) {
            this.connectMillisTimeOut = j;
        }

        /* JADX INFO: renamed from: getBoundMillisTimeOut$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long getBoundMillisTimeOut() {
            return this.boundMillisTimeOut;
        }

        public final void setBoundMillisTimeOut$nothinglink_bluetoothsdk_release(long j) {
            this.boundMillisTimeOut = j;
        }

        /* JADX INFO: renamed from: getBondRetryMaxCount$nothinglink_bluetoothsdk_release, reason: from getter */
        public final int getBondRetryMaxCount() {
            return this.bondRetryMaxCount;
        }

        public final void setBondRetryMaxCount$nothinglink_bluetoothsdk_release(int i) {
            this.bondRetryMaxCount = i;
        }

        /* JADX INFO: renamed from: getBondRetryBackoffMs$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long[] getBondRetryBackoffMs() {
            return this.bondRetryBackoffMs;
        }

        public final void setBondRetryBackoffMs$nothinglink_bluetoothsdk_release(long[] jArr) {
            Intrinsics.checkNotNullParameter(jArr, "<set-?>");
            this.bondRetryBackoffMs = jArr;
        }

        /* JADX INFO: renamed from: getBondPageTimeoutCooldownMs$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long getBondPageTimeoutCooldownMs() {
            return this.bondPageTimeoutCooldownMs;
        }

        public final void setBondPageTimeoutCooldownMs$nothinglink_bluetoothsdk_release(long j) {
            this.bondPageTimeoutCooldownMs = j;
        }

        /* JADX INFO: renamed from: getConnectRetryCount$nothinglink_bluetoothsdk_release, reason: from getter */
        public final int getConnectRetryCount() {
            return this.connectRetryCount;
        }

        public final void setConnectRetryCount$nothinglink_bluetoothsdk_release(int i) {
            this.connectRetryCount = i;
        }

        /* JADX INFO: renamed from: getConnectRetryInterval$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long getConnectRetryInterval() {
            return this.connectRetryInterval;
        }

        public final void setConnectRetryInterval$nothinglink_bluetoothsdk_release(long j) {
            this.connectRetryInterval = j;
        }

        /* JADX INFO: renamed from: getOperateMillisTimeOut$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long getOperateMillisTimeOut() {
            return this.operateMillisTimeOut;
        }

        public final void setOperateMillisTimeOut$nothinglink_bluetoothsdk_release(long j) {
            this.operateMillisTimeOut = j;
        }

        /* JADX INFO: renamed from: getOperateInterval$nothinglink_bluetoothsdk_release, reason: from getter */
        public final long getOperateInterval() {
            return this.operateInterval;
        }

        public final void setOperateInterval$nothinglink_bluetoothsdk_release(long j) {
            this.operateInterval = j;
        }

        /* JADX INFO: renamed from: getMaxConnectNum$nothinglink_bluetoothsdk_release, reason: from getter */
        public final int getMaxConnectNum() {
            return this.maxConnectNum;
        }

        public final void setMaxConnectNum$nothinglink_bluetoothsdk_release(int i) {
            this.maxConnectNum = i;
        }

        /* JADX INFO: renamed from: getMtu$nothinglink_bluetoothsdk_release, reason: from getter */
        public final int getMtu() {
            return this.mtu;
        }

        public final void setMtu$nothinglink_bluetoothsdk_release(int i) {
            this.mtu = i;
        }

        /* JADX INFO: renamed from: getAutoSetMtu$nothinglink_bluetoothsdk_release, reason: from getter */
        public final boolean getAutoSetMtu() {
            return this.autoSetMtu;
        }

        public final void setAutoSetMtu$nothinglink_bluetoothsdk_release(boolean z) {
            this.autoSetMtu = z;
        }

        /* JADX INFO: renamed from: getGpsWhiteList$nothinglink_bluetoothsdk_release, reason: from getter */
        public final GpsWhiteList getGpsWhiteList() {
            return this.gpsWhiteList;
        }

        public final void setGpsWhiteList$nothinglink_bluetoothsdk_release(GpsWhiteList gpsWhiteList) {
            Intrinsics.checkNotNullParameter(gpsWhiteList, "<set-?>");
            this.gpsWhiteList = gpsWhiteList;
        }

        /* JADX INFO: renamed from: getEnableFilterMacPrefix$nothinglink_bluetoothsdk_release, reason: from getter */
        public final boolean getEnableFilterMacPrefix() {
            return this.enableFilterMacPrefix;
        }

        public final void setEnableFilterMacPrefix$nothinglink_bluetoothsdk_release(boolean z) {
            this.enableFilterMacPrefix = z;
        }

        public final Builder setEnableFilterMacPrefix(boolean enable) {
            this.enableFilterMacPrefix = enable;
            return this;
        }

        public final Builder setGpsWhiteList(GpsWhiteList gpsWhites) {
            if (gpsWhites != null) {
                this.gpsWhiteList = gpsWhites;
            }
            return this;
        }

        public final Builder setScanServiceUuid(String... scanServiceUuids) {
            Intrinsics.checkNotNullParameter(scanServiceUuids, "scanServiceUuids");
            for (String str : scanServiceUuids) {
                if (str.length() > 0) {
                    this.scanServiceUuids.add(str);
                }
            }
            return this;
        }

        public final Builder setScanDeviceName(String... scanDeviceNames) {
            Intrinsics.checkNotNullParameter(scanDeviceNames, "scanDeviceNames");
            for (String str : scanDeviceNames) {
                if (str.length() > 0) {
                    this.scanDeviceNames.add(str);
                }
            }
            return this;
        }

        public final Builder setScanManufacturerId(int... scanManufacturerIds) {
            Intrinsics.checkNotNullParameter(scanManufacturerIds, "scanManufacturerIds");
            for (int i : scanManufacturerIds) {
                this.scanManufacturerIds.add(Integer.valueOf(i));
            }
            return this;
        }

        public final Builder setScanParser(IParser... parsers) {
            Intrinsics.checkNotNullParameter(parsers, "parsers");
            for (IParser iParser : parsers) {
                this.scanRecordParsers.add(iParser);
            }
            return this;
        }

        public final Builder setScanDeviceAddress(String... scanDeviceAddresses) {
            Intrinsics.checkNotNullParameter(scanDeviceAddresses, "scanDeviceAddresses");
            for (String str : scanDeviceAddresses) {
                if (str.length() > 0) {
                    this.scanDeviceAddresses.add(str);
                }
            }
            return this;
        }

        public final Builder isContainScanDeviceName(boolean containScanDeviceName) {
            this.containScanDeviceName = containScanDeviceName;
            return this;
        }

        public final Builder setBoundTimeOut(long boundMillisTimeOut) {
            this.boundMillisTimeOut = boundMillisTimeOut;
            return this;
        }

        public static /* synthetic */ Builder setBondRetryPolicy$default(Builder builder, int i, long[] jArr, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 2;
            }
            if ((i2 & 2) != 0) {
                jArr = Constants.INSTANCE.getDEFAULT_BOND_RETRY_BACKOFF_MS();
            }
            if ((i2 & 4) != 0) {
                j = 120000;
            }
            return builder.setBondRetryPolicy(i, jArr, j);
        }

        public final Builder setBondRetryPolicy(int bondRetryMaxCount, long[] bondRetryBackoffMs, long bondPageTimeoutCooldownMs) {
            Intrinsics.checkNotNullParameter(bondRetryBackoffMs, "bondRetryBackoffMs");
            this.bondRetryMaxCount = bondRetryMaxCount;
            if (!(bondRetryBackoffMs.length == 0)) {
                long[] jArrCopyOf = Arrays.copyOf(bondRetryBackoffMs, bondRetryBackoffMs.length);
                Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
                this.bondRetryBackoffMs = jArrCopyOf;
            }
            this.bondPageTimeoutCooldownMs = bondPageTimeoutCooldownMs;
            return this;
        }

        public final Builder setScanMillisTimeOut(long scanMillisTimeOut) {
            this.scanMillisTimeOut = scanMillisTimeOut;
            return this;
        }

        public final Builder setScanRetryCountAndInterval(int scanRetryCount, long scanRetryInterval) {
            this.scanRetryCount = scanRetryCount;
            this.scanRetryInterval = scanRetryInterval;
            return this;
        }

        public final Builder setEnableLog(boolean enableLog) {
            this.enableLog = enableLog;
            return this;
        }

        public final Builder setConnectMillisTimeOut(long connectMillisTimeOut) {
            this.connectMillisTimeOut = connectMillisTimeOut;
            return this;
        }

        public final Builder setConnectRetryCountAndInterval(int connectRetryCount, long connectRetryInterval) {
            this.connectRetryCount = connectRetryCount;
            this.connectRetryInterval = connectRetryInterval;
            return this;
        }

        public final Builder setOperateMillisTimeOut(long operateMillisTimeOut) {
            this.operateMillisTimeOut = operateMillisTimeOut;
            return this;
        }

        public final Builder setOperateInterval(long operateInterval) {
            this.operateInterval = operateInterval;
            return this;
        }

        public final Builder setMaxConnectNum(int maxConnectNum) {
            this.maxConnectNum = maxConnectNum;
            return this;
        }

        public final Builder setMtu(int mtu) {
            setMtu(mtu, true);
            return this;
        }

        public final Builder setMtu(int mtu, boolean autoSetMtu) {
            this.mtu = mtu;
            this.autoSetMtu = autoSetMtu;
            return this;
        }

        public final XBluetoothConfig build() {
            return new XBluetoothConfig(this, null);
        }
    }
}
