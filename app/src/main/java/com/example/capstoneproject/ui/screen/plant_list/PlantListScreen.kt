package com.example.capstoneproject.ui.screen.plant_list

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.ui.ViewModelFactory
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
    val listState = rememberLazyListState()
    val query by viewModel.query
    val plants by viewModel.plants.collectAsState()

    PlantListContent(
        modifier = modifier,
        listState = listState,
        query = query,
        onQueryChange = {
            viewModel.searchPlants(newQuery = it)
        },
        plants = plants,
        screenTitle = PLANT_LIST_TITLE,
        navigateBack = { navController.navigateUp() }
    )
}