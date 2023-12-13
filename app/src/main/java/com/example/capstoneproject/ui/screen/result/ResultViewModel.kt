package com.example.capstoneproject.ui.screen.result

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.model.Plant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ResultViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plants: MutableStateFlow<List<Plant>> = MutableStateFlow(emptyList())
    val plants = _plants.asStateFlow()

    fun getPlants() {
        _plants.value = repository.getPlants()
    }

}