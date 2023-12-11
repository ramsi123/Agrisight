package com.example.capstoneproject.ui.screen.home

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.model.Article
import com.example.capstoneproject.data.model.Plant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plants: MutableStateFlow<List<Plant>> = MutableStateFlow(emptyList())
    val plants = _plants.asStateFlow()

    private val _articles: MutableStateFlow<List<Article>> = MutableStateFlow(emptyList())
    val articles = _articles.asStateFlow()

    fun getPlants() {
        val data = repository.getPlants()
        val displayPlants = data.subList(0, 4)
        _plants.value = displayPlants
    }

    fun getArticles() {
        val data = repository.getArticles()
        val displayArticles = data.subList(0, 5)
        _articles.value = displayArticles
    }

}