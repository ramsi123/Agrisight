package com.example.capstoneproject.ui.screen.article_list.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.capstoneproject.components.SearchBar
import com.example.capstoneproject.data.model.Article
import com.example.capstoneproject.components.TopBar
import com.example.capstoneproject.util.Constants.SEARCH_BAR_ARTICLE_LIST

@Composable
fun ArticleListContent(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    query: String,
    onQueryChange: (String) -> Unit,
    articles: List<Article>,
    screenTitle: String,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(title = screenTitle, navigateBack = { navigateBack() })
        }
    ) { innerPadding ->
        LazyColumn(
            state = listState,
            contentPadding = innerPadding
        ) {
            item {
                SearchBar(query = query, onQueryChange = onQueryChange, placeholder = SEARCH_BAR_ARTICLE_LIST)
            }
            items(items = articles) { article ->
                ArticleListItem(image = article.image, title = article.title, time = article.time, category = article.category)
            }
        }
    }
}