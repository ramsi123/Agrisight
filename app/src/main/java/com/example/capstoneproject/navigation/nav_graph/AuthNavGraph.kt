package com.example.capstoneproject.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.capstoneproject.navigation.AUTHENTICATION_ROUTE
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.screen.forgot_password.ForgotPasswordScreen
import com.example.capstoneproject.ui.screen.signin.SignInScreen
import com.example.capstoneproject.ui.screen.signup.SignUpScreen
import com.example.capstoneproject.ui.screen.welcome.WelcomeScreen

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