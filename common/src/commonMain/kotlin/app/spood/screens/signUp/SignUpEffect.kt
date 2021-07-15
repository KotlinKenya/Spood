package app.spood.screens.signUp

import app.spood.redux.Effect

sealed class SignUpEffect : Effect {
    data class ValidateFullName(val fullName: String) : SignUpEffect()
}