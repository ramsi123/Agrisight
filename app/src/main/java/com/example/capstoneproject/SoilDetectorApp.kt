package com.example.capstoneproject

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstoneproject.navigation.AUTHENTICATION_ROUTE
import com.example.capstoneproject.navigation.ROOT_ROUTE
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.navigation.nav_graph.authNavGraph
import com.example.capstoneproject.ui.screen.dashboard.DashboardScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SoilDetectorApp(
    modifier: Modifier = Modifier,
    activity: ComponentActivity
) {
    val navAuthController = rememberNavController()

    NavHost(
        navController = navAuthController,
        startDestination = AUTHENTICATION_ROUTE,
        route = ROOT_ROUTE,
        modifier = modifier
    ) {
        authNavGraph(navController = navAuthController)
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                activity = activity,
                signOut = {
                    navAuthController.navigate(ROOT_ROUTE) {
                        popUpTo(Screen.Dashboard.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}