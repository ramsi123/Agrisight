package com.example.capstoneproject.ui.screen.plant_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.model.Plant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlantListViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plants = MutableStateFlow(
        repository.getPlants()
    )
    val plants: StateFlow<List<Plant>> = _plants

    private val _query = mutableStateOf("")
    val query: State<String> = _query

    fun searchPlants(newQuery: String) {
        _query.value = newQuery
        _plants.value = repository.searchPlants(_query.value)
    }

}