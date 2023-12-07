package com.example.capstoneproject.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.ViewModelFactory
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
    val plants by viewModel.plants.collectAsState()
    val articles by viewModel.articles.collectAsState()

    HomeContent(
        modifier = modifier,
        plants = plants,
        articles = articles,
        navigateToPlantListScreen = {
            navController.navigate(Screen.PlantList.route)
        },
        navigateToArticleListScreen = {
            navController.navigate(Screen.ArticleList.route)
        }
    )
}