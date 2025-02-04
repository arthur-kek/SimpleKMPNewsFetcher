package com.example.kmp.core.logging

import android.util.Log

actual object Logger {
    private fun getTag(): String {
        val fullClassName = Throwable().stackTrace[2].className
        return fullClassName
            .substringAfterLast('.')
            .substringBefore('$')
    }

    private fun getSubTag(): String {
        val stackTrace = Throwable().stackTrace
        if (stackTrace.size < 3) return "Unknown"

        val element = stackTrace[2]
        val className = element.className.substringAfterLast('.').substringBefore('$')
        val methodName = element.methodName

        return "$className::$methodName"
    }

    actual fun log(message: String) {
        Log.d(getTag(), "[${getSubTag()}] $message")
    }

    actual fun logError(error: Throwable) {
        Log.e(getTag(), "Error:", error)
    }
}