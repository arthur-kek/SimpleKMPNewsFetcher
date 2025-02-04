package com.example.kmp.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import example.kmp.db.SimpleSharedDataBase

actual class DataBaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = SimpleSharedDataBase.Schema,
            context = context,
            name = "SimpleSharedDataBase.db"
        )
}