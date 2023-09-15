package com.onlywin.ori_android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onlywin.ori_android.feature.Splash
import com.onlywin.ori_android.feature.onboarding.Onboarding

internal fun NavGraphBuilder.userNavigation(
    moveToSignUp: () -> Unit,
    moveToSignIn: () -> Unit,
) {
    navigation(
        route = NavigationRoute.User.route,
        startDestination = NavigationRoute.User.Onboarding,
    ) {
        composable(NavigationRoute.User.Splash) {
            Splash()
        }

        composable(NavigationRoute.User.Onboarding) {
            Onboarding(
                moveToSignUp = moveToSignUp,
                moveToSignIn = moveToSignIn,
            )
        }

    }
}
