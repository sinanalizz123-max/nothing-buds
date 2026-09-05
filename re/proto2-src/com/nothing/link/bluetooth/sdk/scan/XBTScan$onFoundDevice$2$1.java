package com.nothing.link.bluetooth.sdk.scan;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBTScan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XBTScan$onFoundDevice$2$1", f = "XBTScan.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class XBTScan$onFoundDevice$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BluetoothDevice $device;
    final /* synthetic */ BluetoothDevice $it;
    int label;
    final /* synthetic */ XBTScan this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XBTScan$onFoundDevice$2$1(XBTScan xBTScan, BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2, Continuation<? super XBTScan$onFoundDevice$2$1> continuation) {
        super(2, continuation);
        this.this$0 = xBTScan;
        this.$it = bluetoothDevice;
        this.$device = bluetoothDevice2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XBTScan$onFoundDevice$2$1(this.this$0, this.$it, this.$device, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((XBTScan$onFoundDevice$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.checkNotNothingDevice(this.$it) && !this.this$0.checkSameData(this.$it)) {
                Logger logger = Logger.INSTANCE;
                XBTScan xBTScan = this.this$0;
                BluetoothDevice bluetoothDevice = this.$device;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = xBTScan.getScanType() + " scan result device: " + bluetoothDevice;
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
                if (!this.this$0.getFilterAddress().isEmpty() && !this.this$0.getFilterAddress().containsKey(this.$it.getAddress())) {
                    return Unit.INSTANCE;
                }
                this.this$0.filterData(new XBluetoothDevice(this.$device, this.$it.getName(), this.$it.getAddress(), this.$it.getAddress(), null, null, null, null, null, null, null));
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
