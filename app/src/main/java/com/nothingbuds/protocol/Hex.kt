package com.nothingbuds.protocol

/**
 * Allocation-conscious hex codec backed by lookup tables.
 * [toHexLower] matches `BudsService.toHexString` output exactly.
 */
private val HEX_LOWER: CharArray = "0123456789abcdef".toCharArray()
private val HEX_UPPER: CharArray = "0123456789ABCDEF".toCharArray()

internal fun ByteArray.toHexLower(): String {
    if (isEmpty()) return ""
    val out = CharArray(size * 2)
    for (i in indices) {
        val v = this[i].toInt() and 0xFF
        out[i * 2] = HEX_LOWER[v ushr 4]
        out[i * 2 + 1] = HEX_LOWER[v and 0x0F]
    }
    return String(out)
}

internal fun ByteArray.toHexUpper(separator: String = ""): String {
    if (isEmpty()) return ""
    if (separator.isEmpty()) {
        val out = CharArray(size * 2)
        for (i in indices) {
            val v = this[i].toInt() and 0xFF
            out[i * 2] = HEX_UPPER[v ushr 4]
            out[i * 2 + 1] = HEX_UPPER[v and 0x0F]
        }
        return String(out)
    }
    val sb = StringBuilder(size * 2 + separator.length * (size - 1))
    for (i in indices) {
        if (i > 0) sb.append(separator)
        val v = this[i].toInt() and 0xFF
        sb.append(HEX_UPPER[v ushr 4])
        sb.append(HEX_UPPER[v and 0x0F])
    }
    return sb.toString()
}
