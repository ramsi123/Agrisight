package com.example.capstoneproject.ui.screen.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.components.ArticleItem
import com.example.capstoneproject.data.model.Article

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: List<Article>,
    onCLick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier.heightIn(max = 520.dp),
        contentPadding = PaddingValues(bottom = 4.dp)
    ) {
        items(articles) { article ->
            ArticleItem(
                article = article,
                onCLick = onCLick
            )
        }
    }
}