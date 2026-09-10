package com.nothingbuds.protocol

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.concurrent.atomic.AtomicInteger

/**
 * Pins the exact outputs of the optimized protocol paths (Hex lookup tables,
 * table-driven CRC16, single-array PacketBuilder, Dirac helpers). Any behavioral
 * drift in the rewrites must fail loudly here.
 */
class OptimizationPinTests {

    // PacketBuilder.build uses a process-wide incrementing opId; reset it so
    // exact-frame assertions are deterministic.
    private fun resetOpId() {
        val f = PacketBuilder.javaClass.getDeclaredField("operationId")
        f.isAccessible = true
        (f.get(PacketBuilder) as AtomicInteger).set(0)
    }

    @Before
    fun resetOp() {
        resetOpId()
    }

    // ---- Hex codec ----------------------------------------------------------

    @Test
    fun `toHexLower empty is empty`() {
        assertEquals("", byteArrayOf().toHexLower())
    }

    @Test
    fun `toHexUpper empty is empty with and without separator`() {
        assertEquals("", byteArrayOf().toHexUpper())
        assertEquals("", byteArrayOf().toHexUpper(":"))
    }

    @Test
    fun `toHexLower single bytes match format`() {
        assertEquals("00", byteArrayOf(0x00).toHexLower())
        assertEquals("0f", byteArrayOf(0x0F).toHexLower())
        assertEquals("ab", byteArrayOf(0xAB.toByte()).toHexLower())
        assertEquals("ff", byteArrayOf(0xFF.toByte()).toHexLower())
    }

    @Test
    fun `toHexUpper single bytes match format`() {
        assertEquals("00", byteArrayOf(0x00).toHexUpper())
        assertEquals("0F", byteArrayOf(0x0F).toHexUpper())
        assertEquals("AB", byteArrayOf(0xAB.toByte()).toHexUpper())
        assertEquals("FF", byteArrayOf(0xFF.toByte()).toHexUpper())
    }

    @Test
    fun `hex multi-byte matches format output`() {
        val bytes = byteArrayOf(0x00, 0x0F, 0xAB.toByte(), 0xFF.toByte(), 0x12, 0x34)
        val expectedLower = bytes.joinToString("") { "%02x".format(it) }
        val expectedUpper = bytes.joinToString("") { "%02X".format(it) }
        assertEquals(expectedLower, bytes.toHexLower())
        assertEquals(expectedUpper, bytes.toHexUpper())
        assertEquals("00:0F:AB:FF:12:34", bytes.toHexUpper(":"))
        assertEquals("00-0F-AB-FF-12-34", bytes.toHexUpper("-"))
        // Single element with separator has no separator emitted.
        assertEquals("AB", byteArrayOf(0xAB.toByte()).toHexUpper(":"))
    }

    @Test
    fun `hex matches format for all 256 byte values`() {
        for (v in 0..255) {
            val b = byteArrayOf(v.toByte())
            assertEquals("%02x".format(v), b.toHexLower())
            assertEquals("%02X".format(v), b.toHexUpper())
        }
    }

    // ---- CRC16 --------------------------------------------------------------

    /** Bit-by-bit MODBUS reference (init 0xFFFF, poly 0xA001, no xor-out). */
    private fun crcBitwise(data: ByteArray, offset: Int = 0, length: Int = data.size - offset): Int {
        var crc = 0xFFFF
        for (i in offset until offset + length) {
            crc = crc xor (data[i].toInt() and 0xFF)
            repeat(8) {
                crc = if ((crc and 1) != 0) (crc ushr 1) xor 0xA001 else crc ushr 1
            }
        }
        return crc and 0xFFFF
    }

    @Test
    fun `crc16 modbus check vector`() {
        val data = "123456789".toByteArray(Charsets.US_ASCII)
        // CRC-16/MODBUS (init 0xFFFF) check value is 0x4B37. (0xBB3D is the
        // CRC-16/ARC value for the same input with init 0x0000.)
        assertEquals(0x4B37, CRC16.calculate(data))
        assertEquals(crcBitwise(data), CRC16.calculate(data))
    }

