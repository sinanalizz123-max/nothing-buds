package com.nothingbuds.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

/**
 * End-to-end logging-pipeline tests: entries from every layer must reach the
 * same exportable sink, in order, under rotation, concurrent writes and fatal
 * crashes — the exact input the log exporter reads.
 */
class AppLogTests {

    @get:Rule
    val tempFolder = TemporaryFolder()

    @Before
    fun initBuffer() {
        AppLog.init(tempFolder.root)
        AppLog.clear()
        AppLog.enabled = true
    }

    @Test
    fun `entries from all layers reach the export snapshot`() {
        AppLog.d("EQ_UI", "[EQ][A1] User selected Pop")
        AppLog.d("BudsService", "TX DIRAC cmd=0xF01D payload=0300")
        AppLog.d("BudsService", "RX ACK payload=00 ackStatus=0")
        AppLog.w("BluetoothConnectionReceiver", "link dropped")
        AppLog.e("BudsService", "Send failed, dropping the link: closed")

        val export = AppLog.snapshot().joinToString("\n")
        assertTrue(export.contains("[EQ][A1] User selected Pop"))
        assertTrue(export.contains("TX DIRAC cmd=0xF01D"))
        assertTrue(export.contains("RX ACK"))
        assertTrue(export.contains("link dropped"))
        assertTrue(export.contains("Send failed"))
    }

    @Test
    fun `snapshot is chronological`() {
        repeat(50) { AppLog.d("Test", "line $it") }
        val seqs = AppLog.snapshot().map { it.substringBefore(" ").toLong() }
        assertEquals((1L..50L).toList(), seqs)
    }

    @Test
    fun `entries logged immediately before export are present`() {
        AppLog.d("EQ_UI", "fresh entry just now")
        assertTrue(AppLog.snapshot().any { it.contains("fresh entry just now") })
    }

    @Test
    fun `file rotates keeping newest entries`() {
        repeat(12000) { AppLog.d("Test", "line $it padding padding padding padding pad") }
        val snapshot = AppLog.snapshot()
        assertTrue(snapshot.size < 12000)
        val export = snapshot.joinToString("\n")
        assertTrue(export.contains("line 11999"))
    }

    @Test
    fun `concurrent writes are thread-safe`() {
        val threads = 8
        val perThread = 200
        val latch = CountDownLatch(threads)
        val pool = Executors.newFixedThreadPool(threads)
        repeat(threads) { t ->
            pool.execute {
                repeat(perThread) { AppLog.d("T$t", "msg $it") }
                latch.countDown()
            }
        }
        latch.await()
        pool.shutdown()
        val snapshot = AppLog.snapshot()
        assertEquals(snapshot.size, snapshot.map { it.substringBefore(" ") }.toSet().size)
    }

    @Test
    fun `disabled toggle captures nothing`() {
        AppLog.enabled = false
        AppLog.d("Test", "must not be stored")
        assertTrue(AppLog.snapshot().isEmpty())
        AppLog.enabled = true
        AppLog.d("Test", "stored now")
        assertTrue(AppLog.snapshot().any { it.contains("stored now") })
    }

    @Test
    fun `levels are preserved`() {
        AppLog.w("Test", "warn here")
        AppLog.e("Test", "error here")
        val export = AppLog.snapshot().joinToString("\n")
        assertTrue(export.contains(" W Test: warn here"))
        assertTrue(export.contains(" E Test: error here"))
    }

    @Test
    fun `fatal crash is captured and delegate runs`() {
        var delegated = false
        AppLog.installCrashHandler { _, _ -> delegated = true }
        try {
            Thread.getDefaultUncaughtExceptionHandler()
                ?.uncaughtException(Thread.currentThread(), RuntimeException("boom-test"))
        } finally {
            AppLog.installCrashHandler { _, _ -> }
        }
        assertTrue(delegated)
        val export = AppLog.snapshot().joinToString("\n")
        assertTrue(export.contains("FATAL EXCEPTION"))
        assertTrue(export.contains("boom-test"))
    }
}
