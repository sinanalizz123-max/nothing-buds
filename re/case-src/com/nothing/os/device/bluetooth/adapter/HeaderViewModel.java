package com.nothing.os.device.bluetooth.adapter;

import android.app.Application;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import com.nothing.base.settings.battery.BatteryUtil;
import com.nothing.base.util.AppGlobals;
import com.nothing.settings.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeaderViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 n2\u00020\u0001:\u0001nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010f\u001a\u00020\u0003H\u0016J\u0015\u0010g\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0002\u0010dJ\u0015\u0010j\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0002\u0010dJ\u000e\u0010k\u001a\u00020h2\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020hR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000bR \u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\u000bR \u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR \u0010-\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR \u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR \u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR \u00106\u001a\b\u0012\u0004\u0012\u00020*0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR \u00109\u001a\b\u0012\u0004\u0012\u00020*0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u000bR \u0010<\u001a\b\u0012\u0004\u0012\u00020*0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR \u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000bR \u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR \u0010E\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\t\"\u0004\bG\u0010\u000bR \u0010H\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\t\"\u0004\bJ\u0010\u000bR\u001a\u0010K\u001a\u00020LX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020LX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PR\u001a\u0010T\u001a\u00020LX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010N\"\u0004\bV\u0010PR \u0010W\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\t\"\u0004\bY\u0010\u000bR \u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\t\"\u0004\b\\\u0010\u000bR \u0010]\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\t\"\u0004\b_\u0010\u000bR\u001e\u0010`\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010e\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d\u00a8\u0006o"}, d2 = {"Lcom/nothing/os/device/bluetooth/adapter/HeaderViewModel;", "Lcom/nothing/os/device/bluetooth/adapter/NormalItemViewModel;", "order", "", "<init>", "(I)V", "leftImage", "Landroidx/databinding/ObservableField;", "getLeftImage", "()Landroidx/databinding/ObservableField;", "setLeftImage", "(Landroidx/databinding/ObservableField;)V", "rightImage", "getRightImage", "setRightImage", "caseImage", "getCaseImage", "setCaseImage", "caseUri", "Landroid/net/Uri;", "getCaseUri", "setCaseUri", "leftImageUri", "getLeftImageUri", "setLeftImageUri", "rightImageUri", "getRightImageUri", "setRightImageUri", "leftVisible", "", "getLeftVisible", "setLeftVisible", "rightVisible", "getRightVisible", "setRightVisible", "caseVisible", "getCaseVisible", "setCaseVisible", "caseTextVisible", "getCaseTextVisible", "setCaseTextVisible", "caseText", "", "getCaseText", "setCaseText", "leftBatteryVisible", "getLeftBatteryVisible", "setLeftBatteryVisible", "rightBatteryVisible", "getRightBatteryVisible", "setRightBatteryVisible", "caseBatteryVisible", "getCaseBatteryVisible", "setCaseBatteryVisible", "caseBattery", "getCaseBattery", "setCaseBattery", "leftBattery", "getLeftBattery", "setLeftBattery", "rightBattery", "getRightBattery", "setRightBattery", "connectEnable", "getConnectEnable", "setConnectEnable", "disConnectEnable", "getDisConnectEnable", "setDisConnectEnable", "connectVisible", "getConnectVisible", "setConnectVisible", "disConnectVisible", "getDisConnectVisible", "setDisConnectVisible", "leftLevel", "Landroidx/databinding/ObservableInt;", "getLeftLevel", "()Landroidx/databinding/ObservableInt;", "setLeftLevel", "(Landroidx/databinding/ObservableInt;)V", "rightLevel", "getRightLevel", "setRightLevel", "caseLevel", "getCaseLevel", "setCaseLevel", "caseCharging", "getCaseCharging", "setCaseCharging", "leftCharging", "getLeftCharging", "setLeftCharging", "rightCharging", "getRightCharging", "setRightCharging", "defaultConnectedStatus", "getDefaultConnectedStatus", "()Ljava/lang/Boolean;", "setDefaultConnectedStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemViewType", "updateDefaultConnectStatus", "", "connected", "updateConnectStatus", "updateButtonEnable", "enable", "setConnect", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeaderViewModel extends NormalItemViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ObservableField<String> caseBattery;
    private ObservableField<Boolean> caseBatteryVisible;
    private ObservableField<Boolean> caseCharging;
    private ObservableField<Integer> caseImage;
    private ObservableInt caseLevel;
    private ObservableField<String> caseText;
    private ObservableField<Boolean> caseTextVisible;
    private ObservableField<Uri> caseUri;
    private ObservableField<Boolean> caseVisible;
    private ObservableField<Boolean> connectEnable;
    private ObservableField<Boolean> connectVisible;
    private Boolean defaultConnectedStatus;
    private ObservableField<Boolean> disConnectEnable;
    private ObservableField<Boolean> disConnectVisible;
    private ObservableField<String> leftBattery;
    private ObservableField<Boolean> leftBatteryVisible;
    private ObservableField<Boolean> leftCharging;
    private ObservableField<Integer> leftImage;
    private ObservableField<Uri> leftImageUri;
    private ObservableInt leftLevel;
    private ObservableField<Boolean> leftVisible;
    private ObservableField<String> rightBattery;
    private ObservableField<Boolean> rightBatteryVisible;
    private ObservableField<Boolean> rightCharging;
    private ObservableField<Integer> rightImage;
    private ObservableField<Uri> rightImageUri;
    private ObservableInt rightLevel;
    private ObservableField<Boolean> rightVisible;

    @BindingAdapter({"showBatteryLevel", "showBatteryLowLevel", "showBatteryCharging"})
    @JvmStatic
    public static final void showBattery(ImageView imageView, int i, int i2, boolean z) {
        INSTANCE.showBattery(imageView, i, i2, z);
    }

    public HeaderViewModel(int i) {
        super(i);
        this.leftImage = new ObservableField<>();
        this.rightImage = new ObservableField<>();
        this.caseImage = new ObservableField<>();
        this.caseUri = new ObservableField<>();
        this.leftImageUri = new ObservableField<>();
        this.rightImageUri = new ObservableField<>();
        this.leftVisible = new ObservableField<>(false);
        this.rightVisible = new ObservableField<>(false);
        this.caseVisible = new ObservableField<>(false);
        this.caseTextVisible = new ObservableField<>(false);
        Application application = AppGlobals.INSTANCE.get();
        this.caseText = new ObservableField<>(application != null ? application.getString(R.string.bluetooth_middle_name) : null);
        this.leftBatteryVisible = new ObservableField<>(false);
        this.rightBatteryVisible = new ObservableField<>(false);
        this.caseBatteryVisible = new ObservableField<>(false);
        this.caseBattery = new ObservableField<>();
        this.leftBattery = new ObservableField<>();
        this.rightBattery = new ObservableField<>();
        this.connectEnable = new ObservableField<>(true);
        this.disConnectEnable = new ObservableField<>(true);
        this.connectVisible = new ObservableField<>(true);
        this.disConnectVisible = new ObservableField<>(false);
        this.leftLevel = new ObservableInt();
        this.rightLevel = new ObservableInt();
        this.caseLevel = new ObservableInt();
        this.caseCharging = new ObservableField<>(false);
        this.leftCharging = new ObservableField<>(false);
        this.rightCharging = new ObservableField<>(false);
        this.defaultConnectedStatus = false;
    }

    public final ObservableField<Integer> getLeftImage() {
        return this.leftImage;
    }

    public final void setLeftImage(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.leftImage = observableField;
    }

    public final ObservableField<Integer> getRightImage() {
        return this.rightImage;
    }

    public final void setRightImage(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.rightImage = observableField;
    }

    public final ObservableField<Integer> getCaseImage() {
        return this.caseImage;
    }

    public final void setCaseImage(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseImage = observableField;
    }

    public final ObservableField<Uri> getCaseUri() {
        return this.caseUri;
    }

    public final void setCaseUri(ObservableField<Uri> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseUri = observableField;
    }

    public final ObservableField<Uri> getLeftImageUri() {
        return this.leftImageUri;
    }

    public final void setLeftImageUri(ObservableField<Uri> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.leftImageUri = observableField;
    }

    public final ObservableField<Uri> getRightImageUri() {
        return this.rightImageUri;
    }

    public final void setRightImageUri(ObservableField<Uri> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.rightImageUri = observableField;
    }

    public final ObservableField<Boolean> getLeftVisible() {
        return this.leftVisible;
    }

    public final void setLeftVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.leftVisible = observableField;
    }

    public final ObservableField<Boolean> getRightVisible() {
        return this.rightVisible;
    }

    public final void setRightVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.rightVisible = observableField;
    }

    public final ObservableField<Boolean> getCaseVisible() {
        return this.caseVisible;
    }

    public final void setCaseVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseVisible = observableField;
    }

    public final ObservableField<Boolean> getCaseTextVisible() {
        return this.caseTextVisible;
    }

    public final void setCaseTextVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseTextVisible = observableField;
    }

    public final ObservableField<String> getCaseText() {
        return this.caseText;
    }

    public final void setCaseText(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseText = observableField;
    }

    public final ObservableField<Boolean> getLeftBatteryVisible() {
        return this.leftBatteryVisible;
    }

    public final void setLeftBatteryVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.leftBatteryVisible = observableField;
    }

    public final ObservableField<Boolean> getRightBatteryVisible() {
        return this.rightBatteryVisible;
    }

    public final void setRightBatteryVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.rightBatteryVisible = observableField;
    }

    public final ObservableField<Boolean> getCaseBatteryVisible() {
        return this.caseBatteryVisible;
    }

    public final void setCaseBatteryVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseBatteryVisible = observableField;
    }

    public final ObservableField<String> getCaseBattery() {
        return this.caseBattery;
    }

    public final void setCaseBattery(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseBattery = observableField;
    }

    public final ObservableField<String> getLeftBattery() {
        return this.leftBattery;
    }

    public final void setLeftBattery(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.leftBattery = observableField;
    }

    public final ObservableField<String> getRightBattery() {
        return this.rightBattery;
    }

    public final void setRightBattery(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.rightBattery = observableField;
    }

    public final ObservableField<Boolean> getConnectEnable() {
        return this.connectEnable;
    }

    public final void setConnectEnable(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.connectEnable = observableField;
    }

    public final ObservableField<Boolean> getDisConnectEnable() {
        return this.disConnectEnable;
    }

    public final void setDisConnectEnable(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.disConnectEnable = observableField;
    }

    public final ObservableField<Boolean> getConnectVisible() {
        return this.connectVisible;
    }

    public final void setConnectVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.connectVisible = observableField;
    }

    public final ObservableField<Boolean> getDisConnectVisible() {
        return this.disConnectVisible;
    }

    public final void setDisConnectVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.disConnectVisible = observableField;
    }

    public final ObservableInt getLeftLevel() {
        return this.leftLevel;
    }

    public final void setLeftLevel(ObservableInt observableInt) {
        Intrinsics.checkNotNullParameter(observableInt, "<set-?>");
        this.leftLevel = observableInt;
    }

    public final ObservableInt getRightLevel() {
        return this.rightLevel;
    }

    public final void setRightLevel(ObservableInt observableInt) {
        Intrinsics.checkNotNullParameter(observableInt, "<set-?>");
        this.rightLevel = observableInt;
    }

    public final ObservableInt getCaseLevel() {
        return this.caseLevel;
    }

    public final void setCaseLevel(ObservableInt observableInt) {
        Intrinsics.checkNotNullParameter(observableInt, "<set-?>");
        this.caseLevel = observableInt;
    }

    public final ObservableField<Boolean> getCaseCharging() {
        return this.caseCharging;
    }

    public final void setCaseCharging(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseCharging = observableField;
    }

    public final ObservableField<Boolean> getLeftCharging() {
        return this.leftCharging;
    }

    public final void setLeftCharging(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.leftCharging = observableField;
    }

    public final ObservableField<Boolean> getRightCharging() {
        return this.rightCharging;
    }

    public final void setRightCharging(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.rightCharging = observableField;
    }

    public final Boolean getDefaultConnectedStatus() {
        return this.defaultConnectedStatus;
    }

    public final void setDefaultConnectedStatus(Boolean bool) {
        this.defaultConnectedStatus = bool;
    }

    @Override // com.nothing.os.device.bluetooth.adapter.NormalItemViewModel, com.nothing.base.adapter.CommonBindingMoreType
    public int getItemViewType() {
        return com.nothing.ear.R.layout.os_advanced_bt_entity_header;
    }

    public final void updateDefaultConnectStatus(Boolean connected) {
        this.defaultConnectedStatus = connected;
    }

    public final void updateConnectStatus(Boolean connected) {
        this.disConnectVisible.set(connected);
        this.connectVisible.set(Boolean.valueOf(Intrinsics.areEqual((Object) connected, (Object) false)));
        this.connectEnable.set(true);
        this.disConnectEnable.set(true);
    }

    public final void updateButtonEnable(boolean enable) {
        this.connectEnable.set(Boolean.valueOf(enable));
        this.disConnectEnable.set(Boolean.valueOf(enable));
    }

    public final void setConnect() {
        if (Intrinsics.areEqual((Object) this.connectVisible.get(), (Object) true)) {
            this.disConnectVisible.set(true);
            this.connectVisible.set(false);
            this.connectEnable.set(true);
            this.disConnectEnable.set(false);
            return;
        }
        this.disConnectVisible.set(false);
        this.connectVisible.set(true);
        this.connectEnable.set(false);
        this.disConnectEnable.set(true);
    }

    /* JADX INFO: compiled from: HeaderViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/nothing/os/device/bluetooth/adapter/HeaderViewModel$Companion;", "", "<init>", "()V", "showBattery", "", "view", "Landroid/widget/ImageView;", "level", "", "lowLevel", "charging", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @BindingAdapter({"showBatteryLevel", "showBatteryLowLevel", "showBatteryCharging"})
        @JvmStatic
        public final void showBattery(ImageView view, int level, int lowLevel, boolean charging) {
            Intrinsics.checkNotNullParameter(view, "view");
            BatteryUtil.INSTANCE.showBatteryIcon(view, level, lowLevel, charging);
        }
    }
}
