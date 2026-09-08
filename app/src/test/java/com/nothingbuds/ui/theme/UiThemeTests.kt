package com.nothingbuds.ui.theme

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class UiThemeTests {

    @Test
    fun `parse known values`() {
        assertEquals(UiTheme.MATERIAL_DARK, UiTheme.parse("MATERIAL_DARK"))
        assertEquals(UiTheme.MATERIAL_LIGHT, UiTheme.parse("MATERIAL_LIGHT"))
        assertEquals(UiTheme.LIQUID_GLASS, UiTheme.parse("LIQUID_GLASS"))
    }

    @Test
    fun `unknown falls back to material dark`() {
        assertEquals(UiTheme.MATERIAL_DARK, UiTheme.parse(null))
        assertEquals(UiTheme.MATERIAL_DARK, UiTheme.parse(""))
        assertEquals(UiTheme.MATERIAL_DARK, UiTheme.parse("DARK"))
    }

    @Test
    fun `first launch follows system theme with material`() {
        assertEquals(UiTheme.MATERIAL_DARK, UiTheme.systemDefault(isSystemDark = true))
        assertEquals(UiTheme.MATERIAL_LIGHT, UiTheme.systemDefault(isSystemDark = false))
    }

    @Test
    fun `labels are non-empty`() {
        UiTheme.entries.forEach { assertTrue(it.label.isNotEmpty()) }
    }
}
