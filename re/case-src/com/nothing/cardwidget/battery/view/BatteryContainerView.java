package com.nothing.cardwidget.battery.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.nothing.cardtransform.key.BatteryContainerKey;
import com.nothing.cardwidget.R;
import com.nothing.cardwidget.RemoteServiceView;
import com.nothing.cardwidget.battery.AttributeHelper;
import com.nothing.cardwidget.battery.BatteryConfig;
import com.nothing.cardwidget.battery.BatteryStateManager;
import com.nothing.cardwidget.battery.timer.ITimerListener;
import com.nothing.cardwidget.battery.timer.TimerFactory;
import com.nothing.cardwidget.mediaplayer.utils.DisplayUtil;
import com.nothing.cardwidget.util.UiUtil;
import com.nothing.commBase.battery.CustomBattery;
import com.nothing.xservice.InnerTransferKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: compiled from: BatteryContainerView.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ \u00103\u001a\u0002042\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\"0/j\b\u0012\u0004\u0012\u00020\"`0H\u0002J;\u00106\u001a\b\u0012\u0004\u0012\u0002H807\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90;2\u0006\u0010<\u001a\u0002H9H\u0002\u00a2\u0006\u0002\u0010=J\u0010\u0010>\u001a\u0002042\u0006\u0010?\u001a\u00020+H\u0002J\u0010\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020\"H\u0002J\u0010\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020\fH\u0016J\u0016\u0010G\u001a\u0002042\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\"0IH\u0002J\u001a\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020+2\b\u0010L\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010M\u001a\u0002042\u0006\u0010N\u001a\u00020OJ\u001e\u0010P\u001a\u0002042\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\"0/j\b\u0012\u0004\u0012\u00020\"`0J\u000e\u0010Q\u001a\u0002042\u0006\u00101\u001a\u00020\bJ \u0010R\u001a\u0002042\u0018\u0010S\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\f0*0)J\u0012\u0010T\u001a\u0002042\b\u0010U\u001a\u0004\u0018\u00010-H\u0016J\u000e\u0010V\u001a\u0002042\u0006\u0010W\u001a\u00020XJ\b\u0010Y\u001a\u000204H\u0002J\b\u0010Z\u001a\u000204H\u0002J\b\u0010[\u001a\u000204H\u0002J4\u0010\\\u001a\u000204*\u00020 2\b\u0010]\u001a\u0004\u0018\u00010\u000e2\b\u0010^\u001a\u0004\u0018\u00010\u000e2\b\u0010_\u001a\u0004\u0018\u00010\"2\b\u0010`\u001a\u0004\u0018\u00010\"H\u0002J\u001c\u0010a\u001a\u000204*\u0012\u0012\u0004\u0012\u00020\"0/j\b\u0012\u0004\u0012\u00020\"`0H\u0002J\u001c\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\"0/j\b\u0012\u0004\u0012\u00020\"`0*\u00020\"H\u0002J\f\u0010c\u001a\u00020\f*\u00020\fH\u0002J\f\u0010d\u001a\u00020\f*\u00020\fH\u0002J\f\u0010e\u001a\u00020\f*\u00020\"H\u0002J\f\u0010f\u001a\u00020\f*\u00020\fH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010(\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\f0*\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\"0/j\b\u0012\u0004\u0012\u00020\"`0X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u00102\u00a8\u0006g"}, d2 = {"Lcom/nothing/cardwidget/battery/view/BatteryContainerView;", "Lcom/nothing/cardwidget/RemoteServiceView;", "Lcom/nothing/cardwidget/battery/timer/ITimerListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "animEnterBottomLeft", "Landroid/animation/Animator;", "animEnterBottomRight", "animEnterTopRight", "animExitBottomLeft", "animExitBottomRight", "animExitTopRight", "attributeHelper", "Lcom/nothing/cardwidget/battery/AttributeHelper;", "getAttributeHelper", "()Lcom/nothing/cardwidget/battery/AttributeHelper;", "attributeHelper$delegate", "Lkotlin/Lazy;", "batteryContainer", "Landroid/widget/LinearLayout;", "batteryLevelTv", "Landroid/widget/TextView;", "batteryPermissionTv", "batteryViewBottomLeft", "Lcom/nothing/cardwidget/battery/view/BatteryCellView;", "batteryViewBottomLeftInfo", "Lcom/nothing/commBase/battery/CustomBattery;", "batteryViewBottomRight", "batteryViewBottomRightInfo", "batteryViewTopLeft", "batteryViewTopRight", "batteryViewTopRightInfo", "clickListener", "Ljava/util/function/Consumer;", "Lkotlin/Pair;", "Landroid/view/View;", "permissionClickListener", "Landroid/view/View$OnClickListener;", "tempList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "widgetId", "Ljava/lang/Integer;", "clearOutDatedData", "", "batteryInfoList", "getKeysByValue", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "map", "", "value", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Set;", "initView", "view", "nothingDeviceOnReceived", "_battery", "onDataChanged", "data", "Landroid/os/Bundle;", "onTicker", InnerTransferKey.UNIQUE_ID, "setAllBatteryClickListener", "batteryList", "", "setBatteryClickListener", "batteryView", "address", BatteryContainerKey.BATTERY_SET_BATTERY_DISPLAY_RATIO, "ratio", "", BatteryContainerKey.BATTERY_SET_INFO_LIST, BatteryContainerKey.BATTERY_WIDGET_ID, "setClickEventConsumer", "c", "setOnClickListener", CmcdData.STREAM_TYPE_LIVE, BatteryContainerKey.BATTERY_PERMISSION_GRANTED, "isPermissionGranted", "", "showBatteryUI", "showPermissionUI", "updateUI", "crossFadeAnimation", "enterAnimator", "exitAnimator", "old", "new", "deviceOnReceived", "deviceStateOnHandle", "getAddressFromUniqueId", "getBaseId", "getUniqueId", "getWidgetIdFromUniqueId", "CardWidgetLib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BatteryContainerView extends RemoteServiceView implements ITimerListener {
    private final String TAG;
    private Animator animEnterBottomLeft;
    private Animator animEnterBottomRight;
    private Animator animEnterTopRight;
    private Animator animExitBottomLeft;
    private Animator animExitBottomRight;
    private Animator animExitTopRight;

    /* JADX INFO: renamed from: attributeHelper$delegate, reason: from kotlin metadata */
    private final Lazy attributeHelper;
    private LinearLayout batteryContainer;
    private TextView batteryLevelTv;
    private TextView batteryPermissionTv;
    private BatteryCellView batteryViewBottomLeft;
    private CustomBattery batteryViewBottomLeftInfo;
    private BatteryCellView batteryViewBottomRight;
    private CustomBattery batteryViewBottomRightInfo;
    private BatteryCellView batteryViewTopLeft;
    private BatteryCellView batteryViewTopRight;
    private CustomBattery batteryViewTopRightInfo;
    private Consumer<Pair<View, String>> clickListener;
    private View.OnClickListener permissionClickListener;
    private ArrayList<CustomBattery> tempList;
    private Integer widgetId;

    /* JADX INFO: compiled from: BatteryContainerView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BatteryConfig.BatteryState.values().length];
            try {
                iArr[BatteryConfig.BatteryState.INIT_IN_CASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BatteryConfig.BatteryState.OUT_OF_CASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BatteryConfig.BatteryState.OUT_OF_CASE_COUNTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BatteryContainerView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BatteryContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BatteryContainerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.nothing.cardwidget.RemoteServiceView
    public void onDataChanged(Bundle data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public /* synthetic */ BatteryContainerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatteryContainerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "BatteryContainerView";
        this.tempList = new ArrayList<>();
        this.attributeHelper = LazyKt.lazy(new Function0<AttributeHelper>() { // from class: com.nothing.cardwidget.battery.view.BatteryContainerView$attributeHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AttributeHelper invoke() {
                return new AttributeHelper();
            }
        });
        getAttributeHelper().getRemoteResource(attributeSet, context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.battery_container, (ViewGroup) this, false);
        addView(viewInflate);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "this");
        initView(viewInflate);
    }

    private final AttributeHelper getAttributeHelper() {
        return (AttributeHelper) this.attributeHelper.getValue();
    }

    private final void initView(View view) {
        Animator animatorClone;
        Animator animatorClone2;
        Animator animatorClone3;
        Animator animatorClone4;
        Animator animatorClone5;
        Animator animatorClone6;
        this.batteryContainer = (LinearLayout) view.findViewById(R.id.battery_container);
        BatteryCellView batteryCellView = (BatteryCellView) view.findViewById(R.id.battery_view_top_left);
        Animator animator = null;
        if (batteryCellView != null) {
            batteryCellView.setAttributeHelper(getAttributeHelper());
        } else {
            batteryCellView = null;
        }
        this.batteryViewTopLeft = batteryCellView;
        BatteryCellView batteryCellView2 = (BatteryCellView) view.findViewById(R.id.battery_view_top_right);
        if (batteryCellView2 != null) {
            batteryCellView2.setAttributeHelper(getAttributeHelper());
        } else {
            batteryCellView2 = null;
        }
        this.batteryViewTopRight = batteryCellView2;
        BatteryCellView batteryCellView3 = (BatteryCellView) view.findViewById(R.id.battery_view_bottom_left);
        if (batteryCellView3 != null) {
            batteryCellView3.setAttributeHelper(getAttributeHelper());
        } else {
            batteryCellView3 = null;
        }
        this.batteryViewBottomLeft = batteryCellView3;
        BatteryCellView batteryCellView4 = (BatteryCellView) view.findViewById(R.id.battery_view_bottom_right);
        if (batteryCellView4 != null) {
            batteryCellView4.setAttributeHelper(getAttributeHelper());
        } else {
            batteryCellView4 = null;
        }
        this.batteryViewBottomRight = batteryCellView4;
        TextView textView = (TextView) view.findViewById(R.id.tv_battery_level);
        Integer batteryLevelTvColor = getAttributeHelper().getBatteryLevelTvColor();
        if (batteryLevelTvColor != null) {
            textView.setTextColor(batteryLevelTvColor.intValue());
        }
        this.batteryLevelTv = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_battery_permission);
        String permissionStr = getAttributeHelper().getPermissionStr();
        if (permissionStr != null) {
            textView2.setText(permissionStr);
        }
        Integer permissionTvColor = getAttributeHelper().getPermissionTvColor();
        if (permissionTvColor != null) {
            textView2.setTextColor(permissionTvColor.intValue());
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.cardwidget.battery.view.BatteryContainerView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BatteryContainerView.initView$lambda$10$lambda$9(this.f$0, view2);
            }
        });
        this.batteryPermissionTv = textView2;
        Animator animBatteryEnter = getAttributeHelper().getAnimBatteryEnter();
        if (animBatteryEnter == null || (animatorClone = animBatteryEnter.clone()) == null) {
            animatorClone = null;
        } else {
            animatorClone.setTarget(this.batteryViewTopRight);
        }
        this.animEnterTopRight = animatorClone;
        Animator animBatteryExit = getAttributeHelper().getAnimBatteryExit();
        if (animBatteryExit == null || (animatorClone2 = animBatteryExit.clone()) == null) {
            animatorClone2 = null;
        } else {
            animatorClone2.setTarget(this.batteryViewTopRight);
        }
        this.animExitTopRight = animatorClone2;
        Animator animBatteryEnter2 = getAttributeHelper().getAnimBatteryEnter();
        if (animBatteryEnter2 == null || (animatorClone3 = animBatteryEnter2.clone()) == null) {
            animatorClone3 = null;
        } else {
            animatorClone3.setTarget(this.batteryViewBottomLeft);
        }
        this.animEnterBottomLeft = animatorClone3;
        Animator animBatteryExit2 = getAttributeHelper().getAnimBatteryExit();
        if (animBatteryExit2 == null || (animatorClone4 = animBatteryExit2.clone()) == null) {
            animatorClone4 = null;
        } else {
            animatorClone4.setTarget(this.batteryViewBottomLeft);
        }
        this.animExitBottomLeft = animatorClone4;
        Animator animBatteryEnter3 = getAttributeHelper().getAnimBatteryEnter();
        if (animBatteryEnter3 == null || (animatorClone5 = animBatteryEnter3.clone()) == null) {
            animatorClone5 = null;
        } else {
            animatorClone5.setTarget(this.batteryViewBottomRight);
        }
        this.animEnterBottomRight = animatorClone5;
        Animator animBatteryExit3 = getAttributeHelper().getAnimBatteryExit();
        if (animBatteryExit3 != null && (animatorClone6 = animBatteryExit3.clone()) != null) {
            animatorClone6.setTarget(this.batteryViewBottomRight);
            animator = animatorClone6;
        }
        this.animExitBottomRight = animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10$lambda$9(BatteryContainerView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.permissionClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private final void showBatteryUI() {
        TextView textView = this.batteryPermissionTv;
        if (textView != null) {
            textView.setVisibility(8);
        }
        LinearLayout linearLayout = this.batteryContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView2 = this.batteryLevelTv;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(0);
    }

    private final void showPermissionUI() {
        TextView textView = this.batteryPermissionTv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        LinearLayout linearLayout = this.batteryContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView2 = this.batteryLevelTv;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(8);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.permissionClickListener = l;
    }

    public final void setBatteryDisplayRatio(float ratio) {
        UiUtil uiUtil = UiUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        int iRoundToInt = MathKt.roundToInt(uiUtil.dp2px(context, 70) * ratio);
        UiUtil uiUtil2 = UiUtil.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "this.context");
        int iRoundToInt2 = MathKt.roundToInt(uiUtil2.dp2px(context2, 6) * ratio);
        UiUtil uiUtil3 = UiUtil.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "this.context");
        int iRoundToInt3 = MathKt.roundToInt(uiUtil3.dp2px(context3, 10) * ratio);
        UiUtil uiUtil4 = UiUtil.INSTANCE;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "this.context");
        int iRoundToInt4 = MathKt.roundToInt(uiUtil4.dp2px(context4, 3) * ratio);
        UiUtil uiUtil5 = UiUtil.INSTANCE;
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "this.context");
        int iRoundToInt5 = MathKt.roundToInt(uiUtil5.dp2px(context5, 16) * ratio);
        BatteryCellView batteryCellView = this.batteryViewTopLeft;
        if (batteryCellView != null) {
            BatteryCellView batteryCellView2 = batteryCellView;
            DisplayUtil.INSTANCE.setViewSize(batteryCellView2, Integer.valueOf(iRoundToInt), Integer.valueOf(iRoundToInt));
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView2, "layout_marginTop", iRoundToInt2);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView2, "layout_marginStart", iRoundToInt2);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView2, "layout_marginEnd", iRoundToInt4);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView2, "layout_marginBottom", iRoundToInt4);
            batteryCellView.updateRatio(ratio);
        }
        BatteryCellView batteryCellView3 = this.batteryViewTopRight;
        if (batteryCellView3 != null) {
            BatteryCellView batteryCellView4 = batteryCellView3;
            DisplayUtil.INSTANCE.setViewSize(batteryCellView4, Integer.valueOf(iRoundToInt), Integer.valueOf(iRoundToInt));
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView4, "layout_marginTop", iRoundToInt2);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView4, "layout_marginStart", iRoundToInt4);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView4, "layout_marginEnd", iRoundToInt2);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView4, "layout_marginBottom", iRoundToInt4);
            batteryCellView3.updateRatio(ratio);
        }
        BatteryCellView batteryCellView5 = this.batteryViewBottomLeft;
        if (batteryCellView5 != null) {
            BatteryCellView batteryCellView6 = batteryCellView5;
            DisplayUtil.INSTANCE.setViewSize(batteryCellView6, Integer.valueOf(iRoundToInt), Integer.valueOf(iRoundToInt));
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView6, "layout_marginTop", iRoundToInt4);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView6, "layout_marginStart", iRoundToInt2);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView6, "layout_marginEnd", iRoundToInt4);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView6, "layout_marginBottom", iRoundToInt2);
            batteryCellView5.updateRatio(ratio);
        }
        BatteryCellView batteryCellView7 = this.batteryViewBottomRight;
        if (batteryCellView7 != null) {
            BatteryCellView batteryCellView8 = batteryCellView7;
            DisplayUtil.INSTANCE.setViewSize(batteryCellView8, Integer.valueOf(iRoundToInt), Integer.valueOf(iRoundToInt));
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView8, "layout_marginTop", iRoundToInt4);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView8, "layout_marginStart", iRoundToInt4);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView8, "layout_marginEnd", iRoundToInt2);
            DisplayUtil.INSTANCE.setViewMargin(batteryCellView8, "layout_marginBottom", iRoundToInt2);
            batteryCellView7.updateRatio(ratio);
        }
        TextView textView = this.batteryLevelTv;
        if (textView != null) {
            TextView textView2 = textView;
            DisplayUtil.INSTANCE.setViewMargin(textView2, "layout_marginEnd", iRoundToInt5);
            DisplayUtil.INSTANCE.setViewMargin(textView2, "layout_marginBottom", iRoundToInt3);
            textView.setTextSize(0, 76.0f * ratio);
        }
        TextView textView3 = this.batteryPermissionTv;
        if (textView3 != null) {
            textView3.setTextSize(0, ratio * 51.0f);
        }
    }

    public final void setPermission(boolean isPermissionGranted) {
        Log.d(this.TAG, "updateBatteryViewState state: " + isPermissionGranted);
        if (isPermissionGranted) {
            showBatteryUI();
        } else {
            showPermissionUI();
        }
    }

    public final void setBatteryInfo(ArrayList<CustomBattery> batteryInfoList) {
        Intrinsics.checkNotNullParameter(batteryInfoList, "batteryInfoList");
        clearOutDatedData(batteryInfoList);
        this.tempList.clear();
        Iterator<T> it = batteryInfoList.iterator();
        while (it.hasNext()) {
            this.tempList.add((CustomBattery) it.next());
        }
        deviceOnReceived(batteryInfoList);
    }

    private final void clearOutDatedData(ArrayList<CustomBattery> batteryInfoList) {
        ArrayList<CustomBattery> arrayList = batteryInfoList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getBaseId(getUniqueId((CustomBattery) it.next())));
        }
        Set set = CollectionsKt.toSet(arrayList2);
        Set<String> setKeySet = BatteryStateManager.INSTANCE.getBatteryStateInfo().keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "BatteryStateManager.batteryStateInfo.keys");
        ArrayList<String> arrayList3 = new ArrayList();
        for (Object obj : setKeySet) {
            String key = (String) obj;
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (!set.contains(getBaseId(key)) && Intrinsics.areEqual(getWidgetIdFromUniqueId(key), String.valueOf(this.widgetId))) {
                arrayList3.add(obj);
            }
        }
        for (String key2 : arrayList3) {
            BatteryStateManager batteryStateManager = BatteryStateManager.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(key2, "key");
            batteryStateManager.clearBatteryState(key2);
            TimerFactory.INSTANCE.stopTimer(key2);
        }
        BatteryStateManager batteryStateManager2 = BatteryStateManager.INSTANCE;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((CustomBattery) it2.next()).getAddress());
        }
        batteryStateManager2.clearOldCachedBatteryInfo(CollectionsKt.toSet(arrayList4));
    }

    public final void setClickEventConsumer(Consumer<Pair<View, String>> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        this.clickListener = c;
    }

    public final void setBatteryWidgetId(int widgetId) {
        this.widgetId = Integer.valueOf(widgetId);
    }

    private final void updateUI() {
        Log.d(this.TAG, "updateUI tempList: " + this.tempList);
        ArrayList<CustomBattery> arrayList = this.tempList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((CustomBattery) obj).getMainBattery() != -1) {
                arrayList2.add(obj);
            }
        }
        final Comparator comparator = new Comparator() { // from class: com.nothing.cardwidget.battery.view.BatteryContainerView$updateUI$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(Intrinsics.areEqual(((CustomBattery) t2).getDeviceType(), "PHONE")), Boolean.valueOf(Intrinsics.areEqual(((CustomBattery) t).getDeviceType(), "PHONE")));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: com.nothing.cardwidget.battery.view.BatteryContainerView$updateUI$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Boolean.valueOf(((CustomBattery) t2).isActive()), Boolean.valueOf(((CustomBattery) t).isActive()));
            }
        };
        ArrayList<CustomBattery> arrayList3 = new ArrayList<>(CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.nothing.cardwidget.battery.view.BatteryContainerView$updateUI$$inlined$thenByDescending$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator2.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Long.valueOf(((CustomBattery) t2).getConnectedTime()), Long.valueOf(((CustomBattery) t).getConnectedTime()));
            }
        }));
        this.tempList = arrayList3;
        int size = arrayList3.size();
        if (size == 1) {
            BatteryCellView batteryCellView = this.batteryViewTopLeft;
            if (batteryCellView != null) {
                batteryCellView.setBatteryInfo(this.tempList.get(0));
            }
            BatteryCellView batteryCellView2 = this.batteryViewTopRight;
            if (batteryCellView2 != null) {
                crossFadeAnimation(batteryCellView2, this.animEnterTopRight, this.animExitTopRight, this.batteryViewTopRightInfo, null);
            }
            BatteryCellView batteryCellView3 = this.batteryViewBottomLeft;
            if (batteryCellView3 != null) {
                crossFadeAnimation(batteryCellView3, this.animEnterBottomLeft, this.animExitBottomLeft, this.batteryViewBottomLeftInfo, null);
            }
            BatteryCellView batteryCellView4 = this.batteryViewBottomRight;
            if (batteryCellView4 != null) {
                crossFadeAnimation(batteryCellView4, this.animEnterBottomRight, this.animExitBottomRight, this.batteryViewBottomRightInfo, null);
            }
            TextView textView = this.batteryLevelTv;
            if (textView != null) {
                textView.setText(this.tempList.get(0).getMainBattery() + "%");
            }
            this.batteryViewTopRightInfo = null;
            this.batteryViewBottomLeftInfo = null;
            this.batteryViewBottomRightInfo = null;
        } else if (size == 2) {
            BatteryCellView batteryCellView5 = this.batteryViewTopLeft;
            if (batteryCellView5 != null) {
                batteryCellView5.setBatteryInfo(this.tempList.get(0));
            }
            BatteryCellView batteryCellView6 = this.batteryViewTopRight;
            if (batteryCellView6 != null) {
                crossFadeAnimation(batteryCellView6, this.animEnterTopRight, this.animExitTopRight, this.batteryViewTopRightInfo, null);
            }
            BatteryCellView batteryCellView7 = this.batteryViewBottomLeft;
            if (batteryCellView7 != null) {
                crossFadeAnimation(batteryCellView7, this.animEnterBottomLeft, this.animExitBottomLeft, this.batteryViewBottomLeftInfo, null);
            }
            BatteryCellView batteryCellView8 = this.batteryViewBottomRight;
            if (batteryCellView8 != null) {
                crossFadeAnimation(batteryCellView8, this.animEnterBottomRight, this.animExitBottomRight, this.batteryViewBottomRightInfo, this.tempList.get(1));
            }
            TextView textView2 = this.batteryLevelTv;
            if (textView2 != null) {
                textView2.setText("");
            }
            this.batteryViewTopRightInfo = null;
            this.batteryViewBottomLeftInfo = null;
            this.batteryViewBottomRightInfo = this.tempList.get(1);
        } else if (size != 3) {
            BatteryCellView batteryCellView9 = this.batteryViewTopLeft;
            if (batteryCellView9 != null) {
                batteryCellView9.setBatteryInfo(this.tempList.get(0));
            }
            BatteryCellView batteryCellView10 = this.batteryViewTopRight;
            if (batteryCellView10 != null) {
                crossFadeAnimation(batteryCellView10, this.animEnterTopRight, this.animExitTopRight, this.batteryViewTopRightInfo, this.tempList.get(1));
            }
            BatteryCellView batteryCellView11 = this.batteryViewBottomLeft;
            if (batteryCellView11 != null) {
                crossFadeAnimation(batteryCellView11, this.animEnterBottomLeft, this.animExitBottomLeft, this.batteryViewBottomLeftInfo, this.tempList.get(2));
            }
            BatteryCellView batteryCellView12 = this.batteryViewBottomRight;
            if (batteryCellView12 != null) {
                crossFadeAnimation(batteryCellView12, this.animEnterBottomRight, this.animExitBottomRight, this.batteryViewBottomRightInfo, this.tempList.get(3));
            }
            TextView textView3 = this.batteryLevelTv;
            if (textView3 != null) {
                textView3.setText("");
            }
            this.batteryViewTopRightInfo = this.tempList.get(1);
            this.batteryViewBottomLeftInfo = this.tempList.get(2);
            this.batteryViewBottomRightInfo = this.tempList.get(3);
        } else {
            BatteryCellView batteryCellView13 = this.batteryViewTopLeft;
            if (batteryCellView13 != null) {
                batteryCellView13.setBatteryInfo(this.tempList.get(0));
            }
            BatteryCellView batteryCellView14 = this.batteryViewTopRight;
            if (batteryCellView14 != null) {
                crossFadeAnimation(batteryCellView14, this.animEnterTopRight, this.animExitTopRight, this.batteryViewTopRightInfo, this.tempList.get(1));
            }
            BatteryCellView batteryCellView15 = this.batteryViewBottomLeft;
            if (batteryCellView15 != null) {
                crossFadeAnimation(batteryCellView15, this.animEnterBottomLeft, this.animExitBottomLeft, this.batteryViewBottomLeftInfo, this.tempList.get(2));
            }
            BatteryCellView batteryCellView16 = this.batteryViewBottomRight;
            if (batteryCellView16 != null) {
                crossFadeAnimation(batteryCellView16, this.animEnterBottomRight, this.animExitBottomRight, this.batteryViewBottomRightInfo, null);
            }
            TextView textView4 = this.batteryLevelTv;
            if (textView4 != null) {
                textView4.setText("");
            }
            this.batteryViewTopRightInfo = this.tempList.get(1);
            this.batteryViewBottomLeftInfo = this.tempList.get(2);
            this.batteryViewBottomRightInfo = null;
        }
        setAllBatteryClickListener(this.tempList);
    }

    private final void setAllBatteryClickListener(List<CustomBattery> batteryList) {
        CustomBattery customBattery = (CustomBattery) CollectionsKt.getOrNull(batteryList, 0);
        String address = customBattery != null ? customBattery.getAddress() : null;
        CustomBattery customBattery2 = (CustomBattery) CollectionsKt.getOrNull(batteryList, 1);
        String address2 = customBattery2 != null ? customBattery2.getAddress() : null;
        CustomBattery customBattery3 = (CustomBattery) CollectionsKt.getOrNull(batteryList, 2);
        String address3 = customBattery3 != null ? customBattery3.getAddress() : null;
        CustomBattery customBattery4 = (CustomBattery) CollectionsKt.getOrNull(batteryList, 3);
        String address4 = customBattery4 != null ? customBattery4.getAddress() : null;
        LinearLayout linearLayout = this.batteryContainer;
        if (linearLayout != null) {
            setBatteryClickListener(linearLayout, null);
        }
        int size = batteryList.size();
        if (size == 1) {
            LinearLayout linearLayout2 = this.batteryContainer;
            if (linearLayout2 != null) {
                setBatteryClickListener(linearLayout2, address);
            }
            BatteryCellView batteryCellView = this.batteryViewTopRight;
            if (batteryCellView != null) {
                setBatteryClickListener(batteryCellView, address);
            }
            BatteryCellView batteryCellView2 = this.batteryViewBottomLeft;
            if (batteryCellView2 != null) {
                setBatteryClickListener(batteryCellView2, address);
            }
            BatteryCellView batteryCellView3 = this.batteryViewBottomRight;
            if (batteryCellView3 != null) {
                setBatteryClickListener(batteryCellView3, address);
                return;
            }
            return;
        }
        if (size == 2) {
            BatteryCellView batteryCellView4 = this.batteryViewTopLeft;
            if (batteryCellView4 != null) {
                setBatteryClickListener(batteryCellView4, address);
            }
            BatteryCellView batteryCellView5 = this.batteryViewTopRight;
            if (batteryCellView5 != null) {
                setBatteryClickListener(batteryCellView5, null);
            }
            BatteryCellView batteryCellView6 = this.batteryViewBottomLeft;
            if (batteryCellView6 != null) {
                setBatteryClickListener(batteryCellView6, null);
            }
            BatteryCellView batteryCellView7 = this.batteryViewBottomRight;
            if (batteryCellView7 != null) {
                setBatteryClickListener(batteryCellView7, address2);
                return;
            }
            return;
        }
        if (size == 3) {
            BatteryCellView batteryCellView8 = this.batteryViewTopLeft;
            if (batteryCellView8 != null) {
                setBatteryClickListener(batteryCellView8, address);
            }
            BatteryCellView batteryCellView9 = this.batteryViewTopRight;
            if (batteryCellView9 != null) {
                setBatteryClickListener(batteryCellView9, address2);
            }
            BatteryCellView batteryCellView10 = this.batteryViewBottomLeft;
            if (batteryCellView10 != null) {
                setBatteryClickListener(batteryCellView10, address3);
            }
            BatteryCellView batteryCellView11 = this.batteryViewBottomRight;
            if (batteryCellView11 != null) {
                setBatteryClickListener(batteryCellView11, null);
                return;
            }
            return;
        }
        BatteryCellView batteryCellView12 = this.batteryViewTopLeft;
        if (batteryCellView12 != null) {
            setBatteryClickListener(batteryCellView12, address);
        }
        BatteryCellView batteryCellView13 = this.batteryViewTopRight;
        if (batteryCellView13 != null) {
            setBatteryClickListener(batteryCellView13, address2);
        }
        BatteryCellView batteryCellView14 = this.batteryViewBottomLeft;
        if (batteryCellView14 != null) {
            setBatteryClickListener(batteryCellView14, address3);
        }
        BatteryCellView batteryCellView15 = this.batteryViewBottomRight;
        if (batteryCellView15 != null) {
            setBatteryClickListener(batteryCellView15, address4);
        }
    }

    private final void setBatteryClickListener(final View batteryView, final String address) {
        Unit unit;
        if (address != null) {
            batteryView.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.cardwidget.battery.view.BatteryContainerView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BatteryContainerView.setBatteryClickListener$lambda$54$lambda$53(batteryView, this, address, view);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            batteryView.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBatteryClickListener$lambda$54$lambda$53(View batteryView, BatteryContainerView this$0, String str, View view) {
        Intrinsics.checkNotNullParameter(batteryView, "$batteryView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        batteryView.setTag(this$0.widgetId);
        Consumer<Pair<View, String>> consumer = this$0.clickListener;
        if (consumer != null) {
            consumer.accept(new Pair<>(batteryView, str));
        }
    }

    private final void crossFadeAnimation(final BatteryCellView batteryCellView, Animator animator, Animator animator2, CustomBattery customBattery, final CustomBattery customBattery2) {
        if (Intrinsics.areEqual((Object) getAttributeHelper().getIsAod(), (Object) true)) {
            batteryCellView.setBatteryInfo(customBattery2);
            return;
        }
        if (animator != null) {
            animator.removeAllListeners();
        }
        if (animator2 != null) {
            animator2.removeAllListeners();
        }
        if (animator2 != null) {
            animator2.addListener(new AnimatorListenerAdapter() { // from class: com.nothing.cardwidget.battery.view.BatteryContainerView.crossFadeAnimation.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    batteryCellView.setBatteryInfo(customBattery2);
                }
            });
        }
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: com.nothing.cardwidget.battery.view.BatteryContainerView.crossFadeAnimation.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    batteryCellView.setBatteryInfo(customBattery2);
                }
            });
        }
        if (customBattery == null && customBattery2 != null) {
            batteryCellView.setBatteryInfo(customBattery2);
            if (animator != null) {
                animator.start();
                return;
            }
            return;
        }
        if (customBattery != null && customBattery2 == null) {
            if (animator2 != null) {
                animator2.start();
            }
        } else if (customBattery == null && customBattery2 == null) {
            batteryCellView.setBatteryInfo(customBattery2);
        } else {
            batteryCellView.setBatteryInfo(customBattery2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x009b  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a0 A[EDGE_INSN: B:40:0x00a0->B:33:0x00a0 BREAK  A[LOOP:0: B:3:0x0006->B:46:0x0006], SYNTHETIC] */
    private final void deviceOnReceived(ArrayList<CustomBattery> arrayList) {
        for (CustomBattery customBattery : arrayList) {
            String deviceType = customBattery.getDeviceType();
            int iHashCode = deviceType.hashCode();
            if (iHashCode == -273684744) {
                if (!deviceType.equals("AIRPODS")) {
                    continue;
                } else {
                    if (!BatteryContainerViewKt.isSingleBattery(customBattery)) {
                        break;
                        break;
                    }
                    nothingDeviceOnReceived(customBattery);
                }
            } else if (iHashCode != -79410817) {
                if (iHashCode == 1386738378 && deviceType.equals("NOTHINGX_DEVICE")) {
                    if (!BatteryContainerViewKt.isSingleBattery(customBattery)) {
                        break;
                    } else {
                        nothingDeviceOnReceived(customBattery);
                    }
                }
            } else if (!deviceType.equals("FASTPAIR_DEVICE")) {
                continue;
            } else {
                if (BatteryContainerViewKt.isSingleBattery(customBattery)) {
                    break;
                }
                ArrayList<CustomBattery> arrayList2 = this.tempList;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (Intrinsics.areEqual(((CustomBattery) obj).getAddress(), customBattery.getAddress())) {
                        arrayList3.add(obj);
                    }
                }
                arrayList2.removeAll(CollectionsKt.toSet(arrayList3));
                this.tempList.add(BatteryStateManager.INSTANCE.earProductsOnCombine(customBattery));
            }
        }
        updateUI();
    }

    private final void nothingDeviceOnReceived(CustomBattery _battery) {
        BatteryStateManager.INSTANCE.getCurrentHandleBatteryInfo().put(_battery.getAddress(), _battery);
        if (_battery.getCaseBattery() != -1) {
            BatteryStateManager.INSTANCE.getCaseBatteryInfo().put(_battery.getAddress(), Integer.valueOf(_battery.getCaseBattery()));
            BatteryStateManager.INSTANCE.setBatteryState(getUniqueId(_battery), BatteryConfig.BatteryState.INIT_IN_CASE);
            TimerFactory.INSTANCE.stopTimer(getUniqueId(_battery));
        } else if (BatteryStateManager.INSTANCE.queryBatteryState(_battery, getUniqueId(_battery)) == BatteryConfig.BatteryState.INIT_IN_CASE) {
            BatteryStateManager.INSTANCE.setBatteryState(getUniqueId(_battery), BatteryConfig.BatteryState.OUT_OF_CASE);
        }
        ArrayList<CustomBattery> arrayList = this.tempList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (Intrinsics.areEqual(((CustomBattery) obj).getAddress(), _battery.getAddress())) {
                arrayList2.add(obj);
            }
        }
        arrayList.removeAll(CollectionsKt.toSet(arrayList2));
        this.tempList.addAll(deviceStateOnHandle(_battery));
    }

    private final ArrayList<CustomBattery> deviceStateOnHandle(CustomBattery customBattery) {
        Integer num;
        Integer num2;
        BatteryStateManager.INSTANCE.getCurrentHandleBatteryInfo().put(customBattery.getAddress(), customBattery);
        int i = WhenMappings.$EnumSwitchMapping$0[BatteryStateManager.INSTANCE.queryBatteryState(customBattery, getUniqueId(customBattery)).ordinal()];
        if (i == 1) {
            return CollectionsKt.arrayListOf(new CustomBattery(customBattery.getAddress(), customBattery.getDeviceType(), customBattery.getDeviceName(), customBattery.getLeftBattery(), customBattery.getBatteryStatus(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBattery(), customBattery.getLeftBattery(), customBattery.getRightBattery(), customBattery.isActive(), customBattery.getConnectedTime(), null, null, null, customBattery.getLeftImage(), 14336, null), new CustomBattery(customBattery.getAddress(), customBattery.getDeviceType(), customBattery.getDeviceName(), customBattery.getRightBattery(), customBattery.getBatteryStatus(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBattery(), customBattery.getLeftBattery(), customBattery.getRightBattery(), customBattery.isActive(), customBattery.getConnectedTime(), null, null, null, customBattery.getRightImage(), 14336, null), new CustomBattery(customBattery.getAddress(), customBattery.getDeviceType(), customBattery.getDeviceName(), customBattery.getCaseBattery(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBattery(), customBattery.getLeftBattery(), customBattery.getRightBattery(), customBattery.isActive(), customBattery.getConnectedTime(), null, null, null, customBattery.getCaseImage(), 14336, null));
        }
        if (i == 2) {
            if (BatteryStateManager.INSTANCE.getCaseBatteryInfo().get(customBattery.getAddress()) == null || ((num = BatteryStateManager.INSTANCE.getCaseBatteryInfo().get(customBattery.getAddress())) != null && num.intValue() == -1)) {
                return CollectionsKt.arrayListOf(BatteryStateManager.INSTANCE.earProductsOnCombine(customBattery));
            }
            BatteryStateManager.INSTANCE.setBatteryState(getUniqueId(customBattery), BatteryConfig.BatteryState.OUT_OF_CASE_COUNTING);
            if (Intrinsics.areEqual((Object) getAttributeHelper().getIsAod(), (Object) true)) {
                TimerFactory timerFactory = TimerFactory.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                timerFactory.startAlarmTimer(context, getUniqueId(customBattery), 30000L, this);
            } else {
                TimerFactory timerFactory2 = TimerFactory.INSTANCE;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                timerFactory2.startHandleTimer(context2, getUniqueId(customBattery), 30000L, this);
            }
            CustomBattery[] customBatteryArr = new CustomBattery[2];
            customBatteryArr[0] = BatteryStateManager.INSTANCE.earProductsOnCombine(customBattery);
            String address = customBattery.getAddress();
            String deviceType = customBattery.getDeviceType();
            String deviceName = customBattery.getDeviceName();
            Integer num3 = BatteryStateManager.INSTANCE.getCaseBatteryInfo().get(customBattery.getAddress());
            if (num3 == null) {
                num3 = -1;
            }
            customBatteryArr[1] = new CustomBattery(address, deviceType, deviceName, num3.intValue(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBattery(), customBattery.getLeftBattery(), customBattery.getRightBattery(), customBattery.isActive(), customBattery.getConnectedTime(), null, null, null, customBattery.getCaseImage(), 14336, null);
            return CollectionsKt.arrayListOf(customBatteryArr);
        }
        if (i != 3) {
            return CollectionsKt.arrayListOf(BatteryStateManager.INSTANCE.earProductsOnCombine(customBattery));
        }
        if (BatteryStateManager.INSTANCE.getCaseBatteryInfo().get(customBattery.getAddress()) == null || ((num2 = BatteryStateManager.INSTANCE.getCaseBatteryInfo().get(customBattery.getAddress())) != null && num2.intValue() == -1)) {
            return CollectionsKt.arrayListOf(BatteryStateManager.INSTANCE.earProductsOnCombine(customBattery));
        }
        if (Intrinsics.areEqual((Object) getAttributeHelper().getIsAod(), (Object) true)) {
            TimerFactory timerFactory3 = TimerFactory.INSTANCE;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            timerFactory3.startAlarmTimer(context3, getUniqueId(customBattery), 30000L, this);
        } else {
            TimerFactory timerFactory4 = TimerFactory.INSTANCE;
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            timerFactory4.startHandleTimer(context4, getUniqueId(customBattery), 30000L, this);
        }
        CustomBattery[] customBatteryArr2 = new CustomBattery[2];
        customBatteryArr2[0] = BatteryStateManager.INSTANCE.earProductsOnCombine(customBattery);
        String address2 = customBattery.getAddress();
        String deviceType2 = customBattery.getDeviceType();
        String deviceName2 = customBattery.getDeviceName();
        Integer num4 = BatteryStateManager.INSTANCE.getCaseBatteryInfo().get(customBattery.getAddress());
        if (num4 == null) {
            num4 = -1;
        }
        customBatteryArr2[1] = new CustomBattery(address2, deviceType2, deviceName2, num4.intValue(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBatteryStatus(), customBattery.getCaseBattery(), customBattery.getLeftBattery(), customBattery.getRightBattery(), customBattery.isActive(), customBattery.getConnectedTime(), null, null, null, customBattery.getCaseImage(), 14336, null);
        return CollectionsKt.arrayListOf(customBatteryArr2);
    }

    @Override // com.nothing.cardwidget.battery.timer.ITimerListener
    public void onTicker(String uniqueId) {
        Object next;
        CustomBattery onTicker$lambda$64$lambda$63;
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Iterator it = getKeysByValue(BatteryStateManager.INSTANCE.getBatteryStateInfo(), BatteryConfig.BatteryState.OUT_OF_CASE_COUNTING).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual((String) next, uniqueId));
        String str = (String) next;
        if (str != null && (onTicker$lambda$64$lambda$63 = BatteryStateManager.INSTANCE.getCurrentHandleBatteryInfo().get(getAddressFromUniqueId(str))) != null) {
            BatteryStateManager.INSTANCE.setBatteryState(uniqueId, BatteryConfig.BatteryState.NORMAL);
            TimerFactory.INSTANCE.stopTimer(uniqueId);
            ArrayList<CustomBattery> arrayList = this.tempList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (Intrinsics.areEqual(((CustomBattery) obj).getAddress(), onTicker$lambda$64$lambda$63.getAddress())) {
                    arrayList2.add(obj);
                }
            }
            arrayList.removeAll(CollectionsKt.toSet(arrayList2));
            Intrinsics.checkNotNullExpressionValue(onTicker$lambda$64$lambda$63, "onTicker$lambda$64$lambda$63");
            this.tempList.addAll(deviceStateOnHandle(onTicker$lambda$64$lambda$63));
        }
        updateUI();
    }

    private final String getUniqueId(CustomBattery customBattery) {
        return customBattery.getAddress() + Marker.ANY_NON_NULL_MARKER + this.widgetId + Marker.ANY_NON_NULL_MARKER + getAttributeHelper().getIsAod();
    }

    private final String getBaseId(String str) {
        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{Marker.ANY_NON_NULL_MARKER}, false, 0, 6, (Object) null);
        if (listSplit$default.size() < 2) {
            return str;
        }
        return listSplit$default.get(0) + Marker.ANY_NON_NULL_MARKER + listSplit$default.get(1);
    }

    private final String getAddressFromUniqueId(String str) {
        return (String) CollectionsKt.first(StringsKt.split$default((CharSequence) str, new String[]{Marker.ANY_NON_NULL_MARKER}, false, 0, 6, (Object) null));
    }

    private final String getWidgetIdFromUniqueId(String str) {
        String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{Marker.ANY_NON_NULL_MARKER}, false, 0, 6, (Object) null), 1);
        return str2 == null ? "" : str2;
    }

    private final <T, E> Set<T> getKeysByValue(Map<T, ? extends E> map, E value) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<T, ? extends E> entry : map.entrySet()) {
            T key = entry.getKey();
            if (Intrinsics.areEqual(value, entry.getValue())) {
                hashSet.add(key);
            }
        }
        return hashSet;
    }
}
