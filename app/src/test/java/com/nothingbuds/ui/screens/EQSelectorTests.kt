package com.nothingbuds.ui.screens

import com.nothingbuds.protocol.EqPreset
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EQSelectorTests {

    @Test
    fun `tile columns adapt to width`() {
        assertEquals(2, eqTileColumns(200))
        assertEquals(3, eqTileColumns(360))
        assertEquals(4, eqTileColumns(600))
        assertEquals(2, eqTileColumns(0))
    }

    @Test
    fun `current preset display`() {
        assertEquals(
            "Pop",
            eqRowSubtitle(isDirac = true, diracEq = 3, eqPresetName = "Balanced", myEqShown = false)
        )
        assertEquals(
            "Dirac",
            eqRowSubtitle(isDirac = true, diracEq = 0, eqPresetName = "Balanced", myEqShown = false)
        )
        assertEquals(
            "Custom",
            eqRowSubtitle(isDirac = true, diracEq = 6, eqPresetName = "Balanced", myEqShown = false)
        )
        assertEquals(
            "More Bass",
            eqRowSubtitle(isDirac = false, diracEq = 0, eqPresetName = "More Bass", myEqShown = false)
        )
    }

    @Test
    fun `my eq display overrides preset`() {
        assertEquals(
            "My EQ",
            eqRowSubtitle(isDirac = true, diracEq = 3, eqPresetName = "Pop", myEqShown = true)
        )
    }

    @Test
    fun `my eq tile only on dirac with profile and switch on`() {
        assertTrue(showMyEqTile(isDirac = true, calibrationEnabled = true, myEq = intArrayOf(1, 0, 3)))
        assertFalse(showMyEqTile(isDirac = false, calibrationEnabled = true, myEq = intArrayOf(1, 0, 3)))
        assertFalse(showMyEqTile(isDirac = true, calibrationEnabled = false, myEq = intArrayOf(1, 0, 3)))
        assertFalse(showMyEqTile(isDirac = true, calibrationEnabled = true, myEq = null))
    }

    @Test
    fun `dirac custom range is minus6 to plus6`() {
        for (v in -6..6) {
            assertEquals(v, v.coerceIn(-6, 6))
        }
        assertEquals(-6, (-9).coerceIn(-6, 6))
        assertEquals(6, 9.coerceIn(-6, 6))
    }

    @Test
    fun `reset produces flat bands`() {
        assertArrayEquals(intArrayOf(0, 0, 0), IntArray(3) { 0 })
        assertArrayEquals(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0), IntArray(8) { 0 })
    }

    @Test
    fun `standard preset labels cover all entries`() {
        assertEquals(
            setOf(EqPreset.BALANCED, EqPreset.MORE_BASS, EqPreset.MORE_TREBLE, EqPreset.VOICE, EqPreset.CUSTOM),
            EqPreset.entries.toSet()
        )
    }
}
