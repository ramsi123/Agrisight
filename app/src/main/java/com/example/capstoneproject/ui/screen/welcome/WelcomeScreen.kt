package com.example.capstoneproject.ui.screen.welcome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.screen.welcome.component.WelcomeContent

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    viewModel: WelcomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAuthRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    // check current user
    LaunchedEffect(key1 = Unit) {
        if (viewModel.getSignedInUser() != null) {
            navController.navigate(Screen.Dashboard.route)
        }
    }

    WelcomeContent(
        modifier = modifier,
        navigateToSignUpScreen = {
            navController.navigate(Screen.SignUp.route)
        },
        navigateToSignInScreen = {
            navController.navigate(Screen.SignIn.route)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}





















