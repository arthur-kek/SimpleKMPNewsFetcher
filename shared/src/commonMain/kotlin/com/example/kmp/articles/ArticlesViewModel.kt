package com.example.kmp.articles

import com.example.kmp.BaseViewModel
import com.example.kmp.core.logging.Logger
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

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch((Dispatchers.IO)) {
            try {
                _articlesState.emit(ArticlesState(loading = true, articles = _articlesState.value.articles))
                val articles = useCase.getArticles(forceFetch)
                Logger.log("Fetched ${articles.size} articles!")
                _articlesState.emit(ArticlesState(articles))
            } catch (e: Exception) {
                e.printStackTrace()
                _articlesState.emit(ArticlesState(listOf()))
            }
        }
    }

}


