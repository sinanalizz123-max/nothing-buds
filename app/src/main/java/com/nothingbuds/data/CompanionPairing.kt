package com.nothingbuds.data

import android.annotation.SuppressLint
import android.app.Activity
import android.companion.AssociationRequest
import android.companion.BluetoothDeviceFilter
import android.companion.CompanionDeviceManager
import android.content.Context
import android.content.IntentSender
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

/**
 * Companion-device association.
 *
 * Associating the earbuds once buys two things on Android 12+: the system tracks their presence for
 * us (so the notification can appear and disappear with the connection), and it lets us start the
 * foreground service from the background when they come back.
 */
object CompanionPairing {

    private const val TAG = "CompanionPairing"

    fun isSupported(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    @SuppressLint("MissingPermission")
    fun associations(context: Context): List<String> {
        if (!isSupported()) return emptyList()
        val manager = context.getSystemService(CompanionDeviceManager::class.java) ?: return emptyList()
        return runCatching { manager.associations }.getOrDefault(emptyList())
    }

    fun isAssociated(context: Context): Boolean = associations(context).isNotEmpty()

    /**
     * Opens the system picker. The caller launches [onIntentSender] through an
     * ActivityResultLauncher and calls [startObserving] once the user has picked a device.
     */
    @RequiresApi(Build.VERSION_CODES.S)
    fun requestAssociation(
        activity: Activity,
        onIntentSender: (IntentSender) -> Unit,
        onFailure: (CharSequence?) -> Unit = {},
    ) {
        val manager = activity.getSystemService(CompanionDeviceManager::class.java) ?: return

        val filter = BluetoothDeviceFilter.Builder()
            .setNamePattern(Regex("(?i).*(nothing|cmf|ear).*").toPattern())
            .build()

        val request = AssociationRequest.Builder()
            .addDeviceFilter(filter)
            .setSingleDevice(false)
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            manager.associate(
                request,
                activity.mainExecutor,
                object : CompanionDeviceManager.Callback() {
                    override fun onAssociationPending(intentSender: IntentSender) =
                        onIntentSender(intentSender)

                    override fun onAssociationCreated(associationInfo: android.companion.AssociationInfo) {
                        startObserving(activity)
                    }

                    override fun onFailure(error: CharSequence?) = onFailure(error)
                }
            )
        } else {
            @Suppress("DEPRECATION")
            manager.associate(
                request,
                object : CompanionDeviceManager.Callback() {
                    @Deprecated("Pre-Tiramisu entry point")
                    override fun onDeviceFound(chooserLauncher: IntentSender) =
                        onIntentSender(chooserLauncher)

                    override fun onFailure(error: CharSequence?) = onFailure(error)
                },
                null
            )
        }
    }

    /**
     * Call after the user picked a device in the system dialog. The association itself is created
     * by the platform, so all that is left is to start tracking it.
     */
    fun onDevicePicked(context: Context) {
        startObserving(context)
    }

    /** Ask the system to notify us whenever an associated device appears or disappears. */
    @SuppressLint("MissingPermission")
    fun startObserving(context: Context) {
        if (!isSupported()) return
        val manager = context.getSystemService(CompanionDeviceManager::class.java) ?: return
        associations(context).forEach { address ->
            runCatching { manager.startObservingDevicePresence(address) }
                .onFailure { Log.w(TAG, "Cannot observe $address", it) }
        }
    }

    @SuppressLint("MissingPermission")
    fun stopObserving(context: Context) {
        if (!isSupported()) return
        val manager = context.getSystemService(CompanionDeviceManager::class.java) ?: return
        associations(context).forEach { address ->
            runCatching { manager.stopObservingDevicePresence(address) }
        }
    }
}
