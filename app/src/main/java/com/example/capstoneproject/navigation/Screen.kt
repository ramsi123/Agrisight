package com.example.capstoneproject.navigation

import com.example.capstoneproject.util.Constants.DASHBOARD_SCREEN
import com.example.capstoneproject.util.Constants.FORGOT_PASSWORD_SCREEN
import com.example.capstoneproject.util.Constants.HOME_SCREEN
import com.example.capstoneproject.util.Constants.PROFILE_SCREEN
import com.example.capstoneproject.util.Constants.SIGN_IN_SCREEN
import com.example.capstoneproject.util.Constants.SIGN_UP_SCREEN
import com.example.capstoneproject.util.Constants.TOOLS_SCREEN
import com.example.capstoneproject.util.Constants.WELCOME_SCREEN

const val ROOT_ROUTE = "root_route"
const val AUTHENTICATION_ROUTE = "authentication_route"
const val BASE_ROUTE = "base_route"
const val DASHBOARD_ROUTE = "dashboard_route"

sealed class Screen(val route: String) {
    object Welcome : Screen(WELCOME_SCREEN)
    object SignUp : Screen(SIGN_UP_SCREEN)
    object SignIn : Screen(SIGN_IN_SCREEN)
    object ForgotPassword : Screen(FORGOT_PASSWORD_SCREEN)
    object Dashboard : Screen(DASHBOARD_SCREEN)
    object Home : Screen(HOME_SCREEN)
    object Tools : Screen(TOOLS_SCREEN)
    object Profile : Screen(PROFILE_SCREEN)
}
