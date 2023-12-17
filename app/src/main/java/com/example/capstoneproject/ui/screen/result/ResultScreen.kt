package com.example.capstoneproject.ui.screen.result

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.data.remote.response.PlantsItem
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.common.UiState
import com.example.capstoneproject.ui.screen.result.component.ResultContent

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    viewModel: ResultViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    navController: NavHostController,
    title: String,
    score: Float
) {
    val context = LocalContext.current
    val formattedScore = String.format("%.2f", score * 100).toDouble()
    var plants: List<PlantsItem> = emptyList()

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

    ResultContent(
        title = title,
        score = formattedScore,
        plants = plants,
        navigateBack = {
            navController.navigateUp()
        },
        navigateToPlantDetailScreen = { plantId ->
            navController.navigate(Screen.PlantDetail.plantDetailRoute(plantId))
        }
    )
}