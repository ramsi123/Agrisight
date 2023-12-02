package com.example.capstoneproject.ui.screen.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.capstoneproject.components.BottomBar
import com.example.capstoneproject.components.TopBar
import com.example.capstoneproject.navigation.BASE_ROUTE
import com.example.capstoneproject.navigation.DASHBOARD_ROUTE
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.navigation.nav_graph.dashboardNavGraph
import com.example.capstoneproject.util.Constants.PROFILE_SCREEN
import com.example.capstoneproject.util.Constants.TITLE
import com.example.capstoneproject.util.Constants.TOOLS_SCREEN

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    signOut: () -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            val title = when (currentRoute) {
                Screen.Home.route -> TITLE
                Screen.Tools.route -> TOOLS_SCREEN
                else -> PROFILE_SCREEN
            }
            TopBar(title = title)
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = DASHBOARD_ROUTE,
            route = BASE_ROUTE,
            modifier = modifier.padding(innerPadding)
        ) {
            dashboardNavGraph(navController = navController, signOut = signOut)
        }
    }
}