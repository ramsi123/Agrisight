package com.example.agrisight.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.agrisight.navigation.AUTHENTICATION_ROUTE
import com.example.agrisight.navigation.Screen
import com.example.agrisight.ui.screen.forgot_password.ForgotPasswordScreen
import com.example.agrisight.ui.screen.signin.SignInScreen
import com.example.agrisight.ui.screen.signup.SignUpScreen
import com.example.agrisight.ui.screen.welcome.WelcomeScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Welcome.route,
        route = AUTHENTICATION_ROUTE
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(Screen.SignIn.route) {
            SignInScreen(navController = navController)
        }
        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(navController = navController)
        }
    }
}