package app.spood.domain.usecase

import app.spood.screens.signUp.SignUpState
import app.spood.util.CommonFlow
import app.spood.util.asCommonFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class SignUpUseCase {

    private val _state = MutableStateFlow(SignUpState())
    val state: Flow<SignUpState> = _state
    val stateIos: CommonFlow<SignUpState> = state.asCommonFlow()

    fun fullNameChanged(fullName: String) {
        _state.value = _state.value.copy(
            fullName = fullName,
            fullNameError = null
        )
    }

    fun phoneNumberChanged(phoneNumber: String) {
        _state.value = _state.value.copy(
            phoneNumber = phoneNumber,
            phoneNumberError = null
        )
    }

    fun signUpErrorDismissed() {
        _state.value = _state.value.copy(signUpError = null)
    }

    suspend fun signUp() {
        _state.value = _state.value.copy(loading = true)
        val validFullName = validateFullName(_state.value.fullName)
        val validPhoneNumber = validatePhoneNumber(_state.value.phoneNumber)
        if (!(validFullName && validPhoneNumber)) {
            _state.value = _state.value.copy(loading = false)
            return
        }

        // Emulate Login Stuff
        if (Random.nextBoolean()) {
            _state.value = _state.value.copy(signedUp = true)
        } else {
            _state.value = _state.value.copy(signUpError = Throwable("Nice Try"))
        }
        _state.value = _state.value.copy(loading = false)
    }

    private fun validateFullName(fullName: String): Boolean {
        return when {
            fullName.isBlank() -> {
                _state.value = _state.value.copy(fullNameError = "Please enter your full name")
                false
            }
            !fullName.trim().contains(" ") -> {
                _state.value = _state.value.copy(fullNameError = "You entered an invalid full name")
                false
            }
            else -> true
        }
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        return when {
            phoneNumber.isBlank() -> {
                _state.value = _state.value.copy(phoneNumberError = "Please enter a phone number")
                false
            }
            else -> true
        }
    }
}