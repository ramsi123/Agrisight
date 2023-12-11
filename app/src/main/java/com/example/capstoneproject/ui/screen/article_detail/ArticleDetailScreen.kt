package com.example.capstoneproject.ui.screen.article_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.screen.article_detail.component.ArticleDetailContent

@Composable
fun ArticleDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ArticleDetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    articleId: String
) {
    viewModel.getArticle(articleId)
    val article by viewModel.article.collectAsState()

    ArticleDetailContent(
        modifier = modifier,
        article = article,
        navigateBack = {
            navController.navigateUp()
        }
    )
}