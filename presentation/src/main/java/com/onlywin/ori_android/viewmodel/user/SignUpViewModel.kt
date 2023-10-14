package com.onlywin.ori_android.viewmodel.user

import androidx.lifecycle.viewModelScope
import com.onlywin.domain.enums.Regexes
import com.onlywin.domain.exception.BadRequestException
import com.onlywin.domain.usecase.auth.SendAuthCodeUseCase
import com.onlywin.domain.usecase.auth.VerifyAuthCodeUseCase
import com.onlywin.domain.usecase.user.SignUpUseCase
import com.onlywin.ori_android.base.BaseViewModel
import com.onlywin.ori_android.feature.signup.SignUpSideEffect
import com.onlywin.ori_android.feature.signup.SignUpState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase,
    private val sendAuthCodeUseCase: SendAuthCodeUseCase,
    private val verifyAuthCodeUseCase: VerifyAuthCodeUseCase,
) : BaseViewModel<SignUpState, SignUpSideEffect>(SignUpState.getDefault()) {

    internal fun onButtonClick() {
        when (state.value.currentStep) {
            0 -> sendAuthCode()
            1 -> verifyAuthCode()
            2 -> {
                postSideEffect(SignUpSideEffect.MoveToSignUpUser)
                moveToNextStep(3)
            }

            3 -> moveToNextStep(4)
            4 -> signUp()
            else -> {}
        }
    }

    internal fun setEmail(email: String) {
        setState(
            state.value.copy(
                email = email,
                codeButtonEnabled = email.isNotBlank(),
                buttonEnabled = email.isNotBlank(),
            )
        )
    }

    internal fun setCode(code: String) {
        setState(state.value.copy(code = code))
    }

    internal fun setPassword(password: String) {
        setState(
            state.value.copy(
                password = password,
                passwordError = if (!Regex(Regexes.PASSWORD).matches(password)) true
                else null,
            )
        )
    }

    internal fun setName(name: String) {
        setState(state.value.copy(name = name))
    }

    internal fun setBirth(birth: String) {
        setState(state.value.copy(birthDay = birth))
    }

    private fun moveToNextStep(currentStep: Int) {
        with(state.value) {
            setState(copy(currentStep = currentStep))
        }
    }

    internal fun sendAuthCode() {
        viewModelScope.launch(Dispatchers.IO) {
            with(state.value) {
                sendAuthCodeUseCase(email).onSuccess {
                    setState(copy(emailError = false))
                    moveToNextStep(1)
                }
            }
        }
    }

    private fun verifyAuthCode() {
        viewModelScope.launch(Dispatchers.IO) {
            with(state.value) {
                verifyAuthCodeUseCase(
                    email = email,
                    code = code,
                ).onSuccess {
                    setState(copy(codeButtonEnabled = false))
                    setState(copy(codeError = null))
                    moveToNextStep(2)
                }.onFailure {
                    if (it is BadRequestException) setState(copy(codeError = true))
                }
            }
        }
    }

    private fun signUp() {
        viewModelScope.launch(Dispatchers.IO) {
            with(state.value) {
                signUpUseCase(
                    email = email,
                    password = password,
                    name = name,
                    birthday = birthDay,
                ).onSuccess {
                    postSideEffect(SignUpSideEffect.Success)
                }.onFailure {

                }
            }
        }
    }
}