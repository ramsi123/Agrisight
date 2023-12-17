package com.example.capstoneproject.ui.screen.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.remote.response.ArticlesItem
import com.example.capstoneproject.data.remote.response.PlantsItem
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
    var plants: List<PlantsItem> = emptyList()
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

    // get plants
    viewModel.plants.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getPlants()
            }
            is UiState.Success -> {
                plants = uiState.data
            }
            is UiState.Error -> {
                Toast.makeText(context, uiState.errorMessage, Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    HomeContent(
        modifier = modifier,
        plants = plants,
        articles = articles,
        navigateToPlantListScreen = {
            navController.navigate(Screen.PlantList.route)
        },
        navigateToPlantDetailScreen = { plantId ->
            navController.navigate(Screen.PlantDetail.plantDetailRoute(plantId))
        },
        navigateToArticleListScreen = {
            navController.navigate(Screen.ArticleList.route)
        },
        navigateToArticleDetailScreen = { articleId ->
            navController.navigate(Screen.ArticleDetail.articleDetailRoute(articleId))
        }
    )
}