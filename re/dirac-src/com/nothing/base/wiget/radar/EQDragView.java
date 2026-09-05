package com.nothing.base.wiget.radar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.ear.R;
import com.nothing.ear.databinding.EqRadarSeekLayoutBinding;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EQDragView.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u0094\u00012\u00020\u00012\u00020\u0002:\u0002\u0094\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0005\u0010\fJ\"\u0010>\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010@\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010A\u001a\u0002082\u0006\u0010B\u001a\u000208H\u0002J\u0018\u0010C\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010D\u001a\u000208H\u0002J\u0010\u0010E\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010F\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020)J\u000e\u0010I\u001a\u00020?2\u0006\u0010J\u001a\u00020\u001dJ\u000e\u0010K\u001a\u00020?2\u0006\u0010L\u001a\u00020/J\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020NJ\u0006\u0010P\u001a\u00020NJ\u0006\u0010Q\u001a\u00020NJ\n\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u0012\u0010T\u001a\u0004\u0018\u00010S2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020?H\u0016J\u0010\u0010X\u001a\u00020?2\u0006\u0010Y\u001a\u00020/H\u0002J\b\u0010Z\u001a\u00020?H\u0002J\b\u0010[\u001a\u00020?H\u0002J\b\u0010\\\u001a\u00020?H\u0002J\u0018\u0010]\u001a\u00020?2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000bH\u0002J \u0010a\u001a\u00020?2\u0006\u0010`\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020_H\u0002J\u0017\u0010c\u001a\u00020\u000b2\b\u0010d\u001a\u0004\u0018\u00010/H\u0002\u00a2\u0006\u0002\u0010eJ\b\u0010f\u001a\u00020?H\u0002J\u0010\u0010g\u001a\u00020?2\u0006\u0010^\u001a\u00020_H\u0002J\u0018\u0010h\u001a\u00020?2\u0006\u0010^\u001a\u00020_2\u0006\u0010i\u001a\u00020/H\u0002J\u0018\u0010j\u001a\u00020?2\u0006\u0010`\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000bH\u0002J\u0014\u0010k\u001a\u00020?2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0016\u0010m\u001a\u00020?2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010oJ\u0018\u0010p\u001a\u00020?2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010oH\u0002J\u000e\u0010q\u001a\u00020?2\u0006\u0010n\u001a\u00020\u000bJ\b\u0010r\u001a\u00020?H\u0002J\b\u0010s\u001a\u00020?H\u0002J\b\u0010t\u001a\u00020?H\u0002J\b\u0010u\u001a\u00020?H\u0002J\b\u0010v\u001a\u00020?H\u0002J\b\u0010w\u001a\u00020?H\u0002J\u0018\u0010x\u001a\u00020?2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010oH\u0002J\"\u0010y\u001a\u00020?2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020{0\u00142\n\u0010|\u001a\u00060}R\u000205H\u0002J\u001e\u0010~\u001a\u00060}R\u000205*\u0002052\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020{0\u0014H\u0002J\u0019\u0010\u0080\u0001\u001a\u00020/2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010oH\u0002J\u0019\u0010\u0080\u0001\u001a\u00020/2\b\u0010n\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0003\u0010\u0081\u0001J)\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010\u00142\u0007\u0010\u0084\u0001\u001a\u00020/2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010oH\u0002J \u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010\u00142\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010oH\u0003J\t\u0010\u0086\u0001\u001a\u00020?H\u0002J\t\u0010\u0087\u0001\u001a\u00020?H\u0002J\u000f\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020{0\u0014H\u0002J\u000f\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020{0\u0014H\u0002J\u0019\u0010\u008a\u0001\u001a\u00020?2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010oH\u0002J\t\u0010\u008b\u0001\u001a\u00020?H\u0002J\u001c\u0010\u008c\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020/2\u0007\u0010\u008d\u0001\u001a\u00020NH\u0002J*\u0010\u008e\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0005\u0012\u00030\u0083\u00010\u008f\u00012\u0007\u0010\u0084\u0001\u001a\u00020/2\u0007\u0010\u008d\u0001\u001a\u00020NH\u0003J$\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0006\u0010b\u001a\u00020\u000b2\u0007\u0010\u0092\u0001\u001a\u00020_2\u0007\u0010\u0084\u0001\u001a\u00020/H\u0002J\u0007\u0010\u0093\u0001\u001a\u00020/R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000208X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u000208X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0095\u0001"}, d2 = {"Lcom/nothing/base/wiget/radar/EQDragView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/nothing/ear/databinding/EqRadarSeekLayoutBinding;", "getBinding", "()Lcom/nothing/ear/databinding/EqRadarSeekLayoutBinding;", "setBinding", "(Lcom/nothing/ear/databinding/EqRadarSeekLayoutBinding;)V", "radarItemList", "", "Lcom/nothing/base/wiget/radar/EQLabelItem;", "changeListener", "Lcom/nothing/base/wiget/radar/OnEQChangeListener;", "getChangeListener", "()Lcom/nothing/base/wiget/radar/OnEQChangeListener;", "setChangeListener", "(Lcom/nothing/base/wiget/radar/OnEQChangeListener;)V", "mimiListener", "Lcom/nothing/base/wiget/radar/OnMimiListener;", "viewModel", "Lcom/nothing/base/wiget/radar/EQLabelViewModel;", "getViewModel", "()Lcom/nothing/base/wiget/radar/EQLabelViewModel;", "setViewModel", "(Lcom/nothing/base/wiget/radar/EQLabelViewModel;)V", "leftPoint", "Landroid/graphics/PointF;", "rightPoint", "topPoint", "tip", "", "getTip", "()Ljava/lang/String;", "setTip", "(Ljava/lang/String;)V", "isSystemPage", "", "()Z", "setSystemPage", "(Z)V", "lastResId", "animateSet", "Landroid/animation/AnimatorSet;", "diracEQRes", "scale", "", "getScale", "()F", "setScale", "(F)V", "scaleInner", "initView", "", "dynamicSetCoverWidth", "baseSimpleHeight", "baseSimpleWidth", "updateScale", "baseScale", "setDefaultStyle", "setSystemStyle", "setTvSummaryTextValue", "earName", "setMimiView", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateMimiStyle", "mimiHasData", "getMimiIconView", "Landroid/view/View;", "getMaskView", "getTriangle", "getContentViewView", "createLetteraTypeFace", "Landroid/graphics/Typeface;", "createNotTypeFace", "textView", "Landroid/widget/TextView;", "onGlobalLayout", "updateCircle", "isDrag", "getLeftCenterPoint", "getRightCenterPoint", "getTopCenterPoint", "initSeekViewMax", "seekView", "Lcom/nothing/base/wiget/radar/EQSeekBar;", "index", "seekBarChange", "progress", "getSelectedColor", "selected", "(Ljava/lang/Boolean;)I", "updateTextColor", "hapticSeekView", "setSeekBarFocus", "focus", "updateRadarCoverRegion", "setRadarList", "list", "setRealRadarStyle", "res", "Landroidx/databinding/ObservableField;", "setStyleByRes", "setDiracOpteoStyle", "setCustomThenNotify", "initStatus", "firstSetThenNotify", "alreadySetThenNotify", "createAnimationSet", "initCustomStatus", "presetToPresetAnimation", "playAfter", "showAnimators", "Landroid/animation/Animator;", "builder", "Landroid/animation/AnimatorSet$Builder;", "playTogetherReturnBuilder", "animators", "isDiracEQ", "(Ljava/lang/Integer;)Z", "animationCover", "Landroid/animation/ObjectAnimator;", "isDismiss", "animationDiracEQ", "updateProgress", "updateText", "dismissCustomAnimations", "showCustomAnimations", "customToPresetAnimation", "presetToCustomAnimation", "animationAlpha", "view", "animationScale", "Lkotlin/Pair;", "dismissSeekbarToZero", "Landroid/animation/ValueAnimator;", "seekBar", "isDragging", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class EQDragView extends ConstraintLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final long ANIMATION_100 = 100;
    public static final long ANIMATION_1300 = 1300;
    public static final long ANIMATION_200 = 200;
    public static final long ANIMATION_300 = 300;
    public static final long ANIMATION_600 = 600;
    public static final long ANIMATION_700 = 700;
    public static final float ANIMATION_ALPHA_0 = 0.0f;
    public static final float ANIMATION_ALPHA_1 = 1.0f;
    public static final float ANIMATION_ALPHA_HALF = 0.5f;
    public static final float ANIMATION_SCALE_1 = 1.0f;
    public static final float ANIMATION_SCALE_HALF = 0.5f;
    public static final int COS_ANGLE_180 = -1;
    public static final float COS_ANGLE_30 = 0.8660254f;
    private static final float COVER_WIDTH = 240.0f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float DEFAULT_SCALE = 0.95f;
    public static final long DELAY = 200;
    private static final float DIRAC_SCALE_1 = 0.021857923f;
    private static final float DIRAC_SCALE_2 = 0.73770493f;
    private static final float DIRAC_SCALE_3 = 1.0f;
    private static final int HALF = 2;
    public static final float LINE_HEIGHT = 1.0f;
    private static final float MARGIN_BOTTOM = 40.0f;
    public static final int MAX_PROGRESS = 12;
    private static final float NORMAL_SHOW_SIZE = 40.0f;
    private static final float NORMAL_SIZE = 13.0f;
    private static final float NT_SHOW_SIZE = 36.0f;
    private static final float NT_SIZE = 16.0f;
    public static final float ONE_FOUR = 0.25f;
    public static final float ONE_HALF = 0.5f;
    private static final float OS_DEFAULT_SCALE = 0.9f;
    public static final int RADAR_INT = 10;
    public static final int RADAR_MAX = 12;
    public static final int RADAR_ONE = 1;
    public static final float RADAR_PADDING = 48.0f;
    public static final float RADAR_PARENT_WIDTH = 414.0f;
    public static final int RADAR_SIZE = 3;
    public static final int RADAR_TEN = 10;
    public static final int RADAR_TWO = 2;
    public static final float RADAR_WIDTH = 366.0f;
    public static final int RADAR_ZERO = 0;
    public static final float SCALE_DEFAULT = 0.95f;
    public static final float SCALE_MAX = 1.0f;
    public static final int SIN_ANGLE_180 = 0;
    public static final float SIN_ANGLE_30 = 0.5f;
    private static final float SUMMARY_SIZE = 14.0f;
    public static final float THUMB_WIDTH = 22.0f;
    private static final float TITLE_SIZE = 22.0f;
    private AnimatorSet animateSet;
    public EqRadarSeekLayoutBinding binding;
    private OnEQChangeListener changeListener;
    private int diracEQRes;
    private boolean isSystemPage;
    private int lastResId;
    private PointF leftPoint;
    private OnMimiListener mimiListener;
    private List<EQLabelItem> radarItemList;
    private PointF rightPoint;
    private float scale;
    private float scaleInner;
    private String tip;
    private PointF topPoint;
    public EQLabelViewModel viewModel;

    @BindingAdapter(requireAll = false, value = {"radarStyle", "diracOpteoRes", "coverSize"})
    @JvmStatic
    public static final void setRadaStyle(EQDragView eQDragView, ObservableField<Integer> observableField, Integer num, float f) {
        INSTANCE.setRadaStyle(eQDragView, observableField, num, f);
    }

    public final EqRadarSeekLayoutBinding getBinding() {
        EqRadarSeekLayoutBinding eqRadarSeekLayoutBinding = this.binding;
        if (eqRadarSeekLayoutBinding != null) {
            return eqRadarSeekLayoutBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(EqRadarSeekLayoutBinding eqRadarSeekLayoutBinding) {
        Intrinsics.checkNotNullParameter(eqRadarSeekLayoutBinding, "<set-?>");
        this.binding = eqRadarSeekLayoutBinding;
    }

    public final OnEQChangeListener getChangeListener() {
        return this.changeListener;
    }

    public final void setChangeListener(OnEQChangeListener onEQChangeListener) {
        this.changeListener = onEQChangeListener;
    }

    public final EQLabelViewModel getViewModel() {
        EQLabelViewModel eQLabelViewModel = this.viewModel;
        if (eQLabelViewModel != null) {
            return eQLabelViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(EQLabelViewModel eQLabelViewModel) {
        Intrinsics.checkNotNullParameter(eQLabelViewModel, "<set-?>");
        this.viewModel = eQLabelViewModel;
    }

    public final String getTip() {
        return this.tip;
    }

    public final void setTip(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tip = str;
    }

    /* JADX INFO: renamed from: isSystemPage, reason: from getter */
    public final boolean getIsSystemPage() {
        return this.isSystemPage;
    }

    public final void setSystemPage(boolean z) {
        this.isSystemPage = z;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EQDragView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.leftPoint = new PointF(0.0f, 0.0f);
        this.rightPoint = new PointF(0.0f, 0.0f);
        this.topPoint = new PointF(0.0f, 0.0f);
        this.tip = "";
        this.lastResId = -1;
        this.diracEQRes = -10;
        this.scale = 1.0f;
        this.scaleInner = 0.95f;
        initView(context, null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EQDragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.leftPoint = new PointF(0.0f, 0.0f);
        this.rightPoint = new PointF(0.0f, 0.0f);
        this.topPoint = new PointF(0.0f, 0.0f);
        this.tip = "";
        this.lastResId = -1;
        this.diracEQRes = -10;
        this.scale = 1.0f;
        this.scaleInner = 0.95f;
        initView(context, attrs, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EQDragView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.leftPoint = new PointF(0.0f, 0.0f);
        this.rightPoint = new PointF(0.0f, 0.0f);
        this.topPoint = new PointF(0.0f, 0.0f);
        this.tip = "";
        this.lastResId = -1;
        this.diracEQRes = -10;
        this.scale = 1.0f;
        this.scaleInner = 0.95f;
        initView(context, attrs, i);
    }

    private final void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.EQDragView, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.EQDragView_eq_base_scale, 1.0f);
        float f2 = typedArrayObtainStyledAttributes.getFloat(R.styleable.EQDragView_eq_base_simple_width, 240.0f);
        float f3 = typedArrayObtainStyledAttributes.getFloat(R.styleable.EQDragView_eq_base_simple_height, 240.0f);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        setViewModel(new EQLabelViewModel());
        this.tip = context.getString(R.string.eq_slide_desc);
        setBinding((EqRadarSeekLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.eq_radar_seek_layout, this, true));
        dynamicSetCoverWidth(context, f3, f2);
        if (context instanceof BaseActivity) {
            this.isSystemPage = ((BaseActivity) context).isSystemPage();
        }
        if (this.isSystemPage) {
            setSystemStyle(context);
        } else {
            setDefaultStyle(context);
        }
        updateScale(context, f);
        getBinding().setViewModel(getViewModel());
        getBinding().executePendingBindings();
        EQSeekBar topSeek = getBinding().topSeek;
        Intrinsics.checkNotNullExpressionValue(topSeek, "topSeek");
        initSeekViewMax(topSeek, 0);
        EQSeekBar rightSeek = getBinding().rightSeek;
        Intrinsics.checkNotNullExpressionValue(rightSeek, "rightSeek");
        initSeekViewMax(rightSeek, 1);
        EQSeekBar leftSeek = getBinding().leftSeek;
        Intrinsics.checkNotNullExpressionValue(leftSeek, "leftSeek");
        initSeekViewMax(leftSeek, 2);
        float f4 = 1;
        getBinding().tvTitle.setTextSize(0, ContextExtKt.sp2px(context, ((f4 - this.scale) * 22.0f) + 22.0f));
        getBinding().tvSummary.setTextSize(0, ContextExtKt.sp2px(context, ((f4 - this.scale) * 14.0f) + 14.0f));
        getBinding().leftSeek.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dynamicSetCoverWidth(Context context, float baseSimpleHeight, float baseSimpleWidth) {
        if (baseSimpleWidth == 0.0f || baseSimpleHeight == 0.0f) {
            return;
        }
        float fFloatValue = ContextExtKt.getDesignDensityParams(context, true, true).getSecond().floatValue();
        ViewGroup.LayoutParams layoutParams = getBinding().ivCover.getLayoutParams();
        layoutParams.height = (int) (baseSimpleHeight * fFloatValue);
        layoutParams.width = (int) (baseSimpleWidth * fFloatValue);
        getBinding().ivCover.setLayoutParams(layoutParams);
    }

    private final void updateScale(Context context, float baseScale) {
        int iDpByDesign2px = ContextExtKt.dpByDesign2px(context, 366.0f);
        int iDpByDesign2px2 = ContextExtKt.dpByDesign2px(context, 414.0f);
        int screenWidth = ScreenUtils.getScreenWidth();
        if (iDpByDesign2px2 >= screenWidth) {
            float f = (iDpByDesign2px * baseScale) / screenWidth;
            this.scale = f;
            this.scaleInner *= f;
        }
        getViewModel().setScaleInner(this.scaleInner);
        getViewModel().setScale(this.scale);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "screenWidth " + screenWidth + ",screenWidth " + screenWidth + ",screen " + iDpByDesign2px2 + " scale " + this.scale;
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

    private final void setDefaultStyle(Context context) {
        getBinding().tvShowValue.setTextColor(ContextCompat.getColor(context, R.color.nt_D71921));
        getBinding().tvTreble.setTypeface(createLetteraTypeFace());
        getBinding().tvMid.setTypeface(createLetteraTypeFace());
        getBinding().tvBass.setTypeface(createLetteraTypeFace());
        getBinding().tvShowValue.setTypeface(createLetteraTypeFace());
        getBinding().tvShowValue.setTextSize(0, ContextExtKt.sp2px(context, 40.0f));
        getBinding().tvTreble.setTextSize(0, ContextExtKt.sp2px(context, 13.0f));
        getBinding().tvMid.setTextSize(0, ContextExtKt.sp2px(context, 13.0f));
        getBinding().tvBass.setTextSize(0, ContextExtKt.sp2px(context, 13.0f));
        getBinding().ivTripleBg.setImageResource(R.drawable.equalizer_triple_background_default);
    }

    private final void setSystemStyle(Context context) {
        getBinding().ivTripleBg.setImageResource(R.drawable.os_equalizer_triple_background);
        AppCompatTextView appCompatTextView = getBinding().tvTreble;
        AppCompatTextView tvTreble = getBinding().tvTreble;
        Intrinsics.checkNotNullExpressionValue(tvTreble, "tvTreble");
        appCompatTextView.setTypeface(createNotTypeFace(tvTreble));
        getBinding().tvTreble.setTextSize(0, ContextExtKt.sp2px(context, NT_SIZE));
        AppCompatTextView appCompatTextView2 = getBinding().tvMid;
        AppCompatTextView tvMid = getBinding().tvMid;
        Intrinsics.checkNotNullExpressionValue(tvMid, "tvMid");
        appCompatTextView2.setTypeface(createNotTypeFace(tvMid));
        getBinding().tvMid.setTextSize(0, ContextExtKt.sp2px(context, NT_SIZE));
        AppCompatTextView appCompatTextView3 = getBinding().tvBass;
        AppCompatTextView tvBass = getBinding().tvBass;
        Intrinsics.checkNotNullExpressionValue(tvBass, "tvBass");
        appCompatTextView3.setTypeface(createNotTypeFace(tvBass));
        getBinding().tvBass.setTextSize(0, ContextExtKt.sp2px(context, NT_SIZE));
        TextView textView = getBinding().tvShowValue;
        TextView tvShowValue = getBinding().tvShowValue;
        Intrinsics.checkNotNullExpressionValue(tvShowValue, "tvShowValue");
        textView.setTypeface(createNotTypeFace(tvShowValue));
        getBinding().tvShowValue.setTextColor(ContextCompat.getColor(context, R.color.os_text_5));
        getBinding().tvShowValue.setTextSize(0, ContextExtKt.sp2px(context, NT_SHOW_SIZE));
        ViewGroup.LayoutParams layoutParams = getBinding().tvShowValue.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = ContextExtKt.dp2px(context, 40.0f);
        getBinding().tvShowValue.setLayoutParams(marginLayoutParams);
        updateTextColor();
    }

    public final void setTvSummaryTextValue(String earName) {
        Intrinsics.checkNotNullParameter(earName, "earName");
        TextView textView = getBinding().tvSummary;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(ContextExtKt.getLocalizedResources(context).getString(R.string.personalised_guide_summary, earName));
    }

    public final void setMimiView(OnMimiListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mimiListener = listener;
        if (listener != null) {
            listener.onInit();
        }
        getBinding().ivMimi.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.base.wiget.radar.EQDragView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EQDragView.setMimiView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMimiView$lambda$1(EQDragView eQDragView, View view) {
        OnMimiListener onMimiListener;
        com.nothing.base.binding.BindingAdapter bindingAdapter = com.nothing.base.binding.BindingAdapter.INSTANCE;
        Intrinsics.checkNotNull(view);
        if (bindingAdapter.unSafeClick(view) || (onMimiListener = eQDragView.mimiListener) == null) {
            return;
        }
        onMimiListener.onClick(eQDragView.getViewModel().getMimiHasData());
    }

    public final void updateMimiStyle(boolean mimiHasData) {
        getViewModel().setMimiHasData(mimiHasData);
        getViewModel().getMimiVisible().set(true);
        if (mimiHasData) {
            getBinding().ivMimi.setImageResource(R.drawable.mimi_eq_icon_open);
        } else {
            getBinding().ivMimi.setImageResource(R.drawable.mimi_eq_icon_normal);
        }
    }

    public final View getMimiIconView() {
        ImageView ivMimi = getBinding().ivMimi;
        Intrinsics.checkNotNullExpressionValue(ivMimi, "ivMimi");
        return ivMimi;
    }

    public final View getMaskView() {
        View ivMask = getBinding().ivMask;
        Intrinsics.checkNotNullExpressionValue(ivMask, "ivMask");
        return ivMask;
    }

    public final View getTriangle() {
        ImageView ivTriangle = getBinding().ivTriangle;
        Intrinsics.checkNotNullExpressionValue(ivTriangle, "ivTriangle");
        return ivTriangle;
    }

    public final View getContentViewView() {
        RoundLinearLayout llPop = getBinding().llPop;
        Intrinsics.checkNotNullExpressionValue(llPop, "llPop");
        return llPop;
    }

    private final Typeface createLetteraTypeFace() {
        return ResourcesCompat.getFont(getContext(), R.font.lettera_monoll_regular);
    }

    private final Typeface createNotTypeFace(TextView textView) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ContextExtKt.getNtype82(context, textView);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        getBinding().leftSeek.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        updateCircle(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCircle(boolean isDrag) {
        getLeftCenterPoint();
        getRightCenterPoint();
        getTopCenterPoint();
        getBinding().circle.update(this.topPoint, this.rightPoint, this.leftPoint, getBinding().leftSeek.getThumb().getIntrinsicWidth() * 0.5f, isDrag, this.scaleInner);
    }

    private final void getLeftCenterPoint() {
        EQSeekBar eQSeekBar = getBinding().leftSeek;
        if (eQSeekBar.getWidth() == 0) {
            return;
        }
        float width = eQSeekBar.getWidth() * 0.5f;
        Rect bounds = eQSeekBar.getThumb().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        float f = bounds.left + ((bounds.right - bounds.left) * 0.5f);
        float x = getBinding().circle.getX() + (getBinding().circle.getWidth() * 0.5f);
        float y = getBinding().circle.getY() + (getBinding().circle.getHeight() * 0.5f);
        float fAbs = ((Math.abs((eQSeekBar.getX() + width) - (getBinding().ivCenter.getX() + (getBinding().ivCenter.getHeight() * 0.5f))) / 0.8660254f) - width) + f;
        if (eQSeekBar.getLayoutDirection() == 1) {
            this.leftPoint.x = x + (0.8660254f * fAbs);
            this.leftPoint.y = y + (fAbs * 0.5f);
            return;
        }
        this.leftPoint.x = x - (0.8660254f * fAbs);
        this.leftPoint.y = y + (fAbs * 0.5f);
    }

    private final void getRightCenterPoint() {
        EQSeekBar eQSeekBar = getBinding().rightSeek;
        if (eQSeekBar.getWidth() == 0) {
            return;
        }
        float width = eQSeekBar.getWidth() * 0.5f;
        Rect bounds = eQSeekBar.getThumb().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        float f = bounds.left + ((bounds.right - bounds.left) * 0.5f);
        float x = getBinding().circle.getX() + (getBinding().circle.getWidth() * 0.5f);
        float y = getBinding().circle.getY() + (getBinding().circle.getHeight() * 0.5f);
        float fAbs = ((Math.abs((eQSeekBar.getX() + width) - (getBinding().ivCenter.getX() + (getBinding().ivCenter.getHeight() * 0.5f))) / 0.8660254f) - width) + f;
        if (eQSeekBar.getLayoutDirection() == 1) {
            this.rightPoint.x = x - (0.8660254f * fAbs);
            this.rightPoint.y = y + (fAbs * 0.5f);
            return;
        }
        this.rightPoint.x = x + (0.8660254f * fAbs);
        this.rightPoint.y = y + (fAbs * 0.5f);
    }

    private final void getTopCenterPoint() {
        EQSeekBar eQSeekBar = getBinding().topSeek;
        if (eQSeekBar.getWidth() == 0) {
            return;
        }
        float width = eQSeekBar.getWidth() * 0.5f;
        float height = eQSeekBar.getHeight() * 0.5f;
        Rect bounds = eQSeekBar.getThumb().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        float f = bounds.left + ((bounds.right - bounds.left) * 0.5f);
        float x = getBinding().circle.getX() + (getBinding().circle.getWidth() * 0.5f);
        float y = getBinding().circle.getY() + (getBinding().circle.getHeight() * 0.5f);
        float y2 = ((getBinding().ivCenter.getY() + (getBinding().ivCenter.getHeight() * 0.5f)) - ((eQSeekBar.getY() + height) + width)) + f;
        this.topPoint.x = x;
        PointF pointF = this.topPoint;
        Context context = eQSeekBar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        pointF.y = (y - y2) + ContextExtKt.dp2px(context, 1.0f);
    }

    private final void initSeekViewMax(final EQSeekBar seekView, final int index) {
        seekView.setMax(12);
        seekView.setProgress(0);
        seekView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.nothing.base.wiget.radar.EQDragView.initSeekViewMax.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(event, "event");
                super.onInitializeAccessibilityEvent(host, event);
                if (event.getEventType() == 128) {
                    int i = index;
                    if (i == 0) {
                        this.getBinding().tvMid.announceForAccessibility(((Object) this.getViewModel().getMidText().get()) + this.getTip());
                        return;
                    }
                    if (i == 1) {
                        this.getBinding().tvTreble.announceForAccessibility(((Object) this.getViewModel().getTrebleText().get()) + this.getTip());
                        return;
                    }
                    if (i != 2) {
                        return;
                    }
                    this.getBinding().tvBass.announceForAccessibility(((Object) this.getViewModel().getBassText().get()) + this.getTip());
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View host, int eventType) {
                Intrinsics.checkNotNullParameter(host, "host");
                if (eventType == 32768) {
                    eventType = 65536;
                }
                super.sendAccessibilityEvent(host, eventType);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.getEventType() == 2048 || event.getEventType() == 4) {
                    return;
                }
                super.sendAccessibilityEventUnchecked(host, event);
            }
        });
        seekView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.nothing.base.wiget.radar.EQDragView.initSeekViewMax.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar p0, int progress, boolean p2) {
                if (seekView.getTag(R.id.eq_drag_view_tag) != null) {
                    return;
                }
                this.seekBarChange(index, progress, seekView);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar p0) {
                int i;
                this.getViewModel().getMidSelected().set(Boolean.valueOf(index == 0));
                this.getViewModel().getTrebleSelected().set(Boolean.valueOf(index == 1));
                this.getViewModel().getBassSelected().set(Boolean.valueOf(index == 2));
                int i2 = index;
                if (i2 == 0) {
                    i = R.drawable.equalizer_triple_background_mid;
                } else if (i2 == 1) {
                    i = R.drawable.equalizer_triple_background_treble;
                } else if (i2 == 2) {
                    i = R.drawable.equalizer_triple_background_bass;
                } else {
                    i = R.drawable.equalizer_triple_background_default;
                }
                this.getViewModel().getSelectBgImage().set(Integer.valueOf(i));
                this.updateTextColor();
                this.getViewModel().getShowValueVisible().set(true);
                this.updateCircle(true);
                this.setSeekBarFocus(seekView, true);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar p0) {
                this.updateRadarCoverRegion(index, seekView.getProgress());
                this.setSeekBarFocus(seekView, false);
                this.getViewModel().getShowValueVisible().set(false);
                this.updateCircle(false);
                this.getViewModel().getMidSelected().set(false);
                this.getViewModel().getTrebleSelected().set(false);
                this.getViewModel().getBassSelected().set(false);
                this.getViewModel().getSelectBgImage().set(Integer.valueOf(R.drawable.equalizer_triple_background_default));
                this.updateTextColor();
                Logger logger = Logger.INSTANCE;
                int i = index;
                Logger logger2 = logger;
                String tag = logger2.getTAG();
                int depth = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str = "onInitializeAccessibilityEvent -- " + i + "   onStopTrackingTouch";
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
                int i2 = index;
                if (i2 == 0) {
                    this.getBinding().tvMid.announceForAccessibility(this.getViewModel().getMidText().get());
                } else if (i2 == 1) {
                    this.getBinding().tvTreble.announceForAccessibility(this.getViewModel().getTrebleText().get());
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.getBinding().tvBass.announceForAccessibility(this.getViewModel().getBassText().get());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekBarChange(int index, int progress, EQSeekBar seekView) {
        List<EQLabelItem> list = this.radarItemList;
        if (list != null) {
            if (Intrinsics.areEqual((Object) getViewModel().getShowValueVisible().get(), (Object) true)) {
                getViewModel().setShowValueReal(list.get(index).convertToGain(progress));
                hapticSeekView(seekView);
            }
            if (index == 0) {
                getViewModel().setMidTextValue(list.get(index).getGain());
            } else if (index == 1) {
                getViewModel().setTrebleValue(list.get(index).getGain());
            } else if (index == 2) {
                getViewModel().setBassValue(list.get(index).getGain());
            }
            updateCircle(Intrinsics.areEqual((Object) getViewModel().getShowValueVisible().get(), (Object) true));
        }
    }

    private final int getSelectedColor(Boolean selected) {
        int i;
        Context context = getContext();
        if (Intrinsics.areEqual((Object) selected, (Object) true)) {
            i = R.color.os_text_5;
        } else {
            i = R.color.nt_F0F2F2_06080A;
        }
        return ContextCompat.getColor(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTextColor() {
        if (this.isSystemPage) {
            getBinding().tvMid.setTextColor(getSelectedColor(getViewModel().getMidSelected().get()));
            getBinding().tvBass.setTextColor(getSelectedColor(getViewModel().getBassSelected().get()));
            getBinding().tvTreble.setTextColor(getSelectedColor(getViewModel().getTrebleSelected().get()));
        }
    }

    private final void hapticSeekView(EQSeekBar seekView) {
        if (Build.VERSION.SDK_INT >= 30) {
            seekView.performHapticFeedback(12, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSeekBarFocus(EQSeekBar seekView, boolean focus) {
        if (focus) {
            if (this.isSystemPage) {
                seekView.getThumb().setTint(ContextCompat.getColor(getContext(), R.color.os_button_background));
                return;
            } else {
                seekView.getThumb().setTint(ContextCompat.getColor(getContext(), R.color.nt_D71921));
                return;
            }
        }
        seekView.getThumb().setTint(ContextCompat.getColor(getContext(), R.color.nt_F0F2F2_06080A));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRadarCoverRegion(int index, int progress) {
        OnEQChangeListener onEQChangeListener;
        List<EQLabelItem> list = this.radarItemList;
        if ((list == null || !list.isEmpty()) && (onEQChangeListener = this.changeListener) != null) {
            onEQChangeListener.onChange(index, progress);
        }
    }

    public final void setRadarList(List<EQLabelItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "EQ_MODE setRadarList " + list;
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
        this.radarItemList = list;
        if ((list != null ? list.size() : 0) < 3) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                if ("List<RadarItem> must be not less than three".length() == 0) {
                    return;
                }
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 6, str4, tag2, "List<RadarItem> must be not less than three " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.e(tag2 + strComponent3, "List<RadarItem> must be not less than three " + strComponent4);
                    return;
                }
                return;
            }
            return;
        }
        updateProgress();
        updateCircle(false);
        if (this.lastResId == 0) {
            getViewModel().getShowCustom().set(true);
            updateText();
        }
    }

    public final void setRealRadarStyle(ObservableField<Integer> res) {
        Integer num;
        if (res == null || (num = res.get()) == null) {
            return;
        }
        int iIntValue = num.intValue();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "EQ_MODE setRadarStyle " + iIntValue + StringUtils.SPACE + isDiracEQ(res);
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
        if (isDiracEQ(res)) {
            getViewModel().getShowCustom().set(false);
            getBinding().diracEq.setAlpha(0.0f);
            getBinding().diracEq.setVisibility(0);
            getBinding().tvMid.setVisibility(8);
            getBinding().tvBass.setVisibility(8);
            getBinding().tvTreble.setVisibility(8);
        } else {
            getBinding().diracEq.setVisibility(8);
            getBinding().tvMid.setVisibility(0);
            getBinding().tvBass.setVisibility(0);
            getBinding().tvTreble.setVisibility(0);
        }
        if (iIntValue == -1) {
            initStatus();
        } else if (iIntValue == 0) {
            setCustomThenNotify();
        } else {
            setStyleByRes(res);
        }
        this.lastResId = iIntValue;
    }

    private final void setStyleByRes(ObservableField<Integer> res) {
        if (!this.isSystemPage) {
            getBinding().ivTripleBg.setImageResource(R.drawable.equalizer_triple_background_default);
        }
        int i = this.lastResId;
        if (i == -1) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "first set value has no animation".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 4, str, tag, "first set value has no animation " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "first set value has no animation " + strComponent2);
                }
            }
            getViewModel().reset(0.0f, 0.0f, 0.0f);
            createAnimationSet();
            presetToPresetAnimation(res);
            getViewModel().getShowCustom().set(false);
            return;
        }
        if (i == 0) {
            createAnimationSet();
            AnimatorSet animatorSet = this.animateSet;
            if (animatorSet != null) {
                animatorSet.addListener(new Animator.AnimatorListener(this) { // from class: com.nothing.base.wiget.radar.EQDragView$setStyleByRes$$inlined$addListener$default$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        this.this$0.getViewModel().getShowCustom().set(false);
                        this.this$0.getViewModel().reset(0.0f, 0.0f, 0.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.this$0.getViewModel().getShowCustom().set(false);
                        this.this$0.getViewModel().reset(0.0f, 0.0f, 0.0f);
                    }
                });
            }
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "custom to preset".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 4, str2, tag2, "custom to preset " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "custom to preset " + strComponent4);
                }
            }
            customToPresetAnimation(res);
            return;
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true) && "preset to preset".length() != 0) {
            Pair<String, String> trace3 = logger3.getTrace(depth3);
            String strComponent5 = trace3.component1();
            String strComponent6 = trace3.component2();
            FileLog fileLog3 = FileLog.INSTANCE;
            String str3 = logger3.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog3, 4, str3, tag3, "preset to preset " + strComponent6, null, 16, null);
            if (logger3.isDebug()) {
                Log.i(tag3 + strComponent5, "preset to preset " + strComponent6);
            }
        }
        createAnimationSet();
        presetToPresetAnimation(res);
    }

    public final void setDiracOpteoStyle(int res) {
        this.diracEQRes = res;
    }

    private final void setCustomThenNotify() {
        if (!this.isSystemPage) {
            getBinding().ivTripleBg.setImageResource(R.drawable.equalizer_triple_background2);
        }
        updateProgress();
        if (this.lastResId != -1) {
            alreadySetThenNotify();
        } else {
            firstSetThenNotify();
        }
    }

    private final void initStatus() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "init status ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "init status  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "init status  " + strComponent2);
            }
        }
        getBinding().circle.setAlpha(0.0f);
        getBinding().circle.setScaleX(0.5f);
        getBinding().circle.setScaleY(0.5f);
        getBinding().leftSeek.setAlpha(0.0f);
        getBinding().rightSeek.setAlpha(0.0f);
        getBinding().topSeek.setAlpha(0.0f);
        getBinding().ivCover.setAlpha(0.0f);
        getBinding().ivCover.setScaleX(0.5f);
        getBinding().ivCover.setScaleY(0.5f);
        getBinding().ivTripleBg.setImageResource(R.drawable.equalizer_triple_background_default);
    }

    private final void firstSetThenNotify() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "first set value has no animation custom".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "first set value has no animation custom " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "first set value has no animation custom " + strComponent2);
            }
        }
        createAnimationSet();
        initCustomStatus();
        if (this.radarItemList != null) {
            getViewModel().getShowCustom().set(false);
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "EQ_MODE createAnimationSet".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 4, str2, tag2, "EQ_MODE createAnimationSet " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "EQ_MODE createAnimationSet " + strComponent4);
                }
            }
            updateCircle(false);
            getViewModel().getShowCustom().set(true);
        }
    }

    private final void alreadySetThenNotify() {
        if (this.lastResId == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "custom to custom will not be entry".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 6, str, tag, "custom to custom will not be entry " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.e(tag + strComponent1, "custom to custom will not be entry " + strComponent2);
                }
            }
        } else {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "preset to custom".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 4, str2, tag2, "preset to custom " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "preset to custom " + strComponent4);
                }
            }
            createAnimationSet();
            AnimatorSet animatorSet = this.animateSet;
            if (animatorSet != null) {
                animatorSet.addListener(new Animator.AnimatorListener(this) { // from class: com.nothing.base.wiget.radar.EQDragView$alreadySetThenNotify$$inlined$addListener$default$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        this.this$0.updateProgress();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.this$0.updateProgress();
                    }
                });
            }
            presetToCustomAnimation();
        }
        getViewModel().getShowCustom().set(true);
    }

    private final void createAnimationSet() {
        AnimatorSet animatorSet = this.animateSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.animateSet = animatorSet2;
        animatorSet2.setInterpolator(new FastOutSlowInInterpolator());
    }

    private final void initCustomStatus() {
        getBinding().circle.setAlpha(1.0f);
        getBinding().circle.setScaleX(1.0f);
        getBinding().circle.setScaleY(1.0f);
        getBinding().leftSeek.setAlpha(1.0f);
        getBinding().rightSeek.setAlpha(1.0f);
        getBinding().topSeek.setAlpha(1.0f);
        getBinding().ivCover.setAlpha(0.0f);
        getBinding().ivCover.setScaleX(0.5f);
        getBinding().ivCover.setScaleY(0.5f);
    }

    private final void presetToPresetAnimation(ObservableField<Integer> res) {
        List<ObjectAnimator> listAnimationCover;
        AnimatorSet animatorSet = this.animateSet;
        if (animatorSet != null) {
            List<ObjectAnimator> listAnimationCover2 = animationCover(true, res);
            if (isDiracEQ(res)) {
                listAnimationCover = animationDiracEQ(res);
            } else {
                listAnimationCover = animationCover(false, res);
            }
            playAfter(listAnimationCover2, playTogetherReturnBuilder(animatorSet, listAnimationCover));
            animatorSet.start();
        }
    }

    private final void playAfter(List<? extends Animator> showAnimators, AnimatorSet.Builder builder) {
        Iterator<? extends Animator> it = showAnimators.iterator();
        while (it.hasNext()) {
            builder.after(it.next());
        }
    }

    private final AnimatorSet.Builder playTogetherReturnBuilder(AnimatorSet animatorSet, List<? extends Animator> list) {
        AnimatorSet.Builder builderPlay = null;
        for (Animator animator : list) {
            if (builderPlay == null) {
                builderPlay = animatorSet.play(animator);
            } else {
                builderPlay.with(animator);
            }
        }
        Intrinsics.checkNotNull(builderPlay);
        return builderPlay;
    }

    private final boolean isDiracEQ(ObservableField<Integer> res) {
        if (res != null) {
            int i = this.diracEQRes;
            Integer num = res.get();
            if (num != null && i == num.intValue()) {
                return true;
            }
        }
        return false;
    }

    private final boolean isDiracEQ(Integer res) {
        return res != null && this.diracEQRes == res.intValue();
    }

    private final List<ObjectAnimator> animationCover(boolean isDismiss, final ObservableField<Integer> res) {
        ArrayList arrayList = new ArrayList();
        AppCompatImageView ivCover = getBinding().ivCover;
        Intrinsics.checkNotNullExpressionValue(ivCover, "ivCover");
        ObjectAnimator objectAnimatorAnimationAlpha = animationAlpha(isDismiss, ivCover);
        if (!isDismiss) {
            objectAnimatorAnimationAlpha.addListener(new Animator.AnimatorListener() { // from class: com.nothing.base.wiget.radar.EQDragView$animationCover$$inlined$addListener$default$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Integer num;
                    ObservableField observableField = res;
                    if (observableField == null || (num = (Integer) observableField.get()) == null) {
                        return;
                    }
                    this.getBinding().ivCover.setImageResource(num.intValue());
                }
            });
        }
        if (isDismiss && isDiracEQ(Integer.valueOf(this.lastResId))) {
            return arrayList;
        }
        AppCompatImageView ivCover2 = getBinding().ivCover;
        Intrinsics.checkNotNullExpressionValue(ivCover2, "ivCover");
        Pair<ObjectAnimator, ObjectAnimator> pairAnimationScale = animationScale(isDismiss, ivCover2);
        ObjectAnimator objectAnimatorComponent1 = pairAnimationScale.component1();
        ObjectAnimator objectAnimatorComponent2 = pairAnimationScale.component2();
        arrayList.add(objectAnimatorAnimationAlpha);
        arrayList.add(objectAnimatorComponent1);
        arrayList.add(objectAnimatorComponent2);
        return arrayList;
    }

    private final List<ObjectAnimator> animationDiracEQ(ObservableField<Integer> res) {
        Integer num;
        ArrayList arrayList = new ArrayList();
        AppCompatImageView diracEq = getBinding().diracEq;
        Intrinsics.checkNotNullExpressionValue(diracEq, "diracEq");
        if (res != null && (num = res.get()) != null) {
            diracEq.setImageResource(num.intValue());
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(diracEq, "alpha", 0.0f, 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(diracEq, "scaleX", DIRAC_SCALE_1, DIRAC_SCALE_2, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(diracEq, "scaleY", DIRAC_SCALE_1, DIRAC_SCALE_2, 1.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.setDuration(ANIMATION_1300);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        objectAnimatorOfFloat2.setDuration(ANIMATION_1300);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        objectAnimatorOfFloat3.setDuration(ANIMATION_1300);
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.nothing.base.wiget.radar.EQDragView$animationDiracEQ$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                this.this$0.getBinding().ivCover.setAlpha(0.0f);
                this.this$0.getBinding().diracEq.setAlpha(0.0f);
                this.this$0.getBinding().diracEq.setScaleX(0.021857923f);
                this.this$0.getBinding().diracEq.setScaleY(0.021857923f);
            }
        });
        arrayList.add(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat3);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProgress() {
        List<EQLabelItem> list = this.radarItemList;
        if (list != null) {
            getBinding().topSeek.setProgress(list.get(0).convertToProgress());
            getBinding().rightSeek.setProgress(list.get(1).convertToProgress());
            getBinding().leftSeek.setProgress(list.get(2).convertToProgress());
        }
        updateText();
    }

    private final void updateText() {
        List<EQLabelItem> list = this.radarItemList;
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (i == 0) {
                    getViewModel().setMidTextValue(list.get(i).getGain());
                } else if (i == 1) {
                    getViewModel().setTrebleValue(list.get(i).getGain());
                } else if (i == 2) {
                    getViewModel().setBassValue(list.get(i).getGain());
                }
                i = i2;
            }
        }
    }

    private final List<Animator> dismissCustomAnimations() {
        ArrayList arrayList = new ArrayList();
        EQInnerCircle circle = getBinding().circle;
        Intrinsics.checkNotNullExpressionValue(circle, "circle");
        ObjectAnimator objectAnimatorAnimationAlpha = animationAlpha(true, circle);
        EQInnerCircle circle2 = getBinding().circle;
        Intrinsics.checkNotNullExpressionValue(circle2, "circle");
        Pair<ObjectAnimator, ObjectAnimator> pairAnimationScale = animationScale(true, circle2);
        ObjectAnimator objectAnimatorComponent1 = pairAnimationScale.component1();
        ObjectAnimator objectAnimatorComponent2 = pairAnimationScale.component2();
        int progress = getBinding().leftSeek.getProgress();
        EQSeekBar leftSeek = getBinding().leftSeek;
        Intrinsics.checkNotNullExpressionValue(leftSeek, "leftSeek");
        ValueAnimator valueAnimatorDismissSeekbarToZero = dismissSeekbarToZero(progress, leftSeek, true);
        EQSeekBar leftSeek2 = getBinding().leftSeek;
        Intrinsics.checkNotNullExpressionValue(leftSeek2, "leftSeek");
        ObjectAnimator objectAnimatorAnimationAlpha2 = animationAlpha(true, leftSeek2);
        int progress2 = getBinding().rightSeek.getProgress();
        EQSeekBar rightSeek = getBinding().rightSeek;
        Intrinsics.checkNotNullExpressionValue(rightSeek, "rightSeek");
        ValueAnimator valueAnimatorDismissSeekbarToZero2 = dismissSeekbarToZero(progress2, rightSeek, true);
        EQSeekBar rightSeek2 = getBinding().rightSeek;
        Intrinsics.checkNotNullExpressionValue(rightSeek2, "rightSeek");
        ObjectAnimator objectAnimatorAnimationAlpha3 = animationAlpha(true, rightSeek2);
        EQSeekBar topSeek = getBinding().topSeek;
        Intrinsics.checkNotNullExpressionValue(topSeek, "topSeek");
        ObjectAnimator objectAnimatorAnimationAlpha4 = animationAlpha(true, topSeek);
        int progress3 = getBinding().topSeek.getProgress();
        EQSeekBar topSeek2 = getBinding().topSeek;
        Intrinsics.checkNotNullExpressionValue(topSeek2, "topSeek");
        ValueAnimator valueAnimatorDismissSeekbarToZero3 = dismissSeekbarToZero(progress3, topSeek2, true);
        arrayList.add(objectAnimatorAnimationAlpha);
        arrayList.add(objectAnimatorComponent1);
        arrayList.add(objectAnimatorComponent2);
        arrayList.add(objectAnimatorComponent2);
        arrayList.add(valueAnimatorDismissSeekbarToZero);
        arrayList.add(objectAnimatorAnimationAlpha2);
        arrayList.add(valueAnimatorDismissSeekbarToZero2);
        arrayList.add(objectAnimatorAnimationAlpha3);
        arrayList.add(objectAnimatorAnimationAlpha4);
        arrayList.add(valueAnimatorDismissSeekbarToZero3);
        return arrayList;
    }

    private final List<Animator> showCustomAnimations() {
        ArrayList arrayList = new ArrayList();
        EQInnerCircle circle = getBinding().circle;
        Intrinsics.checkNotNullExpressionValue(circle, "circle");
        ObjectAnimator objectAnimatorAnimationAlpha = animationAlpha(false, circle);
        EQInnerCircle circle2 = getBinding().circle;
        Intrinsics.checkNotNullExpressionValue(circle2, "circle");
        Pair<ObjectAnimator, ObjectAnimator> pairAnimationScale = animationScale(false, circle2);
        ObjectAnimator objectAnimatorComponent1 = pairAnimationScale.component1();
        ObjectAnimator objectAnimatorComponent2 = pairAnimationScale.component2();
        int progress = getBinding().leftSeek.getProgress();
        EQSeekBar leftSeek = getBinding().leftSeek;
        Intrinsics.checkNotNullExpressionValue(leftSeek, "leftSeek");
        ValueAnimator valueAnimatorDismissSeekbarToZero = dismissSeekbarToZero(progress, leftSeek, false);
        EQSeekBar leftSeek2 = getBinding().leftSeek;
        Intrinsics.checkNotNullExpressionValue(leftSeek2, "leftSeek");
        ObjectAnimator objectAnimatorAnimationAlpha2 = animationAlpha(false, leftSeek2);
        int progress2 = getBinding().rightSeek.getProgress();
        EQSeekBar rightSeek = getBinding().rightSeek;
        Intrinsics.checkNotNullExpressionValue(rightSeek, "rightSeek");
        ValueAnimator valueAnimatorDismissSeekbarToZero2 = dismissSeekbarToZero(progress2, rightSeek, false);
        EQSeekBar rightSeek2 = getBinding().rightSeek;
        Intrinsics.checkNotNullExpressionValue(rightSeek2, "rightSeek");
        ObjectAnimator objectAnimatorAnimationAlpha3 = animationAlpha(false, rightSeek2);
        EQSeekBar topSeek = getBinding().topSeek;
        Intrinsics.checkNotNullExpressionValue(topSeek, "topSeek");
        ObjectAnimator objectAnimatorAnimationAlpha4 = animationAlpha(false, topSeek);
        int progress3 = getBinding().topSeek.getProgress();
        EQSeekBar topSeek2 = getBinding().topSeek;
        Intrinsics.checkNotNullExpressionValue(topSeek2, "topSeek");
        ValueAnimator valueAnimatorDismissSeekbarToZero3 = dismissSeekbarToZero(progress3, topSeek2, false);
        arrayList.add(objectAnimatorAnimationAlpha);
        arrayList.add(objectAnimatorComponent1);
        arrayList.add(objectAnimatorComponent2);
        arrayList.add(valueAnimatorDismissSeekbarToZero);
        arrayList.add(objectAnimatorAnimationAlpha2);
        arrayList.add(valueAnimatorDismissSeekbarToZero2);
        arrayList.add(objectAnimatorAnimationAlpha3);
        arrayList.add(objectAnimatorAnimationAlpha4);
        arrayList.add(valueAnimatorDismissSeekbarToZero3);
        return arrayList;
    }

    private final void customToPresetAnimation(ObservableField<Integer> res) {
        List<ObjectAnimator> listAnimationCover;
        AnimatorSet animatorSet = this.animateSet;
        if (animatorSet != null) {
            List<Animator> listDismissCustomAnimations = dismissCustomAnimations();
            if (isDiracEQ(res)) {
                listAnimationCover = animationDiracEQ(res);
            } else {
                listAnimationCover = animationCover(false, res);
            }
            playAfter(listDismissCustomAnimations, playTogetherReturnBuilder(animatorSet, listAnimationCover));
            animatorSet.start();
        }
    }

    private final void presetToCustomAnimation() {
        AnimatorSet animatorSet = this.animateSet;
        if (animatorSet != null) {
            playAfter(animationCover(true, null), playTogetherReturnBuilder(animatorSet, showCustomAnimations()));
            animatorSet.start();
        }
    }

    private final ObjectAnimator animationAlpha(boolean isDismiss, View view) {
        float f = 0.0f;
        float f2 = 1.0f;
        if (isDismiss) {
            f2 = 0.0f;
            f = 1.0f;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", f, f2);
        if (isDismiss) {
            objectAnimatorOfFloat.setDuration(100L);
        } else {
            objectAnimatorOfFloat.setDuration(200L);
        }
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        return objectAnimatorOfFloat;
    }

    private final Pair<ObjectAnimator, ObjectAnimator> animationScale(boolean isDismiss, View view) {
        float f = 0.5f;
        float f2 = 1.0f;
        if (isDismiss) {
            f2 = 0.5f;
            f = 1.0f;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", f, f2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", f, f2);
        if (isDismiss) {
            objectAnimatorOfFloat.setDuration(100L);
            objectAnimatorOfFloat2.setDuration(100L);
        } else {
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat2.setDuration(200L);
        }
        return TuplesKt.to(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private final ValueAnimator dismissSeekbarToZero(int progress, final EQSeekBar seekBar, boolean isDismiss) {
        ValueAnimator valueAnimatorOfInt;
        if (isDismiss) {
            valueAnimatorOfInt = ValueAnimator.ofInt(progress * 10, 0);
        } else {
            valueAnimatorOfInt = ValueAnimator.ofInt(0, progress * 10);
        }
        if (isDismiss) {
            valueAnimatorOfInt.setDuration(100L);
        } else {
            valueAnimatorOfInt.setDuration(200L);
        }
        seekBar.setTag(R.id.eq_drag_view_tag, Integer.valueOf(seekBar.getProgress()));
        seekBar.setMax(120);
        seekBar.setProgress(seekBar.getProgress() * 10);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.nothing.base.wiget.radar.EQDragView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EQDragView.dismissSeekbarToZero$lambda$32(seekBar, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(valueAnimatorOfInt);
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.nothing.base.wiget.radar.EQDragView$dismissSeekbarToZero$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                seekBar.setMax(12);
                Object tag = seekBar.getTag(R.id.eq_drag_view_tag);
                if (tag != null && (tag instanceof Integer)) {
                    seekBar.setProgress(((Number) tag).intValue());
                    seekBar.setTag(R.id.eq_drag_view_tag, null);
                }
                this.updateCircle(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                seekBar.setMax(12);
                Object tag = seekBar.getTag(R.id.eq_drag_view_tag);
                if (tag == null || !(tag instanceof Integer)) {
                    return;
                }
                seekBar.setProgress(((Number) tag).intValue());
                seekBar.setTag(R.id.eq_drag_view_tag, null);
            }
        });
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissSeekbarToZero$lambda$32(EQSeekBar eQSeekBar, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        eQSeekBar.setProgress(((Integer) animatedValue).intValue());
    }

    public final boolean isDragging() {
        return Intrinsics.areEqual((Object) getViewModel().getShowValueVisible().get(), (Object) true);
    }

    /* JADX INFO: compiled from: EQDragView.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J7\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010\u00052\u0006\u0010=\u001a\u00020\u0010H\u0007\u00a2\u0006\u0002\u0010>R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lcom/nothing/base/wiget/radar/EQDragView$Companion;", "", "<init>", "()V", "MAX_PROGRESS", "", "RADAR_INT", "RADAR_SIZE", "RADAR_ZERO", "RADAR_TWO", "RADAR_ONE", "RADAR_MAX", "RADAR_TEN", "DELAY", "", "RADAR_PARENT_WIDTH", "", "RADAR_WIDTH", "RADAR_PADDING", "THUMB_WIDTH", "SCALE_MAX", "ONE_HALF", "ONE_FOUR", "COS_ANGLE_30", "SIN_ANGLE_30", "SIN_ANGLE_180", "COS_ANGLE_180", "ANIMATION_100", "ANIMATION_200", "ANIMATION_300", "ANIMATION_1300", "ANIMATION_600", "ANIMATION_700", "ANIMATION_ALPHA_0", "ANIMATION_ALPHA_1", "ANIMATION_ALPHA_HALF", "ANIMATION_SCALE_1", "LINE_HEIGHT", "ANIMATION_SCALE_HALF", "SCALE_DEFAULT", "NT_SIZE", "NT_SHOW_SIZE", "NORMAL_SHOW_SIZE", "NORMAL_SIZE", "MARGIN_BOTTOM", "TITLE_SIZE", "SUMMARY_SIZE", "DIRAC_SCALE_1", "DIRAC_SCALE_2", "DIRAC_SCALE_3", "DEFAULT_SCALE", "OS_DEFAULT_SCALE", "HALF", "COVER_WIDTH", "setRadaStyle", "", "view", "Lcom/nothing/base/wiget/radar/EQDragView;", "radarStyle", "Landroidx/databinding/ObservableField;", "diracOpteoRes", "coverSize", "(Lcom/nothing/base/wiget/radar/EQDragView;Landroidx/databinding/ObservableField;Ljava/lang/Integer;F)V", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @BindingAdapter(requireAll = false, value = {"radarStyle", "diracOpteoRes", "coverSize"})
        @JvmStatic
        public final void setRadaStyle(EQDragView view, ObservableField<Integer> radarStyle, Integer diracOpteoRes, float coverSize) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (diracOpteoRes != null) {
                diracOpteoRes.intValue();
                view.setDiracOpteoStyle(diracOpteoRes.intValue());
            }
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            view.dynamicSetCoverWidth(context, coverSize, coverSize);
            view.setRealRadarStyle(radarStyle);
        }
    }
}
