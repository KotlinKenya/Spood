package app.spood.screens.signUp

import app.spood.redux.Reducer

/**
 * Handle any [SignUpAction] and create a new [SignUpState] accordingly
 */
class SignUpReducer : Reducer<SignUpState, SignUpAction> {

    /**
     * Modify [state] and return a new [SignUpState]
     */
    override fun reduce(state: SignUpState, action: SignUpAction) = when (action) {
        is SignUpAction.ChangeFullName -> state.copy(
            fullName = action.fullName,
            fullNameError = null,
            signUpError = null
        )
        is SignUpAction.SetFullNameError -> state.copy(
            fullNameError = action.error
        )
        is SignUpAction.ChangePhoneNumber -> state.copy(
            phoneNumber = action.phoneNumber,
            phoneNumberError = null,
            signUpError = null
        )
        is SignUpAction.SetPhoneNumberError -> state.copy(
            phoneNumberError = action.error
        )
        is SignUpAction.ShowSignUpLoader -> state.copy(
            loading = action.loading
        )
        SignUpAction.InitiateSignUp ->
            state
        SignUpAction.SignUpSucceeded -> state.copy(
            signedUp = true
        )
        is SignUpAction.SetSignUpError -> state.copy(
            signUpError = action.error
        )
    }
}