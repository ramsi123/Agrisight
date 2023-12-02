package com.example.capstoneproject.ui.screen.forgot_password

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.capstoneproject.ui.screen.forgot_password.component.ForgotPasswordContent
import com.example.capstoneproject.util.Constants.EMPTY_STRING

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
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
        onResetPassword = {},
        navigateBack = {
            navController.navigateUp()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(navController = rememberNavController())
}