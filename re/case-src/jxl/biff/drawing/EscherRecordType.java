package jxl.biff.drawing;

import com.nothing.base.protocol.constant.ProtocolConstant;

/* JADX INFO: loaded from: /tmp/source/classes7.dex */
final class EscherRecordType {
    private int value;
    private static EscherRecordType[] types = new EscherRecordType[0];
    public static final EscherRecordType UNKNOWN = new EscherRecordType(0);
    public static final EscherRecordType DGG_CONTAINER = new EscherRecordType(ProtocolConstant.Set.HOST_SET_COMMANDS);
    public static final EscherRecordType BSTORE_CONTAINER = new EscherRecordType(ProtocolConstant.Set.SET_PROTOCOL_ACTIVATED);
    public static final EscherRecordType DG_CONTAINER = new EscherRecordType(ProtocolConstant.Set.SET_WHERE_AM_I);
    public static final EscherRecordType SPGR_CONTAINER = new EscherRecordType(ProtocolConstant.Set.SET_KEY_CONFIGURATION);
    public static final EscherRecordType SP_CONTAINER = new EscherRecordType(ProtocolConstant.Set.SET_EXTRA_FEATURE_STATUS);
    public static final EscherRecordType DGG = new EscherRecordType(61446);
    public static final EscherRecordType BSE = new EscherRecordType(ProtocolConstant.Set.SET_EQ_STATUS);
    public static final EscherRecordType DG = new EscherRecordType(ProtocolConstant.Set.SET_HIGH_VOLUME_GAIN_LEVEL);
    public static final EscherRecordType SPGR = new EscherRecordType(61449);
    public static final EscherRecordType SP = new EscherRecordType(ProtocolConstant.Set.SET_UTC_TIME);
    public static final EscherRecordType OPT = new EscherRecordType(ProtocolConstant.Set.SET_AUTO_POWER_OFF_TIME);
    public static final EscherRecordType CLIENT_ANCHOR = new EscherRecordType(ProtocolConstant.Set.SET_EQ_MODE);
    public static final EscherRecordType CLIENT_DATA = new EscherRecordType(ProtocolConstant.Set.SET_PERSONALIZED);
    public static final EscherRecordType CLIENT_TEXT_BOX = new EscherRecordType(ProtocolConstant.Set.SET_BOX_LED_COLOR);
    public static final EscherRecordType SPLIT_MENU_COLORS = new EscherRecordType(61726);

    private EscherRecordType(int i) {
        this.value = i;
        EscherRecordType[] escherRecordTypeArr = types;
        EscherRecordType[] escherRecordTypeArr2 = new EscherRecordType[escherRecordTypeArr.length + 1];
        System.arraycopy(escherRecordTypeArr, 0, escherRecordTypeArr2, 0, escherRecordTypeArr.length);
        escherRecordTypeArr2[types.length] = this;
        types = escherRecordTypeArr2;
    }

    public int getValue() {
        return this.value;
    }

    public static EscherRecordType getType(int i) {
        EscherRecordType escherRecordType = UNKNOWN;
        int i2 = 0;
        while (true) {
            EscherRecordType[] escherRecordTypeArr = types;
            if (i2 >= escherRecordTypeArr.length) {
                return escherRecordType;
            }
            EscherRecordType escherRecordType2 = escherRecordTypeArr[i2];
            if (i == escherRecordType2.value) {
                return escherRecordType2;
            }
            i2++;
        }
    }
}
