package androidx.media3.common.util;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import java.util.Objects;

/* JADX INFO: loaded from: /tmp/source/classes2.dex */
public final class WakeLockManager {
    private static final String TAG = "WakeLockManager";
    private static final int UNREACTIVE_WAKELOCK_HANDLER_RELEASE_DELAY_MS = 1000;
    private static final String WAKE_LOCK_TAG = "ExoPlayer:WakeLockManager";
    private boolean enabled;
    private final HandlerWrapper mainHandler;
    private boolean stayAwake;
    private final HandlerWrapper wakeLockHandler;
    private final WakeLockManagerInternal wakeLockManagerInternal;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldAcquireWakelock(boolean z, boolean z2) {
        return z && z2;
    }

    public WakeLockManager(Context context, Looper looper, Clock clock) {
        this.wakeLockManagerInternal = new WakeLockManagerInternal(context.getApplicationContext());
        this.wakeLockHandler = clock.createHandler(looper, null);
        this.mainHandler = clock.createHandler(Looper.getMainLooper(), null);
    }

    public void setEnabled(boolean z) {
        if (this.enabled == z) {
            return;
        }
        this.enabled = z;
        postUpdateWakeLock(z, this.stayAwake);
    }

    public void setStayAwake(boolean z) {
        if (this.stayAwake == z) {
            return;
        }
        this.stayAwake = z;
        if (this.enabled) {
            postUpdateWakeLock(true, z);
        }
    }

    private void postUpdateWakeLock(final boolean z, final boolean z2) {
        if (shouldAcquireWakelock(z, z2)) {
            this.wakeLockHandler.post(new Runnable() { // from class: androidx.media3.common.util.WakeLockManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4060xe56dff98(z, z2);
                }
            });
            return;
        }
        final WakeLockManagerInternal wakeLockManagerInternal = this.wakeLockManagerInternal;
        Objects.requireNonNull(wakeLockManagerInternal);
        final Runnable runnable = new Runnable() { // from class: androidx.media3.common.util.WakeLockManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                wakeLockManagerInternal.forceReleaseWakeLock();
            }
        };
        this.mainHandler.postDelayed(runnable, 1000L);
        this.wakeLockHandler.post(new Runnable() { // from class: androidx.media3.common.util.WakeLockManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4061x1aaf849a(runnable, z, z2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$postUpdateWakeLock$0$androidx-media3-common-util-WakeLockManager, reason: not valid java name */
    /* synthetic */ void m4060xe56dff98(boolean z, boolean z2) {
        this.wakeLockManagerInternal.updateWakeLock(z, z2);
    }

    /* JADX INFO: renamed from: lambda$postUpdateWakeLock$2$androidx-media3-common-util-WakeLockManager, reason: not valid java name */
    /* synthetic */ void m4061x1aaf849a(Runnable runnable, boolean z, boolean z2) {
        this.mainHandler.removeCallbacks(runnable);
        this.wakeLockManagerInternal.updateWakeLock(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class WakeLockManagerInternal {
        private final Context applicationContext;
        private PowerManager.WakeLock wakeLock;

        public WakeLockManagerInternal(Context context) {
            this.applicationContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void updateWakeLock(boolean z, boolean z2) {
            if (z) {
                if (this.wakeLock == null) {
                    if (this.applicationContext.checkSelfPermission("android.permission.WAKE_LOCK") != 0) {
                        Log.w(WakeLockManager.TAG, "WAKE_LOCK permission not granted, can't acquire wake lock for playback");
                        return;
                    }
                    PowerManager powerManager = (PowerManager) this.applicationContext.getSystemService("power");
                    if (powerManager == null) {
                        Log.w(WakeLockManager.TAG, "PowerManager is null, therefore not creating the WakeLock.");
                        return;
                    } else {
                        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, WakeLockManager.WAKE_LOCK_TAG);
                        this.wakeLock = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.setReferenceCounted(false);
                    }
                }
            }
            if (this.wakeLock == null) {
                return;
            }
            if (WakeLockManager.shouldAcquireWakelock(z, z2)) {
                this.wakeLock.acquire();
            } else {
                this.wakeLock.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void forceReleaseWakeLock() {
            PowerManager.WakeLock wakeLock = this.wakeLock;
            if (wakeLock != null) {
                wakeLock.release();
            }
        }
    }
}
