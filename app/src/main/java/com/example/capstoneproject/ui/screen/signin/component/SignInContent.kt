package com.example.capstoneproject.ui.screen.signin.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.capstoneproject.R
import com.example.capstoneproject.components.AuthHeaderView
import com.example.capstoneproject.components.EmailField
import com.example.capstoneproject.components.PasswordField
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.darkGray
import com.example.capstoneproject.ui.theme.ghostWhite
import com.example.capstoneproject.ui.theme.gray
import com.example.capstoneproject.ui.theme.lightGray
import com.example.capstoneproject.util.Constants.EMAIL_LABEL
import com.example.capstoneproject.util.Constants.FORGOT_PASSWORD
import com.example.capstoneproject.util.Constants.GOOGLE_SIGN_IN_BUTTON
import com.example.capstoneproject.util.Constants.NO_ACCOUNT
import com.example.capstoneproject.util.Constants.PASSWORD_LABEL
import com.example.capstoneproject.util.Constants.SIGN_IN_BUTTON
import com.example.capstoneproject.util.Constants.SIGN_IN_TITLE
import com.example.capstoneproject.util.Constants.SIGN_IN
import com.example.capstoneproject.util.Constants.SIGN_UP

@Composable
fun SignInContent(
    modifier: Modifier = Modifier,
    email: TextFieldValue,
    onEmailChange: (TextFieldValue) -> Unit,
    password: TextFieldValue,
    onPasswordChange: (TextFieldValue) -> Unit,
    onSignInWithEmail: (String, String) -> Unit,
    onSignInWithGoogle: () -> Unit,
    navigateBack: () -> Unit,
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ConstraintLayout {
                val (image, signInForm) = createRefs()
                Box(
                    modifier = modifier
                        .constrainAs(image) {
                            top.linkTo(signInForm.top)
                            bottom.linkTo(signInForm.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                    AuthHeaderView()
                    IconButton(
                        modifier = modifier.padding(start = 8.dp, top = 8.dp),
                        onClick = {
                            navigateBack()
                        },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
                Card(
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = ghostWhite
                    ),
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 50.dp)
                        .constrainAs(signInForm) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                ) {
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(30.dp)
                    ) {

                        val signInAnnotatedString = buildAnnotatedString {
                            append(SIGN_IN_TITLE)
                            addStyle(
                                style = SpanStyle(
                                    color = darkGray,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                                ),
                                start = 0,
                                end = SIGN_IN_TITLE.length
                            )
                            addStyle(
                                style = SpanStyle(
                                    color = colorPrimary,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                                ),
                                start = 0,
                                end = SIGN_IN.length
                            )
                        }

                        Text(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 20.dp),
                            text = signInAnnotatedString,
                            textAlign = TextAlign.Center,
                            fontSize = 22.sp,
                        )

                        Text(
                            text = EMAIL_LABEL,
                            style = MaterialTheme.typography.bodyLarge.copy(color = gray),
                            modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
                        )
                        EmailField(email = email, onEmailValueChange = onEmailChange)

                        Text(
                            text = PASSWORD_LABEL,
                            style = MaterialTheme.typography.bodyLarge.copy(color = gray),
                            modifier = Modifier.padding(bottom = 10.dp, top = 15.dp)
                        )
                        PasswordField(password = password, onPasswordValueChange = onPasswordChange)

                        Text(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                                .clickable { navigateToForgotPasswordScreen() },
                            text = FORGOT_PASSWORD,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.bodyMedium.copy(color = colorPrimary)
                        )
                        Button(
                            onClick = {
                                onSignInWithEmail(email.text, password.text)
                            },
                            modifier = modifier
                                .padding(top = 30.dp)
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                modifier = modifier.padding(top = 8.dp, bottom = 8.dp),
                                text = SIGN_IN_BUTTON,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Button(
                            onClick = {
                                onSignInWithGoogle()
                            },
                            modifier = modifier
                                .padding(top = 5.dp, bottom = 34.dp)
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = modifier
                                        .size(16.dp),
                                    painter = painterResource(id = R.drawable.ic_google),
                                    contentDescription = null
                                )
                                Text(
                                    modifier = modifier.padding(start = 8.dp,top = 8.dp, bottom = 8.dp),
                                    text = GOOGLE_SIGN_IN_BUTTON,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }

                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = modifier.padding(end = 4.dp),
                                text = NO_ACCOUNT,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = lightGray,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                                )
                            )
                            Text(
                                modifier = modifier.clickable { navigateToSignUpScreen() },
                                text = SIGN_UP,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = colorPrimary,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}