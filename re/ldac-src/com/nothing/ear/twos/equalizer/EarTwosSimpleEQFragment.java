package com.nothing.ear.twos.equalizer;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.nothing.base.dialog.confirm.ConfirmMsgDialog;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.BaseConfig;
import com.nothing.base.wiget.radar.EQDragView;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseEqualiserSimpleFragmentBinding;
import com.nothing.earbase.control.GptProviderHelper;
import com.nothing.earbase.equalizer.activity.BaseEqualiserActivity;
import com.nothing.earbase.equalizer.fragment.SimpleEQFragment;
import com.nothing.log.FileLog;
import com.nothing.log.util.AppGlobals;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EarTwosSimpleEQFragment.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J&\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002J&\u0010\u001b\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002J\u0016\u0010\u001c\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/nothing/ear/twos/equalizer/EarTwosSimpleEQFragment;", "Lcom/nothing/earbase/equalizer/fragment/SimpleEQFragment;", "<init>", "()V", "hdacWarningDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "hdacWarningViewModel", "Lcom/nothing/base/dialog/confirm/ConfirmMsgViewModel;", "createContentConfig", "", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "getActionBarMask", "Landroid/view/View;", "getTopBarMask", GptProviderHelper.SHOWTIPS, "isShow", "", "createShowAnimator", "Landroid/animation/ObjectAnimator;", "view", "start", "", "end", "createDismissAnimator", "dismissAnimation", "action", "Lkotlin/Function0;", "showAnimation", "dismissTipsListener", "isShowTips", "onInitObserver", "binding", "Lcom/nothing/ear/databinding/BaseEqualiserSimpleFragmentBinding;", "onResumeLazy", "loadStatus", "", "onResume", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarTwosSimpleEQFragment extends SimpleEQFragment {
    private static final long ALPHA_DURATION = 200;
    private static final float BACKGROUND_ALPHA = 0.0f;
    private static final float BACKGROUND_ALPHA_NORMAL = 1.0f;
    private static final float TOP_VIEW_HEIGHT = 60.0f;
    private static final long TRANSLATION_DELAY = 100;
    private static final long TRANSLATION_DURATION = 300;
    private static final float TRANSLATION_Y_OFFSET = 50.0f;
    private ConfirmMsgDialog hdacWarningDialog;
    private final ConfirmMsgViewModel hdacWarningViewModel = new ConfirmMsgViewModel();

    @Override // com.nothing.earbase.equalizer.fragment.SimpleEQFragment, com.nothing.base.view.BaseFragment
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createContentConfig(contentConfig);
        this.hdacWarningDialog = new ConfirmMsgDialog();
    }

    @Override // com.nothing.earbase.equalizer.fragment.SimpleEQFragment, com.nothing.base.view.BaseFragment
    public void onInit(Bundle savedInstanceState) {
        String helpDeviceName;
        super.onInit(savedInstanceState);
        EQDragView eQDragView = getMBinding().vRadar;
        IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(SpUtils.INSTANCE.getCurrentModel());
        if (productByModelId == null || (helpDeviceName = productByModelId.getHelpDeviceName()) == null) {
            helpDeviceName = "";
        }
        eQDragView.setTvSummaryTextValue(helpDeviceName);
    }

    private final View getActionBarMask() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "eq simple animal  getActionBarMask ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "eq simple animal  getActionBarMask  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "eq simple animal  getActionBarMask  " + strComponent2);
            }
        }
        if (getContext() instanceof BaseEqualiserActivity) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "eq simple animal  is  BaseEqualiserActivity".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 3, str2, tag2, "eq simple animal  is  BaseEqualiserActivity " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "eq simple animal  is  BaseEqualiserActivity " + strComponent4);
                }
            }
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.nothing.earbase.equalizer.activity.BaseEqualiserActivity");
            return ((BaseEqualiserActivity) context).getActionBarMask();
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (!logger3.isCanLogger(true) || "eq simple animal  not  BaseEqualiserActivity".length() == 0) {
            return null;
        }
        Pair<String, String> trace3 = logger3.getTrace(depth3);
        String strComponent5 = trace3.component1();
        String strComponent6 = trace3.component2();
        FileLog fileLog3 = FileLog.INSTANCE;
        String str3 = logger3.getSdf().format(new Date());
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        FileLog.print$default(fileLog3, 3, str3, tag3, "eq simple animal  not  BaseEqualiserActivity " + strComponent6, null, 16, null);
        if (!logger3.isDebug()) {
            return null;
        }
        Log.i(tag3 + strComponent5, "eq simple animal  not  BaseEqualiserActivity " + strComponent6);
        return null;
    }

    private final View getTopBarMask() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "eq simple animal  getTopBarMask ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "eq simple animal  getTopBarMask  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "eq simple animal  getTopBarMask  " + strComponent2);
            }
        }
        if (getContext() instanceof BaseEqualiserActivity) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "eq simple animal getTopBarMask is  BaseEqualiserActivity".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 3, str2, tag2, "eq simple animal getTopBarMask is  BaseEqualiserActivity " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "eq simple animal getTopBarMask is  BaseEqualiserActivity " + strComponent4);
                }
            }
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.nothing.earbase.equalizer.activity.BaseEqualiserActivity");
            return ((BaseEqualiserActivity) context).getMBinding().eqIvMask;
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (!logger3.isCanLogger(true) || "eq simple animal getTopBarMask not  BaseEqualiserActivity".length() == 0) {
            return null;
        }
        Pair<String, String> trace3 = logger3.getTrace(depth3);
        String strComponent5 = trace3.component1();
        String strComponent6 = trace3.component2();
        FileLog fileLog3 = FileLog.INSTANCE;
        String str3 = logger3.getSdf().format(new Date());
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        FileLog.print$default(fileLog3, 3, str3, tag3, "eq simple animal getTopBarMask not  BaseEqualiserActivity " + strComponent6, null, 16, null);
        if (!logger3.isDebug()) {
            return null;
        }
        Log.i(tag3 + strComponent5, "eq simple animal getTopBarMask not  BaseEqualiserActivity " + strComponent6);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTips(boolean isShow) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "eq simple animal showTips isShow=" + isShow;
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
        if (isShow) {
            View actionBarMask = getActionBarMask();
            if (actionBarMask != null) {
                actionBarMask.setAlpha(0.0f);
            }
            View topBarMask = getTopBarMask();
            if (topBarMask != null) {
                topBarMask.setAlpha(0.0f);
            }
            getMBinding().ivBottomMask.setAlpha(0.0f);
            getMBinding().ivTopMask.setAlpha(0.0f);
            getMBinding().vRadar.getMaskView().setAlpha(0.0f);
            getMBinding().vRadar.getTriangle().setAlpha(0.0f);
            getMBinding().vRadar.getContentViewView().setAlpha(0.0f);
            View actionBarMask2 = getActionBarMask();
            if (actionBarMask2 != null) {
                actionBarMask2.setVisibility(0);
            }
            View topBarMask2 = getTopBarMask();
            if (topBarMask2 != null) {
                topBarMask2.setVisibility(0);
            }
            getMBinding().vRadar.getMaskView().setVisibility(0);
            getMBinding().ivBottomMask.setVisibility(0);
            getMBinding().ivTopMask.setVisibility(0);
            getMBinding().vRadar.getTriangle().setVisibility(0);
            getMBinding().vRadar.getContentViewView().setVisibility(0);
            showAnimation();
            return;
        }
        dismissAnimation(new Function0() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarTwosSimpleEQFragment.showTips$lambda$7(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTips$lambda$7(EarTwosSimpleEQFragment earTwosSimpleEQFragment) {
        View actionBarMask = earTwosSimpleEQFragment.getActionBarMask();
        if (actionBarMask != null) {
            actionBarMask.setVisibility(8);
        }
        View topBarMask = earTwosSimpleEQFragment.getTopBarMask();
        if (topBarMask != null) {
            topBarMask.setVisibility(8);
        }
        earTwosSimpleEQFragment.getMBinding().vRadar.getMaskView().setVisibility(8);
        earTwosSimpleEQFragment.getMBinding().ivBottomMask.setVisibility(8);
        earTwosSimpleEQFragment.getMBinding().ivTopMask.setVisibility(8);
        earTwosSimpleEQFragment.getMBinding().vRadar.getTriangle().setVisibility(4);
        earTwosSimpleEQFragment.getMBinding().vRadar.getContentViewView().setVisibility(4);
        return Unit.INSTANCE;
    }

    static /* synthetic */ ObjectAnimator createShowAnimator$default(EarTwosSimpleEQFragment earTwosSimpleEQFragment, View view, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 1.0f;
        }
        return earTwosSimpleEQFragment.createShowAnimator(view, f, f2);
    }

    private final ObjectAnimator createShowAnimator(View view, float start, float end) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", start, end);
        objectAnimatorOfFloat.setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "also(...)");
        return objectAnimatorOfFloat;
    }

    static /* synthetic */ ObjectAnimator createDismissAnimator$default(EarTwosSimpleEQFragment earTwosSimpleEQFragment, View view, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return earTwosSimpleEQFragment.createDismissAnimator(view, f, f2);
    }

    private final ObjectAnimator createDismissAnimator(View view, float start, float end) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", start, end);
        objectAnimatorOfFloat.setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "also(...)");
        return objectAnimatorOfFloat;
    }

    private final void dismissAnimation(final Function0<Unit> action) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "eq simple animal dismissAnimation".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "eq simple animal dismissAnimation " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "eq simple animal dismissAnimation " + strComponent2);
            }
        }
        ObjectAnimator objectAnimatorCreateDismissAnimator$default = createDismissAnimator$default(this, getTopBarMask(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default2 = createDismissAnimator$default(this, getActionBarMask(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default3 = createDismissAnimator$default(this, getMBinding().ivBottomMask, 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default4 = createDismissAnimator$default(this, getMBinding().ivTopMask, 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default5 = createDismissAnimator$default(this, getMBinding().vRadar.getMaskView(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default6 = createDismissAnimator$default(this, getMBinding().vRadar.getTriangle(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default7 = createDismissAnimator$default(this, getMBinding().vRadar.getContentViewView(), 0.0f, 0.0f, 6, null);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorCreateDismissAnimator$default, objectAnimatorCreateDismissAnimator$default2, objectAnimatorCreateDismissAnimator$default3, objectAnimatorCreateDismissAnimator$default4, objectAnimatorCreateDismissAnimator$default5, objectAnimatorCreateDismissAnimator$default7, objectAnimatorCreateDismissAnimator$default6);
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment.dismissAnimation.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                action.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                action.invoke();
            }
        });
        animatorSet.start();
    }

    private final void showAnimation() {
        final View contentViewView = getMBinding().vRadar.getContentViewView();
        contentViewView.postDelayed(new Runnable() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                EarTwosSimpleEQFragment.showAnimation$lambda$13(this.f$0, contentViewView);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAnimation$lambda$13(EarTwosSimpleEQFragment earTwosSimpleEQFragment, View view) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            boolean z = earTwosSimpleEQFragment.getTopBarMask() == null;
            View topBarMask = earTwosSimpleEQFragment.getTopBarMask();
            Integer numValueOf = topBarMask != null ? Integer.valueOf(topBarMask.getHeight()) : null;
            View topBarMask2 = earTwosSimpleEQFragment.getTopBarMask();
            String str = "eq simple animal showAnimation getTopBarMask()=" + z + " height:" + numValueOf + ",visibility=" + (topBarMask2 != null && topBarMask2.getVisibility() == 0);
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
        View topBarMask3 = earTwosSimpleEQFragment.getTopBarMask();
        if (topBarMask3 != null && topBarMask3.getHeight() == 0) {
            ViewGroup.LayoutParams layoutParams = topBarMask3.getLayoutParams();
            Application context = earTwosSimpleEQFragment.getContext();
            if (context == null) {
                Application application = AppGlobals.INSTANCE.get();
                Intrinsics.checkNotNull(application);
                context = application;
            }
            layoutParams.height = ContextExtKt.dp2px(context, 60.0f);
            topBarMask3.setLayoutParams(layoutParams);
            topBarMask3.requestLayout();
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            boolean z2 = earTwosSimpleEQFragment.getTopBarMask() == null;
            View topBarMask4 = earTwosSimpleEQFragment.getTopBarMask();
            Integer numValueOf2 = topBarMask4 != null ? Integer.valueOf(topBarMask4.getHeight()) : null;
            View topBarMask5 = earTwosSimpleEQFragment.getTopBarMask();
            String str4 = "eq simple animal showAnimation getTopBarMask()=" + z2 + " height:" + numValueOf2 + ",visibility=" + (topBarMask5 != null && topBarMask5.getVisibility() == 0);
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
        ObjectAnimator objectAnimatorCreateShowAnimator$default = createShowAnimator$default(earTwosSimpleEQFragment, earTwosSimpleEQFragment.getTopBarMask(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default2 = createShowAnimator$default(earTwosSimpleEQFragment, earTwosSimpleEQFragment.getActionBarMask(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default3 = createShowAnimator$default(earTwosSimpleEQFragment, earTwosSimpleEQFragment.getMBinding().ivBottomMask, 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default4 = createShowAnimator$default(earTwosSimpleEQFragment, earTwosSimpleEQFragment.getMBinding().ivTopMask, 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default5 = createShowAnimator$default(earTwosSimpleEQFragment, earTwosSimpleEQFragment.getMBinding().vRadar.getMaskView(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default6 = createShowAnimator$default(earTwosSimpleEQFragment, earTwosSimpleEQFragment.getMBinding().vRadar.getTriangle(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default7 = createShowAnimator$default(earTwosSimpleEQFragment, view, 0.0f, 0.0f, 6, null);
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
        Property property = View.TRANSLATION_Y;
        Context context2 = earTwosSimpleEQFragment.getContext();
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat((Property<?, Float>) property, context2 != null ? ContextExtKt.dp2px(context2, 50.0f) : 0.0f, 0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(...)");
        View triangle = earTwosSimpleEQFragment.getMBinding().vRadar.getTriangle();
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[1];
        Property property2 = View.TRANSLATION_Y;
        Context context3 = earTwosSimpleEQFragment.getContext();
        propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat((Property<?, Float>) property2, context3 != null ? ContextExtKt.dp2px(context3, 50.0f) : 0.0f, 0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(triangle, propertyValuesHolderArr2);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder2, "ofPropertyValuesHolder(...)");
        objectAnimatorOfPropertyValuesHolder.setStartDelay(100L);
        objectAnimatorOfPropertyValuesHolder.setDuration(300L);
        objectAnimatorCreateShowAnimator$default7.setDuration(300L);
        objectAnimatorCreateShowAnimator$default7.setStartDelay(100L);
        objectAnimatorOfPropertyValuesHolder2.setStartDelay(100L);
        objectAnimatorOfPropertyValuesHolder2.setDuration(300L);
        objectAnimatorCreateShowAnimator$default6.setStartDelay(100L);
        objectAnimatorCreateShowAnimator$default6.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorCreateShowAnimator$default, objectAnimatorCreateShowAnimator$default2, objectAnimatorCreateShowAnimator$default3, objectAnimatorCreateShowAnimator$default4, objectAnimatorCreateShowAnimator$default5, objectAnimatorCreateShowAnimator$default7, objectAnimatorCreateShowAnimator$default6, objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.start();
    }

    private final void dismissTipsListener() {
        getMBinding().vRadar.getTriangle().setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getMBinding().vRadar.getMaskView().setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getMBinding().vRadar.getContentViewView().setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getMBinding().ivBottomMask.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getMBinding().ivTopMask.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        View actionBarMask = getActionBarMask();
        if (actionBarMask != null) {
            actionBarMask.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.showTips(false);
                }
            });
        }
        View topBarMask = getTopBarMask();
        if (topBarMask != null) {
            topBarMask.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EarTwosSimpleEQFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.showTips(false);
                }
            });
        }
    }

    private final boolean isShowTips() {
        View actionBarMask = getActionBarMask();
        return actionBarMask != null && actionBarMask.getVisibility() == 0;
    }

    @Override // com.nothing.earbase.equalizer.fragment.SimpleEQFragment, com.nothing.base.view.BaseFragment
    public void onInitObserver(BaseEqualiserSimpleFragmentBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.onInitObserver(binding);
        dismissTipsListener();
        this.hdacWarningViewModel.getTitle().set(getString(R.string.attention));
        this.hdacWarningViewModel.getMsg().set(getString(R.string.unavailable_msg, getString(R.string.ear_personalised_sound), getString(R.string.ldac_name)));
        this.hdacWarningViewModel.getPositionBtn().set(getString(R.string.okay));
        this.hdacWarningViewModel.getNegativeVisible().set(false);
    }

    @Override // com.nothing.earbase.equalizer.fragment.SimpleEQFragment, com.nothing.base.view.BaseFragment
    public void onResumeLazy(int loadStatus) {
        super.onResumeLazy(loadStatus);
    }

    @Override // com.nothing.base.view.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
