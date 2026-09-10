package com.nothingbuds.util

import java.io.File

/**
 * Central logging pipeline. Every layer logs through here; each entry is mirrored
 * to logcat AND appended to a single app-scoped log file, so the exported file
 * always contains the complete runtime trace — including fatal crashes, which a
 * logcat-only export would mangle or lose with the dying process.
 *
 * Thread-safe and chronological (synchronous appends under one lock). The file
 * rotates at [MAX_FILE_BYTES], keeping one backup generation.
 */
object AppLog {

    enum class Level { VERBOSE, DEBUG, INFO, WARN, ERROR }

    const val MAX_FILE_BYTES = 256 * 1024L
    private const val LOG_FILE = "applog.txt"
    private const val BACKUP_FILE = "applog.1.txt"

    private val lock = Any()
    private var seq = 0L

    @Volatile
    private var logDir: File? = null

    @Volatile
    var minLevel: Level = Level.VERBOSE

    /**
     * Master switch for file capture, driven by the Settings "Log catching"
     * toggle (off by default). Logcat mirroring always stays on; only the
     * persistent file (and crash-file writes) are gated.
     */
    @Volatile
    var enabled: Boolean = false

    const val PREF_ENABLED = "log_catching"
    const val PREF_UNLOCKED = "log_catching_unlocked"

    fun init(filesDir: File) {
        synchronized(lock) {
            logDir = File(filesDir, "logs").apply { mkdirs() }
        }
    }

    fun d(tag: String, message: String): Int = add(Level.DEBUG, tag, message)
    fun i(tag: String, message: String): Int = add(Level.INFO, tag, message)
    fun w(tag: String, message: String): Int = add(Level.WARN, tag, message)
    fun w(tag: String, message: String, tr: Throwable?): Int =
        add(Level.WARN, tag, "$message\n${tr?.stackTraceToString()}")
    fun e(tag: String, message: String): Int = add(Level.ERROR, tag, message)
    fun e(tag: String, message: String, tr: Throwable?): Int =
        add(Level.ERROR, tag, "$message\n${tr?.stackTraceToString()}")

    private fun add(level: Level, tag: String, message: String): Int {
        android.util.Log.println(levelToPriority(level), tag, message)
        if (level < minLevel || !enabled) return 0
        synchronized(lock) {
            seq += 1
            val line = "$seq ${formatTime(System.currentTimeMillis())} " +
                "${level.name[0]} $tag: $message"
            appendLine(line)
        }
        return 0
    }

    /** Full file content (backup generation first): what the exporter reads. */
    fun snapshot(): List<String> = synchronized(lock) {
        try {
            val dir = logDir ?: return@synchronized emptyList()
            val lines = ArrayList<String>()
            val backup = File(dir, BACKUP_FILE)
            if (backup.exists()) lines.addAll(backup.readLines())
            val current = File(dir, LOG_FILE)
            if (current.exists()) lines.addAll(current.readLines())
            lines
        } catch (_: Exception) {
            emptyList()
        }
    }

    fun size(): Int = synchronized(lock) {
        try {
            val dir = logDir ?: return@synchronized 0
            var count = 0
            val backup = File(dir, BACKUP_FILE)
            if (backup.exists()) count += backup.readLines().size
            val current = File(dir, LOG_FILE)
            if (current.exists()) count += current.readLines().size
            count
        } catch (_: Exception) {
            0
        }
    }

    fun clear() = synchronized(lock) {
        seq = 0L
        logDir?.let {
            File(it, LOG_FILE).delete()
            File(it, BACKUP_FILE).delete()
        }
        Unit
    }

    /**
     * Captures fatal crashes into the log file. The [delegate] runs after the
     * entry is written; pass a recorder in tests, null on device to chain to
     * the previous default handler.
     */
    fun installCrashHandler(delegate: ((Thread, Throwable) -> Unit)? = null) {
        val prev = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, error ->
            // Crash-file capture obeys the same opt-in toggle as normal logging.
            val wasEnabled = enabled
            if (!wasEnabled) enabled = true
            try {
                e("AndroidRuntime", "FATAL EXCEPTION: ${thread.name}\n${error.stackTraceToString()}")
            } catch (_: Exception) {
            } finally {
                enabled = wasEnabled
            }
            (delegate ?: { t, e -> prev?.uncaughtException(t, e) })(thread, error)
        }
    }

    private fun appendLine(line: String) {
        try {
            val dir = logDir ?: return
            if (!dir.exists() && !dir.mkdirs()) return
            val current = File(dir, LOG_FILE)
            if (current.exists() && current.length() > MAX_FILE_BYTES) {
                File(dir, BACKUP_FILE).delete()
                current.renameTo(File(dir, BACKUP_FILE))
            }
            current.appendText(line + "\n")
        } catch (_: Exception) {
        }
    }

    private fun levelToPriority(level: Level): Int = when (level) {
        Level.VERBOSE -> android.util.Log.VERBOSE
        Level.DEBUG -> android.util.Log.DEBUG
        Level.INFO -> android.util.Log.INFO
        Level.WARN -> android.util.Log.WARN
        Level.ERROR -> android.util.Log.ERROR
    }

    internal fun formatTime(timeMs: Long): String {
        val totalSeconds = timeMs / 1000
        val ms = timeMs % 1000
        val s = totalSeconds % 60
        val m = (totalSeconds / 60) % 60
        val h = (totalSeconds / 3600) % 24
        val sb = StringBuilder(12)
        appendPadded(sb, h, 2)
        sb.append(':')
        appendPadded(sb, m, 2)
        sb.append(':')
        appendPadded(sb, s, 2)
        sb.append('.')
        appendPadded(sb, ms, 3)
        return sb.toString()
    }

    private fun appendPadded(sb: StringBuilder, value: Long, width: Int) {
        if (value < 0) {
            sb.append('-')
            val s = (-value).toString()
            for (i in 0 until width - 1 - s.length) sb.append('0')
            sb.append(s)
        } else {
            val s = value.toString()
            for (i in 0 until width - s.length) sb.append('0')
            sb.append(s)
        }
    }
}
