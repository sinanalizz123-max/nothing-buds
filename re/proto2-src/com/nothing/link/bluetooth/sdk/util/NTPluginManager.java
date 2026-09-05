package com.nothing.link.bluetooth.sdk.util;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NTPluginManager.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/util/NTPluginManager;", "", "()V", "pluginListener", "Ljava/util/ArrayList;", "Lcom/nothing/link/bluetooth/sdk/util/NTPluginCallHandler;", "Lkotlin/collections/ArrayList;", "addHandler", "", "handler", "getPluginHandlers", "onCallHandler", "method", "", "arguments", "Landroid/os/Bundle;", "removeHandler", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NTPluginManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<NTPluginManager> singleInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<NTPluginManager>() { // from class: com.nothing.link.bluetooth.sdk.util.NTPluginManager$Companion$singleInstance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NTPluginManager invoke() {
            return new NTPluginManager();
        }
    });
    private final ArrayList<NTPluginCallHandler> pluginListener = new ArrayList<>();

    /* JADX INFO: compiled from: NTPluginManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/util/NTPluginManager$Companion;", "", "()V", "singleInstance", "Lcom/nothing/link/bluetooth/sdk/util/NTPluginManager;", "getSingleInstance", "()Lcom/nothing/link/bluetooth/sdk/util/NTPluginManager;", "singleInstance$delegate", "Lkotlin/Lazy;", "get", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final NTPluginManager getSingleInstance() {
            return (NTPluginManager) NTPluginManager.singleInstance$delegate.getValue();
        }

        public final NTPluginManager get() {
            return getSingleInstance();
        }
    }

    public final void addHandler(NTPluginCallHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.pluginListener.contains(handler)) {
            return;
        }
        this.pluginListener.add(handler);
    }

    public final void removeHandler(NTPluginCallHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.pluginListener.remove(handler);
    }

    public final void onCallHandler(String method, Bundle arguments) {
        Intrinsics.checkNotNullParameter(method, "method");
        Iterator<T> it = this.pluginListener.iterator();
        while (it.hasNext()) {
            ((NTPluginCallHandler) it.next()).onMethodCall(method, arguments);
        }
    }

    public final ArrayList<NTPluginCallHandler> getPluginHandlers() {
        return this.pluginListener;
    }
}
