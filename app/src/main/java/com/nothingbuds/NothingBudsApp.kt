package com.nothingbuds

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class NothingBudsApp : Application() {

    companion object {
        /** Carries the quick-toggle hub. */
        const val NOTIFICATION_CHANNEL_ID = "earbuds_status"

        /**
         * Used when the hub is switched off. A foreground service must post something, so this
         * is the quietest thing Android permits — and on Android 13+ the user can swipe it away
         * without stopping the service.
         */
        const val MINIMAL_CHANNEL_ID = "earbuds_status_minimal"
    }

    override fun onCreate() {
        super.onCreate()
        com.nothingbuds.util.AppLog.init(filesDir)
        com.nothingbuds.util.AppLog.installCrashHandler()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return

        val hub = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            getString(R.string.notification_channel_name),
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = getString(R.string.notification_channel_description)
            setShowBadge(false)
        }

        val minimal = NotificationChannel(
            MINIMAL_CHANNEL_ID,
            getString(R.string.notification_channel_minimal_name),
            NotificationManager.IMPORTANCE_MIN
        ).apply {
            description = getString(R.string.notification_channel_minimal_description)
            setShowBadge(false)
        }

        getSystemService(NotificationManager::class.java)
            .createNotificationChannels(listOf(hub, minimal))
    }
}
