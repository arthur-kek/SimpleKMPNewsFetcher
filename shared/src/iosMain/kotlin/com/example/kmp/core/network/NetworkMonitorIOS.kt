package com.example.kmp.core.network

import kotlinx.cinterop.ExperimentalForeignApi

import platform.Foundation.*

class NetworkMonitorIOS : NetworkMonitor {
    @OptIn(ExperimentalForeignApi::class)
    override fun isOnline(): Boolean {
        val url = NSURL.URLWithString("https://www.apple.com")!!
        val request = NSURLRequest.requestWithURL(url)

        val response = NSURLConnection.sendSynchronousRequest(request, null, null)

        return response != null
    }
}