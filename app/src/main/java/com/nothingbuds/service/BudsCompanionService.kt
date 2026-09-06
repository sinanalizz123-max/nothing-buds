package com.nothingbuds.service

import android.annotation.SuppressLint
import android.companion.AssociationInfo
import android.companion.CompanionDeviceService
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

/**
 * Companion-device hook (Android 12+). Once the earbuds are associated, the system tells us when
 * they come and go — even with the app closed — and grants the exemption needed to start a
 * foreground service from the background. That is what makes the notification appear exactly while
 * the earbuds are connected, and vanish the moment they are not.
 */
@RequiresApi(Build.VERSION_CODES.S)
class BudsCompanionService : CompanionDeviceService() {

    companion object {
        private const val TAG = "BudsCompanionService"
    }

    @SuppressLint("MissingPermission")
    override fun onDeviceAppeared(associationInfo: AssociationInfo) {
        val address = associationInfo.deviceMacAddress?.toString()
        Log.d(TAG, "Companion device appeared: $address")

        val intent = Intent(this, BudsService::class.java).apply {
            action = BudsService.ACTION_CONNECT
            putExtra(BudsService.EXTRA_DEVICE_ADDRESS, address)
        }
        runCatching { startForegroundService(intent) }
            .onFailure { Log.w(TAG, "Could not start service", it) }
    }

    override fun onDeviceDisappeared(associationInfo: AssociationInfo) {
        Log.d(TAG, "Companion device disappeared")
        runCatching {
            startService(
                Intent(this, BudsService::class.java).setAction(BudsService.ACTION_DISCONNECT)
            )
        }
    }

    @Deprecated("Kept for API 31 which still calls the string overloads")
    @Suppress("DEPRECATION")
    override fun onDeviceAppeared(address: String) {
        Log.d(TAG, "Companion device appeared (legacy): $address")
        val intent = Intent(this, BudsService::class.java).apply {
            action = BudsService.ACTION_CONNECT
            putExtra(BudsService.EXTRA_DEVICE_ADDRESS, address)
        }
        runCatching { startForegroundService(intent) }
    }

    @Deprecated("Kept for API 31 which still calls the string overloads")
    @Suppress("DEPRECATION")
    override fun onDeviceDisappeared(address: String) {
        Log.d(TAG, "Companion device disappeared (legacy): $address")
        runCatching {
            startService(
                Intent(this, BudsService::class.java).setAction(BudsService.ACTION_DISCONNECT)
            )
        }
    }
}
