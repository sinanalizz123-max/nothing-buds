package com.nothingbuds.service

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import com.nothingbuds.data.DeviceModels

/**
 * Wakes the service when earbuds attach while the app is closed. ACL connect/disconnect are on
 * Android's implicit-broadcast exemption list, so a manifest receiver still gets them.
 *
 * On Android 12+ a background foreground-service start can be refused; the companion-device
 * association ([BudsCompanionService]) is what makes it reliable there, and this stays as the
 * fallback for older releases and for the case where the app was recently in use.
 */
class BluetoothConnectionReceiver : BroadcastReceiver() {

    companion object {
        private const val TAG = "BtConnectionReceiver"
    }

    override fun onReceive(context: Context, intent: Intent) {
        val device = deviceOf(intent) ?: return
        if (!hasPermission(context)) return

        val name = runCatching { device.name }.getOrNull() ?: return
        if (DeviceModels.findByName(name) == null && !DeviceModels.looksLikeEarbuds(name)) return

        when (intent.action) {
            BluetoothDevice.ACTION_ACL_CONNECTED -> {
                Log.d(TAG, "Earbuds connected: $name")
                val serviceIntent = Intent(context, BudsService::class.java).apply {
                    action = BudsService.ACTION_CONNECT
                    putExtra(BudsService.EXTRA_DEVICE_ADDRESS, device.address)
                }
                runCatching {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        context.startForegroundService(serviceIntent)
                    } else {
                        context.startService(serviceIntent)
                    }
                }.onFailure { Log.w(TAG, "Could not start service from background", it) }
            }

            BluetoothDevice.ACTION_ACL_DISCONNECTED -> {
                Log.d(TAG, "Earbuds disconnected: $name")
                runCatching {
                    context.startService(
                        Intent(context, BudsService::class.java)
                            .setAction(BudsService.ACTION_DISCONNECT)
                    )
                }
            }
        }
    }

    private fun deviceOf(intent: Intent): BluetoothDevice? =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE, BluetoothDevice::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
        }

    private fun hasPermission(context: Context): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
            ActivityCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) ==
            PackageManager.PERMISSION_GRANTED
}
