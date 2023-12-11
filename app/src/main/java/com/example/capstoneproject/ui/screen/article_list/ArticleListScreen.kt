package com.example.capstoneproject.ui.screen.article_list

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.screen.article_list.component.ArticleListContent

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
    val articles by viewModel.articles.collectAsState()

    ArticleListContent(
        modifier = modifier,
        listState = listState,
        query = query,
        onQueryChange = {
            viewModel.searchArticles(newQuery = it)
        },
        articles = articles,
        onClicked = { articleId ->
            navController.navigate(Screen.ArticleDetail.articleDetailRoute(articleId))
        },
        navigateBack = { navController.navigateUp() }
    )
}