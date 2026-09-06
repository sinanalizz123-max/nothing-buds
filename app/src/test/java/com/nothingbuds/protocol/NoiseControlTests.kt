package com.nothingbuds.protocol

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Noise Control values follow the official DeviceNoiseReduction ids
 * (re/NOISE_CONTROL/NOISE_CONTROL.md): the SET payload is [0x01, mode, 0x00].
 */
class NoiseControlTests {

    private fun commandId(frame: ByteArray): Int =
        ByteBuffer.wrap(frame, 3, 2).order(ByteOrder.LITTLE_ENDIAN).short.toInt() and 0xFFFF

    @Test
    fun `anc mode ids match official noise reduction modes`() {
        assertEquals(0x05, AncMode.OFF.value.toInt())
        assertEquals(0x01, AncMode.HIGH.value.toInt())
        assertEquals(0x02, AncMode.MID.value.toInt())
        assertEquals(0x03, AncMode.LOW.value.toInt())
        assertEquals(0x04, AncMode.ADAPTIVE.value.toInt())
        assertEquals(0x07, AncMode.TRANSPARENCY.value.toInt())
    }

    @Test
    fun `setAnc writes mode triplet`() {
        val frame = PacketBuilder.setAnc(AncMode.TRANSPARENCY)
        assertEquals(Commands.SET_ANC, commandId(frame))
        assertEquals(0x01, frame[frame.size - 5].toInt())
        assertEquals(0x07, frame[frame.size - 4].toInt())
        assertEquals(0x00, frame[frame.size - 3].toInt())
    }

    @Test
    fun `cycle order is ANC to transparency to off`() {
        assertEquals(AncMode.TRANSPARENCY, AncMode.cycle(AncMode.HIGH, true))
        assertEquals(AncMode.OFF, AncMode.cycle(AncMode.TRANSPARENCY, true))
        assertEquals(AncMode.HIGH, AncMode.cycle(AncMode.OFF, true))
        assertEquals(AncMode.OFF, AncMode.cycle(AncMode.HIGH, false))
        assertTrue(AncMode.HIGH.isAnc)
        assertFalse(AncMode.OFF.isAnc)
        assertFalse(AncMode.TRANSPARENCY.isAnc)
    }
}
