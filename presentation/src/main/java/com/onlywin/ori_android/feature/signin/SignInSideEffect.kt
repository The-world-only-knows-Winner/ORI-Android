package com.onlywin.ori_android.feature.signin

import com.onlywin.ori_android.base.SideEffect

sealed class SignInSideEffect : SideEffect {
    object Success : SignInSideEffect()
}
