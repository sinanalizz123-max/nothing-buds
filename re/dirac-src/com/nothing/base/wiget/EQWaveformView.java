package com.nothing.base.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EQWaveformView.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\f\b\u0016\u0018\u0000 \u008c\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010;\u001a\u00020\u000bH\u0016J\b\u0010<\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u00020\u000bH\u0016J\b\u0010L\u001a\u00020\u0007H\u0016J\b\u0010M\u001a\u00020\u0007H\u0016J\b\u0010N\u001a\u00020\u0007H\u0016J\b\u0010O\u001a\u00020\u0007H\u0016J\b\u0010P\u001a\u00020\u0007H\u0016J\b\u0010Q\u001a\u00020\u0007H\u0016J\b\u0010R\u001a\u00020\u0007H\u0016J\b\u0010S\u001a\u00020\u0007H\u0016J\u0018\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0014J\b\u0010X\u001a\u00020UH\u0002J\u0010\u0010Y\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u0010\u0010[\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u0010\u0010\\\u001a\u00020U2\u0006\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020UH\u0002J\u0010\u0010`\u001a\u00020U2\u0006\u0010]\u001a\u00020^H\u0002J\u0006\u0010a\u001a\u00020UJ\u0018\u0010b\u001a\u00020'2\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u000bH\u0002JT\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020f0\"2\u0006\u0010]\u001a\u00020^2\u0006\u0010g\u001a\u00020f2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020i0\"2\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\"2\u0006\u0010k\u001a\u00020\u0016H\u0002J<\u0010l\u001a\u00020U2\u0006\u0010]\u001a\u00020^2\u0006\u0010g\u001a\u00020f2\u0006\u0010m\u001a\u00020i2\u0006\u0010k\u001a\u00020\u00162\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\"H\u0002J\u0018\u0010n\u001a\u00020f2\u0006\u0010m\u001a\u00020i2\u0006\u0010o\u001a\u00020\u000bH\u0002J\u0010\u0010p\u001a\u00020U2\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010q\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000bH\u0002J0\u0010r\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"0\u001ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"` H\u0002J \u0010s\u001a\u00020\u00162\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020iH\u0002J\u001c\u0010v\u001a\u00020\u000b2\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"H\u0002J\b\u0010x\u001a\u00020UH\u0002J\u0010\u0010y\u001a\u00020U2\u0006\u0010]\u001a\u00020^H\u0002J\u0010\u0010z\u001a\u00020U2\u0006\u0010]\u001a\u00020^H\u0014J\u000e\u0010{\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000bJ\u000e\u0010|\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000bJ\u0010\u0010}\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000bH\u0002J\u000e\u0010~\u001a\u00020U2\u0006\u0010t\u001a\u00020\u0007JZ\u0010\u007f\u001a\u00020U2\u001a\u0010\u0080\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"0\u0081\u00012\u001a\u0010\u0082\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"0\u0081\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00072\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0003\u0010\u0085\u0001J\"\u0010\u0086\u0001\u001a\u00020U2\u0007\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0089\u0001\u001a\u00020\u0007J\u0007\u0010\u008a\u0001\u001a\u00020UR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010!\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b0\"0\u001ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b0\"` X\u0082\u0004\u00a2\u0006\u0002\n\u0000RB\u0010$\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020#0%0\u001ej\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020#0%` X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u000e\u0010/\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R9\u00101\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"0\u001ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"` \u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R9\u00104\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"0\u001ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"` \u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u000e\u00106\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u00107\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u00108R\u0012\u00109\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u00108R\u0012\u0010:\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u00108R\u001a\u0010>\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0012\u0010G\u001a\u00060HR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010I\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"0\u001ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"` X\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010J\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"0\u001ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\"` X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u008d\u0001"}, d2 = {"Lcom/nothing/base/wiget/EQWaveformView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewWidth", "", "viewHeight", "getViewHeight", "()F", "setViewHeight", "(F)V", "heightScale", "widthScale", "MAX_X", "getTextHeight", "isNeedText", "", "isNeedSystemCoordinate", "textPaint", "Landroid/text/TextPaint;", "paint", "Landroid/graphics/Paint;", "firstInto", "listCoordinateSystemRectF", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "listTextValue", "Lkotlin/Pair;", "", "listTextCoordinateTriple", "Lkotlin/Triple;", "topLinearGradient", "Landroid/graphics/LinearGradient;", "getTopLinearGradient", "()Landroid/graphics/LinearGradient;", "setTopLinearGradient", "(Landroid/graphics/LinearGradient;)V", "bottomLinearGradient", "getBottomLinearGradient", "setBottomLinearGradient", "curePaint", "curePaintBottom", "dataList", "getDataList", "()Ljava/util/ArrayList;", "pointList", "getPointList", "pointPaint", "customGradientStartColor", "Ljava/lang/Integer;", "customGradientEndColor", "customHighlightPointColor", "getInRadius", "getOutRadius", "getRadius", "currentSelectPointIndex", "getCurrentSelectPointIndex", "()I", "setCurrentSelectPointIndex", "(I)V", "isNeedAnimal", "()Z", "setNeedAnimal", "(Z)V", "animation", "Lcom/nothing/base/wiget/EQWaveformView$ViewAnimation;", "lastPointList", "lastDataList", "xRadio", "xyTextColor", "gradientEndColor", "gradientStartColor", "lineColor", "normalPointColor", "highlightPointColor", "roundBackgroundColor", "bordBackgroundColor", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "initCoordinateSystem", "createLineXRectF", "value", "countXAxis", "drawCoordinateSystem", "canvas", "Landroid/graphics/Canvas;", "initTextCoordinate", "drawText", "initCure", "createLinearGradient", "y0", "y1", "toggleAreaDrawPath", "Landroid/graphics/Path;", "path", "point", "Landroid/graphics/PointF;", FirebaseAnalytics.Param.LOCATION, "isTop", "lastPointDrawPath", "currentPoint", "startDrawingPath", "zeroY", "drawCure", "getCureY", "getCureList", "isDiffDiraction", "y", "lastPoint", "getPairValue", "pair", "initPoint", "drawPoint", "onDraw", "countY", "countX", "countXSize", "setMaxY", "addData", "cureDatas", "", "points", "index", "hasAnimation", "(Ljava/util/List;Ljava/util/List;ILjava/lang/Boolean;)V", "setWaveThemeColor", "startColor", "endColor", "pointColor", "resetDefaultWaveTheme", "ViewAnimation", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class EQWaveformView extends View {
    public static final long ANIMAL_TIME = 350;
    public static final float BG_RADIUS = 20.0f;
    public static final float LINE_WIDTH = 1.0f;
    public static final float MAX_Y_POINT = 10.0f;
    public static final int MIN_X = 1;
    public static final float OUT_WHITE_RADIUS = 4.5f;
    public static final int START_INDEX = 8;
    public static final float TEXT_HEIGHT = 15.0f;
    public static final float TEXT_SIZE = 10.0f;
    public static final float WHITE_RADIUS = 2.5f;
    public static final float X_100 = 100.0f;
    public static final float X_1000 = 1000.0f;
    public static final float X_10000 = 10000.0f;
    public static final float X_20 = 20.0f;
    public static final float X_20000 = 20000.0f;
    public static final float X_50 = 50.0f;
    public static final float X_500 = 500.0f;
    public static final float X_5000 = 5000.0f;
    private final float MAX_X;
    private final ViewAnimation animation;
    private LinearGradient bottomLinearGradient;
    private final Paint curePaint;
    private final Paint curePaintBottom;
    private int currentSelectPointIndex;
    private Integer customGradientEndColor;
    private Integer customGradientStartColor;
    private Integer customHighlightPointColor;
    private final ArrayList<Pair<Float, Float>> dataList;
    private boolean firstInto;
    private float heightScale;
    private boolean isNeedAnimal;
    private final ArrayList<Pair<Float, Float>> lastDataList;
    private final ArrayList<Pair<Float, Float>> lastPointList;
    private final ArrayList<RectF> listCoordinateSystemRectF;
    private final ArrayList<Triple<Float, Float, String>> listTextCoordinateTriple;
    private final ArrayList<Pair<String, Float>> listTextValue;
    private Paint paint;
    private final ArrayList<Pair<Float, Float>> pointList;
    private final Paint pointPaint;
    private TextPaint textPaint;
    private LinearGradient topLinearGradient;
    private float viewHeight;
    private float viewWidth;
    private float widthScale;
    private float xRadio;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int MAX_Y = 10;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EQWaveformView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EQWaveformView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean isNeedSystemCoordinate() {
        return true;
    }

    public boolean isNeedText() {
        return true;
    }

    public /* synthetic */ EQWaveformView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EQWaveformView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.heightScale = 1.0f;
        this.widthScale = 1.0f;
        this.MAX_X = ((float) Math.log10(20000.0f)) + (((float) Math.log10(20.0f)) - 1);
        this.textPaint = new TextPaint(1);
        this.paint = new Paint();
        this.firstInto = true;
        this.listCoordinateSystemRectF = new ArrayList<>();
        this.listTextValue = CollectionsKt.arrayListOf(TuplesKt.to("20", Float.valueOf(20.0f)), TuplesKt.to("50", Float.valueOf(50.0f)), TuplesKt.to("100", Float.valueOf(100.0f)), TuplesKt.to("500", Float.valueOf(500.0f)), TuplesKt.to("1K", Float.valueOf(1000.0f)), TuplesKt.to("5K", Float.valueOf(5000.0f)), TuplesKt.to("10K", Float.valueOf(10000.0f)), TuplesKt.to("20K", Float.valueOf(20000.0f)));
        this.listTextCoordinateTriple = new ArrayList<>();
        this.curePaint = new Paint();
        this.curePaintBottom = new Paint();
        this.dataList = new ArrayList<>();
        this.pointList = new ArrayList<>();
        this.pointPaint = new Paint();
        this.currentSelectPointIndex = -1;
        ViewAnimation viewAnimation = new ViewAnimation();
        this.animation = viewAnimation;
        this.lastPointList = new ArrayList<>();
        this.lastDataList = new ArrayList<>();
        this.xRadio = 1.0f;
        viewAnimation.setDuration(350L);
    }

    public final float getViewHeight() {
        return this.viewHeight;
    }

    public final void setViewHeight(float f) {
        this.viewHeight = f;
    }

    public int getTextHeight() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ContextExtKt.dp2px(context, 15.0f);
    }

    public final LinearGradient getTopLinearGradient() {
        return this.topLinearGradient;
    }

    public final void setTopLinearGradient(LinearGradient linearGradient) {
        this.topLinearGradient = linearGradient;
    }

    public final LinearGradient getBottomLinearGradient() {
        return this.bottomLinearGradient;
    }

    public final void setBottomLinearGradient(LinearGradient linearGradient) {
        this.bottomLinearGradient = linearGradient;
    }

    public final ArrayList<Pair<Float, Float>> getDataList() {
        return this.dataList;
    }

    public final ArrayList<Pair<Float, Float>> getPointList() {
        return this.pointList;
    }

    public float getInRadius() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ContextExtKt.dp2px(context, 2.5f);
    }

    public float getOutRadius() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ContextExtKt.dp2px(context, 4.5f);
    }

    public float getRadius() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ContextExtKt.dp2px(context, 20.0f);
    }

    public final int getCurrentSelectPointIndex() {
        return this.currentSelectPointIndex;
    }

    public final void setCurrentSelectPointIndex(int i) {
        this.currentSelectPointIndex = i;
    }

    /* JADX INFO: renamed from: isNeedAnimal, reason: from getter */
    public final boolean getIsNeedAnimal() {
        return this.isNeedAnimal;
    }

    public final void setNeedAnimal(boolean z) {
        this.isNeedAnimal = z;
    }

    public int xyTextColor() {
        return ContextCompat.getColor(getContext(), R.color.nt_99F0F2F2_9906080A);
    }

    public int gradientEndColor() {
        return ContextCompat.getColor(getContext(), R.color.nt_27FFFFFF_27000000);
    }

    public int gradientStartColor() {
        return ContextCompat.getColor(getContext(), R.color.nt_06FFFFFF_06000000);
    }

    public int lineColor() {
        return ContextCompat.getColor(getContext(), R.color.nt_2B2D2F_1A06080A);
    }

    public int normalPointColor() {
        return ContextCompat.getColor(getContext(), R.color.nt_8E8E8E_5E5E62);
    }

    public int highlightPointColor() {
        return ContextCompat.getColor(getContext(), R.color.nt_red_700);
    }

    public int roundBackgroundColor() {
        return ContextCompat.getColor(getContext(), R.color.nt_1B1D1F_E7E9E9);
    }

    public int bordBackgroundColor() {
        return ContextCompat.getColor(getContext(), R.color.nt_1B1D1F_E7E9E9);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension((int) this.viewWidth, (int) this.viewHeight);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension((int) this.viewWidth, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, (int) this.viewHeight);
        } else {
            setMeasuredDimension(size, size2);
        }
        this.viewHeight = getMeasuredHeight();
        this.viewWidth = getMeasuredWidth();
        this.heightScale = ((this.viewHeight - getTextHeight()) * 1.0f) / (MAX_Y * 2);
        this.widthScale = (this.viewWidth * 1.0f) / (this.MAX_X - 1);
        initCoordinateSystem();
        initTextCoordinate();
        initCure();
        initPoint();
    }

    private final void initCoordinateSystem() {
        this.listCoordinateSystemRectF.clear();
        this.paint.setStyle(Paint.Style.FILL);
        this.listCoordinateSystemRectF.add(new RectF(0.0f, 0.0f, this.viewWidth, this.viewHeight - getTextHeight()));
        if (isNeedSystemCoordinate()) {
            this.listCoordinateSystemRectF.add(createLineXRectF(20.0f));
            this.listCoordinateSystemRectF.add(createLineXRectF(50.0f));
            this.listCoordinateSystemRectF.add(createLineXRectF(100.0f));
            this.listCoordinateSystemRectF.add(createLineXRectF(500.0f));
            this.listCoordinateSystemRectF.add(createLineXRectF(1000.0f));
            this.listCoordinateSystemRectF.add(createLineXRectF(5000.0f));
            this.listCoordinateSystemRectF.add(createLineXRectF(10000.0f));
            this.listCoordinateSystemRectF.add(createLineXRectF(20000.0f));
        }
        float textHeight = ((this.viewHeight - getTextHeight()) - 1.0f) / 2.0f;
        this.listCoordinateSystemRectF.add(new RectF(0.0f, textHeight, this.viewWidth, 1 + textHeight));
    }

    private final RectF createLineXRectF(float value) {
        return new RectF(countXAxis(value), 0.0f, countXAxis(value) + 1, this.viewHeight - getTextHeight());
    }

    private final float countXAxis(float value) {
        if (getLayoutDirection() == 1) {
            return this.viewWidth - (((((float) Math.log10(value)) - 1) * this.widthScale) - 0.5f);
        }
        return ((((float) Math.log10(value)) - 1) * this.widthScale) - 0.5f;
    }

    private final void drawCoordinateSystem(Canvas canvas) {
        for (RectF rectF : this.listCoordinateSystemRectF) {
            if (Intrinsics.areEqual(rectF, CollectionsKt.first((List) this.listCoordinateSystemRectF))) {
                this.paint.setColor(roundBackgroundColor());
                canvas.drawRoundRect(rectF, getRadius(), getRadius(), this.paint);
            } else {
                this.paint.setColor(lineColor());
                canvas.drawRect(rectF, this.paint);
            }
        }
    }

    private final void initTextCoordinate() {
        this.textPaint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.lettera_monoll_medium));
        this.textPaint.setColor(xyTextColor());
        TextPaint textPaint = this.textPaint;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textPaint.setTextSize(ContextExtKt.sp2px(context, 10.0f));
        this.listTextCoordinateTriple.clear();
        Iterator<T> it = this.listTextValue.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            float fMeasureText = this.textPaint.measureText((String) pair.getFirst());
            float fAbs = this.viewHeight - ((Math.abs(this.textPaint.getFontMetrics().ascent) - this.textPaint.getFontMetrics().descent) / 2.0f);
            this.listTextCoordinateTriple.add(new Triple<>(Float.valueOf(countXAxis(((Number) pair.getSecond()).floatValue()) - (fMeasureText / 2.0f)), Float.valueOf(fAbs), pair.getFirst()));
        }
    }

    private final void drawText(Canvas canvas) {
        Iterator<T> it = this.listTextCoordinateTriple.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            canvas.drawText((String) triple.getThird(), ((Number) triple.getFirst()).floatValue(), ((Number) triple.getSecond()).floatValue(), this.textPaint);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00de  */
    public final void initCure() {
        float f;
        float f2;
        if (this.topLinearGradient == null) {
            this.topLinearGradient = createLinearGradient(((this.viewHeight - getTextHeight()) - 1.0f) / 2.0f, 0.0f);
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "initCure topLinearGradient y0:" + (((this.viewHeight - getTextHeight()) - 1.0f) / 2.0f) + ",y1:0f";
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    f = 2.0f;
                    f2 = 1.0f;
                } else {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    f = 2.0f;
                    f2 = 1.0f;
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            } else {
                f = 2.0f;
                f2 = 1.0f;
            }
        } else {
            f = 2.0f;
            f2 = 1.0f;
        }
        if (this.bottomLinearGradient == null) {
            this.bottomLinearGradient = createLinearGradient((((this.viewHeight - getTextHeight()) - f2) / f) + f2, this.viewHeight - getTextHeight());
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "initCure bottomLinearGradient y0:" + ((((this.viewHeight - getTextHeight()) - f2) / f) + f2) + ",y1:" + (this.viewHeight - getTextHeight());
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
        }
        this.curePaint.setFlags(1);
        this.curePaint.setStyle(Paint.Style.FILL);
        this.curePaint.setShader(this.topLinearGradient);
        this.curePaintBottom.setFlags(1);
        this.curePaintBottom.setStyle(Paint.Style.FILL);
        this.curePaintBottom.setShader(this.bottomLinearGradient);
    }

    private final LinearGradient createLinearGradient(float y0, float y1) {
        Integer num = this.customGradientStartColor;
        int iIntValue = num != null ? num.intValue() : gradientStartColor();
        Integer num2 = this.customGradientEndColor;
        return new LinearGradient(0.0f, y0, 0.0f, y1, iIntValue, num2 != null ? num2.intValue() : gradientEndColor(), Shader.TileMode.CLAMP);
    }

    private final Pair<Integer, Path> toggleAreaDrawPath(Canvas canvas, Path path, Pair<? extends PointF, ? extends PointF> point, Pair<Float, Integer> location, boolean isTop) {
        PointF first = point.getFirst();
        PointF second = point.getSecond();
        float fFloatValue = location.getFirst().floatValue();
        float f = (first.x + second.x) / 2.0f;
        path.lineTo(f, fFloatValue);
        path.close();
        if (isTop) {
            canvas.drawPath(path, this.curePaint);
        } else {
            canvas.drawPath(path, this.curePaintBottom);
        }
        Path path2 = new Path();
        path2.moveTo(f, fFloatValue);
        path2.lineTo(first.x, first.y);
        return TuplesKt.to(Integer.valueOf(location.getSecond().intValue() + 1), path2);
    }

    private final void lastPointDrawPath(Canvas canvas, Path path, PointF currentPoint, boolean isTop, Pair<Float, Boolean> location) {
        path.lineTo(currentPoint.x, currentPoint.y);
        float fFloatValue = location.getFirst().floatValue();
        if (location.getSecond().booleanValue()) {
            path.lineTo(currentPoint.x, fFloatValue);
            path.close();
            if (isTop) {
                canvas.drawPath(path, this.curePaint);
            } else {
                canvas.drawPath(path, this.curePaintBottom);
            }
        }
    }

    private final Path startDrawingPath(PointF currentPoint, float zeroY) {
        Path path = new Path();
        double d = 20.0f;
        path.moveTo(countXSize((float) Math.log10(d)), zeroY);
        path.lineTo(countXSize((float) Math.log10(d)), currentPoint.y);
        path.lineTo(currentPoint.x, currentPoint.y);
        return path;
    }

    private final void drawCure(Canvas canvas) {
        EQWaveformView eQWaveformView = this;
        ArrayList<Pair<Float, Float>> cureList = eQWaveformView.getCureList();
        if (cureList.isEmpty()) {
            return;
        }
        PointF pointF = new PointF();
        ArrayList arrayList = new ArrayList();
        pointF.x = eQWaveformView.countXSize(cureList.get(0).getFirst().floatValue());
        pointF.y = eQWaveformView.countY(0.0f);
        float fCountY = eQWaveformView.countY(0.0f);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "wave animal drawCure xRadio=" + eQWaveformView.xRadio + StringUtils.SPACE;
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
        int iIntValue = -1;
        int i = 0;
        for (Object obj : cureList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair<Float, Float> pair = (Pair) obj;
            if (i >= 8) {
                float fCountXSize = eQWaveformView.countXSize(pair.getFirst().floatValue());
                float cureY = eQWaveformView.getCureY(eQWaveformView.getPairValue(pair));
                if (pointF.y == fCountY) {
                    if (i == 8) {
                        arrayList.add(eQWaveformView.startDrawingPath(new PointF(fCountXSize, cureY), fCountY));
                        iIntValue = 0;
                    } else {
                        Object obj2 = arrayList.get(iIntValue);
                        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                        Pair<Integer, Path> pair2 = eQWaveformView.toggleAreaDrawPath(canvas, (Path) obj2, TuplesKt.to(new PointF(fCountXSize, cureY), pointF), TuplesKt.to(Float.valueOf(fCountY), Integer.valueOf(iIntValue)), cureY > fCountY);
                        arrayList.add(pair2.getSecond());
                        iIntValue = pair2.getFirst().intValue();
                    }
                } else if (eQWaveformView.isDiffDiraction(cureY, fCountY, pointF)) {
                    Object obj3 = arrayList.get(iIntValue);
                    Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
                    Pair<Integer, Path> pair3 = eQWaveformView.toggleAreaDrawPath(canvas, (Path) obj3, TuplesKt.to(new PointF(fCountXSize, cureY), pointF), TuplesKt.to(Float.valueOf(fCountY), Integer.valueOf(iIntValue)), cureY > fCountY);
                    arrayList.add(pair3.getSecond());
                    iIntValue = pair3.getFirst().intValue();
                } else {
                    Object obj4 = arrayList.get(iIntValue);
                    Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
                    lastPointDrawPath(canvas, (Path) obj4, new PointF(fCountXSize, cureY), cureY <= fCountY, TuplesKt.to(Float.valueOf(fCountY), Boolean.valueOf(i == cureList.size() + (-1))));
                }
                pointF.x = fCountXSize;
                pointF.y = cureY;
            }
            eQWaveformView = this;
            i = i2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Path) it.next()).reset();
        }
        arrayList.clear();
    }

    private final float getCureY(float value) {
        return this.isNeedAnimal ? countY(value * (1 - this.xRadio)) : countY(value);
    }

    private final ArrayList<Pair<Float, Float>> getCureList() {
        if (this.isNeedAnimal) {
            return this.lastDataList;
        }
        return this.dataList;
    }

    private final boolean isDiffDiraction(float y, float zeroY, PointF lastPoint) {
        if (y <= zeroY || lastPoint.y >= zeroY) {
            return y <= zeroY && lastPoint.y > zeroY;
        }
        return true;
    }

    private final float getPairValue(Pair<Float, Float> pair) {
        if (pair.getSecond().floatValue() >= 10.0f) {
            return 10.0f;
        }
        if (pair.getSecond().floatValue() <= -10.0f) {
            return -10.0f;
        }
        return pair.getSecond().floatValue();
    }

    private final void initPoint() {
        this.pointPaint.setFlags(1);
        this.pointPaint.setStyle(Paint.Style.FILL);
    }

    private final void drawPoint(Canvas canvas) {
        float fCountXSize;
        float fCountY;
        int iNormalPointColor;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        boolean z = true;
        if (logger.isCanLogger(true) && "wave data point start drawPoint".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "wave data point start drawPoint " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "wave data point start drawPoint " + strComponent2);
            }
        }
        int i = 0;
        for (Object obj : this.pointList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            if (this.isNeedAnimal) {
                fCountXSize = countXSize(this.lastPointList.get(i).getFirst().floatValue()) - ((countXSize(this.lastPointList.get(i).getFirst().floatValue()) - countXSize(((Number) pair.getFirst()).floatValue())) * this.xRadio);
            } else {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(z) && "wave data point not animal".length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str2 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    FileLog.print$default(fileLog2, 3, str2, tag2, "wave data point not animal " + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, "wave data point not animal " + strComponent4);
                    }
                }
                fCountXSize = countXSize(((Number) pair.getFirst()).floatValue());
            }
            if (this.isNeedAnimal) {
                fCountY = countY(this.lastPointList.get(i).getSecond().floatValue()) - ((countY(this.lastPointList.get(i).getSecond().floatValue()) - countY(((Number) pair.getSecond()).floatValue())) * this.xRadio);
            } else {
                fCountY = countY(((Number) pair.getSecond()).floatValue());
            }
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(z)) {
                String str3 = "wave data point x:" + fCountXSize + ",y:" + fCountY;
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
            this.pointPaint.setColor(bordBackgroundColor());
            canvas.drawCircle(fCountXSize, fCountY, getOutRadius(), this.pointPaint);
            Paint paint = this.pointPaint;
            if (this.currentSelectPointIndex == i) {
                Integer num = this.customHighlightPointColor;
                iNormalPointColor = num != null ? num.intValue() : highlightPointColor();
            } else {
                iNormalPointColor = normalPointColor();
            }
            paint.setColor(iNormalPointColor);
            canvas.drawCircle(fCountXSize, fCountY, getInRadius(), this.pointPaint);
            i = i2;
            z = true;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawCoordinateSystem(canvas);
        if (isNeedText()) {
            drawText(canvas);
        }
        drawCure(canvas);
        drawPoint(canvas);
    }

    public final float countY(float value) {
        return (MAX_Y - value) * this.heightScale;
    }

    public final float countX(float value) {
        return (((float) Math.log10(value)) - 1) * this.widthScale;
    }

    private final float countXSize(float value) {
        if (getLayoutDirection() == 1) {
            return this.viewWidth - ((value - 1) * this.widthScale);
        }
        return (value - 1) * this.widthScale;
    }

    public final void setMaxY(int y) {
        MAX_Y = y;
        this.heightScale = ((this.viewHeight - getTextHeight()) * 1.0f) / (MAX_Y * 2);
    }

    public static /* synthetic */ void addData$default(EQWaveformView eQWaveformView, List list, List list2, int i, Boolean bool, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addData");
        }
        if ((i2 & 8) != 0) {
            bool = false;
        }
        eQWaveformView.addData(list, list2, i, bool);
    }

    public final void addData(List<Pair<Float, Float>> cureDatas, List<Pair<Float, Float>> points, int index, Boolean hasAnimation) {
        Intrinsics.checkNotNullParameter(cureDatas, "cureDatas");
        Intrinsics.checkNotNullParameter(points, "points");
        if (Intrinsics.areEqual((Object) hasAnimation, (Object) true)) {
            this.lastDataList.clear();
            this.lastPointList.clear();
            this.lastPointList.addAll(this.pointList);
            this.lastDataList.addAll(this.dataList);
            this.dataList.clear();
            this.pointList.clear();
            this.dataList.addAll(cureDatas);
            this.pointList.addAll(points);
            this.isNeedAnimal = true;
            this.currentSelectPointIndex = index;
            startAnimation(this.animation);
            return;
        }
        this.isNeedAnimal = false;
        this.dataList.clear();
        this.pointList.clear();
        this.dataList.addAll(cureDatas);
        this.pointList.addAll(points);
        this.currentSelectPointIndex = index;
        invalidate();
    }

    public final void setWaveThemeColor(int startColor, int endColor, int pointColor) {
        this.customGradientStartColor = Integer.valueOf(startColor);
        this.customGradientEndColor = Integer.valueOf(endColor);
        this.customHighlightPointColor = Integer.valueOf(pointColor);
        this.topLinearGradient = null;
        this.bottomLinearGradient = null;
        initCure();
        invalidate();
    }

    public final void resetDefaultWaveTheme() {
        this.customGradientStartColor = null;
        this.customGradientEndColor = null;
        this.customHighlightPointColor = null;
        this.topLinearGradient = null;
        this.bottomLinearGradient = null;
        initCure();
        invalidate();
    }

    /* JADX INFO: compiled from: EQWaveformView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\n"}, d2 = {"Lcom/nothing/base/wiget/EQWaveformView$ViewAnimation;", "Landroid/view/animation/Animation;", "<init>", "(Lcom/nothing/base/wiget/EQWaveformView;)V", "applyTransformation", "", "interpolatedTime", "", "t", "Landroid/view/animation/Transformation;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewAnimation extends Animation {
        public ViewAnimation() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            EQWaveformView.this.xRadio = interpolatedTime;
            EQWaveformView.this.postInvalidate();
        }
    }

    /* JADX INFO: compiled from: EQWaveformView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/nothing/base/wiget/EQWaveformView$Companion;", "", "<init>", "()V", "MAX_Y", "", "getMAX_Y", "()I", "setMAX_Y", "(I)V", "MIN_X", "X_20", "", "X_50", "X_100", "X_500", "X_1000", "X_5000", "X_10000", "X_20000", "LINE_WIDTH", "BG_RADIUS", "TEXT_HEIGHT", "TEXT_SIZE", "WHITE_RADIUS", "OUT_WHITE_RADIUS", "MAX_Y_POINT", "START_INDEX", "ANIMAL_TIME", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getMAX_Y() {
            return EQWaveformView.MAX_Y;
        }

        public final void setMAX_Y(int i) {
            EQWaveformView.MAX_Y = i;
        }
    }
}
