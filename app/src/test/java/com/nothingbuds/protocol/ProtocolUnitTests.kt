package com.nothingbuds.protocol

import com.nothingbuds.data.DeviceModels
import com.nothingbuds.service.isValidRawFrame
import com.nothingbuds.service.parseHexOrNull
import com.nothingbuds.protocol.PacketBuilder
import com.nothingbuds.protocol.ResponseParser
import org.junit.Assert.*
import org.junit.Test
import java.nio.ByteBuffer
import java.nio.ByteOrder

class ProtocolUnitTests {

    @Test
    fun testParseHexOrNull_validHex() {
        assertArrayEquals(byteArrayOf(0x12, 0x34, 0x56), "123456".parseHexOrNull())
        assertArrayEquals(byteArrayOf(), "".parseHexOrNull())
        assertArrayEquals(byteArrayOf(0x0a), "0a".parseHexOrNull())
    }

    @Test
    fun testParseHexOrNull_invalidHex() {
        assertNull("12345G".parseHexOrNull()) // Invalid char
        assertNull("12345".parseHexOrNull()) // Odd length
        assertNull("0x12".parseHexOrNull()) // Prefix
    }

    @Test
    fun testIsValidRawFrame_validFrame() {
        // Valid frame: SOF, header, lenLE=0x0005, fsn, payload(5 bytes), CRC(2 bytes)
        // [0x55, 0x60, 0x01, 0x03, 0xF0, 0x05, 0x00, 0x0F, 0x01, 0x04, 0x0F, 0x28, 0x00, 0x58, 0x6C]
        // This is a minimal valid frame (arbitrary payload matching documented worked frame)
        // Actual CRC of [55 60 01 03 F0 05 00 0F 01 04 0F 28 00] is 0xECDC, so 58 6C is bad CRC
        // However, isValidRawFrame only checks length consistency, not CRC value.
        // It should match the total length.
        val validPayload = byteArrayOf(0x01, 0x04, 0x0F, 0x28, 0x00) // 5 bytes
        val command = 0xF003
        val crc = 0x6C58 // placeholder, not actual CRC
        val frame = PacketBuilder.build(command, validPayload) // PacketBuilder makes its own CRC
        
        // PacketBuilder makes [55 60 01 03 F0 05 00 <opId> <payload> <crcL> <crcH>]
        // Let's manually construct a compliant frame for testing isValidRawFrame() based on spec
        // Payload length = 5 (0x05 0x00)
        val expectedFrameBytes = ByteBuffer.allocate(8 + 5 + 2)
            .order(ByteOrder.LITTLE_ENDIAN)
            .put(0, 0x55.toByte())
            .put(1, 0x60.toByte()).put(2, 0x01.toByte()) // control LE 0x0160
            .put(3, 0x03.toByte()).put(4, 0xF0.toByte()) // command LE 0xF003
            .put(5, 0x05.toByte()).put(6, 0x00.toByte()) // length LE 0x0005
            .put(7, 0x0F.toByte()) // fsn
            .put(8, 0x01.toByte()).put(9, 0x04.toByte()).put(10, 0x0F.toByte())
            .put(11, 0x28.toByte()).put(12, 0x00.toByte()) // payload (5 bytes)
            .put(13, 0x58.toByte()).put(14, 0x6C.toByte()) // CRC LE 0x6C58
            .array()

        assertTrue("Expected isValidRawFrame to return true for a valid frame", isValidRawFrame(expectedFrameBytes))

    }
    
    @Test
    fun testIsValidRawFrame_malformedFrame() {
        assertFalse("Empty frame", isValidRawFrame(byteArrayOf()))
        assertFalse("Bad SOF", isValidRawFrame(byteArrayOf(0x00, 0x60, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00)))
        assertFalse("Too short", isValidRawFrame(byteArrayOf(0x55, 0x60, 0x01, 0x00, 0x00, 0x00, 0x00))) // < 8 bytes
        
        // Mismatched length (payload length 5 declared, but only 4 bytes payload)
        val malformedFrame = ByteBuffer.allocate(8 + 4 + 2) // header + 4 payload + CRC
            .order(ByteOrder.LITTLE_ENDIAN)
            .put(0, 0x55.toByte())
            .put(1, 0x60.toByte()).put(2, 0x01.toByte()) // control LE 0x0160
            .put(3, 0x03.toByte()).put(4, 0xF0.toByte()) // command LE 0xF003
            .put(5, 0x05.toByte()).put(6, 0x00.toByte()) // length LE 0x0005 (declares 5 bytes payload)
            .put(7, 0x0F.toByte()) // fsn
            .put(8, 0x01.toByte()).put(9, 0x04.toByte()).put(10, 0x0F.toByte())
            .put(11, 0x28.toByte()) // payload (only 4 bytes)
            .put(12, 0x58.toByte()).put(13, 0x6C.toByte()) // CRC LE 0x6C58
            .array()
        assertFalse("Length mismatch", isValidRawFrame(malformedFrame))
    }

