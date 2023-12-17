package com.example.capstoneproject.ui.screen.plant_list

import android.widget.Toast
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.data.remote.response.PlantsItem
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.ViewModelFactory
import com.example.capstoneproject.ui.common.UiState
import com.example.capstoneproject.ui.screen.plant_list.component.PlantListContent
import com.example.capstoneproject.util.Constants.PLANT_LIST_TITLE

@Composable
fun PlantListScreen(
    modifier: Modifier = Modifier,
    viewModel: PlantListViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    val context = LocalContext.current
    val listState = rememberLazyListState()
    val query by viewModel.query
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

    PlantListContent(
        modifier = modifier,
        listState = listState,
        query = query,
        onQueryChange = {},
        plants = plants,
        screenTitle = PLANT_LIST_TITLE,
        navigateBack = { navController.navigateUp() },
        navigateToPlantDetailScreen = { plantId ->
            navController.navigate(Screen.PlantDetail.plantDetailRoute(plantId))
        }
    )
}