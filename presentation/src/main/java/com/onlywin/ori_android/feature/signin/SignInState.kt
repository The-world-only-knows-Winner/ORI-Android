package com.onlywin.ori_android.feature.signin

data class SignInState(
    val email: String,
    val password: String,
) {
    companion object {
        internal fun getDefault() = SignInState(
            email = "",
            password = "",
        )
    }
}
