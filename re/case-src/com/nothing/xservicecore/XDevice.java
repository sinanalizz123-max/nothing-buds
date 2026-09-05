package com.nothing.xservicecore;

import android.bluetooth.BluetoothDevice;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: loaded from: /tmp/source/classes7.dex */
public class XDevice implements Parcelable {
    public static final Parcelable.Creator<XDevice> CREATOR = new Parcelable.Creator<XDevice>() { // from class: com.nothing.xservicecore.XDevice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XDevice createFromParcel(Parcel parcel) {
            return new XDevice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XDevice[] newArray(int i) {
            return new XDevice[i];
        }
    };
    private static final boolean DBG = true;
    private static final String TAG = "XDevice";
    private String address;
    private BluetoothDevice bluetoothDevice;
    private Uri boxImage;
    private Uri boxSmallImage;
    private int caseBattery;
    private boolean caseCharging;
    private String companionApp;
    private Uri globalImage;
    private Uri globalSmallImage;
    private int leftBattery;
    private boolean leftCharging;
    private Uri leftImage;
    private Uri leftSmallImage;
    private String modeId;
    private String name;
    private int rightBattery;
    private boolean rightCharging;
    private Uri rightImage;
    private Uri rightSmallImage;
    private int version;
    private Uri volumePanelImage;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XDevice(String str) {
        this.leftBattery = -1;
        this.rightBattery = -1;
        this.caseBattery = -1;
        this.address = str;
    }

    public String getAddress() {
        Log.d(TAG, "getAddress: mAddress=" + getAddressForLogging());
        return this.address;
    }

    public String getAddressForLogging() {
        return this.address;
    }

    private static void log(String str) {
        Log.d(TAG, str);
    }

    public String getModeId() {
        return this.modeId;
    }

    public String getCompanionApp() {
        return this.companionApp;
    }

    public Uri getLeftImage() {
        return this.leftImage;
    }

    public Uri getRightImage() {
        return this.rightImage;
    }

    public Uri getBoxImage() {
        return this.boxImage;
    }

