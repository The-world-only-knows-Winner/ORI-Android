package com.onlywin.ori_android.feature.signin

import com.onlywin.ori_android.viewmodel.SideEffect

sealed class SignInSideEffect : SideEffect {
    object Success : SignInSideEffect()
}
