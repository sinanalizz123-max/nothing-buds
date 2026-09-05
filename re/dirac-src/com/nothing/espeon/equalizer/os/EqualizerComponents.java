package com.nothing.espeon.equalizer.os;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.Logger;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import com.nothing.os.device.bluetooth.adapter.NormalItemViewModel;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EqualizerComponents.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/nothing/espeon/equalizer/os/EqualizerComponents;", "Lcom/nothing/device/BaseFunctionComponents;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/nothing/device/IOTDevice;Landroidx/lifecycle/LifecycleOwner;)V", "viewModel", "Lcom/nothing/os/device/bluetooth/adapter/NormalItemViewModel;", "getViewModel", "()Lcom/nothing/os/device/bluetooth/adapter/NormalItemViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "refresh", "", "addListener", "clearObserver", "", "updateEQ", "type", "", "getComponentsModel", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EqualizerComponents extends BaseFunctionComponents {

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EqualizerComponents(final Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner) {
        super(context, iotDevice, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.viewModel = LazyKt.lazy(new Function0() { // from class: com.nothing.espeon.equalizer.os.EqualizerComponents$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EqualizerComponents.viewModel_delegate$lambda$1(context);
            }
        });
        addListener(true);
    }

    public final NormalItemViewModel getViewModel() {
        return (NormalItemViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NormalItemViewModel viewModel_delegate$lambda$1(Context context) {
        NormalItemViewModel normalItemViewModel = new NormalItemViewModel(620);
        normalItemViewModel.getTitle().set(context.getString(R.string.equalizer));
        return normalItemViewModel;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void refresh() {
        TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ$default;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "EqualizerComponents refresh".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "EqualizerComponents refresh " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "EqualizerComponents refresh " + strComponent2);
            }
        }
        TWSDevice twsDevice = getIotDevice().getTwsDevice();
        if (twsDevice == null || (tWSDeviceBuilderDiracOpteoEQ$default = TWSDeviceExtKt.diracOpteoEQ$default(twsDevice, 0, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderDiracOpteoEQ$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void addListener(boolean clearObserver) {
        TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ$default;
        LiveData<Message> liveData;
        TWSDevice twsDevice;
        TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ$default2;
        LiveData<Message> liveData2;
        if (clearObserver && (twsDevice = getIotDevice().getTwsDevice()) != null && (tWSDeviceBuilderDiracOpteoEQ$default2 = TWSDeviceExtKt.diracOpteoEQ$default(twsDevice, 0, 1, null)) != null && (liveData2 = tWSDeviceBuilderDiracOpteoEQ$default2.getLiveData()) != null) {
            liveData2.removeObservers(getLifecycleOwner());
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "EqualizerComponents addListener".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "EqualizerComponents addListener " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "EqualizerComponents addListener " + strComponent2);
            }
        }
        TWSDevice twsDevice2 = getIotDevice().getTwsDevice();
        if (twsDevice2 == null || (tWSDeviceBuilderDiracOpteoEQ$default = TWSDeviceExtKt.diracOpteoEQ$default(twsDevice2, 0, 1, null)) == null || (liveData = tWSDeviceBuilderDiracOpteoEQ$default.getLiveData()) == null) {
            return;
        }
        liveData.observe(getLifecycleOwner(), new EqualizerComponents$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.espeon.equalizer.os.EqualizerComponents$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EqualizerComponents.addListener$lambda$6(this.f$0, (Message) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addListener$lambda$6(EqualizerComponents equalizerComponents, Message message) {
        Integer num;
        if (message != null && (num = (Integer) message.obtainPayload(Integer.TYPE)) != null) {
            int iIntValue = num.intValue();
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "EqualizerComponents updateEQ " + iIntValue;
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
            equalizerComponents.updateEQ(iIntValue);
        }
        return Unit.INSTANCE;
    }

    private final void updateEQ(int type) {
        String string;
        switch (type) {
            case 0:
                string = getContext().getString(R.string.dirac_eq_opteo);
                break;
            case 1:
                string = getContext().getString(R.string.eq_advanced_genre_rock);
                break;
            case 2:
                string = getContext().getString(R.string.eq_advanced_genre_electronic);
                break;
            case 3:
                string = getContext().getString(R.string.eq_advanced_genre_pop);
                break;
            case 4:
                string = getContext().getString(R.string.dirac_eq_enhance_vocals);
                break;
            case 5:
                string = getContext().getString(R.string.eq_advanced_genre_classical);
                break;
            case 6:
                string = getContext().getString(R.string.sound_eq_custom);
                break;
            default:
                string = "";
                break;
        }
        Intrinsics.checkNotNull(string);
        getViewModel().setSummary(string);
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public CommonBindingMoreType getComponentsModel() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "EqualizerComponents getComponentsModel".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "EqualizerComponents getComponentsModel " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "EqualizerComponents getComponentsModel " + strComponent2);
            }
        }
        return getViewModel();
    }
}
