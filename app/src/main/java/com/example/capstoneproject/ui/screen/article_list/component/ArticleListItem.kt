package com.example.capstoneproject.ui.screen.article_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.capstoneproject.R
import com.example.capstoneproject.data.remote.response.ArticlesItem
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.lightGray

@Composable
fun ArticleListItem(
    modifier: Modifier = Modifier,
    article: ArticlesItem,
    onClicked: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClicked(article.id)
            }
            .padding(vertical = 12.dp, horizontal = 15.dp),
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