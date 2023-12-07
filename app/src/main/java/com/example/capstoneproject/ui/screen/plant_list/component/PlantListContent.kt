package com.example.capstoneproject.ui.screen.plant_list.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.capstoneproject.components.SearchBar
import com.example.capstoneproject.components.TopBar
import com.example.capstoneproject.data.model.Plant
import com.example.capstoneproject.util.Constants.SEARCH_BAR_PLANT_LIST

@Composable
fun PlantListContent(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    query: String,
    onQueryChange: (String) -> Unit,
    plants: List<Plant>,
    screenTitle: String,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(title = screenTitle, navigateBack = { navigateBack() })
        }
    ) { innerPadding ->
        LazyColumn(
            state = listState,
            contentPadding = innerPadding
        ) {
            item {
                SearchBar(query = query, onQueryChange = onQueryChange, placeholder = SEARCH_BAR_PLANT_LIST)
            }
            items(items = plants) { plant ->
                PlantListItem(image = plant.image, name = plant.name, latinName = plant.latinName)
            }
        }
    }
}