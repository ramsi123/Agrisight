package com.example.agrisight.ui.screen.plant_detail

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.agrisight.ui.ViewModelFactory
import com.example.agrisight.data.remote.response.PlantItemData
import com.example.agrisight.di.Injection
import com.example.agrisight.ui.common.UiState
import com.example.agrisight.ui.screen.plant_detail.component.PlantDetailContent

@Composable
fun PlantDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: PlantDetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    navController: NavHostController,
    plantId: String
) {
    val context = LocalContext.current
    var plant = PlantItemData(nama = "", namaLatin = "", id = "", deskripsi = "", gambar = "")

    // get detail plant data
    viewModel.plant.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getDetailPlant(plantId)
            }
            is UiState.Success -> {
                plant = uiState.data
            }
            is UiState.Error -> {
                Toast.makeText(context, uiState.errorMessage, Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    PlantDetailContent(
        modifier = modifier,
        plant = plant,
        navigateBack = {
            navController.navigateUp()
        }
    )
}