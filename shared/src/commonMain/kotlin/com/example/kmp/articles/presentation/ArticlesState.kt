package com.example.kmp.articles.presentation

import com.example.kmp.articles.application.Article

class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)