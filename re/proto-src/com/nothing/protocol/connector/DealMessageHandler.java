package com.nothing.protocol.connector;

import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.nothing.protocol.model.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DealMessageHandler.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/protocol/connector/DealMessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "action", "Lkotlin/Function1;", "Lcom/nothing/protocol/model/Message;", "", "<init>", "(Landroid/os/Looper;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DealMessageHandler extends Handler {
    private final Function1<Message, Unit> action;

    public final Function1<Message, Unit> getAction() {
        return this.action;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DealMessageHandler(Looper looper, Function1<? super Message, Unit> action) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 1 && (msg.obj instanceof Message)) {
            Function1<Message, Unit> function1 = this.action;
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.nothing.protocol.model.Message");
            function1.invoke((Message) obj);
        }
    }
}
