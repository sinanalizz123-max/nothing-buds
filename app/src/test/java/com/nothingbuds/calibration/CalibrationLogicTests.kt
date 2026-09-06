package com.nothingbuds.calibration

import com.nothingbuds.protocol.AncMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class CalibrationLogicTests {

    @Test
    fun `tracker converges on repeated heard answers`() {
        val tracker = ThresholdTracker()
        repeat(10) { tracker.answer(heard = true) }
        assertTrue(tracker.isDone)
        assertTrue(tracker.threshold <= CalibrationTones.START_LEVEL)
    }

    @Test
    fun `tracker rises on unheard answers within safe max`() {
        val tracker = ThresholdTracker()
        repeat(10) { tracker.answer(heard = false) }
        assertTrue(tracker.isDone)
        assertTrue(tracker.level <= CalibrationTones.MAX_LEVEL)
    }

    @Test
    fun `tracker stops after max trials`() {
        val tracker = ThresholdTracker()
        var steps = 0
        while (!tracker.isDone && steps < 50) {
            tracker.answer(heard = steps % 2 == 0)
            steps += 1
        }
        assertTrue(steps <= CalibrationTones.MAX_TRIALS + 1)
    }

    @Test
    fun `my eq derives boosts from thresholds`() {
        val thresholds = mapOf(
            250 to 0.35f, 500 to 0.35f,
            1000 to 0.3f, 2000 to 0.3f,
            4000 to 0.45f, 8000 to 0.45f
        )
        val (bass, mid, treble) = generateMyEq(thresholds)
        assertEquals(0, mid)
        assertEquals(1, bass)
        assertEquals(3, treble)
    }

    @Test
    fun `my eq clamps to 0 to 6`() {
        val flat = CalibrationTones.FREQUENCIES_HZ.associateWith { 0.3f }
        val (bass, mid, treble) = generateMyEq(flat)
        assertEquals(Triple(0, 0, 0), Triple(bass, mid, treble))
        val extreme = flat + mapOf(4000 to 0.5f, 8000 to 0.5f)
        assertTrue(generateMyEq(extreme).third <= 6)
    }

    @Test
    fun `anc controller saves switches and restores`() {
        var current: AncMode? = AncMode.TRANSPARENCY
        val applied = mutableListOf<AncMode>()
        val controller = CalibrationAncController(hasAnc = true) {
            applied.add(it)
            current = it
        }
        assertNull(controller.begin(current))
        assertEquals(listOf(AncMode.HIGH), applied)
        controller.finish()
        assertEquals(listOf(AncMode.HIGH, AncMode.TRANSPARENCY), applied)
        assertEquals(AncMode.TRANSPARENCY, current)
    }

    @Test
    fun `anc controller restores after failure path`() {
        var current: AncMode? = AncMode.OFF
        val controller = CalibrationAncController(hasAnc = true) { current = it }
        controller.begin(current)
        controller.finish()
        assertEquals(AncMode.OFF, current)
    }

    @Test
    fun `anc controller finish without begin is a no-op`() {
        var sets = 0
        val controller = CalibrationAncController(hasAnc = true) { sets += 1 }
        controller.finish()
        assertEquals(0, sets)
    }

    @Test
    fun `anc controller continues gracefully without anc support`() {
        var sets = 0
        val controller = CalibrationAncController(hasAnc = false) { sets += 1 }
        val notice = controller.begin(null)
        assertTrue(notice!!.isNotEmpty())
        controller.finish()
        assertEquals(0, sets)
    }

    @Test
    fun `system eq reports unsupported with reason`() {
        val status = SystemEq.status()
        assertTrue(status is SystemEq.Status.Unsupported)
        assertTrue((status as SystemEq.Status.Unsupported).reason.isNotEmpty())
    }

    @Test
    fun `notification permission request matrix`() {
        assertTrue(NotificationPermission.shouldRequest(33, granted = false, askedBefore = false))
        assertTrue(NotificationPermission.shouldRequest(34, granted = false, askedBefore = false))
        assertFalse(NotificationPermission.shouldRequest(33, granted = true, askedBefore = false))
        assertFalse(NotificationPermission.shouldRequest(33, granted = false, askedBefore = true))
        assertFalse(NotificationPermission.shouldRequest(32, granted = false, askedBefore = false))
    }

    @Test
    fun `frequencies span low mid high`() {
        val freqs = CalibrationTones.FREQUENCIES_HZ
        assertTrue(freqs.size >= 6)
        assertTrue(freqs.any { it < 500 })
        assertTrue(freqs.any { it in 500..2000 })
        assertTrue(freqs.any { it > 2000 })
        assertTrue(CalibrationTones.MAX_LEVEL <= 0.5f)
    }
}
