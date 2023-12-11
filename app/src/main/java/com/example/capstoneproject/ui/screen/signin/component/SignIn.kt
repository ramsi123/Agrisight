package com.example.capstoneproject.ui.screen.signin.component

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.common.UiState
import com.example.capstoneproject.ui.screen.signin.SignInViewModel

@Composable
fun SignIn(
    viewModel: SignInViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    navigateToHomeScreen: () -> Unit
) {
    val context = LocalContext.current
    val signInGoogleState by viewModel.googleAccountState.collectAsStateWithLifecycle()
    val signInEmailState = viewModel.signInWithEmailAndPasswordResponse

    // Error handling for sign in with google
    LaunchedEffect(key1 = signInGoogleState.signInError) {
        signInGoogleState.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // Success handling for sign in with google
    LaunchedEffect(key1 = signInGoogleState.isSignInSuccessful) {
        if (signInGoogleState.isSignInSuccessful) {
            Toast.makeText(
                context,
                "Sign In Success",
                Toast.LENGTH_LONG
            ).show()

            navigateToHomeScreen()
            viewModel.resetGoogleAccountState()
        }
    }

    // handling for sign in with email and password
    LaunchedEffect(key1 = signInEmailState) {
        when (signInEmailState) {
            is UiState.Idle -> {}
            is UiState.Loading -> {}
            is UiState.Success -> {
                Toast.makeText(context, "Sign In Success", Toast.LENGTH_SHORT).show()
            }
            is UiState.Error -> signInEmailState.apply {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}