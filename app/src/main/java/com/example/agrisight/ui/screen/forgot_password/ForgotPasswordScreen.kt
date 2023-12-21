package com.example.agrisight.ui.screen.forgot_password

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.agrisight.ui.ViewModelFactory
import com.example.agrisight.components.ProgressBar
import com.example.agrisight.di.Injection
import com.example.agrisight.ui.common.UiState
import com.example.agrisight.ui.screen.forgot_password.component.ForgotPasswordContent
import com.example.agrisight.util.Constants.EMPTY_STRING

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ForgotPasswordViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    )
) {
    val context = LocalContext.current
    val resetPasswordState = viewModel.resetPasswordState
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(EMPTY_STRING)
            )
        }
    )

    ForgotPasswordContent(
        modifier = modifier,
        email = email,
        onEmailChange = {
            email = it
        },
        onResetPassword = { email ->
            viewModel.resetPassword(email)
        },
        navigateBack = {
            navController.navigateUp()
        }
    )

    // handling for reset password
    when (resetPasswordState) {
        is UiState.Idle -> {
            Unit
        }
        is UiState.Loading -> {
            ProgressBar()
        }
        is UiState.Success -> {
            LaunchedEffect(key1 = resetPasswordState) {
                Toast.makeText(context, "Email sent", Toast.LENGTH_SHORT).show()
            }
        }
        is UiState.Error -> resetPasswordState.apply {
            LaunchedEffect(key1 = resetPasswordState) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(navController = rememberNavController())
}