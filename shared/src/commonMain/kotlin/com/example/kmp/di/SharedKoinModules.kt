package com.example.kmp.di

import com.example.kmp.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)