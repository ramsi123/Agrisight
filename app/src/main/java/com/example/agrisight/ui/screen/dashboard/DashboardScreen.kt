package com.example.agrisight.ui.screen.dashboard

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.agrisight.components.BottomBar
import com.example.agrisight.components.FloatingActionButton
import com.example.agrisight.ui.screen.dashboard.component.TopBarDashboard
import com.example.agrisight.navigation.BASE_ROUTE
import com.example.agrisight.navigation.DASHBOARD_ROUTE
import com.example.agrisight.navigation.Screen
import com.example.agrisight.navigation.nav_graph.dashboardNavGraph
import com.example.agrisight.util.Constants.PROFILE_SCREEN
import com.example.agrisight.util.Constants.TITLE
import com.example.agrisight.util.Constants.TOOLS_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    activity: ComponentActivity,
    signOut: () -> Unit
) {
    val navDashboardController = rememberNavController()
    val navBackStackEntry by navDashboardController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute == Screen.Home.route || currentRoute == Screen.Tools.route || currentRoute == Screen.Profile.route) {
                val title = when (currentRoute) {
                    Screen.Home.route -> TITLE
                    Screen.Tools.route -> TOOLS_SCREEN
                    else -> PROFILE_SCREEN
                }
                TopBarDashboard(title = title)
            }
        },
        bottomBar = {
            if (currentRoute == Screen.Home.route || currentRoute == Screen.Tools.route || currentRoute == Screen.Profile.route) {
                BottomBar(navController = navDashboardController)
            }
        },
        floatingActionButton = {
            if (currentRoute == Screen.Home.route) {
                FloatingActionButton(onCameraClick = {
                    navDashboardController.navigate(Screen.Camera.route)
                })
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navDashboardController,
            startDestination = DASHBOARD_ROUTE,
            route = BASE_ROUTE,
            modifier = modifier.padding(innerPadding)
        ) {
            dashboardNavGraph(
                navController = navDashboardController,
                activity = activity,
                signOut = signOut
            )
        }
    }
}