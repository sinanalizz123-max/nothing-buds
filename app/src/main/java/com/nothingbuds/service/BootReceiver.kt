package com.nothingbuds.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.nothingbuds.util.AppLog
import androidx.core.content.ContextCompat

class BootReceiver : BroadcastReceiver() {

    companion object {
        private const val TAG = "BootReceiver"
        private const val PREF_AUTO_CONNECT = "auto_connect"
        private const val PREF_LAST_DEVICE = "last_device_address"
        private const val PREFS_NAME = "earbuds_prefs"
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_BOOT_COMPLETED &&
            intent.action != "android.intent.action.QUICKBOOT_POWERON") {
            return
        }

        AppLog.d(TAG, "Boot completed, checking auto-connect settings")

        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val autoConnect = prefs.getBoolean(PREF_AUTO_CONNECT, true)
        val lastDeviceAddress = prefs.getString(PREF_LAST_DEVICE, null)

        if (!autoConnect) {
            AppLog.d(TAG, "Auto-connect disabled, not starting service")
            return
        }

        // Start the foreground service
        val serviceIntent = Intent(context, BudsService::class.java)

        if (lastDeviceAddress != null) {
            serviceIntent.action = BudsService.ACTION_CONNECT
            serviceIntent.putExtra(BudsService.EXTRA_DEVICE_ADDRESS, lastDeviceAddress)
            AppLog.d(TAG, "Starting service with auto-connect to: $lastDeviceAddress")
        } else {
            AppLog.d(TAG, "Starting service without auto-connect (no last device)")
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // A boot-time start can be refused on Android 12+ if the app is background-restricted;
            // wrap it so an IllegalStateException cannot crash the process.
            runCatching { ContextCompat.startForegroundService(context, serviceIntent) }
                .onFailure { AppLog.w(TAG, "Could not start service at boot", it) }
        } else {
            runCatching { context.startService(serviceIntent) }
                .onFailure { AppLog.w(TAG, "Could not start service at boot", it) }
        }
    }
}
