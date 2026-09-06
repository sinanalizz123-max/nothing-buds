package com.nothingbuds.ui.screens

/**
 * Holds a pending reboot-required action behind a confirmation dialog.
 * The stored action runs exactly once on confirm and never on cancel;
 * requesting a new action replaces the pending one.
 */
internal class RebootGate {
    private var pending: (() -> Unit)? = null

    val hasPending: Boolean get() = pending != null

    fun request(action: () -> Unit) {
        pending = action
    }

    fun confirm(): Boolean {
        val action = pending ?: return false
        pending = null
        action()
        return true
    }

    fun cancel() {
        pending = null
    }
}
