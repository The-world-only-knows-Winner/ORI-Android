package com.onlywin.ori_android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onlywin.ori_android.feature.signin.SignIn

internal fun NavGraphBuilder.authNavigation(
    moveToOnboarding: () -> Unit,
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
    }
}
