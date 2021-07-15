package app.spood.screens.signUp

import app.spood.domain.usecase.SignUpUseCase
import app.spood.redux.Store
import app.spood.util.asCommonFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class SignUpStore(
    private val signUpUseCase: SignUpUseCase
) : Store<SignUpState, SignUpAction, SignUpEffect> {

    private val _state = MutableStateFlow(SignUpState())
    override val state get() = _state
    override val stateIos get() = state.asCommonFlow()

    override val sideEffect = MutableSharedFlow<SignUpEffect>()

    override fun dispatch(action: SignUpAction) {
        val newState = when (action) {
            is SignUpAction.ChangeFullName -> {
                dispatch(SignUpAction.SetFullNameError(null))
                _state.value.copy(fullName = action.fullName)
            }
            is SignUpAction.SetFullNameError -> {
                _state.value.copy(fullNameError = action.error)
            }
            is SignUpAction.ChangePhoneNumber -> {
                dispatch(SignUpAction.SetPhoneNumberError(null))
                _state.value.copy(phoneNumber = action.phoneNumber)
            }
            is SignUpAction.SetPhoneNumberError -> {
                _state.value.copy(phoneNumberError = action.error)
            }
            is SignUpAction.ShowSignUpLoader -> {
                _state.value.copy(loading = action.loading)
            }
            SignUpAction.InitiateSignUp -> {
                dispatch(SignUpAction.SetFullNameError("Please enter your full name"))
                dispatch(SignUpAction.SetPhoneNumberError("Please enter your phone number"))
                _state.value
            }
            SignUpAction.SignUpSucceeded -> {
                _state.value.copy(signedUp = true)
            }
            is SignUpAction.SignUpFailed -> {
                _state.value.copy(signUpError = action.error)
            }
        }

        if (newState != _state.value) {
            println("SignUpStore ==> NewState: $newState")
            _state.value = newState
        }
    }
}