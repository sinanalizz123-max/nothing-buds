package com.nothingbuds.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Process-wide state holder.
 *
 * The service, the notification hub, the Quick Settings tile and the UI all live in the same
 * process, so a plain singleton is the cheapest way to share one source of truth. The service
 * writes, everyone else observes.
 */
object BudsRepository {

    private val _state = MutableStateFlow(EarbudsState())
    val state: StateFlow<EarbudsState> = _state.asStateFlow()

    fun update(transform: (EarbudsState) -> EarbudsState) {
        _state.value = transform(_state.value)
    }

    fun set(state: EarbudsState) {
        _state.value = state
    }
}
