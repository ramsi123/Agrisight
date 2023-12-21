package com.example.agrisight.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.agrisight.R
import com.example.agrisight.data.remote.response.ArticlesItem
import com.example.agrisight.ui.theme.colorPrimary
import com.example.agrisight.ui.theme.lightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleItem(
    modifier: Modifier = Modifier,
    article: ArticlesItem,
    onCLick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        onClick = {
            onCLick(article.id)
        }
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
                        text = article.kategori,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_medium)),
                        fontSize = 8.sp
                    )
                }
                Text(
                    modifier = modifier.padding(top = 5.dp, bottom = 3.dp),
                    text = article.judul,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 14.sp,
                    lineHeight = 16.sp
                )
                Text(
                    text = article.tanggal,
                    color = lightGray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 12.sp
                )
            }
            AsyncImage(
                modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape),
                model = article.gambar,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleItemPreview() {
    ArticleItem(
        article = ArticlesItem(
            kategori = "Teknologi",
            id = "1",
            tanggal = "2021-05-15 07:01:20",
            deskripsi = "Mewujudkan Digital Farming Bersama Soil Detector Team",
            judul = "Mewujudkan Digital Farming Bersama Soil Detector Team",
            gambar = "R.drawable.digital_farming"
        ),
        onCLick = {}
    )
}