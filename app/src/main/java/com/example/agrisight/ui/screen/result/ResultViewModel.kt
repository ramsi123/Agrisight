package com.example.agrisight.ui.screen.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agrisight.data.AgrisightRepository
import com.example.agrisight.data.remote.response.PlantsItem
import com.example.agrisight.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ResultViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plants: MutableStateFlow<UiState<List<PlantsItem>>> = MutableStateFlow(UiState.Loading)
    val plants = _plants.asStateFlow()

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