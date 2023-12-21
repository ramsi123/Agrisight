package com.example.agrisight.navigation

import com.example.agrisight.util.Constants.ARTICLE_DETAIL_SCREEN
import com.example.agrisight.util.Constants.ARTICLE_LIST_SCREEN
import com.example.agrisight.util.Constants.CAMERA_SCREEN
import com.example.agrisight.util.Constants.DASHBOARD_SCREEN
import com.example.agrisight.util.Constants.FORGOT_PASSWORD_SCREEN
import com.example.agrisight.util.Constants.HOME_SCREEN
import com.example.agrisight.util.Constants.PLANT_DETAIL_SCREEN
import com.example.agrisight.util.Constants.PLANT_LIST_SCREEN
import com.example.agrisight.util.Constants.PROFILE_SCREEN
import com.example.agrisight.util.Constants.RESULT_SCREEN
import com.example.agrisight.util.Constants.SIGN_IN_SCREEN
import com.example.agrisight.util.Constants.SIGN_UP_SCREEN
import com.example.agrisight.util.Constants.TOOLS_SCREEN
import com.example.agrisight.util.Constants.WELCOME_SCREEN

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
    object Camera : Screen(CAMERA_SCREEN)
    object Result : Screen("$RESULT_SCREEN/{title}/{score}") {
        fun resultRoute(title: String, score: Float) = "$RESULT_SCREEN/$title/$score"
    }
    object PlantList : Screen(PLANT_LIST_SCREEN)
    object PlantDetail : Screen("$PLANT_DETAIL_SCREEN/{id}") {
        fun plantDetailRoute(id: String) = "$PLANT_DETAIL_SCREEN/$id"
    }
    object ArticleList : Screen(ARTICLE_LIST_SCREEN)
    object ArticleDetail : Screen("$ARTICLE_DETAIL_SCREEN/{id}") {
        fun articleDetailRoute(id: String) = "$ARTICLE_DETAIL_SCREEN/$id"
    }
}
