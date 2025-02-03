package com.example.kmp.articles

import com.example.kmp.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch((Dispatchers.IO)) {
            try {
                val articles = useCase.getArticles()
                _articlesState.emit(ArticlesState(articles))
            } catch (e: Exception) {
                e.printStackTrace()
                _articlesState.emit(ArticlesState(listOf()))
            }
        }
    }

}


