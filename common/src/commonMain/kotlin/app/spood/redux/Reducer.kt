package app.spood.redux

/**
 * Modifies a [State] using a given [Action]
 */
interface Reducer<S : State, A : Action> {

    /**
     * Given a [state] and some [action] a user took, produce  a new [State]
     */
    fun reduce(state: S, action: A): S
}