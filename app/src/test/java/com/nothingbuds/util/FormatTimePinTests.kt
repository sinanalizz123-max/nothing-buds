package com.nothingbuds.util

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Pins [AppLog.formatTime] manual-padding output (rewritten from String.format).
 * Format is "HH:MM:SS.mmm" with hours wrapping at 24.
 */
class FormatTimePinTests {

    @Test
    fun `formatTime zero`() {
        assertEquals("00:00:00.000", AppLog.formatTime(0L))
    }

    @Test
    fun `formatTime sub-second`() {
        assertEquals("00:00:00.001", AppLog.formatTime(1L))
        assertEquals("00:00:00.009", AppLog.formatTime(9L))
        assertEquals("00:00:00.010", AppLog.formatTime(10L))
        assertEquals("00:00:00.099", AppLog.formatTime(99L))
        assertEquals("00:00:00.999", AppLog.formatTime(999L))
    }

    @Test
    fun `formatTime second rollover`() {
        assertEquals("00:00:01.000", AppLog.formatTime(1000L))
        assertEquals("00:00:59.999", AppLog.formatTime(59999L))
    }

    @Test
    fun `formatTime 61s rollover`() {
        assertEquals("00:01:01.000", AppLog.formatTime(61_000L))
    }

    @Test
    fun `formatTime minute and hour padding`() {
        assertEquals("00:01:00.000", AppLog.formatTime(60_000L))
        assertEquals("00:59:59.999", AppLog.formatTime(3_599_999L))
        assertEquals("01:00:00.000", AppLog.formatTime(3_600_000L))
        assertEquals("01:02:03.004", AppLog.formatTime(3_723_004L))
        assertEquals("12:34:56.789", AppLog.formatTime(45_296_789L))
    }

    @Test
    fun `formatTime 24h wrap`() {
        assertEquals("23:59:59.999", AppLog.formatTime(86_399_999L))
        assertEquals("00:00:00.000", AppLog.formatTime(86_400_000L))
        assertEquals("00:00:00.001", AppLog.formatTime(86_400_001L))
        // 25h 01m 01s 001ms -> hour wraps to 01.
        assertEquals("01:01:01.001", AppLog.formatTime(90_061_001L))
    }
}
