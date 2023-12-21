package com.example.agrisight.ui.screen.article_list

import android.widget.Toast
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.agrisight.ui.ViewModelFactory
import com.example.agrisight.data.remote.response.ArticlesItem
import com.example.agrisight.di.Injection
import com.example.agrisight.navigation.Screen
import com.example.agrisight.ui.common.UiState
import com.example.agrisight.ui.screen.article_list.component.ArticleListContent

@Composable
fun ArticleListScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleListViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    val listState = rememberLazyListState()
    val query by viewModel.query
    val context = LocalContext.current
    var articles: List<ArticlesItem> = emptyList()

    // get articles
    viewModel.articles.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getArticles()
            }
            is UiState.Success -> {
                articles = uiState.data
            }
            is UiState.Error -> {
                Toast.makeText(context, uiState.errorMessage, Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    ArticleListContent(
        modifier = modifier,
        listState = listState,
        query = query,
        onQueryChange = {},
        articles = articles,
        onClicked = { articleId ->
            navController.navigate(Screen.ArticleDetail.articleDetailRoute(articleId))
        },
        navigateBack = { navController.navigateUp() }
    )
}