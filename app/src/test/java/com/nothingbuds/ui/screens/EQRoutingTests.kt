package com.nothingbuds.ui.screens

import com.nothingbuds.protocol.Commands
import com.nothingbuds.protocol.DiracEqPreset
import com.nothingbuds.protocol.EqPreset
import com.nothingbuds.protocol.PacketBuilder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Guards the Equalizer routing contract: on Dirac-capable models (B172/B168) only Dirac Opteo
 * goes through 0xF01D, the standard presets keep using 0xF010, and Custom keeps its own
 * advanced-EQ command (0xF06D). Regression guard for eed4bb3 which wrongly sent every preset
 * through 0xF01D.
 */
class EQRoutingTests {

    private fun commandId(frame: ByteArray): Int =
        ByteBuffer.wrap(frame, 3, 2).order(ByteOrder.LITTLE_ENDIAN).short.toInt() and 0xFFFF

    @Test
    fun `opteo row targets Dirac EQ command when LDAC is off`() {
        // The only row that may write 0xF01D. LDAC off => the tap is allowed.
        val target = eqRowTarget(isOpteoRow = true, lhdcActive = false)
        assertEquals(EqRowTarget.SET_DIRAC_EQ, target)

        val frame = PacketBuilder.setDiracEq(DiracEqPreset.OPTEO.type)
        assertEquals(Commands.SET_DIRAC_EQ, commandId(frame))
        assertEquals(DiracEqPreset.OPTEO.type, frame[frame.size - 4].toInt())
    }

    @Test
    fun `opteo row is blocked while LDAC is on`() {
        // Matches the official app: Dirac Opteo is unavailable while the LDAC codec is active.
        assertEquals(EqRowTarget.DIRAC_UNAVAILABLE, eqRowTarget(isOpteoRow = true, lhdcActive = true))
    }

    @Test
    fun `non-opteo rows never route to the Dirac command`() {
        // Standard EQ rows on a Dirac-capable model must not touch 0xF01D, regardless of codec.
        assertEquals(EqRowTarget.DO_NOTHING, eqRowTarget(isOpteoRow = false, lhdcActive = false))
        assertEquals(EqRowTarget.DO_NOTHING, eqRowTarget(isOpteoRow = false, lhdcActive = true))
    }

    @Test
    fun `standard presets write through SET_EQ`() {
        for (preset in EqPreset.entries) {
            if (preset == EqPreset.CUSTOM) continue
            val frame = PacketBuilder.setEq(preset)
            assertEquals("$preset must use 0xF010", Commands.SET_EQ, commandId(frame))
            assertEquals(preset.value.toInt(), frame[frame.size - 4].toInt())
            assertEquals(0, frame[frame.size - 3].toInt())
        }
    }

    @Test
    fun `custom curve writes through advanced EQ command`() {
        val frame = PacketBuilder.setCustomEq(IntArray(8))
        assertEquals(Commands.SET_ADVANCED_EQ_VALUES, commandId(frame))
    }

    @Test
    fun `dirac mode is active only for opteo over a balanced baseline`() {
        // Single mutually exclusive EQ choice: Dirac Opteo (level 0) or a standard preset.
        assertTrue(diracModeActive(diracEq = 0, eqPreset = EqPreset.BALANCED))

        assertFalse(diracModeActive(diracEq = 0, eqPreset = EqPreset.MORE_BASS))
        assertFalse(diracModeActive(diracEq = DiracEqPreset.ROCK.type, eqPreset = EqPreset.BALANCED))
        assertFalse(diracModeActive(diracEq = DiracEqPreset.CUSTOM.type, eqPreset = EqPreset.BALANCED))
        assertFalse(diracModeActive(diracEq = 0, eqPreset = EqPreset.CUSTOM))
    }
}