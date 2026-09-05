package com.nothing.base.protocol.entity;

import android.util.Log;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: DeviceConfiguration.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0003\u0013\u0014\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/base/protocol/entity/DeviceConfiguration;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "configurations", "", "Lcom/nothing/base/protocol/entity/DeviceConfiguration$Configuration;", "getConfigurations", "()Ljava/util/List;", "getValue", "Lcom/nothing/base/protocol/entity/DeviceConfiguration$ConfigurationValue;", "device", "", "getSerialNumber", "", "obtainDataPacket", "toString", "Configuration", "ConfigurationValue", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceConfiguration implements ITWSParse {
    public static final int TYPE_COPY_SOFTWARE_VERSION = 3;
    public static final int TYPE_HARDWARE_VERSION = 1;
    public static final int TYPE_MANUFACTURE_DATE = 5;
    public static final int TYPE_SN = 4;
    public static final int TYPE_SOFTWARE_VERSION = 2;
    private final List<Configuration> configurations;

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return new byte[0];
    }

    public DeviceConfiguration(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "payload:" + DataExtKt.contentToHexString(payload) + StringUtils.SPACE;
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
        int intOrZero = DataExtKt.getIntOrZero(payload, 0);
        String strDecodeToString$default = StringsKt.decodeToString$default(payload, 1, 0, false, 6, null);
        ArrayList arrayList = new ArrayList();
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "size:" + intOrZero + " values:" + strDecodeToString$default;
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
        Iterator it = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) strDecodeToString$default).toString(), new String[]{"\n"}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt.split$default((CharSequence) it.next(), new String[]{","}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 3) {
                String str7 = (String) CollectionsKt.getOrNull(listSplit$default, 0);
                Integer numValueOf = str7 != null ? Integer.valueOf(Integer.parseInt(str7)) : null;
                String str8 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
                Integer numValueOf2 = str8 != null ? Integer.valueOf(Integer.parseInt(str8)) : null;
                String str9 = (String) CollectionsKt.getOrNull(listSplit$default, 2);
                if (numValueOf != null && numValueOf2 != null && str9 != null) {
                    arrayList.add(new Configuration(numValueOf.intValue(), numValueOf2.intValue(), str9));
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        this.configurations = arrayList2;
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str10 = "list:" + CollectionsKt.joinToString$default(arrayList2, null, null, null, 0, null, null, 63, null);
            String str11 = str10;
            if (str11 == null || str11.length() == 0) {
                return;
            }
            Pair<String, String> trace3 = logger3.getTrace(depth3);
            String strComponent5 = trace3.component1();
            String strComponent6 = trace3.component2();
            FileLog fileLog3 = FileLog.INSTANCE;
            String str12 = logger3.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
            FileLog.print$default(fileLog3, 3, str12, tag3, str10 + StringUtils.SPACE + strComponent6, null, 16, null);
            if (logger3.isDebug()) {
                Log.i(tag3 + strComponent5, str10 + StringUtils.SPACE + strComponent6);
            }
        }
    }

    public final List<Configuration> getConfigurations() {
        return this.configurations;
    }

    public final ConfigurationValue getValue(int device) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        List<Configuration> list = this.configurations;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Configuration) obj).getDevice() == device) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return null;
        }
        ArrayList arrayList3 = arrayList2;
        Iterator it = arrayList3.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Configuration) next).getType() != 1);
        Configuration configuration = (Configuration) next;
        String value = configuration != null ? configuration.getValue() : null;
        Iterator it2 = arrayList3.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (((Configuration) next2).getType() != 2);
        Configuration configuration2 = (Configuration) next2;
        String value2 = configuration2 != null ? configuration2.getValue() : null;
        Iterator it3 = arrayList3.iterator();
        do {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
        } while (((Configuration) next3).getType() != 3);
        Configuration configuration3 = (Configuration) next3;
        String value3 = configuration3 != null ? configuration3.getValue() : null;
        Iterator it4 = arrayList3.iterator();
        do {
            if (!it4.hasNext()) {
                next4 = null;
                break;
            }
            next4 = it4.next();
        } while (((Configuration) next4).getType() != 4);
        Configuration configuration4 = (Configuration) next4;
        String value4 = configuration4 != null ? configuration4.getValue() : null;
        Iterator it5 = arrayList3.iterator();
        do {
            if (!it5.hasNext()) {
                next5 = null;
                break;
            }
            next5 = it5.next();
        } while (((Configuration) next5).getType() != 5);
        Configuration configuration5 = (Configuration) next5;
        return new ConfigurationValue(device, value, value2, value3, value4, configuration5 != null ? configuration5.getValue() : null);
    }

    public final String getSerialNumber() {
        List<Configuration> list = this.configurations;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Configuration configuration = (Configuration) obj;
            if (configuration.getType() == 4 && configuration.getValue().length() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Configuration) it.next()).getValue());
        }
        return (String) CollectionsKt.firstOrNull((List) arrayList3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ConfigurationValue value = getValue(1);
        if (value != null) {
            sb.append(value.toString());
        }
        ConfigurationValue value2 = getValue(2);
        if (value2 != null) {
            sb.append(value2.toString());
        }
        ConfigurationValue value3 = getValue(3);
        if (value3 != null) {
            sb.append(value3.toString());
        }
        ConfigurationValue value4 = getValue(4);
        if (value4 != null) {
            sb.append(value4.toString());
        }
        ConfigurationValue value5 = getValue(5);
        if (value5 != null) {
            sb.append(value5.toString());
        }
        ConfigurationValue value6 = getValue(6);
        if (value6 != null) {
            sb.append(value6.toString());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: DeviceConfiguration.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/nothing/base/protocol/entity/DeviceConfiguration$Configuration;", "", "device", "", "type", "value", "", "<init>", "(IILjava/lang/String;)V", "getDevice", "()I", "getType", "getValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Configuration {
        private final int device;
        private final int type;
        private final String value;

        public static /* synthetic */ Configuration copy$default(Configuration configuration, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = configuration.device;
            }
            if ((i3 & 2) != 0) {
                i2 = configuration.type;
            }
            if ((i3 & 4) != 0) {
                str = configuration.value;
            }
            return configuration.copy(i, i2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDevice() {
            return this.device;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Configuration copy(int device, int type, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Configuration(device, type, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) other;
            return this.device == configuration.device && this.type == configuration.type && Intrinsics.areEqual(this.value, configuration.value);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.device) * 31) + Integer.hashCode(this.type)) * 31) + this.value.hashCode();
        }

        public String toString() {
            return "Configuration(device=" + this.device + ", type=" + this.type + ", value=" + this.value + ")";
        }

        public Configuration(int i, int i2, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.device = i;
            this.type = i2;
            this.value = value;
        }

        public final int getDevice() {
            return this.device;
        }

        public final int getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DeviceConfiguration.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0005H\u0016J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/nothing/base/protocol/entity/DeviceConfiguration$ConfigurationValue;", "", "device", "", "hardware", "", "software", "copySoftware", "sn", "manufactureDate", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDevice", "()I", "getHardware", "()Ljava/lang/String;", "getSoftware", "getCopySoftware", "getSn", "getManufactureDate", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ConfigurationValue {
        private final String copySoftware;
        private final int device;
        private final String hardware;
        private final String manufactureDate;
        private final String sn;
        private final String software;

        public static /* synthetic */ ConfigurationValue copy$default(ConfigurationValue configurationValue, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = configurationValue.device;
            }
            if ((i2 & 2) != 0) {
                str = configurationValue.hardware;
            }
            if ((i2 & 4) != 0) {
                str2 = configurationValue.software;
            }
            if ((i2 & 8) != 0) {
                str3 = configurationValue.copySoftware;
            }
            if ((i2 & 16) != 0) {
                str4 = configurationValue.sn;
            }
            if ((i2 & 32) != 0) {
                str5 = configurationValue.manufactureDate;
            }
            String str6 = str4;
            String str7 = str5;
            return configurationValue.copy(i, str, str2, str3, str6, str7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDevice() {
            return this.device;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getHardware() {
            return this.hardware;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSoftware() {
            return this.software;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCopySoftware() {
            return this.copySoftware;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSn() {
            return this.sn;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getManufactureDate() {
            return this.manufactureDate;
        }

        public final ConfigurationValue copy(int device, String hardware, String software, String copySoftware, String sn, String manufactureDate) {
            return new ConfigurationValue(device, hardware, software, copySoftware, sn, manufactureDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigurationValue)) {
                return false;
            }
            ConfigurationValue configurationValue = (ConfigurationValue) other;
            return this.device == configurationValue.device && Intrinsics.areEqual(this.hardware, configurationValue.hardware) && Intrinsics.areEqual(this.software, configurationValue.software) && Intrinsics.areEqual(this.copySoftware, configurationValue.copySoftware) && Intrinsics.areEqual(this.sn, configurationValue.sn) && Intrinsics.areEqual(this.manufactureDate, configurationValue.manufactureDate);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.device) * 31;
            String str = this.hardware;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.software;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.copySoftware;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.sn;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.manufactureDate;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public ConfigurationValue(int i, String str, String str2, String str3, String str4, String str5) {
            this.device = i;
            this.hardware = str;
            this.software = str2;
            this.copySoftware = str3;
            this.sn = str4;
            this.manufactureDate = str5;
        }

        public final int getDevice() {
            return this.device;
        }

        public final String getHardware() {
            return this.hardware;
        }

        public final String getSoftware() {
            return this.software;
        }

        public final String getCopySoftware() {
            return this.copySoftware;
        }

        public final String getSn() {
            return this.sn;
        }

        public final String getManufactureDate() {
            return this.manufactureDate;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            switch (this.device) {
                case 1:
                    sb.append("Watch ");
                    break;
                case 2:
                    sb.append("left ear ");
                    break;
                case 3:
                    sb.append("right ear ");
                    break;
                case 4:
                    sb.append("case");
                    break;
                case 5:
                    sb.append("TWS ");
                    break;
                case 6:
                    sb.append("Stereo ");
                    break;
            }
            String str = this.hardware;
            if (str != null && str.length() != 0) {
                sb.append("hardware version:" + this.hardware + ", ");
            }
            String str2 = this.software;
            if (str2 != null && str2.length() != 0) {
                sb.append("Software version:" + this.software + ", ");
            }
            String str3 = this.copySoftware;
            if (str3 != null && str3.length() != 0) {
                sb.append("Backup area software version:" + this.copySoftware + ", ");
            }
            String str4 = this.sn;
            if (str4 != null && str4.length() != 0) {
                sb.append("serial number:" + this.sn + ", ");
            }
            String str5 = this.manufactureDate;
            if (str5 != null && str5.length() != 0) {
                sb.append("Production Date:" + this.manufactureDate + ", ");
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }
}
