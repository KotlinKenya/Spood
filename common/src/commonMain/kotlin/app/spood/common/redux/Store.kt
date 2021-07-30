package app.spood.common.redux

import app.spood.common.util.CommonFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * A [State] container for a given screen
 */
interface Store<S : State, A : Action> {
    val state: StateFlow<S>
    val stateIos: CommonFlow<S>
    suspend fun dispatch(action: A)
}