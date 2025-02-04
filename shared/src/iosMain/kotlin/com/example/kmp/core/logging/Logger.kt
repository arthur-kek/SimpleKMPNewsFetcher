package com.example.kmp.core.logging

import platform.Foundation.NSLog

actual object Logger {
    actual fun log(message: String) {
        NSLog("KMPLogger: $message")
    }

    actual fun logError(error: Throwable) {
        NSLog("KMPLogger Error: ${error.message}")
    }
}