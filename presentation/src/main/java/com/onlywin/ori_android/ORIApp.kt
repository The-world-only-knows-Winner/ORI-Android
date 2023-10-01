package com.onlywin.ori_android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.onlywin.ori_android.navigation.NavigationRoute
import com.onlywin.ori_android.navigation.authNavigation
import com.onlywin.ori_android.navigation.mainNavigation
import com.onlywin.ori_android.navigation.userNavigation

@Composable
internal fun ORIApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoute.User.route,
    ) {
        authNavigation(
            moveToOnboarding = { navController.popBackStack() },
            moveToSignUpUser = { navController.navigate(NavigationRoute.Auth.SignUpUser) },
            moveToSignUpAccount = { navController.popBackStack() },
            moveToComplete = { navController.navigate(NavigationRoute.Auth.SignUpComplete) }
        )
        userNavigation(
            moveToOnboarding = {
                navController.navigate(NavigationRoute.User.Onboarding) {
                    popUpTo(NavigationRoute.User.Splash) {
                        inclusive = true
                    }
                }
            },
            moveToSignUp = { navController.navigate(NavigationRoute.Auth.SignUpAccount) },
            moveToSignIn = { navController.navigate(NavigationRoute.Auth.SignIn) },
        )
        mainNavigation()
    }
}
