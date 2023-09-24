package com.onlywin.ori_android.navigation

sealed class NavigationRoute(val route: String) {
    object Auth : NavigationRoute(route = "Auth") {
        const val SignIn = "signIn"
        const val SignUpAccount = "signUpAccount"
        const val SignUpUser = "signUpUser"
        const val SignUpComplete = "signUpComplete"
    }

    object User : NavigationRoute(route = "User") {
        const val Splash = "splash"
        const val Onboarding = "onboarding"
    }

    object Main : NavigationRoute(route = "Main") {
        const val SelectPosition = "selectPosition"
    }
}
