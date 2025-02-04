package com.example.kmp.android

import android.app.Application
import com.example.kmp.android.di.databaseModule
import com.example.kmp.android.di.viewModelsModule
import com.example.kmp.core.di.coreModule
import com.example.kmp.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule + coreModule

        startKoin {
            androidContext(this@AppApplication)
            modules(modules)
        }
    }

}