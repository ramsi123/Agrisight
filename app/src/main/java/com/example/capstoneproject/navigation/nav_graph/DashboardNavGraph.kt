package com.example.capstoneproject.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.capstoneproject.navigation.DASHBOARD_ROUTE
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.screen.home.HomeScreen
import com.example.capstoneproject.ui.screen.profile.ProfileScreen
import com.example.capstoneproject.ui.screen.tools.ToolsScreen

fun NavGraphBuilder.dashboardNavGraph(
    navController: NavHostController,
    signOut: () -> Unit
) {
    navigation(
        startDestination = Screen.Home.route,
        route = DASHBOARD_ROUTE
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Tools.route) {
            ToolsScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(
                navController = navController,
                signOut = signOut
            )
        }
    }
}
