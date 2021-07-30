package app.spood.common.screens.signUp

import app.spood.common.redux.Action

sealed class SignUpAction : Action {
    data class ChangeFullName(val fullName: String) : SignUpAction()
    data class SetFullNameError(val error: String?) : SignUpAction()

    data class ChangePhoneNumber(val phoneNumber: String) : SignUpAction()
    data class SetPhoneNumberError(val error: String?) : SignUpAction()

    data class ShowSignUpLoader(val loading: Boolean) : SignUpAction()

    object InitiateSignUp : SignUpAction()
    object SignUpSucceeded : SignUpAction()
    data class SetSignUpError(val error: Throwable?) : SignUpAction()
}