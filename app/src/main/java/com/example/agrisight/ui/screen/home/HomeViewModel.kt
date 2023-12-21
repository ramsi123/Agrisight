package com.example.agrisight.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agrisight.data.AgrisightRepository
import com.example.agrisight.data.remote.response.ArticlesItem
import com.example.agrisight.data.remote.response.PlantsItem
import com.example.agrisight.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plants: MutableStateFlow<UiState<List<PlantsItem>>> = MutableStateFlow(UiState.Loading)
    val plants = _plants.asStateFlow()

    private val _articles: MutableStateFlow<UiState<List<ArticlesItem>>> = MutableStateFlow(UiState.Loading)
    val articles = _articles.asStateFlow()

    fun getPlants() {
        viewModelScope.launch {
            repository.getPlants()
                .catch {
                    _plants.value = UiState.Error(it.message.toString())
                }
                .collect { plants ->
                    val displayPlants = plants.subList(0, 4)
                    _plants.value = UiState.Success(displayPlants)
                }
        }
    }

    fun getArticles() {
        viewModelScope.launch {
            repository.getArticles()
                .catch {
                    _articles.value = UiState.Error(it.message.toString())
                }
                .collect { articles ->
                    val displayArticles = articles.subList(0, 5)
                    _articles.value = UiState.Success(displayArticles)
                }
        }
    }

}