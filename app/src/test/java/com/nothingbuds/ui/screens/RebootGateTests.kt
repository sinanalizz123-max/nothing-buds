package com.nothingbuds.ui.screens

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RebootGateTests {

    @Test
    fun `cancel sends no command`() {
        val gate = RebootGate()
        var sends = 0
        gate.request { sends += 1 }
        assertTrue(gate.hasPending)
        gate.cancel()
        assertFalse(gate.hasPending)
        assertEquals(0, sends)
    }

    @Test
    fun `reboot now sends the command exactly once`() {
        val gate = RebootGate()
        var sends = 0
        gate.request { sends += 1 }
        assertTrue(gate.confirm())
        assertEquals(1, sends)
        assertFalse(gate.hasPending)
    }

    @Test
    fun `double confirm does not resend`() {
        val gate = RebootGate()
        var sends = 0
        gate.request { sends += 1 }
        gate.confirm()
        assertFalse(gate.confirm())
        assertEquals(1, sends)
    }

    @Test
    fun `new request replaces pending action`() {
        val gate = RebootGate()
        var first = 0
        var second = 0
        gate.request { first += 1 }
        gate.request { second += 1 }
        gate.confirm()
        assertEquals(0, first)
        assertEquals(1, second)
    }
}
