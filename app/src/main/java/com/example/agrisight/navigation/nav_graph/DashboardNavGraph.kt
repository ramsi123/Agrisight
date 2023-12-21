package com.example.agrisight.navigation.nav_graph

import androidx.activity.ComponentActivity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.agrisight.navigation.DASHBOARD_ROUTE
import com.example.agrisight.navigation.Screen
import com.example.agrisight.ui.screen.article_detail.ArticleDetailScreen
import com.example.agrisight.ui.screen.article_list.ArticleListScreen
import com.example.agrisight.ui.screen.camera.CameraScreen
import com.example.agrisight.ui.screen.home.HomeScreen
import com.example.agrisight.ui.screen.plant_detail.PlantDetailScreen
import com.example.agrisight.ui.screen.plant_list.PlantListScreen
import com.example.agrisight.ui.screen.profile.ProfileScreen
import com.example.agrisight.ui.screen.result.ResultScreen
import com.example.agrisight.ui.screen.tools.ToolsScreen

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
            val title = it.arguments?.getString("title") ?: "Unscanned"
            val score = it.arguments?.getFloat("score") ?: 1F
            ResultScreen(
                navController = navController,
                title = title,
                score = score
            )
        }
        composable(Screen.PlantList.route) {
            PlantListScreen(navController = navController)
        }
        composable(
            route = Screen.PlantDetail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ) {
            val id = it.arguments?.getString("id") ?: "1"
            PlantDetailScreen(navController = navController, plantId = id)
        }
        composable(Screen.ArticleList.route) {
            ArticleListScreen(navController = navController)
        }
        composable(
            route = Screen.ArticleDetail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ) {
            val id = it.arguments?.getString("id") ?: "1"
            ArticleDetailScreen(navController = navController, articleId = id)
        }
    }
}
