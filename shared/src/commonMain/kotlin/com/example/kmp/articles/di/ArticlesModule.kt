package com.example.kmp.articles.di

import com.example.kmp.articles.ArticleService
import com.example.kmp.articles.ArticlesDataSource
import com.example.kmp.articles.ArticlesRepository
import com.example.kmp.articles.ArticlesUseCase
import com.example.kmp.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get(), get()) }

}