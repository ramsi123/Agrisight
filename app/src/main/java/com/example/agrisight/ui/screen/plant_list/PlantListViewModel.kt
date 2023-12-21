package com.example.agrisight.ui.screen.plant_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agrisight.data.AgrisightRepository
import com.example.agrisight.data.remote.response.PlantsItem
import com.example.agrisight.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class PlantListViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plants: MutableStateFlow<UiState<List<PlantsItem>>> = MutableStateFlow(UiState.Loading)
    val plants = _plants.asStateFlow()

    private val _query = mutableStateOf("")
    val query: State<String> = _query

    fun getPlants() {
        viewModelScope.launch {
            repository.getPlants()
                .catch {
                    _plants.value = UiState.Error(it.message.toString())
                }
                .collect { plants ->
                    _plants.value = UiState.Success(plants)
                }
        }
    }

}