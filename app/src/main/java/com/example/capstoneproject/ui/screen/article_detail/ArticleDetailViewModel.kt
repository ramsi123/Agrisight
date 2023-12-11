package com.example.capstoneproject.ui.screen.article_detail

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.data.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleDetailViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _article:
            MutableStateFlow<Article> = MutableStateFlow(Article("", 1, "", "", "", ""))
    val article: StateFlow<Article> = _article

    fun getArticle(articleId: String) {
        val article = repository.getArticle(articleId)
        article.forEach {
            _article.value = it
        }
    }

}