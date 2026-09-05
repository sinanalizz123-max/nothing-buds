package com.nothingbuds.protocol

/**
 * CRC-16/MODBUS implementation for Nothing/CMF earbuds protocol.
 * Polynomial: 0xA001 (reversed 0x8005)
 * Initial value: 0xFFFF
 */
object CRC16 {

    fun calculate(data: ByteArray): Int {
        var crc = 0xFFFF

        for (byte in data) {
            crc = crc xor (byte.toInt() and 0xFF)
            for (j in 0 until 8) {
                crc = if ((crc and 1) != 0) {
                    (crc shr 1) xor 0xA001
                } else {
                    crc shr 1
                }
            }
        }

        return crc
    }

    fun toBytes(crc: Int): ByteArray {
        return byteArrayOf(
            (crc and 0xFF).toByte(),
            ((crc shr 8) and 0xFF).toByte()
        )
    }
}
