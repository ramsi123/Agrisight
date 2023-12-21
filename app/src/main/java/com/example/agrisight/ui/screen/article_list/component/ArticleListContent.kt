package com.example.agrisight.ui.screen.article_list.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.agrisight.components.SearchBar
import com.example.agrisight.components.TopBar
import com.example.agrisight.data.remote.response.ArticlesItem
import com.example.agrisight.util.Constants.ARTICLE_LIST_TITLE
import com.example.agrisight.util.Constants.SEARCH_BAR_ARTICLE_LIST

@Composable
fun ArticleListContent(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    query: String,
    onQueryChange: (String) -> Unit,
    articles: List<ArticlesItem>,
    onClicked: (String) -> Unit,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(title = ARTICLE_LIST_TITLE, navigateBack = { navigateBack() })
        }
    ) { innerPadding ->
        LazyColumn(
            state = listState,
            contentPadding = innerPadding
        ) {
            item {
                SearchBar(
                    query = query,
                    onQueryChange = onQueryChange,
                    placeholder = SEARCH_BAR_ARTICLE_LIST
                )
            }
            items(items = articles) { article ->
                ArticleListItem(
                    article = article,
                    onClicked = onClicked
                )
            }
        }
    }
}