package com.onlywin.ori_android.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onlywin.ori_android.feature.Splash

internal fun NavGraphBuilder.userNavigation(){
    navigation(
        route = NavigationRoute.User.route,
        startDestination = NavigationRoute.User.Splash,
    ){
        composable(NavigationRoute.User.Splash){
            Splash()
        }
    }
}