package com.nothingbuds.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Cases
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.PacketBuilder

/**
 * Per-side gesture customization. The rows, the charging-case rows and the per-trigger operation
 * list all come from the connected model's [GestureProfile] ([GestureCapabilities.profileFor]),
 * which mirrors the matching `ControlItemViewModel.convertOptions()` of the official app. The UI
 * never offers operations a model does not expose, and no model falls back to the full union.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GestureScreen(
    state: EarbudsState,
    onBack: () -> Unit,
    onSetGesture: (Int, Int, Int) -> Unit,
) {
    val profile = remember(state.deviceModel?.id) {
        GestureCapabilities.profileFor(state.deviceModel?.id)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gesture controls") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            SideCard("Left earbud", PacketBuilder.SIDE_LEFT, profile.slots, state, onSetGesture)
            SideCard("Right earbud", PacketBuilder.SIDE_RIGHT, profile.slots, state, onSetGesture)
            if (state.deviceModel?.hasSmartDial == true && profile.caseSlots.isNotEmpty()) {
                CaseCard(profile, state, onSetGesture)
            }
            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SideCard(
    title: String,
    side: Int,
    slots: List<GestureSlot>,
    state: EarbudsState,
    onSetGesture: (Int, Int, Int) -> Unit,
) {
    SectionCard(title, Icons.Default.TouchApp) {
        slots.forEachIndexed { index, slot ->
            if (index > 0) Spacer(Modifier.height(4.dp))
            GestureSlotRow(side = side, slot = slot, state = state, onSetGesture = onSetGesture)
        }
    }
}

@Composable
private fun CaseCard(
    profile: GestureProfile,
    state: EarbudsState,
    onSetGesture: (Int, Int, Int) -> Unit,
) {
    SectionCard("Charging case", Icons.Default.Cases) {
        Text(
            "Changing case controls makes the case reboot to apply them.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(Modifier.height(8.dp))
        profile.caseSlots.forEachIndexed { index, slot ->
            if (index > 0) Spacer(Modifier.height(4.dp))
            GestureSlotRow(side = PacketBuilder.SIDE_CASE, slot = slot, state = state, onSetGesture = onSetGesture)
        }
    }
}

@Composable
private fun GestureSlotRow(
    side: Int,
    slot: GestureSlot,
    state: EarbudsState,
    onSetGesture: (Int, Int, Int) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    val profile = remember(state.deviceModel?.id) {
        GestureCapabilities.profileFor(state.deviceModel?.id)
    }
    val context = androidx.compose.ui.platform.LocalContext.current
    val allowedIds = profile.operationsFor(side, slot.type)
    val allowed = GESTURE_ACTIONS.filter { it.id in allowedIds }
    val fixedLabel = fixedSlotLabel(side, slot.type)
    val current = state.gestures
        .find { it.side == side && it.type == slot.type }
        ?.let { GESTURE_ACTIONS.find { action -> action.id == it.action } }
        ?: allowed.find { it.id == profile.defaultFor(side, slot.type, context) }
            ?: allowed.firstOrNull()

    if (fixedLabel != null || allowed.isEmpty()) {
        // Fixed or unconfigurable slot: show its state without a picker.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(slot.label, style = MaterialTheme.typography.bodyLarge)
                Text(
                    fixedLabel ?: current?.label ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
        return
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(slot.label, style = MaterialTheme.typography.bodyLarge)
            Text(
                current?.label ?: "",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        Icon(
            Icons.Default.ArrowDropDown,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        Box {
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                allowed.forEach { action ->
                    DropdownMenuItem(
                        text = { Text(action.label) },
                        onClick = {
                            expanded = false
                            if (action.id != current?.id) {
                                onSetGesture(side, slot.type, action.id)
                            }
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Default.TouchApp,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp),
                            )
                        },
                    )
                }
            }
        }
    }
}

/**
 * Gesture 15 "double press & hold" is never configurable: on the case it is the fixed case-lock
 * row `Operation(4, 1, 15, 40)`, on the earbuds the official app renders an arrow-only row.
 */
private fun fixedSlotLabel(side: Int, type: Int): String? = when {
    type != 15 -> null
    side == PacketBuilder.SIDE_CASE -> "Case lock"
    else -> "Not configurable"
}

// ---- Building blocks -------------------------------------------------------------------------

@Composable
private fun SectionCard(
    title: String,
    icon: ImageVector,
    content: @Composable ColumnScope.() -> Unit,
) {
    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = MaterialTheme.shapes.extraLarge,
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text(title, style = MaterialTheme.typography.titleMedium)
            }
            Spacer(Modifier.height(8.dp))
            content()
        }
    }
    Spacer(Modifier.height(12.dp))
}