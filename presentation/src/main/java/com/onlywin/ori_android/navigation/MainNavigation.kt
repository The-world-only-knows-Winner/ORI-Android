package com.onlywin.ori_android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onlywin.ori_android.feature.home.Home
import com.onlywin.ori_android.feature.selectposition.SelectPosition

internal fun NavGraphBuilder.mainNavigation(

) {
    navigation(
        startDestination = NavigationRoute.Main.Home,
        route = NavigationRoute.Main.route,
    ) {
        composable(NavigationRoute.Main.SelectPosition) {
            SelectPosition()
        }

        composable(NavigationRoute.Main.Home) {
            Home()
        }
    }
}