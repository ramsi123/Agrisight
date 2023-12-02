package com.example.capstoneproject.ui.screen.signup

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
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.screen.signup.component.SignUp
import com.example.capstoneproject.ui.screen.signup.component.SignUpContent
import com.example.capstoneproject.util.Constants.EMPTY_STRING
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAuthRepository(LocalContext.current))
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
                    val signInResult = viewModel.signInWithIntent(
                        intent = result.data ?: return@launch
                    )
                    viewModel.onSignInResult(signInResult)
                }
            }
        }
    )

    SignUpContent(
        modifier = modifier,
        email = email,
        onEmailChange = {
            email = it
        },
        password = password,
        onPasswordChange = {
            password = it
        },
        onSignUpWithEmail = { _, _ -> },
        onSignUpWithGoogle = {
            coroutineScope.launch {
                val signInIntentSender = viewModel.signIn()
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
        navigateToSignInScreen = {
            navController.navigate(Screen.SignIn.route) {
                popUpTo(Screen.Welcome.route) {
                    inclusive = false
                }
            }
        }
    )

    SignUp(
        navigateToHomeScreen = {
            navController.popBackStack()
            navController.navigate(Screen.Dashboard.route)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(navController = rememberNavController())
}