    @Test
    fun `crc16 empty equals init`() {
        assertEquals(0xFFFF, CRC16.calculate(byteArrayOf()))
        assertEquals(crcBitwise(byteArrayOf()), CRC16.calculate(byteArrayOf()))
    }

    @Test
    fun `crc16 single zero byte`() {
        assertEquals(0x40BF, CRC16.calculate(byteArrayOf(0x00)))
        assertEquals(crcBitwise(byteArrayOf(0x00)), CRC16.calculate(byteArrayOf(0x00)))
    }

    @Test
    fun `crc16 table agrees with bitwise reference on varied inputs`() {
        val vectors = listOf(
            byteArrayOf(0xFF.toByte()),
            byteArrayOf(0x01, 0x02, 0x03),
            byteArrayOf(0x55, 0x60, 0x01, 0x03, 0xF0.toByte(), 0x02, 0x00, 0x01, 0x01, 0x04),
            ByteArray(256) { it.toByte() },
            "2,2,1.0.0".toByteArray(Charsets.US_ASCII),
        )
        for (v in vectors) {
            assertEquals("mismatch for ${v.toHexLower()}", crcBitwise(v), CRC16.calculate(v))
        }
        // Offset/length overload agrees with the reference over a slice.
        val data = byteArrayOf(0x00, 0x11, 0x22, 0x33, 0x44)
        assertEquals(crcBitwise(data, 1, 3), CRC16.calculate(data, 1, 3))
    }

    @Test
    fun `crc16 toBytes is little-endian`() {
        assertArrayEquals(byteArrayOf(0x37, 0x4B.toByte()), CRC16.toBytes(0x4B37))
        assertArrayEquals(byteArrayOf(0xFF.toByte(), 0xFF.toByte()), CRC16.toBytes(0xFFFF))
    }

    // ---- PacketBuilder.build ------------------------------------------------

    @Test
    fun `build exact frame bytes for known command and payload`() {
        resetOpId() // next opId = 1
        val frame = PacketBuilder.build(0xF003, byteArrayOf(0x01, 0x04))
        // Hand-built expectation: header [55 60 01 | cmd LE 03 F0 | len LE 02 00 | op 01],
        // payload [01 04], CRC16-LE over the first 10 bytes = 0x3B05 -> [05 3B].
        val expected = byteArrayOf(
            0x55, 0x60, 0x01, 0x03, 0xF0.toByte(), 0x02, 0x00, 0x01,
            0x01, 0x04,
            0x05, 0x3B
        )
        assertArrayEquals(expected, frame)

        // Layout fields spelled out individually.
        assertEquals(0x55, frame[0].toInt() and 0xFF)
        assertEquals(0x60, frame[1].toInt() and 0xFF)
        assertEquals(0x01, frame[2].toInt() and 0xFF)
        val cmd = (frame[3].toInt() and 0xFF) or ((frame[4].toInt() and 0xFF) shl 8)
        assertEquals(0xF003, cmd)
        val len = (frame[5].toInt() and 0xFF) or ((frame[6].toInt() and 0xFF) shl 8)
        assertEquals(2, len)
        assertEquals(0x01, frame[7].toInt() and 0xFF) // opId after reset
        val crcLE = (frame[frame.size - 2].toInt() and 0xFF) or
            ((frame[frame.size - 1].toInt() and 0xFF) shl 8)
        assertEquals(crcBitwise(frame.copyOfRange(0, 10)), crcLE)
        assertEquals(CRC16.calculate(frame, 0, 10), crcLE)
    }

