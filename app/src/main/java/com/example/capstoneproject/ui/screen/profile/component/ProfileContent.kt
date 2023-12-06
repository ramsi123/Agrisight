package com.example.capstoneproject.ui.screen.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.ghostWhite

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
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
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Profile Screen",
                    color = Color.Black
                )
                Button(onClick = signOut) {
                    Text(
                        text = "Sign Out"
                    )
                }
            }
        }
    }
}