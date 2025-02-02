package com.example.kmp.articles.di

import com.example.kmp.articles.ArticleService
import com.example.kmp.articles.ArticlesUseCase
import com.example.kmp.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }

}