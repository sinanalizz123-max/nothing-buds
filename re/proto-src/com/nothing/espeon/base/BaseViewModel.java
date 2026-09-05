package com.nothing.espeon.base;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import com.nothing.database.util.SpUtils;
import com.nothing.espeon.core.protocol.EspeonSppProtocol;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\tJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u001a\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/nothing/espeon/base/BaseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "address", "", "application", "Landroid/app/Application;", "<init>", "(Ljava/lang/String;Landroid/app/Application;)V", "(Landroid/app/Application;)V", "protocol", "Lcom/nothing/espeon/core/protocol/EspeonSppProtocol;", "getProtocol", "()Lcom/nothing/espeon/core/protocol/EspeonSppProtocol;", "setProtocol", "(Lcom/nothing/espeon/core/protocol/EspeonSppProtocol;)V", "mAddress", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "register", "", "extras", "Landroid/os/Bundle;", "onCleared", "onConnected", "onDisconnected", "onError", "code", "", "message", "onUpdate", "cmdType", "data", "Lcom/nothing/protocol/model/Message;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseViewModel extends AndroidViewModel implements TWSDevice.Callback {
    private String mAddress;
    private EspeonSppProtocol protocol;

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(int code, String message) {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public /* synthetic */ BaseViewModel(String str, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, application);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void getBesVersionSuccess() {
        TWSDevice.Callback.DefaultImpls.getBesVersionSuccess(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public boolean isIOThread() {
        return TWSDevice.Callback.DefaultImpls.isIOThread(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnected(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnecting(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnecting(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onDisconnected(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice, int i, String str) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i, str);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int i, Message message, TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onUpdate(this, i, message, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void openBluetooth(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.openBluetooth(this, tWSDevice);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewModel(String str, Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        EspeonSppProtocol espeonSppProtocol = new EspeonSppProtocol(str);
        this.protocol = espeonSppProtocol;
        this.mAddress = "";
        TWSDevice tWSDevice = espeonSppProtocol.getTWSDevice();
        if (tWSDevice != null) {
            tWSDevice.register(this);
        }
    }

    public final EspeonSppProtocol getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(EspeonSppProtocol espeonSppProtocol) {
        Intrinsics.checkNotNullParameter(espeonSppProtocol, "<set-?>");
        this.protocol = espeonSppProtocol;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseViewModel(Application application) {
        this(null, application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final String getMAddress() {
        return this.mAddress;
    }

    public final void setMAddress(String str) {
        this.mAddress = str;
    }

    public void register(Bundle extras) {
        TWSDevice tWSDevice = this.protocol.getTWSDevice();
        if (tWSDevice != null) {
            tWSDevice.unregister(this);
        }
        String string = extras != null ? extras.getString("device_address") : null;
        String str = string;
        if (str == null || str.length() == 0) {
            string = SpUtils.INSTANCE.getSelectDeviceMac();
        }
        this.mAddress = string;
        EspeonSppProtocol espeonSppProtocol = new EspeonSppProtocol(string);
        this.protocol = espeonSppProtocol;
        TWSDevice tWSDevice2 = espeonSppProtocol.getTWSDevice();
        if (tWSDevice2 != null) {
            tWSDevice2.register(this);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        TWSDevice tWSDevice;
        super.onCleared();
        String selectDeviceMac = SpUtils.INSTANCE.getSelectDeviceMac();
        if (selectDeviceMac == null || selectDeviceMac.length() == 0 || (tWSDevice = this.protocol.getTWSDevice()) == null) {
            return;
        }
        tWSDevice.unregister(this);
    }
}
