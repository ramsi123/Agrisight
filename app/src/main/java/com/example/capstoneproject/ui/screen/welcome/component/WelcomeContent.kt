package com.example.capstoneproject.ui.screen.welcome.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.ghostWhite
import com.example.capstoneproject.util.Constants.SIGN_IN_BUTTON
import com.example.capstoneproject.util.Constants.SIGN_UP_BUTTON
import com.example.capstoneproject.util.Constants.TITLE
import com.example.capstoneproject.util.Constants.WELCOME_DESCRIPTION
import com.example.capstoneproject.util.Constants.WELCOME_PICTURE

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
                .background(ghostWhite)
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(bottom = 50.dp),
                bitmap = ImageBitmap.imageResource(id = R.drawable.soil),
                contentDescription = WELCOME_PICTURE
            )
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                text = TITLE,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    letterSpacing = 1.sp
                ),
                textAlign = TextAlign.Start
            )
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp),
                text = WELCOME_DESCRIPTION,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                ),
                textAlign = TextAlign.Start,
                lineHeight = 20.sp
            )
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                onClick = navigateToSignUpScreen,
                colors = ButtonDefaults.buttonColors(containerColor = colorPrimary, contentColor = ghostWhite),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    modifier = modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    text = SIGN_UP_BUTTON,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Button(
                modifier = modifier.fillMaxWidth(),
                onClick = navigateToSignInScreen,
                colors = ButtonDefaults.buttonColors(containerColor = colorPrimary, contentColor = ghostWhite),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    modifier = modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    text = SIGN_IN_BUTTON,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}