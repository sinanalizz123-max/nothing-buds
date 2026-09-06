package com.nothingbuds.ui.screens

import com.nothingbuds.protocol.Commands
import com.nothingbuds.protocol.DiracEqPreset
import com.nothingbuds.protocol.EqPreset
import com.nothingbuds.protocol.PacketBuilder
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Guards the Equalizer routing contract: on Dirac-capable models (B172/B168) the EQ
 * screen is ONE preset list (Dirac first) and every row writes 0xF01D; the Dirac
 * Custom curve writes 0xF041. Non-Dirac models keep the standard 0xF010 path and
 * the existing 8-band custom path untouched.
 */
class EQRoutingTests {

    private fun commandId(frame: ByteArray): Int =
        ByteBuffer.wrap(frame, 3, 2).order(ByteOrder.LITTLE_ENDIAN).short.toInt() and 0xFFFF

    private fun floatAt(frame: ByteArray, offset: Int): Float =
        ByteBuffer.wrap(frame, offset, 4).order(ByteOrder.LITTLE_ENDIAN).float

    @Test
    fun `dirac list order is Dirac first`() {
        assertEquals(
            listOf(
                DiracEqPreset.OPTEO,
                DiracEqPreset.POP,
                DiracEqPreset.ROCK,
                DiracEqPreset.CLASSICAL,
                DiracEqPreset.ELECTRONIC,
                DiracEqPreset.ENHANCE_VOCALS,
                DiracEqPreset.CUSTOM
            ),
            diracRowOrder
        )
        assertEquals(listOf(0, 3, 1, 5, 2, 4, 6), diracRowOrder.map { it.type })
    }

    @Test
    fun `every dirac row writes F01D with type payload`() {
        for (preset in diracRowOrder) {
            val frame = PacketBuilder.setDiracEq(preset.type)
            assertEquals("$preset must use 0xF01D", Commands.SET_DIRAC_EQ, commandId(frame))
            assertEquals(preset.type, frame[frame.size - 4].toInt())
            assertEquals(0, frame[frame.size - 3].toInt())
        }
    }

    @Test
    fun `dirac level maps back to the selected row`() {
        assertEquals(DiracEqPreset.OPTEO, DiracEqPreset.fromLevel(0))
        assertEquals(DiracEqPreset.ROCK, DiracEqPreset.fromLevel(1))
        assertEquals(DiracEqPreset.ELECTRONIC, DiracEqPreset.fromLevel(2))
        assertEquals(DiracEqPreset.POP, DiracEqPreset.fromLevel(3))
        assertEquals(DiracEqPreset.ENHANCE_VOCALS, DiracEqPreset.fromLevel(4))
        assertEquals(DiracEqPreset.CLASSICAL, DiracEqPreset.fromLevel(5))
        assertEquals(DiracEqPreset.CUSTOM, DiracEqPreset.fromLevel(6))
        assertEquals(DiracEqPreset.OPTEO, DiracEqPreset.fromLevel(99))
    }

    @Test
    fun `standard presets still write through SET_EQ`() {
        for (preset in EqPreset.entries) {
            if (preset == EqPreset.CUSTOM) continue
            val frame = PacketBuilder.setEq(preset)
            assertEquals("$preset must use 0xF010", Commands.SET_EQ, commandId(frame))
            assertEquals(preset.value.toInt(), frame[frame.size - 4].toInt())
            assertEquals(0, frame[frame.size - 3].toInt())
        }
    }

    @Test
    fun `existing 8-band custom path is untouched`() {
        val frame = PacketBuilder.setCustomEq(IntArray(8))
        assertEquals(Commands.SET_ADVANCED_EQ_VALUES, commandId(frame))
    }

    @Test
    fun `dirac custom curve writes F041 CustomEQ struct`() {
        // Bass +2, Mid 0, Treble -1 => totalGain -2.0; bands in radar order Mid, Treble, Bass.
        val frame = PacketBuilder.setDiracCustomEq(bass = 2, mid = 0, treble = -1)
        assertEquals(Commands.SET_CUSTOM_EQ, commandId(frame))
        assertEquals(8 + 53 + 2, frame.size)

        assertEquals(3, frame[8].toInt()) // count
        assertEquals(-2.0f, floatAt(frame, 9), 0.0f) // totalGain

        assertEquals(1, frame[13].toInt()) // Mid first
        assertEquals(0.0f, floatAt(frame, 14), 0.0f)
        assertEquals(980.0f, floatAt(frame, 18), 0.0f)
        assertEquals(0.66f, floatAt(frame, 22), 0.001f)

        assertEquals(2, frame[26].toInt()) // Treble
        assertEquals(-1.0f, floatAt(frame, 27), 0.0f)

        assertEquals(0, frame[39].toInt()) // Bass
        assertEquals(2.0f, floatAt(frame, 40), 0.0f)

        assertArrayEquals(ByteArray(9), frame.copyOfRange(52, 61)) // trailing-zero padding
    }

    @Test
    fun `dirac custom gains clamp to minus6 to plus6`() {
        val frame = PacketBuilder.setDiracCustomEq(bass = 9, mid = -9, treble = 0)
        assertEquals(-6.0f, floatAt(frame, 9), 0.0f) // totalGain = -max = -6
        assertEquals(-6.0f, floatAt(frame, 14), 0.0f) // Mid gain clamped
        assertEquals(6.0f, floatAt(frame, 40), 0.0f) // Bass gain clamped
    }
}
