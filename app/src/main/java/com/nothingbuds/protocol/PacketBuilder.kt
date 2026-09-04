package com.nothingbuds.protocol

import java.nio.ByteBuffer
import java.nio.ByteOrder

object PacketBuilder {
    private const val SOF = 0x55.toByte()
    // ear-web (working SPP impl) sends literal control bytes 0x60 0x01 (LE word 0x0160).
    private const val CONTROL_SPP = 0x0160
    private const val CRC_FLAG = 0x20
    private var fsn = 0

    @Synchronized
    fun nextFsn(): Int {
        fsn++
        if (fsn >= 254) fsn = 0
        return fsn
    }

    fun build(command: Int, payload: ByteArray, withCrc: Boolean = true): ByteArray {
        val length = payload.size
        val totalLen = 8 + length + if (withCrc) 2 else 0
        val fsn = nextFsn()

        var control = CONTROL_SPP
        if (withCrc) control = control or CRC_FLAG

        val buffer = ByteBuffer.allocate(totalLen).order(ByteOrder.LITTLE_ENDIAN)
        buffer.put(SOF)
        buffer.putShort(control.toShort())
        buffer.putShort(command.toShort())
        buffer.putShort(length.toShort())
        buffer.put(fsn.toByte())
        buffer.put(payload)

        if (withCrc) {
            val crcData = ByteArray(8 + length)
            buffer.rewind()
            buffer.get(crcData)
            val crc = Crc16.compute(crcData)
            buffer.put((crc and 0xFF).toByte())
            buffer.put(((crc shr 8) and 0xFF).toByte())
        }

        return buffer.array()
    }
}
