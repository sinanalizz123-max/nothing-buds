package com.nothing.earbase.equalizer.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.util.ext.ViewModelExtKt;
import com.nothing.base.wiget.radar.EQGainDragBarViewModel;
import com.nothing.core.entity.AdvanceCustomEQEntity;
import com.nothing.core.entity.EQEntity;
import com.nothing.core.entity.EQValueEntity;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.dao.ProfileItemDao;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.entity.ProfileData;
import com.nothing.database.entity.ProfileId;
import com.nothing.database.entity.ProfileItem;
import com.nothing.database.entity.ProfileName;
import com.nothing.database.manager.SmartVoiceDatabase;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.database.util.SpUtils;
import com.nothing.device.BaseAndroidLifecycleViewModel;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.algorithm.EQAlgorithm;
import com.nothing.earbase.equalizer.algorithm.EQCoordinate;
import com.nothing.earbase.equalizer.algorithm.EQParameter;
import com.nothing.earbase.equalizer.qrcode.QRCodeUtil;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.log.FileLog;
import com.nothing.log.NTLog;
import com.nothing.log.util.AppGlobals;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import com.nothing.xservice.transform.key.ViewKey;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: AdvanceEQViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00ab\u00012\u00020\u0001:\u0002\u00ab\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010k\u001a\u00020lH\u0002J\u0006\u0010m\u001a\u00020lJ\u0006\u0010n\u001a\u00020lJ\n\u0010o\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010p\u001a\u00020lJ\u0010\u0010q\u001a\u00020l2\u0006\u0010r\u001a\u00020\bH\u0002J.\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020u0t2\u0006\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020u2\b\b\u0002\u0010x\u001a\u00020#H\u0002J\b\u0010y\u001a\u00020uH\u0002J\b\u0010z\u001a\u00020lH\u0002J$\u0010{\u001a\u00020\u00182\b\u0010r\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010|\u001a\u00020\u00182\b\b\u0002\u0010}\u001a\u00020#J\u0012\u0010~\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u007f\u001a\u00020uH\u0002J\u001b\u0010\u0080\u0001\u001a\u00020\u00182\u0007\u0010\u0081\u0001\u001a\u00020u2\u0007\u0010\u0082\u0001\u001a\u00020uH\u0002J\u0011\u0010\u0083\u0001\u001a\u00020u2\u0006\u0010v\u001a\u00020\bH\u0002J\t\u0010\u0084\u0001\u001a\u00020lH\u0002J.\u0010\u0085\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020u0t2\u0007\u0010\u0086\u0001\u001a\u00020\b2\u0006\u0010w\u001a\u00020u2\u0006\u0010x\u001a\u00020#H\u0002J\u0007\u0010\u0087\u0001\u001a\u00020lJ\u0010\u0010\u0088\u0001\u001a\u00020l2\u0007\u0010\u0089\u0001\u001a\u00020\u0014J\t\u0010\u008a\u0001\u001a\u00020lH\u0002J\u0013\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u008e\u0001\u001a\u00020l2\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u0018J\u0007\u0010\u008f\u0001\u001a\u00020lJ\u0010\u0010\u0090\u0001\u001a\u00020l2\u0007\u0010\u0091\u0001\u001a\u00020#J&\u0010\u0092\u0001\u001a\u00020l2\u0007\u0010\u0089\u0001\u001a\u00020\u00142\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u00182\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0018J\u0011\u0010\u0095\u0001\u001a\u00020l2\u0006\u0010v\u001a\u00020\bH\u0002J\u0012\u0010\u0096\u0001\u001a\u00020l2\u0007\u0010\u0097\u0001\u001a\u00020\u0018H\u0002J\u0010\u0010\u0098\u0001\u001a\u00020l2\u0007\u0010\u0089\u0001\u001a\u00020\u0014JP\u0010\u0099\u0001\u001a\u00020l2\u0006\u0010w\u001a\u00020u2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\b2\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u00182\u000e\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020l0\u009b\u00012\u000e\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020l0\u009b\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020#J\u0007\u0010\u009e\u0001\u001a\u00020\u0018J\n\u0010\u009f\u0001\u001a\u00030\u008c\u0001H\u0002J\u0007\u0010\u00a0\u0001\u001a\u00020lJ\t\u0010\u00a1\u0001\u001a\u00020lH\u0002J\u0015\u0010\u00a2\u0001\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b0tH\u0002J\u0007\u0010\u00a3\u0001\u001a\u00020lJ+\u0010\u00a4\u0001\u001a\u00020l2\"\u0010\u00a5\u0001\u001a\u001d\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b\u0018\u00010t\u0012\u0004\u0012\u00020l0\u00a6\u0001J+\u0010\u00a7\u0001\u001a\u00020l2\"\u0010\u00a5\u0001\u001a\u001d\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b\u0018\u00010t\u0012\u0004\u0012\u00020l0\u00a6\u0001J\t\u0010\u00a8\u0001\u001a\u00020lH\u0016J\u0007\u0010\u00a9\u0001\u001a\u00020lJ\u0007\u0010\u00aa\u0001\u001a\u00020lR$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0010R \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000202X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R(\u0010:\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010\u00180\u00180&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010(\"\u0004\b=\u0010*R(\u0010>\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010\u00180\u00180&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R(\u0010A\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010\u00180\u00180&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010(\"\u0004\bC\u0010*R\u001a\u0010D\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010J\"\u0004\bN\u0010LR\u001c\u0010O\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010F\"\u0004\bQ\u0010HR\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020,0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010\u001eR\u0011\u0010T\u001a\u00020U\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010J\"\u0004\b_\u0010LR\u001a\u0010`\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010J\"\u0004\ba\u0010LR\u001a\u0010b\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010J\"\u0004\bd\u0010LR\u001a\u0010e\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010J\"\u0004\bg\u0010LR\u001a\u0010h\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010J\"\u0004\bj\u0010L\u00a8\u0006\u00ac\u0001"}, d2 = {"Lcom/nothing/earbase/equalizer/viewmodel/AdvanceEQViewModel;", "Lcom/nothing/device/BaseAndroidLifecycleViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "advanceCustomEQValue", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/core/entity/EQEntity;", "getAdvanceCustomEQValue", "()Landroidx/lifecycle/LiveData;", "setAdvanceCustomEQValue", "(Landroidx/lifecycle/LiveData;)V", "notFoundLiveData", "Landroidx/lifecycle/MutableLiveData;", "getNotFoundLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setNotFoundLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "refreshDataLiveData", "Lcom/nothing/earbase/equalizer/viewmodel/ProfileViewModel;", "getRefreshDataLiveData", "setRefreshDataLiveData", "fullLiveData", "", "getFullLiveData", "setFullLiveData", "profileList", "Landroidx/databinding/ObservableArrayList;", "getProfileList", "()Landroidx/databinding/ObservableArrayList;", "coordinateLiveData", "Lcom/nothing/earbase/equalizer/algorithm/EQCoordinate;", "getCoordinateLiveData", "profileChangeLiveData", "", "getProfileChangeLiveData", "currentProfile", "Landroidx/databinding/ObservableField;", "getCurrentProfile", "()Landroidx/databinding/ObservableField;", "setCurrentProfile", "(Landroidx/databinding/ObservableField;)V", "currentGainViewModel", "Lcom/nothing/base/wiget/radar/EQGainDragBarViewModel;", "getCurrentGainViewModel", "()Lcom/nothing/base/wiget/radar/EQGainDragBarViewModel;", "setCurrentGainViewModel", "(Lcom/nothing/base/wiget/radar/EQGainDragBarViewModel;)V", "undoAlpha", "Landroidx/databinding/ObservableFloat;", "getUndoAlpha", "()Landroidx/databinding/ObservableFloat;", "setUndoAlpha", "(Landroidx/databinding/ObservableFloat;)V", "redoAlpha", "getRedoAlpha", "setRedoAlpha", "resetEnable", "kotlin.jvm.PlatformType", "getResetEnable", "setResetEnable", "frequencyEnable", "getFrequencyEnable", "setFrequencyEnable", "qEnable", "getQEnable", "setQEnable", "defaultEntity", "getDefaultEntity", "()Lcom/nothing/core/entity/EQEntity;", "setDefaultEntity", "(Lcom/nothing/core/entity/EQEntity;)V", "isExpand", "()Z", ViewKey.setExpand, "(Z)V", "isLoadDBSuccess", "setLoadDBSuccess", "tempRemoteEntity", "getTempRemoteEntity", "setTempRemoteEntity", "gainViewModels", "getGainViewModels", "selectBandTip", "Landroidx/databinding/ObservableBoolean;", "getSelectBandTip", "()Landroidx/databinding/ObservableBoolean;", "deviceItem", "Lcom/nothing/database/entity/DeviceItem;", "getDeviceItem", "()Lcom/nothing/database/entity/DeviceItem;", "setDeviceItem", "(Lcom/nothing/database/entity/DeviceItem;)V", "isInitializer", "setInitializer", "isResumeRequest", "setResumeRequest", "hasProfileChanged", "getHasProfileChanged", "setHasProfileChanged", "advanceEqEnabled", "getAdvanceEqEnabled", "setAdvanceEqEnabled", "advanceEqValueChange", "getAdvanceEqValueChange", "setAdvanceEqValueChange", "setDefaultAdvanceCustomEQValue", "", "updateTipsStatus", "showSelectBandTip", "getCurrentProfileEntity", "sendCurrentDataToDevice", "queryAndSetProfile", "it", "addProfileToDataBase", "Lkotlin/Pair;", "", "entity", "profileName", "source", "getDefaultProfileName", "deleteAllProfileData", "updateGainList", "force", "selectIndex", "findSelectedProfileItem", "currentData", "isSameProfileData", "json1", "json2", "toJson", "queryAndUpdateProfileData", "addProfileToDatabaseAndList", "eqEntity", "updateOnlyOneProfile", "updateProfileNameDataBase", "profileViewModel", "updateProfileDataBase", "isEnableDoAlpha", "", "enable", "refreshFrequencyAndQStyle", "refreshWaveChart", "onRequestData", "loadStatus", "setProfileData", "needUpdate", "needSendToDevice", "sendProfileDataToDevice", "addScore", "isSuccess", "deleteProfileData", "addProfileData", "fullAction", "Lkotlin/Function0;", "successAction", "dataSource", "isFull", "getTotalGain", "updateChange", "addHistory", "getHistoryEntity", "reset", "runUndo", "action", "Lkotlin/Function1;", "runRedo", "onCleared", "markProfileChanged", "reportIfNeeded", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdvanceEQViewModel extends BaseAndroidLifecycleViewModel {
    public static final long DURATION_TIME = 2000;
    public static final float ENABLE_ALPHA = 1.0f;
    public static final int MAX_PROFILE_LIST = 20;
    public static final float UNABLE_DO_ALPHA = 0.2f;
    private LiveData<EQEntity> advanceCustomEQValue;
    private boolean advanceEqEnabled;
    private boolean advanceEqValueChange;
    private final MutableLiveData<EQCoordinate> coordinateLiveData;
    private EQGainDragBarViewModel currentGainViewModel;
    private ObservableField<ProfileViewModel> currentProfile;
    private EQEntity defaultEntity;
    private DeviceItem deviceItem;
    private ObservableField<Boolean> frequencyEnable;
    private MutableLiveData<Boolean> fullLiveData;
    private final ObservableArrayList<EQGainDragBarViewModel> gainViewModels;
    private boolean hasProfileChanged;
    private boolean isExpand;
    private boolean isInitializer;
    private boolean isLoadDBSuccess;
    private boolean isResumeRequest;
    private MutableLiveData<EQEntity> notFoundLiveData;
    private final MutableLiveData<Integer> profileChangeLiveData;
    private final ObservableArrayList<ProfileViewModel> profileList;
    private ObservableField<Boolean> qEnable;
    private ObservableFloat redoAlpha;
    private MutableLiveData<ProfileViewModel> refreshDataLiveData;
    private ObservableField<Boolean> resetEnable;
    private final ObservableBoolean selectBandTip;
    private EQEntity tempRemoteEntity;
    private ObservableFloat undoAlpha;

    private final float isEnableDoAlpha(boolean enable) {
        return enable ? 1.0f : 0.2f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvanceEQViewModel(Application application) {
        final TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQValue$default;
        final TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQMode$default;
        LiveData map;
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.notFoundLiveData = new MutableLiveData<>();
        this.refreshDataLiveData = new MutableLiveData<>();
        this.fullLiveData = new MutableLiveData<>();
        this.profileList = new ObservableArrayList<>();
        this.coordinateLiveData = new MutableLiveData<>();
        this.profileChangeLiveData = new MutableLiveData<>();
        this.currentProfile = new ObservableField<>();
        this.undoAlpha = new ObservableFloat(0.2f);
        this.redoAlpha = new ObservableFloat(0.2f);
        this.resetEnable = new ObservableField<>(false);
        this.frequencyEnable = new ObservableField<>(false);
        this.qEnable = new ObservableField<>(false);
        this.gainViewModels = new ObservableArrayList<>();
        this.selectBandTip = new ObservableBoolean(false);
        GooglePlayScoreUtil.INSTANCE.startControl();
        queryAndUpdateProfileData();
        SmartVoiceDatabase.Companion companion = SmartVoiceDatabase.INSTANCE;
        Application application2 = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application2);
        List<DeviceItem> deviceItem = companion.getInstance(application2).getDeviceItemDao().getDeviceItem(SpUtils.INSTANCE.getSelectDeviceMac());
        LiveData<EQEntity> map2 = null;
        this.deviceItem = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderAdvanceCustomEQMode$default = TWSDeviceExtKt.advanceCustomEQMode$default(tWSDevice, null, 1, null)) != null) {
            final Class<AdvanceCustomEQEntity> cls = AdvanceCustomEQEntity.class;
            LiveData map3 = Transformations.map(tWSDeviceBuilderAdvanceCustomEQMode$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderAdvanceCustomEQMode$default.getGetCommand(), tWSDeviceBuilderAdvanceCustomEQMode$default.getNotifyCommand()), new Function1<Message, AdvanceCustomEQEntity>() { // from class: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$special$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final AdvanceCustomEQEntity invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    AdvanceCustomEQEntity advanceCustomEQEntity = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    advanceCustomEQEntity = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.core.entity.AdvanceCustomEQEntity");
                                }
                                obj = (AdvanceCustomEQEntity) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            advanceCustomEQEntity = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            advanceCustomEQEntity = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + advanceCustomEQEntity + StringUtils.SPACE;
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    return advanceCustomEQEntity;
                }
            });
            if (map3 != null && (map = Transformations.map(map3, new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(AdvanceEQViewModel._init_$lambda$0((AdvanceCustomEQEntity) obj));
                }
            })) != null) {
                map.observe(this, new AdvanceEQViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AdvanceEQViewModel._init_$lambda$1(this.f$0, (Boolean) obj);
                    }
                }));
            }
        }
        this.defaultEntity = new EQEntity(0, getTotalGain());
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 != null && (tWSDeviceBuilderAdvanceCustomEQValue$default = TWSDeviceExtKt.advanceCustomEQValue$default(tWSDevice2, 0, null, 3, null)) != null) {
            final Class<EQEntity> cls2 = EQEntity.class;
            map2 = Transformations.map(tWSDeviceBuilderAdvanceCustomEQValue$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderAdvanceCustomEQValue$default.getGetCommand(), tWSDeviceBuilderAdvanceCustomEQValue$default.getNotifyCommand()), new Function1<Message, EQEntity>() { // from class: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$special$$inlined$getLiveData$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final EQEntity invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    EQEntity eQEntity = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    eQEntity = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls3 = cls2;
                        try {
                            if (Intrinsics.areEqual(cls3, Integer.TYPE)) {
                                obj = (EQEntity) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls3, Long.TYPE)) {
                                obj = (EQEntity) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls3, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.core.entity.EQEntity");
                                }
                                obj = (EQEntity) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls3, Boolean.TYPE)) {
                                obj = (EQEntity) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls3, Float.TYPE)) {
                                obj = (EQEntity) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls3.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            eQEntity = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            eQEntity = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls4 = cls2;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls4 + StringUtils.SPACE + eQEntity + StringUtils.SPACE;
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    return eQEntity;
                }
            });
        }
        this.advanceCustomEQValue = map2;
        if (map2 != null) {
            map2.observe(this, new AdvanceEQViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AdvanceEQViewModel._init_$lambda$12(this.f$0, (EQEntity) obj);
                }
            }));
        }
    }

    public final LiveData<EQEntity> getAdvanceCustomEQValue() {
        return this.advanceCustomEQValue;
    }

    public final void setAdvanceCustomEQValue(LiveData<EQEntity> liveData) {
        this.advanceCustomEQValue = liveData;
    }

    public final MutableLiveData<EQEntity> getNotFoundLiveData() {
        return this.notFoundLiveData;
    }

    public final void setNotFoundLiveData(MutableLiveData<EQEntity> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.notFoundLiveData = mutableLiveData;
    }

    public final MutableLiveData<ProfileViewModel> getRefreshDataLiveData() {
        return this.refreshDataLiveData;
    }

    public final void setRefreshDataLiveData(MutableLiveData<ProfileViewModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.refreshDataLiveData = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getFullLiveData() {
        return this.fullLiveData;
    }

    public final void setFullLiveData(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.fullLiveData = mutableLiveData;
    }

    public final ObservableArrayList<ProfileViewModel> getProfileList() {
        return this.profileList;
    }

    public final MutableLiveData<EQCoordinate> getCoordinateLiveData() {
        return this.coordinateLiveData;
    }

    public final MutableLiveData<Integer> getProfileChangeLiveData() {
        return this.profileChangeLiveData;
    }

    public final ObservableField<ProfileViewModel> getCurrentProfile() {
        return this.currentProfile;
    }

    public final void setCurrentProfile(ObservableField<ProfileViewModel> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.currentProfile = observableField;
    }

    public final EQGainDragBarViewModel getCurrentGainViewModel() {
        return this.currentGainViewModel;
    }

    public final void setCurrentGainViewModel(EQGainDragBarViewModel eQGainDragBarViewModel) {
        this.currentGainViewModel = eQGainDragBarViewModel;
    }

    public final ObservableFloat getUndoAlpha() {
        return this.undoAlpha;
    }

    public final void setUndoAlpha(ObservableFloat observableFloat) {
        Intrinsics.checkNotNullParameter(observableFloat, "<set-?>");
        this.undoAlpha = observableFloat;
    }

    public final ObservableFloat getRedoAlpha() {
        return this.redoAlpha;
    }

    public final void setRedoAlpha(ObservableFloat observableFloat) {
        Intrinsics.checkNotNullParameter(observableFloat, "<set-?>");
        this.redoAlpha = observableFloat;
    }

    public final ObservableField<Boolean> getResetEnable() {
        return this.resetEnable;
    }

    public final void setResetEnable(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.resetEnable = observableField;
    }

    public final ObservableField<Boolean> getFrequencyEnable() {
        return this.frequencyEnable;
    }

    public final void setFrequencyEnable(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.frequencyEnable = observableField;
    }

    public final ObservableField<Boolean> getQEnable() {
        return this.qEnable;
    }

    public final void setQEnable(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.qEnable = observableField;
    }

    public final EQEntity getDefaultEntity() {
        return this.defaultEntity;
    }

    public final void setDefaultEntity(EQEntity eQEntity) {
        Intrinsics.checkNotNullParameter(eQEntity, "<set-?>");
        this.defaultEntity = eQEntity;
    }

    /* JADX INFO: renamed from: isExpand, reason: from getter */
    public final boolean getIsExpand() {
        return this.isExpand;
    }

    public final void setExpand(boolean z) {
        this.isExpand = z;
    }

    /* JADX INFO: renamed from: isLoadDBSuccess, reason: from getter */
    public final boolean getIsLoadDBSuccess() {
        return this.isLoadDBSuccess;
    }

    public final void setLoadDBSuccess(boolean z) {
        this.isLoadDBSuccess = z;
    }

    public final EQEntity getTempRemoteEntity() {
        return this.tempRemoteEntity;
    }

    public final void setTempRemoteEntity(EQEntity eQEntity) {
        this.tempRemoteEntity = eQEntity;
    }

    public final ObservableArrayList<EQGainDragBarViewModel> getGainViewModels() {
        return this.gainViewModels;
    }

    public final ObservableBoolean getSelectBandTip() {
        return this.selectBandTip;
    }

    public final DeviceItem getDeviceItem() {
        return this.deviceItem;
    }

    public final void setDeviceItem(DeviceItem deviceItem) {
        this.deviceItem = deviceItem;
    }

    /* JADX INFO: renamed from: isInitializer, reason: from getter */
    public final boolean getIsInitializer() {
        return this.isInitializer;
    }

    public final void setInitializer(boolean z) {
        this.isInitializer = z;
    }

    /* JADX INFO: renamed from: isResumeRequest, reason: from getter */
    public final boolean getIsResumeRequest() {
        return this.isResumeRequest;
    }

    public final void setResumeRequest(boolean z) {
        this.isResumeRequest = z;
    }

    public final boolean getHasProfileChanged() {
        return this.hasProfileChanged;
    }

    public final void setHasProfileChanged(boolean z) {
        this.hasProfileChanged = z;
    }

    public final boolean getAdvanceEqEnabled() {
        return this.advanceEqEnabled;
    }

    public final void setAdvanceEqEnabled(boolean z) {
        this.advanceEqEnabled = z;
    }

    public final boolean getAdvanceEqValueChange() {
        return this.advanceEqValueChange;
    }

    public final void setAdvanceEqValueChange(boolean z) {
        this.advanceEqValueChange = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(AdvanceCustomEQEntity advanceCustomEQEntity) {
        return (advanceCustomEQEntity != null ? advanceCustomEQEntity.getModel() : null) == AdvanceCustomEQEntity.Mode.ON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(AdvanceEQViewModel advanceEQViewModel, Boolean bool) {
        advanceEQViewModel.advanceEqEnabled = bool.booleanValue();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x046e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0483  */
    /* JADX WARN: Code duplicated, block: B:111:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:4:0x0021 A[PHI: r7
      0x0021: PHI (r7v28 ??) = (r7v30 ??), (r7v31 ??), (r7v32 ??) binds: [B:3:0x001f, B:6:0x0038, B:8:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x0386 A[Catch: all -> 0x0450, TryCatch #0 {all -> 0x0450, blocks: (B:71:0x0382, B:73:0x0386, B:76:0x03aa, B:78:0x03c6, B:81:0x03cd, B:66:0x034a, B:68:0x0353), top: B:114:0x034a }] */
    /* JADX WARN: Code duplicated, block: B:75:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:76:0x03aa A[Catch: all -> 0x0450, TryCatch #0 {all -> 0x0450, blocks: (B:71:0x0382, B:73:0x0386, B:76:0x03aa, B:78:0x03c6, B:81:0x03cd, B:66:0x034a, B:68:0x0353), top: B:114:0x034a }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0448 A[Catch: all -> 0x045a, TryCatch #1 {all -> 0x045a, blocks: (B:86:0x0444, B:88:0x044c, B:92:0x0455, B:83:0x03ee, B:85:0x041b, B:87:0x0448), top: B:116:0x00ca }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static final Unit _init_$lambda$12(AdvanceEQViewModel advanceEQViewModel, EQEntity eQEntity) {
        String str;
        ?? r7;
        String str2;
        String str3;
        Object objM6347constructorimpl;
        ?? r8;
        Throwable thM6350exceptionOrNullimpl;
        Logger logger;
        String tag;
        int depth;
        String str4;
        String str5;
        String strComponent1;
        String strComponent2;
        EQEntity eQEntity2;
        String str6;
        String str7;
        Logger logger2;
        String str8;
        String str9;
        Object objLaunch$default;
        Logger logger3 = Logger.INSTANCE;
        String tag2 = logger3.getTAG();
        int depth2 = logger3.getDepth();
        boolean zIsCanLogger = logger3.isCanLogger(true);
        ?? r9 = zIsCanLogger;
        if (zIsCanLogger) {
            str = " advanceCustomEQValue listener   -> " + eQEntity;
            String str10 = str;
            if (str10 == null || str10.length() == 0) {
                r9 = str;
                r9 = str;
                r9 = str;
                str2 = "isLoadDBSuccess ";
                str3 = StringUtils.SPACE;
                r7 = r9;
            } else {
                Pair<String, String> trace = logger3.getTrace(depth2);
                String strComponent3 = trace.component1();
                String strComponent4 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str11 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                String str12 = str + StringUtils.SPACE + strComponent4;
                r7 = 4;
                r7 = 4;
                str2 = "isLoadDBSuccess ";
                str3 = StringUtils.SPACE;
                FileLog.print$default(fileLog, 4, str11, tag2, str12, null, 16, null);
                if (logger3.isDebug()) {
                    r9 = str;
                    r9 = str;
                    Log.i(tag2 + strComponent3, str + str3 + strComponent4);
                }
            }
        } else {
            r9 = str;
            r9 = str;
            r9 = str;
            str2 = "isLoadDBSuccess ";
            str3 = StringUtils.SPACE;
            r7 = r9;
        }
        try {
            r9 = str;
            r9 = str;
            Result.Companion companion = Result.INSTANCE;
            Object obj = null;
            try {
                if (eQEntity == null) {
                    r7 = "format(...)";
                } else {
                    if (eQEntity.getIsInitializer()) {
                        if (advanceEQViewModel.isResumeRequest) {
                            advanceEQViewModel.setDefaultAdvanceCustomEQValue();
                        } else {
                            advanceEQViewModel.isInitializer = true;
                            Logger logger4 = Logger.INSTANCE;
                            Logger logger5 = logger4;
                            String tag3 = logger4.getTAG();
                            int depth3 = logger4.getDepth();
                            if (logger5.isCanLogger(true) && "advanceCustomEQValue wait change to advance tab,then set default vaule".length() != 0) {
                                Pair<String, String> trace2 = logger5.getTrace(depth3);
                                String strComponent5 = trace2.component1();
                                String strComponent6 = trace2.component2();
                                FileLog fileLog2 = FileLog.INSTANCE;
                                String str13 = logger5.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                                FileLog.print$default(fileLog2, 4, str13, tag3, "advanceCustomEQValue wait change to advance tab,then set default vaule " + strComponent6, null, 16, null);
                                if (logger5.isDebug()) {
                                    Log.i(tag3 + strComponent5, "advanceCustomEQValue wait change to advance tab,then set default vaule " + strComponent6);
                                }
                            }
                        }
                        objLaunch$default = Unit.INSTANCE;
                    } else if (eQEntity.getProfileIndex() != 0) {
                        Logger logger6 = Logger.INSTANCE;
                        Logger logger7 = logger6;
                        String tag4 = logger6.getTAG();
                        int depth4 = logger6.getDepth();
                        if (logger7.isCanLogger(true) && "changeProfile 0".length() != 0) {
                            Pair<String, String> trace3 = logger7.getTrace(depth4);
                            String strComponent7 = trace3.component1();
                            String strComponent8 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str14 = logger7.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                            FileLog.print$default(fileLog3, 4, str14, tag4, "changeProfile 0 " + strComponent8, null, 16, null);
                            if (logger7.isDebug()) {
                                Log.i(tag4 + strComponent7, "changeProfile 0 " + strComponent8);
                            }
                        }
                        objLaunch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(advanceEQViewModel), Dispatchers.getIO(), null, new AdvanceEQViewModel$3$2$1$3(advanceEQViewModel, null), 2, null);
                    } else {
                        Logger logger8 = Logger.INSTANCE;
                        Logger logger9 = logger8;
                        String tag5 = logger8.getTAG();
                        int depth5 = logger8.getDepth();
                        if (logger9.isCanLogger(true)) {
                            String str15 = str2 + advanceEQViewModel.isLoadDBSuccess;
                            String str16 = str15;
                            if (str16 != null && str16.length() != 0) {
                                Pair<String, String> trace4 = logger9.getTrace(depth5);
                                String strComponent9 = trace4.component1();
                                String strComponent10 = trace4.component2();
                                FileLog fileLog4 = FileLog.INSTANCE;
                                String str17 = logger9.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str17, "format(...)");
                                FileLog.print$default(fileLog4, 4, str17, tag5, str15 + str3 + strComponent10, null, 16, null);
                                if (logger9.isDebug()) {
                                    Log.i(tag5 + strComponent9, str15 + str3 + strComponent10);
                                }
                            }
                        }
                        Logger logger10 = Logger.INSTANCE;
                        Logger logger11 = logger10;
                        String tag6 = logger10.getTAG();
                        int depth6 = logger10.getDepth();
                        if (logger11.isCanLogger(true)) {
                            eQEntity2 = eQEntity;
                            String str18 = "viewmodel gainViewModels advanceCustomEQValue isLoadDBSuccess " + advanceEQViewModel.isLoadDBSuccess + ",  it:" + eQEntity2;
                            String str19 = str18;
                            if (str19 != null) {
                                try {
                                    if (str19.length() != 0) {
                                        Pair<String, String> trace5 = logger11.getTrace(depth6);
                                        String strComponent11 = trace5.component1();
                                        String strComponent12 = trace5.component2();
                                        FileLog fileLog5 = FileLog.INSTANCE;
                                        String str20 = logger11.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str20, "format(...)");
                                        str6 = "format(...)";
                                        try {
                                            FileLog.print$default(fileLog5, 3, str20, tag6, str18 + str3 + strComponent12, null, 16, null);
                                            str6 = str6;
                                            if (logger11.isDebug()) {
                                                Log.i(tag6 + strComponent11, str18 + str3 + strComponent12);
                                                str6 = str6;
                                            }
                                            if (advanceEQViewModel.isLoadDBSuccess) {
                                                eQEntity2.setTotalGain(advanceEQViewModel.getTotalGain());
                                                Logger logger12 = Logger.INSTANCE;
                                                logger2 = logger12;
                                                String tag7 = logger12.getTAG();
                                                int depth7 = logger12.getDepth();
                                                if (logger2.isCanLogger(true)) {
                                                    String str21 = "viewmodel gainViewModels advanceCustomEQValue isLoadDBSuccess " + advanceEQViewModel.isLoadDBSuccess + ",  it:" + eQEntity2;
                                                    str8 = str21;
                                                    if (str8 != null || str8.length() == 0) {
                                                        str9 = str6;
                                                    } else {
                                                        Pair<String, String> trace6 = logger2.getTrace(depth7);
                                                        String strComponent13 = trace6.component1();
                                                        String strComponent14 = trace6.component2();
                                                        FileLog fileLog6 = FileLog.INSTANCE;
                                                        String str22 = logger2.getSdf().format(new Date());
                                                        String str23 = str6;
                                                        Intrinsics.checkNotNullExpressionValue(str22, str23);
                                                        FileLog.print$default(fileLog6, 3, str22, tag7, str21 + str3 + strComponent14, null, 16, null);
                                                        str9 = str23;
                                                        if (logger2.isDebug()) {
                                                            Log.i(tag7 + strComponent13, str21 + str3 + strComponent14);
                                                            str9 = str23;
                                                        }
                                                    }
                                                } else {
                                                    str9 = str6;
                                                }
                                                advanceEQViewModel.queryAndSetProfile(eQEntity);
                                                str7 = str9;
                                            } else {
                                                str7 = str6;
                                                advanceEQViewModel.tempRemoteEntity = eQEntity2;
                                            }
                                            obj = Unit.INSTANCE;
                                            r7 = str7;
                                        } catch (Throwable th) {
                                            th = th;
                                            r7 = str6;
                                            Result.Companion companion2 = Result.INSTANCE;
                                            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
                                            r8 = r7;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str6 = "format(...)";
                                    r7 = str6;
                                    Result.Companion companion3 = Result.INSTANCE;
                                    objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
                                    r8 = r7;
                                }
                            }
                            thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
                            if (thM6350exceptionOrNullimpl != null) {
                                logger = Logger.INSTANCE;
                                tag = logger.getTAG();
                                depth = logger.getDepth();
                                if (logger.isCanLogger(true)) {
                                    str4 = "Print Unknown error,add log monitor,Message is " + thM6350exceptionOrNullimpl.getMessage();
                                    str5 = str4;
                                    if (str5 != null && str5.length() != 0) {
                                        Pair<String, String> trace7 = logger.getTrace(depth);
                                        strComponent1 = trace7.component1();
                                        strComponent2 = trace7.component2();
                                        FileLog fileLog7 = FileLog.INSTANCE;
                                        String str24 = logger.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str24, r8);
                                        FileLog.print$default(fileLog7, 4, str24, tag, str4 + str3 + strComponent2, null, 16, null);
                                        if (logger.isDebug()) {
                                            Log.i(tag + strComponent1, str4 + str3 + strComponent2);
                                        }
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        eQEntity2 = eQEntity;
                        str6 = "format(...)";
                        if (advanceEQViewModel.isLoadDBSuccess) {
                            eQEntity2.setTotalGain(advanceEQViewModel.getTotalGain());
                            Logger logger13 = Logger.INSTANCE;
                            logger2 = logger13;
                            String tag8 = logger13.getTAG();
                            int depth8 = logger13.getDepth();
                            if (logger2.isCanLogger(true)) {
                                str9 = str6;
                            } else {
                                String str25 = "viewmodel gainViewModels advanceCustomEQValue isLoadDBSuccess " + advanceEQViewModel.isLoadDBSuccess + ",  it:" + eQEntity2;
                                str8 = str25;
                                if (str8 != null) {
                                    str9 = str6;
                                } else {
                                    str9 = str6;
                                }
                            }
                            advanceEQViewModel.queryAndSetProfile(eQEntity);
                            str7 = str9;
                        } else {
                            str7 = str6;
                            advanceEQViewModel.tempRemoteEntity = eQEntity2;
                        }
                        obj = Unit.INSTANCE;
                        r7 = str7;
                    }
                    obj = objLaunch$default;
                    r7 = "format(...)";
                }
                objM6347constructorimpl = Result.m6347constructorimpl(obj);
                r8 = r7;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            r7 = "format(...)";
        }
        thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str4 = "Print Unknown error,add log monitor,Message is " + thM6350exceptionOrNullimpl.getMessage();
                str5 = str4;
                if (str5 != null) {
                    Pair<String, String> trace8 = logger.getTrace(depth);
                    strComponent1 = trace8.component1();
                    strComponent2 = trace8.component2();
                    FileLog fileLog8 = FileLog.INSTANCE;
                    String str26 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str26, r8);
                    FileLog.print$default(fileLog8, 4, str26, tag, str4 + str3 + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str4 + str3 + strComponent2);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void setDefaultAdvanceCustomEQValue() {
        this.isResumeRequest = false;
        this.isInitializer = false;
        deleteAllProfileData();
        this.profileList.clear();
        EQEntity eQEntity = new EQEntity(0, getTotalGain());
        sendProfileDataToDevice(eQEntity);
        addProfileToDataBase$default(this, eQEntity, getDefaultProfileName(), 0, 4, null);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "viewmodel gainViewModels init advanceCustomEQValue refreshDataLiveData ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "viewmodel gainViewModels init advanceCustomEQValue refreshDataLiveData  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "viewmodel gainViewModels init advanceCustomEQValue refreshDataLiveData  " + strComponent2);
            }
        }
        this.refreshDataLiveData.setValue(this.currentProfile.get());
    }

    public final void updateTipsStatus() {
        DeviceItem deviceItem = this.deviceItem;
        if (deviceItem != null) {
            deviceItem.setGuideShow(true);
            SmartVoiceDatabase.Companion companion = SmartVoiceDatabase.INSTANCE;
            Application application = AppGlobals.INSTANCE.get();
            Intrinsics.checkNotNull(application);
            companion.getInstance(application).getDeviceItemDao().updateDeviceItem(deviceItem);
        }
    }

    public final void showSelectBandTip() {
        if (this.selectBandTip.get()) {
            return;
        }
        this.selectBandTip.set(true);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06721(null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$showSelectBandTip$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AdvanceEQViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$showSelectBandTip$1", f = "AdvanceEQViewModel.kt", i = {}, l = {191, 192}, m = "invokeSuspend", n = {}, s = {})
    static final class C06721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06721(Continuation<? super C06721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AdvanceEQViewModel.this.new C06721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel.C06721.C01341(r5.this$0, null), r5) == r0) goto L15;
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
                if (DelayKt.delay(2000L, this) != coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$showSelectBandTip$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AdvanceEQViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$showSelectBandTip$1$1", f = "AdvanceEQViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AdvanceEQViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01341(AdvanceEQViewModel advanceEQViewModel, Continuation<? super C01341> continuation) {
                super(2, continuation);
                this.this$0 = advanceEQViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01341(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getSelectBandTip().set(false);
                return Unit.INSTANCE;
            }
        }
    }

    private final ProfileViewModel getCurrentProfileEntity() {
        ProfileViewModel profileViewModel = this.currentProfile.get();
        return profileViewModel == null ? (ProfileViewModel) CollectionsKt.getOrNull(this.profileList, 0) : profileViewModel;
    }

    public final void sendCurrentDataToDevice() {
        Pair<Integer, EQEntity> currentCacheData;
        ProfileViewModel currentProfileEntity = getCurrentProfileEntity();
        if (currentProfileEntity == null || (currentCacheData = currentProfileEntity.getCurrentCacheData()) == null) {
            return;
        }
        sendProfileDataToDevice(currentCacheData.getSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryAndSetProfile(EQEntity it) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "viewmodel gainViewModels queryAndSetProfile".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "viewmodel gainViewModels queryAndSetProfile " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "viewmodel gainViewModels queryAndSetProfile " + strComponent2);
            }
        }
        if (this.profileList.isEmpty()) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "viewmodel gainViewModels profileList is empty".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 4, str2, tag2, "viewmodel gainViewModels profileList is empty " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "viewmodel gainViewModels profileList is empty " + strComponent4);
                }
            }
            addProfileToDataBase$default(this, it, getDefaultProfileName(), 0, 4, null);
            this.refreshDataLiveData.setValue(this.currentProfile.get());
            return;
        }
        ProfileViewModel profileViewModelFindSelectedProfileItem = findSelectedProfileItem(toJson(it));
        if (profileViewModelFindSelectedProfileItem == null) {
            if (this.refreshDataLiveData.getValue() == null) {
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true) && "viewmodel gainViewModels local data not show ,then show default value ".length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str3 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog3, 4, str3, tag3, "viewmodel gainViewModels local data not show ,then show default value  " + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, "viewmodel gainViewModels local data not show ,then show default value  " + strComponent6);
                    }
                }
                ProfileViewModel profileViewModel = (ProfileViewModel) CollectionsKt.first((List) this.profileList);
                if (profileViewModel != null) {
                    this.refreshDataLiveData.setValue(profileViewModel);
                    this.currentProfile.set(profileViewModel);
                }
            }
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true) && "viewmodel gainViewModels show new profile data ".length() != 0) {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str4 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog4, 4, str4, tag4, "viewmodel gainViewModels show new profile data  " + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, "viewmodel gainViewModels show new profile data  " + strComponent8);
                }
            }
            this.notFoundLiveData.setValue(it);
            return;
        }
        Logger logger5 = Logger.INSTANCE;
        String tag5 = logger5.getTAG();
        int depth5 = logger5.getDepth();
        if (logger5.isCanLogger(true) && "viewmodel gainViewModels queryAndSetProfile --> ".length() != 0) {
            Pair<String, String> trace5 = logger5.getTrace(depth5);
            String strComponent9 = trace5.component1();
            String strComponent10 = trace5.component2();
            FileLog fileLog5 = FileLog.INSTANCE;
            String str5 = logger5.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            FileLog.print$default(fileLog5, 4, str5, tag5, "viewmodel gainViewModels queryAndSetProfile -->  " + strComponent10, null, 16, null);
            if (logger5.isDebug()) {
                Log.i(tag5 + strComponent9, "viewmodel gainViewModels queryAndSetProfile -->  " + strComponent10);
            }
        }
        profileViewModelFindSelectedProfileItem.setCurrentCacheData(new Pair<>(-1, it));
        this.currentProfile.set(profileViewModelFindSelectedProfileItem);
        this.refreshDataLiveData.setValue(this.currentProfile.get());
    }

    static /* synthetic */ Pair addProfileToDataBase$default(AdvanceEQViewModel advanceEQViewModel, EQEntity eQEntity, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return advanceEQViewModel.addProfileToDataBase(eQEntity, str, i);
    }

    private final Pair<ProfileViewModel, String> addProfileToDataBase(EQEntity entity, String profileName, int source) {
        Pair<ProfileViewModel, String> pairAddProfileToDatabaseAndList = addProfileToDatabaseAndList(entity, profileName, source);
        this.currentProfile.set(pairAddProfileToDatabaseAndList.getFirst());
        findSelectedProfileItem(pairAddProfileToDatabaseAndList.getSecond());
        this.profileChangeLiveData.setValue(0);
        return pairAddProfileToDatabaseAndList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDefaultProfileName() {
        return ViewModelExtKt.getString(this, R.string.eq_advanced_custom, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteAllProfileData() {
        int iDeleteAll = DatabaseUtils.INSTANCE.getProfileDao().deleteAll(SpUtils.INSTANCE.getSelectDeviceMac());
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "deleteAllProfileData " + iDeleteAll;
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

    public static /* synthetic */ boolean updateGainList$default(AdvanceEQViewModel advanceEQViewModel, EQEntity eQEntity, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = -1;
        }
        return advanceEQViewModel.updateGainList(eQEntity, z, i);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x001d  */
    public final boolean updateGainList(EQEntity it, boolean force, int selectIndex) {
        boolean z;
        List<EQValueEntity> eqList;
        EQGainDragBarViewModel eQGainDragBarViewModel;
        boolean zIsEmpty = this.gainViewModels.isEmpty();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "viewmodel gainViewModels advanceCustomEQValue " + it;
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
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            z = true;
        }
        if (it != null && (eqList = it.getEqList()) != null) {
            int i = 0;
            for (Object obj : eqList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                EQValueEntity eQValueEntity = (EQValueEntity) obj;
                if (zIsEmpty || (eQGainDragBarViewModel = (EQGainDragBarViewModel) CollectionsKt.getOrNull(this.gainViewModels, i)) == null) {
                    eQGainDragBarViewModel = new EQGainDragBarViewModel();
                }
                eQGainDragBarViewModel.setIndex(i);
                eQGainDragBarViewModel.updateGainValue(eQValueEntity.getGain());
                eQGainDragBarViewModel.setFilterType(eQValueEntity.getFilterType());
                eQGainDragBarViewModel.setQuality(eQValueEntity.getQuality());
                eQGainDragBarViewModel.setFrequency(eQValueEntity.getFrequency());
                eQGainDragBarViewModel.setMinFrequency(eQValueEntity.getMinFrequency());
                eQGainDragBarViewModel.setMaxFrequency(eQValueEntity.getMaxFrequency());
                if (force) {
                    eQGainDragBarViewModel.getFocused().set(false);
                }
                if (selectIndex == i) {
                    eQGainDragBarViewModel.getFocused().set(Boolean.valueOf(z));
                }
                if (zIsEmpty) {
                    this.gainViewModels.add(eQGainDragBarViewModel);
                } else {
                    this.gainViewModels.set(i, eQGainDragBarViewModel);
                }
                i = i2;
            }
        }
        return zIsEmpty;
    }

    private final ProfileViewModel findSelectedProfileItem(String currentData) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "viewmodel gainViewModels currentData:" + currentData;
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
        ProfileViewModel profileViewModel = null;
        boolean z = false;
        for (ProfileViewModel profileViewModel2 : this.profileList) {
            String str4 = profileViewModel2.getProfileData().get();
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str5 = "viewmodel gainViewModels data:" + str4;
                String str6 = str5;
                if (str6 != null && str6.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str7 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    FileLog.print$default(fileLog2, 3, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            String str8 = str4;
            if (str8 != null && str8.length() != 0 && isSameProfileData(str4, currentData) && !z) {
                profileViewModel2.selectItem(true);
                profileViewModel = profileViewModel2;
                z = true;
            } else {
                profileViewModel2.selectItem(false);
            }
        }
        return profileViewModel;
    }

    private final boolean isSameProfileData(String json1, String json2) {
        if (Intrinsics.areEqual(json1, json2)) {
            return true;
        }
        try {
            Type type = new TypeToken<List<? extends EQValueEntity>>() { // from class: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$isSameProfileData$type$1
            }.getType();
            Object objFromJson = new Gson().fromJson(json1, type);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            List list = (List) objFromJson;
            Object objFromJson2 = new Gson().fromJson(json2, type);
            Intrinsics.checkNotNullExpressionValue(objFromJson2, "fromJson(...)");
            List list2 = (List) objFromJson2;
            if (list.size() != list2.size()) {
                return false;
            }
            List<Pair> listZip = CollectionsKt.zip(list, list2);
            if ((listZip instanceof Collection) && listZip.isEmpty()) {
                return true;
            }
            for (Pair pair : listZip) {
                EQValueEntity eQValueEntity = (EQValueEntity) pair.component1();
                EQValueEntity eQValueEntity2 = (EQValueEntity) pair.component2();
                if (eQValueEntity.getFilterType() != eQValueEntity2.getFilterType() || Math.abs(eQValueEntity.getGain() - eQValueEntity2.getGain()) >= 0.01f || Math.abs(eQValueEntity.getFrequency() - eQValueEntity2.getFrequency()) >= 0.01f || Math.abs(eQValueEntity.getQuality() - eQValueEntity2.getQuality()) >= 0.01f) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final String toJson(EQEntity entity) {
        String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(entity.getEqList());
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$queryAndUpdateProfileData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AdvanceEQViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$queryAndUpdateProfileData$1", f = "AdvanceEQViewModel.kt", i = {0}, l = {362}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class C06701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C06701(Continuation<? super C06701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06701 c06701 = AdvanceEQViewModel.this.new C06701(continuation);
            c06701.L$0 = obj;
            return c06701;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                AdvanceEQViewModel.this.getProfileList().clear();
                ArrayList profileByData = DatabaseUtils.INSTANCE.getProfileDao().getProfileByData(SpUtils.INSTANCE.getSelectDeviceMac());
                if (profileByData == null) {
                    profileByData = new ArrayList();
                }
                AdvanceEQViewModel advanceEQViewModel = AdvanceEQViewModel.this;
                for (ProfileItem profileItem : profileByData) {
                    ProfileViewModel profileViewModel = new ProfileViewModel();
                    profileViewModel.getProfileName().set(profileItem.getName());
                    QRCodeUtil qRCodeUtil = QRCodeUtil.INSTANCE;
                    Object objFromJson = new Gson().fromJson(profileItem.getData(), new TypeToken<List<? extends EQValueEntity>>() { // from class: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$queryAndUpdateProfileData$1$invokeSuspend$lambda$0$$inlined$fromJson$nt_ear_GoogleStoreRelease$1
                    }.getType());
                    Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                    profileViewModel.setCurrentCacheData(new Pair<>(Boxing.boxInt(-1), new EQEntity(advanceEQViewModel.getTotalGain(), (List<EQValueEntity>) objFromJson)));
                    profileViewModel.setId(profileItem.getId());
                    profileViewModel.setSource(profileItem.getSource());
                    profileViewModel.getProfileData().set(profileItem.getData());
                    advanceEQViewModel.getProfileList().add(profileViewModel);
                }
                AdvanceEQViewModel.this.setLoadDBSuccess(true);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(AdvanceEQViewModel.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Logger logger = Logger.INSTANCE;
            AdvanceEQViewModel advanceEQViewModel2 = AdvanceEQViewModel.this;
            Logger logger2 = logger;
            String tag = logger2.getTAG();
            int depth = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str = "tempRemoteEnity " + advanceEQViewModel2.getTempRemoteEntity();
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger2.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$queryAndUpdateProfileData$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: AdvanceEQViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$queryAndUpdateProfileData$1$2", f = "AdvanceEQViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AdvanceEQViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AdvanceEQViewModel advanceEQViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = advanceEQViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
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
                this.this$0.getProfileChangeLiveData().setValue(Boxing.boxInt(0));
                if (this.this$0.getTempRemoteEntity() != null) {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true) && "viewmodel gainViewModels queryAndUpdateProfileData tempRemoteEntity ".length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        FileLog.print$default(fileLog, 3, str, tag, "viewmodel gainViewModels queryAndUpdateProfileData tempRemoteEntity  " + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, "viewmodel gainViewModels queryAndUpdateProfileData tempRemoteEntity  " + strComponent2);
                        }
                    }
                    EQEntity tempRemoteEntity = this.this$0.getTempRemoteEntity();
                    if (tempRemoteEntity != null) {
                        this.this$0.queryAndSetProfile(tempRemoteEntity);
                    }
                    this.this$0.setTempRemoteEntity(null);
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void queryAndUpdateProfileData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06701(null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0030  */
    private final Pair<ProfileViewModel, String> addProfileToDatabaseAndList(EQEntity eqEntity, String profileName, int source) {
        long j;
        String json = toJson(eqEntity);
        long jInsert = DatabaseUtils.INSTANCE.getProfileDao().insert(new ProfileItem(profileName, SpUtils.INSTANCE.getSelectDeviceMac(), json, source));
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = " insert  " + jInsert;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                j = jInsert;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                j = jInsert;
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            j = jInsert;
        }
        ProfileViewModel profileViewModel = new ProfileViewModel();
        profileViewModel.getProfileName().set(profileName);
        profileViewModel.setId(Long.valueOf(j));
        profileViewModel.setSource(source);
        profileViewModel.getProfileData().set(json);
        profileViewModel.setCurrentCacheData(new Pair<>(-1, eqEntity));
        this.profileList.add(profileViewModel);
        return TuplesKt.to(profileViewModel, json);
    }

    public final void updateOnlyOneProfile() {
        boolean z = this.profileList.size() == 1;
        Iterator<ProfileViewModel> it = this.profileList.iterator();
        while (it.hasNext()) {
            it.next().setOnlyOneItem(z);
        }
    }

    public final void updateProfileNameDataBase(ProfileViewModel profileViewModel) {
        Intrinsics.checkNotNullParameter(profileViewModel, "profileViewModel");
        ProfileItemDao profileDao = DatabaseUtils.INSTANCE.getProfileDao();
        ProfileName[] profileNameArr = new ProfileName[1];
        Long id = profileViewModel.getId();
        String str = profileViewModel.getProfileName().get();
        if (str == null) {
            str = "";
        }
        profileNameArr[0] = new ProfileName(id, str);
        profileDao.updateProfileName(profileNameArr);
    }

    private final void updateProfileDataBase() {
        Pair<Integer, EQEntity> currentCacheData;
        EQEntity second;
        ProfileViewModel profileViewModel = this.currentProfile.get();
        if (profileViewModel == null || (currentCacheData = profileViewModel.getCurrentCacheData()) == null || (second = currentCacheData.getSecond()) == null) {
            return;
        }
        String json = toJson(second);
        ProfileItemDao profileDao = DatabaseUtils.INSTANCE.getProfileDao();
        ProfileData[] profileDataArr = new ProfileData[1];
        ProfileViewModel profileViewModel2 = this.currentProfile.get();
        profileDataArr[0] = new ProfileData(profileViewModel2 != null ? profileViewModel2.getId() : null, json);
        profileDao.updateProfileData(profileDataArr);
    }

    public static /* synthetic */ void refreshFrequencyAndQStyle$default(AdvanceEQViewModel advanceEQViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        advanceEQViewModel.refreshFrequencyAndQStyle(z);
    }

    public final void refreshFrequencyAndQStyle(boolean enable) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "refreshFrequencyAndQStyle " + enable;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
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
        this.frequencyEnable.set(Boolean.valueOf(enable));
        this.qEnable.set(Boolean.valueOf(enable));
    }

    public final void refreshWaveChart() {
        Pair<Integer, EQEntity> currentCacheData;
        refreshFrequencyAndQStyle(this.currentGainViewModel != null);
        ObservableFloat observableFloat = this.undoAlpha;
        ProfileViewModel profileViewModel = this.currentProfile.get();
        observableFloat.set(isEnableDoAlpha(profileViewModel != null && profileViewModel.undoHistoryIsNotEmpty()));
        ObservableFloat observableFloat2 = this.redoAlpha;
        ProfileViewModel profileViewModel2 = this.currentProfile.get();
        observableFloat2.set(isEnableDoAlpha(profileViewModel2 != null && profileViewModel2.redoHistoryIsNotEmpty()));
        ObservableField<Boolean> observableField = this.resetEnable;
        EQEntity eQEntity = this.defaultEntity;
        ProfileViewModel profileViewModel3 = this.currentProfile.get();
        observableField.set(Boolean.valueOf(!Intrinsics.areEqual(eQEntity, (profileViewModel3 == null || (currentCacheData = profileViewModel3.getCurrentCacheData()) == null) ? null : currentCacheData.getSecond())));
        if (this.gainViewModels.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (EQGainDragBarViewModel eQGainDragBarViewModel : this.gainViewModels) {
            float quality = eQGainDragBarViewModel.getQuality();
            float frequency = eQGainDragBarViewModel.getFrequency();
            Float f = eQGainDragBarViewModel.getGainValue().get();
            EQParameter eQParameter = new EQParameter();
            eQParameter.setQ(quality);
            eQParameter.setFc((int) frequency);
            eQParameter.setGain(f != null ? (int) f.floatValue() : 0);
            arrayList.add(eQParameter);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.coordinateLiveData.setValue(EQAlgorithm.getCoordinate$default(EQAlgorithm.INSTANCE, 0, arrayList, 1, null));
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "end getCoordinate".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "end getCoordinate " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "end getCoordinate " + strComponent2);
            }
        }
    }

    public final void onRequestData(int loadStatus) {
        TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQValue$default;
        this.isResumeRequest = true;
        if (this.isInitializer) {
            setDefaultAdvanceCustomEQValue();
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "viewmodel gainViewModels onRequestData " + loadStatus;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
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
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderAdvanceCustomEQValue$default = TWSDeviceExtKt.advanceCustomEQValue$default(tWSDevice, 0, null, 3, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderAdvanceCustomEQValue$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    public static /* synthetic */ void setProfileData$default(AdvanceEQViewModel advanceEQViewModel, ProfileViewModel profileViewModel, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        advanceEQViewModel.setProfileData(profileViewModel, z, z2);
    }

    public final void setProfileData(ProfileViewModel profileViewModel, boolean needUpdate, boolean needSendToDevice) {
        Pair<Integer, EQEntity> pair;
        Intrinsics.checkNotNullParameter(profileViewModel, "profileViewModel");
        Pair<Integer, EQEntity> currentCacheData = profileViewModel.getCurrentCacheData();
        if (currentCacheData != null) {
            Iterator<ProfileViewModel> it = this.profileList.iterator();
            while (it.hasNext()) {
                it.next().selectItem(false);
            }
            profileViewModel.selectItem(true);
            this.currentProfile.set(profileViewModel);
            if (needUpdate) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "viewmodel gainViewModels setProfileData refreshDataLiveData ".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    pair = currentCacheData;
                    FileLog.print$default(fileLog, 3, str, tag, "viewmodel gainViewModels setProfileData refreshDataLiveData  " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "viewmodel gainViewModels setProfileData refreshDataLiveData  " + strComponent2);
                    }
                } else {
                    pair = currentCacheData;
                }
                this.refreshDataLiveData.setValue(profileViewModel);
            } else {
                pair = currentCacheData;
            }
            updateProfileDataBase();
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str2 = "viewmodel gainViewModels setProfileData " + pair.getSecond() + StringUtils.SPACE + needSendToDevice;
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 4, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            if (needSendToDevice) {
                sendProfileDataToDevice(pair.getSecond());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendProfileDataToDevice(EQEntity entity) {
        float f;
        NTLog.d("viewmodel gainViewModels sendProfileDataToDevice:" + entity);
        EQCoordinate value = this.coordinateLiveData.getValue();
        if ((value != null ? value.getMaxYValue() : 0) > 0) {
            EQCoordinate value2 = this.coordinateLiveData.getValue();
            f = -(value2 != null ? value2.getMaxYValue() : 0);
        } else {
            f = 0.0f;
        }
        entity.setTotalGain(f);
        addScore(true);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06711(entity, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$sendProfileDataToDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AdvanceEQViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$sendProfileDataToDevice$1", f = "AdvanceEQViewModel.kt", i = {0}, l = {775}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class C06711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EQEntity $entity;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06711(EQEntity eQEntity, Continuation<? super C06711> continuation) {
            super(2, continuation);
            this.$entity = eQEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AdvanceEQViewModel.this.new C06711(this.$entity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQValue;
            EQEntity eQEntity;
            Object objSyncSetResponse$default;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = AdvanceEQViewModel.this.getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderAdvanceCustomEQValue = TWSDeviceExtKt.advanceCustomEQValue(tWSDevice, 0, this.$entity)) != null) {
                    eQEntity = this.$entity;
                    int setCommand = tWSDeviceBuilderAdvanceCustomEQValue.getSetCommand();
                    this.L$0 = tWSDeviceBuilderAdvanceCustomEQValue;
                    this.L$1 = eQEntity;
                    this.I$0 = 0;
                    this.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderAdvanceCustomEQValue.getTwsDevice(), setCommand, tWSDeviceBuilderAdvanceCustomEQValue.getSetPayload(), tWSDeviceBuilderAdvanceCustomEQValue.getTimeOut(), tWSDeviceBuilderAdvanceCustomEQValue.getIsNeedFsn(), false, tWSDeviceBuilderAdvanceCustomEQValue.getMockResponse(), this, 16, null);
                    if (objSyncSetResponse$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = 0;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            eQEntity = (EQEntity) this.L$1;
            tWSDeviceBuilderAdvanceCustomEQValue = (TWSDeviceBuilder) this.L$0;
            ResultKt.throwOnFailure(obj);
            objSyncSetResponse$default = obj;
            Message message = (Message) objSyncSetResponse$default;
            if (message != null && message.isOk()) {
                LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilderAdvanceCustomEQValue.getTwsDevice().getCommandCache(), tWSDeviceBuilderAdvanceCustomEQValue.getGetCommand(), 0, 2, null);
                byte[] bArrObtainDataPacket = eQEntity.obtainDataPacket();
                Message message2 = (Message) liveDataCommand$default.getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                    tWSDeviceBuilderAdvanceCustomEQValue.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilderAdvanceCustomEQValue.getGetCommand(), bArrObtainDataPacket);
                    if (message2 != null) {
                        message2.setPayload(bArrObtainDataPacket);
                        if (i != 0) {
                            tWSDeviceBuilderAdvanceCustomEQValue.getTwsDevice().onUpdate(tWSDeviceBuilderAdvanceCustomEQValue.getGetCommand(), message2);
                        }
                    }
                }
                Boxing.boxBoolean(true);
            } else {
                Boxing.boxBoolean(false);
            }
            return Unit.INSTANCE;
        }
    }

    private final void addScore(boolean isSuccess) {
        String productId;
        GooglePlayScoreUtil googlePlayScoreUtil = GooglePlayScoreUtil.INSTANCE;
        IOTDeviceManager iOTDeviceManager = IOTDeviceManager.INSTANCE;
        TWSDevice tWSDevice = getTWSDevice();
        IOTProductDevice productByMacAddress = iOTDeviceManager.getProductByMacAddress(tWSDevice != null ? tWSDevice.getAddress() : null);
        if (productByMacAddress == null || (productId = productByMacAddress.getProductId()) == null) {
            productId = "";
        }
        googlePlayScoreUtil.addScore(isSuccess, productId);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$deleteProfileData$1, reason: invalid class name */
    /* JADX INFO: compiled from: AdvanceEQViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$deleteProfileData$1", f = "AdvanceEQViewModel.kt", i = {}, l = {525}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProfileViewModel $profileViewModel;
        int label;
        final /* synthetic */ AdvanceEQViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ProfileViewModel profileViewModel, AdvanceEQViewModel advanceEQViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$profileViewModel = profileViewModel;
            this.this$0 = advanceEQViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$profileViewModel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int iDelete = DatabaseUtils.INSTANCE.getProfileDao().delete(new ProfileId(this.$profileViewModel.getId()));
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C01331(this.this$0, this.$profileViewModel, iDelete, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$deleteProfileData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AdvanceEQViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$deleteProfileData$1$1", f = "AdvanceEQViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $count;
            final /* synthetic */ ProfileViewModel $profileViewModel;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AdvanceEQViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01331(AdvanceEQViewModel advanceEQViewModel, ProfileViewModel profileViewModel, int i, Continuation<? super C01331> continuation) {
                super(2, continuation);
                this.this$0 = advanceEQViewModel;
                this.$profileViewModel = profileViewModel;
                this.$count = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01331 c01331 = new C01331(this.this$0, this.$profileViewModel, this.$count, continuation);
                c01331.L$0 = obj;
                return c01331;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.markProfileChanged();
                int iIndexOf = this.this$0.getProfileList().indexOf(this.$profileViewModel);
                boolean zRemove = this.this$0.getProfileList().remove(this.$profileViewModel);
                Logger logger = Logger.INSTANCE;
                int i = this.$count;
                ProfileViewModel profileViewModel = this.$profileViewModel;
                Logger logger2 = logger;
                String tag = logger2.getTAG();
                int depth = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str = "delete count " + i + " index :" + iIndexOf + " ,remove " + zRemove + StringUtils.SPACE + profileViewModel.getId();
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger2.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                if (this.$profileViewModel.getSelected()) {
                    ObservableArrayList<ProfileViewModel> profileList = this.this$0.getProfileList();
                    ProfileViewModel profileViewModel2 = (iIndexOf < 0 || iIndexOf >= profileList.size()) ? (ProfileViewModel) CollectionsKt.getOrNull(this.this$0.getProfileList(), iIndexOf - 1) : profileList.get(iIndexOf);
                    if (profileViewModel2 != null) {
                        AdvanceEQViewModel.setProfileData$default(this.this$0, profileViewModel2, false, false, 6, null);
                    }
                }
                this.this$0.getProfileChangeLiveData().setValue(Boxing.boxInt(0));
                return Unit.INSTANCE;
            }
        }
    }

    public final void deleteProfileData(ProfileViewModel profileViewModel) {
        Intrinsics.checkNotNullParameter(profileViewModel, "profileViewModel");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(profileViewModel, this, null), 2, null);
    }

    public static /* synthetic */ void addProfileData$default(AdvanceEQViewModel advanceEQViewModel, String str, EQEntity eQEntity, boolean z, Function0 function0, Function0 function1, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            eQEntity = new EQEntity(0, advanceEQViewModel.getTotalGain());
        }
        EQEntity eQEntity2 = eQEntity;
        if ((i2 & 4) != 0) {
            z = true;
        }
        advanceEQViewModel.addProfileData(str, eQEntity2, z, function0, function1, (i2 & 32) != 0 ? 0 : i);
    }

    public final void addProfileData(String profileName, EQEntity eqEntity, boolean needSendToDevice, Function0<Unit> fullAction, Function0<Unit> successAction, int dataSource) {
        Intrinsics.checkNotNullParameter(profileName, "profileName");
        Intrinsics.checkNotNullParameter(eqEntity, "eqEntity");
        Intrinsics.checkNotNullParameter(fullAction, "fullAction");
        Intrinsics.checkNotNullParameter(successAction, "successAction");
        if (isFull()) {
            fullAction.invoke();
            return;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "addProfileData " + profileName;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
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
        setProfileData$default(this, addProfileToDataBase(eqEntity, profileName, dataSource).getFirst(), false, needSendToDevice, 2, null);
        successAction.invoke();
    }

    public final boolean isFull() {
        return this.profileList.size() >= 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getTotalGain() {
        IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(SpUtils.INSTANCE.getCurrentModel());
        if (productByModelId != null) {
            return productByModelId.getTotalGain();
        }
        return 0.0f;
    }

    public final void updateChange() {
        NTLog.d("viewmodel gainViewModels updateChange");
        ProfileViewModel profileViewModel = this.currentProfile.get();
        if (profileViewModel != null) {
            profileViewModel.clearRedo();
            addHistory();
            Pair<Integer, EQEntity> historyEntity = getHistoryEntity();
            EQEntity second = historyEntity.getSecond();
            profileViewModel.setCurrentCacheData(historyEntity);
            profileViewModel.getProfileData().set(toJson(second));
            this.advanceEqValueChange = true;
            Pair<Integer, EQEntity> currentCacheData = profileViewModel.getCurrentCacheData();
            NTLog.d("viewmodel gainViewModels updateChange currentCacheData :" + (currentCacheData != null ? currentCacheData.getSecond() : null));
            setProfileData$default(this, profileViewModel, false, false, 4, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004e  */
    private final void addHistory() {
        ProfileViewModel profileViewModel;
        String str;
        Pair pair;
        String str2;
        ProfileViewModel profileViewModel2 = this.currentProfile.get();
        if (profileViewModel2 != null) {
            profileViewModel2.checkHistory();
            Pair pair2 = (Pair) CollectionsKt.lastOrNull((List) profileViewModel2.getUndoEntity());
            Pair<Integer, EQEntity> currentCacheData = profileViewModel2.getCurrentCacheData();
            if (currentCacheData != null) {
                if (Intrinsics.areEqual(pair2 != null ? (EQEntity) pair2.getSecond() : null, currentCacheData.getSecond())) {
                    return;
                }
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str3 = "addHistory " + currentCacheData.getSecond();
                    String str4 = str3;
                    if (str4 == null || str4.length() == 0) {
                        profileViewModel = profileViewModel2;
                        pair = pair2;
                        str = "format(...)";
                        str2 = StringUtils.SPACE;
                    } else {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str5 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        String str6 = str3 + StringUtils.SPACE + strComponent2;
                        profileViewModel = profileViewModel2;
                        str = "format(...)";
                        pair = pair2;
                        str2 = StringUtils.SPACE;
                        FileLog.print$default(fileLog, 4, str5, tag, str6, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str3 + str2 + strComponent2);
                        }
                    }
                } else {
                    profileViewModel = profileViewModel2;
                    pair = pair2;
                    str = "format(...)";
                    str2 = StringUtils.SPACE;
                }
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str7 = "addHistory " + (pair != null ? (EQEntity) pair.getSecond() : null);
                    String str8 = str7;
                    if (str8 != null && str8.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str9 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, str);
                        FileLog.print$default(fileLog2, 4, str9, tag2, str7 + str2 + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str7 + str2 + strComponent4);
                        }
                    }
                }
                profileViewModel.getUndoEntity().add(currentCacheData);
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str10 = "addHistory advanceCustomEQValue undoEntity size " + profileViewModel.getUndoEntity().size() + str2;
                    String str11 = str10;
                    if (str11 == null || str11.length() == 0) {
                        return;
                    }
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str12 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str12, str);
                    FileLog.print$default(fileLog3, 4, str12, tag3, str10 + str2 + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str10 + str2 + strComponent6);
                    }
                }
            }
        }
    }

    private final Pair<Integer, EQEntity> getHistoryEntity() {
        EQEntity eQEntity = new EQEntity(0, getTotalGain());
        int size = this.gainViewModels.size();
        ArrayList arrayList = new ArrayList(size);
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            EQGainDragBarViewModel eQGainDragBarViewModel = this.gainViewModels.get(i2);
            if (Intrinsics.areEqual((Object) eQGainDragBarViewModel.getFocused().get(), (Object) true)) {
                i = i2;
            }
            int filterType = eQGainDragBarViewModel.getFilterType();
            Float f = eQGainDragBarViewModel.getGainValue().get();
            arrayList.add(new EQValueEntity(filterType, f != null ? f.floatValue() : 0.0f, eQGainDragBarViewModel.getFrequency(), eQGainDragBarViewModel.getQuality(), eQGainDragBarViewModel.getMinFrequency(), eQGainDragBarViewModel.getMaxFrequency()));
        }
        eQEntity.setEqList(arrayList);
        return new Pair<>(Integer.valueOf(i), eQEntity);
    }

    public final void reset() {
        ObservableField<String> profileData;
        ProfileViewModel profileViewModel = this.currentProfile.get();
        if (profileViewModel != null) {
            profileViewModel.clearRedo();
        }
        addHistory();
        EQEntity eQEntity = new EQEntity(0, getTotalGain());
        ProfileViewModel profileViewModel2 = this.currentProfile.get();
        if (profileViewModel2 != null) {
            profileViewModel2.setCurrentCacheData(new Pair<>(-1, eQEntity));
        }
        ProfileViewModel profileViewModel3 = this.currentProfile.get();
        if (profileViewModel3 != null && (profileData = profileViewModel3.getProfileData()) != null) {
            profileData.set(toJson(eQEntity));
        }
        updateProfileDataBase();
        this.refreshDataLiveData.setValue(this.currentProfile.get());
        sendProfileDataToDevice(eQEntity);
    }

    public final void runUndo(Function1<? super Pair<Integer, EQEntity>, Unit> action) {
        ProfileViewModel profileViewModel;
        ArrayList<Pair<Integer, EQEntity>> redoEntity;
        ArrayList<Pair<Integer, EQEntity>> undoEntity;
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.undoAlpha.get() == 0.2f || (profileViewModel = this.currentProfile.get()) == null) {
            return;
        }
        Pair<Integer, EQEntity> currentCacheData = profileViewModel.getCurrentCacheData();
        if (currentCacheData != null) {
            Pair pair = (Pair) CollectionsKt.lastOrNull((List) profileViewModel.getRedoEntity());
            if (!Intrinsics.areEqual(pair != null ? (EQEntity) pair.getSecond() : null, currentCacheData.getSecond())) {
                profileViewModel.getRedoEntity().add(currentCacheData);
            }
        }
        Pair<Integer, EQEntity> pair2 = (Pair) CollectionsKt.removeLastOrNull(profileViewModel.getUndoEntity());
        if (pair2 == null) {
            action.invoke(null);
            return;
        }
        profileViewModel.setCurrentCacheData(pair2);
        profileViewModel.getProfileData().set(toJson(pair2.getSecond()));
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            ProfileViewModel profileViewModel2 = this.currentProfile.get();
            String str = "addHistory runUndo  undoEntity size " + ((profileViewModel2 == null || (undoEntity = profileViewModel2.getUndoEntity()) == null) ? null : Integer.valueOf(undoEntity.size())) + StringUtils.SPACE;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
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
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            ProfileViewModel profileViewModel3 = this.currentProfile.get();
            String str4 = "addHistory runUndo  redoEntity size " + ((profileViewModel3 == null || (redoEntity = profileViewModel3.getRedoEntity()) == null) ? null : Integer.valueOf(redoEntity.size())) + StringUtils.SPACE;
            String str5 = str4;
            if (str5 != null && str5.length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        updateProfileDataBase();
        action.invoke(pair2);
        sendProfileDataToDevice(pair2.getSecond());
    }

    public final void runRedo(Function1<? super Pair<Integer, EQEntity>, Unit> action) {
        ProfileViewModel profileViewModel;
        ArrayList<Pair<Integer, EQEntity>> redoEntity;
        ArrayList<Pair<Integer, EQEntity>> undoEntity;
        ArrayList<Pair<Integer, EQEntity>> redoEntity2;
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.redoAlpha.get() == 0.2f || (profileViewModel = this.currentProfile.get()) == null) {
            return;
        }
        Pair<Integer, EQEntity> currentCacheData = profileViewModel.getCurrentCacheData();
        if (currentCacheData != null) {
            Pair pair = (Pair) CollectionsKt.lastOrNull((List) profileViewModel.getUndoEntity());
            if (!Intrinsics.areEqual(pair != null ? (EQEntity) pair.getSecond() : null, currentCacheData.getSecond())) {
                profileViewModel.getUndoEntity().add(currentCacheData);
            }
        }
        ProfileViewModel profileViewModel2 = this.currentProfile.get();
        Pair<Integer, EQEntity> pair2 = (profileViewModel2 == null || (redoEntity2 = profileViewModel2.getRedoEntity()) == null) ? null : (Pair) CollectionsKt.removeLastOrNull(redoEntity2);
        if (pair2 == null) {
            action.invoke(null);
            return;
        }
        profileViewModel.setCurrentCacheData(pair2);
        profileViewModel.getProfileData().set(toJson(pair2.getSecond()));
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            ProfileViewModel profileViewModel3 = this.currentProfile.get();
            String str = "addHistory runUndo  undoEntity size " + ((profileViewModel3 == null || (undoEntity = profileViewModel3.getUndoEntity()) == null) ? null : Integer.valueOf(undoEntity.size())) + StringUtils.SPACE;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
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
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            ProfileViewModel profileViewModel4 = this.currentProfile.get();
            String str4 = "addHistory runUndo  redoEntity size " + ((profileViewModel4 == null || (redoEntity = profileViewModel4.getRedoEntity()) == null) ? null : Integer.valueOf(redoEntity.size())) + StringUtils.SPACE;
            String str5 = str4;
            if (str5 != null && str5.length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        updateProfileDataBase();
        action.invoke(pair2);
        sendProfileDataToDevice(pair2.getSecond());
    }

    @Override // com.nothing.device.BaseAndroidLifecycleViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQValue$default;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "viewmodel gainViewModels onCleared ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "viewmodel gainViewModels onCleared  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "viewmodel gainViewModels onCleared  " + strComponent2);
            }
        }
        reportIfNeeded();
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderAdvanceCustomEQValue$default = TWSDeviceExtKt.advanceCustomEQValue$default(tWSDevice, 0, null, 2, null)) != null) {
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderAdvanceCustomEQValue$default, false, (byte[]) null, 0, 7, (Object) null);
        }
        GooglePlayScoreUtil.INSTANCE.endControl();
        super.onCleared();
    }

    public final void markProfileChanged() {
        this.hasProfileChanged = true;
    }

    public final void reportIfNeeded() {
        String str;
        ObservableField<String> profileName;
        Pair<Integer, EQEntity> currentCacheData;
        EQEntity second;
        List<EQValueEntity> eqList;
        Pair<Integer, EQEntity> currentCacheData2;
        EQEntity second2;
        List<EQValueEntity> eqList2;
        if (!this.advanceEqEnabled) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "advanceEqEnabled: " + this.advanceEqEnabled;
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    return;
                }
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    return;
                }
                return;
            }
            return;
        }
        if (this.advanceEqValueChange) {
            this.advanceEqValueChange = false;
            ProfileViewModel profileViewModel = this.currentProfile.get();
            int size = (profileViewModel == null || (currentCacheData2 = profileViewModel.getCurrentCacheData()) == null || (second2 = currentCacheData2.getSecond()) == null || (eqList2 = second2.getEqList()) == null) ? 0 : eqList2.size();
            ProfileViewModel profileViewModel2 = this.currentProfile.get();
            String str5 = "[";
            if (profileViewModel2 != null && (currentCacheData = profileViewModel2.getCurrentCacheData()) != null && (second = currentCacheData.getSecond()) != null && (eqList = second.getEqList()) != null) {
                int i = 0;
                String str6 = "[";
                for (Object obj : eqList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    EQValueEntity eQValueEntity = (EQValueEntity) obj;
                    String str7 = ((Object) str6) + "[" + eQValueEntity.getGain() + "," + eQValueEntity.getFrequency() + "," + eQValueEntity.getQuality() + "," + eQValueEntity.getFilterType() + "]";
                    if (i != size - 1) {
                        str7 = ((Object) str7) + ",";
                    }
                    str6 = str7;
                    i = i2;
                }
                str5 = str6;
            }
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str8 = "reportIfNeeded: " + ((Object) str5);
                String str9 = str8;
                if (str9 != null && str9.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str10 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    FileLog.print$default(fileLog2, 3, str10, tag2, str8 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str8 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            AppBuriedPointUtils.reportData$default(AppBuriedPointUtils.INSTANCE, new EventParams(AppBuriedPointUtils.ADVANCED_EQ_PROFILES_VALUES, str5, "string"), null, false, null, 14, null);
        }
        AppBuriedPointUtils appBuriedPointUtils = AppBuriedPointUtils.INSTANCE;
        ProfileViewModel profileViewModel3 = this.currentProfile.get();
        AppBuriedPointUtils.reportData$default(appBuriedPointUtils, new EventParams(AppBuriedPointUtils.ADVANCED_EQ_PROFILES_SOURCE, String.valueOf(profileViewModel3 != null ? profileViewModel3.getSource() : 0), AppBuriedPointUtils.VALUE_TYPE_INT), null, false, null, 14, null);
        AppBuriedPointUtils appBuriedPointUtils2 = AppBuriedPointUtils.INSTANCE;
        ProfileViewModel profileViewModel4 = this.currentProfile.get();
        if (profileViewModel4 == null || (profileName = profileViewModel4.getProfileName()) == null || (str = profileName.get()) == null) {
            str = "";
        }
        AppBuriedPointUtils.reportData$default(appBuriedPointUtils2, new EventParams(AppBuriedPointUtils.ADVANCED_EQ_PROFILES_NAME, str, "string"), null, false, null, 14, null);
        if (this.hasProfileChanged) {
            AppBuriedPointUtils.reportData$default(AppBuriedPointUtils.INSTANCE, new EventParams(AppBuriedPointUtils.ADVANCED_EQ_PROFILES_NUMBER, String.valueOf(this.profileList.size()), AppBuriedPointUtils.VALUE_TYPE_INT), null, false, null, 14, null);
            this.hasProfileChanged = false;
        }
    }
}
