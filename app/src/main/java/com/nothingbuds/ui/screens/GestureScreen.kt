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
 * Earbud trigger slots per model (wire type id → label), per `IOTEar*GestureAction`.
 * Espeon (B172) carries the verified set: 0 slide, 2/3 taps, 7 tap-hold, 9 double tap-hold,
 * 15 double-press-hold. Other models keep the common base.
 */
private fun earbudSlots(modelId: String?): List<Pair<Int, String>> = when (modelId) {
    "B172" -> listOf(
        0 to "Volume slide",
        2 to "Double tap",
        3 to "Triple tap",
        7 to "Tap & hold",
        9 to "Double tap & hold",
        15 to "Double press & hold",
    )
    else -> listOf(
        2 to "Double tap",
        3 to "Triple tap",
        7 to "Tap & hold",
        9 to "Double tap & hold",
    )
}

/**
 * Charging-case trigger slots for smart-dial models (Espeon/Heracross `caseGestures`):
 * 1 single, 2 double, 3 triple, 7 press-hold, 10 rotate, 15 double-press-hold.
 */
private val CASE_SLOTS = listOf(
    1 to "Single press",
    2 to "Double press",
    3 to "Triple press",
    7 to "Press & hold",
    10 to "Rotate smart dial",
    15 to "Double press & hold",
)

/**
 * Allowed action ids per (side, trigger), from the espeon `ControlItemViewModel` lists.
 * Other models keep the full [GESTURE_ACTIONS] union. "No action" (1) is always offered.
 */
private fun allowedActionIds(side: Int, type: Int, modelId: String?): List<Int> {
    if (modelId != "B172") return GESTURE_ACTIONS.map { it.id }
    if (side == PacketBuilder.SIDE_CASE) {
        return when (type) {
            1 -> listOf(9, 8, 2, 11, 17, 1)   // single press
            7 -> listOf(22, 11, 17, 1)         // press & hold
            2 -> listOf(3, 25, 1)              // double press (call)
            3 -> listOf(26, 1)                 // triple press (call)
            10 -> listOf(23, 1)                // rotate → volume control
            else -> listOf(1)
        }
    }
    return when (type) {
        0 -> listOf(18, 19, 11, 1)  // volume slide
        7 -> listOf(18, 19, 11, 1)  // press & hold → volume + assistant
        else -> listOf(9, 8, 11, 1) // double/triple/double-tap-hold
    }
}

/**
 * Per-side gesture customization. Each trigger slot on the left/right earbud and the charging case
 * maps to an operation from [GESTURE_ACTIONS]; picking one writes a `SET_KEY_CONFIGURATION` packet.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GestureScreen(
    state: EarbudsState,
    onBack: () -> Unit,
    onSetGesture: (Int, Int, Int) -> Unit,
) {
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
            SideCard("Left earbud", PacketBuilder.SIDE_LEFT, earbudSlots(state.deviceModel?.id), state, onSetGesture)
            SideCard("Right earbud", PacketBuilder.SIDE_RIGHT, earbudSlots(state.deviceModel?.id), state, onSetGesture)
            if (state.deviceModel?.hasSmartDial == true) {
                CaseCard(state, onSetGesture)
            }
            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SideCard(
    title: String,
    side: Int,
    slots: List<Pair<Int, String>>,
    state: EarbudsState,
    onSetGesture: (Int, Int, Int) -> Unit,
) {
    SectionCard(title, Icons.Default.TouchApp) {
        slots.forEachIndexed { index, (type, slotLabel) ->
            if (index > 0) Spacer(Modifier.height(4.dp))
            GestureSlotRow(side = side, type = type, slotLabel = slotLabel, state = state, onSetGesture = onSetGesture)
        }
    }
}

@Composable
private fun CaseCard(
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
        CASE_SLOTS.forEachIndexed { index, (type, slotLabel) ->
            if (index > 0) Spacer(Modifier.height(4.dp))
            GestureSlotRow(side = PacketBuilder.SIDE_CASE, type = type, slotLabel = slotLabel, state = state, onSetGesture = onSetGesture)
        }
    }
}

@Composable
private fun GestureSlotRow(
    side: Int,
    type: Int,
    slotLabel: String,
    state: EarbudsState,
    onSetGesture: (Int, Int, Int) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    val allowed = GESTURE_ACTIONS.filter { it.id in allowedActionIds(side, type, state.deviceModel?.id) }
    val current = state.gestures
        .find { it.side == side && it.type == type }
        ?.let { GESTURE_ACTIONS.find { action -> action.id == it.action } }
        ?: allowed.find { it.id == 1 } ?: allowed.first()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(slotLabel, style = MaterialTheme.typography.bodyLarge)
            Text(
                current.label,
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
                            if (action.id != current.id) {
                                onSetGesture(side, type, action.id)
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