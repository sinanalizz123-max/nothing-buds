package com.nothing.link.bluetooth.sdk.connect;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BleException.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/CompleteException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", NotificationCompat.CATEGORY_MESSAGE, "", "(Ljava/lang/String;)V", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CompleteException extends CancellationException {
    /* JADX WARN: Multi-variable type inference failed */
    public CompleteException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CompleteException(String str) {
        super(str);
    }

    public /* synthetic */ CompleteException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
