package com.example.capstoneproject.ui.screen.article_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleListViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _articles = MutableStateFlow(
        repository.getAllArticles()
    )
    val articles: StateFlow<List<Article>> = _articles

    private val _query = mutableStateOf("")
    val query: State<String> = _query

    fun searchArticles(newQuery: String) {
        _query.value = newQuery
        _articles.value = repository.searchArticles(_query.value)
    }

}