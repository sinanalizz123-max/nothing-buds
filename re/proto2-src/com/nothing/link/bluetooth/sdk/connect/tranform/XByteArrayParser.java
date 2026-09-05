package com.nothing.link.bluetooth.sdk.connect.tranform;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XByteArrayParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J6\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\t2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000fH&J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH&J6\u0010\u0014\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\t2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000fH&\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "", "getCommandDescribe", "", "command", "getOTACommandDescribe", "getOTAReceiveCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "byteArray", "", "getOTAWriterResponseCommand", "taskId", "dataArray", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getReceiveCommand", "uuid", "index", "", "getWriterCommand", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface XByteArrayParser {
    String getCommandDescribe(String command);

    String getOTACommandDescribe(String command);

    XCommand getOTAReceiveCommand(byte[] byteArray);

    XCommand getOTAWriterResponseCommand(String taskId, byte[] dataArray, ArrayList<String> resIds);

    XCommand getReceiveCommand(String uuid, int index, byte[] byteArray);

    XCommand getWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds);

    /* JADX INFO: compiled from: XByteArrayParser.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getCommandDescribe(XByteArrayParser xByteArrayParser, String command) {
            Intrinsics.checkNotNullParameter(command, "command");
            return "";
        }

        public static String getOTACommandDescribe(XByteArrayParser xByteArrayParser, String command) {
            Intrinsics.checkNotNullParameter(command, "command");
            return "";
        }
    }
}
