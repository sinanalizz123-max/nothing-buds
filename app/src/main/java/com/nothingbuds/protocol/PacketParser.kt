package com.nothingbuds.protocol

import java.nio.ByteBuffer
import java.nio.ByteOrder

data class ParsedPacket(
    val command: Int,
    val payload: ByteArray,
    val fsn: Int,
    val hasCrc: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ParsedPacket
        if (command != other.command) return false
        if (!payload.contentEquals(other.payload)) return false
        if (fsn != other.fsn) return false
        if (hasCrc != other.hasCrc) return false
        return true
    }

    override fun hashCode(): Int {
        var result = command
        result = 31 * result + payload.contentHashCode()
        result = 31 * result + fsn
        result = 31 * result + hasCrc.hashCode()
        return result
    }
}

object PacketParser {
    fun parse(data: ByteArray): ParsedPacket? {
        if (data.size < 8 || data[0] != 0x55.toByte()) return null
        val buf = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN)
        buf.get()
        val control = buf.short.toInt() and 0xFFFF
        val command = buf.short.toInt() and 0xFFFF
        val length = buf.short.toInt() and 0xFFFF
        val hasCrc = (control and 0x20) != 0
        val expectedSize = 8 + length + if (hasCrc) 2 else 0
        if (data.size < expectedSize) return null
        val fsn = buf.get().toInt() and 0xFF
        val payload = ByteArray(length)
        buf.get(payload)
        if (hasCrc) {
            val crcReceived = buf.short.toInt() and 0xFFFF
            val crcData = ByteArray(8 + length)
            ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).get(crcData)
            val crcComputed = Crc16.compute(crcData)
            if (crcReceived != crcComputed) return null
        }
        return ParsedPacket(command, payload, fsn, hasCrc)
    }
}
