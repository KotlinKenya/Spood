package app.spood.redux

/**
 * Processes side-effects of an [Action]
 */
interface Effect<S : State, A : Action> {

    /**
     * Given an [action] and a [state], process a side-effect without modifying the state directly
     */
    suspend fun process(action: A, state: S, store: Store<S, A>)
}