    @Test
    fun testFindByName_exactMatch() {
        assertEquals(DeviceModels.NOTHING_EAR_2, DeviceModels.findByName("Nothing Ear (2)"))
        assertEquals(DeviceModels.CMF_BUDS_2_PLUS, DeviceModels.findByName("CMF Buds 2 Plus"))
    }

    @Test
    fun testFindByName_longestSubstringMatch() {
        // "Nothing Ear (a) (LE)" contains "Nothing Ear (a)" (length 17) and "Nothing Ear" (length 11)
        // Should pick "Nothing Ear (a)"
        assertEquals(DeviceModels.NOTHING_EAR_A, DeviceModels.findByName("Nothing Ear (a) (LE)"))
        
        // "CMF Buds 2a (LE)" contains "CMF Buds 2a" (length 11) and "CMF Buds 2" (length 10)
        // Should pick "CMF Buds 2a"
        assertEquals(DeviceModels.CMF_BUDS_2A, DeviceModels.findByName("CMF Buds 2a (LE)"))

        // "CMF Buds 2 Plus (LE)" contains "CMF Buds 2 Plus"
        assertEquals(DeviceModels.CMF_BUDS_2_PLUS, DeviceModels.findByName("CMF Buds 2 Plus (LE)"))
    }
    
    @Test
    fun testFindByName_noMatch() {
        assertNull(DeviceModels.findByName("Unknown Device"))
        assertNull(DeviceModels.findByName("Other Headphones"))
    }

    @Test
    fun testParse_validPacket_noCrc() {
        // Test a valid packet where the control bit5 (CRC present) is NOT set, and no trailing CRC.
        // Command 0xF003, payload 1 byte (0x01)
        val frame = ByteBuffer.allocate(8 + 1) // header + 1 payload
            .order(ByteOrder.LITTLE_ENDIAN)
            .put(0, 0x55.toByte())
            .put(1, 0x40.toByte()).put(2, 0x01.toByte()) // control LE 0x0140 (CRC bit5 NOT set)
            .put(3, 0x03.toByte()).put(4, 0xF0.toByte()) // command LE 0xF003
            .put(5, 0x01.toByte()).put(6, 0x00.toByte()) // length LE 0x0001
            .put(7, 0x0A.toByte()) // fsn
            .put(8, 0x01.toByte()) // payload (1 byte)
            .array()
        
        val parsed = ResponseParser.parse(frame)
        assertNotNull(parsed)
        assertEquals(0xF003, parsed?.command)
        assertArrayEquals(byteArrayOf(0x01), parsed?.payload)
    }

    @Test
    fun testParse_validPacket_withCrc_matching() {
        // Test a valid packet where CRC is present and matches.
        // Command 0xC018, payload 0 bytes. Correct CRC for header (8 bytes) + 0 payload.
        val headerNoCrc = ByteBuffer.allocate(8)
            .order(ByteOrder.LITTLE_ENDIAN)
            .put(0, 0x55.toByte())
            .put(1, 0x60.toByte()).put(2, 0x01.toByte()) // control LE 0x0160 (CRC bit5 IS set)
            .put(3, 0x18.toByte()).put(4, 0xC0.toByte()) // command LE 0xC018
            .put(5, 0x00.toByte()).put(6, 0x00.toByte()) // length LE 0x0000
            .put(7, 0x0F.toByte()) // fsn
            .array()
        val expectedCrc = CRC16.calculate(headerNoCrc)
        
        val frame = ByteBuffer.allocate(8 + 0 + 2)
            .order(ByteOrder.LITTLE_ENDIAN)
            .put(headerNoCrc)
            .put(CRC16.toBytes(expectedCrc))
            .array()
        
        val parsed = ResponseParser.parse(frame)
        assertNotNull(parsed)
        assertEquals(0xC018, parsed?.command)
        assertArrayEquals(byteArrayOf(), parsed?.payload)
    }

