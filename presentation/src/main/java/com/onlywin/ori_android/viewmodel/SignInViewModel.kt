package com.onlywin.ori_android.viewmodel

import androidx.lifecycle.viewModelScope
import com.onlywin.domain.repository.AuthRepository
import com.onlywin.ori_android.base.BaseViewModel
import com.onlywin.ori_android.feature.signin.SignInSideEffect
import com.onlywin.ori_android.feature.signin.SignInState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authRepository: AuthRepository,
) : BaseViewModel<SignInState, SignInSideEffect>(SignInState.getDefault()) {
    internal fun setEmail(email: String) {
        setState(state.value.copy(email = email))
    }

    internal fun setPassword(password: String) {
        setState(state.value.copy(password = password))
    }

    internal fun signIn() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                authRepository.signIn(
                    email = state.value.email,
                    password = state.value.password,
                )
            }.onSuccess {

            }.onFailure {

            }
        }
    }
}
