package com.example.agrisight.ui.screen.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.agrisight.R
import com.example.agrisight.ui.theme.colorPrimary
import com.example.agrisight.ui.theme.ghostWhite
import com.example.agrisight.ui.screen.signin.component.UserData
import com.example.agrisight.util.Constants.PROFILE_PICTURE
import com.example.agrisight.util.Constants.SIGN_OUT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    user: UserData,
    signOut: () -> Unit
) {
    Surface(modifier = modifier.fillMaxSize(), color = colorPrimary) {
        Card(
            colors = CardDefaults.cardColors(containerColor = ghostWhite),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (user.profilePictureUrl.isNullOrEmpty()) {
                    Image(
                        modifier = modifier.size(100.dp),
                        imageVector = Icons.Default.Person,
                        contentDescription = PROFILE_PICTURE
                    )
                } else {
                    AsyncImage(
                        modifier = modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        model = user.profilePictureUrl,
                        contentDescription = PROFILE_PICTURE,
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    modifier = modifier.padding(top = 10.dp, bottom = 15.dp),
                    text = user.email ?: "",
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 22.sp
                )
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    onClick = signOut,
                    colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = SIGN_OUT
                        )
                        Text(
                            text = SIGN_OUT,
                            fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
                        )
                    }
                }
            }
        }
    }
}