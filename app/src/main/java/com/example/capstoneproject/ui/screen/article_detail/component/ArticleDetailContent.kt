package com.example.capstoneproject.ui.screen.article_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.capstoneproject.R
import com.example.capstoneproject.components.TopBar
import com.example.capstoneproject.data.remote.response.ArticleItem
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.lightGray
import com.example.capstoneproject.util.Constants.ARTICLE_DETAIL_TITLE

@Composable
fun ArticleDetailContent(
    modifier: Modifier = Modifier,
    article: ArticleItem,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(title = ARTICLE_DETAIL_TITLE, navigateBack = { navigateBack() })
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = modifier
                    .padding(15.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
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
                            fontSize = 10.sp
                        )
                    }
                }
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp),
                    text = article.judul,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 18.sp,
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = article.tanggal,
                    color = lightGray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start
                )
                AsyncImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .padding(top = 20.dp, bottom = 20.dp),
                    model = article.gambar,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = article.deskripsi,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}