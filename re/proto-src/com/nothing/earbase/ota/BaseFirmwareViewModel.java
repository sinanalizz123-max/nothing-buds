package com.nothing.earbase.ota;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.model.Battery;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.router.device.DeviceColor;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NetworkUtils;
import com.nothing.base.util.Utils;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.util.ext.ViewModelExtKt;
import com.nothing.broadcase.util.BleBroadcastParseUtil;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.core.api.EarDeviceRepo;
import com.nothing.earbase.ota.entity.DeviceBattery;
import com.nothing.earbase.ota.entity.DeviceColorEntity;
import com.nothing.earbase.ota.entity.DeviceModelEntity;
import com.nothing.earbase.ota.entity.EarphoneStatus;
import com.nothing.earbase.ota.entity.FirmwareVersion;
import com.nothing.earbase.ota.entity.ServerFirmware;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.log.FileLog;
import com.nothing.log.NTLog;
import com.nothing.network.core.ApiResult;
import com.nothing.nt_ear.NtEarPlugin;
import com.nothing.ota.OTAHelper;
import com.nothing.ota.callback.DownloadInterface;
import com.nothing.ota.callback.TransferInterface;
import com.nothing.ota.entity.OTAProcess;
import com.nothing.ota.entity.ServerCheckItem;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\b\u0016\u0018\u0000 \u00d0\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u00d0\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010tJ\u001e\u0010{\u001a\u00020r2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010|\u001a\u00020\u000bH\u0016J\u0010\u0010}\u001a\u00020r2\u0006\u0010~\u001a\u00020\u000bH\u0016J\b\u0010\u007f\u001a\u00020rH\u0016J\u0007\u0010\u0080\u0001\u001a\u00020rJ\u0007\u0010\u0081\u0001\u001a\u00020\u000bJ\u0011\u0010\u0082\u0001\u001a\u00020r2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\u0010\u0010\u0085\u0001\u001a\u00020r2\u0007\u0010\u0086\u0001\u001a\u00020\u000bJ\u0007\u0010\u0087\u0001\u001a\u00020rJ\u0010\u0010\u0088\u0001\u001a\u00020r2\u0007\u0010\u0089\u0001\u001a\u00020\u000bJ\u0007\u0010\u008a\u0001\u001a\u00020\u000fJ \u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020!0\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0003\u0010\u008e\u0001J\t\u0010\u008f\u0001\u001a\u00020rH\u0002J\u0007\u0010\u0090\u0001\u001a\u00020\u000fJ\u0019\u0010\u0091\u0001\u001a\u00020\u000f2\u0007\u0010\u008d\u0001\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0003\u0010\u008e\u0001J%\u0010\u0092\u0001\u001a\u00020\u000f2\u0007\u0010\u0093\u0001\u001a\u00020\u000f2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0082@\u00a2\u0006\u0003\u0010\u0096\u0001J%\u0010\u0097\u0001\u001a\u00020\u000f2\u0007\u0010\u0098\u0001\u001a\u00020\u000f2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0082@\u00a2\u0006\u0003\u0010\u0096\u0001J\u0014\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0006\u0010b\u001a\u00020\u000fH\u0002J\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0095\u0001J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0002J\t\u0010\u009e\u0001\u001a\u00020rH\u0016J\u0019\u0010\u009f\u0001\u001a\u00020r2\u000e\u0010\u00a0\u0001\u001a\t\u0012\u0004\u0012\u00020!0\u00a1\u0001H\u0002J\u0007\u0010\u00a2\u0001\u001a\u00020rJ\u0010\u0010\u00a3\u0001\u001a\u00020r2\u0007\u0010\u008d\u0001\u001a\u00020\u000fJ\u0013\u0010\u00a4\u0001\u001a\u0005\u0018\u00010\u00a5\u0001H\u0082@\u00a2\u0006\u0003\u0010\u00a6\u0001J\u0013\u0010\u00a7\u0001\u001a\u00020r2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u000f\u0010\u00a8\u0001\u001a\u00020r2\u0006\u0010A\u001a\u00020!J\u0012\u0010\u00a9\u0001\u001a\u00020r2\u0007\u0010\u00aa\u0001\u001a\u000201H\u0016J\u000b\u0010\u00ad\u0001\u001a\u00020\u000f*\u000201J\u0012\u0010\u00ae\u0001\u001a\u00020r2\u0007\u0010\u00af\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010\u00b0\u0001\u001a\u00020r2\u0007\u0010\u00b1\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u00b2\u0001\u001a\u00020rH\u0002J\u0012\u0010\u00b3\u0001\u001a\u00020r2\t\b\u0002\u0010\u00b4\u0001\u001a\u00020\u000bJ\t\u0010\u00b5\u0001\u001a\u00020rH\u0016J\t\u0010\u00b6\u0001\u001a\u00020rH\u0016J\u0012\u0010\u00b7\u0001\u001a\u00020r2\u0007\u0010\u00aa\u0001\u001a\u000201H\u0016J\t\u0010\u00b8\u0001\u001a\u00020rH\u0016J\t\u0010\u00b9\u0001\u001a\u00020rH\u0016J\t\u0010\u00ba\u0001\u001a\u00020rH\u0016J\u001d\u0010\u00bb\u0001\u001a\u00020r2\u0007\u0010\u00bc\u0001\u001a\u0002012\t\u0010\u00bd\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u00be\u0001\u001a\u00020r2\u0007\u0010\u00bf\u0001\u001a\u0002012\b\u0010\u00c0\u0001\u001a\u00030\u00a5\u0001H\u0016J\u001b\u0010\u00c1\u0001\u001a\u00020r2\u0007\u0010\u00c2\u0001\u001a\u0002012\u0007\u0010\u00c3\u0001\u001a\u00020\u000fH\u0016J\u0007\u0010\u00c4\u0001\u001a\u00020rJ\u0007\u0010\u00c5\u0001\u001a\u00020rJ\u0010\u0010\u00c6\u0001\u001a\u00020\u000bH\u0082@\u00a2\u0006\u0003\u0010\u00a6\u0001J\t\u0010\u00c7\u0001\u001a\u000201H\u0016J\u0010\u0010\u00c8\u0001\u001a\u00020\u000bH\u0082@\u00a2\u0006\u0003\u0010\u00a6\u0001J\u0010\u0010\u00c9\u0001\u001a\u00020\u000bH\u0082@\u00a2\u0006\u0003\u0010\u00a6\u0001J\u0010\u0010\u00ca\u0001\u001a\u00020\u000bH\u0082@\u00a2\u0006\u0003\u0010\u00a6\u0001J\u0010\u0010\u00cb\u0001\u001a\u00020r2\u0007\u0010\u00cc\u0001\u001a\u00020\u000fJ\u0007\u0010\u00cd\u0001\u001a\u00020rJ\t\u0010\u00ce\u0001\u001a\u00020rH\u0014J\u0007\u0010\u00cf\u0001\u001a\u00020rR\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\rR\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001f\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 \u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001f\u0010$\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u001f\u0010&\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\rR\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\rR\u0011\u0010*\u001a\u00020+\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001f\u0010.\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\rR\u001f\u00100\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u000101010 \u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u00103\u001a\u000204\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u000204\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00106R\u001f\u00109\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\rR\u001f\u0010;\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u000101010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\rR\u001f\u0010=\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u000101010 \u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010#R\u001f\u0010?\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u000101010 \u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010#R\u001a\u0010A\u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001f\u0010F\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010\rR\u001f\u0010H\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010\rR\u001f\u0010J\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010\rR\u001f\u0010L\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010\rR\u001f\u0010N\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\rR\u001f\u0010P\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010\rR\u001f\u0010R\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000f0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010\rR\u001a\u0010T\u001a\u000201X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0011\u0010^\u001a\u000204\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u00106R\u001a\u0010`\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0016\"\u0004\ba\u0010\u0018R\u001a\u0010b\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010[\"\u0004\bd\u0010]R\u001a\u0010e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010[\"\u0004\bg\u0010]R\u001a\u0010h\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0016\"\u0004\bi\u0010\u0018R(\u0010j\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010#\"\u0004\bl\u0010mR\u000e\u0010n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001f\u0010o\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0 \u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010#R\u001a\u0010u\u001a\u00020vX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u0010\u0010\u00ab\u0001\u001a\u00030\u00ac\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00d1\u0001"}, d2 = {"Lcom/nothing/earbase/ota/BaseFirmwareViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/nothing/ota/callback/DownloadInterface;", "Lcom/nothing/ota/callback/TransferInterface;", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "isCheckProgress", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "()Landroidx/databinding/ObservableField;", "currentVersionText", "", "getCurrentVersionText", "updateNewText", "getUpdateNewText", "versionDesc", "getVersionDesc", "isNotification", "()Z", "setNotification", "(Z)V", "protocol", "Lcom/nothing/earbase/spp/BaseSppProtocol;", "getProtocol", "()Lcom/nothing/earbase/spp/BaseSppProtocol;", "setProtocol", "(Lcom/nothing/earbase/spp/BaseSppProtocol;)V", "otaFirmware", "Landroidx/lifecycle/MutableLiveData;", "Lcom/nothing/earbase/ota/entity/ServerFirmware;", "getOtaFirmware", "()Landroidx/lifecycle/MutableLiveData;", "versionTextShow", "getVersionTextShow", "versionCaseTextShow", "getVersionCaseTextShow", "newFileStr", "getNewFileStr", "updateBtnVisible", "Landroidx/databinding/ObservableBoolean;", "getUpdateBtnVisible", "()Landroidx/databinding/ObservableBoolean;", "progressVisible", "getProgressVisible", "checkBatteryStatus", "", "getCheckBatteryStatus", "downloadProgress", "Landroidx/databinding/ObservableInt;", "getDownloadProgress", "()Landroidx/databinding/ObservableInt;", "progressDrawable", "getProgressDrawable", "totalProgress", "getTotalProgress", "firmwareProgress", "getFirmwareProgress", "currentFragment", "getCurrentFragment", "firmwareStatus", "getFirmwareStatus", "serverFirmware", "getServerFirmware", "()Lcom/nothing/earbase/ota/entity/ServerFirmware;", "setServerFirmware", "(Lcom/nothing/earbase/ota/entity/ServerFirmware;)V", "tipsTitle", "getTipsTitle", "tipsContent", "getTipsContent", "tipsVisible", "getTipsVisible", "doneVisible", "getDoneVisible", "readMoreVisible", "getReadMoreVisible", "shadowVisible", "getShadowVisible", "readMoreText", "getReadMoreText", "newTextHeight", "getNewTextHeight", "()I", "setNewTextHeight", "(I)V", "testOTAPath", "getTestOTAPath", "()Ljava/lang/String;", "setTestOTAPath", "(Ljava/lang/String;)V", "newTextHeightChange", "getNewTextHeightChange", "isSystemPage", "setSystemPage", "address", "getAddress", "setAddress", "modelId", "getModelId", "setModelId", "isOtherOTA", "setOtherOTA", "repeatOTA", "getRepeatOTA", "setRepeatOTA", "(Landroidx/lifecycle/MutableLiveData;)V", "isStartUpdate", "gotoLastActivity", "getGotoLastActivity", "setCurrentMacAddress", "", "extras", "Landroid/os/Bundle;", "successTime", "", "getSuccessTime", "()J", "setSuccessTime", "(J)V", "initViewModel", "isOsView", "setUpgrade", "isForce", "setDowngrade", "updateHeightChange", "isInstalling", "initOTAViewModel", "otaProcess", "Lcom/nothing/ota/entity/OTAProcess;", "showDownloadTips", "downloading", "showMore", "setShowReadMoreBtn", "show", "getDeviceMac", "checkDeviceServer", "Lcom/nothing/network/core/ApiResult;", "version", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTwsVersion", "getCurrentVersion", "getCurrentModelId", "checkEarOneModelId", "productId", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "(Ljava/lang/String;Lcom/nothing/protocol/device/TWSDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkModelId", "cacheProductId", "getCurrentDaoDevice", "Lcom/nothing/database/entity/DeviceItem;", "getTWSDevice", "getBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "requestDeviceServer", "requestFailure", "apiResult", "Lcom/nothing/network/core/ApiResult$Failure;", "serverErrorDeal", "updateDeviceDaoVersion", "getDeviceVersion", "Lcom/nothing/protocol/model/Message;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initOTA", "checkUpdateStatus", "download", "progress", "decimalFormat", "Ljava/text/DecimalFormat;", "formatProgress", "downSuccess", "isValid", "downLoadFileSuccess", "canUpdate", "getInvalidDownloadUrl", "startWorkManager", "isTryAgain", "downFail", "downUrlInvalid", "transfer", "transferSuccess", "onConnected", "onDisconnected", "onError", "code", "message", "onUpdate", "cmdType", "data", "transferFail", "errorCode", "errorMsg", "onCheckBatteryAndStatus", "confirmUpdateOrInstall", "checkBattery", "minOTABattery", "checkStereoStatus", "checkBatteryAndStatus", "deviceStatus", "clickTestOTA", "path", "firmwareTrayAgain", "onCleared", "releaseOTA", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseFirmwareViewModel extends AndroidViewModel implements DownloadInterface, TransferInterface, TWSDevice.Callback {
    public static final int BATTERY_VALUE = 30;
    public static final int CHECK_UPDATE_FRAGMENT = 0;
    public static final String EAR_ONE_BLACK_ID = "624011";
    public static final String EAR_ONE_PRODUCT = "B181";
    public static final String EAR_ONE_VERSION_PREFIX = "0.6700.";
    public static final String EAR_ONE_WHITE_ID = "31D53D";
    public static final int KEEP_TIME = 200;
    public static final long LOADING_TIME = 30000;
    public static final int NEED_UPDATE = 1;
    public static final int NEW_FIRMWARE_FRAGMENT = 1;
    public static final double PROGRESS_DOWNLOAD_MAX = 0.05d;
    public static final double PROGRESS_INSTALL_MAX = 0.93d;
    public static final int PROGRESS_MAX = 100;
    public static final int PROGRESS_MAX_98 = 98;
    public static final int PROGRESS_MAX_KEEP = 1;
    public static final int STATE_CHECKING = 0;
    public static final int STATE_CHECKING_FIRMWARE = 3;
    public static final int STATE_CHECKING_LATEST_VERSION = 5;
    public static final int STATE_CHECKING_NET_ERROR = 2;
    public static final int STATE_CHECKING_PERMISSION = 1;
    public static final int STATE_CHECKING_VERSION_ERROR = 4;
    public static final int STATE_DOWNLOAD_ERROR = 8;
    public static final int STATE_DOWNLOAD_NEED = 6;
    public static final int STATE_DOWNLOAD_START = 7;
    public static final int STATE_INSTALLING_FAIL = 14;
    public static final int STATE_INSTALLING_RETRY = 11;
    public static final int STATE_INSTALLING_SUCCESS = 12;
    public static final int STATE_INSTALLING_SUCCESS_CONNECTING = 13;
    public static final int STATE_INSTALL_NEED = 9;
    public static final int STATE_INSTALL_START = 10;
    public static final int STATE_INSTALL_START_LOCAL = 15;
    public static final int STEREO_BATTERY_VALUE = 20;
    public static final long TRY_AGAIN_DELAY_TIME = 1000;
    public static final int UPDATE_CANCEL = 2;
    public static final int UPDATE_INIT = 0;
    public static final int UPDATE_SURE = 1;
    private String address;
    private final MutableLiveData<Integer> checkBatteryStatus;
    private final MutableLiveData<Integer> currentFragment;
    private final ObservableField<String> currentVersionText;
    private DecimalFormat decimalFormat;
    private final ObservableField<Boolean> doneVisible;
    private final ObservableInt downloadProgress;
    private final ObservableField<Integer> firmwareProgress;
    private final MutableLiveData<Integer> firmwareStatus;
    private final MutableLiveData<Boolean> gotoLastActivity;
    private final ObservableField<Boolean> isCheckProgress;
    private boolean isNotification;
    private boolean isOtherOTA;
    private boolean isStartUpdate;
    private boolean isSystemPage;
    private String modelId;
    private final ObservableField<String> newFileStr;
    private int newTextHeight;
    private final ObservableInt newTextHeightChange;
    private final MutableLiveData<ServerFirmware> otaFirmware;
    private final ObservableInt progressDrawable;
    private final ObservableField<Boolean> progressVisible;
    public BaseSppProtocol protocol;
    private final ObservableField<String> readMoreText;
    private final ObservableField<Boolean> readMoreVisible;
    private MutableLiveData<Boolean> repeatOTA;
    public ServerFirmware serverFirmware;
    private final ObservableField<Boolean> shadowVisible;
    private long successTime;
    private String testOTAPath;
    private final ObservableField<String> tipsContent;
    private final ObservableField<String> tipsTitle;
    private final ObservableField<Boolean> tipsVisible;
    private final ObservableField<String> totalProgress;
    private final ObservableBoolean updateBtnVisible;
    private final ObservableField<String> updateNewText;
    private final ObservableField<String> versionCaseTextShow;
    private final ObservableField<String> versionDesc;
    private final ObservableField<String> versionTextShow;

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$checkBattery$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel", f = "BaseFirmwareViewModel.kt", i = {0}, l = {827, 834}, m = "checkBattery", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseFirmwareViewModel.this.checkBattery(this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$checkBatteryAndStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel", f = "BaseFirmwareViewModel.kt", i = {0}, l = {852, 861}, m = "checkBatteryAndStatus", n = {"this"}, s = {"L$0"})
    static final class C06911 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06911(Continuation<? super C06911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseFirmwareViewModel.this.checkBatteryAndStatus(this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$checkEarOneModelId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel", f = "BaseFirmwareViewModel.kt", i = {0}, l = {323}, m = "checkEarOneModelId", n = {"this"}, s = {"L$0"})
    static final class C06921 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06921(Continuation<? super C06921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseFirmwareViewModel.this.checkEarOneModelId(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$checkModelId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel", f = "BaseFirmwareViewModel.kt", i = {0, 0, 0, 1, 1}, l = {340, 346}, m = "checkModelId", n = {"this", "cacheProductId", "twsDevice", "this", "productId"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C06931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C06931(Continuation<? super C06931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseFirmwareViewModel.this.checkModelId(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$checkStereoStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel", f = "BaseFirmwareViewModel.kt", i = {0}, l = {843}, m = "checkStereoStatus", n = {"this"}, s = {"L$0"})
    static final class C06941 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06941(Continuation<? super C06941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseFirmwareViewModel.this.checkStereoStatus(this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$deviceStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel", f = "BaseFirmwareViewModel.kt", i = {0}, l = {866}, m = "deviceStatus", n = {"this"}, s = {"L$0"})
    static final class C06961 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06961(Continuation<? super C06961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseFirmwareViewModel.this.deviceStatus(this);
        }
    }

    public Object checkDeviceServer(String str, Continuation<? super ApiResult<ServerFirmware>> continuation) {
        return checkDeviceServer$suspendImpl(this, str, continuation);
    }

    public int minOTABattery() {
        return 20;
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(int code, String message) {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void setDowngrade() {
    }

    public void setUpgrade(boolean isForce) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFirmwareViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.isCheckProgress = new ObservableField<>(true);
        this.currentVersionText = new ObservableField<>("");
        this.updateNewText = new ObservableField<>("");
        this.versionDesc = new ObservableField<>("");
        MutableLiveData<ServerFirmware> mutableLiveData = new MutableLiveData<>();
        this.otaFirmware = mutableLiveData;
        this.versionTextShow = new ObservableField<>("");
        this.versionCaseTextShow = new ObservableField<>("");
        ServerFirmware value = mutableLiveData.getValue();
        this.newFileStr = new ObservableField<>(value != null ? value.getNewFileSize() : null);
        this.updateBtnVisible = new ObservableBoolean(true);
        this.progressVisible = new ObservableField<>(false);
        this.checkBatteryStatus = new MutableLiveData<>(0);
        this.downloadProgress = new ObservableInt(0);
        this.progressDrawable = new ObservableInt(R.drawable.download_progress_bg);
        this.totalProgress = new ObservableField<>(formatProgress(0));
        this.firmwareProgress = new ObservableField<>(0);
        this.currentFragment = new MutableLiveData<>(0);
        this.firmwareStatus = new MutableLiveData<>(0);
        this.tipsTitle = new ObservableField<>("");
        this.tipsContent = new ObservableField<>("");
        this.tipsVisible = new ObservableField<>(false);
        this.doneVisible = new ObservableField<>(false);
        this.readMoreVisible = new ObservableField<>(false);
        this.shadowVisible = new ObservableField<>(false);
        this.readMoreText = new ObservableField<>("");
        this.testOTAPath = "";
        this.newTextHeightChange = new ObservableInt(0);
        this.address = SpUtils.INSTANCE.getSelectDeviceMac();
        this.modelId = SpUtils.INSTANCE.getCurrentModel();
        this.repeatOTA = new MutableLiveData<>(false);
        this.gotoLastActivity = new MutableLiveData<>(false);
        this.successTime = 30000L;
        this.decimalFormat = new DecimalFormat("0%");
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

    public final ObservableField<Boolean> isCheckProgress() {
        return this.isCheckProgress;
    }

    public final ObservableField<String> getCurrentVersionText() {
        return this.currentVersionText;
    }

    public final ObservableField<String> getUpdateNewText() {
        return this.updateNewText;
    }

    public final ObservableField<String> getVersionDesc() {
        return this.versionDesc;
    }

    /* JADX INFO: renamed from: isNotification, reason: from getter */
    public final boolean getIsNotification() {
        return this.isNotification;
    }

    public final void setNotification(boolean z) {
        this.isNotification = z;
    }

    public final BaseSppProtocol getProtocol() {
        BaseSppProtocol baseSppProtocol = this.protocol;
        if (baseSppProtocol != null) {
            return baseSppProtocol;
        }
        Intrinsics.throwUninitializedPropertyAccessException("protocol");
        return null;
    }

    public final void setProtocol(BaseSppProtocol baseSppProtocol) {
        Intrinsics.checkNotNullParameter(baseSppProtocol, "<set-?>");
        this.protocol = baseSppProtocol;
    }

    public final MutableLiveData<ServerFirmware> getOtaFirmware() {
        return this.otaFirmware;
    }

    public final ObservableField<String> getVersionTextShow() {
        return this.versionTextShow;
    }

    public final ObservableField<String> getVersionCaseTextShow() {
        return this.versionCaseTextShow;
    }

    public final ObservableField<String> getNewFileStr() {
        return this.newFileStr;
    }

    public final ObservableBoolean getUpdateBtnVisible() {
        return this.updateBtnVisible;
    }

    public final ObservableField<Boolean> getProgressVisible() {
        return this.progressVisible;
    }

    public final MutableLiveData<Integer> getCheckBatteryStatus() {
        return this.checkBatteryStatus;
    }

    public final ObservableInt getDownloadProgress() {
        return this.downloadProgress;
    }

    public final ObservableInt getProgressDrawable() {
        return this.progressDrawable;
    }

    public final ObservableField<String> getTotalProgress() {
        return this.totalProgress;
    }

    public final ObservableField<Integer> getFirmwareProgress() {
        return this.firmwareProgress;
    }

    public final MutableLiveData<Integer> getCurrentFragment() {
        return this.currentFragment;
    }

    public final MutableLiveData<Integer> getFirmwareStatus() {
        return this.firmwareStatus;
    }

    public final ServerFirmware getServerFirmware() {
        ServerFirmware serverFirmware = this.serverFirmware;
        if (serverFirmware != null) {
            return serverFirmware;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serverFirmware");
        return null;
    }

    public final void setServerFirmware(ServerFirmware serverFirmware) {
        Intrinsics.checkNotNullParameter(serverFirmware, "<set-?>");
        this.serverFirmware = serverFirmware;
    }

    public final ObservableField<String> getTipsTitle() {
        return this.tipsTitle;
    }

    public final ObservableField<String> getTipsContent() {
        return this.tipsContent;
    }

    public final ObservableField<Boolean> getTipsVisible() {
        return this.tipsVisible;
    }

    public final ObservableField<Boolean> getDoneVisible() {
        return this.doneVisible;
    }

    public final ObservableField<Boolean> getReadMoreVisible() {
        return this.readMoreVisible;
    }

    public final ObservableField<Boolean> getShadowVisible() {
        return this.shadowVisible;
    }

    public final ObservableField<String> getReadMoreText() {
        return this.readMoreText;
    }

    public final int getNewTextHeight() {
        return this.newTextHeight;
    }

    public final void setNewTextHeight(int i) {
        this.newTextHeight = i;
    }

    public final String getTestOTAPath() {
        return this.testOTAPath;
    }

    public final void setTestOTAPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testOTAPath = str;
    }

    public final ObservableInt getNewTextHeightChange() {
        return this.newTextHeightChange;
    }

    /* JADX INFO: renamed from: isSystemPage, reason: from getter */
    public final boolean getIsSystemPage() {
        return this.isSystemPage;
    }

    public final void setSystemPage(boolean z) {
        this.isSystemPage = z;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final void setModelId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelId = str;
    }

    /* JADX INFO: renamed from: isOtherOTA, reason: from getter */
    public final boolean getIsOtherOTA() {
        return this.isOtherOTA;
    }

    public final void setOtherOTA(boolean z) {
        this.isOtherOTA = z;
    }

    public final MutableLiveData<Boolean> getRepeatOTA() {
        return this.repeatOTA;
    }

    public final void setRepeatOTA(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.repeatOTA = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getGotoLastActivity() {
        return this.gotoLastActivity;
    }

    public final void setCurrentMacAddress(Bundle extras) {
        String string = extras != null ? extras.getString("device_address") : null;
        String str = string;
        if (str == null || str.length() == 0) {
            return;
        }
        this.address = string;
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.address);
        String modelId = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getModelId() : null;
        String str2 = modelId;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.modelId = modelId;
    }

    public final long getSuccessTime() {
        return this.successTime;
    }

    public final void setSuccessTime(long j) {
        this.successTime = j;
    }

    public static /* synthetic */ void initViewModel$default(BaseFirmwareViewModel baseFirmwareViewModel, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initViewModel");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        baseFirmwareViewModel.initViewModel(str, z);
    }

    public void initViewModel(String address, boolean isOsView) {
        IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(this.modelId);
        if (productByModelId != null) {
            if (productByModelId.hasCaseUpdate()) {
                this.successTime = 120000L;
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseFirmwareViewModel$initViewModel$1$1(this, null), 3, null);
            }
            OTAProcess oTAProcessCreateOTAProcess = productByModelId.createOTAProcess();
            if (oTAProcessCreateOTAProcess != null) {
                initOTAViewModel(oTAProcessCreateOTAProcess);
            }
        }
    }

    public final void updateHeightChange() {
        this.newTextHeightChange.set(this.newTextHeightChange.get() + 1);
    }

    public final boolean isInstalling() {
        Integer value = this.firmwareStatus.getValue();
        if (value != null && value.intValue() == 10) {
            return true;
        }
        Integer value2 = this.firmwareStatus.getValue();
        if (value2 != null && value2.intValue() == 11) {
            return true;
        }
        Integer value3 = this.firmwareStatus.getValue();
        if (value3 != null && value3.intValue() == 13) {
            return true;
        }
        Integer value4 = this.firmwareStatus.getValue();
        if (value4 != null && value4.intValue() == 14) {
            return true;
        }
        Integer value5 = this.firmwareStatus.getValue();
        return value5 != null && value5.intValue() == 15;
    }

    public final void initOTAViewModel(OTAProcess otaProcess) {
        Intrinsics.checkNotNullParameter(otaProcess, "otaProcess");
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            tWSDevice.register(this);
        }
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 != null && !tWSDevice2.isConnected()) {
            this.gotoLastActivity.postValue(true);
        }
        this.isStartUpdate = false;
        requestDeviceServer();
        initOTA(otaProcess);
        OTAHelper.INSTANCE.clearDownload(getDeviceMac());
    }

    public final void showDownloadTips(boolean downloading) {
        String string;
        IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(SpUtils.INSTANCE.getCurrentModel());
        boolean z = false;
        if (productByModelId != null && productByModelId.getType() == 6) {
            z = true;
        }
        if (downloading) {
            BaseFirmwareViewModel baseFirmwareViewModel = this;
            this.tipsTitle.set(ViewModelExtKt.getString(baseFirmwareViewModel, R.string.new_firmware_update_hint_title));
            if (z) {
                this.tipsContent.set(ViewModelExtKt.getString(baseFirmwareViewModel, R.string.firmware_update_hint_headphone));
            } else {
                this.tipsContent.set(ViewModelExtKt.getString(baseFirmwareViewModel, R.string.new_firmware_update_hint));
            }
        } else {
            BaseFirmwareViewModel baseFirmwareViewModel2 = this;
            this.tipsTitle.set(ViewModelExtKt.getString(baseFirmwareViewModel2, R.string.firmware_while_update));
            String string2 = ViewModelExtKt.getString(baseFirmwareViewModel2, R.string.firmware_updating);
            if (z) {
                string = ViewModelExtKt.getString(baseFirmwareViewModel2, R.string.firmware_updating_3);
            } else {
                string = ViewModelExtKt.getString(baseFirmwareViewModel2, R.string.firmware_updating_2);
            }
            this.tipsContent.set((string2 + "\n\n" + string) + "\n\n" + ViewModelExtKt.getString(baseFirmwareViewModel2, R.string.firmware_updating_4));
        }
        if (this.isSystemPage) {
            this.tipsVisible.set(true);
        }
    }

    public final void showMore() {
        Boolean bool = this.shadowVisible.get();
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        if (zBooleanValue) {
            this.readMoreText.set(ViewModelExtKt.getString(this, R.string.firmware_read_less));
        } else {
            this.readMoreText.set(ViewModelExtKt.getString(this, R.string.firmware_read_more));
        }
        this.shadowVisible.set(Boolean.valueOf(!zBooleanValue));
    }

    public final void setShowReadMoreBtn(boolean show) {
        this.readMoreText.set(ViewModelExtKt.getString(this, R.string.firmware_read_more));
        this.shadowVisible.set(Boolean.valueOf(show));
        this.readMoreVisible.set(Boolean.valueOf(show));
    }

    public final String getDeviceMac() {
        String address;
        TWSDevice tWSDevice = getTWSDevice();
        return (tWSDevice == null || (address = tWSDevice.getAddress()) == null) ? "" : address;
    }

    static /* synthetic */ Object checkDeviceServer$suspendImpl(BaseFirmwareViewModel baseFirmwareViewModel, String str, Continuation<? super ApiResult<ServerFirmware>> continuation) {
        return EarDeviceRepo.checkDeviceServer$default(EarDeviceRepo.INSTANCE, str, 0, null, baseFirmwareViewModel.address, baseFirmwareViewModel.modelId, continuation, 6, null);
    }

    private final void updateTwsVersion() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            ServerFirmware value = this.otaFirmware.getValue();
            tWSDevice.setVersion(value != null ? value.getVersion() : null);
        }
    }

    public final String getCurrentVersion() {
        String firmwareVersion;
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.address);
        return (iOTDeviceByMacAddress == null || (firmwareVersion = iOTDeviceByMacAddress.getFirmwareVersion()) == null) ? "" : firmwareVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getCurrentModelId(String str, Continuation<? super String> continuation) {
        String productId;
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.address);
        if (iOTDeviceByMacAddress == null || (productId = iOTDeviceByMacAddress.getProductId()) == null) {
            productId = "";
        }
        IOTDevice iOTDeviceByMacAddress2 = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.address);
        TWSDevice twsDevice = iOTDeviceByMacAddress2 != null ? iOTDeviceByMacAddress2.getTwsDevice() : null;
        if (StringsKt.startsWith$default(str, EAR_ONE_VERSION_PREFIX, false, 2, (Object) null)) {
            return checkEarOneModelId(productId, twsDevice, continuation);
        }
        return checkModelId(productId, twsDevice, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:31:0x0085  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object checkEarOneModelId(String str, TWSDevice tWSDevice, Continuation<? super String> continuation) {
        C06921 c06921;
        BaseFirmwareViewModel baseFirmwareViewModel;
        Message message;
        IOTDevice iOTDeviceByMacAddress;
        DeviceColorEntity deviceColorEntity;
        if (continuation instanceof C06921) {
            c06921 = (C06921) continuation;
            if ((c06921.label & Integer.MIN_VALUE) != 0) {
                c06921.label -= Integer.MIN_VALUE;
            } else {
                c06921 = new C06921(continuation);
            }
        } else {
            c06921 = new C06921(continuation);
        }
        C06921 c06922 = c06921;
        Object objSyncSetResponse$default = c06922.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06922.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSyncSetResponse$default);
            if (Intrinsics.areEqual(str, "B181")) {
                baseFirmwareViewModel = this;
            } else {
                if (tWSDevice != null) {
                    c06922.L$0 = this;
                    c06922.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDevice, ProtocolConstant.Query.GET_REMOTE_COLOR_ID, null, null, false, false, null, c06922, 62, null);
                    if (objSyncSetResponse$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    baseFirmwareViewModel = this;
                } else {
                    message = null;
                    baseFirmwareViewModel = this;
                }
                if (message != null || (deviceColorEntity = (DeviceColorEntity) message.obtainPayload(DeviceColorEntity.class)) == null || deviceColorEntity.getColor() == null) {
                    DeviceColor deviceColor = DeviceColor.WHITE;
                }
                DeviceColor deviceColor2 = DeviceColor.WHITE;
                baseFirmwareViewModel.modelId = "31D53D";
                iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(baseFirmwareViewModel.address);
                if (iOTDeviceByMacAddress != null) {
                    iOTDeviceByMacAddress.setModelId(baseFirmwareViewModel.modelId);
                }
            }
            return baseFirmwareViewModel.modelId;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        baseFirmwareViewModel = (BaseFirmwareViewModel) c06922.L$0;
        ResultKt.throwOnFailure(objSyncSetResponse$default);
        message = (Message) objSyncSetResponse$default;
        if (message != null) {
            DeviceColor deviceColor3 = DeviceColor.WHITE;
        } else {
            DeviceColor deviceColor4 = DeviceColor.WHITE;
        }
        DeviceColor deviceColor5 = DeviceColor.WHITE;
        baseFirmwareViewModel.modelId = "31D53D";
        iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(baseFirmwareViewModel.address);
        if (iOTDeviceByMacAddress != null) {
            iOTDeviceByMacAddress.setModelId(baseFirmwareViewModel.modelId);
        }
        return baseFirmwareViewModel.modelId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x009a  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:51:0x0102  */
    /* JADX WARN: Code duplicated, block: B:53:0x010e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0116 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
    
        if (r2 == r14) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkModelId(String str, TWSDevice tWSDevice, Continuation<? super String> continuation) {
        C06931 c06931;
        String str2;
        TWSDevice tWSDevice2;
        BaseFirmwareViewModel baseFirmwareViewModel;
        Message message;
        TWSDevice tWSDevice3;
        BaseFirmwareViewModel baseFirmwareViewModel2;
        String productId;
        DeviceModelEntity deviceModelEntity;
        String colorHex;
        String str3;
        IOTDevice iOTDeviceByMacAddress;
        DeviceColorEntity deviceColorEntity;
        if (continuation instanceof C06931) {
            c06931 = (C06931) continuation;
            if ((c06931.label & Integer.MIN_VALUE) != 0) {
                c06931.label -= Integer.MIN_VALUE;
            } else {
                c06931 = new C06931(continuation);
            }
        } else {
            c06931 = new C06931(continuation);
        }
        C06931 c06932 = c06931;
        Object objSendMessageSync$default = c06932.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06932.label;
        Message message2 = null;
        if (i != 0) {
            if (i == 1) {
                tWSDevice3 = (TWSDevice) c06932.L$2;
                String str4 = (String) c06932.L$1;
                baseFirmwareViewModel2 = (BaseFirmwareViewModel) c06932.L$0;
                ResultKt.throwOnFailure(objSendMessageSync$default);
                str2 = str4;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                productId = (String) c06932.L$1;
                baseFirmwareViewModel = (BaseFirmwareViewModel) c06932.L$0;
                ResultKt.throwOnFailure(objSendMessageSync$default);
            }
            message2 = (Message) objSendMessageSync$default;
            if (message2 != null || (deviceColorEntity = (DeviceColorEntity) message2.obtainPayload(DeviceColorEntity.class)) == null || (colorHex = deviceColorEntity.getColorHex()) == null) {
                colorHex = "02";
            }
            String str5 = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(productId + colorHex);
            str3 = str5 != null ? str5 : "";
            if (str3.length() <= 0) {
                return str3;
            }
            baseFirmwareViewModel.modelId = str3;
            iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(baseFirmwareViewModel.address);
            if (iOTDeviceByMacAddress != null) {
                iOTDeviceByMacAddress.setModelId(baseFirmwareViewModel.modelId);
            }
            return baseFirmwareViewModel.modelId;
        }
        ResultKt.throwOnFailure(objSendMessageSync$default);
        if (tWSDevice != null) {
            c06932.L$0 = this;
            str2 = str;
            c06932.L$1 = str2;
            c06932.L$2 = tWSDevice;
            c06932.label = 1;
            objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_DEVICE_MODEL, null, false, false, null, null, c06932, 62, null);
            if (objSendMessageSync$default != coroutine_suspended) {
                tWSDevice3 = tWSDevice;
                baseFirmwareViewModel2 = this;
            }
        } else {
            str2 = str;
            tWSDevice2 = tWSDevice;
            baseFirmwareViewModel = this;
            message = null;
            if (message != null || (deviceModelEntity = (DeviceModelEntity) message.obtainPayload(DeviceModelEntity.class)) == null || (productId = deviceModelEntity.getProductId()) == null) {
                productId = "";
            }
            if (Intrinsics.areEqual(str2, productId)) {
                return baseFirmwareViewModel.modelId;
            }
            if (tWSDevice2 != null) {
                c06932.L$0 = baseFirmwareViewModel;
                c06932.L$1 = productId;
                c06932.L$2 = null;
                c06932.label = 2;
                objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice2, ProtocolConstant.Query.GET_REMOTE_COLOR_ID, null, false, false, null, null, c06932, 62, null);
            }
            if (message2 != null) {
                colorHex = "02";
            } else {
                colorHex = "02";
            }
            String str6 = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(productId + colorHex);
            if (str6 != null) {
            }
            if (str3.length() <= 0) {
                return str3;
            }
            baseFirmwareViewModel.modelId = str3;
            iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(baseFirmwareViewModel.address);
            if (iOTDeviceByMacAddress != null) {
                iOTDeviceByMacAddress.setModelId(baseFirmwareViewModel.modelId);
            }
            return baseFirmwareViewModel.modelId;
        }
        return coroutine_suspended;
        message = (Message) objSendMessageSync$default;
        baseFirmwareViewModel = baseFirmwareViewModel2;
        tWSDevice2 = tWSDevice3;
        if (message != null) {
            productId = "";
        } else {
            productId = "";
        }
        if (Intrinsics.areEqual(str2, productId)) {
            return baseFirmwareViewModel.modelId;
        }
        if (tWSDevice2 != null) {
            c06932.L$0 = baseFirmwareViewModel;
            c06932.L$1 = productId;
            c06932.L$2 = null;
            c06932.label = 2;
            objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice2, ProtocolConstant.Query.GET_REMOTE_COLOR_ID, null, false, false, null, null, c06932, 62, null);
        }
        if (message2 != null) {
            colorHex = "02";
        } else {
            colorHex = "02";
        }
        String str7 = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(productId + colorHex);
        if (str7 != null) {
        }
        if (str3.length() <= 0) {
            return str3;
        }
        baseFirmwareViewModel.modelId = str3;
        iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(baseFirmwareViewModel.address);
        if (iOTDeviceByMacAddress != null) {
            iOTDeviceByMacAddress.setModelId(baseFirmwareViewModel.modelId);
        }
        return baseFirmwareViewModel.modelId;
    }

    private final DeviceItem getCurrentDaoDevice(String address) {
        List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(address);
        if (deviceItem != null) {
            return (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem);
        }
        return null;
    }

    public final TWSDevice getTWSDevice() {
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.address);
        if (iOTDeviceByMacAddress != null) {
            return iOTDeviceByMacAddress.getTwsDevice();
        }
        return null;
    }

    private final BluetoothDevice getBluetoothDevice() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            return tWSDevice.getDevice();
        }
        return null;
    }

    public void requestDeviceServer() {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        if (networkUtils.isInternetAvailable(application)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07011(null), 2, null);
        } else {
            this.firmwareStatus.postValue(2);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$requestDeviceServer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$requestDeviceServer$1", f = "BaseFirmwareViewModel.kt", i = {0}, l = {385, 387, 392}, m = "invokeSuspend", n = {"version"}, s = {"L$0"})
    static final class C07011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C07011(Continuation<? super C07011> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFirmwareViewModel.this.new C07011(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.ota.BaseFirmwareViewModel.C07011.C01471(r7.this$0, null), r7) == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.ota.BaseFirmwareViewModel.C07011.AnonymousClass2(r7.this$0, r8, r1, null), r7) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String currentVersion;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                currentVersion = BaseFirmwareViewModel.this.getCurrentVersion();
                this.L$0 = currentVersion;
                this.label = 1;
                obj = BaseFirmwareViewModel.this.getCurrentModelId(currentVersion, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                currentVersion = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            String str = (String) obj;
            if (currentVersion.length() == 0 || str.length() == 0) {
                this.L$0 = null;
                this.label = 2;
            } else {
                this.L$0 = null;
                this.label = 3;
            }
        }

        /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$requestDeviceServer$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$requestDeviceServer$1$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BaseFirmwareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01471(BaseFirmwareViewModel baseFirmwareViewModel, Continuation<? super C01471> continuation) {
                super(2, continuation);
                this.this$0 = baseFirmwareViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01471(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getFirmwareStatus().postValue(Boxing.boxInt(4));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$requestDeviceServer$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$requestDeviceServer$1$2", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $modelId;
            final /* synthetic */ String $version;
            int label;
            final /* synthetic */ BaseFirmwareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(BaseFirmwareViewModel baseFirmwareViewModel, String str, String str2, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = baseFirmwareViewModel;
                this.$modelId = str;
                this.$version = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$modelId, this.$version, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                PluginRegistry plugins;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get("main");
                FlutterPlugin flutterPlugin = (flutterEngine == null || (plugins = flutterEngine.getPlugins()) == null) ? null : plugins.get(NtEarPlugin.class);
                if (flutterPlugin instanceof NtEarPlugin) {
                    String address = this.this$0.getAddress();
                    String str = this.$modelId;
                    String str2 = this.$version;
                    final BaseFirmwareViewModel baseFirmwareViewModel = this.this$0;
                    ((NtEarPlugin) flutterPlugin).checkOTA(address, str, str2, new Function1() { // from class: com.nothing.earbase.ota.BaseFirmwareViewModel$requestDeviceServer$1$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BaseFirmwareViewModel.C07011.AnonymousClass2.invokeSuspend$lambda$0(baseFirmwareViewModel, (ApiResult) obj2);
                        }
                    });
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(BaseFirmwareViewModel baseFirmwareViewModel, ApiResult apiResult) {
                baseFirmwareViewModel.isCheckProgress().set(false);
                if (apiResult instanceof ApiResult.Success) {
                    baseFirmwareViewModel.setServerFirmware((ServerFirmware) ((ApiResult.Success) apiResult).getData());
                    baseFirmwareViewModel.checkUpdateStatus(baseFirmwareViewModel.getServerFirmware());
                } else if (apiResult instanceof ApiResult.Error) {
                    if (((ApiResult.Error) apiResult).getCode() == 423) {
                        baseFirmwareViewModel.checkUpdateStatus(new ServerFirmware(0, null, null, null, null, null, 62, null));
                    } else {
                        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
                        Application application = AppGlobals.INSTANCE.get();
                        Intrinsics.checkNotNull(application);
                        if (networkUtils.isInternetAvailable(application)) {
                            baseFirmwareViewModel.getFirmwareStatus().postValue(4);
                        } else {
                            baseFirmwareViewModel.getFirmwareStatus().postValue(2);
                        }
                    }
                } else if (apiResult instanceof ApiResult.Failure) {
                    baseFirmwareViewModel.requestFailure((ApiResult.Failure) apiResult);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestFailure(ApiResult.Failure<ServerFirmware> apiResult) {
        if (apiResult.getCode() == 423) {
            checkUpdateStatus(new ServerFirmware(0, null, null, null, null, null, 62, null));
        } else {
            this.firmwareStatus.postValue(4);
        }
    }

    public final void serverErrorDeal() {
        this.firmwareStatus.postValue(0);
        this.isCheckProgress.set(true);
        if (getCurrentVersion().length() == 0) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07021(null), 2, null);
        } else {
            requestDeviceServer();
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$serverErrorDeal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$serverErrorDeal$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {444, 449}, m = "invokeSuspend", n = {}, s = {})
    static final class C07021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07021(Continuation<? super C07021> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFirmwareViewModel.this.new C07021(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.ota.BaseFirmwareViewModel.C07021.C01481(r5.this$0, null), r5) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String version;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BaseFirmwareViewModel.this.getDeviceVersion(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            Message message = (Message) obj;
            FirmwareVersion firmwareVersion = message != null ? (FirmwareVersion) message.obtainPayload(FirmwareVersion.class) : null;
            if (firmwareVersion == null || (version = firmwareVersion.getVersionStr()) == null) {
                version = "";
            }
            if (version.length() > 0) {
                BaseFirmwareViewModel.this.updateDeviceDaoVersion(version);
                this.label = 2;
            } else {
                BaseFirmwareViewModel.this.getFirmwareStatus().postValue(Boxing.boxInt(4));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$serverErrorDeal$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$serverErrorDeal$1$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BaseFirmwareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01481(BaseFirmwareViewModel baseFirmwareViewModel, Continuation<? super C01481> continuation) {
                super(2, continuation);
                this.this$0 = baseFirmwareViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01481(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.requestDeviceServer();
                return Unit.INSTANCE;
            }
        }
    }

    public final void updateDeviceDaoVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        DeviceItem currentDaoDevice = getCurrentDaoDevice(this.address);
        if (currentDaoDevice != null) {
            currentDaoDevice.setDeviceVersion(version);
        }
        if (currentDaoDevice != null) {
            DatabaseUtils.INSTANCE.getDeviceDao().updateDeviceItem(currentDaoDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getDeviceVersion(Continuation<? super Message> continuation) {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            return TWSDevice.syncSetResponse$default(tWSDevice, 49218, null, null, false, false, null, continuation, 62, null);
        }
        return null;
    }

    private final void initOTA(OTAProcess otaProcess) {
        BluetoothDevice bluetoothDevice = getBluetoothDevice();
        if (bluetoothDevice != null) {
            OTAHelper.INSTANCE.setOTADevice(bluetoothDevice, otaProcess);
        }
        OTAHelper.INSTANCE.registerDownload(this);
        OTAHelper.INSTANCE.registerTransfer(this);
    }

    public final void checkUpdateStatus(ServerFirmware serverFirmware) {
        String deviceName;
        Intrinsics.checkNotNullParameter(serverFirmware, "serverFirmware");
        String strFirstUpper = null;
        if (serverFirmware.getNeed_update() == 1) {
            this.otaFirmware.postValue(serverFirmware);
            if (this.isSystemPage) {
                this.versionTextShow.set(ViewModelExtKt.getString(this, R.string.new_version, getCurrentVersion() + " > " + serverFirmware.getVersion()));
            } else {
                this.versionTextShow.set(ViewModelExtKt.getString(this, R.string.new_version, getCurrentVersion() + " \u2192 " + serverFirmware.getVersion()));
            }
            this.currentFragment.postValue(1);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06951(serverFirmware, null), 2, null);
            return;
        }
        ObservableField<String> observableField = this.currentVersionText;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        BaseFirmwareViewModel baseFirmwareViewModel = this;
        String str = String.format(ViewModelExtKt.getString(baseFirmwareViewModel, R.string.firmware_version), Arrays.copyOf(new Object[]{getCurrentVersion()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        observableField.set(str);
        ObservableField<String> observableField2 = this.updateNewText;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string = ViewModelExtKt.getString(baseFirmwareViewModel, R.string.least_new_update);
        IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(this.modelId);
        if (productByModelId != null && (deviceName = productByModelId.getDeviceName()) != null) {
            strFirstUpper = DataExtKt.firstUpper(deviceName);
        }
        String str2 = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(strFirstUpper)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        observableField2.set(str2);
        this.currentFragment.postValue(0);
        this.firmwareStatus.postValue(5);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$checkUpdateStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$checkUpdateStatus$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {522}, m = "invokeSuspend", n = {}, s = {})
    static final class C06951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ServerFirmware $serverFirmware;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06951(ServerFirmware serverFirmware, Continuation<? super C06951> continuation) {
            super(2, continuation);
            this.$serverFirmware = serverFirmware;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFirmwareViewModel.this.new C06951(this.$serverFirmware, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int iCheckUpdate$default = OTAHelper.checkUpdate$default(OTAHelper.INSTANCE, new ServerCheckItem(BaseFirmwareViewModel.this.getDeviceMac(), this.$serverFirmware.getVersion(), this.$serverFirmware.getFile_size(), this.$serverFirmware.getSha_256(), BaseFirmwareViewModel.this.getCurrentVersion(), this.$serverFirmware.getLink()), false, 2, null);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C01431(iCheckUpdate$default, BaseFirmwareViewModel.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$checkUpdateStatus$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$checkUpdateStatus$1$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $status;
            int label;
            final /* synthetic */ BaseFirmwareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01431(int i, BaseFirmwareViewModel baseFirmwareViewModel, Continuation<? super C01431> continuation) {
                super(2, continuation);
                this.$status = i;
                this.this$0 = baseFirmwareViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01431(this.$status, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                int i = this.$status;
                if (i == 1 || i == 2) {
                    this.this$0.getFirmwareStatus().postValue(Boxing.boxInt(6));
                } else if (i == 3 || i == 4) {
                    this.this$0.getFirmwareStatus().postValue(Boxing.boxInt(9));
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.ota.callback.DownloadInterface
    public void download(int progress) {
        int i = (int) (((double) progress) * 0.05d);
        this.totalProgress.set(formatProgress(i));
        this.downloadProgress.set(i);
    }

    public final String formatProgress(int i) {
        DecimalFormat decimalFormat;
        if (ViewModelExtKt.getApplicationContext(this).getResources().getConfiguration().getLayoutDirection() == 1) {
            String language = Locale.getDefault().getLanguage();
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "battery view onMeasure language:" + language;
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
            Intrinsics.checkNotNull(language);
            if (StringsKt.startsWith(language, "he", true) || StringsKt.startsWith(language, "iw", true)) {
                decimalFormat = new DecimalFormat("0%");
            } else {
                decimalFormat = new DecimalFormat("%0");
            }
        } else {
            decimalFormat = new DecimalFormat("0%");
        }
        this.decimalFormat = decimalFormat;
        String str4 = decimalFormat.format(Float.valueOf((i * 1.0f) / 100));
        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
        return str4;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$downSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$downSuccess$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO}, m = "invokeSuspend", n = {}, s = {})
    static final class C06971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06971(Continuation<? super C06971> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFirmwareViewModel.this.new C06971(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        
            if (r7 == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
        
            if (r7 == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.ota.BaseFirmwareViewModel.C06971.C01441(r6.this$0, r7, null), r6) == r0) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(BaseFirmwareViewModel.this.getAddress());
                if (productByMacAddress == null || productByMacAddress.getType() != 6) {
                    this.label = 2;
                    obj = BaseFirmwareViewModel.this.deviceStatus(this);
                } else {
                    this.label = 1;
                    obj = BaseFirmwareViewModel.this.checkStereoStatus(this);
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) obj).booleanValue();
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) obj).booleanValue();
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            this.label = 3;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$downSuccess$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$downSuccess$1$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $canUpdate;
            int label;
            final /* synthetic */ BaseFirmwareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01441(BaseFirmwareViewModel baseFirmwareViewModel, boolean z, Continuation<? super C01441> continuation) {
                super(2, continuation);
                this.this$0 = baseFirmwareViewModel;
                this.$canUpdate = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01441(this.this$0, this.$canUpdate, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.downLoadFileSuccess(this.$canUpdate);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // com.nothing.ota.callback.DownloadInterface
    public void downSuccess(boolean isValid) {
        if (isValid) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06971(null), 2, null);
            return;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "try again download file downSuccess".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "try again download file downSuccess " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "try again download file downSuccess " + strComponent2);
            }
        }
        getInvalidDownloadUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downLoadFileSuccess(boolean canUpdate) {
        if (canUpdate) {
            this.firmwareStatus.postValue(10);
        } else if (this.isOtherOTA) {
            this.repeatOTA.postValue(true);
        } else {
            this.checkBatteryStatus.postValue(2);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$getInvalidDownloadUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$getInvalidDownloadUrl$1", f = "BaseFirmwareViewModel.kt", i = {0}, l = {635, 637}, m = "invokeSuspend", n = {"version"}, s = {"L$0"})
    static final class C06981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C06981(Continuation<? super C06981> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFirmwareViewModel.this.new C06981(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r3, new com.nothing.earbase.ota.BaseFirmwareViewModel.C06981.C01451(r5, (java.lang.String) r8, r1, null), r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String currentVersion;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                currentVersion = BaseFirmwareViewModel.this.getCurrentVersion();
                this.L$0 = currentVersion;
                this.label = 1;
                obj = BaseFirmwareViewModel.this.getCurrentModelId(currentVersion, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                currentVersion = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            BaseFirmwareViewModel baseFirmwareViewModel = BaseFirmwareViewModel.this;
            this.L$0 = null;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$getInvalidDownloadUrl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$getInvalidDownloadUrl$1$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $modelId;
            final /* synthetic */ String $version;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ BaseFirmwareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01451(BaseFirmwareViewModel baseFirmwareViewModel, String str, String str2, Continuation<? super C01451> continuation) {
                super(2, continuation);
                this.this$0 = baseFirmwareViewModel;
                this.$modelId = str;
                this.$version = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01451 c01451 = new C01451(this.this$0, this.$modelId, this.$version, continuation);
                c01451.L$0 = obj;
                return c01451;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                PluginRegistry plugins;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get("main");
                FlutterPlugin flutterPlugin = (flutterEngine == null || (plugins = flutterEngine.getPlugins()) == null) ? null : plugins.get(NtEarPlugin.class);
                if (flutterPlugin instanceof NtEarPlugin) {
                    String address = this.this$0.getAddress();
                    String str = this.$modelId;
                    String str2 = this.$version;
                    final BaseFirmwareViewModel baseFirmwareViewModel = this.this$0;
                    ((NtEarPlugin) flutterPlugin).checkOTA(address, str, str2, new Function1() { // from class: com.nothing.earbase.ota.BaseFirmwareViewModel$getInvalidDownloadUrl$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BaseFirmwareViewModel.C06981.C01451.invokeSuspend$lambda$2(baseFirmwareViewModel, coroutineScope, (ApiResult) obj2);
                        }
                    });
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$2(BaseFirmwareViewModel baseFirmwareViewModel, CoroutineScope coroutineScope, ApiResult apiResult) {
                if (apiResult instanceof ApiResult.Success) {
                    baseFirmwareViewModel.setServerFirmware((ServerFirmware) ((ApiResult.Success) apiResult).getData());
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "try again download file checkDeviceServer  serverFirmware.link:" + baseFirmwareViewModel.getServerFirmware().getLink();
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
                    ServerCheckItem serverCheckItem = new ServerCheckItem(baseFirmwareViewModel.getDeviceMac(), baseFirmwareViewModel.getServerFirmware().getVersion(), baseFirmwareViewModel.getServerFirmware().getFile_size(), baseFirmwareViewModel.getServerFirmware().getSha_256(), baseFirmwareViewModel.getCurrentVersion(), baseFirmwareViewModel.getServerFirmware().getLink());
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true) && "try again download file checkDeviceServer".length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str4 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                        FileLog.print$default(fileLog2, 3, str4, tag2, "try again download file checkDeviceServer " + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, "try again download file checkDeviceServer " + strComponent4);
                        }
                    }
                    OTAHelper.invalidUrlTryAgain$default(OTAHelper.INSTANCE, serverCheckItem, false, 2, null);
                } else if (apiResult instanceof ApiResult.Error) {
                    if (((ApiResult.Error) apiResult).getCode() == 423) {
                        baseFirmwareViewModel.checkUpdateStatus(new ServerFirmware(0, null, null, null, null, null, 62, null));
                    } else {
                        baseFirmwareViewModel.getFirmwareStatus().postValue(8);
                    }
                } else if (!(apiResult instanceof ApiResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void getInvalidDownloadUrl() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06981(null), 2, null);
    }

    public static /* synthetic */ void startWorkManager$default(BaseFirmwareViewModel baseFirmwareViewModel, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startWorkManager");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        baseFirmwareViewModel.startWorkManager(z);
    }

    public final void startWorkManager(boolean isTryAgain) {
        NTLog.i("OTA_WORKER_TAG startWorkManager");
        OTAHelper.INSTANCE.startOTA(isTryAgain);
    }

    @Override // com.nothing.ota.callback.DownloadInterface
    public void downFail() {
        this.firmwareStatus.postValue(8);
    }

    @Override // com.nothing.ota.callback.DownloadInterface
    public void downUrlInvalid() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "try again download file downUrlInvalid".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "try again download file downUrlInvalid " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "try again download file downUrlInvalid " + strComponent2);
            }
        }
        getInvalidDownloadUrl();
    }

    @Override // com.nothing.ota.callback.TransferInterface
    public void transfer(int progress) {
        this.firmwareProgress.set(Integer.valueOf(progress));
        int i = ((int) (((double) progress) * 0.93d)) + 5;
        this.totalProgress.set(formatProgress(i));
        this.downloadProgress.set(i);
    }

    @Override // com.nothing.ota.callback.TransferInterface
    public void transferSuccess() {
        this.totalProgress.set(formatProgress(98));
        this.firmwareProgress.set(98);
        this.downloadProgress.set(98);
        this.firmwareStatus.postValue(13);
        updateTwsVersion();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07031(null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$transferSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$transferSuccess$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {717, 718}, m = "invokeSuspend", n = {}, s = {})
    static final class C07031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07031(Continuation<? super C07031> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFirmwareViewModel.this.new C07031(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.ota.BaseFirmwareViewModel.C07031.C01491(r6.this$0, null), r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(BaseFirmwareViewModel.this.getSuccessTime(), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$transferSuccess$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$transferSuccess$1$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ BaseFirmwareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01491(BaseFirmwareViewModel baseFirmwareViewModel, Continuation<? super C01491> continuation) {
                super(2, continuation);
                this.this$0 = baseFirmwareViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01491 c01491 = new C01491(this.this$0, continuation);
                c01491.L$0 = obj;
                return c01491;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Integer value = this.this$0.getFirmwareStatus().getValue();
                if (value == null || value.intValue() != 12) {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true) && "STATE_ TIME OUT RECONNECT".length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        FileLog.print$default(fileLog, 4, str, tag, "STATE_ TIME OUT RECONNECT " + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, "STATE_ TIME OUT RECONNECT " + strComponent2);
                        }
                    }
                    final BaseFirmwareViewModel baseFirmwareViewModel = this.this$0;
                    Utils.valueAnimatorStartByInt$default(Utils.INSTANCE, new int[]{1, 200}, 0L, null, new Function1() { // from class: com.nothing.earbase.ota.BaseFirmwareViewModel$transferSuccess$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BaseFirmwareViewModel.C07031.C01491.invokeSuspend$lambda$1(baseFirmwareViewModel, ((Integer) obj2).intValue());
                        }
                    }, 6, null);
                    this.this$0.getFirmwareStatus().postValue(Boxing.boxInt(12));
                } else {
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true) && "STATE_INSTALLING_SUCCESS now ".length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str2 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        FileLog.print$default(fileLog2, 4, str2, tag2, "STATE_INSTALLING_SUCCESS now  " + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, "STATE_INSTALLING_SUCCESS now  " + strComponent4);
                        }
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$1(BaseFirmwareViewModel baseFirmwareViewModel, int i) {
                baseFirmwareViewModel.getTotalProgress().set(baseFirmwareViewModel.formatProgress(100));
                baseFirmwareViewModel.getFirmwareProgress().set(100);
                baseFirmwareViewModel.getDownloadProgress().set(100);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$onConnected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$onConnected$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07001(Continuation<? super C07001> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFirmwareViewModel.this.new C07001(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BaseFirmwareViewModel.this.getTotalProgress().set(BaseFirmwareViewModel.this.formatProgress(100));
            BaseFirmwareViewModel.this.getFirmwareProgress().set(Boxing.boxInt(100));
            BaseFirmwareViewModel.this.getDownloadProgress().set(100);
            BaseFirmwareViewModel.this.getFirmwareStatus().postValue(Boxing.boxInt(12));
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected() {
        Integer value = this.firmwareStatus.getValue();
        if (value != null && value.intValue() == 13) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C07001(null), 2, null);
        }
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
        if (this.isStartUpdate) {
            return;
        }
        this.gotoLastActivity.postValue(true);
    }

    @Override // com.nothing.ota.callback.TransferInterface
    public void transferFail(int errorCode, String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Integer value = this.firmwareStatus.getValue();
        if (value != null && value.intValue() == 12) {
            return;
        }
        Integer value2 = this.firmwareStatus.getValue();
        if (value2 != null && value2.intValue() == 13) {
            return;
        }
        Integer value3 = this.firmwareStatus.getValue();
        if (value3 != null && value3.intValue() == 14) {
            return;
        }
        Integer num = this.firmwareProgress.get();
        if (num != null && num.intValue() == 100) {
            return;
        }
        this.firmwareStatus.postValue(14);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "STATE_INSTALLING_FAIL " + errorCode;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str3 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$onCheckBatteryAndStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$onCheckBatteryAndStatus$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {785, 787, 789}, m = "invokeSuspend", n = {}, s = {})
    static final class C06991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06991(Continuation<? super C06991> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFirmwareViewModel.this.new C06991(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        
            if (r7 == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
        
            if (r7 == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.ota.BaseFirmwareViewModel.C06991.C01461(r7, r6.this$0, null), r6) == r0) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(BaseFirmwareViewModel.this.getAddress());
                if (productByMacAddress == null || productByMacAddress.getType() != 6) {
                    this.label = 2;
                    obj = BaseFirmwareViewModel.this.checkBatteryAndStatus(this);
                } else {
                    this.label = 1;
                    obj = BaseFirmwareViewModel.this.checkBattery(this);
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) obj).booleanValue();
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) obj).booleanValue();
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            this.label = 3;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.ota.BaseFirmwareViewModel$onCheckBatteryAndStatus$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFirmwareViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.ota.BaseFirmwareViewModel$onCheckBatteryAndStatus$1$1", f = "BaseFirmwareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $canUpdate;
            int label;
            final /* synthetic */ BaseFirmwareViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01461(boolean z, BaseFirmwareViewModel baseFirmwareViewModel, Continuation<? super C01461> continuation) {
                super(2, continuation);
                this.$canUpdate = z;
                this.this$0 = baseFirmwareViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01461(this.$canUpdate, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.$canUpdate) {
                    this.this$0.getCheckBatteryStatus().postValue(Boxing.boxInt(1));
                } else if (this.this$0.getIsOtherOTA()) {
                    this.this$0.getRepeatOTA().postValue(Boxing.boxBoolean(true));
                } else {
                    this.this$0.getCheckBatteryStatus().postValue(Boxing.boxInt(2));
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void onCheckBatteryAndStatus() {
        this.isStartUpdate = true;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06991(null), 2, null);
    }

    public final void confirmUpdateOrInstall() {
        if (isInstalling()) {
            return;
        }
        NTLog.i("---------firmwareStatus.value:---------" + this.firmwareStatus.getValue());
        Integer value = this.firmwareStatus.getValue();
        if ((value != null && value.intValue() == 8) || ((value != null && value.intValue() == 7) || (value != null && value.intValue() == 6))) {
            this.firmwareStatus.postValue(7);
            return;
        }
        if ((value != null && value.intValue() == 11) || ((value != null && value.intValue() == 9) || ((value != null && value.intValue() == 14) || (value != null && value.intValue() == 10)))) {
            this.firmwareStatus.postValue(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object checkBattery(Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objSyncSetResponse$default;
        BaseFirmwareViewModel baseFirmwareViewModel;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Logger logger = Logger.INSTANCE;
            Logger logger2 = Logger.INSTANCE;
            Logger logger3 = logger;
            String tag = logger3.getTAG();
            int depth = logger3.getDepth();
            if (logger3.isCanLogger(true) && "white_list_android checkBattery".length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "white_list_android checkBattery " + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, "white_list_android checkBattery " + strComponent2);
                }
            }
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice != null) {
                anonymousClass2.L$0 = this;
                anonymousClass2.label = 1;
                objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDevice, 49159, null, null, false, false, null, anonymousClass2, 62, null);
                if (objSyncSetResponse$default != coroutine_suspended) {
                    baseFirmwareViewModel = this;
                }
            }
            return Boxing.boxBoolean(false);
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        BaseFirmwareViewModel baseFirmwareViewModel2 = (BaseFirmwareViewModel) anonymousClass2.L$0;
        ResultKt.throwOnFailure(obj);
        objSyncSetResponse$default = obj;
        baseFirmwareViewModel = baseFirmwareViewModel2;
        Message message = (Message) objSyncSetResponse$default;
        if (message != null) {
            DeviceBattery deviceBattery = (DeviceBattery) message.obtainPayload(DeviceBattery.class);
            if (deviceBattery == null) {
                return Boxing.boxBoolean(false);
            }
            Logger logger4 = Logger.INSTANCE;
            Logger logger5 = Logger.INSTANCE;
            Logger logger6 = logger4;
            String tag2 = logger6.getTAG();
            int depth2 = logger6.getDepth();
            if (logger6.isCanLogger(true)) {
                Battery stereo = deviceBattery.getStereo();
                String str2 = "white_list_android checkBattery battery:" + (stereo != null ? Boxing.boxInt(stereo.getBattery()) : null);
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace2 = logger6.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger6.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger6.isDebug()) {
                        Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            Battery stereo2 = deviceBattery.getStereo();
            if ((stereo2 != null ? stereo2.getBattery() : 0) < baseFirmwareViewModel.minOTABattery()) {
                return Boxing.boxBoolean(false);
            }
            anonymousClass2.L$0 = null;
            anonymousClass2.label = 2;
            Object objCheckStereoStatus = baseFirmwareViewModel.checkStereoStatus(anonymousClass2);
            return objCheckStereoStatus == coroutine_suspended ? coroutine_suspended : objCheckStereoStatus;
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x005f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object checkStereoStatus(Continuation<? super Boolean> continuation) {
        C06941 c06941;
        BaseFirmwareViewModel baseFirmwareViewModel;
        Message message;
        EarphoneStatus earphoneStatus;
        boolean zIsOTA;
        EarphoneStatus.Status stereo;
        if (continuation instanceof C06941) {
            c06941 = (C06941) continuation;
            if ((c06941.label & Integer.MIN_VALUE) != 0) {
                c06941.label -= Integer.MIN_VALUE;
            } else {
                c06941 = new C06941(continuation);
            }
        } else {
            c06941 = new C06941(continuation);
        }
        C06941 c06942 = c06941;
        Object objSyncSetResponse$default = c06942.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06942.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSyncSetResponse$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice != null) {
                c06942.L$0 = this;
                c06942.label = 1;
                objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDevice, 49162, null, null, false, false, null, c06942, 62, null);
                if (objSyncSetResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                baseFirmwareViewModel = this;
            } else {
                baseFirmwareViewModel = this;
                message = null;
            }
            earphoneStatus = message != null ? (EarphoneStatus) message.obtainPayload(EarphoneStatus.class) : null;
            if (earphoneStatus != null || (stereo = earphoneStatus.getStereo()) == null) {
                zIsOTA = false;
            } else {
                zIsOTA = stereo.isOTA();
            }
            baseFirmwareViewModel.isOtherOTA = zIsOTA;
            return Boxing.boxBoolean(!zIsOTA);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        baseFirmwareViewModel = (BaseFirmwareViewModel) c06942.L$0;
        ResultKt.throwOnFailure(objSyncSetResponse$default);
        message = (Message) objSyncSetResponse$default;
        if (message != null) {
        }
        if (earphoneStatus != null) {
            zIsOTA = false;
        } else {
            zIsOTA = false;
        }
        baseFirmwareViewModel.isOtherOTA = zIsOTA;
        return Boxing.boxBoolean(!zIsOTA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object checkBatteryAndStatus(Continuation<? super Boolean> continuation) {
        C06911 c06911;
        BaseFirmwareViewModel baseFirmwareViewModel;
        if (continuation instanceof C06911) {
            c06911 = (C06911) continuation;
            if ((c06911.label & Integer.MIN_VALUE) != 0) {
                c06911.label -= Integer.MIN_VALUE;
            } else {
                c06911 = new C06911(continuation);
            }
        } else {
            c06911 = new C06911(continuation);
        }
        C06911 c06912 = c06911;
        Object objSyncSetResponse$default = c06912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06912.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objSyncSetResponse$default);
            Logger logger = Logger.INSTANCE;
            Logger logger2 = Logger.INSTANCE;
            Logger logger3 = logger;
            String tag = logger3.getTAG();
            int depth = logger3.getDepth();
            if (logger3.isCanLogger(true) && "white_list_android checkBatteryAndStatus".length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "white_list_android checkBatteryAndStatus " + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, "white_list_android checkBatteryAndStatus " + strComponent2);
                }
            }
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice != null) {
                c06912.L$0 = this;
                c06912.label = 1;
                objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDevice, 49159, null, null, false, false, null, c06912, 62, null);
                if (objSyncSetResponse$default != coroutine_suspended) {
                    baseFirmwareViewModel = this;
                }
            }
            return Boxing.boxBoolean(false);
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSyncSetResponse$default);
            return objSyncSetResponse$default;
        }
        baseFirmwareViewModel = (BaseFirmwareViewModel) c06912.L$0;
        ResultKt.throwOnFailure(objSyncSetResponse$default);
        Message message = (Message) objSyncSetResponse$default;
        if (message != null) {
            DeviceBattery deviceBattery = (DeviceBattery) message.obtainPayload(DeviceBattery.class);
            if (deviceBattery == null) {
                return Boxing.boxBoolean(false);
            }
            Logger logger4 = Logger.INSTANCE;
            Logger logger5 = Logger.INSTANCE;
            Logger logger6 = logger4;
            String tag2 = logger6.getTAG();
            int depth2 = logger6.getDepth();
            if (logger6.isCanLogger(true)) {
                Battery right = deviceBattery.getRight();
                Integer numBoxInt = right != null ? Boxing.boxInt(right.getBattery()) : null;
                Battery left = deviceBattery.getLeft();
                String str2 = "white_list_android checkBatteryAndStatus right:" + numBoxInt + ",left:" + (left != null ? Boxing.boxInt(left.getBattery()) : null);
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    z = false;
                }
                if (!z) {
                    Pair<String, String> trace2 = logger6.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger6.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger6.isDebug()) {
                        Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            Battery left2 = deviceBattery.getLeft();
            if ((left2 != null ? left2.getBattery() : 0) >= 30) {
                Battery right2 = deviceBattery.getRight();
                if ((right2 != null ? right2.getBattery() : 0) >= 30) {
                    c06912.L$0 = null;
                    c06912.label = 2;
                    Object objDeviceStatus = baseFirmwareViewModel.deviceStatus(c06912);
                    return objDeviceStatus == coroutine_suspended ? coroutine_suspended : objDeviceStatus;
                }
            }
            return Boxing.boxBoolean(false);
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deviceStatus(Continuation<? super Boolean> continuation) {
        C06961 c06961;
        BaseFirmwareViewModel baseFirmwareViewModel;
        EarphoneStatus.Status right;
        if (continuation instanceof C06961) {
            c06961 = (C06961) continuation;
            if ((c06961.label & Integer.MIN_VALUE) != 0) {
                c06961.label -= Integer.MIN_VALUE;
            } else {
                c06961 = new C06961(continuation);
            }
        } else {
            c06961 = new C06961(continuation);
        }
        C06961 c06962 = c06961;
        Object objSyncSetResponse$default = c06962.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06962.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSyncSetResponse$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice != null) {
                c06962.L$0 = this;
                c06962.label = 1;
                objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDevice, 49162, null, null, false, false, null, c06962, 62, null);
                if (objSyncSetResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                baseFirmwareViewModel = this;
            }
            return Boxing.boxBoolean(false);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        baseFirmwareViewModel = (BaseFirmwareViewModel) c06962.L$0;
        ResultKt.throwOnFailure(objSyncSetResponse$default);
        Message message = (Message) objSyncSetResponse$default;
        if (message != null) {
            EarphoneStatus earphoneStatus = (EarphoneStatus) message.obtainPayload(EarphoneStatus.class);
            if (earphoneStatus == null) {
                return Boxing.boxBoolean(false);
            }
            EarphoneStatus.Status left = earphoneStatus.getLeft();
            if (left == null || !left.getInCase() || (right = earphoneStatus.getRight()) == null || !right.getInCase()) {
                return Boxing.boxBoolean(false);
            }
            EarphoneStatus.Status right2 = earphoneStatus.getRight();
            boolean zIsOTA = right2 != null ? right2.isOTA() : false;
            baseFirmwareViewModel.isOtherOTA = zIsOTA;
            return Boxing.boxBoolean(!zIsOTA);
        }
        return Boxing.boxBoolean(false);
    }

    public final void clickTestOTA(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.testOTAPath = path;
        this.currentFragment.postValue(1);
        this.firmwareStatus.postValue(15);
    }

    public final void firmwareTrayAgain() {
        if (this.testOTAPath.length() > 0) {
            clickTestOTA(this.testOTAPath);
        } else {
            startWorkManager(true);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        OTAHelper.INSTANCE.unregisterDownload(this);
        OTAHelper.INSTANCE.unregisterTransfer(this);
        OTAHelper.INSTANCE.cancelDownload();
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            tWSDevice.unregister(this);
        }
    }

    public final void releaseOTA() {
        OTAHelper.cancelOTA$default(OTAHelper.INSTANCE, false, 1, null);
        OTAHelper.INSTANCE.release();
    }
}
