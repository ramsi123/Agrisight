package com.example.capstoneproject.ui.screen.plant_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.remote.response.PlantItemData
import com.example.capstoneproject.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class PlantDetailViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plant: MutableStateFlow<UiState<PlantItemData>> = MutableStateFlow(UiState.Loading)
    val plant = _plant.asStateFlow()

    fun getDetailPlant(plantId: String) {
        viewModelScope.launch {
            repository.getDetailPlant(plantId)
                .catch {
                    _plant.value = UiState.Error(it.message.toString())
                }
                .collect { plant ->
                    _plant.value = UiState.Success(plant)
                }
        }
    }

}