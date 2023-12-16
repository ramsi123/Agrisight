package com.example.capstoneproject.ui.screen.article_detail

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.data.remote.response.ArticleItem
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.common.UiState
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
    //viewModel.getDetailArticle(articleId)
    //val article by viewModel.article.collectAsState()
    val context = LocalContext.current
    var article: ArticleItem = ArticleItem(kategori = "", id = "", deskripsi = "", tanggal = "", judul = "", gambar = "")
    
    viewModel.article.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getDetailArticle(articleId)
            }
            is UiState.Success -> {
                article = uiState.data
            }
            is UiState.Error -> {
                Toast.makeText(context, uiState.errorMessage, Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    ArticleDetailContent(
        modifier = modifier,
        article = article,
        navigateBack = {
            navController.navigateUp()
        }
    )
}