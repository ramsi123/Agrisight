package com.example.agrisight.ui.screen.signin

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agrisight.ui.ViewModelFactory
import com.example.agrisight.di.Injection
import com.example.agrisight.navigation.Screen
import com.example.agrisight.ui.screen.signin.component.SignIn
import com.example.agrisight.ui.screen.signin.component.SignInContent
import com.example.agrisight.util.Constants.EMPTY_STRING
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    val coroutineScope = rememberCoroutineScope()
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(EMPTY_STRING)
            )
        }
    )
    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(EMPTY_STRING)
            )
        }
    )

    // to show pop up filled with google account option
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            if (result.resultCode == ComponentActivity.RESULT_OK) {
                coroutineScope.launch {
                    val signInResult = viewModel.signInWithIntentGoogle(
                        intent = result.data ?: return@launch
                    )
                    viewModel.onSignInGoogleResult(signInResult)
                }
            }
        }
    )

    SignInContent(
        modifier = modifier,
        email = email,
        onEmailChange = {
            email = it
        },
        password = password,
        onPasswordChange = {
            password = it
        },
        onSignInWithEmail = { email, password ->
            viewModel.signInWithEmail(email, password)
        },
        onSignInWithGoogle = {
            coroutineScope.launch {
                val signInIntentSender = viewModel.signInGoogle()
                launcher.launch(
                    IntentSenderRequest.Builder(
                        signInIntentSender ?: return@launch
                    ).build()
                )
            }
        },
        navigateBack = {
            navController.navigateUp()
        },
        navigateToForgotPasswordScreen = {
            navController.navigate(Screen.ForgotPassword.route)
        },
        navigateToSignUpScreen = {
            navController.navigate(Screen.SignUp.route) {
                popUpTo(Screen.Welcome.route) {
                    inclusive = false
                }
            }
        }
    )

    SignIn(
        navigateToHomeScreen = {
            navController.navigate(Screen.Dashboard.route) {
                popUpTo(Screen.Welcome.route) {
                    inclusive = true
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(navController = rememberNavController())
}