package app.spood.redux

import app.spood.util.CommonFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Store<S : State, A : Action, E : Effect> {
    val state: StateFlow<S>
    val stateIos: CommonFlow<S>
    val sideEffect: Flow<E>
    fun dispatch(action: A)
}