package com.example.kmp.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmp.db.DataBaseDriverFactory
import example.kmp.db.SimpleSharedDataBase
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DataBaseDriverFactory().createDriver() }
    single<SimpleSharedDataBase> { SimpleSharedDataBase(get()) }

}