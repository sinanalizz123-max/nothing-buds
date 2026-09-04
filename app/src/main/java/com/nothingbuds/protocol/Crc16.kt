package com.nothingbuds.protocol

object Crc16 {
    private const val POLYNOMIAL = 0xA001
    private const val INITIAL = 0xFFFF

    fun compute(data: ByteArray): Int {
        var crc = INITIAL
        for (b in data) {
            crc = crc xor (b.toInt() and 0xFF)
            for (j in 0 until 8) {
                crc = if ((crc and 1) != 0) (crc shr 1) xor POLYNOMIAL
                else crc shr 1
            }
        }
        return crc and 0xFFFF
    }
}
