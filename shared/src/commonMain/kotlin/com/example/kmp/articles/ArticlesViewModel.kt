package com.example.kmp.articles

import com.example.kmp.BaseViewModel
import com.example.kmp.provideHttpClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    private val useCase: ArticlesUseCase

    init {
        val httpClient = provideHttpClient()
        val service = ArticleService(httpClient)
        useCase = ArticlesUseCase(service)

        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            try {
                val articles = useCase.getArticles()
                _articlesState.emit(ArticlesState(articles))
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _articlesState.emit(ArticlesState(listOf()))
            }

        }
    }

}


