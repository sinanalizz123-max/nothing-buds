package com.nothingbuds.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
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

        Log.d(TAG, "Boot completed, checking auto-connect settings")

        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val autoConnect = prefs.getBoolean(PREF_AUTO_CONNECT, true)
        val lastDeviceAddress = prefs.getString(PREF_LAST_DEVICE, null)

        if (!autoConnect) {
            Log.d(TAG, "Auto-connect disabled, not starting service")
            return
        }

        // Start the foreground service
        val serviceIntent = Intent(context, BudsService::class.java)

        if (lastDeviceAddress != null) {
            serviceIntent.action = BudsService.ACTION_CONNECT
            serviceIntent.putExtra(BudsService.EXTRA_DEVICE_ADDRESS, lastDeviceAddress)
            Log.d(TAG, "Starting service with auto-connect to: $lastDeviceAddress")
        } else {
            Log.d(TAG, "Starting service without auto-connect (no last device)")
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ContextCompat.startForegroundService(context, serviceIntent)
        } else {
            context.startService(serviceIntent)
        }
    }
}
