package com.onlywin.ori_android.feature.signup

data class SignUpState(
    val email: String,
    val emailError: Boolean?,
    val code: String,
    val codeError: Boolean?,
    val password: String,
    val passwordError: Boolean?,
    val name: String,
    val birthday: String,
    val currentStep: Int,
    val buttonEnabled: Boolean,
    val codeButtonEnabled: Boolean,
) {
    companion object {
        fun getDefault() = SignUpState(
            email = "",
            emailError = null,
            code = "",
            codeError = null,
            password = "",
            passwordError = null,
            name = "",
            birthday = "",
            currentStep = 0,
            buttonEnabled = false,
            codeButtonEnabled = false,
        )
    }
}
