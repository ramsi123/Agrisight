package com.example.capstoneproject.ui.screen.article_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.components.TopBar
import com.example.capstoneproject.data.model.Article
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.lightGray
import com.example.capstoneproject.util.Constants.ARTICLE_DETAIL_TITLE

@Composable
fun ArticleDetailContent(
    modifier: Modifier = Modifier,
    article: Article,
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
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = colorPrimary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = modifier.padding(vertical = 4.dp, horizontal = 6.dp),
                        text = article.category,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_medium)),
                        fontSize = 8.sp
                    )
                }
                Text(
                    modifier = modifier.padding(top = 5.dp, bottom = 3.dp),
                    text = article.title,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 14.sp,
                    lineHeight = 16.sp
                )
                Text(
                    text = article.time,
                    color = lightGray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 12.sp
                )
            }
        }
    }
}