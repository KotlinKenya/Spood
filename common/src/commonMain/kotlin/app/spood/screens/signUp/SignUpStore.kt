package app.spood.screens.signUp

import app.spood.redux.Effect
import app.spood.redux.Store
import app.spood.util.asCommonFlow
import kotlinx.coroutines.flow.MutableStateFlow

class SignUpStore(
    private val reducer: SignUpReducer,
    private val effects: List<Effect<SignUpState, SignUpAction>> = emptyList()
) : Store<SignUpState, SignUpAction> {

    private val _state = MutableStateFlow(SignUpState())
    override val state get() = _state
    override val stateIos get() = state.asCommonFlow()

    override suspend fun dispatch(action: SignUpAction) {
        effects.forEach { effect ->
            effect.process(action, _state.value, this)
        }

        val newState = reducer.reduce(_state.value, action)
        _state.value = newState
    }
}