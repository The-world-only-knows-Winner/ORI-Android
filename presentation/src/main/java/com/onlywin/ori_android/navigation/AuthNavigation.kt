package com.onlywin.ori_android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onlywin.ori_android.feature.signin.SignIn
import com.onlywin.ori_android.feature.signup.SignUpAccount
import com.onlywin.ori_android.feature.signup.SignUpComplete
import com.onlywin.ori_android.feature.signup.SignUpUser

internal fun NavGraphBuilder.authNavigation(
    moveToOnboarding: () -> Unit,
    moveToSignUpUser: () -> Unit,
    moveToSignUpAccount: () -> Unit,
    moveToComplete: () -> Unit,
) {
    navigation(
        route = NavigationRoute.Auth.route,
        startDestination = NavigationRoute.Auth.SignIn,
    ) {
        composable(NavigationRoute.Auth.SignIn) {
            SignIn(
                moveToOnboarding = moveToOnboarding,
            )
        }

        composable(NavigationRoute.Auth.SignUpAccount) {
            SignUpAccount(
                moveToOnboarding = moveToOnboarding,
                moveToSignUpUser = moveToSignUpUser,
            )
        }

        composable(NavigationRoute.Auth.SignUpUser) {
            SignUpUser(
                moveToSignUpAccount = moveToSignUpAccount,
                moveToComplete = moveToComplete,
            )
        }

        composable(NavigationRoute.Auth.SignUpComplete) {
            SignUpComplete()
        }
    }
}
