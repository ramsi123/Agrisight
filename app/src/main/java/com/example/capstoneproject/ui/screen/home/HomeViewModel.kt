package com.example.capstoneproject.ui.screen.home

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.model.Article
import com.example.capstoneproject.data.model.Plant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.forEach

class HomeViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _plants = MutableStateFlow(
        repository.getPlants()
    )
    val plants: StateFlow<List<Plant>> = _plants

    private val _articles = MutableStateFlow(
        repository.getAllArticles()
    )
    val articles: StateFlow<List<Article>> = _articles

    fun getPlants() {}

}