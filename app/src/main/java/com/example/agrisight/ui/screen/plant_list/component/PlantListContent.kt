package com.example.agrisight.ui.screen.plant_list.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.agrisight.components.SearchBar
import com.example.agrisight.components.TopBar
import com.example.agrisight.data.remote.response.PlantsItem
import com.example.agrisight.util.Constants.SEARCH_BAR_PLANT_LIST

@Composable
fun PlantListContent(
    modifier: Modifier = Modifier,
    listState: LazyListState,
    query: String,
    onQueryChange: (String) -> Unit,
    plants: List<PlantsItem>,
    screenTitle: String,
    navigateBack: () -> Unit,
    navigateToPlantDetailScreen: (String) -> Unit
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
                PlantListItem(
                    plant = plant,
                    onClick = navigateToPlantDetailScreen
                )
            }
        }
    }
}