    @Test
    fun testParse_validPacket_withCrc_mismatch() {
        // Valid packet with CRC present, but CRC is invalid. Should return null.
        val headerNoCrc = ByteBuffer.allocate(8)
            .order(ByteOrder.LITTLE_ENDIAN)
            .put(0, 0x55.toByte())
            .put(1, 0x60.toByte()).put(2, 0x01.toByte()) // control LE 0x0160 (CRC bit5 IS set)
            .put(3, 0x18.toByte()).put(4, 0xC0.toByte()) // command LE 0xC018
            .put(5, 0x00.toByte()).put(6, 0x00.toByte()) // length LE 0x0000
            .put(7, 0x0F.toByte()) // fsn
            .array()
        val badCrcBytes = byteArrayOf(0x00, 0x00) // Intentionally bad CRC
        
        val frame = ByteBuffer.allocate(8 + 0 + 2)
            .order(ByteOrder.LITTLE_ENDIAN)
            .put(headerNoCrc)
            .put(badCrcBytes)
            .array()
        
        assertNull("CRC mismatch should return null", ResponseParser.parse(frame))
    }

    @Test
    fun testParse_truncatedPacket() {
        // Header only, expects 1 byte payload + CRC (total 11 bytes minimum for a packet)
        // Our parser requires totalLength (HEADER + PAYLOAD + (CRC?2:0))
        val frame = ByteBuffer.allocate(8) // Just header
            .order(ByteOrder.LITTLE_ENDIAN)
            .put(0, 0x55.toByte())
            .put(1, 0x60.toByte()).put(2, 0x01.toByte()) // control LE 0x0160 (CRC bit5 IS set)
            .put(3, 0x03.toByte()).put(4, 0xF0.toByte()) // command LE 0xF003
            .put(5, 0x01.toByte()).put(6, 0x00.toByte()) // length LE 0x0001 (payload 1 byte)
            .put(7, 0x0F.toByte()) // fsn
            .array()
        assertNull("Truncated packet should return null", ResponseParser.parse(frame))
    }

    @Test
    fun testParseGestures_valid() {
        // [count, (side, common, type, action) x count]
        // Example: 1 slot (left double tap play/pause)
        val payload = byteArrayOf(
            0x01, // count = 1
            0x02, 0x00, 0x02, 0x02 // Left, common=0, Double tap, Play/Pause
        )
        val gestures = ResponseParser.parseGestures(payload)
        assertEquals(1, gestures.size)
        assertEquals(2, gestures[0].side)
        assertEquals(2, gestures[0].type)
        assertEquals(2, gestures[0].action)
    }

    @Test
    fun testParseGestures_truncated() {
        // count = 1, but only 3 bytes of slot data
        val payload = byteArrayOf(0x01, 0x02, 0x00, 0x02)
        assertTrue("Truncated gestures should return emptyList", ResponseParser.parseGestures(payload).isEmpty())
    }
    
    @Test
    fun testParseCaseLed_valid() {
        // [count, (type, R, G, B) x count]
        // Example: 1 slot (type 0x01, red LED)
        val payload = byteArrayOf(
            0x01, // count = 1
            0x01, 0xFF.toByte(), 0x00, 0x00 // type=0x01, R=FF, G=0, B=0
        )
        val colors = ResponseParser.parseCaseLed(payload)
        assertEquals(1, colors.size)
        assertEquals(0xFFFF0000.toInt(), colors[0])
    }

    @Test
    fun testParseCaseLed_truncated() {
        // count = 1, but only 3 bytes of slot data
        val payload = byteArrayOf(0x01, 0x01, 0xFF.toByte(), 0x00)
        assertTrue("Truncated case LED should return emptyList", ResponseParser.parseCaseLed(payload).isEmpty())
    }

    @Test
    fun testParseDualDeviceList_valid() {
        // [count, (MAC x6, flags) x count]
        // Example: 1 device
        val mac = byteArrayOf(0x11, 0x22, 0x33, 0x44, 0x55, 0x66)
        val payload = byteArrayOf(
            0x01, // count = 1
            mac[0], mac[1], mac[2], mac[3], mac[4], mac[5], // MAC (6 bytes)
            0x01 // flags = 1
        )
        val devices = ResponseParser.parseDualDeviceList(payload)
        assertEquals(1, devices.size)
        assertEquals("11:22:33:44:55:66", devices[0].mac)
        assertEquals(1, devices[0].flags)
    }
    
    @Test
    fun testParseDualDeviceList_truncated() {
        // count = 1, but only 6 bytes of slot data
        val mac = byteArrayOf(0x11, 0x22, 0x33, 0x44, 0x55, 0x66)
        val payload = byteArrayOf(
            0x01, // count = 1
            mac[0], mac[1], mac[2], mac[3], mac[4], mac[5] // MAC (6 bytes, missing flags)
        )
        assertTrue("Truncated dual device list should return emptyList", ResponseParser.parseDualDeviceList(payload).isEmpty())
    }
}


