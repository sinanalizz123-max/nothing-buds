package com.nothingbuds.protocol

/**
 * CRC-16/MODBUS implementation for Nothing/CMF earbuds protocol.
 * Polynomial: 0xA001 (reversed 0x8005)
 * Initial value: 0xFFFF
 */
object CRC16 {

    private val TABLE: IntArray = IntArray(256) { i ->
        var crc = i
        repeat(8) {
            crc = if ((crc and 1) != 0) {
                (crc ushr 1) xor 0xA001
            } else {
                crc ushr 1
            }
        }
        crc
    }

    fun calculate(data: ByteArray): Int = calculate(data, 0, data.size)

    fun calculate(data: ByteArray, offset: Int, length: Int): Int {
        var crc = 0xFFFF
        val end = offset + length
        for (i in offset until end) {
            crc = (crc ushr 8) xor TABLE[(crc xor (data[i].toInt() and 0xFF)) and 0xFF]
        }
        return crc and 0xFFFF
    }

    fun toBytes(crc: Int): ByteArray {
        return byteArrayOf(
            (crc and 0xFF).toByte(),
            ((crc shr 8) and 0xFF).toByte()
        )
    }
}
