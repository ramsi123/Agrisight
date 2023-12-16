package com.example.capstoneproject.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.model.Plant
import com.example.capstoneproject.data.remote.response.ArticlesItem
import com.example.capstoneproject.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plants: MutableStateFlow<List<Plant>> = MutableStateFlow(emptyList())
    val plants = _plants.asStateFlow()

    private val _articles: MutableStateFlow<UiState<List<ArticlesItem>>> = MutableStateFlow(UiState.Loading)
    val articles = _articles.asStateFlow()

    fun getPlants() {
        val data = repository.getPlants()
        val displayPlants = data.subList(0, 4)
        _plants.value = displayPlants
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