package app.spood.screens.signUp.effect

import app.spood.redux.Effect
import app.spood.redux.Store
import app.spood.screens.signUp.SignUpAction
import app.spood.screens.signUp.SignUpState

class SignUpValidationEffect : Effect<SignUpState, SignUpAction> {

    override suspend fun process(
        action: SignUpAction,
        state: SignUpState,
        store: Store<SignUpState, SignUpAction>
    ) {

        if (action is SignUpAction.InitiateSignUp) {
            validateFullName(state.fullName)?.let { error ->
                store.dispatch(SignUpAction.SetFullNameError(error))
            }

            validatePhoneNumber(state.phoneNumber)?.let { error ->
                store.dispatch(SignUpAction.SetPhoneNumberError(error))
            }
        }
    }

    private fun validateFullName(fullName: String): String? {
        return when {
            fullName.isBlank() -> {
                "Please enter your full name"
            }
            !fullName.trim().contains(" ") -> {
                "You need to enter both your first and last name"
            }
            else -> null
        }
    }

    private fun validatePhoneNumber(phoneNumber: String): String? {
        return when {
            phoneNumber.isBlank() -> {
                "Please enter a phone number"
            }
            else -> null
        }
    }
}