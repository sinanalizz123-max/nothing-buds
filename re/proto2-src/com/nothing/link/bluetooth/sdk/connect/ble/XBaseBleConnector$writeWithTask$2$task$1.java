package com.nothing.link.bluetooth.sdk.connect.ble;

import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.task.XTask;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: XBaseBleConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/nothing/link/bluetooth/sdk/task/XTask;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$writeWithTask$2$task$1", f = "XBaseBleConnector.kt", i = {0}, l = {691}, m = "invokeSuspend", n = {"$this$$receiver"}, s = {"L$0"})
final class XBaseBleConnector$writeWithTask$2$task$1 extends SuspendLambda implements Function2<XTask, Continuation<? super Boolean>, Object> {
    final /* synthetic */ XCommand $command;
    final /* synthetic */ byte[] $dataArray;
    final /* synthetic */ long $operateInterval;
    final /* synthetic */ String $serviceUUID;
    final /* synthetic */ String $writeUUID;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ XBaseBleConnector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XBaseBleConnector$writeWithTask$2$task$1(XBaseBleConnector xBaseBleConnector, XCommand xCommand, String str, String str2, byte[] bArr, long j, Continuation<? super XBaseBleConnector$writeWithTask$2$task$1> continuation) {
        super(2, continuation);
        this.this$0 = xBaseBleConnector;
        this.$command = xCommand;
        this.$serviceUUID = str;
        this.$writeUUID = str2;
        this.$dataArray = bArr;
        this.$operateInterval = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        XBaseBleConnector$writeWithTask$2$task$1 xBaseBleConnector$writeWithTask$2$task$1 = new XBaseBleConnector$writeWithTask$2$task$1(this.this$0, this.$command, this.$serviceUUID, this.$writeUUID, this.$dataArray, this.$operateInterval, continuation);
        xBaseBleConnector$writeWithTask$2$task$1.L$0 = obj;
        return xBaseBleConnector$writeWithTask$2$task$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(XTask xTask, Continuation<? super Boolean> continuation) {
        return ((XBaseBleConnector$writeWithTask$2$task$1) create(xTask, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        XTask xTask;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            XTask xTask2 = (XTask) this.L$0;
            this.L$0 = xTask2;
            this.label = 1;
            Object objWrite = this.this$0.write(this.$command, this.$serviceUUID, this.$writeUUID, this.$dataArray, this.$operateInterval, this);
            if (objWrite == coroutine_suspended) {
                return coroutine_suspended;
            }
            xTask = xTask2;
            obj = objWrite;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            xTask = (XTask) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (zBooleanValue) {
            xTask.setWriting();
        }
        return Boxing.boxBoolean(zBooleanValue);
    }
}
