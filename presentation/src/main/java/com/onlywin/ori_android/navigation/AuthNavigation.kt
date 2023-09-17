package com.onlywin.ori_android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onlywin.ori_android.feature.signin.SignIn
import com.onlywin.ori_android.feature.signup.SignUpAccount
import com.onlywin.ori_android.feature.signup.SignUpUser

internal fun NavGraphBuilder.authNavigation(
    moveToOnboarding: () -> Unit,
    moveToSignUpAccount: () -> Unit,
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

        composable(NavigationRoute.User.SignUpAccount) {
            SignUpAccount(
                moveToOnboarding = moveToOnboarding,
            )
        }

        composable(NavigationRoute.User.SignUpUser){
            SignUpUser(
                moveToSignUpAccount = moveToSignUpAccount,
            )
        }
    }
}
