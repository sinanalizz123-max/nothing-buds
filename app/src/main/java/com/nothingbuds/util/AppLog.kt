package com.nothingbuds.util

/**
 * Central logging pipeline. Every layer (UI, service, protocol, receivers) logs
 * through here. Each entry is mirrored to logcat AND appended to a single
 * app-scoped, thread-safe, chronological ring buffer that the log exporter
 * reads directly — so the exported file always contains the same runtime
 * information regardless of logcat buffer eviction or tag filters.
 */
object AppLog {

    enum class Level { VERBOSE, DEBUG, INFO, WARN, ERROR }

    data class Entry(
        val seq: Long,
        val timeMs: Long,
        val level: Level,
        val tag: String,
        val message: String
    )

    const val MAX_ENTRIES = 4000

    private val lock = Any()
    private val buffer = ArrayDeque<Entry>(MAX_ENTRIES)
    private var seq = 0L

    @Volatile
    var minLevel: Level = Level.VERBOSE

    fun d(tag: String, message: String): Int = add(Level.DEBUG, tag, message)
    fun i(tag: String, message: String): Int = add(Level.INFO, tag, message)
    fun w(tag: String, message: String): Int = add(Level.WARN, tag, message)
    fun w(tag: String, message: String, tr: Throwable?): Int =
        add(Level.WARN, tag, "$message\n${android.util.Log.getStackTraceString(tr)}")
    fun e(tag: String, message: String): Int = add(Level.ERROR, tag, message)
    fun e(tag: String, message: String, tr: Throwable?): Int =
        add(Level.ERROR, tag, "$message\n${android.util.Log.getStackTraceString(tr)}")

    private fun add(level: Level, tag: String, message: String): Int {
        android.util.Log.println(levelToPriority(level), tag, message)
        if (level < minLevel) return 0
        synchronized(lock) {
            if (buffer.size >= MAX_ENTRIES) buffer.removeFirst()
            seq += 1
            buffer.addLast(Entry(seq, System.currentTimeMillis(), level, tag, message))
        }
        return 0
    }

    /** Chronological snapshot for export. Reads the live buffer; never stale. */
    fun snapshot(): List<String> = synchronized(lock) {
        buffer.map { e -> "${e.seq} ${formatTime(e.timeMs)} ${e.level.name[0]} ${e.tag}: ${e.message}" }
    }

    fun size(): Int = synchronized(lock) { buffer.size }

    fun clear() = synchronized(lock) {
        buffer.clear()
        seq = 0L
    }

    private fun levelToPriority(level: Level): Int = when (level) {
        Level.VERBOSE -> android.util.Log.VERBOSE
        Level.DEBUG -> android.util.Log.DEBUG
        Level.INFO -> android.util.Log.INFO
        Level.WARN -> android.util.Log.WARN
        Level.ERROR -> android.util.Log.ERROR
    }

    private fun formatTime(timeMs: Long): String {
        val totalSeconds = timeMs / 1000
        val ms = timeMs % 1000
        val s = totalSeconds % 60
        val m = (totalSeconds / 60) % 60
        val h = (totalSeconds / 3600) % 24
        return "%02d:%02d:%02d.%03d".format(h, m, s, ms)
    }
}
