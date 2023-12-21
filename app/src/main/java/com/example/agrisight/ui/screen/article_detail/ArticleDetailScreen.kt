package com.example.agrisight.ui.screen.article_detail

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.agrisight.ui.ViewModelFactory
import com.example.agrisight.ui.screen.article_detail.component.ArticleDetailContent
import com.example.agrisight.data.remote.response.ArticleItem
import com.example.agrisight.di.Injection
import com.example.agrisight.ui.common.UiState

@Composable
fun ArticleDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ArticleDetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    articleId: String
) {
    val context = LocalContext.current
    var article = ArticleItem(kategori = "", id = "", deskripsi = "", tanggal = "", judul = "", gambar = "")
    
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