package com.nothing.os.device.bluetooth.components;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.ear.R;
import com.nothing.os.device.bluetooth.adapter.NormalItemViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GestureControlsComponents.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/nothing/os/device/bluetooth/components/GestureControlsComponents;", "Lcom/nothing/device/BaseFunctionComponents;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/nothing/device/IOTDevice;Landroidx/lifecycle/LifecycleOwner;)V", "viewModel", "Lcom/nothing/os/device/bluetooth/adapter/NormalItemViewModel;", "getViewModel", "()Lcom/nothing/os/device/bluetooth/adapter/NormalItemViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "needRequest", "", "getComponentsModel", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GestureControlsComponents extends BaseFunctionComponents {

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.nothing.device.BaseFunctionComponents
    public boolean needRequest() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GestureControlsComponents(final Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner) {
        super(context, iotDevice, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.viewModel = LazyKt.lazy(new Function0() { // from class: com.nothing.os.device.bluetooth.components.GestureControlsComponents$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GestureControlsComponents.viewModel_delegate$lambda$1(context);
            }
        });
    }

    public final NormalItemViewModel getViewModel() {
        return (NormalItemViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NormalItemViewModel viewModel_delegate$lambda$1(Context context) {
        NormalItemViewModel normalItemViewModel = new NormalItemViewModel(660);
        normalItemViewModel.getTitle().set(context.getString(R.string.os_device_gesture_controls));
        return normalItemViewModel;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public CommonBindingMoreType getComponentsModel() {
        return getViewModel();
    }
}
