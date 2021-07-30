package app.spood.common.screens.signUp.effect

import app.spood.common.data.network.SpoodApi
import app.spood.common.domain.entity.User
import app.spood.common.redux.Effect
import app.spood.common.redux.Store
import app.spood.common.screens.signUp.SignUpAction
import app.spood.common.screens.signUp.SignUpState
import kotlin.random.Random

class SignUpNetworkingEffect : Effect<SignUpState, SignUpAction> {

    override suspend fun process(
        action: SignUpAction,
        state: SignUpState,
        store: Store<SignUpState, SignUpAction>
    ) {
        if (action is SignUpAction.InitiateSignUp && state.fullNameError.isNullOrBlank() && state.phoneNumberError.isNullOrBlank()) {
            store.dispatch(SignUpAction.SetSignUpError(null))
            store.dispatch(SignUpAction.ShowSignUpLoader(true))
            try {
                val user = signUp(state.fullName, state.phoneNumber)
                store.dispatch(SignUpAction.SignUpSucceeded)
            } catch (e: Exception) {
                store.dispatch(SignUpAction.SetSignUpError(e))
            } finally {
                store.dispatch(SignUpAction.ShowSignUpLoader(false))
            }
        }
    }

    suspend fun signUp(fullName: String, phoneNumber: String): User {
        val api = SpoodApi()
        val token = api.signUp(fullName, phoneNumber)
        throw Exception(token)
        return User(1, "Oliver M")
    }
}