package com.nothing.device;

import android.app.Activity;
import android.view.View;
import androidx.activity.ComponentActivity;
import com.nothing.base.popupwindow.ForBottomPopupWindow;
import com.nothing.base.view.BaseFragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IOTDeviceAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J.\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J<\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J2\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00142\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J*\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00142\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u000e\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!H\u0016J\u000e\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u001a\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0014H\u0016\u00a8\u0006("}, d2 = {"Lcom/nothing/device/IOTDeviceAction;", "", "<init>", "()V", "startDetailActivity", "", "activity", "Landroidx/activity/ComponentActivity;", "startPairActivity", "earView", "Lkotlin/Triple;", "Landroid/view/View;", "startGuideActivity", "view", "modelId", "", "address", "views", "Lkotlin/Pair;", "startControlActivity", "Landroid/app/Activity;", "isLeft", "", "startCaseControlActivity", "startEqualizerActivity", "startFindDeviceActivity", "startMimiActivity", "startLhdcActivity", "startNoiseReductionActivity", "startDualConnectActivity", "startEarFitTestActivity", "startPersonalANCActivity", "getANCDialog", "Lcom/nothing/base/popupwindow/ForBottomPopupWindow;", "getSimpleEQFragment", "Lcom/nothing/base/view/BaseFragment;", "startFirmwareActivity", "startGestureOperationActivity", "startDualActivity", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IOTDeviceAction {
    public static final String PAIR_IMAGE_VIEW = "ear_image_transition";
    public static final String PAIR_LEFT_VIEW = "left_ear";
    public static final String PAIR_RIGHT_VIEW = "right_ear";

    public ForBottomPopupWindow<?> getANCDialog() {
        return null;
    }

    public BaseFragment<?> getSimpleEQFragment() {
        return null;
    }

    public void startCaseControlActivity(Activity activity, Triple<? extends View, ? extends View, ? extends View> earView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(earView, "earView");
    }

    public void startControlActivity(Activity activity, Triple<? extends View, ? extends View, ? extends View> earView, boolean isLeft) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(earView, "earView");
    }

    public void startDetailActivity(ComponentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startDualActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startDualConnectActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startEarFitTestActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startEqualizerActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startFindDeviceActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startFirmwareActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startGestureOperationActivity(Activity activity, String address) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startGuideActivity(ComponentActivity activity, View view, String modelId, String address) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startGuideActivity(ComponentActivity activity, Pair<? extends View, ? extends View> views, String modelId, String address) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(views, "views");
    }

    public void startLhdcActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startMimiActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startNoiseReductionActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void startPairActivity(ComponentActivity activity, Triple<? extends View, ? extends View, ? extends View> earView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(earView, "earView");
    }

    public void startPersonalANCActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
