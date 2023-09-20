package com.onlywin.ori_android.feature.signin

import com.onlywin.ori_android.base.State

data class SignInState(
    val email: String,
    val password: String,
) : State {
    companion object {
        internal fun getDefault() = SignInState(
            email = "",
            password = "",
        )
    }
}
