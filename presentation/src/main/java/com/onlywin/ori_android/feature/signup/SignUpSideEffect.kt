package com.onlywin.ori_android.feature.signup

sealed class SignUpSideEffect {
    object MoveToSignUpUser: SignUpSideEffect()
    object Success: SignUpSideEffect()
}