package com.example.capstoneproject.ui.screen.article_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.remote.response.ArticlesItem
import com.example.capstoneproject.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ArticleListViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _articles: MutableStateFlow<UiState<List<ArticlesItem>>> = MutableStateFlow(UiState.Loading)
    val articles = _articles.asStateFlow()

    private val _query = mutableStateOf("")
    val query: State<String> = _query

    fun getArticles() {
        viewModelScope.launch {
            repository.getArticles()
                .catch {
                    _articles.value = UiState.Error(it.message.toString())
                }
                .collect { articles ->
                    _articles.value = UiState.Success(articles)
                }
        }
    }

}