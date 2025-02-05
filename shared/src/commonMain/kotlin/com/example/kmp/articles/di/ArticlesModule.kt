package com.example.kmp.articles.di

import com.example.kmp.articles.data.ArticleService
import com.example.kmp.articles.data.ArticlesDataSource
import com.example.kmp.articles.data.ArticlesRepository
import com.example.kmp.articles.application.ArticlesUseCase
import com.example.kmp.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get(), get()) }

}