    @Test
    fun `build empty payload frame layout`() {
        resetOpId()
        val frame = PacketBuilder.build(0xC007)
        assertEquals(10, frame.size)
        assertEquals(0, (frame[5].toInt() and 0xFF) or ((frame[6].toInt() and 0xFF) shl 8))
        assertEquals(0x01, frame[7].toInt() and 0xFF)
        val crcLE = (frame[8].toInt() and 0xFF) or ((frame[9].toInt() and 0xFF) shl 8)
        assertEquals(CRC16.calculate(frame, 0, 8), crcLE)
    }

    @Test
    fun `buildFromHex matches build with decoded payload`() {
        resetOpId()
        val fromHex = PacketBuilder.buildFromHex(0xF003, "0104")
        resetOpId()
        val direct = PacketBuilder.build(0xF003, byteArrayOf(0x01, 0x04))
        assertArrayEquals(direct, fromHex)
        resetOpId()
        val emptyHex = PacketBuilder.buildFromHex(0xC007, "")
        resetOpId()
        val emptyDirect = PacketBuilder.build(0xC007)
        assertArrayEquals(emptyDirect, emptyHex)
    }

    // ---- setDiracCustomEq ---------------------------------------------------

    private fun payloadOf(frame: ByteArray): ByteArray =
        frame.copyOfRange(8, frame.size - 2)

    private fun assertFloatLe(payload: ByteArray, offset: Int, value: Float) {
        val bits = java.lang.Float.floatToRawIntBits(value)
        val actual = ByteBuffer.wrap(payload, offset, 4).order(ByteOrder.LITTLE_ENDIAN).int
        assertEquals("float $value at offset $offset", bits, actual)
    }

    @Test
    fun `setDiracCustomEq exact 53-byte payload for bass2 mid-1 treble0`() {
        val frame = PacketBuilder.setDiracCustomEq(bass = 2, mid = -1, treble = 0)
        val payload = payloadOf(frame)
        assertEquals(PacketBuilder.DIRAC_CUSTOM_PACKET_SIZE, payload.size)
        assertEquals(53, payload.size)
        // Command on the wire is SET_CUSTOM_EQ (0xF041).
        val cmd = (frame[3].toInt() and 0xFF) or ((frame[4].toInt() and 0xFF) shl 8)
        assertEquals(Commands.SET_CUSTOM_EQ, cmd)
        assertEquals(8 + 53 + 2, frame.size)

        // [count=3][totalGain=-max(2,-1,0)=-2.0 LE]
        assertEquals(3, payload[0].toInt())
        assertFloatLe(payload, 1, -2.0f)
        assertEquals(
            java.lang.Float.floatToRawIntBits(-2.0f),
            java.lang.Float.floatToRawIntBits(-(maxOf(2, -1, 0).toFloat()))
        )

        // Bands in radar order Mid, Treble, Bass: [filterType, gain, freq, Q].
        var o = 5
        // Mid: peak, -1 dB, 980 Hz, Q 0.66
        assertEquals(1, payload[o].toInt())
        assertFloatLe(payload, o + 1, -1.0f)
        assertFloatLe(payload, o + 5, 980f)
        assertFloatLe(payload, o + 9, 0.66f)
        o += 13
        // Treble: high shelf, 0 dB, 3500 Hz, Q 1.0
        assertEquals(2, payload[o].toInt())
        assertFloatLe(payload, o + 1, 0.0f)
        assertFloatLe(payload, o + 5, 3500f)
        assertFloatLe(payload, o + 9, 1.0f)
        o += 13
        // Bass: low shelf, 2 dB, 140 Hz, Q 0.8
        assertEquals(0, payload[o].toInt())
        assertFloatLe(payload, o + 1, 2.0f)
        assertFloatLe(payload, o + 5, 140f)
        assertFloatLe(payload, o + 9, 0.8f)
        o += 13

        // Trailing-zero padding to 53 bytes (5 + 16*3 = 44, so 9 zeros).
        assertEquals(44, o)
        for (i in o until 53) assertEquals("padding byte $i", 0, payload[i].toInt())
    }

