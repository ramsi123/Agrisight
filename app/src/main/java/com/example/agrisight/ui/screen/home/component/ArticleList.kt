package com.example.agrisight.ui.screen.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.agrisight.components.ArticleItem
import com.example.agrisight.data.remote.response.ArticlesItem

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: List<ArticlesItem>,
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