package com.onlywin.ori_android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onlywin.ori_android.feature.signin.SignIn
import com.onlywin.ori_android.feature.signup.SignUpAccount
import com.onlywin.ori_android.feature.signup.SignUpComplete
import com.onlywin.ori_android.feature.signup.SignUpUser
import com.onlywin.ori_android.viewmodel.user.SignUpViewModel
import org.koin.androidx.compose.koinViewModel

private val signUpViewModel: SignUpViewModel
    @Composable get() = koinViewModel()

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
            SignIn(moveToOnboarding = moveToOnboarding)
        }

        composable(NavigationRoute.Auth.SignUpAccount) {
            SignUpAccount(
                moveToOnboarding = moveToOnboarding,
                moveToSignUpUser = moveToSignUpUser,
                signUpViewModel = signUpViewModel,
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
