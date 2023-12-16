package com.example.capstoneproject.ui.screen.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.remote.response.ArticlesItem
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.common.UiState
import com.example.capstoneproject.ui.screen.home.component.HomeContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    val context = LocalContext.current
    val plants by viewModel.plants.collectAsState()
    var articles: List<ArticlesItem> = emptyList()

    // collect articles data
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

    // get plants
    LaunchedEffect(key1 = true) {
        viewModel.getPlants()
    }

    // get articles
    LaunchedEffect(key1 = true) {
        viewModel.getArticles()
    }

    HomeContent(
        modifier = modifier,
        plants = plants,
        articles = articles,
        navigateToPlantListScreen = {
            navController.navigate(Screen.PlantList.route)
        },
        navigateToArticleListScreen = {
            navController.navigate(Screen.ArticleList.route)
        },
        navigateToArticleDetailScreen = { articleId ->
            navController.navigate(Screen.ArticleDetail.articleDetailRoute(articleId))
        }
    )
}