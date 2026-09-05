package com.nothing.nt_ear_ota.caseble;

import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XCaseBleParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J6\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0011H\u0016J6\u0010\u0012\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/nothing/nt_ear_ota/caseble/XCaseBleParser;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "<init>", "()V", "getReceiveCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "uuid", "", "index", "", "byteArray", "", "getWriterCommand", "taskId", "dataArray", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getOTAWriterResponseCommand", "getOTAReceiveCommand", "nt_ear_ota_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XCaseBleParser implements XByteArrayParser {
    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public String getCommandDescribe(String str) {
        return XByteArrayParser.DefaultImpls.getCommandDescribe(this, str);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public String getOTACommandDescribe(String str) {
        return XByteArrayParser.DefaultImpls.getOTACommandDescribe(this, str);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getReceiveCommand(String uuid, int index, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (byteArray.length == 0) {
            return null;
        }
        return new XCommand("raw", 0, 0, false, 0, 0, 0, (index <= 0 || index >= byteArray.length) ? byteArray : ArraysKt.copyOfRange(byteArray, index, byteArray.length), uuid, null, 638, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        if (taskId == null) {
            taskId = "raw";
        }
        return new XCommand(taskId, 0, dataArray.length, false, 0, 0, 0, dataArray, null, resIds, 378, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getOTAWriterResponseCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        return getWriterCommand(taskId, dataArray, resIds);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getOTAReceiveCommand(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return new XCommand("raw", 0, 0, false, 0, 0, 0, byteArray, null, null, 894, null);
    }
}
