package com.example.kmp.di

import com.example.kmp.articles.presentation.ArticlesViewModel
import com.example.kmp.core.di.coreModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {

    val modules = sharedKoinModules + databaseModule + coreModule
    startKoin { modules(modules) }

}

class ArticlesInjector: KoinComponent {

    val articlesViewModel: ArticlesViewModel by inject()

}