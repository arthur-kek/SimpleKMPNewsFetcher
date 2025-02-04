package com.example.kmp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmp.db.DataBaseDriverFactory
import example.kmp.db.SimpleSharedDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DataBaseDriverFactory(androidContext()).createDriver() }
    single<SimpleSharedDataBase> { SimpleSharedDataBase(get()) }

}