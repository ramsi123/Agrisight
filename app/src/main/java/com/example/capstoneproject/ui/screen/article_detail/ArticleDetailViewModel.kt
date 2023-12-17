package com.example.capstoneproject.ui.screen.article_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.remote.response.ArticleItem
import com.example.capstoneproject.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ArticleDetailViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _article: MutableStateFlow<UiState<ArticleItem>> = MutableStateFlow(UiState.Loading)
    val article = _article.asStateFlow()

    fun getDetailArticle(articleId: String) {
        viewModelScope.launch {
            repository.getDetailArticle(articleId)
                .catch {
                    _article.value = UiState.Error(it.message.toString())
                }
                .collect { article ->
                    _article.value = UiState.Success(article)
                }
        }
    }

}