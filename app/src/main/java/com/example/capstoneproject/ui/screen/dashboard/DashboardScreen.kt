package com.example.capstoneproject.ui.screen.dashboard

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.capstoneproject.components.BottomBar
import com.example.capstoneproject.components.FloatingActionButton
import com.example.capstoneproject.components.TopBar
import com.example.capstoneproject.navigation.BASE_ROUTE
import com.example.capstoneproject.navigation.DASHBOARD_ROUTE
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.navigation.nav_graph.dashboardNavGraph
import com.example.capstoneproject.util.Constants.PROFILE_SCREEN
import com.example.capstoneproject.util.Constants.RESULT_SCREEN
import com.example.capstoneproject.util.Constants.TITLE
import com.example.capstoneproject.util.Constants.TOOLS_SCREEN

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    activity: ComponentActivity,
    signOut: () -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute != Screen.Camera.route) {
                val title = when (currentRoute) {
                    Screen.Home.route -> TITLE
                    Screen.Tools.route -> TOOLS_SCREEN
                    Screen.Profile.route -> PROFILE_SCREEN
                    else -> RESULT_SCREEN
                }
                TopBar(title = title)
            }
        },
        bottomBar = {
            if (currentRoute != Screen.Camera.route && currentRoute != Screen.Result.route) {
                BottomBar(navController = navController)
            }
        },
        floatingActionButton = {
            if (currentRoute == Screen.Home.route) {
                FloatingActionButton(onCameraClick = {
                    navController.navigate(Screen.Camera.route)
                })
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = DASHBOARD_ROUTE,
            route = BASE_ROUTE,
            modifier = modifier.padding(innerPadding)
        ) {
            dashboardNavGraph(
                navController = navController,
                activity = activity,
                signOut = signOut
            )
        }
    }
}