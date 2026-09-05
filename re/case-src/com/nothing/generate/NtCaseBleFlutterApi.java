package com.nothing.generate;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NtCaseBlePigeon.g.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0010\u0012\u0004\u0012\u00020\t0\u000fJ:\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0010\u0012\u0004\u0012\u00020\t0\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/generate/NtCaseBleFlutterApi;", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "messageChannelSuffix", "", "<init>", "(Lio/flutter/plugin/common/BinaryMessenger;Ljava/lang/String;)V", "onCaseBleDataReceived", "", "realMacArg", "dataArg", "", "", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "onCaseBleConnectionStateChanged", "stateArg", "Lcom/nothing/generate/NtCaseBleConnectionState;", "caseMacArg", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NtCaseBleFlutterApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<NtCaseBlePigeonPigeonCodec> codec$delegate = LazyKt.lazy(new Function0() { // from class: com.nothing.generate.NtCaseBleFlutterApi$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NtCaseBleFlutterApi.codec_delegate$lambda$2();
        }
    });
    private final BinaryMessenger binaryMessenger;
    private final String messageChannelSuffix;

    /* JADX INFO: compiled from: NtCaseBlePigeon.g.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/nothing/generate/NtCaseBleFlutterApi$Companion;", "", "<init>", "()V", "codec", "Lio/flutter/plugin/common/MessageCodec;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lkotlin/Lazy;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) NtCaseBleFlutterApi.codec$delegate.getValue();
        }
    }

    public NtCaseBleFlutterApi(BinaryMessenger binaryMessenger, String messageChannelSuffix) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        Intrinsics.checkNotNullParameter(messageChannelSuffix, "messageChannelSuffix");
        this.binaryMessenger = binaryMessenger;
        this.messageChannelSuffix = messageChannelSuffix;
    }

    public /* synthetic */ NtCaseBleFlutterApi(BinaryMessenger binaryMessenger, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(binaryMessenger, (i & 2) != 0 ? "" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NtCaseBlePigeonPigeonCodec codec_delegate$lambda$2() {
        return new NtCaseBlePigeonPigeonCodec();
    }

    public final void onCaseBleDataReceived(String realMacArg, List<Long> dataArg, final Function1<? super Result<Unit>, Unit> callback) {
        String str;
        Intrinsics.checkNotNullParameter(realMacArg, "realMacArg");
        Intrinsics.checkNotNullParameter(dataArg, "dataArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.messageChannelSuffix.length() > 0) {
            str = "." + this.messageChannelSuffix;
        } else {
            str = "";
        }
        final String str2 = "dev.flutter.pigeon.nt_ear.NtCaseBleFlutterApi.onCaseBleDataReceived" + str;
        new BasicMessageChannel(this.binaryMessenger, str2, INSTANCE.getCodec()).send(CollectionsKt.listOf(realMacArg, dataArg), new BasicMessageChannel.Reply() { // from class: com.nothing.generate.NtCaseBleFlutterApi$$ExternalSyntheticLambda0
            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                NtCaseBleFlutterApi.onCaseBleDataReceived$lambda$0(callback, str2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCaseBleDataReceived$lambda$0(Function1 function1, String str, Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() > 1) {
                Result.Companion companion = Result.INSTANCE;
                Object obj2 = list.get(0);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = list.get(1);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new NtCaseBleFlutterError((String) obj2, (String) obj3, (String) list.get(2))))));
                return;
            }
            Result.Companion companion2 = Result.INSTANCE;
            function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
            return;
        }
        Result.Companion companion3 = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(NtCaseBlePigeonPigeonUtils.INSTANCE.createConnectionError(str)))));
    }

    public final void onCaseBleConnectionStateChanged(String realMacArg, NtCaseBleConnectionState stateArg, String caseMacArg, final Function1<? super Result<Unit>, Unit> callback) {
        String str;
        Intrinsics.checkNotNullParameter(realMacArg, "realMacArg");
        Intrinsics.checkNotNullParameter(stateArg, "stateArg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.messageChannelSuffix.length() > 0) {
            str = "." + this.messageChannelSuffix;
        } else {
            str = "";
        }
        final String str2 = "dev.flutter.pigeon.nt_ear.NtCaseBleFlutterApi.onCaseBleConnectionStateChanged" + str;
        new BasicMessageChannel(this.binaryMessenger, str2, INSTANCE.getCodec()).send(CollectionsKt.listOf(realMacArg, stateArg, caseMacArg), new BasicMessageChannel.Reply() { // from class: com.nothing.generate.NtCaseBleFlutterApi$$ExternalSyntheticLambda1
            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                NtCaseBleFlutterApi.onCaseBleConnectionStateChanged$lambda$1(callback, str2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCaseBleConnectionStateChanged$lambda$1(Function1 function1, String str, Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() > 1) {
                Result.Companion companion = Result.INSTANCE;
                Object obj2 = list.get(0);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = list.get(1);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new NtCaseBleFlutterError((String) obj2, (String) obj3, (String) list.get(2))))));
                return;
            }
            Result.Companion companion2 = Result.INSTANCE;
            function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
            return;
        }
        Result.Companion companion3 = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(NtCaseBlePigeonPigeonUtils.INSTANCE.createConnectionError(str)))));
    }
}
