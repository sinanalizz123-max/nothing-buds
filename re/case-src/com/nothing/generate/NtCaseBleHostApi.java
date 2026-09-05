package com.nothing.generate;

import com.nothing.earbase.unknown.DeviceEarImage;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NtCaseBlePigeon.g.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014JD\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0004\u0012\u00020\u00030\tH&J*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0004\u0012\u00020\u00030\tH&J8\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0004\u0012\u00020\u00030\tH&J*\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n\u0012\u0004\u0012\u00020\u00030\tH&J,\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n\u0012\u0004\u0012\u00020\u00030\tH&J,\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n\u0012\u0004\u0012\u00020\u00030\tH&\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/generate/NtCaseBleHostApi;", "", "connect", "", "realMac", "", "uuids", "", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", DeviceEarImage.DISCONNECT_EAR_IMAGE, "sendData", "data", "", "", "connectionState", "Lcom/nothing/generate/NtCaseBleConnectionState;", "gattIdentifier", "linkedCaseMac", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface NtCaseBleHostApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void connect(String realMac, Map<String, String> uuids, Function1<? super Result<Unit>, Unit> callback);

    void connectionState(String realMac, Function1<? super Result<? extends NtCaseBleConnectionState>, Unit> callback);

    void disconnect(String realMac, Function1<? super Result<Unit>, Unit> callback);

    void gattIdentifier(String realMac, Function1<? super Result<String>, Unit> callback);

    void linkedCaseMac(String realMac, Function1<? super Result<String>, Unit> callback);

    void sendData(String realMac, List<Long> data, Function1<? super Result<Unit>, Unit> callback);

    /* JADX INFO: compiled from: NtCaseBlePigeon.g.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007R#\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/generate/NtCaseBleHostApi$Companion;", "", "<init>", "()V", "codec", "Lio/flutter/plugin/common/MessageCodec;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lkotlin/Lazy;", "setUp", "", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "api", "Lcom/nothing/generate/NtCaseBleHostApi;", "messageChannelSuffix", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: codec$delegate, reason: from kotlin metadata */
        private static final Lazy<NtCaseBlePigeonPigeonCodec> codec = LazyKt.lazy(new Function0() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NtCaseBleHostApi.Companion.codec_delegate$lambda$0();
            }
        });

        public final void setUp(BinaryMessenger binaryMessenger, NtCaseBleHostApi ntCaseBleHostApi) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, ntCaseBleHostApi, null, 4, null);
        }

        private Companion() {
        }

        public final MessageCodec<Object> getCodec() {
            return codec.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final NtCaseBlePigeonPigeonCodec codec_delegate$lambda$0() {
            return new NtCaseBlePigeonPigeonCodec();
        }

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, NtCaseBleHostApi ntCaseBleHostApi, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = "";
            }
            companion.setUp(binaryMessenger, ntCaseBleHostApi, str);
        }

        public final void setUp(BinaryMessenger binaryMessenger, final NtCaseBleHostApi api, String messageChannelSuffix) {
            Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
            Intrinsics.checkNotNullParameter(messageChannelSuffix, "messageChannelSuffix");
            String str = messageChannelSuffix.length() > 0 ? "." + messageChannelSuffix : "";
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.nt_ear.NtCaseBleHostApi.connect" + str, getCodec());
            if (api != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda10
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        NtCaseBleHostApi.Companion.setUp$lambda$3$lambda$2(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.nt_ear.NtCaseBleHostApi.disconnect" + str, getCodec());
            if (api != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda11
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        NtCaseBleHostApi.Companion.setUp$lambda$6$lambda$5(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.nt_ear.NtCaseBleHostApi.sendData" + str, getCodec());
            if (api != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda12
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        NtCaseBleHostApi.Companion.setUp$lambda$9$lambda$8(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.nt_ear.NtCaseBleHostApi.connectionState" + str, getCodec());
            if (api != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        NtCaseBleHostApi.Companion.setUp$lambda$12$lambda$11(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.nt_ear.NtCaseBleHostApi.gattIdentifier" + str, getCodec());
            if (api != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda2
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        NtCaseBleHostApi.Companion.setUp$lambda$15$lambda$14(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.nt_ear.NtCaseBleHostApi.linkedCaseMac" + str, getCodec());
            if (api != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda3
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        NtCaseBleHostApi.Companion.setUp$lambda$18$lambda$17(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$3$lambda$2(NtCaseBleHostApi ntCaseBleHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ntCaseBleHostApi.connect((String) obj2, (Map) list.get(1), new Function1() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return NtCaseBleHostApi.Companion.setUp$lambda$3$lambda$2$lambda$1(reply, (Result) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setUp$lambda$3$lambda$2$lambda$1(BasicMessageChannel.Reply reply, Result result) {
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
            if (thM6350exceptionOrNullimpl != null) {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapError(thM6350exceptionOrNullimpl));
            } else {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$6$lambda$5(NtCaseBleHostApi ntCaseBleHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ntCaseBleHostApi.disconnect((String) obj2, new Function1() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return NtCaseBleHostApi.Companion.setUp$lambda$6$lambda$5$lambda$4(reply, (Result) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setUp$lambda$6$lambda$5$lambda$4(BasicMessageChannel.Reply reply, Result result) {
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
            if (thM6350exceptionOrNullimpl != null) {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapError(thM6350exceptionOrNullimpl));
            } else {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$9$lambda$8(NtCaseBleHostApi ntCaseBleHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Long>");
            ntCaseBleHostApi.sendData((String) obj2, (List) obj3, new Function1() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return NtCaseBleHostApi.Companion.setUp$lambda$9$lambda$8$lambda$7(reply, (Result) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setUp$lambda$9$lambda$8$lambda$7(BasicMessageChannel.Reply reply, Result result) {
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
            if (thM6350exceptionOrNullimpl != null) {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapError(thM6350exceptionOrNullimpl));
            } else {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$12$lambda$11(NtCaseBleHostApi ntCaseBleHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ntCaseBleHostApi.connectionState((String) obj2, new Function1() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return NtCaseBleHostApi.Companion.setUp$lambda$12$lambda$11$lambda$10(reply, (Result) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setUp$lambda$12$lambda$11$lambda$10(BasicMessageChannel.Reply reply, Result result) {
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
            if (thM6350exceptionOrNullimpl != null) {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapError(thM6350exceptionOrNullimpl));
            } else {
                Object value = result.getValue();
                if (Result.m6353isFailureimpl(value)) {
                    value = null;
                }
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapResult((NtCaseBleConnectionState) value));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$15$lambda$14(NtCaseBleHostApi ntCaseBleHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ntCaseBleHostApi.gattIdentifier((String) obj2, new Function1() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return NtCaseBleHostApi.Companion.setUp$lambda$15$lambda$14$lambda$13(reply, (Result) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setUp$lambda$15$lambda$14$lambda$13(BasicMessageChannel.Reply reply, Result result) {
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
            if (thM6350exceptionOrNullimpl != null) {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapError(thM6350exceptionOrNullimpl));
            } else {
                Object value = result.getValue();
                if (Result.m6353isFailureimpl(value)) {
                    value = null;
                }
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapResult((String) value));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$18$lambda$17(NtCaseBleHostApi ntCaseBleHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            Intrinsics.checkNotNullParameter(reply, "reply");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ntCaseBleHostApi.linkedCaseMac((String) obj2, new Function1() { // from class: com.nothing.generate.NtCaseBleHostApi$Companion$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return NtCaseBleHostApi.Companion.setUp$lambda$18$lambda$17$lambda$16(reply, (Result) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setUp$lambda$18$lambda$17$lambda$16(BasicMessageChannel.Reply reply, Result result) {
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
            if (thM6350exceptionOrNullimpl != null) {
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapError(thM6350exceptionOrNullimpl));
            } else {
                Object value = result.getValue();
                if (Result.m6353isFailureimpl(value)) {
                    value = null;
                }
                reply.reply(NtCaseBlePigeonPigeonUtils.INSTANCE.wrapResult((String) value));
            }
            return Unit.INSTANCE;
        }
    }
}
