package com.example.capstoneproject.ui.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.light_gray

@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    image: Int,
    title: String,
    time: String,
    category: String
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Box(
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = colorPrimary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = modifier.padding(vertical = 4.dp, horizontal = 6.dp),
                        text = category,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_medium)),
                        fontSize = 8.sp
                    )
                }
                Text(
                    text = title,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 14.sp,
                    lineHeight = 16.sp
                )
                Text(
                    text = time,
                    color = light_gray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 12.sp
                )
            }
            Image(
                modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(image),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleItemPreview() {
    ArticleItem(
        image = R.drawable.garden,
        title = "Mewujudkan Digital Farming Bersama Soil Detector Team",
        time = "2021-05-15 07:01:20",
        category = "Teknologi"
    )
}