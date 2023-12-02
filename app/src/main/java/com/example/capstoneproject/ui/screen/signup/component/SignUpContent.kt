package com.example.capstoneproject.ui.screen.signup.component

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
import com.example.capstoneproject.ui.theme.dark_gray
import com.example.capstoneproject.ui.theme.ghost_white
import com.example.capstoneproject.ui.theme.gray
import com.example.capstoneproject.ui.theme.light_gray
import com.example.capstoneproject.util.Constants
import com.example.capstoneproject.util.Constants.ALREADY_USER
import com.example.capstoneproject.util.Constants.GOOGLE_SIGN_UP_BUTTON
import com.example.capstoneproject.util.Constants.SIGN_IN
import com.example.capstoneproject.util.Constants.SIGN_UP_BUTTON
import com.example.capstoneproject.util.Constants.SIGN_UP_TITLE
import com.example.capstoneproject.util.Constants.SIGN_UP_TITLE_WORD

@Composable
fun SignUpContent(
    modifier: Modifier = Modifier,
    email: TextFieldValue,
    onEmailChange: (TextFieldValue) -> Unit,
    password: TextFieldValue,
    onPasswordChange: (TextFieldValue) -> Unit,
    onSignUpWithEmail: (String, String) -> Unit,
    onSignUpWithGoogle: () -> Unit,
    navigateBack: () -> Unit,
    navigateToSignInScreen: () -> Unit
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
                        containerColor = ghost_white
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
                            append(SIGN_UP_TITLE)
                            addStyle(
                                style = SpanStyle(
                                    color = dark_gray,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                                ),
                                start = 0,
                                end = SIGN_UP_TITLE.length
                            )
                            addStyle(
                                style = SpanStyle(
                                    color = colorPrimary,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                                ),
                                start = 0,
                                end = SIGN_UP_TITLE_WORD.length
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
                            text = Constants.EMAIL_LABEL,
                            style = MaterialTheme.typography.bodyLarge.copy(color = gray),
                            modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
                        )
                        EmailField(email = email, onEmailValueChange = onEmailChange)

                        Text(
                            text = Constants.PASSWORD_LABEL,
                            style = MaterialTheme.typography.bodyLarge.copy(color = gray),
                            modifier = Modifier.padding(bottom = 10.dp, top = 15.dp)
                        )
                        PasswordField(password = password, onPasswordValueChange = onPasswordChange)

                        Button(
                            onClick = {
                                onSignUpWithEmail(email.text, password.text)
                            },
                            modifier = modifier
                                .padding(top = 30.dp)
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                modifier = modifier.padding(top = 8.dp, bottom = 8.dp),
                                text = SIGN_UP_BUTTON,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Button(
                            onClick = {
                                onSignUpWithGoogle()
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
                                    text = GOOGLE_SIGN_UP_BUTTON,
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
                                text = ALREADY_USER,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = light_gray,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                                )
                            )
                            Text(
                                modifier = modifier.clickable { navigateToSignInScreen() },
                                text = SIGN_IN,
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