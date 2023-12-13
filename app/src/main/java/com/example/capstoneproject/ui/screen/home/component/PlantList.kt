package com.example.capstoneproject.ui.screen.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.components.PlantItem
import com.example.capstoneproject.data.model.Plant

@Composable
fun PlantList(
    modifier: Modifier = Modifier,
    plants: List<Plant>
) {
    LazyVerticalGrid(
        modifier = modifier.heightIn(max = 125.dp),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(bottom = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(plants) { plant ->
            PlantItem(
                image = plant.image,
                name = plant.name,
                latinName = plant.latinName
            )
        }
    }
}