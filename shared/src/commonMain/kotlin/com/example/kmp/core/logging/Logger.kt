package com.example.kmp.core.logging

expect object Logger {
    fun log(message: String)
    fun logError(error: Throwable)
}