package com.onlywin.ori_android.viewmodel

import com.onlywin.ori_android.feature.signin.SignInSideEffect
import com.onlywin.ori_android.feature.signin.SignInState

class SignInViewModel : BaseViewModel<SignInState, SignInSideEffect>(SignInState.getDefault()) {
    internal fun setEmail(email: String) {
        setState(state.value.copy(email = email))
    }

    internal fun setPassword(password: String) {
        setState(state.value.copy(password = password))
    }
}
