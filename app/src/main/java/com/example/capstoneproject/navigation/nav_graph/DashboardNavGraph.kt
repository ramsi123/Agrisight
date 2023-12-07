package com.example.capstoneproject.navigation.nav_graph

import androidx.activity.ComponentActivity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.capstoneproject.navigation.DASHBOARD_ROUTE
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.screen.article_list.ArticleListScreen
import com.example.capstoneproject.ui.screen.camera.CameraScreen
import com.example.capstoneproject.ui.screen.home.HomeScreen
import com.example.capstoneproject.ui.screen.plant_list.PlantListScreen
import com.example.capstoneproject.ui.screen.profile.ProfileScreen
import com.example.capstoneproject.ui.screen.result.ResultScreen
import com.example.capstoneproject.ui.screen.tools.ToolsScreen

fun NavGraphBuilder.dashboardNavGraph(
    navController: NavHostController,
    activity: ComponentActivity,
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
        composable(Screen.Camera.route) {
            CameraScreen(navController = navController, activity = activity)
        }
        composable(
            route = Screen.Result.route,
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("score") { type = NavType.FloatType }
            )
        ) {
            val title = it.arguments?.getString("title") ?: ""
            val score = it.arguments?.getFloat("score") ?: 0F
            ResultScreen(
                navController = navController,
                title = title,
                score = score
            )
        }
        composable(Screen.PlantList.route) {
            PlantListScreen(navController = navController)
        }
        composable(Screen.ArticleList.route) {
            ArticleListScreen(navController = navController)
        }
    }
}
