package com.nothing.base.util;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import io.flutter.plugins.firebase.analytics.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VibratorAnimationUtils.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/nothing/base/util/VibratorAnimationUtils;", "", "<init>", "()V", "playerMedia", "Landroid/media/MediaPlayer;", "SECONDS_1000", "", "SECONDS_200", "SECONDS_500", "SECONDS_10", "SECONDS_2", "startVibrator", "", "activity", "Landroid/app/Activity;", Constants.MILLISECONDS, "Lcom/nothing/base/util/VibratorAnimationUtils$VibratorMilliSeconds;", "context", "Landroid/content/Context;", "previewVibrator", "isChecked", "", "VibratorMilliSeconds", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VibratorAnimationUtils {
    public static final VibratorAnimationUtils INSTANCE = new VibratorAnimationUtils();
    public static final long SECONDS_10 = 10;
    public static final long SECONDS_1000 = 1000;
    public static final long SECONDS_2 = 2;
    public static final long SECONDS_200 = 200;
    public static final long SECONDS_500 = 500;
    private static MediaPlayer playerMedia;

    private VibratorAnimationUtils() {
    }

    /* JADX INFO: compiled from: VibratorAnimationUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/base/util/VibratorAnimationUtils$VibratorMilliSeconds;", "", "seconds", "", "<init>", "(Ljava/lang/String;IJ)V", "getSeconds", "()J", "setSeconds", "(J)V", "Seconds1000", "Seconds10", "Seconds200", "Seconds500", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum VibratorMilliSeconds {
        Seconds1000(1000),
        Seconds10(10),
        Seconds200(200),
        Seconds500(500);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private long seconds;

        public static EnumEntries<VibratorMilliSeconds> getEntries() {
            return $ENTRIES;
        }

        VibratorMilliSeconds(long j) {
            this.seconds = j;
        }

        public final long getSeconds() {
            return this.seconds;
        }

        public final void setSeconds(long j) {
            this.seconds = j;
        }
    }

    public final void startVibrator(Activity activity) {
        startVibrator(activity, VibratorMilliSeconds.Seconds1000);
    }

    public final void startVibrator(Activity activity, VibratorMilliSeconds milliseconds) {
        Intrinsics.checkNotNullParameter(milliseconds, "milliseconds");
        Vibrator vibrator = (Vibrator) (activity != null ? activity.getSystemService("vibrator") : null);
        if (vibrator != null) {
            vibrator.vibrate(10L);
        }
    }

    public final void startVibrator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(VibrationEffect.createPredefined(5));
    }

    public final void previewVibrator(Activity activity, boolean isChecked) {
        if (isChecked) {
            return;
        }
        startVibrator(activity);
    }

    public final void previewVibrator(Activity activity, boolean isChecked, VibratorMilliSeconds milliseconds) {
        Intrinsics.checkNotNullParameter(milliseconds, "milliseconds");
        if (isChecked) {
            return;
        }
        startVibrator(activity, milliseconds);
    }
}
