package app.spood.screens.signUp.effect

import app.spood.domain.entity.User
import app.spood.redux.Effect
import app.spood.redux.Store
import app.spood.screens.signUp.SignUpAction
import app.spood.screens.signUp.SignUpState
import kotlinx.coroutines.delay
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
        // Emulate Login Stuff
        delay(2000)
        if (Random.nextBoolean()) {
            return User(1, "Oliver M")
        } else {
            throw Exception("You already have an account. Try signing in.")
        }
    }
}