package com.example.capstoneproject.ui.screen.welcome.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.ghost_white
import com.example.capstoneproject.util.Constants.SIGN_IN_BUTTON
import com.example.capstoneproject.util.Constants.SIGN_UP_BUTTON
import com.example.capstoneproject.util.Constants.TITLE

@Composable
fun WelcomeContent(
    modifier: Modifier = Modifier,
    navigateToSignUpScreen: () -> Unit,
    navigateToSignInScreen: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = colorPrimary)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.wrapContentWidth(),
                bitmap = ImageBitmap.imageResource(id = R.drawable.flower_logo),
                contentDescription = "header_view_soil_logo"
            )
            Text(
                text = TITLE,
                color = Color.White,
                style = TextStyle(
                    fontSize = 40.sp,
                    fontFamily = FontFamily(Font(R.font.josefin_sans_semibold_italic)),
                    letterSpacing = 2.sp
                )
            )
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 10.dp),
                onClick = navigateToSignUpScreen,
                colors = ButtonDefaults.buttonColors(containerColor = ghost_white)
            ) {
                Text(
                    modifier = modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    text = SIGN_UP_BUTTON,
                    color = colorPrimary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Button(
                modifier = modifier.fillMaxWidth(),
                onClick = navigateToSignInScreen,
                colors = ButtonDefaults.buttonColors(containerColor = ghost_white)
            ) {
                Text(
                    modifier = modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    text = SIGN_IN_BUTTON,
                    color = colorPrimary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}