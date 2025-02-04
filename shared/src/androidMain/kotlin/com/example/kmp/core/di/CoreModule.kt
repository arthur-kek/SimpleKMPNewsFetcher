package com.example.kmp.core.di

import com.example.kmp.core.network.NetworkMonitor
import com.example.kmp.core.network.NetworkMonitorAndroid
import org.koin.dsl.module

val coreModule = module {

    single<NetworkMonitor> { NetworkMonitorAndroid(get()) }

}