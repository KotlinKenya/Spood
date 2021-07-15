package app.spood.screens.signUp

import app.spood.redux.State

data class SignUpState(
    val fullName: String = "",
    val fullNameError: String? = null,
    val phoneNumber: String = "",
    val phoneNumberError: String? = null,
    val loading: Boolean = false,
    val signUpError: Throwable? = null,
    val signedUp: Boolean = false
) : State