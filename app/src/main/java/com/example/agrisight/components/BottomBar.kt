package com.example.agrisight.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.agrisight.navigation.NavigationItem
import com.example.agrisight.navigation.Screen
import com.example.agrisight.ui.theme.colorPrimary
import com.example.agrisight.util.Constants.HOME_SCREEN
import com.example.agrisight.util.Constants.PROFILE_SCREEN
import com.example.agrisight.util.Constants.TOOLS_SCREEN

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        val navigationItems = listOf(
            NavigationItem(
                title = HOME_SCREEN,
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = TOOLS_SCREEN,
                icon = Icons.Default.Work,
                screen = Screen.Tools
            ),
            NavigationItem(
                title = PROFILE_SCREEN,
                icon = Icons.Default.Person,
                screen = Screen.Profile
            )
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}