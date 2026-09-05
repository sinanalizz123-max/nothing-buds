package com.nothing.base.util;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.ImageFormat;
import android.media.Image;
import android.util.Log;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.nothing.log.FileLog;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00020!\"\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020$2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0&Je\u0010+\u001a\u00020\u001f2\n\u0010 \u001a\u00020!\"\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020$2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020*0.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020*0.JU\u00100\u001a\u00020\u001f2\n\u0010 \u001a\u00020!\"\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020$2-\u0010%\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d01\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0&JI\u00102\u001a\u00020\u001f2\n\u0010 \u001a\u000203\"\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020$2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0&J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0002J\u0016\u00107\u001a\u0002082\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020\u0007J0\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u0010<\u001a\u0002082\u0006\u0010=\u001a\u000208H\u0002J\u000e\u0010>\u001a\u00020\u00072\u0006\u0010<\u001a\u000208J\"\u0010?\u001a\u00020\u001d2\u0006\u0010<\u001a\u0002082\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\u0007J0\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u00072\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u001d2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00170.H\u0086@\u00a2\u0006\u0002\u0010FR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/nothing/base/util/Utils;", "", "<init>", "()V", "BAR_HEIGHT", "", "COLOR_FORMAT_I420", "", "COLOR_FORMAT_NV21", "MUSIC_CHECK", "VIDEO_CHECK", "BITS_PER_UNIT", "I420_OFFSET", "", "CRC16_INIT", "CRC16_INIT_XOR", "POLYNOMIAL", "processIsKill", "getProcessIsKill", "()I", "setProcessIsKill", "(I)V", "newsClick", "", "getNewsClick", "()Z", "setNewsClick", "(Z)V", "DURATION", "", "valueAnimatorStartByFloat", "Landroid/animation/ValueAnimator;", "values", "", "duration", "interpolator", "Landroid/animation/TimeInterpolator;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "valueAnimatorStartByFloat2", "updateAction", "endAction", "Lkotlin/Function0;", "startAction", "valueAnimatorStartByTimeAndFloat", "Lkotlin/Pair;", "valueAnimatorStartByInt", "", "isImageFormatSupported", "image", "Landroid/media/Image;", "getDataFromImage", "", "colorFormat", "getDataFromImageInternal", "index", "data", "rowData", "obtainCrc16", "obtainCrc32", "offset", "length", "retryWhenFail", "retryTimes", "retryIntervalMs", "func", "(ILjava/lang/Long;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Utils {
    public static final float BAR_HEIGHT = 8.0f;
    private static final int BITS_PER_UNIT = 8;
    public static final int COLOR_FORMAT_I420 = 1;
    public static final int COLOR_FORMAT_NV21 = 2;
    private static final int CRC16_INIT = 65535;
    private static final int CRC16_INIT_XOR = 255;
    private static final long DURATION = 300;
    private static final double I420_OFFSET = 1.25d;
    public static final int MUSIC_CHECK = 3;
    private static final int POLYNOMIAL = 40961;
    public static final int VIDEO_CHECK = 0;
    private static boolean newsClick;
    public static final Utils INSTANCE = new Utils();
    private static int processIsKill = -1;

    /* JADX INFO: renamed from: com.nothing.base.util.Utils$retryWhenFail$1, reason: invalid class name */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.base.util.Utils", f = "Utils.kt", i = {0, 0, 0, 0}, l = {248}, m = "retryWhenFail", n = {"this", "retryIntervalMs", "func", "retryNumbers"}, s = {"L$0", "L$1", "L$2", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Utils.this.retryWhenFail(0, null, null, this);
        }
    }

    private Utils() {
    }

    public final int getProcessIsKill() {
        return processIsKill;
    }

    public final void setProcessIsKill(int i) {
        processIsKill = i;
    }

    public final boolean getNewsClick() {
        return newsClick;
    }

    public final void setNewsClick(boolean z) {
        newsClick = z;
    }

    public static /* synthetic */ ValueAnimator valueAnimatorStartByFloat$default(Utils utils, float[] fArr, long j, TimeInterpolator timeInterpolator, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            timeInterpolator = new FastOutSlowInInterpolator();
        }
        return utils.valueAnimatorStartByFloat(fArr, j2, timeInterpolator, function1);
    }

    public final ValueAnimator valueAnimatorStartByFloat(float[] values, long duration, TimeInterpolator interpolator, final Function1<? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(action, "action");
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Arrays.copyOf(values, values.length));
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.nothing.base.util.Utils$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Utils.valueAnimatorStartByFloat$lambda$0(action, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void valueAnimatorStartByFloat$lambda$0(Function1 function1, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        if (animatedValue instanceof Float) {
            function1.invoke(animatedValue);
        }
    }

    public static /* synthetic */ ValueAnimator valueAnimatorStartByFloat2$default(Utils utils, float[] fArr, long j, TimeInterpolator timeInterpolator, Function1 function1, Function0 function0, Function0 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            timeInterpolator = new FastOutSlowInInterpolator();
        }
        return utils.valueAnimatorStartByFloat2(fArr, j2, timeInterpolator, function1, function0, function2);
    }

    public final ValueAnimator valueAnimatorStartByFloat2(float[] values, long duration, TimeInterpolator interpolator, final Function1<? super Float, Unit> updateAction, final Function0<Unit> endAction, final Function0<Unit> startAction) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(updateAction, "updateAction");
        Intrinsics.checkNotNullParameter(endAction, "endAction");
        Intrinsics.checkNotNullParameter(startAction, "startAction");
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Arrays.copyOf(values, values.length));
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.nothing.base.util.Utils.valueAnimatorStartByFloat2.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                startAction.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                endAction.invoke();
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.nothing.base.util.Utils$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Utils.valueAnimatorStartByFloat2$lambda$1(updateAction, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void valueAnimatorStartByFloat2$lambda$1(Function1 function1, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        if (animatedValue instanceof Float) {
            function1.invoke(animatedValue);
        }
    }

    public static /* synthetic */ ValueAnimator valueAnimatorStartByTimeAndFloat$default(Utils utils, float[] fArr, long j, TimeInterpolator timeInterpolator, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            timeInterpolator = new FastOutSlowInInterpolator();
        }
        return utils.valueAnimatorStartByTimeAndFloat(fArr, j2, timeInterpolator, function1);
    }

    public final ValueAnimator valueAnimatorStartByTimeAndFloat(float[] values, long duration, TimeInterpolator interpolator, final Function1<? super Pair<Float, Long>, Unit> action) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(action, "action");
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Arrays.copyOf(values, values.length));
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.nothing.base.util.Utils$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Utils.valueAnimatorStartByTimeAndFloat$lambda$2(action, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void valueAnimatorStartByTimeAndFloat$lambda$2(Function1 function1, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        long currentPlayTime = it.getCurrentPlayTime();
        if (animatedValue instanceof Float) {
            function1.invoke(new Pair(animatedValue, Long.valueOf(currentPlayTime)));
        }
    }

    public static /* synthetic */ ValueAnimator valueAnimatorStartByInt$default(Utils utils, int[] iArr, long j, TimeInterpolator timeInterpolator, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            timeInterpolator = new FastOutSlowInInterpolator();
        }
        return utils.valueAnimatorStartByInt(iArr, j2, timeInterpolator, function1);
    }

    public final ValueAnimator valueAnimatorStartByInt(int[] values, long duration, TimeInterpolator interpolator, final Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(action, "action");
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(Arrays.copyOf(values, values.length));
        valueAnimatorOfInt.setDuration(duration);
        valueAnimatorOfInt.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.nothing.base.util.Utils$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Utils.valueAnimatorStartByInt$lambda$3(action, valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
        Intrinsics.checkNotNull(valueAnimatorOfInt);
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void valueAnimatorStartByInt$lambda$3(Function1 function1, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        if (animatedValue instanceof Integer) {
            function1.invoke(animatedValue);
        }
    }

    private final boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        return format == 17 || format == 35 || format == 842094169;
    }

    public final byte[] getDataFromImage(Image image, int colorFormat) {
        Intrinsics.checkNotNullParameter(image, "image");
        if (colorFormat != 1 || colorFormat != 2 || !isImageFormatSupported(image)) {
            return new byte[0];
        }
        int iWidth = image.getCropRect().width();
        int iHeight = image.getCropRect().height();
        Image.Plane[] planes = image.getPlanes();
        byte[] bArr = new byte[((iWidth * iHeight) * ImageFormat.getBitsPerPixel(image.getFormat())) / 8];
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        int length = planes.length;
        for (int i = 0; i < length; i++) {
            getDataFromImageInternal(i, colorFormat, image, bArr, bArr2);
        }
        return bArr;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0030  */
    private final void getDataFromImageInternal(int index, int colorFormat, Image image, byte[] data, byte[] rowData) {
        int i;
        int i2;
        int i3;
        Image.Plane plane = image.getPlanes()[index];
        int iWidth = image.getCropRect().width();
        int iHeight = image.getCropRect().height();
        int i4 = image.getCropRect().top;
        int i5 = image.getCropRect().left;
        if (index != 0) {
            i2 = 2;
            if (index != 1) {
                if (index != 2) {
                    i = 0;
                    i2 = 1;
                } else if (colorFormat == 1) {
                    i = (int) (((double) (iWidth * iHeight)) * I420_OFFSET);
                    i2 = 1;
                } else if (colorFormat != 2) {
                    i = 0;
                    i2 = 1;
                } else {
                    i = iWidth * iHeight;
                }
            } else if (colorFormat == 1) {
                i = iWidth * iHeight;
                i2 = 1;
            } else if (colorFormat != 2) {
                i = 0;
                i2 = 1;
            } else {
                i = (iWidth * iHeight) + 1;
            }
        } else {
            i = 0;
            i2 = 1;
        }
        ByteBuffer buffer = plane.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
        int rowStride = plane.getRowStride();
        int pixelStride = plane.getPixelStride();
        int i6 = index == 0 ? 0 : 1;
        int i7 = iWidth >> i6;
        int i8 = iHeight >> i6;
        buffer.position(((i4 >> i6) * rowStride) + ((i5 >> i6) * pixelStride));
        for (int i9 = 0; i9 < i8; i9++) {
            if (pixelStride == 1 && i2 == 1) {
                buffer.get(data, i, i7);
                i += i7;
                i3 = i7;
            } else {
                i3 = ((i7 - 1) * pixelStride) + 1;
                buffer.get(rowData, 0, i3);
                for (int i10 = 0; i10 < i7; i10++) {
                    data[i] = rowData[i10 * pixelStride];
                    i += i2;
                }
            }
            if (i9 < i8 - 1) {
                buffer.position((buffer.position() + rowStride) - i3);
            }
        }
    }

    public final int obtainCrc16(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i = 65535;
        for (byte b : data) {
            i = (i & 65535) ^ (b & 255);
            for (int i2 = 0; i2 < 8; i2++) {
                i = (i & 1) > 0 ? (i >> 1) ^ POLYNOMIAL : i >> 1;
            }
        }
        return i;
    }

    public static /* synthetic */ long obtainCrc32$default(Utils utils, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return utils.obtainCrc32(bArr, i, i2);
    }

    public final long obtainCrc32(byte[] data, int offset, int length) {
        Intrinsics.checkNotNullParameter(data, "data");
        CRC32 crc32 = new CRC32();
        crc32.update(data, offset, length);
        return crc32.getValue();
    }

    public static /* synthetic */ Object retryWhenFail$default(Utils utils, int i, Long l, Function0 function0, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        return utils.retryWhenFail(i, l, function0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0055 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0057 -> B:24:0x0078). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006e -> B:23:0x0073). Please report as a decompilation issue!!! */
    public final Object retryWhenFail(int i, Long l, Function0<Boolean> function0, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        Utils utils;
        Function0<Boolean> function1;
        boolean zBooleanValue;
        AnonymousClass1 anonymousClass2;
        Utils utils2;
        int i2;
        Long l2;
        Long l3;
        Function0<Boolean> function2;
        int i3;
        int i4;
        Logger logger;
        String tag;
        int depth;
        String strComponent1;
        String strComponent2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                utils = this;
            } else {
                utils = this;
                anonymousClass1 = utils.new AnonymousClass1(continuation);
            }
        } else {
            utils = this;
            anonymousClass1 = utils.new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass1.label;
        boolean z = true;
        z = true;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            function1 = function0;
            zBooleanValue = false;
            anonymousClass2 = anonymousClass1;
            utils2 = utils;
            i2 = i;
            l2 = l;
            if (zBooleanValue && i2 > 0) {
                if (l2 != null) {
                    long jLongValue = l2.longValue();
                    anonymousClass2.L$0 = utils2;
                    anonymousClass2.L$1 = l2;
                    anonymousClass2.L$2 = function1;
                    anonymousClass2.I$0 = i2;
                    anonymousClass2.label = z ? 1 : 0;
                    if (DelayKt.delay(jLongValue, anonymousClass2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AnonymousClass1 anonymousClass3 = anonymousClass2;
                    l3 = l2;
                    anonymousClass1 = anonymousClass3;
                    function2 = function1;
                    i3 = i2;
                }
                zBooleanValue = function1.invoke().booleanValue();
                i4 = i2 - 1;
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(z) && "utils-retry".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    strComponent1 = trace.component1();
                    strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    i = i4;
                    l = l2;
                    FileLog.print$default(fileLog, 3, str, tag, "utils-retry " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "utils-retry " + strComponent2);
                    }
                } else {
                    i = i4;
                    l = l2;
                }
                z = true;
                i2 = i;
                l2 = l;
                if (zBooleanValue) {
                }
                return Boxing.boxBoolean(zBooleanValue);
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i3 = anonymousClass1.I$0;
        function2 = (Function0) anonymousClass1.L$2;
        l3 = (Long) anonymousClass1.L$1;
        utils2 = (Utils) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        Long l4 = l3;
        anonymousClass2 = anonymousClass1;
        l2 = l4;
        i2 = i3;
        function1 = function2;
        zBooleanValue = function1.invoke().booleanValue();
        i4 = i2 - 1;
        logger = Logger.INSTANCE;
        tag = logger.getTAG();
        depth = logger.getDepth();
        if (logger.isCanLogger(z)) {
            Pair<String, String> trace2 = logger.getTrace(depth);
            strComponent1 = trace2.component1();
            strComponent2 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str2 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            i = i4;
            l = l2;
            FileLog.print$default(fileLog2, 3, str2, tag, "utils-retry " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "utils-retry " + strComponent2);
            }
            z = true;
            i2 = i;
            l2 = l;
            if (zBooleanValue) {
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        i = i4;
        l = l2;
        z = true;
        i2 = i;
        l2 = l;
        if (zBooleanValue) {
        }
        return Boxing.boxBoolean(zBooleanValue);
    }
}
