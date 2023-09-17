package com.onlywin.ori_android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.onlywin.ori_android.navigation.NavigationRoute
import com.onlywin.ori_android.navigation.authNavigation
import com.onlywin.ori_android.navigation.userNavigation

@Composable
internal fun DuckApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoute.User.route,
    ) {
        authNavigation(
            moveToOnboarding = { navController.popBackStack() }
        )
        userNavigation(
            moveToOnboarding = { navController.navigate(NavigationRoute.User.Onboarding) },
            moveToSignUp = { },
            moveToSignIn = { navController.navigate(NavigationRoute.Auth.SignIn) },
        )
    }
}
