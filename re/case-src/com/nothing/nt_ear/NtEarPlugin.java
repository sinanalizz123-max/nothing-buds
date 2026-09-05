package com.nothing.nt_ear;

import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.nothing.audiodo.AudiodoApi;
import com.nothing.audiodo.view.AspenInit;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.router.device.DeviceColor;
import com.nothing.base.router.device.widget.WidgetRouter;
import com.nothing.base.router.gloable.GlobalRouter;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.BtWidgetRefreshGate;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.PhoneUtil;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.view.BaseApplication;
import com.nothing.base.view.NTCrashHandler;
import com.nothing.caseble.NtCaseBleApi;
import com.nothing.caseble.NtPeerLinkBleApi;
import com.nothing.common.Utils;
import com.nothing.database.dao.DeviceItemDao;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.manager.MagicDatabase;
import com.nothing.database.manager.NewsConfigDatabase;
import com.nothing.database.manager.ProductDatabase;
import com.nothing.database.manager.ScoreDatabase;
import com.nothing.database.manager.SmartDatabase;
import com.nothing.database.manager.SmartVoiceDatabase;
import com.nothing.database.manager.UserDatabase;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceAction;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.two.core.protocol.EarTwoSppProtocol;
import com.nothing.ear.two.mimi.MimiData;
import com.nothing.ear.two.mimi.MimiManager;
import com.nothing.ear.two.mimi.MimiSdkActivity;
import com.nothing.earbase.control.GptProviderHelper;
import com.nothing.earbase.control.VoiceAssistantUtil;
import com.nothing.earbase.essential.skywalk.SkyWalkUtil;
import com.nothing.earbase.os.cache.MacCacheDataBase;
import com.nothing.earbase.ota.entity.ServerFirmware;
import com.nothing.earbase.unknown.NewSkuDevice;
import com.nothing.earbase.unknown.device.UnknownDevice;
import com.nothing.earbase.unknown.device.UnknownProduct;
import com.nothing.earbase.unknown.entity.UnknownProjectInfo;
import com.nothing.earbase.widget.news.NewsMedia3Manager;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.BigDataControl;
import com.nothing.event.log.database.EventDatabase;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.event.log.service.OnProgressListener;
import com.nothing.generate.AudiodoFlutterApi;
import com.nothing.generate.AudiodoHostApi;
import com.nothing.generate.BatteryInfo;
import com.nothing.generate.MimiType;
import com.nothing.generate.NOSHeaderInfo;
import com.nothing.generate.NOSProfileInfo;
import com.nothing.generate.NewsFlutterApi;
import com.nothing.generate.NewsHostApi;
import com.nothing.generate.NoiseLevelFlutterApi;
import com.nothing.generate.NoiseLevelHostApi;
import com.nothing.generate.NtAppCommonNativeApi;
import com.nothing.generate.NtCaseBleFlutterApi;
import com.nothing.generate.NtCaseBleHostApi;
import com.nothing.generate.NtDeviceInfo;
import com.nothing.generate.NtDeviceParams;
import com.nothing.generate.NtEarDeviceData;
import com.nothing.generate.NtEarFlutterApi;
import com.nothing.generate.NtEarMimiData;
import com.nothing.generate.NtEarNativeApi;
import com.nothing.generate.NtEvent;
import com.nothing.generate.NtMediaSessionNativeApi;
import com.nothing.generate.NtPeerLinkFlutterApi;
import com.nothing.generate.NtPeerLinkHostApi;
import com.nothing.generate.NtSuperMicWalkTalkApi;
import com.nothing.generate.NtSuperMicWalkTalkFlutterApi;
import com.nothing.generate.RemoteRateInfo;
import com.nothing.generate.SpotifyHostApi;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.device.BoundListener;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.link.bluetooth.sdk.util.NTPluginCallHandler;
import com.nothing.link.bluetooth.sdk.util.NTPluginManager;
import com.nothing.log.FileLog;
import com.nothing.magicbutton.MagicButtonApiManager;
import com.nothing.network.core.ApiResult;
import com.nothing.network.core.NetWorkConstant;
import com.nothing.news.NewsApi;
import com.nothing.noiselevel.NoiseLevelApi;
import com.nothing.nt_ear.audio.CallPlaybackAudioController;
import com.nothing.nt_route.FlutterRouterManager;
import com.nothing.nt_route.NtBleOTAStatusChange;
import com.nothing.nt_route.NtEarOTAInterface;
import com.nothing.nt_route.NtEarOTARouterManager;
import com.nothing.nt_system_runtime.utils.PreviewListener;
import com.nothing.nt_system_runtime.utils.PreviewUtils;
import com.nothing.nt_widget.NtWidgetPlugin;
import com.nothing.os.INOSSettingDetail;
import com.nothing.os.INOSSettingSpatial;
import com.nothing.os.ListNOSProfileInfo;
import com.nothing.os.device.bluetooth.adapter.HeaderInfoEntity;
import com.nothing.os.device.xservice.XViewServiceImpl;
import com.nothing.ota.OTAHelper;
import com.nothing.ota.OTANetHelper;
import com.nothing.ota.callback.TransferInterface;
import com.nothing.ota.device.OTADevice;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.ProtocolModel;
import com.nothing.smart.widgets.config.EarNewWidgetTWSDeviceManager;
import com.nothing.smart.widgets.nothing.NothingWidgetTWSDeviceManager;
import com.nothing.supermic.NtSupperMicApi;
import com.nothing.walktalk.WalkieTalkieHelper;
import com.nothing.xhost.cardparser.ext.AnyExtKt;
import com.nothing.xhost.cardparser.ext.JSONObjectExtKt;
import com.nothing.xservice.ProfileItemInfo;
import com.nothing.xservice.XSettingsConstants;
import defpackage.NativeRoute;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import org.apache.tika.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: NtEarPlugin.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0004oru~\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010k\u001a\u00020h2\u0006\u0010l\u001a\u00020mH\u0016J*\u0010w\u001a\u00020h2\u0006\u0010x\u001a\u00020y2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020h2\u0007\u0010\u0081\u0001\u001a\u00020mH\u0016J,\u0010\u0082\u0001\u001a\u00020h2\u0007\u0010\u0083\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u0084\u0001\u001a\u00020h2\u0007\u0010\u0085\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020h2\u0007\u0010\u0081\u0001\u001a\u00020-H\u0016J\u001c\u0010\u0087\u0001\u001a\u00020h2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u0081\u0001\u001a\u00020-H\u0002J=\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020j2\u0007\u0010\u008d\u0001\u001a\u00020j2\u0007\u0010\u008e\u0001\u001a\u00020j2\u0007\u0010\u008f\u0001\u001a\u00020j2\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010jH\u0002J\u0013\u0010\u0091\u0001\u001a\u00020h2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\u0010\u0010\u0094\u0001\u001a\u00020hH\u0082@\u00a2\u0006\u0003\u0010\u0095\u0001J\t\u0010\u0096\u0001\u001a\u00020hH\u0016J\u0012\u0010\u0097\u0001\u001a\u00020h2\u0007\u0010\u0081\u0001\u001a\u00020-H\u0016J\t\u0010\u0098\u0001\u001a\u00020hH\u0016J:\u0010\u0099\u0001\u001a\u00020h2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010j2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010j2\u0019\u0010z\u001a\u0015\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009c\u00010|\u0012\u0004\u0012\u00020h0{H\u0016J7\u0010\u009d\u0001\u001a\u00020h2\u0007\u0010\u009e\u0001\u001a\u00020y2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u009f\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u00a0\u0001\u001a\u00020h2\u0007\u0010\u008e\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00a1\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00a2\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00a3\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u00a4\u0001\u001a\u00020h2\u0007\u0010\u008e\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00a5\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00a6\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J=\u0010\u00a7\u0001\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0007\u0010\u00a8\u0001\u001a\u00020y2\u0007\u0010\u00a9\u0001\u001a\u00020y2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J+\u0010\u00aa\u0001\u001a\u00020h2 \u0010z\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00ac\u00010\u00ab\u00010|\u0012\u0004\u0012\u00020h0{H\u0016J-\u0010\u00ad\u0001\u001a\u00020h2\b\u0010\u00ae\u0001\u001a\u00030\u00af\u00012\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u00b0\u0001\u001a\u00020h2\u0007\u0010\u00b1\u0001\u001a\u00020y2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016JA\u0010\u00b2\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u0007\u0010\u009b\u0001\u001a\u00020j2\n\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b4\u00012\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016JA\u0010\u00b5\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u0007\u0010\u009b\u0001\u001a\u00020j2\n\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00b4\u00012\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00b6\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0|\u0012\u0004\u0012\u00020h0{H\u0016J)\u0010\u00b7\u0001\u001a\u00020y2\b\u0010\u00b8\u0001\u001a\u00030\u00b9\u00012\b\u0010\u00ba\u0001\u001a\u00030\u00b9\u00012\n\u0010\u00bb\u0001\u001a\u0005\u0018\u00010\u00bc\u0001H\u0016J5\u0010\u00c0\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u0007\u0010\u00c1\u0001\u001a\u00020y2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J>\u0010\u00c2\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u0007\u0010\u00c3\u0001\u001a\u0002032\u0007\u0010\u00c4\u0001\u001a\u0002032\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0|\u0012\u0004\u0012\u00020h0{H\u0016J/\u0010\u00c5\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u001b\u0010z\u001a\u0017\u0012\r\u0012\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u00c6\u00010|\u0012\u0004\u0012\u00020h0{H\u0016J.\u0010\u00c7\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u001a\u0010z\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010j0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u00c8\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u00c9\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u00ca\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J6\u0010\u00cb\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\"\u0010z\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030\u00cc\u0001\u0018\u00010\u00ab\u00010|\u0012\u0004\u0012\u00020h0{H\u0016J6\u0010\u00cd\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\"\u0010z\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030\u00cc\u0001\u0018\u00010\u00ab\u00010|\u0012\u0004\u0012\u00020h0{H\u0016J8\u0010\u00ce\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\n\u0010\u00cf\u0001\u001a\u0005\u0018\u00010\u00cc\u00012\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J6\u0010\u00d0\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\"\u0010z\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030\u00cc\u0001\u0018\u00010\u00ab\u00010|\u0012\u0004\u0012\u00020h0{H\u0016J8\u0010\u00d1\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\n\u0010\u00cf\u0001\u001a\u0005\u0018\u00010\u00cc\u00012\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J8\u0010\u00d2\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\n\u0010\u00cf\u0001\u001a\u0005\u0018\u00010\u00cc\u00012\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J7\u0010\u00d3\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\t\u0010\u00d4\u0001\u001a\u0004\u0018\u00010j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00d5\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00d6\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u00d7\u0001\u001a\u00020h2\u0007\u0010\u00d8\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u00d9\u0001\u001a\u00020h2\u0007\u0010\u00d8\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0|\u0012\u0004\u0012\u00020h0{H\u0016J\u0012\u0010\u00da\u0001\u001a\u00020y2\u0007\u0010\u009b\u0001\u001a\u00020jH\u0002J\u0012\u0010\u00db\u0001\u001a\u00020y2\u0007\u0010\u009b\u0001\u001a\u00020jH\u0002J-\u0010\u00dc\u0001\u001a\u00020h2\b\u0010\u00dd\u0001\u001a\u00030\u00de\u00012\b\u0010\u00df\u0001\u001a\u00030\u00e0\u00012\u0007\u0010\u00e1\u0001\u001a\u00020jH\u0082@\u00a2\u0006\u0003\u0010\u00e2\u0001J-\u0010\u00e3\u0001\u001a\u00020h2\b\u0010\u00dd\u0001\u001a\u00030\u00de\u00012\b\u0010\u00df\u0001\u001a\u00030\u00e0\u00012\u0007\u0010\u00e1\u0001\u001a\u00020jH\u0082@\u00a2\u0006\u0003\u0010\u00e2\u0001J#\u0010\u00e4\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0|\u0012\u0004\u0012\u00020h0{H\u0016J\u0011\u0010\u00e5\u0001\u001a\u00020h2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J+\u0010\u00e6\u0001\u001a\u00020h2\"\u0010z\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020j\u0012\u0005\u0012\u00030\u00ac\u0001\u0018\u00010\u00e7\u0001\u0012\u0004\u0012\u00020h0{J\u001d\u0010\u00e8\u0001\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010j2\n\u0010\u00e9\u0001\u001a\u0005\u0018\u00010\u00ea\u0001J\u001b\u0010\u00eb\u0001\u001a\u00020h2\u0012\u0010z\u001a\u000e\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020h0{J\u001a\u0010\u00ec\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020j2\b\u0010\u00c3\u0001\u001a\u00030\u00b9\u0001J'\u0010\u00ed\u0001\u001a\u0016\u0012\u000f\u0012\r \u00f0\u0001*\u0005\u0018\u00010\u00ef\u00010\u00ef\u0001\u0018\u00010\u00ee\u00012\n\u0010\u00f1\u0001\u001a\u0005\u0018\u00010\u00ea\u0001J\u001b\u0010\u00f2\u0001\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\n\u0010\u00f3\u0001\u001a\u0005\u0018\u00010\u00ea\u0001J?\u0010\u00f4\u0001\u001a\u00020h2\u0007\u0010\u008e\u0001\u001a\u00020j2\u0007\u0010\u009b\u0001\u001a\u00020j2\u0007\u0010\u00f5\u0001\u001a\u00020j2\u001b\u0010\u00bd\u0001\u001a\u0016\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00bf\u00010\u00be\u0001\u0012\u0004\u0012\u00020h0{J\u000f\u0010\u00f6\u0001\u001a\u00020h2\u0006\u0010i\u001a\u00020jJ-\u0010\u00f7\u0001\u001a\u00020h2\b\u0010\u00cf\u0001\u001a\u00030\u00f8\u00012\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J&\u0010\u00f9\u0001\u001a\u00020h2\u001b\u0010z\u001a\u0017\u0012\r\u0012\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u00fa\u00010|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00fb\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J5\u0010\u00fc\u0001\u001a\u00020h2\u0007\u0010\u00fd\u0001\u001a\u0002032\u0007\u0010\u00fe\u0001\u001a\u00020y2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u00ff\u0001\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u0080\u0002\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0|\u0012\u0004\u0012\u00020h0{H\u0016J.\u0010\u0081\u0002\u001a\u00020h2\u0007\u0010\u0082\u0002\u001a\u00020j2\u001a\u0010z\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010j0|\u0012\u0004\u0012\u00020h0{H\u0016J,\u0010\u0083\u0002\u001a\u00020h2\u0007\u0010\u008e\u0001\u001a\u00020j2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0|\u0012\u0004\u0012\u00020h0{H\u0016J#\u0010\u0084\u0002\u001a\u00020h2\u0018\u0010z\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0|\u0012\u0004\u0012\u00020h0{H\u0016J\u0019\u0010\u0085\u0002\u001a\u00020h2\u0007\u0010\u00fe\u0001\u001a\u00020y2\u0007\u0010\u008d\u0001\u001a\u00020jJ\u0018\u0010\u0086\u0002\u001a\u00020h2\u000f\u0010\u0087\u0002\u001a\n\u0012\u0005\u0012\u00030\u0088\u00020\u00ab\u0001J\u0011\u0010\u0089\u0002\u001a\u00020h2\u0006\u0010x\u001a\u00020yH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u00104\u001a\u000205\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u00020oX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010pR\u0010\u0010q\u001a\u00020rX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010sR\u0010\u0010t\u001a\u00020uX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010vR\u0010\u0010}\u001a\u00020~X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u007fR\u0010\u0010\u0092\u0001\u001a\u00030\u0093\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u00bd\u0001\u001a\u0016\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00bf\u00010\u00be\u0001\u0012\u0004\u0012\u00020h0{X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u008a\u0002"}, d2 = {"Lcom/nothing/nt_ear/NtEarPlugin;", "Lcom/nothing/generate/NtEarNativeApi;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "Lcom/nothing/nt_system_runtime/utils/PreviewListener;", "<init>", "()V", "protocol", "Lcom/nothing/ear/two/core/protocol/EarTwoSppProtocol;", "getProtocol", "()Lcom/nothing/ear/two/core/protocol/EarTwoSppProtocol;", "setProtocol", "(Lcom/nothing/ear/two/core/protocol/EarTwoSppProtocol;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "magicButtonApi", "Lcom/nothing/magicbutton/MagicButtonApiManager;", "getMagicButtonApi", "()Lcom/nothing/magicbutton/MagicButtonApiManager;", "setMagicButtonApi", "(Lcom/nothing/magicbutton/MagicButtonApiManager;)V", "flutterApi", "Lcom/nothing/generate/NtEarFlutterApi;", "getFlutterApi", "()Lcom/nothing/generate/NtEarFlutterApi;", "setFlutterApi", "(Lcom/nothing/generate/NtEarFlutterApi;)V", "deviceDetail", "Lcom/nothing/os/INOSSettingDetail;", "getDeviceDetail", "()Lcom/nothing/os/INOSSettingDetail;", "setDeviceDetail", "(Lcom/nothing/os/INOSSettingDetail;)V", "mainSpatial", "Lcom/nothing/os/INOSSettingSpatial;", "getMainSpatial", "()Lcom/nothing/os/INOSSettingSpatial;", "setMainSpatial", "(Lcom/nothing/os/INOSSettingSpatial;)V", "activityBinding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "getActivityBinding", "()Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "setActivityBinding", "(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V", "INSTALL_MIN_TIME", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "boundListener", "Lcom/nothing/link/bluetooth/sdk/device/BoundListener;", "getBoundListener", "()Lcom/nothing/link/bluetooth/sdk/device/BoundListener;", "setBoundListener", "(Lcom/nothing/link/bluetooth/sdk/device/BoundListener;)V", "audiodoApi", "Lcom/nothing/generate/AudiodoHostApi;", "getAudiodoApi", "()Lcom/nothing/generate/AudiodoHostApi;", "setAudiodoApi", "(Lcom/nothing/generate/AudiodoHostApi;)V", "newsApi", "Lcom/nothing/generate/NewsHostApi;", "getNewsApi", "()Lcom/nothing/generate/NewsHostApi;", "setNewsApi", "(Lcom/nothing/generate/NewsHostApi;)V", "superMicApi", "Lcom/nothing/supermic/NtSupperMicApi;", "getSuperMicApi", "()Lcom/nothing/supermic/NtSupperMicApi;", "setSuperMicApi", "(Lcom/nothing/supermic/NtSupperMicApi;)V", "noiseLevelApi", "Lcom/nothing/generate/NoiseLevelHostApi;", "getNoiseLevelApi", "()Lcom/nothing/generate/NoiseLevelHostApi;", "setNoiseLevelApi", "(Lcom/nothing/generate/NoiseLevelHostApi;)V", "ntCaseBleApi", "Lcom/nothing/caseble/NtCaseBleApi;", "getNtCaseBleApi", "()Lcom/nothing/caseble/NtCaseBleApi;", "setNtCaseBleApi", "(Lcom/nothing/caseble/NtCaseBleApi;)V", "ntPeerLinkBleApi", "Lcom/nothing/caseble/NtPeerLinkBleApi;", "getNtPeerLinkBleApi", "()Lcom/nothing/caseble/NtPeerLinkBleApi;", "setNtPeerLinkBleApi", "(Lcom/nothing/caseble/NtPeerLinkBleApi;)V", "audioSessionChannel", "Lio/flutter/plugin/common/MethodChannel;", "callPlaybackAudioController", "Lcom/nothing/nt_ear/audio/CallPlaybackAudioController;", "simCountryChannel", "reboundDevice", "", "address", "", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "callHandler", "com/nothing/nt_ear/NtEarPlugin$callHandler$1", "Lcom/nothing/nt_ear/NtEarPlugin$callHandler$1;", "otaStatusChange", "com/nothing/nt_ear/NtEarPlugin$otaStatusChange$1", "Lcom/nothing/nt_ear/NtEarPlugin$otaStatusChange$1;", "earOTACallback", "com/nothing/nt_ear/NtEarPlugin$earOTACallback$1", "Lcom/nothing/nt_ear/NtEarPlugin$earOTACallback$1;", "setPreviewMode", "preview", "", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "transferCallback", "com/nothing/nt_ear/NtEarPlugin$transferCallback$1", "Lcom/nothing/nt_ear/NtEarPlugin$transferCallback$1;", "onDetachedFromEngine", "binding", Utils.METHOD_LOGOUT, "email", "login", "userInfo", "onAttachedToActivity", "addRouterInterceptor", "activity", "Landroid/app/Activity;", "createUnknownDevice", "Lcom/nothing/device/IOTDevice;", "fastPairID", "productId", "mac", "colorId", "name", "onAttachSettingsInterface", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "syncAddress", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDetachedFromActivityForConfigChanges", "onReattachedToActivityForConfigChanges", "onDetachedFromActivity", "getMimiData", "realMac", "modelId", "Lcom/nothing/generate/NtEarMimiData;", "setMiniEnable", "enable", "getDeviceUniqueId", "isSupportGPT", "isVoiceAssistantInstalled", "isVoiceAssistantSupported", "isShowVoiceAssistantTips", "isSGPTSelected", "hasNewsWidget", "isSupportNews", "updateGptSelected", GptProviderHelper.CHATGPT, GptProviderHelper.SHOWTIPS, "getEarDeviceData", "", "Lcom/nothing/generate/NtEarDeviceData;", "writeEventTrack", NotificationCompat.CATEGORY_EVENT, "Lcom/nothing/generate/NtEvent;", "uploadEventTrack", "forceUpload", "updateEarInfo", "device", "Lcom/nothing/generate/NtDeviceParams;", "fetchEarLog", "nothingNewsPlay", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "action", "Lcom/nothing/network/core/ApiResult;", "Lcom/nothing/earbase/ota/entity/ServerFirmware;", "getPhoneSpatialAudio", "needGet", "setPhoneSpatialAudio", NotificationCompat.CATEGORY_STATUS, "lastStatus", "getHeaderInfo", "Lcom/nothing/generate/NOSHeaderInfo;", "getFastPairedIdByMac", "forgetByOS", "disconnectByOS", "connectByOS", "getProfilesInfo", "Lcom/nothing/generate/NOSProfileInfo;", "getAudioDeviceType", "setAudioDeviceType", "info", "getSpatialInfo", "setProfileInfo", "setSpatialInfo", "setBluetoothAlias", MimeTypesReaderMetKeys.ALIAS_TAG, "isSupportEssentialSpace", "isSupportEssentialVoice", "updateWhiteListConfigs", "configs", "updateDeviceInfoList", "isNativelyConfiguredModel", "isNativeProductForModel", "handleNewDevice", "productDevice", "Lcom/nothing/device/IOTProductDevice;", "item", "Lcom/nothing/earbase/unknown/entity/UnknownProjectInfo;", "fastPairId", "(Lcom/nothing/device/IOTProductDevice;Lcom/nothing/earbase/unknown/entity/UnknownProjectInfo;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExistingDevice", "startRecorderService", "connectSkyWalk", "importDevice", "", "updateSettingSpatial", "audioInfo", "Landroid/os/Bundle;", "hasDevices", "updatePhoneSpatial", "profileItemInfos", "Ljava/util/ArrayList;", "Lcom/nothing/xservice/ProfileItemInfo;", "kotlin.jvm.PlatformType", "bundle", "parserProfileList", "profilesInfo", "checkOTA", "version", "getWatchBattery", "notifyWatchBattery", "Lcom/nothing/generate/BatteryInfo;", "getDeviceInfo", "Lcom/nothing/generate/NtDeviceInfo;", "isExtraDarkMode", "updateCaseOTAProgress", "progress", "isSuccess", "checkUpdateTime", "showRemoteRateDialog", "getRemoteConfigValue", "key", "forgetDevice", "withdrawConsent", "addScore", "updateRemoteRateInfo", "remoteRateInfo", "Lcom/nothing/generate/RemoteRateInfo;", "onChange", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NtEarPlugin implements NtEarNativeApi, FlutterPlugin, ActivityAware, PluginRegistry.ActivityResultListener, PreviewListener {
    private Function1<? super ApiResult<ServerFirmware>, Unit> action;
    private ActivityPluginBinding activityBinding;
    private MethodChannel audioSessionChannel;
    private AudiodoHostApi audiodoApi;
    private CallPlaybackAudioController callPlaybackAudioController;
    private Context context;
    private INOSSettingDetail deviceDetail;
    private NtEarFlutterApi flutterApi;
    private INOSSettingSpatial mainSpatial;
    private NewsHostApi newsApi;
    private NoiseLevelHostApi noiseLevelApi;
    private NtCaseBleApi ntCaseBleApi;
    private NtPeerLinkBleApi ntPeerLinkBleApi;
    private MethodChannel simCountryChannel;
    private NtSupperMicApi superMicApi;
    private EarTwoSppProtocol protocol = new EarTwoSppProtocol(null, 1, 0 == true ? 1 : 0);
    private MagicButtonApiManager magicButtonApi = new MagicButtonApiManager();
    private final long INSTALL_MIN_TIME = 86400000;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private BoundListener boundListener = new BoundListener() { // from class: com.nothing.nt_ear.NtEarPlugin$boundListener$1
        @Override // com.nothing.link.bluetooth.sdk.device.BoundListener
        public void removeBind(String address, boolean success) {
            Intrinsics.checkNotNullParameter(address, "address");
            if (!success) {
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new NtEarPlugin$boundListener$1$removeBind$2(this.this$0, address, null), 3, null);
                return;
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "NtEarPlugin removeBind " + address + StringUtils.SPACE + success;
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
            this.this$0.reboundDevice(address);
        }
    };
    private NtEarPlugin$callHandler$1 callHandler = new NTPluginCallHandler() { // from class: com.nothing.nt_ear.NtEarPlugin$callHandler$1
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.nothing.link.bluetooth.sdk.util.NTPluginCallHandler
        public void onMethodCall(String method, Bundle arguments) {
            String string;
            Application application;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            String string10;
            Intrinsics.checkNotNullParameter(method, "method");
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "NtEarPlugin  onMethodCall method:" + method + ",arguments:" + arguments;
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
            String str4 = "";
            switch (method.hashCode()) {
                case -1766984670:
                    if (method.equals("invokeStopOta")) {
                        if (arguments != null && (string = arguments.getString("address")) != null) {
                            str4 = string;
                        }
                        NtEarOTARouterManager.INSTANCE.get().stopOTA(str4);
                        break;
                    }
                    break;
                case -636072020:
                    if (method.equals("freshEarWidget") && (application = AppGlobals.INSTANCE.get()) != null) {
                        BtWidgetRefreshGate.requestFreshWidget(application, "NtEarPlugin.callHandler");
                    }
                    break;
                case 219178935:
                    if (method.equals("invokeConnectCallback")) {
                        if (arguments == null || (string2 = arguments.getString("address")) == null) {
                            string2 = "";
                        }
                        if (arguments != null && (string3 = arguments.getString("fastPairID")) != null) {
                            str4 = string3;
                        }
                        Function2<String, String, Unit> connectCallback = FlutterRouterManager.INSTANCE.get().getConnectCallback();
                        if (connectCallback != null) {
                            connectCallback.invoke(string2, str4);
                        }
                        break;
                    }
                    break;
                case 267816044:
                    if (method.equals("unBindDevice")) {
                        if (arguments != null && (string4 = arguments.getString("address")) != null) {
                            str4 = string4;
                        }
                        NtEarOTARouterManager.INSTANCE.get().unBindDevice(str4);
                        break;
                    }
                    break;
                case 660155378:
                    if (method.equals("invokeStartOTA")) {
                        NtEarOTARouterManager.INSTANCE.get().startOTA((arguments == null || (string10 = arguments.getString("address")) == null) ? "" : string10, (arguments == null || (string9 = arguments.getString("fastPairID")) == null) ? "" : string9, (arguments == null || (string8 = arguments.getString("filePath")) == null) ? "" : string8, (arguments == null || (string7 = arguments.getString("firmwareVersion")) == null) ? "" : string7, (arguments == null || (string6 = arguments.getString("modelId")) == null) ? "" : string6, (arguments == null || (string5 = arguments.getString("colorId")) == null) ? "" : string5);
                        break;
                    }
                    break;
            }
        }
    };
    private NtEarPlugin$otaStatusChange$1 otaStatusChange = new NtBleOTAStatusChange() { // from class: com.nothing.nt_ear.NtEarPlugin$otaStatusChange$1
        @Override // com.nothing.nt_route.NtBleOTAStatusChange
        public void otaStatusChange(String address, int progress, int status) {
            Intrinsics.checkNotNullParameter(address, "address");
            NTPluginManager nTPluginManager = NTPluginManager.INSTANCE.get();
            Bundle bundle = new Bundle();
            bundle.putString("address", address);
            bundle.putInt("progress", progress);
            bundle.putInt(NotificationCompat.CATEGORY_STATUS, status);
            Unit unit = Unit.INSTANCE;
            nTPluginManager.onCallHandler("otaStatusChange", bundle);
        }
    };
    private NtEarPlugin$earOTACallback$1 earOTACallback = new NtEarOTAInterface() { // from class: com.nothing.nt_ear.NtEarPlugin$earOTACallback$1
        /* JADX WARN: Code duplicated, block: B:4:0x0043  */
        @Override // com.nothing.nt_route.NtEarOTAInterface
        public void startOTA(String address, String fastPairId, String filePath, String firmwareVersion, String productId, String colorId) {
            String str;
            String str2;
            boolean z;
            int i;
            String firmwareVersion2 = firmwareVersion;
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(fastPairId, "fastPairId");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(firmwareVersion2, "firmwareVersion");
            Intrinsics.checkNotNullParameter(productId, "productId");
            Intrinsics.checkNotNullParameter(colorId, "colorId");
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str3 = "ota test earOTACallback startOTA,mac:" + address + ",fastPairId:" + fastPairId + ",path:" + filePath;
                String str4 = str3;
                if (str4 == null || str4.length() == 0) {
                    str2 = "format(...)";
                    str = StringUtils.SPACE;
                } else {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str5 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    String str6 = str3 + StringUtils.SPACE + strComponent2;
                    str = StringUtils.SPACE;
                    str2 = "format(...)";
                    FileLog.print$default(fileLog, 3, str5, tag, str6, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str3 + str + strComponent2);
                    }
                }
            } else {
                str2 = "format(...)";
                str = StringUtils.SPACE;
            }
            SpUtils.INSTANCE.setSelectDeviceMac(address);
            SpUtils.INSTANCE.setCurrentModel(fastPairId);
            String str7 = str;
            String str8 = str2;
            NtEarPlugin.createUnknownDevice$default(this.this$0, fastPairId, productId, address, colorId, null, 16, null);
            IOTDeviceManager.INSTANCE.getAndCreateIOTDevice(address, fastPairId);
            List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(address);
            DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
            if (deviceItem2 == null) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str9 = "getFirmwareVersion deviceItem is null  " + firmwareVersion2;
                    String str10 = str9;
                    if (str10 != null && str10.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str11 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str11, str8);
                        FileLog.print$default(fileLog2, 3, str11, tag2, str9 + str7 + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str9 + str7 + strComponent4);
                        }
                    }
                }
                z = false;
                i = 1;
                firmwareVersion2 = firmwareVersion;
                DatabaseUtils.INSTANCE.getDeviceDao().insertDeviceItem(new DeviceItem("", address, false, firmwareVersion, fastPairId, null, false, false, false, null, false, 0L, 4068, null));
            } else {
                z = false;
                i = 1;
                if (firmwareVersion2.length() > 0) {
                    deviceItem2.setDeviceVersion(firmwareVersion2);
                    DatabaseUtils.INSTANCE.getDeviceDao().updateDeviceItem(deviceItem2);
                }
            }
            OTAHelper.INSTANCE.registerTransfer(this.this$0.transferCallback);
            OTAHelper.INSTANCE.initFirmwarmItem(address, filePath, firmwareVersion2);
            OTAHelper.startOTA$default(OTAHelper.INSTANCE, z, i, null);
        }

        @Override // com.nothing.nt_route.NtEarOTAInterface
        public void stopOTA(String address) {
            Intrinsics.checkNotNullParameter(address, "address");
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "ota test earOTACallback stopOTA".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "ota test earOTACallback stopOTA " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "ota test earOTACallback stopOTA " + strComponent2);
                }
            }
            OTAHelper.cancelOTA$default(OTAHelper.INSTANCE, false, 1, null);
            OTAHelper.INSTANCE.release();
            OTAHelper.INSTANCE.unregisterTransfer(this.this$0.transferCallback);
        }

        @Override // com.nothing.nt_route.NtEarOTAInterface
        public void unBindDevice(String address) {
            Intrinsics.checkNotNullParameter(address, "address");
            if (NothingOSUtil.INSTANCE.isNothingOS()) {
                NothingWidgetTWSDeviceManager.INSTANCE.deleteWidget(this.this$0.getContext(), address);
            } else {
                EarNewWidgetTWSDeviceManager.INSTANCE.deleteWidgetDevice(this.this$0.getContext(), address);
            }
        }

        @Override // com.nothing.nt_route.NtEarOTAInterface
        public void freshEarWidget() {
            Context context = this.this$0.getContext();
            if (context != null) {
                BtWidgetRefreshGate.requestFreshWidget(context, "NtEarPlugin.freshEarWidget");
            }
        }
    };
    private NtEarPlugin$transferCallback$1 transferCallback = new TransferInterface() { // from class: com.nothing.nt_ear.NtEarPlugin$transferCallback$1
        @Override // com.nothing.ota.callback.TransferInterface
        public void transfer(int progress) {
            NtEarOTARouterManager.INSTANCE.get().updateProgress(SpUtils.INSTANCE.getSelectDeviceMac(), progress, 2);
        }

        @Override // com.nothing.ota.callback.TransferInterface
        public void transferSuccess() {
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "NtEarOTARouterManager transferSuccess".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "NtEarOTARouterManager transferSuccess " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "NtEarOTARouterManager transferSuccess " + strComponent2);
                }
            }
            NtEarOTARouterManager.INSTANCE.get().updateProgress(SpUtils.INSTANCE.getSelectDeviceMac(), 100, 3);
        }

        @Override // com.nothing.ota.callback.TransferInterface
        public void transferFail(int errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            NtEarOTARouterManager ntEarOTARouterManager = NtEarOTARouterManager.INSTANCE.get();
            String selectDeviceMac = SpUtils.INSTANCE.getSelectDeviceMac();
            OTADevice oTADevice = OTAHelper.INSTANCE.getOTADevice();
            ntEarOTARouterManager.updateProgress(selectDeviceMac, oTADevice != null ? oTADevice.getCurrentProcess() : 0, 4);
        }
    };
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SetRingtoneResult.values().length];
            try {
                iArr[SetRingtoneResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SetRingtoneResult.NEED_WRITE_SETTINGS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SetRingtoneResult.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NativeRoute.values().length];
            try {
                iArr2[NativeRoute.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[NativeRoute.OTA.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[NativeRoute.EQUALIZER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[NativeRoute.GESTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[NativeRoute.MIMI.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[NativeRoute.GPT_GESTURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[NativeRoute.NEWS_REPORT_ANDROID.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$handleNewDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin", f = "NtEarPlugin.kt", i = {1, 1}, l = {1710, 1729}, m = "handleNewDevice", n = {"productDevice", "newsDevice"}, s = {"L$0", "L$1"})
    static final class C09611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09611(Continuation<? super C09611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtEarPlugin.this.handleNewDevice(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$syncAddress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin", f = "NtEarPlugin.kt", i = {0}, l = {2207}, m = "syncAddress", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class C09661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09661(Continuation<? super C09661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtEarPlugin.this.syncAddress(this);
        }
    }

    public final EarTwoSppProtocol getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(EarTwoSppProtocol earTwoSppProtocol) {
        Intrinsics.checkNotNullParameter(earTwoSppProtocol, "<set-?>");
        this.protocol = earTwoSppProtocol;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final MagicButtonApiManager getMagicButtonApi() {
        return this.magicButtonApi;
    }

    public final void setMagicButtonApi(MagicButtonApiManager magicButtonApiManager) {
        Intrinsics.checkNotNullParameter(magicButtonApiManager, "<set-?>");
        this.magicButtonApi = magicButtonApiManager;
    }

    public final NtEarFlutterApi getFlutterApi() {
        return this.flutterApi;
    }

    public final void setFlutterApi(NtEarFlutterApi ntEarFlutterApi) {
        this.flutterApi = ntEarFlutterApi;
    }

    public final INOSSettingDetail getDeviceDetail() {
        return this.deviceDetail;
    }

    public final void setDeviceDetail(INOSSettingDetail iNOSSettingDetail) {
        this.deviceDetail = iNOSSettingDetail;
    }

    public final INOSSettingSpatial getMainSpatial() {
        return this.mainSpatial;
    }

    public final void setMainSpatial(INOSSettingSpatial iNOSSettingSpatial) {
        this.mainSpatial = iNOSSettingSpatial;
    }

    public final ActivityPluginBinding getActivityBinding() {
        return this.activityBinding;
    }

    public final void setActivityBinding(ActivityPluginBinding activityPluginBinding) {
        this.activityBinding = activityPluginBinding;
    }

    public final SimpleDateFormat getDateFormat() {
        return this.dateFormat;
    }

    public final BoundListener getBoundListener() {
        return this.boundListener;
    }

    public final void setBoundListener(BoundListener boundListener) {
        Intrinsics.checkNotNullParameter(boundListener, "<set-?>");
        this.boundListener = boundListener;
    }

    public final AudiodoHostApi getAudiodoApi() {
        return this.audiodoApi;
    }

    public final void setAudiodoApi(AudiodoHostApi audiodoHostApi) {
        this.audiodoApi = audiodoHostApi;
    }

    public final NewsHostApi getNewsApi() {
        return this.newsApi;
    }

    public final void setNewsApi(NewsHostApi newsHostApi) {
        this.newsApi = newsHostApi;
    }

    public final NtSupperMicApi getSuperMicApi() {
        return this.superMicApi;
    }

    public final void setSuperMicApi(NtSupperMicApi ntSupperMicApi) {
        this.superMicApi = ntSupperMicApi;
    }

    public final NoiseLevelHostApi getNoiseLevelApi() {
        return this.noiseLevelApi;
    }

    public final void setNoiseLevelApi(NoiseLevelHostApi noiseLevelHostApi) {
        this.noiseLevelApi = noiseLevelHostApi;
    }

    public final NtCaseBleApi getNtCaseBleApi() {
        return this.ntCaseBleApi;
    }

    public final void setNtCaseBleApi(NtCaseBleApi ntCaseBleApi) {
        this.ntCaseBleApi = ntCaseBleApi;
    }

    public final NtPeerLinkBleApi getNtPeerLinkBleApi() {
        return this.ntPeerLinkBleApi;
    }

    public final void setNtPeerLinkBleApi(NtPeerLinkBleApi ntPeerLinkBleApi) {
        this.ntPeerLinkBleApi = ntPeerLinkBleApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reboundDevice(String address) {
        List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(address);
        DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
        if (deviceItem2 != null) {
            DatabaseUtils.INSTANCE.getDeviceDao().deleteDeviceItem(deviceItem2);
        }
        DatabaseUtils.INSTANCE.getProfileDao().deleteAll(address);
        IOTDeviceManager.INSTANCE.removeMacAddressDevice(address);
        Application application = AppGlobals.INSTANCE.get();
        if (application != null) {
            GptProviderHelper.INSTANCE.delete(application, address);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(final FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        AspenInit aspenInit = AspenInit.INSTANCE;
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        aspenInit.initAsync(applicationContext);
        this.context = flutterPluginBinding.getApplicationContext();
        NetWorkConstant.INSTANCE.getURL_MAP().put(NetWorkConstant.DEBUG, String.valueOf(Logger.INSTANCE.isDebug()));
        RouterFactory.INSTANCE.initDeviceRouter();
        RouterFactory.INSTANCE.initNativeRouter();
        RouterFactory.INSTANCE.getGlobalRouter().initUrl(true);
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        this.flutterApi = new NtEarFlutterApi(binaryMessenger, null, 2, 0 == true ? 1 : 0);
        NtEarNativeApi.Companion companion = NtEarNativeApi.INSTANCE;
        BinaryMessenger binaryMessenger2 = flutterPluginBinding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger2, "getBinaryMessenger(...)");
        NtEarNativeApi.Companion.setUp$default(companion, binaryMessenger2, this, null, 4, null);
        Context applicationContext2 = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        this.callPlaybackAudioController = new CallPlaybackAudioController(applicationContext2);
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.nothing.nt_ear/audio_session");
        methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda17
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                NtEarPlugin.onAttachedToEngine$lambda$2$lambda$1(this.f$0, methodCall, result);
            }
        });
        this.audioSessionChannel = methodChannel;
        MethodChannel methodChannel2 = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.nothing.nt_ear/sim_country");
        methodChannel2.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda18
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                NtEarPlugin.onAttachedToEngine$lambda$9$lambda$8(flutterPluginBinding, methodCall, result);
            }
        });
        this.simCountryChannel = methodChannel2;
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.nothing.nt_ear/save_image_to_album").setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda19
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                NtEarPlugin.onAttachedToEngine$lambda$10(flutterPluginBinding, methodCall, result);
            }
        });
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.nothing.nt_ear/set_ringtone").setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda20
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                NtEarPlugin.onAttachedToEngine$lambda$11(flutterPluginBinding, this, methodCall, result);
            }
        });
        PreviewUtils.INSTANCE.addListener(this);
        XBluetoothManager.INSTANCE.get().registerBoundListener("NtEarPlugin", this.boundListener);
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass5(flutterPluginBinding, null), 3, null);
        NtEarOTARouterManager.INSTANCE.get().registerEarOTACallback(this.earOTACallback);
        NtEarOTARouterManager.INSTANCE.get().registerBleOTACallback(this.otaStatusChange);
        RouterFactory.INSTANCE.getGlobalRouter().getRemoteConfig();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "NtEarPlugin  onAttachedToEngine end".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "NtEarPlugin  onAttachedToEngine end " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "NtEarPlugin  onAttachedToEngine end " + strComponent2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void onAttachedToEngine$lambda$2$lambda$1(NtEarPlugin ntEarPlugin, MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (str != null) {
            boolean zPrepareInCallPlayback = false;
            switch (str.hashCode()) {
                case -1504491195:
                    if (str.equals("prepareInCallPlayback")) {
                        try {
                            CallPlaybackAudioController callPlaybackAudioController = ntEarPlugin.callPlaybackAudioController;
                            if (callPlaybackAudioController != null) {
                                zPrepareInCallPlayback = callPlaybackAudioController.prepareInCallPlayback();
                            }
                        } catch (Throwable unused) {
                        }
                        result.success(Boolean.valueOf(zPrepareInCallPlayback));
                        return;
                    }
                    break;
                case -201633145:
                    if (str.equals("requestMediaFocusTransient")) {
                        try {
                            CallPlaybackAudioController callPlaybackAudioController2 = ntEarPlugin.callPlaybackAudioController;
                            if (callPlaybackAudioController2 != null) {
                                zPrepareInCallPlayback = callPlaybackAudioController2.requestMediaFocusTransient();
                            }
                        } catch (Throwable unused2) {
                        }
                        result.success(Boolean.valueOf(zPrepareInCallPlayback));
                        return;
                    }
                    break;
                case 188949573:
                    if (str.equals("releaseInCallPlayback")) {
                        try {
                            CallPlaybackAudioController callPlaybackAudioController3 = ntEarPlugin.callPlaybackAudioController;
                            if (callPlaybackAudioController3 != null) {
                                callPlaybackAudioController3.releaseInCallPlayback();
                            }
                            break;
                        } catch (Throwable unused3) {
                        }
                        result.success(null);
                        return;
                    }
                    break;
                case 1747787689:
                    if (str.equals("abandonMediaFocus")) {
                        try {
                            CallPlaybackAudioController callPlaybackAudioController4 = ntEarPlugin.callPlaybackAudioController;
                            if (callPlaybackAudioController4 != null) {
                                callPlaybackAudioController4.abandonMediaFocus();
                            }
                            break;
                        } catch (Throwable unused4) {
                        }
                        result.success(null);
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:46:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d3  */
    public static final void onAttachedToEngine$lambda$9$lambda$8(FlutterPlugin.FlutterPluginBinding flutterPluginBinding, MethodCall call, final MethodChannel.Result result) {
        Object next;
        String countryIso;
        String string;
        String upperCase;
        String string2;
        String upperCase2;
        String simCountryIso;
        String string3;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (Intrinsics.areEqual(str, "getSimCountryCode")) {
            Object obj = null;
            try {
                Context applicationContext = flutterPluginBinding.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                Object systemService = applicationContext.getSystemService("telephony_subscription_service");
                SubscriptionManager subscriptionManager = systemService instanceof SubscriptionManager ? (SubscriptionManager) systemService : null;
                Object systemService2 = applicationContext.getSystemService("phone");
                TelephonyManager telephonyManager = systemService2 instanceof TelephonyManager ? (TelephonyManager) systemService2 : null;
                if (subscriptionManager != null) {
                    try {
                        List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
                        if (activeSubscriptionInfoList != null) {
                            Iterator<T> it = activeSubscriptionInfoList.iterator();
                            do {
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                } else {
                                    next = it.next();
                                    String countryIso2 = ((SubscriptionInfo) next).getCountryIso();
                                    string2 = countryIso2 != null ? StringsKt.trim((CharSequence) countryIso2).toString() : null;
                                }
                            } while (string2 == null || string2.length() == 0);
                            SubscriptionInfo subscriptionInfo = (SubscriptionInfo) next;
                            if (subscriptionInfo == null || (countryIso = subscriptionInfo.getCountryIso()) == null || (string = StringsKt.trim((CharSequence) countryIso).toString()) == null) {
                                upperCase = null;
                            } else {
                                upperCase = string.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                if (upperCase == null || upperCase.length() <= 0) {
                                    upperCase = null;
                                }
                            }
                        } else {
                            upperCase = null;
                        }
                    } catch (Throwable unused) {
                    }
                } else {
                    upperCase = null;
                }
                if (telephonyManager == null || (simCountryIso = telephonyManager.getSimCountryIso()) == null || (string3 = StringsKt.trim((CharSequence) simCountryIso).toString()) == null) {
                    upperCase2 = null;
                } else {
                    upperCase2 = string3.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    if (upperCase2 == null || upperCase2.length() <= 0) {
                        upperCase2 = null;
                    }
                }
                String str2 = upperCase == null ? upperCase2 : upperCase;
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str3 = "getSimCountryCode subCountry=" + upperCase + " telephonyCountry=" + upperCase2 + " resolved=" + str2;
                    String str4 = str3;
                    if (str4 != null && str4.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str5 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        FileLog.print$default(fileLog, 3, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                obj = str2;
            } catch (Throwable unused2) {
            }
            result.success(obj);
            return;
        }
        if (Intrinsics.areEqual(str, "getCallRecordingPolicy")) {
            if (Intrinsics.areEqual(call.argument("forceRefresh"), (Object) true)) {
                RouterFactory.INSTANCE.getGlobalRouter().refreshCallRecordingPolicy(new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtEarPlugin.onAttachedToEngine$lambda$9$lambda$8$lambda$7(result, (String) obj2);
                    }
                });
                return;
            } else {
                result.success(SpUtils.INSTANCE.getCallRecordingPolicy());
                return;
            }
        }
        result.notImplemented();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachedToEngine$lambda$9$lambda$8$lambda$7(MethodChannel.Result result, String policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        result.success(policy);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachedToEngine$lambda$10(FlutterPlugin.FlutterPluginBinding flutterPluginBinding, MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(call.method, "saveImageToAlbum")) {
            String str = (String) call.argument("path");
            String str2 = (String) call.argument("name");
            String str3 = str;
            if (str3 == null || str3.length() == 0) {
                result.success(false);
                return;
            }
            GalleryImageSaveUtil galleryImageSaveUtil = GalleryImageSaveUtil.INSTANCE;
            Context applicationContext = flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            result.success(Boolean.valueOf(galleryImageSaveUtil.saveImageFileToGallery(applicationContext, str, str2)));
            return;
        }
        result.notImplemented();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachedToEngine$lambda$11(FlutterPlugin.FlutterPluginBinding flutterPluginBinding, NtEarPlugin ntEarPlugin, MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(call.method, "setAsRingtone")) {
            String str = (String) call.argument("path");
            String str2 = (String) call.argument("name");
            String str3 = str;
            String str4 = "failed";
            if (str3 == null || str3.length() == 0) {
                result.success(MapsKt.mapOf(TuplesKt.to(NotificationCompat.CATEGORY_STATUS, "failed")));
                return;
            }
            RingtoneSaveUtil ringtoneSaveUtil = RingtoneSaveUtil.INSTANCE;
            Context applicationContext = flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            ActivityPluginBinding activityPluginBinding = ntEarPlugin.activityBinding;
            int i = WhenMappings.$EnumSwitchMapping$0[ringtoneSaveUtil.setAsDefaultRingtone(applicationContext, str, str2, activityPluginBinding != null ? activityPluginBinding.getActivity() : null).ordinal()];
            if (i == 1) {
                str4 = "success";
            } else if (i == 2) {
                str4 = "need_write_settings";
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            result.success(MapsKt.mapOf(TuplesKt.to(NotificationCompat.CATEGORY_STATUS, str4)));
            return;
        }
        result.notImplemented();
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$onAttachedToEngine$5, reason: invalid class name */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$onAttachedToEngine$5", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlutterPlugin.FlutterPluginBinding $flutterPluginBinding;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(FlutterPlugin.FlutterPluginBinding flutterPluginBinding, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$flutterPluginBinding = flutterPluginBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new AnonymousClass5(this.$flutterPluginBinding, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            EventDatabase.Companion companion = EventDatabase.INSTANCE;
            Application application = AppGlobals.INSTANCE.get();
            Intrinsics.checkNotNull(application);
            companion.getInstance(application).getEventDao();
            NtEarPlugin.this.getMagicButtonApi().onAttachedToEngine(this.$flutterPluginBinding);
            NtEarPlugin ntEarPlugin = NtEarPlugin.this;
            Context applicationContext = this.$flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            BinaryMessenger binaryMessenger = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
            int i = 2;
            ntEarPlugin.setAudiodoApi(new AudiodoApi(applicationContext, new AudiodoFlutterApi(binaryMessenger, null, i, 0 == true ? 1 : 0)));
            NtEarPlugin ntEarPlugin2 = NtEarPlugin.this;
            Context applicationContext2 = this.$flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            BinaryMessenger binaryMessenger2 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger2, "getBinaryMessenger(...)");
            ntEarPlugin2.setNewsApi(new NewsApi(applicationContext2, new NewsFlutterApi(binaryMessenger2, null, 2, null)));
            NtEarPlugin ntEarPlugin3 = NtEarPlugin.this;
            Context applicationContext3 = this.$flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
            BinaryMessenger binaryMessenger3 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger3, "getBinaryMessenger(...)");
            ntEarPlugin3.setSuperMicApi(new NtSupperMicApi(applicationContext3, new NtSuperMicWalkTalkFlutterApi(binaryMessenger3, null, 2, null)));
            NtEarPlugin ntEarPlugin4 = NtEarPlugin.this;
            Context applicationContext4 = this.$flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
            BinaryMessenger binaryMessenger4 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger4, "getBinaryMessenger(...)");
            ntEarPlugin4.setNoiseLevelApi(new NoiseLevelApi(applicationContext4, new NoiseLevelFlutterApi(binaryMessenger4, null, 2, null)));
            NtEarPlugin ntEarPlugin5 = NtEarPlugin.this;
            BinaryMessenger binaryMessenger5 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger5, "getBinaryMessenger(...)");
            ntEarPlugin5.setNtCaseBleApi(new NtCaseBleApi(new NtCaseBleFlutterApi(binaryMessenger5, null, 2, null)));
            NtCaseBleHostApi.Companion companion2 = NtCaseBleHostApi.INSTANCE;
            BinaryMessenger binaryMessenger6 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger6, "getBinaryMessenger(...)");
            NtCaseBleHostApi.Companion.setUp$default(companion2, binaryMessenger6, NtEarPlugin.this.getNtCaseBleApi(), null, 4, null);
            NtEarPlugin ntEarPlugin6 = NtEarPlugin.this;
            BinaryMessenger binaryMessenger7 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger7, "getBinaryMessenger(...)");
            ntEarPlugin6.setNtPeerLinkBleApi(new NtPeerLinkBleApi(new NtPeerLinkFlutterApi(binaryMessenger7, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0)));
            NtPeerLinkHostApi.Companion companion3 = NtPeerLinkHostApi.INSTANCE;
            BinaryMessenger binaryMessenger8 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger8, "getBinaryMessenger(...)");
            NtPeerLinkHostApi.Companion.setUp$default(companion3, binaryMessenger8, NtEarPlugin.this.getNtPeerLinkBleApi(), null, 4, null);
            WalkieTalkieHelper.INSTANCE.init(NtEarPlugin.this.getSuperMicApi());
            NtSuperMicWalkTalkApi.Companion companion4 = NtSuperMicWalkTalkApi.INSTANCE;
            BinaryMessenger binaryMessenger9 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger9, "getBinaryMessenger(...)");
            NtSuperMicWalkTalkApi.Companion.setUp$default(companion4, binaryMessenger9, NtEarPlugin.this.getSuperMicApi(), null, 4, null);
            AudiodoHostApi.Companion companion5 = AudiodoHostApi.INSTANCE;
            BinaryMessenger binaryMessenger10 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger10, "getBinaryMessenger(...)");
            AudiodoHostApi.Companion.setUp$default(companion5, binaryMessenger10, NtEarPlugin.this.getAudiodoApi(), null, 4, null);
            NewsHostApi.Companion companion6 = NewsHostApi.INSTANCE;
            BinaryMessenger binaryMessenger11 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger11, "getBinaryMessenger(...)");
            NewsHostApi.Companion.setUp$default(companion6, binaryMessenger11, NtEarPlugin.this.getNewsApi(), null, 4, null);
            NoiseLevelHostApi.Companion companion7 = NoiseLevelHostApi.INSTANCE;
            BinaryMessenger binaryMessenger12 = this.$flutterPluginBinding.getBinaryMessenger();
            Intrinsics.checkNotNullExpressionValue(binaryMessenger12, "getBinaryMessenger(...)");
            NoiseLevelHostApi.Companion.setUp$default(companion7, binaryMessenger12, NtEarPlugin.this.getNoiseLevelApi(), null, 4, null);
            BigDataControl bigDataControl = BigDataControl.INSTANCE;
            Context applicationContext5 = this.$flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
            bigDataControl.bindService(applicationContext5, new OnProgressListener() { // from class: com.nothing.nt_ear.NtEarPlugin.onAttachedToEngine.5.1
                @Override // com.nothing.event.log.service.OnProgressListener
                public void onProgress(int totalProgress, String percentText) {
                    Intrinsics.checkNotNullParameter(percentText, "percentText");
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "BigDataControl onProgress " + totalProgress;
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
                        FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
            });
            NtEarPlugin ntEarPlugin7 = NtEarPlugin.this;
            Context applicationContext6 = this.$flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext6, "getApplicationContext(...)");
            ntEarPlugin7.connectSkyWalk(applicationContext6);
            GlobalRouter globalRouter = RouterFactory.INSTANCE.getGlobalRouter();
            Context applicationContext7 = this.$flutterPluginBinding.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext7, "getApplicationContext(...)");
            globalRouter.initGoogleScore(applicationContext7);
            NTPluginManager.INSTANCE.get().addHandler(NtEarPlugin.this.callHandler);
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void setPreviewMode(boolean preview, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        PreviewUtils.INSTANCE.setChangePreviewMode(preview);
        SpUtils.INSTANCE.setStartFragmentDialogAgree(!preview);
        if (!preview && NothingOSUtil.INSTANCE.isChina(this.context)) {
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "[NtMimiPrivacy] setPreviewMode: privacy accepted \u2192 initMiMiSDK()".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 4, str, tag, "[NtMimiPrivacy] setPreviewMode: privacy accepted \u2192 initMiMiSDK() " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "[NtMimiPrivacy] setPreviewMode: privacy accepted \u2192 initMiMiSDK() " + strComponent2);
                }
            }
            RouterFactory.INSTANCE.getEarTwoRouter().initMiMiSDK();
        } else {
            com.nothing.base.util.Logger logger2 = com.nothing.base.util.Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "[NtMimiPrivacy] setPreviewMode: preview mode on \u2192 Mimi deferred".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 4, str2, tag2, "[NtMimiPrivacy] setPreviewMode: preview mode on \u2192 Mimi deferred " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "[NtMimiPrivacy] setPreviewMode: preview mode on \u2192 Mimi deferred " + strComponent4);
                }
            }
        }
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        try {
            CallPlaybackAudioController callPlaybackAudioController = this.callPlaybackAudioController;
            if (callPlaybackAudioController != null) {
                callPlaybackAudioController.releaseInCallPlayback();
            }
        } catch (Throwable unused) {
        }
        try {
            MethodChannel methodChannel = this.audioSessionChannel;
            if (methodChannel != null) {
                methodChannel.setMethodCallHandler(null);
            }
        } catch (Throwable unused2) {
        }
        this.audioSessionChannel = null;
        this.callPlaybackAudioController = null;
        try {
            MethodChannel methodChannel2 = this.simCountryChannel;
            if (methodChannel2 != null) {
                methodChannel2.setMethodCallHandler(null);
            }
        } catch (Throwable unused3) {
        }
        this.simCountryChannel = null;
        BigDataControl bigDataControl = BigDataControl.INSTANCE;
        Context applicationContext = binding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        bigDataControl.onDestroy(applicationContext);
        this.magicButtonApi.onDetachedFromEngine(binding);
        this.context = null;
        XBluetoothManager.INSTANCE.get().unRegisterBoundListener("NtEarPlugin");
        NtAppCommonNativeApi.Companion companion = NtAppCommonNativeApi.INSTANCE;
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        NtAppCommonNativeApi.Companion.setUp$default(companion, binaryMessenger, null, null, 4, null);
        NtEarNativeApi.Companion companion2 = NtEarNativeApi.INSTANCE;
        BinaryMessenger binaryMessenger2 = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger2, "getBinaryMessenger(...)");
        NtEarNativeApi.Companion.setUp$default(companion2, binaryMessenger2, null, null, 4, null);
        SpotifyHostApi.Companion companion3 = SpotifyHostApi.INSTANCE;
        BinaryMessenger binaryMessenger3 = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger3, "getBinaryMessenger(...)");
        SpotifyHostApi.Companion.setUp$default(companion3, binaryMessenger3, null, null, 4, null);
        AudiodoHostApi.Companion companion4 = AudiodoHostApi.INSTANCE;
        BinaryMessenger binaryMessenger4 = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger4, "getBinaryMessenger(...)");
        AudiodoHostApi.Companion.setUp$default(companion4, binaryMessenger4, null, null, 4, null);
        NtCaseBleHostApi.Companion companion5 = NtCaseBleHostApi.INSTANCE;
        BinaryMessenger binaryMessenger5 = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger5, "getBinaryMessenger(...)");
        NtCaseBleHostApi.Companion.setUp$default(companion5, binaryMessenger5, null, null, 4, null);
        NtPeerLinkHostApi.Companion companion6 = NtPeerLinkHostApi.INSTANCE;
        BinaryMessenger binaryMessenger6 = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger6, "getBinaryMessenger(...)");
        NtPeerLinkHostApi.Companion.setUp$default(companion6, binaryMessenger6, null, null, 4, null);
        this.ntPeerLinkBleApi = null;
        NtMediaSessionNativeApi.Companion companion7 = NtMediaSessionNativeApi.INSTANCE;
        BinaryMessenger binaryMessenger7 = binding.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger7, "getBinaryMessenger(...)");
        NtMediaSessionNativeApi.Companion.setUp$default(companion7, binaryMessenger7, null, null, 4, null);
        NtEarOTARouterManager.INSTANCE.get().removeEarOTACallback(this.earOTACallback);
        NtEarOTARouterManager.INSTANCE.get().removeBleOTACallback(this.otaStatusChange);
        OTAHelper.cancelOTA$default(OTAHelper.INSTANCE, false, 1, null);
        OTAHelper.INSTANCE.release();
        OTAHelper.INSTANCE.unregisterTransfer(this.transferCallback);
        NtSupperMicApi ntSupperMicApi = this.superMicApi;
        if (ntSupperMicApi != null) {
            ntSupperMicApi.destroy();
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "NtEarPlugin  onDetachedFromEngine ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "NtEarPlugin  onDetachedFromEngine  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "NtEarPlugin  onDetachedFromEngine  " + strComponent2);
            }
        }
        NTPluginManager.INSTANCE.get().removeHandler(this.callHandler);
        PreviewUtils.INSTANCE.removeListener(this);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$logout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$logout$1", f = "NtEarPlugin.kt", i = {}, l = {651}, m = "invokeSuspend", n = {}, s = {})
    static final class C09621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09621(Continuation<? super C09621> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09621(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (MimiManager.INSTANCE.clearHearId(false, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void logout(String email, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NtFlutterSharedPreference.INSTANCE.setUserInfo("");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09621(null), 3, null);
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void login(String userInfo, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NtFlutterSharedPreference.INSTANCE.setUserInfo(userInfo);
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.activityBinding = binding;
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "NtEarPlugin---onAttachedToActivity ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "NtEarPlugin---onAttachedToActivity  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "NtEarPlugin---onAttachedToActivity  " + strComponent2);
            }
        }
        NTCrashHandler.Companion companion = NTCrashHandler.INSTANCE;
        Context applicationContext = binding.getActivity().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        NTCrashHandler.Companion.cleanupOldCrashFiles$default(companion, applicationContext, 0, 2, null);
        Activity activity = binding.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        onAttachSettingsInterface(activity);
        try {
            addRouterInterceptor(activity, binding);
        } catch (Exception unused) {
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C09632(binding, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$onAttachedToActivity$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$onAttachedToActivity$2", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09632 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActivityPluginBinding $binding;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09632(ActivityPluginBinding activityPluginBinding, Continuation<? super C09632> continuation) {
            super(2, continuation);
            this.$binding = activityPluginBinding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new C09632(this.$binding, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09632) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NtEarPlugin.this.getMagicButtonApi().onAttachedToActivity(this.$binding);
            return Unit.INSTANCE;
        }
    }

    private final void addRouterInterceptor(final Activity activity, ActivityPluginBinding binding) {
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "NtEarPlugin---addRouterInterceptor ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "NtEarPlugin---addRouterInterceptor  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "NtEarPlugin---addRouterInterceptor  " + strComponent2);
            }
        }
        FlutterRouterManager.INSTANCE.get().addEarInterceptor(new Function2() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(NtEarPlugin.addRouterInterceptor$lambda$22(activity, this, (NativeRoute) obj, (Map) obj2));
            }
        });
        binding.addActivityResultListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final boolean addRouterInterceptor$lambda$22(Activity activity, NtEarPlugin ntEarPlugin, NativeRoute route, Map map) {
        boolean z;
        String str;
        TWSDevice twsDevice;
        Intrinsics.checkNotNullParameter(route, "route");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "NtEarMessagesPlugin  " + route + StringUtils.SPACE + map;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (map != null && !map.isEmpty() && map.containsKey("device")) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new NtEarPlugin$addRouterInterceptor$2$2(ntEarPlugin, null), 3, null);
            JSONObject jSONObject = new JSONObject(String.valueOf(map.get("device")));
            String strValueOf = String.valueOf(map.get("firmwareVersion"));
            String strValueOf2 = String.valueOf(map.get("source"));
            String stringOrNull = JSONObjectExtKt.getStringOrNull(jSONObject, "realMac");
            if (stringOrNull == null) {
                stringOrNull = "";
            }
            String stringOrNull2 = JSONObjectExtKt.getStringOrNull(jSONObject, "fastPairID");
            if (stringOrNull2 == null) {
                stringOrNull2 = "";
            }
            String stringOrNull3 = JSONObjectExtKt.getStringOrNull(jSONObject, "modelId");
            if (stringOrNull3 == null) {
                stringOrNull3 = "";
            }
            String stringOrNull4 = JSONObjectExtKt.getStringOrNull(jSONObject, "colorId");
            if (stringOrNull4 == null) {
                stringOrNull4 = "";
            }
            String stringOrNull5 = JSONObjectExtKt.getStringOrNull(jSONObject, "name");
            String str5 = stringOrNull5 != null ? stringOrNull5 : "";
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                z = 0;
                z = 0;
                z = 0;
                String str6 = "white_list_android productId:" + stringOrNull3 + ",colorId:" + stringOrNull4 + ",name:" + str5;
                String str7 = str6;
                if (str7 == null || str7.length() == 0) {
                    str = str5;
                } else {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    str = str5;
                    String str8 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    FileLog.print$default(fileLog2, 3, str8, tag2, str6 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str6 + StringUtils.SPACE + strComponent4);
                    }
                }
            } else {
                str = str5;
                z = 0;
            }
            if (stringOrNull.length() == 0 || stringOrNull2.length() == 0) {
                return true;
            }
            SpUtils.INSTANCE.setSelectDeviceMac(stringOrNull);
            SpUtils.INSTANCE.setCurrentModel(stringOrNull2);
            String str9 = stringOrNull2;
            ntEarPlugin.createUnknownDevice(str9, stringOrNull3, stringOrNull, stringOrNull4, str);
            IOTDevice andCreateIOTDevice = IOTDeviceManager.INSTANCE.getAndCreateIOTDevice(stringOrNull, str9);
            if (andCreateIOTDevice != null && (twsDevice = andCreateIOTDevice.getTwsDevice()) != null) {
                twsDevice.setVersion(strValueOf);
            }
            List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(stringOrNull);
            DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
            if (deviceItem2 == null) {
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str10 = "getFirmwareVersion deviceItem is null  " + strValueOf;
                    String str11 = str10;
                    if (str11 != null && str11.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str12 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                        FileLog.print$default(fileLog3, 3, str12, tag3, str10 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, str10 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                DeviceItem deviceItem3 = new DeviceItem("", stringOrNull, false, strValueOf, str9, null, false, false, false, null, false, 0L, 4068, null);
                DeviceItemDao deviceDao = DatabaseUtils.INSTANCE.getDeviceDao();
                DeviceItem[] deviceItemArr = new DeviceItem[1];
                deviceItemArr[z] = deviceItem3;
                deviceDao.insertDeviceItem(deviceItemArr);
            } else if (strValueOf.length() > 0) {
                deviceItem2.setDeviceVersion(strValueOf);
                DeviceItemDao deviceDao2 = DatabaseUtils.INSTANCE.getDeviceDao();
                DeviceItem[] deviceItemArr2 = new DeviceItem[1];
                deviceItemArr2[z] = deviceItem2;
                deviceDao2.updateDeviceItem(deviceItemArr2);
            }
            IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(str9);
            IOTDeviceAction action = productByModelId != null ? productByModelId.getAction() : null;
            switch (WhenMappings.$EnumSwitchMapping$1[route.ordinal()]) {
                case 1:
                    try {
                        activity.startActivity(new Intent(activity, Class.forName("com.nothing.debug.tools.EarDebugToolActivity")));
                        return true;
                    } catch (Exception e) {
                        Logger logger4 = Logger.INSTANCE;
                        String tag4 = logger4.getTAG();
                        int depth4 = logger4.getDepth();
                        if (!logger4.isCanLogger(true)) {
                            return true;
                        }
                        String str13 = "Can't start EarDebugToolActivity " + e.getMessage();
                        String str14 = str13;
                        if (str14 == null || str14.length() == 0) {
                            return true;
                        }
                        Pair<String, String> trace4 = logger4.getTrace(depth4);
                        String strComponent7 = trace4.component1();
                        String strComponent8 = trace4.component2();
                        FileLog fileLog4 = FileLog.INSTANCE;
                        String str15 = logger4.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                        FileLog.print$default(fileLog4, 5, str15, tag4, str13 + StringUtils.SPACE + strComponent8, null, 16, null);
                        if (!logger4.isDebug()) {
                            return true;
                        }
                        Log.w(tag4 + strComponent7, str13 + StringUtils.SPACE + strComponent8);
                        return true;
                    }
                case 2:
                    if (action != null) {
                        action.startFirmwareActivity(activity);
                    }
                    return true;
                case 3:
                    if (action != null) {
                        action.startEqualizerActivity(activity);
                    }
                    return true;
                case 4:
                    ImageView imageView = new ImageView(activity);
                    Triple<? extends View, ? extends View, ? extends View> triple = new Triple<>(imageView, imageView, imageView);
                    if (Intrinsics.areEqual(strValueOf2, "dialog")) {
                        if (action != null) {
                            action.startCaseControlActivity(activity, triple);
                        }
                    } else if (action != null) {
                        action.startControlActivity(activity, triple, true);
                        return true;
                    }
                    return true;
                case 5:
                    MimiSdkActivity.INSTANCE.startMimiSDK(activity);
                    return true;
                case 6:
                    GptProviderHelper.INSTANCE.insertOrUpdate(activity, SpUtils.INSTANCE.getSelectDeviceMac(), VoiceAssistantUtil.INSTANCE.isGptEnable(), z);
                    if (action == null) {
                        return true;
                    }
                    action.startGestureOperationActivity(activity, stringOrNull);
                    return true;
                case 7:
                    RouterFactory.INSTANCE.getWidgetRouter().startNewsConfig(activity);
                    return true;
                default:
                    return z;
            }
        }
        if (route != NativeRoute.NEWS_REPORT_ANDROID) {
            return false;
        }
        RouterFactory.INSTANCE.getWidgetRouter().startNewsConfig(activity);
        return true;
    }

    static /* synthetic */ IOTDevice createUnknownDevice$default(NtEarPlugin ntEarPlugin, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = null;
        }
        return ntEarPlugin.createUnknownDevice(str, str2, str3, str4, str5);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00f6  */
    private final IOTDevice createUnknownDevice(String fastPairID, String productId, String mac, String colorId, String name) {
        Integer num;
        DeviceColor deviceColorFromValue;
        ProtocolModel protocol;
        ProtocolModel protocol2;
        HashSet<IOTDevice> deviceList;
        IOTDevice iOTDevice;
        if (StringsKt.isBlank(fastPairID) || StringsKt.isBlank(productId) || StringsKt.isBlank(mac)) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "unknown_widget createUnknownDevice error: invalid parameters fastPairID:" + fastPairID + ", productId:" + productId + ", mac:" + mac;
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
            return null;
        }
        if (IOTDeviceManager.INSTANCE.getAllFastPairMap().keySet().contains(fastPairID)) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "unknown_widget createUnknownDevice skip: fastPairID already exists: " + fastPairID;
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str6 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            return null;
        }
        IOTDevice nativeTemplateForModelId = IOTDeviceManager.INSTANCE.getNativeTemplateForModelId(fastPairID);
        if (nativeTemplateForModelId != null) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str7 = "unknown_widget createUnknownDevice use native template: " + fastPairID + "," + mac;
                String str8 = str7;
                if (str8 == null || str8.length() == 0) {
                    iOTDevice = nativeTemplateForModelId;
                    num = null;
                } else {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    num = null;
                    String str9 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                    iOTDevice = nativeTemplateForModelId;
                    FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                    }
                }
            } else {
                iOTDevice = nativeTemplateForModelId;
                num = null;
            }
            IOTDevice iOTDevice2 = (IOTDevice) iOTDevice.getClass().newInstance();
            if (iOTDevice2 != null) {
                if (iOTDevice.getOverrideDeviceName()) {
                    iOTDevice2.setDeviceName(iOTDevice.getDeviceName());
                }
                iOTDevice2.setMacAddress(mac);
                iOTDevice2.setModelId(fastPairID);
                iOTDevice2.setProductId(iOTDevice.getProductId());
                iOTDevice2.addAllGesturesItem(iOTDevice.getGestureList());
                iOTDevice2.setMyMacAddress(mac);
                IOTDeviceManager.INSTANCE.getAllFastPairMap().put(fastPairID, fastPairID);
                IOTDeviceManager.INSTANCE.addAddressDevice(iOTDevice2);
                IOTDeviceManager.INSTANCE.evictUnknownProductIfNativeExists$nt_ear_GoogleStoreRelease(iOTDevice.getProductId());
                return iOTDevice2;
            }
        } else {
            num = null;
        }
        IOTProductDevice productByProductId = IOTDeviceManager.INSTANCE.getProductByProductId(productId);
        if (productByProductId != null && !(productByProductId instanceof UnknownProduct)) {
            NewSkuDevice newSkuDevice = new NewSkuDevice(DeviceColor.BLACK, fastPairID, productId);
            IOTDevice iOTDevice3 = (IOTDevice) CollectionsKt.firstOrNull(productByProductId.getDeviceList());
            if (iOTDevice3 != null) {
                com.nothing.base.util.Logger logger4 = com.nothing.base.util.Logger.INSTANCE;
                Logger logger5 = Logger.INSTANCE;
                com.nothing.base.util.Logger logger6 = logger4;
                String tag4 = logger6.getTAG();
                int depth4 = logger6.getDepth();
                if (logger6.isCanLogger(true) && "unknown_widget_sku add anc number".length() != 0) {
                    Pair<String, String> trace4 = logger6.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str10 = logger6.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    FileLog.print$default(fileLog4, 3, str10, tag4, "unknown_widget_sku add anc number " + strComponent8, null, 16, null);
                    if (logger6.isDebug()) {
                        Log.i(tag4 + strComponent7, "unknown_widget_sku add anc number " + strComponent8);
                    }
                }
                newSkuDevice.setDeviceConfigs(iOTDevice3.isSupportAdvanceEQ(), iOTDevice3.getANCLevel(""), iOTDevice3.getProductId(), iOTDevice3.getDeviceName());
            } else {
                com.nothing.base.util.Logger logger7 = com.nothing.base.util.Logger.INSTANCE;
                Logger logger8 = Logger.INSTANCE;
                com.nothing.base.util.Logger logger9 = logger7;
                String tag5 = logger9.getTAG();
                int depth5 = logger9.getDepth();
                if (logger9.isCanLogger(true) && "unknown_widget_sku add test sku".length() != 0) {
                    Pair<String, String> trace5 = logger9.getTrace(depth5);
                    String strComponent9 = trace5.component1();
                    String strComponent10 = trace5.component2();
                    FileLog fileLog5 = FileLog.INSTANCE;
                    String str11 = logger9.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                    FileLog.print$default(fileLog5, 3, str11, tag5, "unknown_widget_sku add test sku " + strComponent10, null, 16, null);
                    if (logger9.isDebug()) {
                        Log.i(tag5 + strComponent9, "unknown_widget_sku add test sku " + strComponent10);
                    }
                }
                newSkuDevice.setDeviceConfigs(productByProductId.supportAdvanceEq(), productByProductId.getSupportANCLevel(), productId, productByProductId.getDeviceName());
            }
            IOTDeviceManager.INSTANCE.getAllFastPairMap().put(fastPairID, fastPairID);
            newSkuDevice.setMacAddress(mac);
            newSkuDevice.setMyMacAddress(mac);
            productByProductId.getDeviceList().add(newSkuDevice);
            NewSkuDevice newSkuDevice2 = newSkuDevice;
            IOTDeviceManager.INSTANCE.addAddressDevice(newSkuDevice2);
            return newSkuDevice2;
        }
        Logger logger10 = Logger.INSTANCE;
        String tag6 = logger10.getTAG();
        int depth6 = logger10.getDepth();
        if (logger10.isCanLogger(true)) {
            String str12 = "unknown_widget_projectId " + productId + " white_list_android create unknown device";
            String str13 = str12;
            if (str13 != null && str13.length() != 0) {
                Pair<String, String> trace6 = logger10.getTrace(depth6);
                String strComponent11 = trace6.component1();
                String strComponent12 = trace6.component2();
                FileLog fileLog6 = FileLog.INSTANCE;
                String str14 = logger10.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                FileLog.print$default(fileLog6, 3, str14, tag6, str12 + StringUtils.SPACE + strComponent12, null, 16, null);
                if (logger10.isDebug()) {
                    Log.i(tag6 + strComponent11, str12 + StringUtils.SPACE + strComponent12);
                }
            }
        }
        UnknownDevice unknownDevice = new UnknownDevice();
        if (colorId.length() > 0) {
            try {
                deviceColorFromValue = DeviceColor.INSTANCE.fromValue(colorId);
            } catch (Exception unused) {
                Logger logger11 = Logger.INSTANCE;
                String tag7 = logger11.getTAG();
                int depth7 = logger11.getDepth();
                if (logger11.isCanLogger(true)) {
                    String str15 = "unknown_widget createUnknownDevice invalid colorId: " + colorId + ", use default";
                    String str16 = str15;
                    if (str16 != null && str16.length() != 0) {
                        Pair<String, String> trace7 = logger11.getTrace(depth7);
                        String strComponent13 = trace7.component1();
                        String strComponent14 = trace7.component2();
                        FileLog fileLog7 = FileLog.INSTANCE;
                        String str17 = logger11.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str17, "format(...)");
                        FileLog.print$default(fileLog7, 3, str17, tag7, str15 + StringUtils.SPACE + strComponent14, null, 16, null);
                        if (logger11.isDebug()) {
                            Log.i(tag7 + strComponent13, str15 + StringUtils.SPACE + strComponent14);
                        }
                    }
                }
                deviceColorFromValue = DeviceColor.BLACK;
            }
        } else {
            deviceColorFromValue = DeviceColor.BLACK;
        }
        unknownDevice.setDeviceConfigs(deviceColorFromValue, fastPairID, productId);
        if (name != null) {
            unknownDevice.setDeviceName(name);
        }
        IOTProductDevice productByProductId2 = IOTDeviceManager.INSTANCE.getProductByProductId(productId);
        if (productByProductId2 != null && (deviceList = productByProductId2.getDeviceList()) != null) {
            deviceList.add(unknownDevice);
        }
        unknownDevice.setMacAddress(mac);
        UnknownDevice unknownDevice2 = unknownDevice;
        IOTDeviceManager.INSTANCE.addAddressDevice(unknownDevice2);
        IOTDeviceManager.INSTANCE.getAllFastPairMap().put(fastPairID, fastPairID);
        unknownDevice.setMyMacAddress(mac);
        Logger logger12 = Logger.INSTANCE;
        String tag8 = logger12.getTAG();
        int depth8 = logger12.getDepth();
        if (logger12.isCanLogger(true)) {
            TWSDevice twsDevice = unknownDevice.getTwsDevice();
            String str18 = "white_list_android tws Type:" + ((twsDevice == null || (protocol2 = twsDevice.getProtocol()) == null) ? num : Integer.valueOf(protocol2.getType()));
            String str19 = str18;
            if (str19 != null && str19.length() != 0) {
                Pair<String, String> trace8 = logger12.getTrace(depth8);
                String strComponent15 = trace8.component1();
                String strComponent16 = trace8.component2();
                FileLog fileLog8 = FileLog.INSTANCE;
                String str20 = logger12.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str20, "format(...)");
                FileLog.print$default(fileLog8, 3, str20, tag8, str18 + StringUtils.SPACE + strComponent16, null, 16, null);
                if (logger12.isDebug()) {
                    Log.i(tag8 + strComponent15, str18 + StringUtils.SPACE + strComponent16);
                }
            }
        }
        Logger logger13 = Logger.INSTANCE;
        String tag9 = logger13.getTAG();
        int depth9 = logger13.getDepth();
        if (logger13.isCanLogger(true)) {
            TWSDevice twsDevice2 = unknownDevice.getTwsDevice();
            String str21 = "iotDevice_error tws Type:" + ((twsDevice2 == null || (protocol = twsDevice2.getProtocol()) == null) ? num : Integer.valueOf(protocol.getType())) + ",tws:" + unknownDevice.getTwsDevice();
            String str22 = str21;
            if (str22 != null && str22.length() != 0) {
                Pair<String, String> trace9 = logger13.getTrace(depth9);
                String strComponent17 = trace9.component1();
                String strComponent18 = trace9.component2();
                FileLog fileLog9 = FileLog.INSTANCE;
                String str23 = logger13.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str23, "format(...)");
                FileLog.print$default(fileLog9, 3, str23, tag9, str21 + StringUtils.SPACE + strComponent18, null, 16, null);
                if (logger13.isDebug()) {
                    Log.i(tag9 + strComponent17, str21 + StringUtils.SPACE + strComponent18);
                }
            }
        }
        return unknownDevice2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onAttachSettingsInterface(Activity activity) {
        MutableLiveData<HeaderInfoEntity> headerInfoLiveData;
        MutableLiveData<ListNOSProfileInfo> audioTypeInfoLiveData;
        MutableLiveData<ListNOSProfileInfo> profileInfoLiveData;
        if ((activity instanceof INOSSettingDetail) && (activity instanceof FlutterActivity)) {
            INOSSettingDetail iNOSSettingDetail = (INOSSettingDetail) activity;
            this.deviceDetail = iNOSSettingDetail;
            if (iNOSSettingDetail != null && (profileInfoLiveData = iNOSSettingDetail.getProfileInfoLiveData()) != null) {
                profileInfoLiveData.observe((LifecycleOwner) activity, new NtEarPlugin$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NtEarPlugin.onAttachSettingsInterface$lambda$34(this.f$0, (ListNOSProfileInfo) obj);
                    }
                }));
            }
            INOSSettingDetail iNOSSettingDetail2 = this.deviceDetail;
            if (iNOSSettingDetail2 != null && (audioTypeInfoLiveData = iNOSSettingDetail2.getAudioTypeInfoLiveData()) != null) {
                audioTypeInfoLiveData.observe((LifecycleOwner) activity, new NtEarPlugin$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NtEarPlugin.onAttachSettingsInterface$lambda$37(this.f$0, (ListNOSProfileInfo) obj);
                    }
                }));
            }
            INOSSettingDetail iNOSSettingDetail3 = this.deviceDetail;
            if (iNOSSettingDetail3 != null && (headerInfoLiveData = iNOSSettingDetail3.getHeaderInfoLiveData()) != null) {
                headerInfoLiveData.observe((LifecycleOwner) activity, new NtEarPlugin$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NtEarPlugin.onAttachSettingsInterface$lambda$41(this.f$0, (HeaderInfoEntity) obj);
                    }
                }));
            }
        }
        if ((activity instanceof INOSSettingSpatial) && (activity instanceof FlutterActivity)) {
            this.mainSpatial = (INOSSettingSpatial) activity;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachSettingsInterface$lambda$34(NtEarPlugin ntEarPlugin, ListNOSProfileInfo listNOSProfileInfo) {
        if (listNOSProfileInfo == null || listNOSProfileInfo.getAddress().length() == 0) {
            return Unit.INSTANCE;
        }
        NtEarFlutterApi ntEarFlutterApi = ntEarPlugin.flutterApi;
        if (ntEarFlutterApi != null) {
            ntEarFlutterApi.updateProfilesInfo(listNOSProfileInfo.getAddress(), listNOSProfileInfo.getProfileList(), new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarPlugin.onAttachSettingsInterface$lambda$34$lambda$33((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachSettingsInterface$lambda$34$lambda$33(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachSettingsInterface$lambda$37(NtEarPlugin ntEarPlugin, final ListNOSProfileInfo listNOSProfileInfo) {
        if (listNOSProfileInfo == null || listNOSProfileInfo.getAddress().length() == 0) {
            return Unit.INSTANCE;
        }
        NtEarFlutterApi ntEarFlutterApi = ntEarPlugin.flutterApi;
        if (ntEarFlutterApi != null) {
            ntEarFlutterApi.updateAudioDeviceType(listNOSProfileInfo.getAddress(), listNOSProfileInfo.getProfileList(), new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarPlugin.onAttachSettingsInterface$lambda$37$lambda$36(listNOSProfileInfo, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachSettingsInterface$lambda$37$lambda$36(ListNOSProfileInfo listNOSProfileInfo, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "updateAudioDeviceType " + listNOSProfileInfo.getAddress() + StringUtils.SPACE + listNOSProfileInfo;
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    public static final Unit onAttachSettingsInterface$lambda$41(NtEarPlugin ntEarPlugin, final HeaderInfoEntity headerInfoEntity) {
        boolean z;
        if (headerInfoEntity.getAddress().length() == 0) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) headerInfoEntity.getConnected(), (Object) true)) {
            HashMap<String, BluetoothDevice> connectedDevice = XBluetoothManager.INSTANCE.get().getConnectedDevice();
            if ((connectedDevice != null ? connectedDevice.get(headerInfoEntity.getAddress()) : null) != null) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "updateSettingsHeaderInfo1  " + Intrinsics.areEqual((Object) headerInfoEntity.getConnected(), (Object) true) + ", " + z;
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
        NtEarFlutterApi ntEarFlutterApi = ntEarPlugin.flutterApi;
        if (ntEarFlutterApi != null) {
            ntEarFlutterApi.updateSettingsHeaderInfo(headerInfoEntity.getAddress(), new NOSHeaderInfo(headerInfoEntity.getTitle(), headerInfoEntity.getSummary(), Boolean.valueOf(Intrinsics.areEqual((Object) headerInfoEntity.getConnected(), (Object) true) && z), headerInfoEntity.getIsBusy(), Long.valueOf(headerInfoEntity.getBattery())), new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarPlugin.onAttachSettingsInterface$lambda$41$lambda$40(headerInfoEntity, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachSettingsInterface$lambda$41$lambda$40(HeaderInfoEntity headerInfoEntity, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "updateSettingsHeaderInfo  " + headerInfoEntity.getAddress() + StringUtils.SPACE + headerInfoEntity.getTitle();
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object syncAddress(Continuation<? super Unit> continuation) {
        C09661 c09661;
        Mutex mutex;
        if (continuation instanceof C09661) {
            c09661 = (C09661) continuation;
            if ((c09661.label & Integer.MIN_VALUE) != 0) {
                c09661.label -= Integer.MIN_VALUE;
            } else {
                c09661 = new C09661(continuation);
            }
        } else {
            c09661 = new C09661(continuation);
        }
        Object obj = c09661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09661.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.mutex;
            c09661.L$0 = mutex2;
            c09661.label = 1;
            if (mutex2.lock(null, c09661) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) c09661.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            Set<BluetoothDevice> boundDevice = XBluetoothManager.INSTANCE.get().getBoundDevice();
            if (boundDevice != null) {
                List<DeviceItem> allDeviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getAllDeviceItem();
                Set<BluetoothDevice> set = boundDevice;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(((BluetoothDevice) it.next()).getAddress());
                }
                List list = CollectionsKt.toList(arrayList);
                ArrayList arrayList2 = new ArrayList();
                for (DeviceItem deviceItem : allDeviceItem) {
                    if (!list.contains(deviceItem.getAddress())) {
                        arrayList2.add(deviceItem.getAddress());
                        IOTDeviceManager.INSTANCE.removeMacAddressDevice(deviceItem.getAddress());
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        onAttachedToActivity(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.deviceDetail = null;
        this.mainSpatial = null;
        this.magicButtonApi.onDetachedFromActivity();
        ActivityPluginBinding activityPluginBinding = this.activityBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this);
        }
        this.activityBinding = null;
        FlutterRouterManager.INSTANCE.get().addEarInterceptor(null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$getMimiData$1, reason: invalid class name */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$getMimiData$1", f = "NtEarPlugin.kt", i = {}, l = {1000}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<NtEarMimiData>, Unit> $callback;
        final /* synthetic */ String $modelId;
        final /* synthetic */ String $realMac;
        int label;
        final /* synthetic */ NtEarPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, String str2, NtEarPlugin ntEarPlugin, Function1<? super Result<NtEarMimiData>, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$realMac = str;
            this.$modelId = str2;
            this.this$0 = ntEarPlugin;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$realMac, this.$modelId, this.this$0, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object mimiData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SpUtils spUtils = SpUtils.INSTANCE;
                String str = this.$realMac;
                if (str == null) {
                    str = "";
                }
                spUtils.setSelectDeviceMac(str);
                SpUtils spUtils2 = SpUtils.INSTANCE;
                String str2 = this.$modelId;
                spUtils2.setCurrentModel(str2 != null ? str2 : "");
                this.label = 1;
                mimiData = MimiManager.INSTANCE.getMimiData(this.this$0.getProtocol(), false, this);
                if (mimiData == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mimiData = obj;
            }
            MimiData mimiData2 = (MimiData) mimiData;
            if (mimiData2 != null) {
                Function1<Result<NtEarMimiData>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                boolean enable = mimiData2.getEnable();
                boolean presetIsNull = mimiData2.getPresetIsNull();
                boolean isShowRicher = mimiData2.getIsShowRicher();
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(new NtEarMimiData(Boxing.boxBoolean(enable), Boxing.boxLong(mimiData2.getProgress()), Boxing.boxBoolean(presetIsNull), Boxing.boxBoolean(mimiData2.getIsShowSofter()), Boxing.boxBoolean(mimiData2.getIsShowRecommend()), Boxing.boxBoolean(isShowRicher), MimiType.INSTANCE.ofRaw(mimiData2.getSelectedTab())))));
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getMimiData(String realMac, String modelId, Function1<? super Result<NtEarMimiData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(realMac, modelId, this, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$setMiniEnable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$setMiniEnable$1", f = "NtEarPlugin.kt", i = {}, l = {1024}, m = "invokeSuspend", n = {}, s = {})
    static final class C09651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ NtEarPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09651(boolean z, NtEarPlugin ntEarPlugin, Continuation<? super C09651> continuation) {
            super(2, continuation);
            this.$enable = z;
            this.this$0 = ntEarPlugin;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09651(this.$enable, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MimiManager.INSTANCE.changeEnable(this.$enable, this.this$0.getProtocol(), this) == coroutine_suspended) {
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
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void setMiniEnable(boolean enable, String realMac, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09651(enable, this, null), 3, null);
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getDeviceUniqueId(Function1<? super Result<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(OTANetHelper.INSTANCE.getOnlyID())));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isSupportGPT(String mac, Function1<? super Result<Boolean>, Unit> callback) {
        Object objM6347constructorimpl;
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        VoiceAssistantUtil.INSTANCE.initParameters(mac);
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean zIsSupportFeatureOfNothing = NothingOSUtil.INSTANCE.isNothingOS() ? NothingOSUtil.INSTANCE.isSupportFeatureOfNothing("NTF_BT_GPT") : false;
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zIsSupportFeatureOfNothing))));
            objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m6350exceptionOrNullimpl(objM6347constructorimpl) != null) {
            Result.Companion companion4 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isVoiceAssistantInstalled(Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean zIsInstall = VoiceAssistantUtil.INSTANCE.isInstall();
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zIsInstall))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isVoiceAssistantSupported(Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean zIsVersionSupport = VoiceAssistantUtil.INSTANCE.isVersionSupport();
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zIsVersionSupport))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isShowVoiceAssistantTips(Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean zIsShowDeviceTips = VoiceAssistantUtil.INSTANCE.isShowDeviceTips();
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zIsShowDeviceTips))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isSGPTSelected(String mac, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z = VoiceAssistantUtil.INSTANCE.isSelectChatGpt() && VoiceAssistantUtil.INSTANCE.isGptEnable();
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(z))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void hasNewsWidget(Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Application application = AppGlobals.INSTANCE.get();
        boolean zHasNothingAiNews = application != null ? RouterFactory.INSTANCE.getWidgetRouter().hasNothingAiNews(application) : false;
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zHasNothingAiNews))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isSupportNews(Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean zIsSupportNews = NothingOSUtil.INSTANCE.isSupportNews(AppGlobals.INSTANCE.get());
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zIsSupportNews))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void updateGptSelected(String address, boolean chatGpt, boolean showTips, Function1<? super Result<Boolean>, Unit> callback) {
        String str;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(callback, "callback");
        VoiceAssistantUtil.INSTANCE.setSelectChatGpt(chatGpt);
        Context context = this.context;
        if (context != null) {
            GptProviderHelper.INSTANCE.insertOrUpdate(context, address, chatGpt, showTips);
        }
        AppBuriedPointUtils appBuriedPointUtils = AppBuriedPointUtils.INSTANCE;
        if (chatGpt) {
            str = "1";
        } else {
            str = "0";
        }
        AppBuriedPointUtils.reportData$default(appBuriedPointUtils, new EventParams(AppBuriedPointUtils.CHANGE_CONTROL_GPT, str, AppBuriedPointUtils.VALUE_TYPE_INT), null, false, null, 14, null);
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getEarDeviceData(Function1<? super Result<? extends List<NtEarDeviceData>>, Unit> callback) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Context context = this.context;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new NtEarPlugin$getEarDeviceData$1$1(applicationContext, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$writeEventTrack$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$writeEventTrack$1", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09711(NtEvent ntEvent, Continuation<? super C09711> continuation) {
            super(2, continuation);
            this.$event = ntEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09711(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NtEvent ntEvent = this.$event;
            NtDeviceParams deviceEvent = ntEvent.getDeviceEvent();
            Object objCopy$default = null;
            if (deviceEvent != null) {
                String sn = this.$event.getDeviceEvent().getSn();
                if (sn != null) {
                    byte[] bytes = sn.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    if (bytes != null) {
                        objCopy$default = DataExtKt.toMD5(bytes);
                    }
                }
                objCopy$default = NtDeviceParams.copy$default(deviceEvent, objCopy$default, null, null, null, null, 30, null);
            }
            try {
                BigDataControl.INSTANCE.addAppEvent(NtEvent.copy$default(ntEvent, null, null, null, null, null, objCopy$default, null, 95, null));
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void writeEventTrack(NtEvent event, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), Dispatchers.getIO(), null, new C09711(event, null), 2, null);
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void uploadEventTrack(boolean forceUpload, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BigDataControl.INSTANCE.checkAndUpload(forceUpload);
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void updateEarInfo(String realMac, String modelId, NtDeviceParams device, Function1<? super Result<Boolean>, Unit> callback) {
        TWSDevice twsDevice;
        String md5;
        String sn;
        String version;
        String version2;
        boolean z;
        String str;
        String str2;
        String modelId2;
        String str3;
        String modelId3;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IOTDevice andCreateIOTDevice = IOTDeviceManager.INSTANCE.getAndCreateIOTDevice(realMac, modelId);
        if (andCreateIOTDevice != null) {
            andCreateIOTDevice.setMyMacAddress(realMac);
            twsDevice = andCreateIOTDevice.getTwsDevice();
        } else {
            twsDevice = null;
        }
        if (twsDevice != null) {
            String str4 = "";
            if (device == null || (md5 = device.getSn()) == null) {
                md5 = "";
            }
            if (md5.length() > 0) {
                byte[] bytes = md5.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                md5 = DataExtKt.toMD5(bytes);
            }
            String str5 = md5;
            if (twsDevice.getFlutterDevice() == null) {
                twsDevice.setFlutterDevice(device != null ? NtDeviceParams.copy$default(device, str5, null, null, null, null, 30, null) : null);
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str6 = "updateEarInfo first update " + realMac;
                    String str7 = str6;
                    if (str7 == null || str7.length() == 0) {
                        return;
                    }
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str8 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    FileLog.print$default(fileLog, 3, str8, tag, str6 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str6 + StringUtils.SPACE + strComponent2);
                        return;
                    }
                    return;
                }
                return;
            }
            NtDeviceParams flutterDevice = twsDevice.getFlutterDevice();
            if (flutterDevice == null || (sn = flutterDevice.getSn()) == null) {
                sn = "";
            }
            NtDeviceParams flutterDevice2 = twsDevice.getFlutterDevice();
            if (flutterDevice2 == null || (version = flutterDevice2.getVersion()) == null) {
                version = "";
            }
            if (device == null || (version2 = device.getVersion()) == null) {
                version2 = "";
            }
            if (Intrinsics.areEqual(sn, str5) || str5.length() <= 0) {
                z = false;
                str = sn;
            } else {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str9 = "updateEarInfo change sn:" + ((Object) str5) + " newSN:" + ((Object) str5);
                    String str10 = str9;
                    if (str10 != null && str10.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str11 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                        FileLog.print$default(fileLog2, 3, str11, tag2, str9 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str9 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                str = str5;
                z = true;
            }
            if (Intrinsics.areEqual(version, version2) || version2.length() <= 0) {
                str2 = version;
            } else {
                twsDevice.setVersion(version2);
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str12 = "updateEarInfo change version:" + ((Object) version2) + " newVersion:" + version2;
                    String str13 = str12;
                    if (str13 != null && str13.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str14 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                        FileLog.print$default(fileLog3, 3, str14, tag3, str12 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, str12 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                str2 = version2;
                z = true;
            }
            NtDeviceParams flutterDevice3 = twsDevice.getFlutterDevice();
            if (flutterDevice3 == null || (modelId2 = flutterDevice3.getModelId()) == null) {
                modelId2 = "";
            }
            if (device != null && (modelId3 = device.getModelId()) != null) {
                str4 = modelId3;
            }
            if (Intrinsics.areEqual(modelId2, str4) || str4.length() <= 0) {
                str3 = modelId2;
            } else {
                Logger logger4 = Logger.INSTANCE;
                String tag4 = logger4.getTAG();
                int depth4 = logger4.getDepth();
                if (logger4.isCanLogger(true)) {
                    String str15 = "updateEarInfo change modelId:" + ((Object) modelId2) + " newModelId:" + str4;
                    String str16 = str15;
                    if (str16 != null && str16.length() != 0) {
                        Pair<String, String> trace4 = logger4.getTrace(depth4);
                        String strComponent7 = trace4.component1();
                        String strComponent8 = trace4.component2();
                        FileLog fileLog4 = FileLog.INSTANCE;
                        String str17 = logger4.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str17, "format(...)");
                        FileLog.print$default(fileLog4, 3, str17, tag4, str15 + StringUtils.SPACE + strComponent8, null, 16, null);
                        if (logger4.isDebug()) {
                            Log.i(tag4 + strComponent7, str15 + StringUtils.SPACE + strComponent8);
                        }
                    }
                }
                str3 = str4;
                z = true;
            }
            if (z) {
                String str18 = str;
                String str19 = str3;
                String str20 = str2;
                twsDevice.setFlutterDevice(device != null ? NtDeviceParams.copy$default(device, str, str3, null, null, str2, 12, null) : null);
                Logger logger5 = Logger.INSTANCE;
                String tag5 = logger5.getTAG();
                int depth5 = logger5.getDepth();
                if (logger5.isCanLogger(true)) {
                    String str21 = "updateEarInfo change mac:" + realMac + " sn:" + ((Object) str18) + " version:" + ((Object) str20) + " modelId:" + ((Object) str19);
                    String str22 = str21;
                    if (str22 == null || str22.length() == 0) {
                        return;
                    }
                    Pair<String, String> trace5 = logger5.getTrace(depth5);
                    String strComponent9 = trace5.component1();
                    String strComponent10 = trace5.component2();
                    FileLog fileLog5 = FileLog.INSTANCE;
                    String str23 = logger5.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str23, "format(...)");
                    FileLog.print$default(fileLog5, 3, str23, tag5, str21 + StringUtils.SPACE + strComponent10, null, 16, null);
                    if (logger5.isDebug()) {
                        Log.i(tag5 + strComponent9, str21 + StringUtils.SPACE + strComponent10);
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.nothing.generate.NtEarNativeApi
    public void fetchEarLog(String realMac, String modelId, NtDeviceParams device, Function1<? super Result<Boolean>, Unit> callback) {
        TWSDevice twsDevice;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IOTDevice andCreateIOTDevice = IOTDeviceManager.INSTANCE.getAndCreateIOTDevice(realMac, modelId);
        NtDeviceParams ntDeviceParamsCopy$default = null;
        md5 = null;
        String md5 = null;
        if (andCreateIOTDevice != null) {
            andCreateIOTDevice.setMyMacAddress(realMac);
            twsDevice = andCreateIOTDevice.getTwsDevice();
        } else {
            twsDevice = null;
        }
        if (twsDevice != null) {
            if (device != null) {
                String sn = device.getSn();
                if (sn != null) {
                    byte[] bytes = sn.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    if (bytes != null) {
                        md5 = DataExtKt.toMD5(bytes);
                    }
                }
                ntDeviceParamsCopy$default = NtDeviceParams.copy$default(device, md5, null, null, null, null, 30, null);
            }
            twsDevice.setFlutterDevice(ntDeviceParamsCopy$default);
            BigDataControl.INSTANCE.autoFetchDelay(twsDevice);
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void nothingNewsPlay(Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.context != null) {
            NewsMedia3Manager.INSTANCE.playNothingWidget();
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        this.magicButtonApi.onActivityResult(requestCode, resultCode, data);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01e5  */
    @Override // com.nothing.generate.NtEarNativeApi
    public void getPhoneSpatialAudio(String realMac, boolean needGet, Function1<? super Result<Boolean>, Unit> callback) {
        boolean zBooleanValue;
        Object next;
        Boolean visible;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (NothingOSUtil.INSTANCE.isChina(this.context)) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
            SpUtils.INSTANCE.setPhoneSupportSpatial(0);
            return;
        }
        INOSSettingSpatial iNOSSettingSpatial = this.mainSpatial;
        Pair<Boolean, Bundle> pairIsSupportSpatial = iNOSSettingSpatial != null ? iNOSSettingSpatial.isSupportSpatial(realMac) : null;
        if (pairIsSupportSpatial != null && pairIsSupportSpatial.getFirst().booleanValue()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "getPhoneSpatialAudio support".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "getPhoneSpatialAudio support " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "getPhoneSpatialAudio support " + strComponent2);
                }
            }
            if (needGet) {
                INOSSettingSpatial iNOSSettingSpatial2 = this.mainSpatial;
                if (iNOSSettingSpatial2 != null) {
                    iNOSSettingSpatial2.getPhoneSpatialStatus(realMac);
                }
                if (this.deviceDetail == null) {
                    INOSSettingSpatial iNOSSettingSpatial3 = this.mainSpatial;
                    parserProfileList(realMac, iNOSSettingSpatial3 != null ? iNOSSettingSpatial3.getMainProfileStatus(realMac) : null);
                }
            }
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
            return;
        }
        if ((pairIsSupportSpatial != null ? pairIsSupportSpatial.getSecond() : null) == null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "getPhoneSpatialAudio not support".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 3, str2, tag2, "getPhoneSpatialAudio not support " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "getPhoneSpatialAudio not support " + strComponent4);
                }
            }
            SpUtils.INSTANCE.setPhoneSupportSpatial(0);
            Result.Companion companion3 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
            return;
        }
        Bundle second = pairIsSupportSpatial.getSecond();
        if (second != null) {
            second.setClassLoader(getClass().getClassLoader());
        }
        ArrayList<ProfileItemInfo> arrayListProfileItemInfos = profileItemInfos(pairIsSupportSpatial.getSecond());
        if (arrayListProfileItemInfos != null) {
            Iterator<T> it = arrayListProfileItemInfos.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((ProfileItemInfo) next).getKey(), XSettingsConstants.SPATIAL_AUDIO));
            ProfileItemInfo profileItemInfo = (ProfileItemInfo) next;
            if (profileItemInfo == null || (visible = profileItemInfo.getVisible()) == null) {
                zBooleanValue = false;
            } else {
                zBooleanValue = visible.booleanValue();
            }
        } else {
            zBooleanValue = false;
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str3 = "getPhoneSpatialAudio support " + zBooleanValue;
            String str4 = str3;
            if (str4 != null && str4.length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str5 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                FileLog.print$default(fileLog3, 3, str5, tag3, str3 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str3 + StringUtils.SPACE + strComponent6);
                }
            }
        }
        if (zBooleanValue) {
            SpUtils.INSTANCE.setPhoneSupportSpatial(1);
            updateSettingSpatial(realMac, pairIsSupportSpatial.getSecond());
            if (needGet) {
                INOSSettingSpatial iNOSSettingSpatial4 = this.mainSpatial;
                if (iNOSSettingSpatial4 != null) {
                    iNOSSettingSpatial4.getPhoneSpatialStatus(realMac);
                }
                if (this.deviceDetail == null) {
                    INOSSettingSpatial iNOSSettingSpatial5 = this.mainSpatial;
                    parserProfileList(realMac, iNOSSettingSpatial5 != null ? iNOSSettingSpatial5.getMainProfileStatus(realMac) : null);
                }
            }
        } else {
            SpUtils.INSTANCE.setPhoneSupportSpatial(0);
        }
        Result.Companion companion4 = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zBooleanValue))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void setPhoneSpatialAudio(String realMac, long status, long lastStatus, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "getPhoneSpatialAudio setPhoneSpatialAudio " + status;
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
        INOSSettingSpatial iNOSSettingSpatial = this.mainSpatial;
        if (iNOSSettingSpatial != null) {
            iNOSSettingSpatial.setPhoneSpatialStatus(realMac, (int) status, (int) lastStatus);
        }
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getHeaderInfo(String realMac, Function1<? super Result<NOSHeaderInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "getHeaderInfo realMac:" + realMac;
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
        INOSSettingDetail iNOSSettingDetail = this.deviceDetail;
        if (iNOSSettingDetail != null) {
            iNOSSettingDetail.getHeaderInfo(realMac);
        }
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(null)));
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$getFastPairedIdByMac$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$getFastPairedIdByMac$2", f = "NtEarPlugin.kt", i = {}, l = {1323, 1343}, m = "invokeSuspend", n = {}, s = {})
    static final class C09592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<String>, Unit> $callback;
        final /* synthetic */ String $realMac;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09592(String str, Function1<? super Result<String>, Unit> function1, Continuation<? super C09592> continuation) {
            super(2, continuation);
            this.$realMac = str;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new C09592(this.$realMac, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09592) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, new com.nothing.nt_ear.NtEarPlugin.C09592.AnonymousClass1(r5, (java.lang.String) r8, r7.$realMac, null), r7) == r0) goto L15;
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
                obj = TimeoutKt.withTimeoutOrNull(2000L, new NtEarPlugin$getFastPairedIdByMac$2$fastPairId$1(NtEarPlugin.this, this.$realMac, null), this);
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
            MainCoroutineDispatcher main = Dispatchers.getMain();
            Function1<Result<String>, Unit> function1 = this.$callback;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$getFastPairedIdByMac$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarPlugin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$getFastPairedIdByMac$2$1", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<String>, Unit> $callback;
            final /* synthetic */ String $fastPairId;
            final /* synthetic */ String $realMac;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super Result<String>, Unit> function1, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$fastPairId = str;
                this.$realMac = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$callback, this.$fastPairId, this.$realMac, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Logger logger = Logger.INSTANCE;
                String str = this.$fastPairId;
                String str2 = this.$realMac;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str3 = "getFastPairedIdByMac result fastPairId:" + str + "  " + str2;
                    String str4 = str3;
                    if (str4 != null && str4.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str5 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        FileLog.print$default(fileLog, 3, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                Function1<Result<String>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(this.$fastPairId)));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getFastPairedIdByMac(String realMac, Function1<? super Result<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "getFastPairedIdByMac realMac:" + realMac + StringUtils.SPACE;
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
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09592(realMac, callback, null), 3, null);
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void forgetByOS(String realMac, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "forgetByOS  " + realMac;
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
        if (realMac.length() == 0) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
            return;
        }
        NtCaseBleApi ntCaseBleApi = this.ntCaseBleApi;
        if (ntCaseBleApi != null) {
            ntCaseBleApi.clearBindingForEar(realMac, "forgetByOS");
        }
        Result.Companion companion2 = Result.INSTANCE;
        INOSSettingDetail iNOSSettingDetail = this.deviceDetail;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(iNOSSettingDetail != null && iNOSSettingDetail.forgetByOS(realMac)))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void disconnectByOS(String realMac, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "disconnectByOS  " + realMac;
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
        if (realMac.length() != 0) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09582(realMac, callback, null), 3, null);
        } else {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$disconnectByOS$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$disconnectByOS$2", f = "NtEarPlugin.kt", i = {}, l = {1369}, m = "invokeSuspend", n = {}, s = {})
    static final class C09582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        final /* synthetic */ String $realMac;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09582(String str, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super C09582> continuation) {
            super(2, continuation);
            this.$realMac = str;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new C09582(this.$realMac, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                INOSSettingDetail deviceDetail = NtEarPlugin.this.getDeviceDetail();
                boolean z = false;
                if (deviceDetail != null && deviceDetail.disconnectByOS(this.$realMac)) {
                    z = true;
                }
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$callback, z, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$disconnectByOS$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarPlugin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$disconnectByOS$2$1", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
            final /* synthetic */ boolean $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super Result<Boolean>, Unit> function1, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$result = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$callback, this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Result<Boolean>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boxing.boxBoolean(this.$result))));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void connectByOS(String realMac, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "connectByOS  " + realMac;
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
        if (realMac.length() != 0) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09572(realMac, callback, null), 3, null);
        } else {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$connectByOS$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$connectByOS$2", f = "NtEarPlugin.kt", i = {}, l = {1383}, m = "invokeSuspend", n = {}, s = {})
    static final class C09572 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        final /* synthetic */ String $realMac;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09572(String str, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super C09572> continuation) {
            super(2, continuation);
            this.$realMac = str;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new C09572(this.$realMac, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09572) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                INOSSettingDetail deviceDetail = NtEarPlugin.this.getDeviceDetail();
                boolean z = false;
                if (deviceDetail != null && deviceDetail.connectByOS(this.$realMac)) {
                    z = true;
                }
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$callback, z, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$connectByOS$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarPlugin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$connectByOS$2$1", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
            final /* synthetic */ boolean $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super Result<Boolean>, Unit> function1, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$result = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$callback, this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Result<Boolean>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boxing.boxBoolean(this.$result))));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getProfilesInfo(String realMac, Function1<? super Result<? extends List<NOSProfileInfo>>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "getProfileInfo realMac:" + realMac;
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
        INOSSettingDetail iNOSSettingDetail = this.deviceDetail;
        if (iNOSSettingDetail != null) {
            iNOSSettingDetail.getProfileInfo(realMac);
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getAudioDeviceType(String realMac, Function1<? super Result<? extends List<NOSProfileInfo>>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "getAudioDeviceType realMac:" + realMac;
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
        INOSSettingDetail iNOSSettingDetail = this.deviceDetail;
        if (iNOSSettingDetail != null) {
            iNOSSettingDetail.getAudioDeviceType(realMac);
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void setAudioDeviceType(String realMac, NOSProfileInfo info, Function1<? super Result<Boolean>, Unit> callback) {
        INOSSettingDetail iNOSSettingDetail;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "setAudioDeviceType realMac:" + realMac + ",info:" + (info != null ? info.getKey() : null) + " enable:" + (info != null ? info.getEnable() : null);
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
        if (info == null || (iNOSSettingDetail = this.deviceDetail) == null) {
            return;
        }
        iNOSSettingDetail.setAudioDeviceType(realMac, info);
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getSpatialInfo(String realMac, Function1<? super Result<? extends List<NOSProfileInfo>>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "getSpatialInfo mainSpatial is null:" + (this.deviceDetail == null);
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
        INOSSettingDetail iNOSSettingDetail = this.deviceDetail;
        if (iNOSSettingDetail != null) {
            iNOSSettingDetail.getSpatialInfo(realMac);
        }
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(null)));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void setProfileInfo(String realMac, NOSProfileInfo info, Function1<? super Result<Boolean>, Unit> callback) {
        INOSSettingDetail iNOSSettingDetail;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "setProfileInfo realMac:" + realMac + ",info:" + (info != null ? info.getKey() : null) + " enable:" + (info != null ? info.getEnable() : null);
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
        if (info == null || (iNOSSettingDetail = this.deviceDetail) == null) {
            return;
        }
        iNOSSettingDetail.setProfileInfo(realMac, info);
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void setSpatialInfo(String realMac, NOSProfileInfo info, Function1<? super Result<Boolean>, Unit> callback) {
        INOSSettingDetail iNOSSettingDetail;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "setSpatialInfo realMac:" + realMac + ",info:" + (info != null ? info.getKey() : null) + " enable:" + (info != null ? info.getEnable() : null);
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
        if (info == null || (iNOSSettingDetail = this.deviceDetail) == null) {
            return;
        }
        iNOSSettingDetail.setSpatialInfo(realMac, info);
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void setBluetoothAlias(String realMac, String alias, Function1<? super Result<Boolean>, Unit> callback) {
        INOSSettingDetail iNOSSettingDetail;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "setBluetoothAlias realMac:" + realMac + ",alias:" + alias;
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
        if (alias == null || (iNOSSettingDetail = this.deviceDetail) == null) {
            return;
        }
        iNOSSettingDetail.setBluetoothAlias(realMac, alias);
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isSupportEssentialSpace(Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean zIsSupportEssential = NothingOSUtil.INSTANCE.isSupportEssential();
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "test_record isSupportEssentialSpace".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "test_record isSupportEssentialSpace " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "test_record isSupportEssentialSpace " + strComponent2);
            }
        }
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zIsSupportEssential))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isSupportEssentialVoice(Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean zIsSupportEssentialVoice = NothingOSUtil.INSTANCE.isSupportEssentialVoice();
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "isSupportEssentialVoice:" + zIsSupportEssentialVoice;
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
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(zIsSupportEssentialVoice))));
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$updateWhiteListConfigs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$updateWhiteListConfigs$1", f = "NtEarPlugin.kt", i = {0, 0}, l = {1537}, m = "invokeSuspend", n = {"oldProduct", "whiteListConfigsToSave"}, s = {"L$0", "L$1"})
    static final class C09691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $configs;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ NtEarPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09691(String str, NtEarPlugin ntEarPlugin, Continuation<? super C09691> continuation) {
            super(2, continuation);
            this.$configs = str;
            this.this$0 = ntEarPlugin;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09691(this.$configs, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:103:0x052d  */
        /* JADX WARN: Code duplicated, block: B:104:0x052f A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:106:0x0555 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:111:0x05a8 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:114:0x060b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:115:0x060c A[EDGE_INSN: B:115:0x060c->B:116:0x060d BREAK  A[LOOP:0: B:58:0x02ad->B:200:0x02ad]] */
        /* JADX WARN: Code duplicated, block: B:117:0x0610 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x0631  */
        /* JADX WARN: Code duplicated, block: B:122:0x0633 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:124:0x064f A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:129:0x06a2 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:133:0x06e7 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:139:0x0707 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:141:0x071f  */
        /* JADX WARN: Code duplicated, block: B:142:0x0721 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:144:0x0743 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:149:0x0791 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:182:0x06fe A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:183:0x0361 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:184:0x02da A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:186:0x02d9 A[ADDED_TO_REGION, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:188:0x0336 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:189:0x0421 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:190:0x0380 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:191:0x02c6 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:192:0x037e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:193:0x03a2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:196:0x03f6 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:197:0x036b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:198:0x051a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:199:0x061e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:201:0x02ad A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:203:0x02ad A[ADDED_TO_REGION, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:204:0x02ad A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:208:0x02ad A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:214:0x06f3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:216:0x06e1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:48:0x01ee  */
        /* JADX WARN: Code duplicated, block: B:60:0x02b3 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:86:0x0434  */
        /* JADX WARN: Code duplicated, block: B:87:0x0436 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:89:0x0460 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:94:0x04b3 A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:97:0x04ed A[Catch: Exception -> 0x0864, TryCatch #1 {Exception -> 0x0864, blocks: (B:6:0x0027, B:58:0x02ad, B:60:0x02b3, B:62:0x02c6, B:65:0x02da, B:68:0x02e6, B:70:0x0336, B:71:0x0361, B:73:0x036b, B:76:0x0380, B:78:0x03a2, B:81:0x03aa, B:83:0x03f6, B:84:0x0421, B:95:0x04dc, B:97:0x04ed, B:99:0x04f4, B:101:0x051a, B:112:0x05d1, B:104:0x052f, B:106:0x0555, B:109:0x055c, B:111:0x05a8, B:117:0x0610, B:119:0x061e, B:130:0x06cb, B:131:0x06e1, B:133:0x06e7, B:135:0x06f3, B:136:0x06f7, B:122:0x0633, B:124:0x064f, B:127:0x0656, B:129:0x06a2, B:87:0x0436, B:89:0x0460, B:92:0x0467, B:94:0x04b3, B:137:0x06fe, B:139:0x0707, B:142:0x0721, B:144:0x0743, B:147:0x074b, B:149:0x0791, B:11:0x0037, B:22:0x00db, B:24:0x00e5, B:33:0x0163, B:27:0x00f9, B:30:0x0104, B:32:0x0142, B:35:0x0166, B:37:0x017e, B:38:0x018a, B:40:0x0190, B:41:0x01a0, B:43:0x01a6, B:45:0x01b8, B:46:0x01cc, B:57:0x029a, B:49:0x01f2, B:51:0x021c, B:54:0x0223, B:56:0x0271, B:151:0x07bd, B:162:0x085e, B:154:0x07d2, B:156:0x07e8, B:159:0x07ef, B:161:0x0835, B:14:0x004d, B:16:0x005f, B:19:0x0066, B:21:0x00b2, B:36:0x016b), top: B:181:0x0013, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:98:0x04f3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x060c -> B:116:0x060d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:87:0x0436
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instruction units count: 2318
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nothing.nt_ear.NtEarPlugin.C09691.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void updateWhiteListConfigs(String configs, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09691(configs, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$updateDeviceInfoList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$updateDeviceInfoList$1", f = "NtEarPlugin.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {1661, 1663}, m = "invokeSuspend", n = {"deviceMappingsToSave", "productDevice", "deviceFastPairList", "productId", "deviceMappingsToSave", "productDevice", "deviceFastPairList", "productId"}, s = {"L$0", "L$3", "L$4", "L$5", "L$0", "L$3", "L$4", "L$5"})
    static final class C09671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $configs;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ NtEarPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09671(String str, NtEarPlugin ntEarPlugin, Continuation<? super C09671> continuation) {
            super(2, continuation);
            this.$configs = str;
            this.this$0 = ntEarPlugin;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09671(this.$configs, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:102:0x039c A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:104:0x03af A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:106:0x03c1 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:107:0x03c3 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:112:0x041c A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:113:0x0447 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:115:0x044d A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:117:0x0459 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:118:0x045c  */
        /* JADX WARN: Code duplicated, block: B:120:0x045f A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x046a  */
        /* JADX WARN: Code duplicated, block: B:124:0x0493 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:126:0x04ae  */
        /* JADX WARN: Code duplicated, block: B:127:0x04af  */
        /* JADX WARN: Code duplicated, block: B:129:0x04b4 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:132:0x04d0  */
        /* JADX WARN: Code duplicated, block: B:136:0x04dc  */
        /* JADX WARN: Code duplicated, block: B:137:0x04e1  */
        /* JADX WARN: Code duplicated, block: B:138:0x04e3 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:187:0x037c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:190:0x036a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:51:0x0209 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0224 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x0236 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x023b  */
        /* JADX WARN: Code duplicated, block: B:62:0x0250 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:64:0x0258 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x025d  */
        /* JADX WARN: Code duplicated, block: B:68:0x0263 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:74:0x0276 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:76:0x027e A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:79:0x0289  */
        /* JADX WARN: Code duplicated, block: B:82:0x02ae  */
        /* JADX WARN: Code duplicated, block: B:83:0x02b0 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:85:0x02c8 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:90:0x031b A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:93:0x0355 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:96:0x0370 A[Catch: Exception -> 0x065a, TryCatch #1 {Exception -> 0x065a, blocks: (B:7:0x0036, B:100:0x0396, B:102:0x039c, B:104:0x03af, B:107:0x03c3, B:110:0x03d0, B:112:0x041c, B:113:0x0447, B:115:0x044d, B:117:0x0459, B:120:0x045f, B:122:0x046c, B:124:0x0493, B:129:0x04b4, B:49:0x0203, B:51:0x0209, B:53:0x0224, B:56:0x022c, B:58:0x0236, B:60:0x023c, B:62:0x0250, B:64:0x0258, B:66:0x025e, B:68:0x0263, B:71:0x026a, B:72:0x0272, B:74:0x0276, B:76:0x027e, B:78:0x0284, B:80:0x028a, B:83:0x02b0, B:85:0x02c8, B:88:0x02cf, B:90:0x031b, B:91:0x0344, B:93:0x0355, B:94:0x036a, B:96:0x0370, B:98:0x037c, B:99:0x0380, B:140:0x04e8, B:142:0x04f1, B:145:0x050b, B:147:0x052d, B:150:0x0535, B:152:0x0581, B:12:0x0060, B:15:0x0068, B:17:0x0072, B:26:0x00f0, B:20:0x0085, B:23:0x0090, B:25:0x00cf, B:28:0x00f3, B:30:0x010b, B:41:0x01be, B:42:0x01cb, B:44:0x01d1, B:46:0x01e2, B:47:0x01ec, B:48:0x01f2, B:33:0x011f, B:35:0x013f, B:38:0x0147, B:40:0x0195, B:154:0x05ad, B:165:0x0654, B:157:0x05c2, B:159:0x05d8, B:162:0x05df, B:164:0x062b, B:29:0x00f8), top: B:184:0x0014, inners: #0 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARN: Type inference failed for: r12v20, types: [int] */
        /* JADX WARN: Type inference failed for: r12v33, types: [T, com.nothing.device.IOTProductDevice] */
        /* JADX WARN: Type inference failed for: r12v43 */
        /* JADX WARN: Type inference failed for: r12v9, types: [T, com.nothing.device.IOTProductDevice] */
        /* JADX WARN: Type inference failed for: r13v8, types: [T, com.nothing.earbase.unknown.device.UnknownProduct] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:132:0x04d0 -> B:133:0x04d1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x04d4 -> B:135:0x04d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x04e1 -> B:139:0x04e4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0380 -> B:100:0x0396). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:190:0x036a
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 1802
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nothing.nt_ear.NtEarPlugin.C09671.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void updateDeviceInfoList(String configs, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09671(configs, this, null), 3, null);
    }

    private final boolean isNativelyConfiguredModel(String modelId) {
        IOTDevice infoByModelId;
        return (StringsKt.isBlank(modelId) || (infoByModelId = IOTDeviceManager.INSTANCE.getInfoByModelId(modelId)) == null || (infoByModelId instanceof UnknownDevice) || (infoByModelId instanceof NewSkuDevice)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isNativeProductForModel(String modelId) {
        IOTProductDevice productByModelId;
        if (StringsKt.isBlank(modelId) || (productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(modelId)) == null) {
            return false;
        }
        return !(productByModelId instanceof UnknownProduct);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01bf, code lost:
    
        if (r0.addIotDevice(r24, r2, r3, r4, r5, r6) == r8) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0344, code lost:
    
        if (r2.setNewEarImage(r1, r3, r11, r6) == r8) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleNewDevice(IOTProductDevice iOTProductDevice, UnknownProjectInfo unknownProjectInfo, String str, Continuation<? super Unit> continuation) {
        C09611 c09611;
        NewSkuDevice newSkuDevice;
        IOTProductDevice iOTProductDevice2 = iOTProductDevice;
        if (continuation instanceof C09611) {
            c09611 = (C09611) continuation;
            if ((c09611.label & Integer.MIN_VALUE) != 0) {
                c09611.label -= Integer.MIN_VALUE;
            } else {
                c09611 = new C09611(continuation);
            }
        } else {
            c09611 = new C09611(continuation);
        }
        C09611 c09612 = c09611;
        Object obj = c09612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09612.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NewSkuDevice newSkuDevice2 = (NewSkuDevice) c09612.L$1;
            IOTProductDevice iOTProductDevice3 = (IOTProductDevice) c09612.L$0;
            ResultKt.throwOnFailure(obj);
            newSkuDevice = newSkuDevice2;
            iOTProductDevice2 = iOTProductDevice3;
            iOTProductDevice2.getDeviceList().add(newSkuDevice);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (iOTProductDevice2 instanceof UnknownProduct) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "unknown_widget_sku_update newProject projectId:" + iOTProductDevice2.getProductId() + ", fastPairId:" + str;
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            com.nothing.base.util.Logger logger2 = com.nothing.base.util.Logger.INSTANCE;
            Logger logger3 = Logger.INSTANCE;
            com.nothing.base.util.Logger logger4 = logger2;
            String tag2 = logger4.getTAG();
            int depth2 = logger4.getDepth();
            if (logger4.isCanLogger(true) && "unknown_widget_download_url first add image".length() != 0) {
                Pair<String, String> trace2 = logger4.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str5 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                FileLog.print$default(fileLog2, 3, str5, tag2, "unknown_widget_download_url first add image " + strComponent4, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag2 + strComponent3, "unknown_widget_download_url first add image " + strComponent4);
                }
            }
            IOTDeviceManager.INSTANCE.getAllFastPairMap().put(str, str);
            UnknownProduct unknownProduct = (UnknownProduct) iOTProductDevice2;
            String leftImageUrl = unknownProjectInfo.getLeftImageUrl();
            if (leftImageUrl == null) {
                leftImageUrl = "";
            }
            String rightImageUrl = unknownProjectInfo.getRightImageUrl();
            if (rightImageUrl == null) {
                rightImageUrl = "";
            }
            String globalImageUrl = unknownProjectInfo.getGlobalImageUrl();
            if (globalImageUrl == null) {
                globalImageUrl = "";
            }
            String name = unknownProjectInfo.getName();
            if (name == null) {
                name = "";
            }
            c09612.label = 1;
        } else {
            Logger logger5 = Logger.INSTANCE;
            String tag3 = logger5.getTAG();
            int depth3 = logger5.getDepth();
            if (logger5.isCanLogger(true)) {
                String str6 = "unknown_widget newSkuDevice projectId:" + iOTProductDevice2.getProductId() + ", fastPairId:" + str;
                String str7 = str6;
                if (str7 != null && str7.length() != 0) {
                    Pair<String, String> trace3 = logger5.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str8 = logger5.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    FileLog.print$default(fileLog3, 3, str8, tag3, str6 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger5.isDebug()) {
                        Log.i(tag3 + strComponent5, str6 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            newSkuDevice = new NewSkuDevice(DeviceColor.BLACK, str, iOTProductDevice2.getProductId());
            com.nothing.base.util.Logger logger6 = com.nothing.base.util.Logger.INSTANCE;
            Logger logger7 = Logger.INSTANCE;
            com.nothing.base.util.Logger logger8 = logger6;
            String tag4 = logger8.getTAG();
            int depth4 = logger8.getDepth();
            if (logger8.isCanLogger(true) && "unknown_widget_sku add anc number".length() != 0) {
                Pair<String, String> trace4 = logger8.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str9 = logger8.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                FileLog.print$default(fileLog4, 3, str9, tag4, "unknown_widget_sku add anc number " + strComponent8, null, 16, null);
                if (logger8.isDebug()) {
                    Log.i(tag4 + strComponent7, "unknown_widget_sku add anc number " + strComponent8);
                }
            }
            boolean zSupportAdvanceEq = iOTProductDevice2.supportAdvanceEq();
            int supportANCLevel = iOTProductDevice2.getSupportANCLevel();
            String productId = iOTProductDevice2.getProductId();
            String name2 = unknownProjectInfo.getName();
            if (name2 == null) {
                name2 = "";
            }
            newSkuDevice.setDeviceConfigs(zSupportAdvanceEq, supportANCLevel, productId, name2);
            IOTDeviceManager.INSTANCE.getAllFastPairMap().put(str, str);
            String leftImageUrl2 = unknownProjectInfo.getLeftImageUrl();
            if (leftImageUrl2 == null) {
                leftImageUrl2 = "";
            }
            String rightImageUrl2 = unknownProjectInfo.getRightImageUrl();
            if (rightImageUrl2 == null) {
                rightImageUrl2 = "";
            }
            String globalImageUrl2 = unknownProjectInfo.getGlobalImageUrl();
            String str10 = globalImageUrl2 != null ? globalImageUrl2 : "";
            c09612.L$0 = iOTProductDevice2;
            c09612.L$1 = newSkuDevice;
            c09612.label = 2;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateExistingDevice(IOTProductDevice iOTProductDevice, UnknownProjectInfo unknownProjectInfo, String str, Continuation<? super Unit> continuation) {
        HashSet<IOTDevice> deviceList;
        IOTDevice infoByModelId = IOTDeviceManager.INSTANCE.getInfoByModelId(str);
        if ((infoByModelId instanceof UnknownDevice) && (iOTProductDevice instanceof UnknownProduct)) {
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            Logger logger2 = Logger.INSTANCE;
            com.nothing.base.util.Logger logger3 = logger;
            String tag = logger3.getTAG();
            int depth = logger3.getDepth();
            if (logger3.isCanLogger(true) && "unknown_widget_download_url after update image".length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str2 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog, 3, str2, tag, "unknown_widget_download_url after update image " + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, "unknown_widget_download_url after update image " + strComponent2);
                }
            }
            IOTDeviceManager.INSTANCE.getAllFastPairMap().put(str, str);
            UnknownProduct unknownProduct = (UnknownProduct) iOTProductDevice;
            String leftImageUrl = unknownProjectInfo.getLeftImageUrl();
            if (leftImageUrl == null) {
                leftImageUrl = "";
            }
            String rightImageUrl = unknownProjectInfo.getRightImageUrl();
            if (rightImageUrl == null) {
                rightImageUrl = "";
            }
            String globalImageUrl = unknownProjectInfo.getGlobalImageUrl();
            if (globalImageUrl == null) {
                globalImageUrl = "";
            }
            String name = unknownProjectInfo.getName();
            if (name == null) {
                name = "";
            }
            Object objAddIotDevice = unknownProduct.addIotDevice(str, leftImageUrl, rightImageUrl, globalImageUrl, name, continuation);
            return objAddIotDevice == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAddIotDevice : Unit.INSTANCE;
        }
        if (infoByModelId instanceof NewSkuDevice) {
            IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(str);
            IOTDevice iOTDevice = null;
            Object obj = null;
            iOTDevice = null;
            if (productByModelId != null && (deviceList = productByModelId.getDeviceList()) != null) {
                for (Object obj2 : deviceList) {
                    if (!(((IOTDevice) obj2) instanceof NewSkuDevice)) {
                        obj = obj2;
                        break;
                    }
                }
                iOTDevice = (IOTDevice) obj;
            }
            if (iOTDevice != null) {
                com.nothing.base.util.Logger logger4 = com.nothing.base.util.Logger.INSTANCE;
                Logger logger5 = Logger.INSTANCE;
                com.nothing.base.util.Logger logger6 = logger4;
                String tag2 = logger6.getTAG();
                int depth2 = logger6.getDepth();
                if (logger6.isCanLogger(true) && "unknown_widget_sku updateDeviceInfoList add anc number".length() != 0) {
                    Pair<String, String> trace2 = logger6.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str3 = logger6.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog2, 3, str3, tag2, "unknown_widget_sku updateDeviceInfoList add anc number " + strComponent4, null, 16, null);
                    if (logger6.isDebug()) {
                        Log.i(tag2 + strComponent3, "unknown_widget_sku updateDeviceInfoList add anc number " + strComponent4);
                    }
                }
                NewSkuDevice newSkuDevice = (NewSkuDevice) infoByModelId;
                boolean zIsSupportAdvanceEQ = iOTDevice.isSupportAdvanceEQ();
                int aNCLevel = iOTDevice.getANCLevel("");
                String modelId = unknownProjectInfo.getModelId();
                String name2 = unknownProjectInfo.getName();
                if (name2 == null) {
                    name2 = "";
                }
                newSkuDevice.setDeviceConfigs(zIsSupportAdvanceEQ, aNCLevel, modelId, name2);
            }
            IOTDeviceManager.INSTANCE.getAllFastPairMap().put(str, str);
            NewSkuDevice newSkuDevice2 = (NewSkuDevice) infoByModelId;
            String leftImageUrl2 = unknownProjectInfo.getLeftImageUrl();
            if (leftImageUrl2 == null) {
                leftImageUrl2 = "";
            }
            String rightImageUrl2 = unknownProjectInfo.getRightImageUrl();
            if (rightImageUrl2 == null) {
                rightImageUrl2 = "";
            }
            String globalImageUrl2 = unknownProjectInfo.getGlobalImageUrl();
            Object newEarImage = newSkuDevice2.setNewEarImage(leftImageUrl2, rightImageUrl2, globalImageUrl2 != null ? globalImageUrl2 : "", continuation);
            return newEarImage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? newEarImage : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void startRecorderService(Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectSkyWalk(final Context context) {
        NtEarFlutterApi ntEarFlutterApi = this.flutterApi;
        if (ntEarFlutterApi != null) {
            ntEarFlutterApi.importDevice(new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarPlugin.connectSkyWalk$lambda$96(context, (Result) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0079  */
    public static final Unit connectSkyWalk$lambda$96(Context context, Result result) {
        Iterator it;
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            Iterator it2 = ((List) value).iterator();
            while (it2.hasNext()) {
                NtEarDeviceData ntEarDeviceData = (NtEarDeviceData) it2.next();
                XBluetoothManager xBluetoothManager = XBluetoothManager.INSTANCE.get();
                String realMac = ntEarDeviceData.getRealMac();
                if (realMac == null) {
                    realMac = "";
                }
                XConnectorDevice.spp$default(xBluetoothManager.getDevice(realMac), null, null, 0, new XDefaultParser(), 7, null).addDeviceSateChange();
                IOTDeviceManager iOTDeviceManager = IOTDeviceManager.INSTANCE;
                String realMac2 = ntEarDeviceData.getRealMac();
                if (realMac2 == null) {
                    realMac2 = "";
                }
                String fastPairID = ntEarDeviceData.getFastPairID();
                IOTDevice andCreateIOTDevice = iOTDeviceManager.getAndCreateIOTDevice(realMac2, fastPairID != null ? fastPairID : "");
                TWSDevice twsDevice = andCreateIOTDevice != null ? andCreateIOTDevice.getTwsDevice() : null;
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "SkyWalk-Record connectSkyWalk twsDevice:" + twsDevice;
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        it = it2;
                    } else {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        it = it2;
                        FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                } else {
                    it = it2;
                }
                if (twsDevice != null && twsDevice.isConnected()) {
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str4 = "SkyWalk-Record connectSkyWalk device:" + ntEarDeviceData.getRealMac();
                        String str5 = str4;
                        if (str5 != null && str5.length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str6 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                            FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                            }
                        }
                    }
                    SkyWalkUtil.connectToDevice$default(SkyWalkUtil.INSTANCE, context, twsDevice.getDevice(), false, 4, null);
                }
                it2 = it;
            }
        }
        Result.m6350exceptionOrNullimpl(result.getValue());
        return Unit.INSTANCE;
    }

    public final void importDevice(final Function1<? super Map<String, NtEarDeviceData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "importDevice start " + this.flutterApi;
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
        NtEarFlutterApi ntEarFlutterApi = this.flutterApi;
        if (ntEarFlutterApi != null) {
            ntEarFlutterApi.importDevice(new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarPlugin.importDevice$lambda$102(callback, (Result) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit importDevice$lambda$102(Function1 function1, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "importDevice callback".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "importDevice callback " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "importDevice callback " + strComponent2);
            }
        }
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            List list = (List) value;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                String realMac = ((NtEarDeviceData) obj).getRealMac();
                if (realMac == null) {
                    realMac = "";
                }
                linkedHashMap.put(realMac, obj);
            }
            function1.invoke(MapsKt.toMap(linkedHashMap));
        }
        if (Result.m6350exceptionOrNullimpl(result.getValue()) != null) {
            function1.invoke(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0183  */
    public final void updateSettingSpatial(final String address, Bundle audioInfo) {
        boolean zBooleanValue;
        Object next;
        Object next2;
        int i;
        Boolean checked;
        Boolean checked2;
        Object next3;
        Boolean visible;
        if (audioInfo != null) {
            audioInfo.setClassLoader(getClass().getClassLoader());
        }
        ArrayList<ProfileItemInfo> arrayListProfileItemInfos = profileItemInfos(audioInfo);
        if (address != null) {
            ArrayList arrayList = new ArrayList();
            boolean z = true;
            if (arrayListProfileItemInfos != null) {
                Iterator it = arrayListProfileItemInfos.iterator();
                while (it.hasNext()) {
                    ProfileItemInfo profileItemInfo = (ProfileItemInfo) it.next();
                    if (profileItemInfo != null) {
                        String title = profileItemInfo.getTitle();
                        Boolean checked3 = profileItemInfo.getChecked();
                        Boolean enable = profileItemInfo.getEnable();
                        Map mapEmptyMap = MapsKt.emptyMap();
                        String groupTitle = profileItemInfo.getGroupTitle();
                        String string = profileItemInfo.getExtras().getString(XSettingsConstants.SUB_TITLE);
                        Boolean hasDialog = profileItemInfo.getHasDialog();
                        String key = profileItemInfo.getKey();
                        Integer ordinal = profileItemInfo.getOrdinal();
                        arrayList.add(new NOSProfileInfo(checked3, enable, mapEmptyMap, groupTitle, string, hasDialog, key, ordinal != null ? Long.valueOf(ordinal.intValue()) : null, title, profileItemInfo.getVisible()));
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "updateSettingSpatial updateAudioInfo key:" + profileItemInfo.getKey() + ",checked:" + profileItemInfo.getChecked();
                            String str2 = str;
                            if (!(str2 == null || str2.length() == 0)) {
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
                    } else {
                        it = it;
                    }
                    it = it;
                }
            }
            NtEarFlutterApi ntEarFlutterApi = this.flutterApi;
            if (ntEarFlutterApi != null) {
                ntEarFlutterApi.updateSpatialInfo(address, arrayList, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NtEarPlugin.updateSettingSpatial$lambda$106(address, (Result) obj);
                    }
                });
            }
            if (arrayListProfileItemInfos != null) {
                Iterator<T> it2 = arrayListProfileItemInfos.iterator();
                do {
                    if (!it2.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it2.next();
                } while (!Intrinsics.areEqual(((ProfileItemInfo) next3).getKey(), XSettingsConstants.SPATIAL_AUDIO));
                ProfileItemInfo profileItemInfo2 = (ProfileItemInfo) next3;
                if (profileItemInfo2 == null || (visible = profileItemInfo2.getVisible()) == null) {
                    zBooleanValue = false;
                } else {
                    zBooleanValue = visible.booleanValue();
                }
            } else {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                ArrayList<ProfileItemInfo> arrayList2 = arrayListProfileItemInfos;
                Iterator<T> it3 = arrayList2.iterator();
                do {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                } while (!Intrinsics.areEqual(((ProfileItemInfo) next).getKey(), XSettingsConstants.SPATIAL_AUDIO));
                ProfileItemInfo profileItemInfo3 = (ProfileItemInfo) next;
                boolean zBooleanValue2 = (profileItemInfo3 == null || (checked2 = profileItemInfo3.getChecked()) == null) ? false : checked2.booleanValue();
                Iterator<T> it4 = arrayList2.iterator();
                do {
                    if (!it4.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it4.next();
                } while (!Intrinsics.areEqual(((ProfileItemInfo) next2).getKey(), XSettingsConstants.HEAD_TRACK));
                ProfileItemInfo profileItemInfo4 = (ProfileItemInfo) next2;
                boolean zBooleanValue3 = (profileItemInfo4 == null || (checked = profileItemInfo4.getChecked()) == null) ? false : checked.booleanValue();
                if (zBooleanValue2) {
                    i = zBooleanValue3 ? 2 : 1;
                } else {
                    i = 0;
                }
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "updatePhoneSpatial status:" + i;
                    String str5 = str4;
                    if (str5 != null && str5.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str6 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                        FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                NtEarFlutterApi ntEarFlutterApi2 = this.flutterApi;
                if (ntEarFlutterApi2 != null) {
                    ntEarFlutterApi2.updatePhoneSpatialAudio(address, i, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NtEarPlugin.updateSettingSpatial$lambda$111((Result) obj);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSettingSpatial$lambda$106(String str, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "updateSettingSpatial updateAudioInfo  " + str;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSettingSpatial$lambda$111(Result result) {
        return Unit.INSTANCE;
    }

    public final void hasDevices(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        NtEarFlutterApi ntEarFlutterApi = this.flutterApi;
        if (ntEarFlutterApi != null) {
            ntEarFlutterApi.hasDevices(new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarPlugin.hasDevices$lambda$114(callback, (Result) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hasDevices$lambda$114(Function1 function1, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            function1.invoke(Boolean.valueOf(((Boolean) value).booleanValue()));
        }
        if (Result.m6350exceptionOrNullimpl(result.getValue()) != null) {
            function1.invoke(false);
        }
        return Unit.INSTANCE;
    }

    public final void updatePhoneSpatial(String realMac, int status) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        NtEarFlutterApi ntEarFlutterApi = this.flutterApi;
        if (ntEarFlutterApi != null) {
            ntEarFlutterApi.updatePhoneSpatialAudio(realMac, status, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarPlugin.updatePhoneSpatial$lambda$115((Result) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updatePhoneSpatial$lambda$115(Result result) {
        return Unit.INSTANCE;
    }

    public final ArrayList<ProfileItemInfo> profileItemInfos(Bundle bundle) {
        ArrayList<ProfileItemInfo> parcelableArrayList;
        if (Build.VERSION.SDK_INT < 33) {
            return (bundle == null || (parcelableArrayList = bundle.getParcelableArrayList(XSettingsConstants.AUDIO_LIST)) == null) ? new ArrayList<>() : parcelableArrayList;
        }
        boolean z = bundle != null ? bundle.getBoolean("spatial_and_head_track") : false;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "profileItemInfos spatial_and_head_track:" + z;
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
        SpUtils.INSTANCE.setNewInterfaceSpatial(z);
        if (bundle != null) {
            return bundle.getParcelableArrayList(XSettingsConstants.AUDIO_LIST, ProfileItemInfo.class);
        }
        return null;
    }

    public final void parserProfileList(String address, Bundle profilesInfo) {
        ArrayList<ProfileItemInfo> parcelableArrayList;
        Intrinsics.checkNotNullParameter(address, "address");
        if (address.length() == 0 || profilesInfo == null) {
            return;
        }
        profilesInfo.setClassLoader(getClass().getClassLoader());
        if (Build.VERSION.SDK_INT >= 33) {
            parcelableArrayList = profilesInfo.getParcelableArrayList(XSettingsConstants.PROFILE_LIST, ProfileItemInfo.class);
        } else {
            parcelableArrayList = profilesInfo.getParcelableArrayList(XSettingsConstants.PROFILE_LIST);
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList();
            }
        }
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayList != null) {
            for (ProfileItemInfo profileItemInfo : parcelableArrayList) {
                if (profileItemInfo != null) {
                    String title = profileItemInfo.getTitle();
                    Boolean checked = profileItemInfo.getChecked();
                    Boolean enable = profileItemInfo.getEnable();
                    Map mapEmptyMap = MapsKt.emptyMap();
                    String groupTitle = profileItemInfo.getGroupTitle();
                    Boolean hasDialog = profileItemInfo.getHasDialog();
                    String key = profileItemInfo.getKey();
                    Integer ordinal = profileItemInfo.getOrdinal();
                    arrayList.add(new NOSProfileInfo(checked, enable, mapEmptyMap, groupTitle, "", hasDialog, key, ordinal != null ? Long.valueOf(ordinal.intValue()) : null, title, profileItemInfo.getVisible()));
                }
            }
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C09642(new ListNOSProfileInfo(address, arrayList), null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$parserProfileList$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$parserProfileList$2", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ListNOSProfileInfo $newProfiles;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09642(ListNOSProfileInfo listNOSProfileInfo, Continuation<? super C09642> continuation) {
            super(2, continuation);
            this.$newProfiles = listNOSProfileInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new C09642(this.$newProfiles, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NtEarFlutterApi flutterApi = NtEarPlugin.this.getFlutterApi();
            if (flutterApi != null) {
                String address = this.$newProfiles.getAddress();
                List<NOSProfileInfo> profileList = this.$newProfiles.getProfileList();
                final ListNOSProfileInfo listNOSProfileInfo = this.$newProfiles;
                flutterApi.updateProfilesInfo(address, profileList, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$parserProfileList$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtEarPlugin.C09642.invokeSuspend$lambda$1(listNOSProfileInfo, (Result) obj2);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(ListNOSProfileInfo listNOSProfileInfo, Result result) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "updateProfilesInfo  " + listNOSProfileInfo.getAddress();
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
            return Unit.INSTANCE;
        }
    }

    public final void checkOTA(String mac, String modelId, String version, final Function1<? super ApiResult<ServerFirmware>, Unit> action) {
        String productId;
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(action, "action");
        NtEarFlutterApi ntEarFlutterApi = this.flutterApi;
        if (ntEarFlutterApi != null) {
            String strReplace$default = StringsKt.replace$default(mac, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null);
            IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(modelId);
            if (productByModelId == null || (productId = productByModelId.getProductId()) == null) {
                productId = "";
            }
            ntEarFlutterApi.checkOta(strReplace$default, productId, version, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarPlugin.checkOTA$lambda$120(action, (Result) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkOTA$lambda$120(Function1 function1, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            Object value2 = result.getValue();
            if (Result.m6353isFailureimpl(value2)) {
                value2 = null;
            }
            Map map = (Map) value2;
            if (map == null || map.isEmpty() || !Result.m6354isSuccessimpl(result.getValue())) {
                function1.invoke(new ApiResult.Failure(-1, null, "request fail"));
            } else {
                Object obj = map.get("needUpdate");
                function1.invoke(new ApiResult.Success(new ServerFirmware(obj != null ? AnyExtKt.toInt(obj) : 0, String.valueOf(map.get("otaUrl")), String.valueOf(map.get("version")), String.valueOf(map.get("description")), String.valueOf(map.get("fileSize")), String.valueOf(map.get("sha256")))));
            }
        }
        if (Result.m6350exceptionOrNullimpl(result.getValue()) != null) {
            function1.invoke(new ApiResult.Failure(-1, null, "channal fail"));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$getWatchBattery$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$getWatchBattery$2", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09602 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09602(String str, Continuation<? super C09602> continuation) {
            super(2, continuation);
            this.$address = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new C09602(this.$address, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09602) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NtEarFlutterApi flutterApi = NtEarPlugin.this.getFlutterApi();
            if (flutterApi != null) {
                String str = this.$address;
                final NtEarPlugin ntEarPlugin = NtEarPlugin.this;
                flutterApi.getWatchBatteryInfo(str, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$getWatchBattery$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtEarPlugin.C09602.invokeSuspend$lambda$3(ntEarPlugin, (Result) obj2);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$3(NtEarPlugin ntEarPlugin, Result result) {
            Object value = result.getValue();
            if (Result.m6354isSuccessimpl(value)) {
                BatteryInfo batteryInfo = (BatteryInfo) value;
                Context context = ntEarPlugin.getContext();
                if (context != null) {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "get watch battery from flutter battery:" + (batteryInfo != null ? batteryInfo.getBattery() : null) + " ,charging:" + (batteryInfo != null ? batteryInfo.getCharging() : null);
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
                    XViewServiceImpl.INSTANCE.getInstance(context).callbackWatchBattery(batteryInfo);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void getWatchBattery(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "get WatchBatteryInfo from flutter " + address;
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
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C09602(address, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0023  */
    @Override // com.nothing.generate.NtEarNativeApi
    public void notifyWatchBattery(BatteryInfo info, Function1<? super Result<Boolean>, Unit> callback) {
        boolean z;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            boolean z2 = this.context != null;
            String str = "receive WatchBatteryInfo " + z2 + " ," + info.getAddress() + ",battery:" + info.getBattery() + ",charging:" + info.getCharging() + ",modelId:" + info.getModelId() + ",fastPairId:" + info.getFastPairId() + ",colorId:" + info.getColorId();
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                z = true;
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            z = true;
        }
        Context context = this.context;
        if (context != null) {
            XViewServiceImpl.INSTANCE.getInstance(context).callbackWatchBattery(info);
        }
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(z))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getDeviceInfo(Function1<? super Result<NtDeviceInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(new NtDeviceInfo(PhoneUtil.INSTANCE.getOsVersion(), PhoneUtil.INSTANCE.getCategory(), PhoneUtil.INSTANCE.getBrandName(), PhoneUtil.INSTANCE.getModelName(), "", PhoneUtil.INSTANCE.getHardWareModel(), "Android", PhoneUtil.INSTANCE.getOperatingVersion(), PhoneUtil.INSTANCE.generateUniqueDeviceId(), PhoneUtil.INSTANCE.getLanguage(), PhoneUtil.INSTANCE.getRamSize(), ""))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void isExtraDarkMode(Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        Context context = this.context;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(Settings.Secure.getInt(context != null ? context.getContentResolver() : null, NtWidgetPlugin.EXTRA_DARK_MODE_SETTING, 0) == 1))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void updateCaseOTAProgress(long progress, boolean isSuccess, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "OTA_Progress progress:" + progress + ",isInvite:" + isSuccess;
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
        OTAHelper.INSTANCE.setOTANotificationProgress((int) progress, isSuccess);
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void checkUpdateTime(Function1<? super Result<Boolean>, Unit> callback) {
        boolean z;
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Context context = this.context;
            PackageManager packageManager = context != null ? context.getPackageManager() : null;
            Context context2 = this.context;
            PackageInfo packageInfo = (context2 == null || packageManager == null) ? null : packageManager.getPackageInfo(context2.getPackageName(), 0);
            Long lValueOf = packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null;
            Long lValueOf2 = packageInfo != null ? Long.valueOf(packageInfo.lastUpdateTime) : null;
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            com.nothing.base.util.Logger logger2 = logger;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger2.isCanLogger(true)) {
                String str = "firstInstallTime:" + this.dateFormat.format(lValueOf) + ",lastUpdateTime:" + this.dateFormat.format(lValueOf2) + ",currentTime:" + this.dateFormat.format(Long.valueOf(jCurrentTimeMillis));
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger2.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            z = lValueOf != null && lValueOf2 != null && lValueOf.longValue() + this.INSTALL_MIN_TIME < jCurrentTimeMillis && lValueOf2.longValue() + this.INSTALL_MIN_TIME < jCurrentTimeMillis;
        } catch (Exception unused) {
        }
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(z))));
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void showRemoteRateDialog(final Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ActivityPluginBinding activityPluginBinding = this.activityBinding;
        Activity activity = activityPluginBinding != null ? activityPluginBinding.getActivity() : null;
        if (activity == null) {
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "google_score showRemoteRateDialog activity == null".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "google_score showRemoteRateDialog activity == null " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "google_score showRemoteRateDialog activity == null " + strComponent2);
                }
            }
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
            return;
        }
        com.nothing.base.util.Logger logger2 = com.nothing.base.util.Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true) && "google_score startGoogleScore before".length() != 0) {
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str2 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            FileLog.print$default(fileLog2, 3, str2, tag2, "google_score startGoogleScore before " + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, "google_score startGoogleScore before " + strComponent4);
            }
        }
        RouterFactory.INSTANCE.getGlobalRouter().startGoogleScore(activity, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NtEarPlugin.showRemoteRateDialog$lambda$130(this.f$0, callback, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRemoteRateDialog$lambda$130(NtEarPlugin ntEarPlugin, Function1 function1, boolean z) {
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "google_score startGoogleScore finish result: " + z;
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
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boolean.valueOf(z))));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void getRemoteConfigValue(String key, final Function1<? super Result<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RouterFactory.INSTANCE.getGlobalRouter().getRemoteConfigValue(key, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NtEarPlugin.getRemoteConfigValue$lambda$131(callback, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getRemoteConfigValue$lambda$131(Function1 function1, String str) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(str)));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void forgetDevice(String mac, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        INOSSettingSpatial iNOSSettingSpatial = this.mainSpatial;
        if (iNOSSettingSpatial != null) {
            iNOSSettingSpatial.forgetDevice(mac);
        }
    }

    @Override // com.nothing.generate.NtEarNativeApi
    public void withdrawConsent(Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ActivityPluginBinding activityPluginBinding = this.activityBinding;
        Activity activity = activityPluginBinding != null ? activityPluginBinding.getActivity() : null;
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09702(callback, activity, null), 3, null);
            return;
        }
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "withdrawConsent activity == null".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "withdrawConsent activity == null " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "withdrawConsent activity == null " + strComponent2);
            }
        }
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$withdrawConsent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$withdrawConsent$2", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09702 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09702(Function1<? super Result<Unit>, Unit> function1, Activity activity, Continuation<? super C09702> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09702 c09702 = new C09702(this.$callback, this.$activity, continuation);
            c09702.L$0 = obj;
            return c09702;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09702) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0144  */
        /* JADX WARN: Code duplicated, block: B:51:0x030f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM6347constructorimpl;
            Object objM6347constructorimpl2;
            Throwable th;
            Throwable th2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Activity activity = this.$activity;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    MagicDatabase.INSTANCE.getInstance(activity).clearAllTables();
                    NewsConfigDatabase.INSTANCE.getInstance(activity).clearAllTables();
                    ProductDatabase.INSTANCE.getInstance(activity).clearAllTables();
                    ScoreDatabase.INSTANCE.getInstance(activity).clearAllTables();
                    SmartDatabase.INSTANCE.getInstance(activity).clearAllTables();
                    SmartVoiceDatabase.INSTANCE.getInstance(activity).clearAllTables();
                    UserDatabase.INSTANCE.getInstance(activity).clearAllTables();
                    MacCacheDataBase.INSTANCE.getInstance(activity).clearAllTables();
                    EventDatabase.INSTANCE.getInstance(activity).clearAllTables();
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true) && "withdrawConsent \u6e05\u9664\u6240\u6709\u6570\u636e\u5e93\u8868".length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        FileLog.print$default(fileLog, 3, str, tag, "withdrawConsent \u6e05\u9664\u6240\u6709\u6570\u636e\u5e93\u8868 " + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, "withdrawConsent \u6e05\u9664\u6240\u6709\u6570\u636e\u5e93\u8868 " + strComponent2);
                        }
                    }
                    objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
                } catch (Throwable th3) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th3));
                }
                Function1<Result<Unit>, Unit> function1 = this.$callback;
                Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
                if (thM6350exceptionOrNullimpl != null) {
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str2 = "Failed to clear database tables: " + thM6350exceptionOrNullimpl.getMessage();
                        String str3 = str2;
                        if (str3 == null || str3.length() == 0) {
                            th2 = thM6350exceptionOrNullimpl;
                        } else {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str4 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                            th2 = thM6350exceptionOrNullimpl;
                            FileLog.print$default(fileLog2, 6, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.e(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                            }
                        }
                    } else {
                        th2 = thM6350exceptionOrNullimpl;
                    }
                    Result.Companion companion3 = Result.INSTANCE;
                    function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(th2))));
                }
                Activity activity2 = this.$activity;
                try {
                    Result.Companion companion4 = Result.INSTANCE;
                    MagicDatabase.INSTANCE.getInstance(activity2).close();
                    NewsConfigDatabase.INSTANCE.getInstance(activity2).close();
                    ProductDatabase.INSTANCE.getInstance(activity2).close();
                    ScoreDatabase.INSTANCE.getInstance(activity2).close();
                    SmartDatabase.INSTANCE.getInstance(activity2).close();
                    SmartVoiceDatabase.INSTANCE.getInstance(activity2).close();
                    UserDatabase.INSTANCE.getInstance(activity2).close();
                    MacCacheDataBase.INSTANCE.getInstance(activity2).close();
                    EventDatabase.INSTANCE.getInstance(activity2).close();
                    Logger logger3 = Logger.INSTANCE;
                    String tag3 = logger3.getTAG();
                    int depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true) && "withdrawConsent \u5173\u95ed\u6570\u636e\u5e93\u8fde\u63a5".length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str5 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        FileLog.print$default(fileLog3, 3, str5, tag3, "withdrawConsent \u5173\u95ed\u6570\u636e\u5e93\u8fde\u63a5 " + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, "withdrawConsent \u5173\u95ed\u6570\u636e\u5e93\u8fde\u63a5 " + strComponent6);
                        }
                    }
                    objM6347constructorimpl2 = Result.m6347constructorimpl(Unit.INSTANCE);
                } catch (Throwable th4) {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM6347constructorimpl2 = Result.m6347constructorimpl(ResultKt.createFailure(th4));
                }
                Function1<Result<Unit>, Unit> function2 = this.$callback;
                Throwable thM6350exceptionOrNullimpl2 = Result.m6350exceptionOrNullimpl(objM6347constructorimpl2);
                if (thM6350exceptionOrNullimpl2 != null) {
                    Logger logger4 = Logger.INSTANCE;
                    String tag4 = logger4.getTAG();
                    int depth4 = logger4.getDepth();
                    if (logger4.isCanLogger(true)) {
                        String str6 = "Failed to close databases: " + thM6350exceptionOrNullimpl2.getMessage();
                        String str7 = str6;
                        if (str7 == null || str7.length() == 0) {
                            th = thM6350exceptionOrNullimpl2;
                        } else {
                            Pair<String, String> trace4 = logger4.getTrace(depth4);
                            String strComponent7 = trace4.component1();
                            String strComponent8 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str8 = logger4.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                            th = thM6350exceptionOrNullimpl2;
                            FileLog.print$default(fileLog4, 6, str8, tag4, str6 + StringUtils.SPACE + strComponent8, null, 16, null);
                            if (logger4.isDebug()) {
                                Log.e(tag4 + strComponent7, str6 + StringUtils.SPACE + strComponent8);
                            }
                        }
                    } else {
                        th = thM6350exceptionOrNullimpl2;
                    }
                    Result.Companion companion6 = Result.INSTANCE;
                    function2.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(th))));
                }
                Function1<Result<Unit>, Unit> function3 = this.$callback;
                Result.Companion companion7 = Result.INSTANCE;
                function3.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
            } catch (Exception e) {
                Logger logger5 = Logger.INSTANCE;
                String tag5 = logger5.getTAG();
                int depth5 = logger5.getDepth();
                if (logger5.isCanLogger(true)) {
                    String str9 = "Error during withdraw consent: " + e.getMessage();
                    String str10 = str9;
                    if (str10 != null && str10.length() != 0) {
                        Pair<String, String> trace5 = logger5.getTrace(depth5);
                        String strComponent9 = trace5.component1();
                        String strComponent10 = trace5.component2();
                        FileLog fileLog5 = FileLog.INSTANCE;
                        String str11 = logger5.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                        FileLog.print$default(fileLog5, 6, str11, tag5, str9 + StringUtils.SPACE + strComponent10, null, 16, null);
                        if (logger5.isDebug()) {
                            Log.e(tag5 + strComponent9, str9 + StringUtils.SPACE + strComponent10);
                        }
                    }
                }
                Function1<Result<Unit>, Unit> function4 = this.$callback;
                Result.Companion companion8 = Result.INSTANCE;
                function4.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(e))));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$addScore$2, reason: invalid class name */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$addScore$2", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSuccess;
        final /* synthetic */ String $productId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$isSuccess = z;
            this.$productId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new AnonymousClass2(this.$isSuccess, this.$productId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NtEarFlutterApi flutterApi = NtEarPlugin.this.getFlutterApi();
            if (flutterApi != null) {
                flutterApi.addScore(this.$isSuccess, this.$productId, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$addScore$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtEarPlugin.AnonymousClass2.invokeSuspend$lambda$0((Result) obj2);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Result result) {
            return Unit.INSTANCE;
        }
    }

    public final void addScore(boolean isSuccess, String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "get addScore from flutter " + isSuccess + StringUtils.SPACE + productId;
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
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass2(isSuccess, productId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear.NtEarPlugin$updateRemoteRateInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear.NtEarPlugin$updateRemoteRateInfo$1", f = "NtEarPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<RemoteRateInfo> $remoteRateInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09681(List<RemoteRateInfo> list, Continuation<? super C09681> continuation) {
            super(2, continuation);
            this.$remoteRateInfo = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarPlugin.this.new C09681(this.$remoteRateInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NtEarFlutterApi flutterApi = NtEarPlugin.this.getFlutterApi();
            if (flutterApi != null) {
                flutterApi.updateRemoteRateInfo(this.$remoteRateInfo, new Function1() { // from class: com.nothing.nt_ear.NtEarPlugin$updateRemoteRateInfo$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtEarPlugin.C09681.invokeSuspend$lambda$0((Result) obj2);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Result result) {
            return Unit.INSTANCE;
        }
    }

    public final void updateRemoteRateInfo(List<RemoteRateInfo> remoteRateInfo) {
        Intrinsics.checkNotNullParameter(remoteRateInfo, "remoteRateInfo");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C09681(remoteRateInfo, null), 3, null);
    }

    @Override // com.nothing.nt_system_runtime.utils.PreviewListener
    public void onChange(boolean preview) {
        Context context;
        if (preview || (context = this.context) == null) {
            return;
        }
        BaseApplication.Companion companion = BaseApplication.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.initBluetoothManager(applicationContext);
        WidgetRouter widgetRouter = RouterFactory.INSTANCE.getWidgetRouter();
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        widgetRouter.initMediaPlayer(applicationContext2);
        NewsMedia3Manager newsMedia3Manager = NewsMedia3Manager.INSTANCE;
        Context applicationContext3 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        NewsMedia3Manager.initMediaBrowserCompat$default(newsMedia3Manager, applicationContext3, false, 2, null);
        WidgetRouter widgetRouter2 = RouterFactory.INSTANCE.getWidgetRouter();
        Context applicationContext4 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext4, "getApplicationContext(...)");
        widgetRouter2.freshSqlWidget(applicationContext4);
        WalkieTalkieHelper walkieTalkieHelper = WalkieTalkieHelper.INSTANCE;
        Context applicationContext5 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext5, "getApplicationContext(...)");
        walkieTalkieHelper.registerBroadCast(applicationContext5);
    }
}