    @Test
    fun `setDiracCustomEq clamps to minus6 to plus6`() {
        val frame = PacketBuilder.setDiracCustomEq(bass = 10, mid = -10, treble = 0)
        val payload = payloadOf(frame)
        // Clamped to (6, -6, 0); totalGain = -6.0.
        assertFloatLe(payload, 1, -6.0f)
        assertFloatLe(payload, 5 + 1, -6.0f) // Mid gain
        assertFloatLe(payload, 18 + 1, 0.0f) // Treble gain
        assertFloatLe(payload, 31 + 1, 6.0f) // Bass gain
    }

    // ---- setCustomEq --------------------------------------------------------

    @Test
    fun `setCustomEq maps minus6 to plus6 with offset 6`() {
        val frame = PacketBuilder.setCustomEq(intArrayOf(-6, -5, 0, 5, 6))
        val payload = payloadOf(frame)
        assertArrayEquals(byteArrayOf(0, 1, 6, 11, 12), payload)
    }

    @Test
    fun `setCustomEq clamps at boundaries`() {
        val frame = PacketBuilder.setCustomEq(intArrayOf(-7, 7, -100, 100, 0))
        val payload = payloadOf(frame)
        assertArrayEquals(byteArrayOf(0, 12, 0, 12, 6), payload)
    }

    // ---- DiracEqPreset.fromLevel --------------------------------------------

    @Test
    fun `dirac fromLevel maps every level`() {
        assertEquals(DiracEqPreset.OPTEO, DiracEqPreset.fromLevel(0))
        assertEquals(DiracEqPreset.ROCK, DiracEqPreset.fromLevel(1))
        assertEquals(DiracEqPreset.ELECTRONIC, DiracEqPreset.fromLevel(2))
        assertEquals(DiracEqPreset.POP, DiracEqPreset.fromLevel(3))
        assertEquals(DiracEqPreset.ENHANCE_VOCALS, DiracEqPreset.fromLevel(4))
        assertEquals(DiracEqPreset.CLASSICAL, DiracEqPreset.fromLevel(5))
        assertEquals(DiracEqPreset.CUSTOM, DiracEqPreset.fromLevel(6))
    }

    @Test
    fun `dirac fromLevel out-of-range falls back to OPTEO`() {
        assertEquals(DiracEqPreset.OPTEO, DiracEqPreset.fromLevel(-1))
        assertEquals(DiracEqPreset.OPTEO, DiracEqPreset.fromLevel(7))
        assertEquals(DiracEqPreset.OPTEO, DiracEqPreset.fromLevel(100))
        assertEquals(DiracEqPreset.OPTEO, DiracEqPreset.fromLevel(-100))
    }

    // ---- parseAsciiString ---------------------------------------------------

    @Test
    fun `parseAsciiString stops at embedded NUL ignoring trailing bytes`() {
        val payload = byteArrayOf(0x41, 0x42, 0x00, 0x43, 0x44, 0x45) // "AB\0CDE"
        assertEquals("AB", ResponseParser.parseAsciiString(payload))
    }

    @Test
    fun `parseAsciiString strips trailing NUL padding`() {
        assertEquals("hi", ResponseParser.parseAsciiString(byteArrayOf(0x68, 0x69, 0x00, 0x00, 0x00)))
        assertEquals("2,2,1.0.0", ResponseParser.parseAsciiString("2,2,1.0.0\u0000\u0000".toByteArray(Charsets.US_ASCII)))
    }

    @Test
    fun `parseAsciiString edge cases`() {
        assertEquals("", ResponseParser.parseAsciiString(byteArrayOf()))
        assertEquals("", ResponseParser.parseAsciiString(byteArrayOf(0x00, 0x00)))
        assertEquals("abc", ResponseParser.parseAsciiString("abc".toByteArray(Charsets.US_ASCII)))
    }
}
