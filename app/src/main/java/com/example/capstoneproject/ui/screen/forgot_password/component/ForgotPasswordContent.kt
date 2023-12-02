package com.example.capstoneproject.ui.screen.forgot_password.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.SpanStyle
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
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.dark_gray
import com.example.capstoneproject.ui.theme.ghost_white
import com.example.capstoneproject.ui.theme.gray
import com.example.capstoneproject.util.Constants
import com.example.capstoneproject.util.Constants.FORGOT_PASSWORD_TITLE
import com.example.capstoneproject.util.Constants.FORGOT_PASSWORD_TITLE_WORD
import com.example.capstoneproject.util.Constants.RESET_PASSWORD_BUTTON

@Composable
fun ForgotPasswordContent(
    modifier: Modifier = Modifier,
    email: TextFieldValue,
    onEmailChange: (TextFieldValue) -> Unit,
    onResetPassword: (String) -> Unit,
    navigateBack: () -> Unit
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
                            append(FORGOT_PASSWORD_TITLE)
                            addStyle(
                                style = SpanStyle(
                                    color = dark_gray,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                                ),
                                start = 0,
                                end = FORGOT_PASSWORD_TITLE.length
                            )
                            addStyle(
                                style = SpanStyle(
                                    color = colorPrimary,
                                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                                ),
                                start = FORGOT_PASSWORD_TITLE.indexOf(FORGOT_PASSWORD_TITLE_WORD),
                                end = FORGOT_PASSWORD_TITLE.length
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

                        Button(
                            onClick = { onResetPassword(email.text) },
                            modifier = modifier
                                .padding(top = 30.dp)
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                modifier = modifier.padding(top = 8.dp, bottom = 8.dp),
                                text = RESET_PASSWORD_BUTTON,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
    }
}