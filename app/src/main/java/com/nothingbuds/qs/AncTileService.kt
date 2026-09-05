package com.nothingbuds.qs

import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import com.nothingbuds.R
import com.nothingbuds.data.BudsRepository
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.AncMode
import com.nothingbuds.service.BudsService
import com.nothingbuds.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Quick Settings tile that cycles the listening mode: ANC -> Transparency -> Off.
 *
 * Android tiles only know two checked states, so the third state is carried by the icon and the
 * subtitle instead — tapping always advances the cycle.
 */
class AncTileService : TileService() {

    private var scope: CoroutineScope? = null
    private var observeJob: Job? = null

    override fun onStartListening() {
        super.onStartListening()
        val newScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
        scope = newScope
        observeJob = newScope.launch {
            BudsRepository.state.collectLatest { render(it) }
        }
    }

    override fun onStopListening() {
        observeJob?.cancel()
        scope?.cancel()
        scope = null
        super.onStopListening()
    }

    override fun onClick() {
        super.onClick()
        val state = BudsRepository.state.value

        if (!state.isConnected) {
            launchApp()
            return
        }

        // Optimistic local flip so the tile animates immediately; the service confirms it.
        val next = AncMode.cycle(
            current = state.ancMode,
            hasTransparency = state.deviceModel?.hasTransparency ?: true,
            ancLevel = state.ancLevel
        )
        render(state.copy(ancMode = next))

        runCatching {
            startService(
                Intent(this, BudsService::class.java).apply {
                    action = BudsService.ACTION_SET_ANC
                    putExtra(BudsService.EXTRA_ANC_MODE, next.name)
                }
            )
        }
    }

    private fun render(state: EarbudsState) {
        val tile = qsTile ?: return

        tile.label = getString(R.string.tile_label)
        if (!state.isConnected) {
            tile.state = Tile.STATE_UNAVAILABLE
            tile.icon = Icon.createWithResource(this, R.drawable.ic_anc_off)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                tile.subtitle = getString(R.string.tile_disconnected)
            }
            tile.updateTile()
            return
        }

        val (iconRes, subtitle) = when (state.ancMode) {
            AncMode.OFF -> R.drawable.ic_anc_off to getString(R.string.mode_off)
            AncMode.TRANSPARENCY -> R.drawable.ic_transparency to getString(R.string.mode_transparency)
            else -> R.drawable.ic_anc to getString(R.string.mode_anc)
        }

        tile.state = if (state.ancMode == AncMode.OFF) Tile.STATE_INACTIVE else Tile.STATE_ACTIVE
        tile.icon = Icon.createWithResource(this, iconRes)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            tile.subtitle = subtitle
        }
        tile.updateTile()
    }

    private fun launchApp() {
        val intent = Intent(this, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            startActivityAndCollapse(
                PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                )
            )
        } else {
            @Suppress("DEPRECATION")
            startActivityAndCollapse(intent)
        }
    }
}
