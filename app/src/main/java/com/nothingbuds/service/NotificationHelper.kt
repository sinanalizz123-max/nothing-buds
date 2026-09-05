package com.nothingbuds.service

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.nothingbuds.NothingBudsApp
import com.nothingbuds.R
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.AncMode
import com.nothingbuds.ui.MainActivity
import android.os.Build

/**
 * Builds the ongoing notification. It is a quick-toggle hub: battery on the first line,
 * one action per listening mode (ANC / Transparency / Off) with the active one marked.
 *
 * The notification only ever exists while earbuds are connected — see [BudsService].
 */
class NotificationHelper(private val context: Context) {

    companion object {
        const val PREFS_NAME = "earbuds_prefs"
        const val PREF_SHOW_HUB = "show_notification"
    }

    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    /** The hub can be switched off in settings; the tile keeps working either way. */
    private val hubEnabled: Boolean
        get() = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getBoolean(PREF_SHOW_HUB, true)

    /** Short-lived placeholder shown while the SPP link is being established. */
    fun createConnectingNotification(): Notification =
        baseBuilder()
            .setContentTitle(context.getString(R.string.app_name))
            .setContentText(context.getString(R.string.notif_connecting))
            .build()

    fun createNotification(state: EarbudsState): Notification {
        if (!state.isConnected) return createConnectingNotification()
        if (!hubEnabled) return createMinimalNotification(state)

        val title = state.deviceName.ifEmpty { context.getString(R.string.app_name) }
        val builder = baseBuilder()
            .setSmallIcon(ancIcon(state.ancMode))
            .setContentTitle(title)
            .setContentText("${batteryText(state)}  ·  ${ancLabel(state.ancMode)}")
            // Only the device name goes in the header. Battery and mode live in the expanded view,
            // so the same values are not repeated twice in one notification.
            .setSubText(title)

        val model = state.deviceModel
        val hasAnc = model == null || model.hasAnc
        if (!hasAnc) return builder.build()

        // A segmented row of full-width buttons reads better than the thin default actions and can
        // show which mode is selected. Standard actions are deliberately not added on top: the
        // decorated style would render them below the custom view, duplicating the same controls.
        val hasTransparency = model == null || model.hasTransparency

        val expanded = RemoteViews(context.packageName, R.layout.notification_hub).apply {
            setTextViewText(R.id.hub_battery, "${batteryText(state)}  ·  ${ancLabel(state.ancMode)}")
            bindSegments(state, hasTransparency)
        }

        val collapsed = RemoteViews(context.packageName, R.layout.notification_hub_compact).apply {
            bindSegments(state, hasTransparency)
        }

        return builder
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(collapsed)
            .setCustomBigContentView(expanded)
            .build()
    }

    private fun RemoteViews.bindSegments(state: EarbudsState, hasTransparency: Boolean) {
        val current = state.ancMode
        // Coming back to ANC returns to the level that was in use before, which is what the
        // earbuds themselves track in group 0x02 of the ANC report.
        val ancTarget = state.ancLevel.takeIf { it.isAnc } ?: AncMode.HIGH

        bindSegment(R.id.segment_anc, ancTarget, current, requestCode = 11)
        bindSegment(
            R.id.segment_transparency,
            AncMode.TRANSPARENCY,
            current,
            requestCode = 12,
            enabled = hasTransparency
        )
        bindSegment(R.id.segment_off, AncMode.OFF, current, requestCode = 13)
    }

    /**
     * Paints one segment and wires its tap. The selected segment is filled; the rest are muted.
     */
    private fun RemoteViews.bindSegment(
        viewId: Int,
        mode: AncMode,
        current: AncMode,
        requestCode: Int,
        enabled: Boolean = true,
    ) {
        if (!enabled) {
            setViewVisibility(viewId, android.view.View.GONE)
            return
        }

        val selected = if (mode.isAnc) current.isAnc else current == mode

        setInt(
            viewId,
            "setBackgroundResource",
            if (selected) R.drawable.bg_segment_active else R.drawable.bg_segment_inactive
        )
        setTextColor(
            viewId,
            context.getColor(
                if (selected) R.color.segment_active_fg else R.color.segment_inactive_fg
            )
        )
        setOnClickPendingIntent(viewId, ancPendingIntent(mode, requestCode))
    }

    /**
     * What the service posts when the hub is disabled: one silent line on a MIN-importance
     * channel, no controls. Android 13+ lets the user swipe even this away.
     */
    private fun createMinimalNotification(state: EarbudsState): Notification =
        NotificationCompat.Builder(context, NothingBudsApp.MINIMAL_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_earbuds)
            .setContentTitle(state.deviceName.ifEmpty { context.getString(R.string.app_name) })
            .setContentText(context.getString(R.string.notif_minimal_text))
            .setOngoing(true)
            .setShowWhen(false)
            .setSilent(true)
            .setOnlyAlertOnce(true)
            .setPriority(NotificationCompat.PRIORITY_MIN)
            .build()

    private fun baseBuilder(): NotificationCompat.Builder =
        NotificationCompat.Builder(context, NothingBudsApp.NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_earbuds)
            .setContentIntent(
                PendingIntent.getActivity(
                    context,
                    0,
                    Intent(context, MainActivity::class.java),
                    PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                )
            )
            .setOngoing(true)
            .setShowWhen(false)
            .setSilent(true)
            .setOnlyAlertOnce(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setPriority(NotificationCompat.PRIORITY_LOW)

    /**
     * Explicit component on purpose: Android 14 drops implicit intents aimed at a non-exported
     * component, which silently killed every action tap.
     */
    private fun ancPendingIntent(mode: AncMode, requestCode: Int): PendingIntent {
        val serviceIntent = Intent(context, BudsService::class.java)
            .setAction(BudsService.ACTION_SET_ANC)
            .putExtra(BudsService.EXTRA_ANC_MODE, mode.name)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PendingIntent.getForegroundService(
                context,
                requestCode,
                serviceIntent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        } else {
            PendingIntent.getService(
                context,
                requestCode,
                serviceIntent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        }
    }

    private fun ancIcon(mode: AncMode): Int = when (mode) {
        AncMode.OFF -> R.drawable.ic_anc_off
        AncMode.TRANSPARENCY -> R.drawable.ic_transparency
        else -> R.drawable.ic_anc
    }

    private fun batteryText(state: EarbudsState): String {
        val parts = mutableListOf<String>()
        with(state.battery) {
            if (isLeftConnected) parts.add("L ${left}%${if (leftCharging) "⚡" else ""}")
            if (isRightConnected) parts.add("R ${right}%${if (rightCharging) "⚡" else ""}")
            if (isCaseConnected) parts.add("◱ ${case}%${if (caseCharging) "⚡" else ""}")
        }
        return if (parts.isEmpty()) context.getString(R.string.battery_unknown) else parts.joinToString("  ")
    }

    private fun ancLabel(mode: AncMode): String = when (mode) {
        AncMode.OFF -> context.getString(R.string.anc_state_off)
        AncMode.LOW -> context.getString(R.string.anc_state_low)
        AncMode.MID -> context.getString(R.string.anc_state_mid)
        AncMode.HIGH -> context.getString(R.string.anc_state_high)
        AncMode.ADAPTIVE -> context.getString(R.string.anc_state_adaptive)
        AncMode.TRANSPARENCY -> context.getString(R.string.mode_transparency)
    }

    fun updateNotification(notificationId: Int, notification: Notification) {
        notificationManager.notify(notificationId, notification)
    }

    fun cancel(notificationId: Int) {
        notificationManager.cancel(notificationId)
    }
}
