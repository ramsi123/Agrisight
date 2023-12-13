package com.example.capstoneproject.ui.screen.result

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.di.Injection
import com.example.capstoneproject.ui.ViewModelFactory
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
    val formattedScore = String.format("%.2f", score * 100).toDouble()
    val plants by viewModel.plants.collectAsState()

    // get plants recommendation
    LaunchedEffect(key1 = true) {
        viewModel.getPlants()
    }

    ResultContent(
        title = title,
        score = formattedScore,
        plants = plants,
        navigateBack = {
            navController.navigateUp()
        }
    )
}