    public Uri getGlobalImage() {
        return this.globalImage;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setModeId(String str) {
        this.modeId = str;
    }

    public void setCompanionApp(String str) {
        this.companionApp = str;
    }

    public void setLeftImage(Uri uri) {
        this.leftImage = uri;
    }

    public void setRightImage(Uri uri) {
        this.rightImage = uri;
    }

    public void setBoxImage(Uri uri) {
        this.boxImage = uri;
    }

    public void setGlobalImage(Uri uri) {
        this.globalImage = uri;
    }

    public String getName() {
        return this.name;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
    }

    public Uri getLeftSmallImage() {
        return this.leftSmallImage;
    }

    public void setLeftSmallImage(Uri uri) {
        this.leftSmallImage = uri;
    }

    public Uri getRightSmallImage() {
        return this.rightSmallImage;
    }

    public void setRightSmallImage(Uri uri) {
        this.rightSmallImage = uri;
    }

    public Uri getBoxSmallImage() {
        return this.boxSmallImage;
    }

    public void setBoxSmallImage(Uri uri) {
        this.boxSmallImage = uri;
    }

    public Uri getGlobalSmallImage() {
        return this.globalSmallImage;
    }

    public void setGlobalSmallImage(Uri uri) {
        this.globalSmallImage = uri;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setVolumePanelImage(Uri uri) {
        this.volumePanelImage = uri;
    }

    public Uri getVolumePanelImage() {
        return this.volumePanelImage;
    }

    public void setLeftBattery(int i) {
        this.leftBattery = i;
    }

    public void setRightBattery(int i) {
        this.rightBattery = i;
    }

    public void setCaseBattery(int i) {
        this.caseBattery = i;
    }

    public int getLeftBattery() {
        return this.leftBattery;
    }

    public int getRightBattery() {
        return this.rightBattery;
    }

    public int getCaseBattery() {
        return this.caseBattery;
    }

    public void setLeftCharging(boolean z) {
        this.leftCharging = z;
    }

    public void setCaseCharging(boolean z) {
        this.caseCharging = z;
    }

    public void setRightCharging(boolean z) {
        this.rightCharging = z;
    }

    public boolean isCaseCharging() {
        return this.caseCharging;
    }

    public boolean isLeftCharging() {
        return this.leftCharging;
    }

    public boolean isRightCharging() {
        return this.rightCharging;
    }

    public String toString() {
        return "XDevice{address='" + this.address + "', name='" + this.name + "', modeId='" + this.modeId + "', companionApp='" + this.companionApp + "', leftImage=" + this.leftImage + ", rightImage=" + this.rightImage + ", boxImage=" + this.boxImage + ", globalImage=" + this.globalImage + ", leftSmallImage=" + this.leftSmallImage + ", rightSmallImage=" + this.rightSmallImage + ", boxSmallImage=" + this.boxSmallImage + ", globalSmallImage=" + this.globalSmallImage + ", volumePanelImage=" + this.volumePanelImage + ", version=" + this.version + ", leftBattery=" + this.leftBattery + ", rightBattery=" + this.rightBattery + ", caseBattery=" + this.caseBattery + ", caseCharging=" + this.caseCharging + ", leftCharging=" + this.leftCharging + ", rightCharging=" + this.rightCharging + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.address);
        parcel.writeString(this.companionApp);
        parcel.writeString(this.modeId);
        parcel.writeParcelable(this.leftImage, i);
        parcel.writeParcelable(this.rightImage, i);
        parcel.writeParcelable(this.boxImage, i);
        parcel.writeParcelable(this.globalImage, i);
        parcel.writeParcelable(this.bluetoothDevice, i);
        parcel.writeParcelable(this.leftSmallImage, i);
        parcel.writeParcelable(this.rightSmallImage, i);
        parcel.writeParcelable(this.boxSmallImage, i);
        parcel.writeParcelable(this.globalSmallImage, i);
        parcel.writeInt(this.version);
        parcel.writeParcelable(this.volumePanelImage, i);
        parcel.writeInt(this.leftBattery);
        parcel.writeInt(this.rightBattery);
        parcel.writeInt(this.caseBattery);
        parcel.writeByte(this.leftCharging ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.rightCharging ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.caseCharging ? (byte) 1 : (byte) 0);
    }

    public void readFromParcel(Parcel parcel) {
        this.name = parcel.readString();
        this.address = parcel.readString();
        this.companionApp = parcel.readString();
        this.modeId = parcel.readString();
        this.leftImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.rightImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.boxImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.globalImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.bluetoothDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.leftSmallImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.rightSmallImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.boxSmallImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.globalSmallImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.version = parcel.readInt();
        this.volumePanelImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.leftBattery = parcel.readInt();
        this.rightBattery = parcel.readInt();
        this.caseBattery = parcel.readInt();
        this.leftCharging = parcel.readByte() != 0;
        this.rightCharging = parcel.readByte() != 0;
        this.caseCharging = parcel.readByte() != 0;
    }

    protected XDevice(Parcel parcel) {
        this.leftBattery = -1;
        this.rightBattery = -1;
        this.caseBattery = -1;
        this.name = parcel.readString();
        this.address = parcel.readString();
        this.companionApp = parcel.readString();
        this.modeId = parcel.readString();
        this.leftImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.rightImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.boxImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.globalImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.bluetoothDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.leftSmallImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.rightSmallImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.boxSmallImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.globalSmallImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.version = parcel.readInt();
        this.volumePanelImage = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.leftBattery = parcel.readInt();
        this.rightBattery = parcel.readInt();
        this.caseBattery = parcel.readInt();
        this.leftCharging = parcel.readByte() != 0;
        this.rightCharging = parcel.readByte() != 0;
        this.caseCharging = parcel.readByte() != 0;
    }
}
